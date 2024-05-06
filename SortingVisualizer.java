import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingVisualizer extends JFrame {
    private JPanel controlPanel;
    private JPanel sortPanel;
    private JLabel inputLabel;
    private JTextField inputField;
    private JButton submitButton;
    private JLabel resultLabel;
    private JTextField resultField;
    private JComboBox<String> algorithmComboBox;

    private int[] arrayToSort;

    public SortingVisualizer() {
        setTitle("Sorting Visualizer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        inputLabel = new JLabel("Enter numbers separated by commas:");
        inputField = new JTextField(20);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());

        resultLabel = new JLabel("Sorted Result:");
        resultField = new JTextField(20);
        resultField.setEditable(false);

        algorithmComboBox = new JComboBox<>(new String[] { "Bubble Sort", "Selection Sort", "Insertion Sort" });
        algorithmComboBox.setSelectedIndex(0);

        controlPanel.add(inputLabel);
        controlPanel.add(inputField);
        controlPanel.add(submitButton);
        controlPanel.add(resultLabel);
        controlPanel.add(resultField);
        controlPanel.add(algorithmComboBox);

        sortPanel = new JPanel();
        sortPanel.setLayout(new GridLayout(1, 1));

        add(controlPanel, BorderLayout.NORTH);
        add(sortPanel, BorderLayout.CENTER);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText();
            String[] numbers = input.split(",");
            arrayToSort = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arrayToSort[i] = Integer.parseInt(numbers[i].trim());
            }

            SortingAlgorithm sortingAlgorithm;
            switch (algorithmComboBox.getSelectedIndex()) {
                case 0:
                    sortingAlgorithm = new BubbleSort();
                    break;
                case 1:
                    sortingAlgorithm = new SelectionSort();
                    break;
                case 2:
                    sortingAlgorithm = new InsertionSort();
                    break;
                default:
                    sortingAlgorithm = new BubbleSort();
            }

            sortingAlgorithm.sort(arrayToSort);

            StringBuilder sortedResult = new StringBuilder();
            for (int num : arrayToSort) {
                sortedResult.append(num).append(", ");
            }
            resultField.setText(sortedResult.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SortingVisualizer visualizer = new SortingVisualizer();
                visualizer.setVisible(true);
            }
        });
    }

    public interface SortingAlgorithm {
        void sort(int[] array);
    }

    public class BubbleSort implements SortingAlgorithm {
        public void sort(int[] array) {
            int n = array.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    public class SelectionSort implements SortingAlgorithm {
        public void sort(int[] array) {
            int n = array.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    public class InsertionSort implements SortingAlgorithm {
        public void sort(int[] array) {
            int n = array.length;
            for (int i = 1; i < n; ++i) {
                int key = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }
        }
    }
}
