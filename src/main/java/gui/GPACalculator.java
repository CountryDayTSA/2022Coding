package gui;

import calculator.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GPACalculator {
    final double AP = 1.15;
    final double Honors = 1.1;
    final double CollegeOthers = 1.0;
    final double Elective = 1.0;
    private Map<String, Double> Collection;
    private Map<Integer, Double> Course;
    private Map<Integer, Double> Credits;
    
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
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;

    public GPACalculator() {
        initMaps();
        textArea1.setEditable(false);
        getGPAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isValid()){
                    JOptionPane.showMessageDialog(root, "In valid grade(must be uppercase e.p.: B+) or didn't select a course type or credits. Please check and enter again!");
                    return;
                }

                double result = calculateResult();
                result = round(result,2);
                textArea1.setText(String.valueOf(result));
                //result text Area
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GPACalculator - LCDS TSA");
        frame.setContentPane(new GPACalculator().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,300);
        frame.pack();
        frame.setVisible(true);
    }

    private boolean isValid(){
        boolean v = true;

        if(!Collection.containsKey(textField1.getText())){
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
        if(!Course.containsKey(comboBox1.getSelectedIndex())){
            v = false;
        }
        if(!Course.containsKey(comboBox2.getSelectedIndex())){
            v = false;
        }
        if(!Course.containsKey(comboBox3.getSelectedIndex())){
            v = false;
        }
        if(!Course.containsKey(comboBox4.getSelectedIndex())){
            v = false;
        }
        if(!Credits.containsKey(comboBox5.getSelectedIndex())){
            v = false;
        }
        if(!Credits.containsKey(comboBox6.getSelectedIndex())){
            v = false;
        }
        if(!Credits.containsKey(comboBox7.getSelectedIndex())){
            v = false;
        }
        if(!Credits.containsKey(comboBox8.getSelectedIndex())){
            v = false;
        }
        return v;
    }
    private void initMaps(){
        this.Collection = new HashMap<>();
        this.Course = new HashMap<>();
        this.Credits = new HashMap<>();

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

        this.Course.put(3,1.15);
        this.Course.put(2, 1.1);
        this.Course.put(1,1.0);
        this.Course.put(0,1.0);

        this.Credits.put(0, 1.0);
        this.Credits.put(1, 1.5);
        this.Credits.put(2, 2.0);
        this.Credits.put(3, 2.5);
        this.Credits.put(4, 3.0);
        this.Credits.put(5, 3.5);
        this.Credits.put(6, 4.0);
        this.Credits.put(7, 4.5);
        this.Credits.put(8, 5.0);
        this.Credits.put(9, 5.5);
    }

    private double calculateResult(){
        double result = 0;
        double credits = 0;
        result += Collection.get(textField1.getText()) * Course.get(comboBox1.getSelectedIndex()) * Credits.get(comboBox5.getSelectedIndex());
        result += Collection.get(textField2.getText()) * Course.get(comboBox2.getSelectedIndex()) * Credits.get(comboBox6.getSelectedIndex());
        result += Collection.get(textField3.getText()) * Course.get(comboBox3.getSelectedIndex()) * Credits.get(comboBox7.getSelectedIndex());
        result += Collection.get(textField4.getText()) * Course.get(comboBox4.getSelectedIndex()) * Credits.get(comboBox8.getSelectedIndex());
        credits += Credits.get(comboBox5.getSelectedIndex());
        credits += Credits.get(comboBox6.getSelectedIndex());
        credits += Credits.get(comboBox7.getSelectedIndex());
        credits += Credits.get(comboBox8.getSelectedIndex());
        return result/credits;
    }
    private void reset(){

    }
    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
