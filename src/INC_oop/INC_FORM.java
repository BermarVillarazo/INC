package INC_oop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.server.ExportException;
import java.util.Objects;

public class INC_FORM extends JFrame {
    private javax.swing.JPanel JPanel;
    private JComboBox cbFigures;
    private JTextField tfOne;
    private JTextField tfTwo;
    private JTextField tfThree;
    private JLabel lblOne;
    private JLabel lblTwo;
    private JLabel lblThree;
    private JButton btnCalculate;
    private JTextField tfVolume;
    private JTextField tfSA;
    private JButton saveButton;
    private JButton clearButton;
    private JList list1;

    public INC_FORM() {
        lblOne.setVisible(false);
        lblTwo.setVisible(false);
        lblThree.setVisible(false);

        tfOne.setVisible(false);
        tfTwo.setVisible(false);
        tfThree.setVisible(false);

        //  MILESTONE F: Implement Save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //  MILESTONE G: Implement Clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfOne.setText(null);
                tfTwo.setText(null);
                tfThree.setText(null);
                tfVolume.setText(null);
                tfSA.setText(null);
            }
        });

        // MILESTONE D: Create and show fields for each figure
        cbFigures.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    switch (Objects.requireNonNull(cbFigures.getSelectedItem()).toString()) {
                        case "Choose a Figure":
                            lblOne.setVisible(false);
                            lblTwo.setVisible(false);
                            lblThree.setVisible(false);

                            tfOne.setVisible(false);
                            tfTwo.setVisible(false);
                            tfThree.setVisible(false);
                            break;
                        case "Rectangular Solid":
                            lblOne.setVisible(true);
                            lblTwo.setVisible(true);
                            lblThree.setVisible(true);

                            tfOne.setVisible(true);
                            tfTwo.setVisible(true);
                            tfThree.setVisible(true);

                            lblOne.setText("Length:");
                            lblTwo.setText("Width:");
                            lblThree.setText("Height:");
                            btnCalculate.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        if(tfOne.getText().isEmpty() || tfTwo.getText().isEmpty() || tfThree.getText().isEmpty()) {
                                            throw new Exception();
                                        }
                                        String getLengthRS = tfOne.getText();
                                        double lengthRS = Double.parseDouble(getLengthRS);
                                        String getWidthRS = tfTwo.getText();
                                        double widthRS = Double.parseDouble(getWidthRS);
                                        String getHeightRS = tfThree.getText();
                                        double heightRS = Double.parseDouble(getHeightRS);
                                        if (lengthRS < 0 || widthRS < 0 || heightRS < 0) {
                                            tfOne.setText(null);
                                            tfTwo.setText(null);
                                            tfThree.setText(null);
                                            throw new NegativeNumberException("");
                                        }
                                        Figure.RectangularSolid RS = new Figure.RectangularSolid(lengthRS, widthRS, heightRS);
                                        String volumeRS = String.valueOf(RS.getVolume());
                                        String surfaceAreaRS = String.valueOf(RS.getSurfaceArea());
                                        tfVolume.setText(volumeRS);
                                        tfSA.setText(surfaceAreaRS);
                                        RS.setVolume(0);
                                        RS.setSurfaceArea(0);
                                    } catch (NumberFormatException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Invalid input!");
                                    } catch (NegativeNumberException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Input must not be a negative number!");
                                    } catch (Exception i) {
                                        JOptionPane.showMessageDialog(JPanel, "Field/s may not have input.");
                                    }
                                }
                            });
                            break;
                        case "Cube":
                            lblOne.setText("Side:");
                            lblOne.setVisible(true);
                            lblTwo.setVisible(false);
                            lblThree.setVisible(false);

                            tfOne.setVisible(true);
                            tfTwo.setVisible(false);
                            tfThree.setVisible(false);
                            btnCalculate.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try{
                                        if(tfOne.getText().isEmpty()) {
                                            throw new Exception();
                                        }
                                        String getSideC = tfOne.getText();
                                        double sideC = Double.parseDouble(getSideC);
                                        if(sideC < 0) {
                                            tfOne.setText(null);
                                            throw new NegativeNumberException("");
                                        }
                                        Figure.Cube cube = new Figure.Cube(sideC);
                                        String volumeC = String.valueOf(cube.getVolume());
                                        String surfaceAreaC = String.valueOf(cube.getSurfaceArea());
                                        tfVolume.setText(volumeC);
                                        tfSA.setText(surfaceAreaC);
                                        cube.setVolume(0);
                                        cube.setSurfaceArea(0);
                                    } catch (NumberFormatException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Invalid input!");
                                    } catch (NegativeNumberException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Input must not be a negative number!");
                                    } catch (Exception i) {
                                        JOptionPane.showMessageDialog(JPanel, "Field/s may not have input.");
                                    }
                                }
                            });
                            break;
                        case "Cylinder":
                            lblOne.setText("Radius:");
                            lblTwo.setText("Height:");
                            lblOne.setVisible(true);
                            lblTwo.setVisible(true);
                            lblThree.setVisible(false);

                            tfOne.setVisible(true);
                            tfTwo.setVisible(true);
                            tfThree.setVisible(false);

                            btnCalculate.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        if(tfOne.getText().isEmpty() || tfTwo.getText().isEmpty()) {
                                            throw new Exception();
                                        }
                                        String getRadiusCy = tfOne.getText();
                                        double radiusCy = Double.parseDouble(getRadiusCy);
                                        String getHeightCy = tfOne.getText();
                                        double heightCy = Double.parseDouble(getHeightCy);
                                        if(heightCy < 0 || radiusCy < 0) {
                                            tfOne.setText(null);
                                            tfTwo.setText(null);
                                            throw new NegativeNumberException("");
                                        }

                                        Figure.Cylinder cylinder = new Figure.Cylinder(radiusCy, heightCy);
                                        String volumeCy = String.valueOf(cylinder.getVolume());
                                        String surfaceAreaCy = String.valueOf(cylinder.getSurfaceArea());
                                        tfVolume.setText(volumeCy);
                                        tfSA.setText(surfaceAreaCy);
                                        cylinder.setVolume(0);
                                        cylinder.setSurfaceArea(0);
                                    } catch (NumberFormatException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Invalid input!");
                                    } catch (NegativeNumberException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Input must not be a negative number!");
                                    } catch (Exception i) {
                                        JOptionPane.showMessageDialog(JPanel, "Field/s may not have input.");
                                    }
                                }
                            });
                            break;
                        case "Prism":
                            lblOne.setText("Base Area:");
                            lblTwo.setText("Height:");
                            lblOne.setVisible(true);
                            lblTwo.setVisible(true);
                            lblThree.setVisible(false);

                            tfOne.setVisible(true);
                            tfTwo.setVisible(true);
                            tfThree.setVisible(false);

                            btnCalculate.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        if(tfOne.getText().isEmpty() || tfTwo.getText().isEmpty()) {
                                            throw new Exception();
                                        }
                                        String getBaseAreaP= tfOne.getText();
                                        double radiusP = Double.parseDouble(getBaseAreaP);
                                        String getHeightP = tfTwo.getText();
                                        double heightP = Double.parseDouble(getHeightP);
                                        if(heightP < 0 || radiusP < 0) {
                                            tfOne.setText(null);
                                            tfTwo.setText(null);
                                            throw new NegativeNumberException("");
                                        }
                                        Figure.Prism prism = new Figure.Prism(radiusP, heightP);
                                        String volumeP = String.valueOf(prism.getVolume());
                                        String surfaceAreaP = String.valueOf(prism.getSurfaceArea());
                                        tfVolume.setText(volumeP);
                                        tfSA.setText(surfaceAreaP);
                                        prism.setVolume(0);
                                        prism.setSurfaceArea(0);
                                    } catch (NumberFormatException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Invalid input!");
                                    } catch (NegativeNumberException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Input must not be a negative number!");
                                    } catch (Exception i) {
                                        JOptionPane.showMessageDialog(JPanel, "Field/s may not have input.");
                                    }
                                }
                            });
                            break;
                        case "Sphere":
                            lblOne.setText("Radius:");
                            lblOne.setVisible(true);
                            lblTwo.setVisible(false);
                            lblThree.setVisible(false);

                            tfOne.setVisible(true);
                            tfTwo.setVisible(false);
                            tfThree.setVisible(false);
                            btnCalculate.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        if(tfOne.getText().isEmpty()) {
                                            throw new Exception();
                                        }
                                        String getRadiusSph = tfOne.getText();
                                        double radiusSph = Double.parseDouble(getRadiusSph );
                                        if(radiusSph < 0) {
                                            tfOne.setText(null);
                                            throw new NegativeNumberException("");
                                        }
                                        Figure.Ellipsoid.Sphere sphere = new Figure.Ellipsoid.Sphere(radiusSph);
                                        String volumeSph = String.valueOf(sphere.getVolume());
                                        String surfaceAreaSph = String.valueOf(sphere.getSurfaceArea());
                                        tfVolume.setText(volumeSph);
                                        tfSA.setText(surfaceAreaSph);
                                        sphere.setVolume(0);
                                        sphere.setSurfaceArea(0);
                                    } catch (NumberFormatException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Invalid input!");
                                    } catch (NegativeNumberException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Input must not be a negative number!");
                                    } catch (Exception i) {
                                        JOptionPane.showMessageDialog(JPanel, "Field/s may not have input.");
                                    }
                                }
                            });
                            break;
                        case "Pyramid":
                            lblOne.setText("Base Area:");
                            lblTwo.setText("Height:");
                            lblOne.setVisible(true);
                            lblTwo.setVisible(true);
                            lblThree.setVisible(false);

                            tfOne.setVisible(true);
                            tfTwo.setVisible(true);
                            tfThree.setVisible(false);

                            btnCalculate.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        if(tfOne.getText().isEmpty() || tfTwo.getText().isEmpty()) {
                                            throw new Exception();
                                        }
                                        String getBaseAreaPy= tfOne.getText();
                                        double baseAreaPy = Double.parseDouble(getBaseAreaPy);
                                        String getHeightPy = tfTwo.getText();
                                        double heightPy = Double.parseDouble(getHeightPy);
                                        if(heightPy < 0 || baseAreaPy < 0) {
                                            tfOne.setText(null);
                                            tfTwo.setText(null);
                                            throw new NegativeNumberException("");
                                        }
                                        Figure.Pyramid pyramid = new Figure.Pyramid(baseAreaPy, heightPy);
                                        String volumePy = String.valueOf(pyramid.getVolume());
                                        String surfaceAreaPy = String.valueOf(pyramid.getSurfaceArea());
                                        tfVolume.setText(volumePy);
                                        tfSA.setText(surfaceAreaPy);
                                        pyramid.setVolume(0);
                                        pyramid.setSurfaceArea(0);
                                    } catch (NumberFormatException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Invalid input!");
                                    } catch (NegativeNumberException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Input must not be a negative number!");
                                    } catch (Exception i) {
                                        JOptionPane.showMessageDialog(JPanel, "Field/s may not have input.");
                                    }
                                }
                            });
                            break;
                        case "Right Circular Cone":
                            lblOne.setText("Radius:");
                            lblTwo.setText("Height:");
                            lblOne.setVisible(true);
                            lblTwo.setVisible(true);
                            lblThree.setVisible(false);

                            tfOne.setVisible(true);
                            tfTwo.setVisible(true);
                            tfThree.setVisible(false);

                            btnCalculate.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        if(tfOne.getText().isEmpty() || tfTwo.getText().isEmpty()) {
                                            throw new Exception();
                                        }
                                        String getRadiusRCC = tfOne.getText();
                                        double radiusRCC = Double.parseDouble(getRadiusRCC);
                                        String getHeightRCC = tfOne.getText();
                                        double heightRCC = Double.parseDouble(getHeightRCC);
                                        if(heightRCC < 0 || radiusRCC < 0) {
                                            tfOne.setText(null);
                                            tfTwo.setText(null);
                                            throw new NegativeNumberException("");
                                        }
                                        Figure.RightCircularCone rightCircularCone = new Figure.RightCircularCone(radiusRCC, heightRCC);
                                        String volumeRCC = String.valueOf(rightCircularCone.getVolume());
                                        String surfaceAreaRCC = String.valueOf(rightCircularCone.getSurfaceArea());
                                        tfVolume.setText(volumeRCC);
                                        tfSA.setText(surfaceAreaRCC);
                                        rightCircularCone.setVolume(0);
                                        rightCircularCone.setSurfaceArea(0);
                                    } catch (NumberFormatException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Invalid input!");
                                    } catch (NegativeNumberException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Input must not be a negative number!");
                                    } catch (Exception i) {
                                        JOptionPane.showMessageDialog(JPanel, "Field/s may not have input.");
                                    }
                                }
                            });
                            break;
                        case "Rectangular Pyramid":
                            lblOne.setVisible(true);
                            lblTwo.setVisible(true);
                            lblThree.setVisible(true);

                            tfOne.setVisible(true);
                            tfTwo.setVisible(true);
                            tfThree.setVisible(true);

                            lblOne.setText("Length:");
                            lblTwo.setText("Width:");
                            lblThree.setText("Height:");

                            btnCalculate.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        if(tfOne.getText().isEmpty() || tfTwo.getText().isEmpty() || tfThree.getText().isEmpty()) {
                                            throw new Exception();
                                        }
                                        String getLengthRP = tfOne.getText();
                                        double lengthRP = Double.parseDouble(getLengthRP);
                                        String getWidthRP = tfTwo.getText();
                                        double widthRP = Double.parseDouble(getWidthRP);
                                        String getHeightRP = tfThree.getText();
                                        double heightRP = Double.parseDouble(getHeightRP);
                                        if (lengthRP < 0 || widthRP < 0 || heightRP < 0) {
                                            tfOne.setText(null);
                                            tfTwo.setText(null);
                                            tfThree.setText(null);
                                            throw new NegativeNumberException("");
                                        }
                                        Figure.RectangularPyramid RP = new Figure.RectangularPyramid(lengthRP, widthRP, heightRP);
                                        String volumeRP = String.valueOf(RP.getVolume());
                                        String surfaceAreaRP = String.valueOf(RP.getSurfaceArea());
                                        tfVolume.setText(volumeRP);
                                        tfSA.setText(surfaceAreaRP);
                                        RP.setVolume(0);
                                        RP.setSurfaceArea(0);
                                    } catch (NumberFormatException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Invalid input!");
                                    } catch (NegativeNumberException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Input must not be a negative number!");
                                    } catch (Exception i) {
                                        JOptionPane.showMessageDialog(JPanel, "Field/s may not have input.");
                                    }
                                }
                            });
                            break;
                        case "Ellipsoid":
                            lblOne.setVisible(true);
                            lblTwo.setVisible(true);
                            lblThree.setVisible(true);

                            tfOne.setVisible(true);
                            tfTwo.setVisible(true);
                            tfThree.setVisible(true);

                            lblOne.setText("a:");
                            lblTwo.setText("b:");
                            lblThree.setText("c:");

                            btnCalculate.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        if(tfOne.getText().isEmpty() || tfTwo.getText().isEmpty() || tfThree.getText().isEmpty()) {
                                            throw new Exception();
                                        }
                                        String getA = tfOne.getText();
                                        double A = Double.parseDouble(getA);
                                        String getB = tfTwo.getText();
                                        double B = Double.parseDouble(getB);
                                        String getC = tfThree.getText();
                                        double C = Double.parseDouble(getC);
                                        if (A < 0 || B < 0 || C < 0) {
                                            tfOne.setText(null);
                                            tfTwo.setText(null);
                                            tfThree.setText(null);
                                            throw new NegativeNumberException("");
                                        }
                                        Figure.Ellipsoid ellipsoid = new Figure.Ellipsoid(A, B, C);
                                        String volumeE = String.valueOf(ellipsoid.getVolume());
                                        String surfaceAreaE = String.valueOf(ellipsoid.getSurfaceArea());
                                        tfVolume.setText(volumeE);
                                        tfSA.setText(surfaceAreaE);
                                        ellipsoid.setVolume(0);
                                        ellipsoid.setSurfaceArea(0);
                                    } catch (NumberFormatException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Invalid input!");
                                    } catch (NegativeNumberException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Input must not be a negative number!");
                                    } catch (Exception i) {
                                        JOptionPane.showMessageDialog(JPanel, "Field/s may not have input.");
                                    }
                                }
                            });
                            break;
                        case "Tetrahedron":
                            lblOne.setText("Edge Length:");
                            lblOne.setVisible(true);
                            lblTwo.setVisible(false);
                            lblThree.setVisible(false);

                            tfOne.setVisible(true);
                            tfTwo.setVisible(false);
                            tfThree.setVisible(false);
                            btnCalculate.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        if(tfOne.getText().isEmpty()) {
                                            throw new Exception();
                                        }
                                        String getEdgeLength = tfOne.getText();
                                        double edgeLength = Double.parseDouble(getEdgeLength);
                                        if(edgeLength < 0) {
                                            tfOne.setText(null);
                                            throw new NegativeNumberException("");

                                        }
                                        Figure.Tetrahedron tetrahedron = new Figure.Tetrahedron(edgeLength);
                                        String volumeT = String.valueOf(tetrahedron.getVolume());
                                        String surfaceAreaT = String.valueOf(tetrahedron.getSurfaceArea());
                                        tfVolume.setText(volumeT);
                                        tfSA.setText(surfaceAreaT);
                                        tetrahedron.setVolume(0);
                                        tetrahedron.setSurfaceArea(0);
                                    } catch (NumberFormatException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Invalid input!");
                                    } catch (NegativeNumberException i) {
                                        JOptionPane.showMessageDialog(JPanel, "Input must not be a negative number!");
                                    } catch (Exception i) {
                                        JOptionPane.showMessageDialog(JPanel, "Field/s may not have input.");
                                    }
                                }
                            });
                            break;
                    }
                }
            }
        });
    }

    // MILESTONE A: Show the GUI
    // MILESTONE B: Create the ComboBox for figures
    public static void main(String[] args) {
        INC_FORM inc = new INC_FORM();
        inc.setTitle("Figure");
        inc.setContentPane(inc.JPanel);
        inc.setSize(500, 500);
        inc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inc.setVisible(true);
    }

    static class NegativeNumberException extends Exception {
        public NegativeNumberException(String s) { super(s); }
    }
}