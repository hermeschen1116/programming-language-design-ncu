abstract class Shape {

	protected String color;
	protected double x;
	protected double y;

	public abstract double calculateArea();

	public abstract double calculatePerimeter();

	public abstract boolean isOverlapping(Shape other);

	public void setCoordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String getCoordinates() {
		return String.format("(%.1f, %.1f)", this.x, this.y);
	}
}

interface Color {
	void setColor(String color);
	String getColor();
}

class Square extends Shape implements Color {

	public double sideLength;

	Square(double sideLength) {
		this.sideLength = sideLength;
	}

	public double calculateArea() {
		return this.sideLength * this.sideLength;
	}

	public double calculatePerimeter() {
		return this.sideLength * 4;
	}

	public boolean isOverlapping(Shape other) {
		if (
			(other.x > super.x) &
			(other.x < (super.x + this.sideLength)) &
			(other.y < super.y) &
			(other.y > (super.y + this.sideLength))
		) {
			return true;
		}
		return false;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}
}

class Rectangle extends Shape implements Color {

	public double width;
	public double length;

	Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	public double calculateArea() {
		return this.width * this.length;
	}

	public double calculatePerimeter() {
		return (this.width + this.length) * 2;
	}

	public boolean isOverlapping(Shape other) {
		if (
			(other.x > super.x) &
			(other.x < (super.x + this.width)) &
			(other.y < super.y) &
			(other.y > (super.y + this.length))
		) {
			return true;
		}
		return false;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}
}

// please don't modify the testcases below

public class Main {

	public static void main(String[] args) {
		Square square = new Square(6);
		square.setColor("Red");
		square.setCoordinates(10, 15);
		System.out.println("square Area: " + square.calculateArea());
		System.out.println("square Perimeter: " + square.calculatePerimeter());
		System.out.println("square Color: " + square.getColor());
		System.out.println("square Coordinates: " + square.getCoordinates());

		Rectangle rectangle = new Rectangle(11, 25);
		rectangle.setColor("Blue");
		rectangle.setCoordinates(-5, -8);
		System.out.println("rectangle Area: " + rectangle.calculateArea());
		System.out.println("rectangle Perimeter: " + rectangle.calculatePerimeter());
		System.out.println("rectangle Color: " + rectangle.getColor());
		System.out.println("rectangle Coordinates: " + rectangle.getCoordinates());

		Shape anotherRectangle = new Rectangle(3, 4);
		anotherRectangle.setCoordinates(0, 0);
		System.out.println("anotherRectangle Area: " + anotherRectangle.calculateArea());
		System.out.println("anotherRectangle Perimeter: " + anotherRectangle.calculatePerimeter());
		System.out.println("anotherRectangle Coordinates: " + anotherRectangle.getCoordinates());

		Color color = new Square(12);
		color.setColor("Green");
		System.out.println("Color: " + color.getColor());

		System.out.println("square and rectangle overlap: " + square.isOverlapping(rectangle));
		System.out.println("rectangle and anotherRectangle overlap: " + rectangle.isOverlapping(anotherRectangle));
		System.out.println("anotherRectangle and square overlap: " + anotherRectangle.isOverlapping(square));
	}
}
