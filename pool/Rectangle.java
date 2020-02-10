package pool;

public class Rectangle {
	private double width;
	private double lenght;

	public Rectangle(double width, double lenght) {
		if (width < 0) {
			width = 0;
		}
		if (lenght < 0) {
			lenght = 0;
		}

		this.width = width;
		this.lenght = lenght;
	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return lenght;
	}

	public double getArea() {
		return lenght * width;
	}

}
