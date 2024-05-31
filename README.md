# balanced-symbol-checker

Balanced Symbol Checker
Overview
This project aims to solve the problem of checking program source code for unbalanced symbols such as { without a matching }. We will implement a stack-based approach to track and verify the balance of symbols in the source code. Additionally, we will ignore symbols inside comments, string literals, and character literals. We will create a generic stack class backed by both an array and a singly-linked list to determine which implementation is more efficient.

Requirements

Part 1: SinglyLinkedList.java
Create a generic class SinglyLinkedList that implements a provided List interface using a singly-linked list.

Implementation Guidelines:

Constructor:

public SinglyLinkedList()

This is the default constructor.

0-based indexing:

The first list item is at index 0.
Big-O behavior:

Ensure the methods adhere to the Big-O behavior specified in the List interface.

Part 2: LinkedListStack.java
Create a generic stack class LinkedListStack that implements a provided Stack interface. This stack should be backed by the SinglyLinkedList class.


Constructor:
public LinkedListStack()

This is the default constructor.

I also ensure the work in each method is O(1).

Part 3: BalancedSymbolChecker.java
The BalancedSymbolChecker class will use the stack to determine if an input file contains unbalanced symbols.

Instantiate the Stack:

Use the stack implementation determined to be the most efficient (from Part 2).
Check for Unbalanced Symbols:

Use the stack to track and verify the balance of symbols in the file.
Implement the provided error message methods for compatibility with the auto-grader.

Testing

Create JUnit 5 test classes to ensure the functionality of each method. Organize tests to cover various cases, including edge cases and typical usage scenarios.
