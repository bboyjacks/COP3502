import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    /**
     * This static helper method prevents less error
     * in printing input message
     * @param _str
     */
    static void clearPrintInput(String _str) {
        System.out.println(_str + " (positive integer): ");
    }

    /**
     * This static helper method prevents less error
     * in printing input message
     * #param _str
     */
    static void clearPrintInputLess(String _str) {
        System.out.println(_str + ": ");
    }

    /**
     * This is a static helper method that prevents
     * less error in printing output message
     */
    static void clearPrintOutput(String _str, Double _output) {
        System.out.println(_str + ": " + _output.toString());
    }

    /**
     * Scanner object used
     */
    static Scanner scanner = new Scanner(System.in);

    /**
     * PI used in the program
     */
    static final Double PI = 3.14;


    /**
     * This object holds all the 2D related stuff
     */
    private static class Calc2d {

        //
        // Cal2d object dependencies
        //

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

            public Double mLength;
            public Double mWidth;

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

            public Double mRadius;

            /**
             * Calculates area of Circle
             * @return area of the Circle
             */
            @Override
            public Double getArea() {
                return PI * (mRadius * mRadius);
            }

            /**
             * Gets the circumference of a Circle
             * @return circumference
             */
            public Double getCircumference() {
                return 2 * PI * mRadius;
            }
        }

        /**
         * Defines a Triangle
         */
        private class Triangle implements Shape, NonCircularShape {

            public Double mSideA;
            public Double mSideB;
            public Double mSideC;

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

        // ********* End of Cal2D dependencies ********** //

        // Cal2D member variables

        private Rectangle mRectangle;
        private Circle mCircle;
        private Triangle mTriangle;

        Calc2d() {
            mRectangle = new Rectangle();
            mCircle = new Circle();
            mTriangle = new Triangle();
        }

        /**
         * Runs the Calc2D
         */
        public void run() {

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

    /**
     * This class holds all the 3D related stuff
     */
    private static class Calc3d {

        //
        // Cal3d object dependencies
        //

        /**
         * This defines a Shape3d
         */
        public interface Shape3d {
            public Double getSurfaceArea();
            public Double getVolume();
        }

        /**
         * This implements Shape3d behaviors for Sphere
         */
        private class Sphere implements Shape3d {

            public Double mRadius;

            /**
             * This gets the surface area of sphere
             * @return Double surface area of Sphere
             */
            @Override
            public Double getSurfaceArea() {
                return 4 * PI * mRadius * mRadius;
            }

            /**
             * This gets volume of Sphere
             * @return Double volume of Sphere
             */
            @Override
            public Double getVolume() {
                return 4 * PI * (mRadius * mRadius * mRadius) / 3;
            }
        }

        /**
         * This implements Shape3d behaviors for RectangularPrism
         */
        private class RectangularPrism implements Shape3d {

            public Double mDiameter;
            public Double mWidth;
            public Double mHeight;

            /**
             * This gets the surface area of Rectangular Prism
             * @return Double surface area of Rectangular Prism
             */
            @Override
            public Double getSurfaceArea() {
                return 2 * ((mDiameter * mWidth) + (mDiameter * mHeight) + (mWidth * mHeight));
            }

            /**
             * This gets the volume of Rectangular Prism
             * @return Double volume of Rectangular Prism
             */
            @Override
            public Double getVolume() {
                return mDiameter * mWidth * mHeight;
            }
        }

        /**
         * This implements Shape3d for Cylinder
         */
        private class Cylinder implements Shape3d {

            public Double mRadius;
            public Double mHeight;

            /**
             * This gets surface area of Cylinder
             * @return Double surface area of Cylinder
             */
            @Override
            public Double getSurfaceArea() {
                return 2 * PI * mRadius * mHeight + 2 * PI * (mRadius * mRadius);
            }

            /**
             * This gets volume of Cylinder
             * @return Double volume of Cylinder
             */
            @Override
            public Double getVolume() {
                return PI * (mRadius * mRadius) * mHeight;
            }
        }

        //************ End of Cal3d dependencies **************//

        /**
         * Member variables of Calc3d
         */
        private Sphere mSphere;
        private RectangularPrism mRectangularPrism;
        private Cylinder mCylinder;

        /**
         * Instantiates all Cal3ds dependencies
         */
        Calc3d() {
            mSphere = new Sphere();
            mRectangularPrism = new RectangularPrism();
            mCylinder = new Cylinder();
        }

        /**
         * This runs the Cal3d object
         */
        public void run() {

            Double input;

            clearPrintInputLess("Enter the radius of the sphere");
            input = scanner.nextDouble();
            mSphere.mRadius = input;

            clearPrintInputLess("Enter the diameter of the rectangular prism");
            input = scanner.nextDouble();
            mRectangularPrism.mDiameter = input;

            clearPrintInputLess("Enter the height of the rectangular prism");
            input = scanner.nextDouble();
            mRectangularPrism.mHeight = input;

            clearPrintInputLess("Enter the width of the rectangular prism");
            input = scanner.nextDouble();
            mRectangularPrism.mWidth = input;

            clearPrintInputLess("Enter the height of the cylinder");
            input = scanner.nextDouble();
            mCylinder.mHeight = input;

            clearPrintInputLess("Enter the radius of the cylinder");
            input = scanner.nextDouble();
            mCylinder.mRadius = input;

            clearPrintOutput("The surface area of the sphere is", mSphere.getSurfaceArea());
            clearPrintOutput("The volume of the sphere is", mSphere.getVolume());
            clearPrintOutput("The surface area of the rectangular prism is", mRectangularPrism.getSurfaceArea());
            clearPrintOutput("The volume of the rectangular prism is", mRectangularPrism.getVolume());
            clearPrintOutput("The surface area of the cylinder is", mCylinder.getSurfaceArea());
            clearPrintOutput("The volume of the cylinder is", mCylinder.getVolume());

        }
    }

    /**
     * Entry point
     * @param args
     */
    public static void main(String args[]) {

        // Start Cal2d
        Calc2d cal2d = new Calc2d();
        cal2d.run();


        // Start Cal3d
        Calc3d cal3d = new Calc3d();
        cal3d.run();
    }
}
