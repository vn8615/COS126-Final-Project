import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class simulator extends JPanel implements ActionListener {

    static JFrame f;
    static JButton b;

    static JTextField tau;
    static JTextField dt;
    static JTextField k;
    static JTextField m;
    static JTextField A;
    static JTextField theta;

    static JLabel tauText;
    static JLabel dtText;
    static JLabel kText;
    static JLabel mText;
    static JLabel AText;
    static JLabel thetaText;

    private static double[] values = new double[6];

    public simulator() {

    }

    private static void showGUI() {
        f = new JFrame("textfield");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b = new JButton("submit");
        simulator text = new simulator();
        b.addActionListener(text);

        tau = new JTextField(20);
        tauText = new JLabel("tau");
        dt = new JTextField(20);
        dtText = new JLabel("time interval");
        k = new JTextField(20);
        kText = new JLabel("spring constant");
        m = new JTextField(20);
        mText = new JLabel("mass");
        A = new JTextField(20);
        AText = new JLabel("amplitude");
        theta = new JTextField(20);
        thetaText = new JLabel("angle");
        JPanel p = new JPanel();

        JTextField[] fields = {tau, dt, k, m, A, theta};
        JLabel[] labels = {tauText, dtText, kText, mText, AText, thetaText};

        for (int i = 0; i < labels.length; i++) {
            String name = labels[i].getText();
            StringBuilder whiteSpace = new StringBuilder();
            int remain = 15 - name.length();
            for (int j = 0; j < remain; j++) {
                whiteSpace.append(" ");
            }
            String addSpace = whiteSpace.toString();
            name += addSpace;
            labels[i].setText(name);
        }

        p.add(tauText);
        p.add(tau);
        p.add(dtText);
        p.add(dt);
        p.add(kText);
        p.add(k);
        p.add(mText);
        p.add(m);
        p.add(AText);
        p.add(A);
        p.add(thetaText);
        p.add(theta);
        p.add(b);


        f.add(p);
        f.setSize(575, 500);
        f.pack();
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        String s = evt.getActionCommand();
        JLabel[] labels = {tauText, dtText, kText, mText, AText, thetaText};
        if (s.equals("submit")) {
            for (int i = 0; i < values.length; i++) {
                values[i] = Double.parseDouble(labels[i].getText());
            }
            for (int i = 0; i < labels.length; i++) {
                labels[i].setText("");
            }
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showGUI();
            }
        });
        double tau = values[0];
        double dt = values[1];

        double k = values[2];
        double m = values[3];
        double w = Math.sqrt(k / m);

        double A = values[4];

        double theta = values[5];

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
            bfhbd
        }

    }

    public static double[] decompose(double r, double theta) {
        return new double[]{r * Math.cos(Math.toRadians(theta)),
                r * Math.sin(Math.toRadians(theta))};
    }

}
