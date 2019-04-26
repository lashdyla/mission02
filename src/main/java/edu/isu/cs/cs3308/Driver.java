package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.Stack;
import edu.isu.cs.cs3308.structures.impl.LinkedStack;

/**
 * Stack Applications
 * @author Isaac Griffith
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 10; i++)
            stack.push(i);

        System.out.println("Stack It");
        stack.printStack();

        stack.reverse();

        System.out.println();
        System.out.println("Reverse It!");
        stack.printStack();

        System.out.println();
        System.out.println("Evaluate It:");
        System.out.print("5 2 + 8 3 - * 4 / = ");
        System.out.println(PostFix.evalPostFix("5 2 + 8 3 - * 4 /"));
        System.out.print("40 5 + 90 3 / - 14 * = ");
        System.out.println(PostFix.evalPostFix("40 5 + 90 3 / - 14 *"));
    }

}
