package homework2;

public class Wall {

	private double width;
	private double height;

	public Wall() {

	}

	public Wall(double weight, double height) {
		setWidth(weight);
		setHeight(height);

	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double weight) {
		if (weight < 0) {
			weight = 0;
		}
		this.width = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height < 0) {
			height = 0;
		}
		this.height = height;
	}

	public double getArea() {
		return height * width;
	}

}
