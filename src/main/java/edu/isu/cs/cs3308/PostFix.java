package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.LinkedStack;

/**
 * Postfix expression evaluator.
 *
 * @author Isaac Griffith
 * @author Dylan Lasher
 */
public class PostFix
{

    /**
     * Evaluates the provided postfix expression and returns the answer. If the
     * provided string is null, empty, or only contains whitespace then return
     * 0;
     *
     * @param infix A string representing an postfix notation expression where
     * each item is separated by a space.
     * @return value of the postfix express or 0 if the postfix expression is null,
     * empty, or contains only whitespace.
     */
    public static int evalPostFix(String infix)
    {
        // check if string is null/empty
        if (infix == null || infix.trim().isEmpty())
        {
            return 0;
        }
        // else string is acceptable
        else {
            // stack to store all separated string values
            LinkedStack<String> valueList = new LinkedStack<>();

            for (String portion: infix.split(" "))
            {
                valueList.push(portion);
            }

            // reverse stack
            valueList.reverse();

            // counter for numbers / symbols in sequence
            int countNum = 0;
            int countSym = 0;

            // bool - if all values needed are ready for calculation
            boolean calcNow = false;
            // int value of output
            int postNum = -1;

            // temp values for each calculation
            int tempNum1 = -1;
            int tempNum2 = -1;
            String tempSym1 = "";
            String tempSym2 = "";

            // bool to determine if all the calculations are done
            boolean finished = false;

            // iterate through stack for calculations
            while (valueList.size() >= 0 && finished == false)
            {
                // check values needed
                String tempPeek = "";
                int tempInt = -1;

                // Check if we get value from stack
                if (valueList.size() > 0 && calcNow == false)
                {
                    // temp peek of next value
                    tempPeek = valueList.peek();

                    if (	!tempPeek.equals("+") &&
                            !tempPeek.equals("-") &&
                            !tempPeek.equals("*") &&
                            !tempPeek.equals("/")) {
                        tempInt = Integer.parseInt(tempPeek);
                    }

                    // assigns values based on count
                    if (tempInt > -1)
                    {
                        if (countNum == 0)
                        {
                            tempNum1 = Integer.parseInt(valueList.pop());
                        } else if (countNum == 1)
                        {
                            tempNum2 = Integer.parseInt(valueList.pop());
                        }
                    } else {
                        if (countSym == 0)
                        {
                            tempSym1 = valueList.pop();
                        } else if (countSym == 1)
                        {
                            tempSym2 = valueList.pop();
                        }
                    }
                }

                // // Checks if there is invalid set of arguments:
                // check if first value is number otherwise throw exception
                if (	postNum != -1 &&
                        countNum == 0 &&
                        (tempPeek.equals("+") ||
                                tempPeek.equals("-") ||
                                tempPeek.equals("*") ||
                                tempPeek.equals("/"))) {
                    throw new IllegalArgumentException("Symbol instead of expected number.");
                }
                //too many numbers throw exception
                else if (countNum > 2) {
                    throw new IllegalArgumentException("Too many numbers.");
                }
                //too many symbols throw exception
                else if (countSym > 2) {
                    throw new IllegalArgumentException("Too many symbols.");
                }
                // // Checks if calculation is ready:
                else if ((postNum == -1 && countNum == 2 && countSym == 1 && tempInt != -1) ||
                        (postNum != -1 && countNum == 2 && countSym == 2 && tempInt != -1) ||
                        (postNum != -1 && countNum == 2 && countSym == 1 && tempInt != -1) ||
                        (postNum != -1 && countNum == 1 && countSym == 1 && tempInt == -1)) {
                    calcNow = true;
                }
                // else incrementing
                else {
                    if (tempInt > -1)
                    {
                        countNum++;
                    } else {
                        countSym++;
                    }
                }
                // // Calculate needed post number
                if (calcNow == true)
                {
                    int comboNum = -1;

                    if (countNum == 2)
                    {
                        if (tempSym1.equals("+"))
                        {
                            comboNum = (tempNum1 + tempNum2);
                        } else if (tempSym1.equals("-"))
                        {
                            comboNum = (tempNum1 - tempNum2);
                        } else if (tempSym1.equals("*"))
                        {
                            comboNum = (tempNum1 * tempNum2);
                        } else if (tempSym1.equals("/"))
                        {
                            comboNum = (tempNum1 / tempNum2);
                        }

                        if (postNum == -1)
                        {
                            postNum = comboNum;
                        } else if (countSym == 2)
                        {
                            if (tempSym2.equals("+"))
                            {
                                postNum += comboNum;
                            } else if (tempSym2.equals("-"))
                            {
                                postNum -= comboNum;
                            } else if (tempSym2.equals("*"))
                            {
                                postNum *= comboNum;
                            } else if (tempSym2.equals("/"))
                            {
                                postNum /= comboNum;
                            }
                        }
                    }
                    else if (countNum == 1)
                    {
                        if (tempSym1.equals("+"))
                        {
                            postNum += tempNum1;
                        } else if (tempSym1.equals("-"))
                        {
                            postNum -= tempNum1;
                        } else if (tempSym1.equals("*"))
                        {
                            postNum *= tempNum1;
                        } else if (tempSym1.equals("/"))
                        {
                            postNum /= tempNum1;
                        }
                    }

                    // reset counter values
                    countNum = 0;
                    countSym = 0;
                    tempNum1 = -1;
                    tempNum2 = -1;
                    tempSym1 = "";
                    tempSym2 = "";
                }

                // Check if finished

                if (valueList.size() == 0 && calcNow == true)
                {
                    finished = true;
                }
                else {
                    calcNow = false;
                }
            }

            return postNum;
        }
    }
}