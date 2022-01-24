package gui;

import calculator.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GPACalculator {
    final double AP = 1.15;
    final double Honors = 1.1;
    final double CollegeOthers = 1.0;
    final double Elective = 1.0;
    private Map<String, Double> Collection;
    private ArrayList<Double> allGrades;
    
    private JPanel root;
    private JButton getGPAButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JTextArea textArea1;

    public GPACalculator() {
        this.allGrades = new ArrayList<>();
        this.Collection = new HashMap<>();
        this.Collection.put("A", 4.00);
        this.Collection.put("A-",3.67);
        this.Collection.put("B+",3.33);
        this.Collection.put("B",3.00);
        this.Collection.put("B-",2.67);
        this.Collection.put("C+",2.33);
        this.Collection.put("C",2.00);
        this.Collection.put("C-",1.67);
        this.Collection.put("D+",1.33);
        this.Collection.put("D",1.00);
        this.Collection.put("F",0.0);
        textArea1.setEditable(false);
        getGPAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isValid()){
                    JOptionPane.showMessageDialog(root, "In valid grades, please check and enter again!");
                    return;
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GPACalculator");
        frame.setContentPane(new GPACalculator().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,300);
        frame.pack();
        frame.setVisible(true);
    }

    private boolean isValid(){
        boolean v = true;
        if(!Collection.containsKey(textField1.getText())){
            System.out.println(textField1.getText());
            System.out.println(Collection.containsKey(textField1.getText()));
            v = false;
        }
        if(!Collection.containsKey(textField2.getText())){
            v = false;
        }
        if(!Collection.containsKey(textField3.getText())){
            v = false;
        }
        if(!Collection.containsKey(textField4.getText())){
            v = false;
        }
        return v;
    }
}
