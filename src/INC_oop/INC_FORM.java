package INC_oop;

import javax.swing.*;

public class INC_FORM extends JFrame {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton clearButton;
    private JButton calculateFigureButton;
    private javax.swing.JPanel JPanel;

    public static void main(String[] args) {
        INC_FORM inc = new INC_FORM();
        inc.setTitle("Figure");
        inc.setContentPane(inc.JPanel);
        inc.setSize(500, 500);
        inc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inc.setVisible(true);
    }
}
