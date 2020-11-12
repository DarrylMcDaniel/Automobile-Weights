/* File:    Project2.Java
   Author:  Darryl McDaniel
   Date:    September 15th, 2020
   Purpose: This program computes the sales tax for a collection of automobiles of different types.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Project2 extends JFrame {
    private static int MAX_IN_LIST = 5;
    //labels for the frame
    JLabel makeAndModelLbl = new JLabel("Make and Model");
    JLabel salesPriceLbl = new JLabel("Sales Price");
    JLabel mpgLbl = new JLabel("Miles per Gallon");
    JLabel weightLbl = new JLabel("Weight in Pounds");
    //textfields for the frame
    JTextField makeAndModelTxt = new JTextField(10);
    JTextField salesPriceTxt = new JTextField(10);
    JTextField mpgTxt = new JTextField(20);
    JTextField weightTxt = new JTextField(20);
    JTextField salesTaxField = new JTextField(20);
    //buttons and radio buttons for frame
    JRadioButton rbtnHybrid = new JRadioButton("Hybrid");
    JRadioButton rbtnElectric = new JRadioButton("Electric");
    JRadioButton rbtnOther = new JRadioButton("Other");
    JButton btnComputeSalesTax = new JButton("Compute Sales Tax");
    JButton btnClearField = new JButton("Clear Fields");
    JButton btnDisplayReport = new JButton("Display Report");


    public Project2(){

        JFrame projectFrame = new JFrame();
        JPanel labelPane = new JPanel();

        //adding of labels and textfields in the north of the frame
        labelPane.setLayout(new GridLayout(2,2));
        labelPane.add(makeAndModelLbl);
        labelPane.add(makeAndModelTxt);
        labelPane.add(salesPriceLbl);
        labelPane.add(salesPriceTxt);

        add("North", labelPane);

        //creation of the middle panel where the radio buttons and labels and textfields are encased
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3,3));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Automobile Type"));
        centerPanel.add(rbtnHybrid);
        centerPanel.add(mpgLbl);
        centerPanel.add(mpgTxt);
        centerPanel.add(rbtnElectric);
        centerPanel.add(weightLbl);
        centerPanel.add(weightTxt);
        centerPanel.add(rbtnOther);
        add("Center", centerPanel);

        //adding buttons and sales tax textfield in the south of the frame
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,2));
        p.add(btnComputeSalesTax);
        salesTaxField.setEditable(false);
        p.add(salesTaxField);
        p.add(btnClearField);
        p.add(btnDisplayReport);
        add("South", p);


        ArrayList<Automobile> list = new ArrayList<>();

        //addressing all of the buttons listener actions
        rbtnHybrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbtnHybrid.setSelected(true);
                rbtnElectric.setSelected(false);
                rbtnOther.setSelected(false);
            }
        });
        rbtnElectric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbtnHybrid.setSelected(false);
                rbtnElectric.setSelected(true);
                rbtnOther.setSelected(false);
            }
        });
        rbtnOther.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rbtnHybrid.setSelected(false);
                rbtnElectric.setSelected(false);
                rbtnOther.setSelected(true);
            }
        });
        btnComputeSalesTax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                String makeAndModelInput = makeAndModelTxt.getText();
                int salesPriceInput = Integer.parseInt(salesPriceTxt.getText());
                //if statements that determine which type of Automobile object is created based on the radio
                //    button selection
                if (rbtnOther.isSelected()) {
                    Automobile car = new Automobile(makeAndModelInput, salesPriceInput);
                    salesTaxField.setText(" " + car.salesTax(salesPriceInput));
                    list.add(car);
                    if (list.size() > MAX_IN_LIST){
                        list.remove(0);
                    }
                }
                if (rbtnElectric.isSelected()) {
                    int weightInPounds = Integer.parseInt(weightTxt.getText());
                    Automobile car = new Automobile.Electric(makeAndModelInput, salesPriceInput, weightInPounds);
                    salesTaxField.setText("" + car.salesTax(salesPriceInput));
                    list.add(car);
                    if (list.size() > MAX_IN_LIST){
                        list.remove(0);
                    }
                }
                if (rbtnHybrid.isSelected()) {
                    int mpgInput = Integer.parseInt(mpgTxt.getText());
                    Automobile car = new Automobile.Hybrid(makeAndModelInput, salesPriceInput, mpgInput);
                    salesTaxField.setText("" + car.salesTax(salesPriceInput));
                    list.add(car);
                    if (list.size() > MAX_IN_LIST){
                        list.remove(0);
                    }
                }
            }catch (Exception er){
                JOptionPane.showMessageDialog(projectFrame, "Invalid Entry");
            }
            }
        });
        btnClearField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeAndModelTxt.setText("");
                salesPriceTxt.setText("");
                mpgTxt.setText("");
                weightTxt.setText("");
            }
        });
        btnDisplayReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    System.out.println(list);
            }
        });
    }
    //main where the frame is actually created and runs
    public static void main(String[] args) {
        Project2 prj2 = new Project2();
        prj2. setTitle("Automobile Sales Tax Calculator");
        prj2. setSize(400,200);
        prj2. setLocationRelativeTo(null);
        prj2. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prj2. setVisible(true);
    }
}
