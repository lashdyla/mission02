# CS 3308 Mission 02

## Due: Sunday January 27, 2019 @ 2300

## Purpose
* Gain experience in implementing DoublyLinkedLists
* Gain experience in implementing a Stack as a wrapped list
* Learn about postfix expressions

## Problem Statement
Implement a `Stack` ADT using a doubly-linked list, call this class a `LinkedStack`. Included in this Stack ADT are three non-wrapper methods. Futherore, design and implement an approach using a stack to evaluate expressions written in the postfix format.

**_Postfix notation_** is an unambiguous way of writing an arithmetic expression without parentheses. It is defined so fthat if `"(exp1) op (exp2)"` is a normal fully parenthesized expression whose operation is **op**, the postfix version of this is `"pexp1 pexp2 op"`, where `pexp1` is the postfix version of `exp1` and `pexp2` is the postfix version of `exp2`. The postfix version of a single number or variable is just that number or variable. So, for example, the postfix version of `"((5 + 2) * (9 - 3)) / 4"` is "5 2 + 0 3 - * 4 /". We can easily use stacks and their basic operations to evaluate such postfix expressions.

## Assignment
1. Fork this repository
2. Build a generic `DoublyLinkedList` class which implements the `List<E>` interface (from package `edu.isu.cs.cs3308.structures`), in a class called `DoublyLinkedList<E>` in the package named `edu.isu.cs.cs3308.structures.impl`. (Note you may need to create this package).
3. Create a class called `LinkedStack` in the package `edu.isu.cs.cs3308.structures.impl` which implements the `edu.isu.cs.cs3308.structures.Stack` ADT
4. Use the DoublyLinkedList as the basis for the `Stack`
5. Write the standard stack methods (`push`, `pop`, `peek`, `size`, `isEmpty`, and `printStack`) as a wrapper around the List ADT methods. Look at the `edu.isu.cs.cs3308.structures.Stack` interface to see the method headers and documentation. **Be sure to read this documentation carefully**
6. Verify that your stack operations work correcly using the `Driver` class and the associated unit tests for both the `DoublyLinkedList` and the `LinkedStack` classes.
7. You will also need to implement three additional methods in the `LinkedStack` class beyond the basic ones:
    * `public void transfer(Stack<E> to)` -- This method transfers all elements from the stack it is called on onto the provided stack `to`, so that the element that starts at the top of the called on stack is the first to be inserted onto `to`, and the element at the bottom of the called on stack ends up on the top of `to`. **Note: Although you have access to the underlying list, you may only use the methods defined by the Stack ADT to complete this task. Also make sure you are not attempting to put data onto a null stack**
    * `public void reverse()` -- This method reverses the contents of the stack on which the method is called. The implementation of this method requires the use of two temporary stacks and the transfer method. **Note: Although you have access to the underlying list, you may only use the methods defined by the Stack ADT to complete this task.**
    * `public void merge(Stack<E> from)` -- This method takes the contents of the provided stack, `from`, and adds it to the bottom of the stack the method is called on. Note that this method should not destroy (leave empty) the provided stack. **Note: Although you have access to the underlying list, you may only use the methods defined by the Stack ADT to complete this task. Also be sure that you are not attempting to move data from a null stack.**
8. Be sure to test all of your implementations using the provided unit tests and the `Driver` class.
9. Implement a postfix expression evaluator in the class `PostFix` in the method with header `public static String evalPostFix(String infix).` The goal is to use a stack to build up the answer until a single value remains.
10. The postfix evaluation method should throw an `IllegalArgumentException` if it detects that there are too few expressions for a given operator.

## Submission
When you have completed the assignment (all tests pass) or it is reaching midnight of the due date, make sure you have completed the following:
1. Committed all changes to your repo
2. Pushed your changes to GitHub
3. Tagged your repo as "COMPLETE"
4. Pushed the "COMPLETE" tag to GitHub
5. Submitted your repository URL to Moodle in the Mission 01 submission section.

## Grading -- 50 Points
* Evaluate PostFix Expressions Correctly - 10 Points
* LinkedStack Correctly Implemented - 15 points
* DoublyLinkedList Correctly Implemented - 15 Points
* Code Style and Documentation - 10 points

## Hints
* This is a fairly large Mission, I would suggest starting early to ensure you complete the assignment on time.
* The basic implementation of a DoublyLinkedList is depicted in the book, I would consult this prior to starting.
* Each of the Stack methods are no longer than 12 lines each.   So they should not be too terribly difficult. The key is to draw up a plan of attack prior to coding (remeber the 4 steps: 1. Understand the problem. 2. Design a solution. 3. Implement the soution. 4. Test the solution.). If you ask me for help and cannot produce a plan, then I will simply ask you to start with that.
* The post fix evaluation method takes in a String as a parameter. We can assume that if the string is not empy, null, or only contains whitespace, then each of the numbers/operators are separated by a single space. We can apply the `String` method `split(String)` which returns an array of string objects. The array is coposed of the orignal string chopped up into smaller pieces that were originally separated by the string parameter to split. Using this knowledge we can then check if the item is an operator or anything else (i.e., a number) whcih can then be extracted using `Integer.parseInt(Stirng)`.
* You can test if a Stirng only contains whitespace as follows: let `x` be a string, then `x.trim().isEmpty()` returns true if the string only contains whitespace.
