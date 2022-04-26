public class simulator {
    public static void main(String[] args) {
        double tau = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        double k = Double.parseDouble(args[2]);
        double m = Double.parseDouble(args[3]);
        double w = Math.sqrt(k / m);

        double A = Double.parseDouble(args[4]);

        double theta = Double.parseDouble(args[5]);

        double a = 0;
        double v = 0;
        double r = A;

        StdDraw.setXscale(-5, 5);
        StdDraw.setYscale(-5, 5);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.WHITE);

        for (double t = 0; t < tau; t += dt) {

            // Step 5B. Update velocities and positions.
            a = -w * w * r;
            v += a * dt;
            r += v * dt;

            // Step 5C. Draw universe to standard drawing.
            double[] decomposition = decompose(r, theta);

            StdDraw.picture(0, 0, "starfield.jpg"); //change background
            StdDraw.line(0, 0, decomposition[0], decomposition[1]);//change to spring like shape
            StdDraw.square(decomposition[0], decomposition[1], 0.1);
            StdDraw.show();
            StdDraw.pause(20);
        }

    }

    public static double[] decompose(double r, double theta) {
        return new double[]{r * Math.cos(Math.toRadians(theta)),
                r * Math.sin(Math.toRadians(theta))};
    }

}
