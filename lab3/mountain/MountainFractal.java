package mountain;

import java.util.Iterator;
import java.util.LinkedList;

import fractal.*;
import mountain.Side;

public class MountainFractal extends Fractal {
	private Point point1, point2, point3;
	double dev;
	LinkedList<Side> history;

	/**
	 * Creates an object that handles Koch's fractal.
	 * 
	 * @param length
	 *            the length of the triangle side
	 */
	public MountainFractal(Point point1, Point point2, Point point3, Double dev) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.dev = dev;
		history = new LinkedList<Side>();

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
		fractalLine(turtle, order, point1, point2, point3, dev);
	}

	/*
	 * Reursive method: Draws a recursive line of the triangle.
	 */
	private void fractalLine(TurtleGraphics turtle, int order, Point p1,
			Point p2, Point p3, double dev) {
		if (order == 0) {
			turtle.moveTo(p1.getX(), p1.getY());
			turtle.forwardTo(p2.getX(), p2.getY());
			turtle.forwardTo(p3.getX(), p3.getY());
			turtle.forwardTo(p1.getX(), p1.getY());
		} else {
			Point ab = haveBeenCalc(p1, p2, dev);
			Point bc = haveBeenCalc(p2, p3, dev);
			Point ca = haveBeenCalc(p3, p1, dev);

//			if (ab == null) {
//				
//			}
//			if (bc == null) {
//				bc = new Point((p2.getX() + p3.getX()) / 2,
//						((p2.getY() + p3.getY()) / 2)
//								+ RandomUtilities.randFunc(dev));
//
//				list.add(new Side(p2, p3, bc));
//			}
//			if (ca == null) {
//				ca = new Point((p1.getX() + p3.getX()) / 2,
//						((p1.getY() + p3.getY()) / 2)
//								+ RandomUtilities.randFunc(dev));
//
//				list.add(new Side(p3, p1, ca));
//			}
			dev = dev/2;

			fractalLine(turtle, order - 1, p1, ab, ca, dev);
			fractalLine(turtle, order - 1, p2, bc, ab, dev);
			fractalLine(turtle, order - 1, p3, ca, bc, dev);
			fractalLine(turtle, order - 1, ab, ca, bc, dev);

		}

	}

	private Point haveBeenCalc(Point start,
			Point dest, double dev) {
		Iterator<Side> it = history.iterator();
		while (it.hasNext()) {
			Side temp = it.next();
			if (temp.getStart() == start && temp.getDest() == dest
					|| temp.getStart() == dest && temp.getDest() == start) {
				it.remove();
				return temp.getMiddle();
			}
		}
		Point temp = new Point((start.getX() + dest.getX()) / 2,
						((start.getY() + dest.getY()) / 2)
								+ RandomUtilities.randFunc(dev));

				history.add(new Side(dest, start, temp));
		return temp;
	}

}
