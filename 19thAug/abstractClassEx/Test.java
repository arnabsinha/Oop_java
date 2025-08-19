// Abstract class Shape, serving as a blueprint for specific shape classes
abstract class Shape {
    // Name of the shape
    String objectName = " "; 

    // Constructor to initialize the name of the shape
    Shape(String name) {
        this.objectName = name;
    }

    // Concrete method to move the shape to a new position
    public void moveTo(int x, int y) {
        System.out.println(this.objectName + " has been moved to x = " + x + " and y = " + y);
    }

    // Abstract method to calculate the area of the shape
    abstract public double area();

    // Abstract method to draw the shape
    abstract public void draw();
}

// Rectangle class extending Shape and providing its own implementation
class Rectangle extends Shape {
     // Dimensions of the rectangle
    int length, width;

    // Constructor to initialize the rectangle's dimensions and name
    Rectangle(int length, int width, String name) {
        super(name);
        this.length = length;
        this.width = width;
    }

    // Implementation of draw method for rectangle
    @Override 
    public void draw() {
        System.out.println("Rectangle has been drawn ");
    }

    // Implementation of area method for rectangle
    @Override 
    public double area() {
        return (double)(length * width);
    }
}

// Circle class extending Shape and providing its own implementation
class Circle extends Shape {
    // Value of pi for circle area calculation
    double pi = 3.14; 
    // Radius of the circle
    int radius; 

    // Constructor to initialize the circle's radius and name
    Circle(int radius, String name) {
        super(name);
        this.radius = radius;
    }

    // Implementation of draw method for circle
    @Override 
    public void draw() {
        System.out.println("Circle has been drawn ");
    }

    // Implementation of area method for circle
    @Override 
    public double area() {
        return (double)(pi * radius * radius);
    }
}

// Main class to test the functionality of the shape classes
public class Test {
    public static void main(String[] args) {
        // Creating a Rectangle object and demonstrating its behavior
        Shape rect = new Rectangle(2, 3, "Rectangle");
        System.out.println("Area of rectangle: " + rect.area());
        rect.moveTo(1, 2);

        System.out.println();

        // Creating a Circle object and demonstrating its behavior
        Shape circle = new Circle(2, "Circle");
        System.out.println("Area of circle: " + circle.area());
        circle.moveTo(2, 4);
    }
}
