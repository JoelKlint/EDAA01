package fractal;

import koch.Koch;
import mountain.Point;
import mountain.MountainFractal;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1] = new MountainFractal(new Point(100, 400), new Point(250,200), new Point(400, 450), 50.0);
		new FractalView(fractals, "Fraktaler");
	}

}
