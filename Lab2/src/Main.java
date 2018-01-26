import java.util.*;

public class Main {

    /**
     * Defines a shape
     */
    private interface Shape {
        Double getArea();
    }

    /**
     * Defines a Non Circular Shape
     */
    private interface NonCircularShape {
        Double getPerimeter();
    }

    /**
     * Defines a Rectangle
     */
    private class Rectangle implements Shape, NonCircularShape {

        private Double mLength;
        private Double mWidth;

        /**
         * Calculates area of Rectangle
         *
         * @return area of the Rectangle
         */
        @Override
        public Double getArea() {
            return mLength * mWidth;
        }

        /**
         * Gets the perimeter of Rectangle
         * @return perimeter
         */
        public Double getPerimeter() {
            return 2 * (mLength + mWidth);
        }
    }

    /**
     * Defines a Circle
     */
    private class Circle implements Shape {

        private Double mRadius;

        /**
         * Calculates area of Circle
         * @return area of the Circle
         */
        @Override
        public Double getArea() {
            return Math.PI;
        }

        /**
         * Gets the circumference of a Circle
         * @return circumference
         */
        public Double getCircumference() {
            return 2 * Math.PI * mRadius;
        }
    }

    /**
     * Defines a Triangle
     */
    private class Triangle implements Shape, NonCircularShape {

        private Double mSideA;
        private Double mSideB;
        private Double mSideC;

        /**
         * Gets the area of a Triangle
         * @return area of the Triangle
         */
        @Override
        public Double getArea() {
            Double S = (mSideA + mSideB + mSideC) / 2;
            Double A = Math.sqrt(S * (S - mSideA) * (S - mSideB) * (S - mSideC));
            return A;
        }

        @Override
        public Double getPerimeter() {
            return mSideA + mSideB + mSideC;
        }
    }

    /**
     * This static helper method prevents less error
     * in printing input message
     * @param _str
     */
    static void clearPrintInput(String _str) {
        System.out.print(_str + " (positive integer): ");
    }

    /**
     * This is a static helper method that prevents
     * less error in printing output message
     */
    static void clearPrintOutput(String _str, Double _output) {
        System.out.print(_str + ": " + _output.toString());
    }

    /**
     * This object holds all the 2D states
     */
    private class Calc2d {
        private Rectangle mRectangle;
        private Circle mCircle;
        private Triangle mTriangle;

        /**
         * Runs the Calc2D
         */
        public void run() {

            Scanner scanner = new Scanner(System.in);
            Double input;

            clearPrintInput("Enter length of rectangle");
            input = scanner.nextDouble();
            mRectangle.mLength = input;

            clearPrintInput("Enter width of rectangle");
            input = scanner.nextDouble();
            mRectangle.mWidth = input;

            clearPrintInput("Now enter the radius of the circle");
            input = scanner.nextDouble();
            mCircle.mRadius = input;

            clearPrintInput("Enter side A of triangle");
            input = scanner.nextDouble();
            mTriangle.mSideA = input;

            clearPrintInput("Enter side B of triangle");
            input = scanner.nextDouble();
            mTriangle.mSideB = input;

            clearPrintInput("Enter side C of triangle");
            input = scanner.nextDouble();
            mTriangle.mSideC = input;

            clearPrintOutput("Area of rectangle", mRectangle.getArea());
            clearPrintOutput("Area of circle", mCircle.getArea());
            clearPrintOutput("Perimeter of rectangle", mRectangle.getPerimeter());
            clearPrintOutput("Circumference of circle", mCircle.getCircumference());
            clearPrintOutput("Area of triangle", mTriangle.getArea());
            clearPrintOutput("Perimeter of triangle", mTriangle.getPerimeter());
        }
    }

    public static void main(String args[]) {

        Calc2d cal2d = new Calc2d();
    }
}
