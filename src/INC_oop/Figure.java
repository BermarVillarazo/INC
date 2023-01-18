package INC_oop;
// MILESTONE C: Create Figure Class and subclasses
public abstract class Figure implements Comparable<Figure> {
    double volume;
    double surfaceArea;

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public String toString() {
        return "Figure: " + "(" + volume + ", " + surfaceArea + ")";
    }

    public int compareTo(Figure other) {
        int vol = (int) this.volume;
        int sur = (int) this.surfaceArea;
        if (vol > other.volume || sur < other.surfaceArea) {
            return -1;
        } else if (vol < other.volume || sur > other.surfaceArea) {
            return 1;
        } else {
            return 0;
        }
    }

    public static class RectangularSolid extends Figure {
        double length;
        double width;
        double height;

        public RectangularSolid(double l, double w, double h) {
            length = l;
            width = w;
            height = h;
            volume = length * width * height;
            surfaceArea = 2 * (length * width + width * height + length * height);
        }
        public String toString() {
            return "Rectangular Solid: " + "(" + volume + ", " + surfaceArea + ")";
        }

    }

    public static class Cube extends RectangularSolid {
        public Cube(double side) {
            super(side, side, side);
        }

        public String toString() {
            return "Cube: " + "(" + volume + ", " + surfaceArea + ")";
        }
    }

    public static class Cylinder extends Figure {
        double radius;
        double height;

        public Cylinder(double r, double h) {
            radius = r;
            height = h;
            volume = Math.PI * radius * radius * height;
            surfaceArea = 2 * Math.PI * radius * height + 2 * Math.PI * radius * radius;
        }

        public String toString() {
            return "Cylinder: " + "(" + volume + ", " + surfaceArea + ")";
        }
    }

    public static class Prism extends Figure {
        double baseArea;
        double height;

        public Prism(double b, double h) {
            baseArea = b;
            height = h;
            volume = baseArea * height;
            surfaceArea = 2 * baseArea + height * baseArea / 2;
        }

        public String toString() {
            return "Prism: " + "(" + volume + ", " + surfaceArea + ")";
        }
    }

    public static class Pyramid extends Figure {
        double baseArea;
        double height;

        public Pyramid(double b, double h) {
            baseArea = b;
            height = h;
            volume = baseArea * height / 3;
            surfaceArea = baseArea + height * Math.sqrt(baseArea / 2);
        }
        public String toString() {
            return "Pyramid: " + "(" + volume + ", " + surfaceArea + ")";
        }
    }
    public static class RightCircularCone extends Figure {
        double radius;
        double height;

        public RightCircularCone(double r, double h) {
            radius = r;
            height = h;
            volume = Math.PI * radius * radius * height / 3;
            surfaceArea = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        }

        public String toString() {
            return "Right Circular Cone: " + "(" + volume + ", " + surfaceArea + ")";
        }
    }

    public static class RectangularPyramid extends Figure {
        double length;
        double width;
        double height;

        public RectangularPyramid(double l, double w, double h) {
            length = l;
            width = w;
            height = h;
            volume = length * width * height / 3;
            surfaceArea = length * width + width * Math.sqrt(height * height + (length / 2) * (length / 2)) + length * Math.sqrt(height * height + (width / 2) * (width / 2));
        }

        public String toString() {
            return "Rectangular Pyramid: " + "(" + volume + ", " + surfaceArea + ")";
        }
    }

    public static class Ellipsoid extends Figure {
        double a;
        double b;
        double c;
        public Ellipsoid(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
            volume = (4 / 3) * Math.PI * a * b * c;
            surfaceArea = 4 * Math.PI * Math.sqrt((a * b + b * c + a * c) / 3);
        }

        public String toString() {
            return "Ellipsoid: " + "(" + volume + ", " + surfaceArea + ")";
        }
    }

    public static class Sphere extends Ellipsoid {
        public Sphere(double r) {
            super(r, r, r);
        }

        public String toString() {
            return "Sphere: " + "(" + volume + ", " + surfaceArea + ")";
        }
    }

    public static class Tetrahedron extends Figure {
        double edgeLength;

        public Tetrahedron(double e) {
            edgeLength = e;
            volume = Math.pow(edgeLength, 3) / (6 * Math.sqrt(2));
            surfaceArea = Math.sqrt(3) * Math.pow(edgeLength, 2);
        }

        public String toString() {
            return "Tetrahedron: " + "(" + volume + ", " + surfaceArea + ")";
        }
    }
}