package INC_oop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

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
    private JButton loadButton;
    private JTextArea savedArea;
    private JTextArea tfLoad;
    private JButton volBtn;
    private JButton SABtn;
    private JButton figureBtn;
    private JTextField txtLoad;
    private JTextArea loadArea;

    List<Figure> figures = new ArrayList<>();

    public INC_FORM() {
        lblOne.setVisible(false);
        lblTwo.setVisible(false);
        lblThree.setVisible(false);

        tfOne.setVisible(false);
        tfTwo.setVisible(false);
        tfThree.setVisible(false);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String input = txtLoad.getText();

                try {
                    int index = Integer.parseInt(input);
                    Figure selectedFigure = figures.get(index);

                    tfOne.setText(String.valueOf(selectedFigure.getNumOne()));
                    tfTwo.setText(String.valueOf(selectedFigure.getNumTwo()));
                    tfThree.setText(String.valueOf(selectedFigure.getNumThree()));

                    int selectedIndex = getIndexOfFigureType(selectedFigure);
                    cbFigures.setSelectedIndex(selectedIndex);

                    saveButton.setEnabled(false);
                    tfOne.setEnabled(false);
                    tfTwo.setEnabled(false);
                    tfThree.setEnabled(false);
                    cbFigures.setEnabled(false);

                    loadArea.setText("LOAD:\n");
                    loadArea.append(selectedFigure + "\n");

                } catch (NumberFormatException event) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }

            private int getIndexOfFigureType(Figure selectedFigure) {
                if (selectedFigure instanceof Figure.RectangularSolid) {
                    return 0;
                } else if (selectedFigure instanceof Figure.Cube) {
                    return 1;
                } else if (selectedFigure instanceof Figure.Cylinder) {
                    return 2;
                } else if (selectedFigure instanceof Figure.Prism) {
                    return 3;
                } else if (selectedFigure instanceof Figure.RightCircularCone) {
                    return 4;
                } else {
                    return -1;
                }
            }
        });
        volBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(figures);

                tfLoad.setText("SORTED as Volume: \n");

                for (Figure f : figures) {
                    tfLoad.append(f.toString() + "\n");
                }
            }
        });

        SABtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(figures);

                tfLoad.setText("SORTED as Surface Area: \n");

                for (Figure f : figures) {
                    tfLoad.append(f.toString() + "\n");
                }
            }
        });

        figureBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(figures);

                tfLoad.setText("SORTED as Figures: \n");

                for (Figure f : figures) {
                    tfLoad.append(f.toString() + "\n");
                }
            }
        });

        //  MILESTONE F: Implement Save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFigure = (String) cbFigures.getSelectedItem();
                switch (selectedFigure) {
                    case "Rectangular Solid":
                        String getRectangle = tfOne.getText();
                        double lengthR = Double.parseDouble(getRectangle);
                        String getWidth = tfTwo.getText();
                        double widthR = Double.parseDouble(getWidth);
                        String getHeightR = tfTwo.getText();
                        double heightR = Double.parseDouble(getHeightR);

                        Figure.RectangularSolid rectangularSolid = new Figure.RectangularSolid(lengthR, widthR, heightR);
                        figures.add(rectangularSolid);

                        tfVolume.setText(String.valueOf(rectangularSolid.getVolume()));
                        tfSA.setText(String.valueOf(rectangularSolid.getSurfaceArea()));

                        saveButton.setEnabled(false);
                        tfOne.setEnabled(false);
                        tfTwo.setEnabled(false);
                        tfThree.setEnabled(false);
                        cbFigures.setEnabled(false);
                        break;
                    case "Cube":
                        String getEdgeLengthC = tfOne.getText();
                        double edgeLengthC = Double.parseDouble(getEdgeLengthC);

                        Figure.Cube cube = new Figure.Cube(edgeLengthC);
                        figures.add(cube);
                        tfVolume.setText(String.valueOf(cube.getVolume()));
                        tfSA.setText(String.valueOf(cube.getSurfaceArea()));

                        saveButton.setEnabled(false);
                        tfOne.setEnabled(false);
                        cbFigures.setEnabled(false);
                        break;
                    case "Cylinder":
                        String getRadiusC = tfOne.getText();
                        double radiusC = Double.parseDouble(getRadiusC);
                        String getHeightC = tfTwo.getText();
                        double heightC = Double.parseDouble(getHeightC);

                        Figure.Cylinder cylinder = new Figure.Cylinder(radiusC, heightC);
                        figures.add(cylinder);

                        tfVolume.setText(String.valueOf(cylinder.getVolume()));
                        tfSA.setText(String.valueOf(cylinder.getSurfaceArea()));

                        saveButton.setEnabled(false);
                        tfOne.setEnabled(false);
                        tfTwo.setEnabled(false);
                        cbFigures.setEnabled(false);
                        break;
                    case "Prism":
                        String getPrism = tfOne.getText();
                        double lengthP = Double.parseDouble(getPrism);
                        String getHeightP = tfTwo.getText();
                        double heightP = Double.parseDouble(getHeightP);

                        Figure.Prism prism = new Figure.Prism(lengthP, heightP);
                        figures.add(prism);

                        tfVolume.setText(String.valueOf(prism.getVolume()));
                        tfSA.setText(String.valueOf(prism.getSurfaceArea()));

                        saveButton.setEnabled(false);
                        tfOne.setEnabled(false);
                        tfTwo.setEnabled(false);
                        cbFigures.setEnabled(false);
                        break;
                    case "Right Circular Cone":
                        String getRightCircularCone = tfOne.getText();
                        double radiusR = Double.parseDouble(getRightCircularCone);
                        String getHeightRCC = tfTwo.getText();
                        double heightRCC = Double.parseDouble(getHeightRCC);

                        Figure.RightCircularCone rightCircularCone = new Figure.RightCircularCone(radiusR, heightRCC);
                        figures.add(rightCircularCone);

                        tfVolume.setText(String.valueOf(rightCircularCone.getVolume()));
                        tfSA.setText(String.valueOf(rightCircularCone.getSurfaceArea()));

                        saveButton.setEnabled(false);
                        tfOne.setEnabled(false);
                        tfTwo.setEnabled(false);
                        cbFigures.setEnabled(false);
                        break;
                    case "Ellipsoid":
                        String getEllipsoid = tfOne.getText();
                        double aE = Double.parseDouble(getEllipsoid);
                        String getbE = tfTwo.getText();
                        double bE = Double.parseDouble(getbE);
                        String getcE = tfTwo.getText();
                        double cE = Double.parseDouble(getcE);

                        Figure.Ellipsoid ellipsoid = new Figure.Ellipsoid(aE, bE, cE);
                        figures.add(ellipsoid);

                        tfVolume.setText(String.valueOf(ellipsoid.getVolume()));
                        tfSA.setText(String.valueOf(ellipsoid.getSurfaceArea()));

                        saveButton.setEnabled(false);
                        tfOne.setEnabled(false);
                        tfTwo.setEnabled(false);
                        tfThree.setEnabled(false);
                        cbFigures.setEnabled(false);
                        break;
                    case "Sphere":
                        String getSphere = tfOne.getText();
                        double RadiusS = Double.parseDouble(getSphere);

                        Figure.Sphere sphere = new Figure.Sphere(RadiusS);
                        figures.add(sphere);

                        tfVolume.setText(String.valueOf(sphere.getVolume()));
                        tfSA.setText(String.valueOf(sphere.getSurfaceArea()));

                        saveButton.setEnabled(false);
                        tfOne.setEnabled(false);
                        tfTwo.setEnabled(false);
                        cbFigures.setEnabled(false);
                        break;
                    case "Tetrahedron":
                        String getTetrahedron = tfOne.getText();
                        double edgeLengthT = Double.parseDouble(getTetrahedron);

                        Figure.Tetrahedron tetrahedron = new Figure.Tetrahedron(edgeLengthT);
                        figures.add(tetrahedron);

                        tfVolume.setText(String.valueOf(tetrahedron.getVolume()));
                        tfSA.setText(String.valueOf(tetrahedron.getSurfaceArea()));

                        saveButton.setEnabled(false);
                        tfOne.setEnabled(false);
                        cbFigures.setEnabled(false);
                        break;
                }
                for (Figure figure : figures) {
                    savedArea.append("Figure: " + figure.toString() + "\n" + "Volume: " + figure.getVolume() + "\n" + "Surface Area: " + figure.getSurfaceArea() + "\n");
                    savedArea.append("\n");
                }
                savedArea.setBounds(10, 400, 330, 50);
                add(savedArea);
            }
        });

        //  MILESTONE G: Implement Clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbFigures.setEnabled(true);
                tfOne.setEnabled(true);
                tfTwo.setEnabled(true);
                tfThree.setEnabled(true);
                tfVolume.setText(null);
                tfSA.setText(null);
                saveButton.setEnabled(true);
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
        inc.setSize(1000, 500);
        inc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inc.setVisible(true);
    }

    static class NegativeNumberException extends Exception {
        public NegativeNumberException(String s) { super(s); }
    }
}