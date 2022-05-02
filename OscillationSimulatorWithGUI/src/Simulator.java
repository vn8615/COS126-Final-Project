public class Simulator {

    // runs GUI; when values submitted, runs model method and sets hasSubmitted false for user interface
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.showGUI();
        while (true) {
            if (ui.getHasSubmitted()) {
                ui.setHasSubmitted(false);
                model(ui.getValues(), ui);
            }
        }
    }

    // draws spring motion for a given tau, dt, spring constant, mass, amplitude, theta, damping constant from input
    public static void model(double[] values, UserInterface ui) {

        // set requisite values to the user inputs from array values[]
        double tau = values[0];
        double dt = values[1];

        double k = values[2];
        double m = values[3];
        // where necessary, calculate auxiliary values (omega, gamma)
        double w = Math.sqrt(k / m);

        double A = values[4];

        double theta = values[5];

        double beta = values[6];
        double gamma = beta / (2 * m);

        // dictate motion based on a, v, r (= A)
        double a = 0;
        double v = 0;
        double r = A;

        // set StdDraw window and drawing settings
        StdDraw.setXscale(-5, 5);
        StdDraw.setYscale(-5, 5);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.01);

        // iterate through time (for given dt interval) with new spring position, velocity, and length
        for (double t = 0; t < tau; t += dt) {
            if (ui.getHasSubmitted())
                break;

            a = -w * w * r - 2 * gamma * v;
            v += a * dt;
            r += v * dt;

            double[] decomposition = decompose(r, theta);

            // draw background, spring, and animate motion
            StdDraw.picture(0, 0, "table.jpg");
            StdDraw.line(0, 0, decomposition[0], decomposition[1]);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(decomposition[0], decomposition[1], 0.25);
            StdDraw.show();
            StdDraw.pause(20);
        }
    }

    // decomposes the length of the spring into horizontal and vertical components
    public static double[] decompose(double r, double theta) {
        return new double[]{r * Math.cos(Math.toRadians(theta)),
                r * Math.sin(Math.toRadians(theta))};
    }

}
