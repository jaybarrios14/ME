package todolist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToDoList extends JFrame {
    private JTextField taskInput;
    private JButton addButton;
    private JButton deleteButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private ArrayList<String> tasks;

 public ToDoList() {
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        
        // Setup GUI components
        taskInput = new JTextField(20);
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");
        taskList = new JList<>(listModel);
        
        // Add components to the frame
        setLayout(new java.awt.FlowLayout());
        add(taskInput);
        add(addButton);
        add(deleteButton);
        add(new JScrollPane(taskList));

        // Add button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (!task.isEmpty()) {
                    tasks.add(task);
                    listModel.addElement(task);
                    taskInput.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a task.");
                }
            }
        });

        // Delete button action
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                    tasks.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a task to delete.");
                }
            }
        });

        // Frame settings
        setTitle("To-Do List");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoList().setVisible(true);
        });
    }
}
