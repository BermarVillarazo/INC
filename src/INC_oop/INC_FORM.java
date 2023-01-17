package INC_oop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

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

    public INC_FORM() {
        lblOne.setVisible(false);
        lblTwo.setVisible(false);
        lblThree.setVisible(false);

        tfOne.setVisible(false);
        tfTwo.setVisible(false);
        tfThree.setVisible(false);
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
                                    String getLengthRS = tfOne.getText();
                                    double lengthRS = Double.parseDouble(getLengthRS);
                                    String getWidthRS = tfTwo.getText();
                                    double widthRS = Double.parseDouble(getWidthRS);
                                    String getHeightRS = tfThree.getText();
                                    double heightRS = Double.parseDouble(getHeightRS);

                                    Figure.RectangularSolid RS = new Figure.RectangularSolid(lengthRS, widthRS, heightRS);
                                    String volumeRS = String.valueOf(RS.getVolume());
                                    String surfaceAreaRS = String.valueOf(RS.getSurfaceArea());
                                    tfVolume.setText(volumeRS);
                                    tfSA.setText(surfaceAreaRS);
                                    RS.setVolume(0);
                                    RS.setSurfaceArea(0);

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
                                    String getSideC = tfOne.getText();
                                    double sideC = Double.parseDouble(getSideC);

                                    Figure.Cube cube = new Figure.Cube(sideC);
                                    String volumeC = String.valueOf(cube.getVolume());
                                    String surfaceAreaC = String.valueOf(cube.getSurfaceArea());
                                    tfVolume.setText(volumeC);
                                    tfSA.setText(surfaceAreaC);
                                    cube.setVolume(0);
                                    cube.setSurfaceArea(0);
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
                                    String getRadiusCy = tfOne.getText();
                                    double radiusCy = Double.parseDouble(getRadiusCy);
                                    String getHeightCy = tfOne.getText();
                                    double heightCy = Double.parseDouble(getHeightCy);

                                    Figure.Cylinder cylinder = new Figure.Cylinder(radiusCy, heightCy);
                                    String volumeCy = String.valueOf(cylinder.getVolume());
                                    String surfaceAreaCy = String.valueOf(cylinder.getSurfaceArea());
                                    tfVolume.setText(volumeCy);
                                    tfSA.setText(surfaceAreaCy);
                                    cylinder.setVolume(0);
                                    cylinder.setSurfaceArea(0);
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
                                    String getBaseAreaP = tfOne.getText();
                                    double radiusP = Double.parseDouble(getBaseAreaP);
                                    String getHeightP = tfOne.getText();
                                    double heightP = Double.parseDouble(getHeightP);

                                    Figure.Prism prism = new Figure.Prism(radiusP, heightP);
                                    String volumeP = String.valueOf(prism.getVolume());
                                    String surfaceAreaP = String.valueOf(prism.getSurfaceArea());
                                    tfVolume.setText(volumeP);
                                    tfSA.setText(surfaceAreaP);
                                    prism.setVolume(0);
                                    prism.setSurfaceArea(0);
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
                                    String getRadiusSph = tfOne.getText();
                                    double radiusSph = Double.parseDouble(getRadiusSph);

                                    Figure.Ellipsoid.Sphere sphere = new Figure.Ellipsoid.Sphere(radiusSph);
                                    String volumeSph = String.valueOf(sphere.getVolume());
                                    String surfaceAreaSph = String.valueOf(sphere.getSurfaceArea());
                                    tfVolume.setText(volumeSph);
                                    tfSA.setText(surfaceAreaSph);
                                    sphere.setVolume(0);
                                    sphere.setSurfaceArea(0);
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
                                    String getBaseAreaPy = tfOne.getText();
                                    double baseAreaPy = Double.parseDouble(getBaseAreaPy);
                                    String getHeightPy = tfOne.getText();
                                    double heightPy = Double.parseDouble(getHeightPy);

                                    Figure.Pyramid pyramid = new Figure.Pyramid(baseAreaPy, heightPy);
                                    String volumePy = String.valueOf(pyramid.getVolume());
                                    String surfaceAreaPy = String.valueOf(pyramid.getSurfaceArea());
                                    tfVolume.setText(volumePy);
                                    tfSA.setText(surfaceAreaPy);
                                    pyramid.setVolume(0);
                                    pyramid.setSurfaceArea(0);
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
                                    String getRadiusRCC = tfOne.getText();
                                    double radiusRCC = Double.parseDouble(getRadiusRCC);
                                    String getHeightRCC = tfOne.getText();
                                    double heightRCC = Double.parseDouble(getHeightRCC);

                                    Figure.RightCircularCone rightCircularCone = new Figure.RightCircularCone(radiusRCC, heightRCC);
                                    String volumeRCC = String.valueOf(rightCircularCone.getVolume());
                                    String surfaceAreaRCC = String.valueOf(rightCircularCone.getSurfaceArea());
                                    tfVolume.setText(volumeRCC);
                                    tfSA.setText(surfaceAreaRCC);
                                    rightCircularCone.setVolume(0);
                                    rightCircularCone.setSurfaceArea(0);
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
                                    String getLengthRP = tfOne.getText();
                                    double lengthRP = Double.parseDouble(getLengthRP);
                                    String getWidthRP = tfTwo.getText();
                                    double widthRS = Double.parseDouble(getWidthRP);
                                    String getHeightRP = tfThree.getText();
                                    double heightRP = Double.parseDouble(getHeightRP);

                                    Figure.RectangularPyramid RP = new Figure.RectangularPyramid(lengthRP, widthRS, heightRP);
                                    String volumeRP = String.valueOf(RP.getVolume());
                                    String surfaceAreaRP = String.valueOf(RP.getSurfaceArea());
                                    tfVolume.setText(volumeRP);
                                    tfSA.setText(surfaceAreaRP);
                                    RP.setVolume(0);
                                    RP.setSurfaceArea(0);

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
                                    String getA = tfOne.getText();
                                    double A = Double.parseDouble(getA);
                                    String getB = tfTwo.getText();
                                    double B = Double.parseDouble(getB);
                                    String getC = tfThree.getText();
                                    double C = Double.parseDouble(getC);

                                    Figure.Ellipsoid ellipsoid = new Figure.Ellipsoid(A, B, C);
                                    String volumeE = String.valueOf(ellipsoid.getVolume());
                                    String surfaceAreaE = String.valueOf(ellipsoid.getSurfaceArea());
                                    tfVolume.setText(volumeE);
                                    tfSA.setText(surfaceAreaE);
                                    ellipsoid.setVolume(0);
                                    ellipsoid.setSurfaceArea(0);

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
                                    String getEdgeLength = tfOne.getText();
                                    double edgeLength = Double.parseDouble(getEdgeLength);

                                    Figure.Tetrahedron tetrahedron = new Figure.Tetrahedron(edgeLength);
                                    String volumeT = String.valueOf(tetrahedron.getVolume());
                                    String surfaceAreaT = String.valueOf(tetrahedron.getSurfaceArea());
                                    tfVolume.setText(volumeT);
                                    tfSA.setText(surfaceAreaT);
                                    tetrahedron.setVolume(0);
                                    tetrahedron.setSurfaceArea(0);
                                }
                            });
                            break;
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        INC_FORM inc = new INC_FORM();
        inc.setTitle("Figure");
        inc.setContentPane(inc.JPanel);
        inc.setSize(500, 500);
        inc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inc.setVisible(true);
    }
}