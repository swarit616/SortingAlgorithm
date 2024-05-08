# SortingAlgorithm
This Java program, "SortingVisualizer," creates a graphical user interface (GUI) for sorting arrays of integers using various sorting algorithms such as Bubble Sort, Selection Sort, and Insertion Sort. Let's break down the different components and functionalities of the code:

1. Import Statements:
The program imports necessary Java libraries for creating GUI components and handling events.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

2. SortingVisualizer Class:
This class extends JFrame to create the main window for the application.
Constructor (SortingVisualizer()):
Sets up the GUI components like labels, text fields, buttons, and combo box.
Initializes the layout of the frame.
SubmitButtonListener Class:
This inner class implements ActionListener to handle events when the submit button is clicked.
It retrieves the input from the text field, converts it into an array of integers, selects the sorting algorithm based on the combo box selection, sorts the array, and displays the sorted result in the result text field.
main(String[] args) Method:
This method is the entry point of the program.
It creates an instance of SortingVisualizer and makes it visible on the Swing event dispatch thread.

3. SortingAlgorithm Interface:
This interface defines a method sort(int[] array) that must be implemented by any class representing a sorting algorithm.

4. Sorting Algorithm Classes:
BubbleSort, SelectionSort, and InsertionSort are inner classes of SortingVisualizer that implement the SortingAlgorithm interface.
Each class provides a method to sort an array of integers using its respective sorting algorithm (Bubble Sort, Selection Sort, or Insertion Sort).

How it Works:
Users input numbers separated by commas into the text field.
They select a sorting algorithm from the combo box.
Upon clicking the submit button, the program reads the input, converts it into an array of integers, selects the appropriate sorting algorithm, sorts the array using that algorithm, and displays the sorted result in the GUI.

Technologies Used:
Java Swing: Used to create the graphical user interface.
Event Handling: ActionListener interface used to handle button click events.
Sorting Algorithms: Implemented using Bubble Sort, Selection Sort, and Insertion Sort.
Multithreading: SwingUtilities.invokeLater() used to ensure GUI is created and updated on the Event Dispatch Thread.
This program provides a simple yet effective way to visualize and compare different sorting algorithms in action.


