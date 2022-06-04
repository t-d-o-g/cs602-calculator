import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
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
    private JLabel jLabelTitle;
    private JRadioButton jRadioButtonAdd;
    private JRadioButton jRadioButtonSubtract;
    private JRadioButton jRadioButtonMultiply;
    private JRadioButton jRadioButtonDivide;
    private ButtonGroup buttonGroup;
    private Color backgroundColor;
    private Font font;
    private enum Operator {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    };


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
        font = new Font("Monospaced", Font.BOLD, 18);
        jLabelTitle = new JLabel("Calculator");
        jLabelTitle.setBounds(25, 25, 160, 25);
        jLabelTitle.setFont(font);
        getContentPane().add(jLabelTitle);
        jLabelEquals = new JLabel("=");
        jLabelEquals.setFont(font);
        jLabelEquals.setBounds(360, 100, 35, 30);
        getContentPane().add(jLabelEquals);
        jTextFieldResult = new JTextField();
        jTextFieldResult.setBounds(400, 100, 215, 40);
        jTextFieldResult.setFont(font);
        getContentPane().add(jTextFieldResult);
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);
            getContentPane().setBackground(backgroundColor);
            {
                jRadioButtonAdd = new JRadioButton();
                getContentPane().add(jRadioButtonAdd);
                jRadioButtonAdd.setText("+");
                jRadioButtonAdd.setFont(font);
                jRadioButtonAdd.setBounds(160, 65, 50, 50);
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
                jRadioButtonSubtract.setFont(font);
                jRadioButtonSubtract.setBounds(160, 100, 50, 50);
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
                jRadioButtonMultiply.setFont(font);
                jRadioButtonMultiply.setBounds(160, 135, 50, 50);
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
                jRadioButtonDivide.setFont(font);
                jRadioButtonDivide.setBounds(160, 170, 50, 50);
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
                jTextFieldA.setBounds(25, 100, 120, 40);
                jTextFieldA.setFont(font);
                getContentPane().add(jTextFieldA);
            }
            {
                jTextFieldB = new JTextField();
                jTextFieldB.setBounds(210, 100, 120, 40);
                jTextFieldB.setFont(font);
                getContentPane().add(jTextFieldB);
            }
            pack();
            setSize(640, 300);
        } catch (NumberFormatException e) {
            JLabel label = new JLabel("Error: Max integer value 2147483647 exceeded in one or both text fields");
            label.setFont(new Font("Monospaced", Font.BOLD, 14));
            JOptionPane.showMessageDialog(null, label);
        }
    }

    private ButtonGroup getButtonGroup() {
        if(buttonGroup == null) {
            buttonGroup = new ButtonGroup();
        }
        return buttonGroup;
    }

    private void calculate(String a, String b, Enum Op) {
        if (a.isEmpty() || b.isEmpty()) {
            JLabel label = new JLabel("Error: No input in one or both text fields.");
            label.setFont(new Font("Monospaced", Font.BOLD, 14));
            JOptionPane.showMessageDialog(null, label);
            return;
        }
        if (!a.matches("[0-9]+") || !b.matches("[0-9]+")) {
            JLabel label = new JLabel("Error: Non integer inputs on one or both text fields.");
            label.setFont(new Font("Monospaced", Font.BOLD, 14));
            JOptionPane.showMessageDialog(null, label);
            return;
        }
        if (Op == Operator.DIVIDE) {
            if (!b.equals("0")) {
                float result = (float) Integer.parseInt(a) + Integer.parseInt(b);
                jTextFieldResult.setText(String.format("%.8f", result));
            } else {
                JLabel label = new JLabel("Error: Division by zero.");
                label.setFont(new Font("Monospaced", Font.BOLD, 14));
                JOptionPane.showMessageDialog(null, label);
            }
        } else if (Op == Operator.MULTIPLY){
            long result = (long) Integer.parseInt(a) * Integer.parseInt(b);
            jTextFieldResult.setText(String.valueOf(result));
        } else if (Op == Operator.SUBTRACT) {
            int result = Integer.parseInt(a) - Integer.parseInt(b);
            jTextFieldResult.setText(String.valueOf(result));
        } else {
            long result = (long) Integer.parseInt(a) + Integer.parseInt(b);
            jTextFieldResult.setText(String.valueOf(result));
        }
    }

    private void jRadioButtonAddActionPerformed(ActionEvent evt) {
        String a = jTextFieldA.getText().trim();
        String b = jTextFieldB.getText().trim();
        calculate(a, b, Operator.ADD);
    }

    private void jRadioButtonSubtractActionPerformed(ActionEvent evt) {
        String a = jTextFieldA.getText().trim();
        String b = jTextFieldB.getText().trim();
        calculate(a, b, Operator.SUBTRACT);
    }

    private void jRadioButtonMultiplyActionPerformed(ActionEvent evt) {
        String a = jTextFieldA.getText().trim();
        String b = jTextFieldB.getText().trim();
        calculate(a, b, Operator.MULTIPLY);
    }

    private void jRadioButtonDivideActionPerformed(ActionEvent evt) {
        String a = jTextFieldA.getText().trim();
        String b = jTextFieldB.getText().trim();
        calculate(a, b, Operator.DIVIDE);
    }
}