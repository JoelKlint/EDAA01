package mountain;

import fractal.*;

public class MountainFractaldsa extends Fractal {
	private Point point1, point2, point3;
	double dev;

	/**
	 * Creates an object that handles Koch's fractal.
	 * 
	 * @param length
	 *            the length of the triangle side
	 */
	public MountainFractaldsa(Point point1, Point point2, Point point3, Double dev) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.dev = dev;
	}

	/**
	 * Returns the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return "Mountain Fractal";
	}

	/**
	 * Draws the fractal.
	 * 
	 * @param turtle
	 *            the turtle graphic object
	 */
	public void draw(TurtleGraphics turtle) {
		 fractalLine(turtle, order, point1, point2);
		 fractalLine(turtle, order, point2, point3);
		 fractalLine(turtle, order, point3, point1);
	}

	/*
	 * Reursive method: Draws a recursive line of the triangle.
	 */
	private void fractalLine(TurtleGraphics turtle, int order, Point p1,
			Point p2) {
		if (order == 0) {
			turtle.moveTo(p1.getX(), p1.getY());
			turtle.forwardTo(p2.getX(), p2.getY());
		} else {
			Point temp = new Point((p2.getX() + p1.getX()) / 2,
					((p2.getY() + p1.getY()) / 2) + RandomUtilities.randFunc(dev));
			dev = dev/2;

			fractalLine(turtle, order - 1, p1, temp);
			fractalLine(turtle, order - 1, temp, p2);

		}

	}

}
