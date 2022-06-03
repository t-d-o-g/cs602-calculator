import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class Main extends javax.swing.JFrame {

    private JTextField jTextFieldA;
    private JTextField jTextFieldB;
    private JTextField jTextFieldResult;
    private JLabel jLabelEquals;
    private JRadioButton jRadioButtonAdd;
    private JRadioButton jRadioButtonSubtract;
    private JRadioButton jRadioButtonMultiply;
    private JRadioButton jRadioButtonDivide;
    private ButtonGroup buttonGroup;
    private Color backgroundColor;


    /**
     * Auto-generated main method to display this JFrame
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main inst = new Main();
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    public Main() {
        super();
        initGUI();
    }

    private void initGUI() {
        backgroundColor = new Color(200, 200, 200);
        jLabelEquals = new JLabel("=");
        jLabelEquals.setBounds(265, 100, 35, 30);
        getContentPane().add(jLabelEquals);
        jTextFieldResult = new JTextField();
        jTextFieldResult.setBounds(295, 100, 160, 40);
        getContentPane().add(jTextFieldResult);
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);
            getContentPane().setBackground(backgroundColor);
            {
                jRadioButtonAdd = new JRadioButton();
                getContentPane().add(jRadioButtonAdd);
                jRadioButtonAdd.setText("+");
                jRadioButtonAdd.setBounds(120, 65, 35, 35);
                jRadioButtonAdd.setBackground(backgroundColor);
                getButtonGroup().add(jRadioButtonAdd);
                jRadioButtonAdd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jRadioButtonAddActionPerformed(evt);
                    }
                });
            }
            {
                jRadioButtonSubtract = new JRadioButton();
                getContentPane().add(jRadioButtonSubtract);
                jRadioButtonSubtract.setText("-");
                jRadioButtonSubtract.setBounds(120, 100, 35, 35);
                jRadioButtonSubtract.setBackground(backgroundColor);
                getButtonGroup().add(jRadioButtonSubtract);
                jRadioButtonSubtract.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jRadioButtonSubtractActionPerformed(evt);
                    }
                });
            }
            {
                jRadioButtonMultiply = new JRadioButton();
                getContentPane().add(jRadioButtonMultiply);
                jRadioButtonMultiply.setText("*");
                jRadioButtonMultiply.setBounds(120, 135, 35, 35);
                jRadioButtonMultiply.setBackground(backgroundColor);
                getButtonGroup().add(jRadioButtonMultiply);
                jRadioButtonMultiply.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jRadioButtonMultiplyActionPerformed(evt);
                    }
                });
            }
            {
                jRadioButtonDivide = new JRadioButton();
                getContentPane().add(jRadioButtonDivide);
                jRadioButtonDivide.setText("/");
                jRadioButtonDivide.setBounds(120, 170, 35, 35);
                jRadioButtonDivide.setBackground(backgroundColor);
                getButtonGroup().add(jRadioButtonDivide);
                jRadioButtonDivide.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jRadioButtonDivideActionPerformed(evt);
                    }
                });
            }
            {
                jTextFieldA = new JTextField();
                jTextFieldA.setBounds(25, 100, 80, 40);
                getContentPane().add(jTextFieldA);
            }
            {
                jTextFieldB = new JTextField();
                jTextFieldB.setBounds(170, 100, 80, 40);
                getContentPane().add(jTextFieldB);
            }
            pack();
            setSize(475, 300);
        } catch (Exception e) {
            //add your error handling code here
        }
    }

    private ButtonGroup getButtonGroup() {
        if(buttonGroup == null) {
            buttonGroup = new ButtonGroup();
        }
        return buttonGroup;
    }

    private void jRadioButtonAddActionPerformed(ActionEvent evt) {
        System.out.println("jRadioButtonAdd.actionPerformed, event="+evt);
        if (jTextFieldA.getText().isEmpty() || jTextFieldB.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: No input in one or both text fields.");
            return;
        }
        try {
            String a = jTextFieldA.getText();
            String b = jTextFieldB.getText();
            int result = Integer.parseInt(a) + Integer.parseInt(b);
            jTextFieldResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Non integer inputs on one or both text fields.");
        }
    }

    private void jRadioButtonSubtractActionPerformed(ActionEvent evt) {
        System.out.println("jRadioButtonSubtract.actionPerformed, event="+evt);
        if (jTextFieldA.getText().isEmpty() || jTextFieldB.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: No input in one or both text fields.");
            return;
        }
        try {
            String a = jTextFieldA.getText();
            String b = jTextFieldB.getText();
            int result = Integer.parseInt(a) - Integer.parseInt(b);
            jTextFieldResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Non integer inputs on one or both text fields.");
        }
}

    private void jRadioButtonMultiplyActionPerformed(ActionEvent evt) {
        System.out.println("jRadioButtonMultiply.actionPerformed, event="+evt);
        if (jTextFieldA.getText().isEmpty() || jTextFieldB.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: No input in one or both text fields.");
            return;
        }
        try {
            String a = jTextFieldA.getText();
            String b = jTextFieldB.getText();
            int result = Integer.parseInt(a) * Integer.parseInt(b);
            jTextFieldResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Non integer inputs on one or both text fields.");
        }
}

    private void jRadioButtonDivideActionPerformed(ActionEvent evt) {
        System.out.println("jRadioButtonDivide.actionPerformed, event="+evt);
        if (jTextFieldA.getText().isEmpty() || jTextFieldB.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: No input in one or both text fields.");
            return;
        }
        try {
            String a = jTextFieldA.getText();
            String b = jTextFieldB.getText();
            if (!b.equals("0")) {
                float floatResult = (float) Integer.parseInt(a) / Integer.parseInt(b);
                jTextFieldResult.setText(String.valueOf(floatResult));
            } else {
                JOptionPane.showMessageDialog(null, "Division by zero.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Non integer inputs on one or both text fields.");
        }
    }
}