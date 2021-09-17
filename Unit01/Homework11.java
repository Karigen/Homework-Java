package Unit01;

import com.sin.java.plot.Plot;

public class Homework11 {

    public static void main(String[] args) {
	Plot.figrue();
	Plot.hold_on();
	
	int len = 70;
	double[] y1 = new double[len];
	for (int i = 0; i < y1.length; i++) {
		y1[i] = Math.sin(i / 10.0f);
	}
	Plot.plot(y1, "-b");
    }

}
