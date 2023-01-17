package INC_oop;

import javax.swing.*;


public class INC_FORM extends JFrame {
    private javax.swing.JPanel JPanel;
    private JComboBox cbFigures;
    private JTextField tfOne;
    private JTextField tfTwo;
    private JTextField tfThree;
    private JTextField tfVolume;
    private JTextField tfSA;
    private JButton clearButton;
    private JButton btnCalculate;
    private JLabel lblOne;
    private JLabel lblTwo;
    private JLabel lblThree;

    public static void main(String[] args) {
        INC_FORM inc = new INC_FORM();
        inc.setTitle("Figure");
        inc.setContentPane(inc.JPanel);
        inc.setSize(500, 500);
        inc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inc.setVisible(true);
    }
}