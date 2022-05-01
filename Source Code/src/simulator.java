public class simulator {

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

    public static void model(double[] values, UserInterface ui) {

        double tau = values[0];
        double dt = values[1];

        double k = values[2];
        double m = values[3];
        double w = Math.sqrt(k / m);

        double A = values[4];

        double theta = values[5];

        double beta = values[6];
        double gamma = beta / (2 * m);

        double a = 0;
        double v = 0;
        double r = A;

        //TODO: Change brush stroke (thickness etc) to make it look good!!
        StdDraw.setXscale(-5, 5);
        StdDraw.setYscale(-5, 5);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.BLUE);

        for (double t = 0; t < tau; t += dt) {
            if (ui.getHasSubmitted())
                break;

            a = -w * w * r - 2 * gamma * v;
            v += a * dt;
            r += v * dt;

            double[] decomposition = decompose(r, theta);

            //TODO: choose another background shall you wish!
            StdDraw.picture(0, 0, "jadwin.jpg");
            StdDraw.line(0, 0, decomposition[0], decomposition[1]);
            StdDraw.filledSquare(decomposition[0], decomposition[1], 0.1);
            StdDraw.show();
            StdDraw.pause(20);
        }
    }

    public static double[] decompose(double r, double theta) {
        return new double[]{r * Math.cos(Math.toRadians(theta)),
                r * Math.sin(Math.toRadians(theta))};
    }

}
