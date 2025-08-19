// Interface defining the method to draw an object
interface Drawable {
    void draw();
}

// Interface defining the method to move an object to a new position
interface Movable {
    void moveTo(int x, int y);
}

// Circle class implementing both Drawable and Movable interfaces
class Circle implements Drawable, Movable {
    double pi = 3.14; // Value of Pi for circle calculations
    int radius; // Radius of the circle

    // Constructor to initialize the radius of the circle
    Circle(int radius) {
        this.radius = radius;
    }

    // Implementation of the draw method from Drawable interface
    @Override 
    public void draw() {
        System.out.println("Circle has been drawn ");
    }

    // Implementation of the moveTo method from Movable interface
    @Override 
    public void moveTo(int x, int y) {
        System.out.println("Circle has been moved to x = " + x + " and y = " + y);
    }
}

// Main class to test the implementation of Circle class
public class Test {
    public static void main(String[] args) {
        // Create a Circle object
        Circle circle = new Circle(2);
        
        // Call the draw method
        circle.draw();
        
        // Call the moveTo method
        //circle.moveTo(2, 4);

    }
}
