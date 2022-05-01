import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JPanel implements ActionListener {
    private JFrame f;
    private JButton b;

    private JTextField tau;
    private JTextField dt;
    private JTextField k;
    private JTextField m;
    private JTextField A;
    private JTextField theta;
    private JTextField beta;

    private JLabel tauText;
    private JLabel dtText;
    private JLabel kText;
    private JLabel mText;
    private JLabel AText;
    private JLabel thetaText;
    private JLabel betaText;

    private double[] values = new double[7];

    private volatile boolean hasSubmitted = false;

    public void showGUI() {
        f = new JFrame("textfield");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b = new JButton("submit");
        b.addActionListener(this);

        //TODO: capitalize!
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
        beta = new JTextField(20);
        betaText = new JLabel("beta");
        JPanel p = new JPanel();

        JTextField[] fields = {tau, dt, k, m, A, theta, beta};
        JLabel[] labels = {tauText, dtText, kText, mText, AText, thetaText, betaText};

        for (int i = 0; i < fields.length; i++) {
            p.add(labels[i]);
            p.add(fields[i]);
        }
        p.add(b);

        f.add(p);

        //TODO: Adjust window to look nice upon opening. I removed the pack already.
        //TODO: Also position text so that it centers itself on the window, do two columns then go two inputs per *line*
        f.setSize(575, 500);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        //TODO: capitalize!
        String s = evt.getActionCommand();
        JTextField[] fields = {tau, dt, k, m, A, theta, beta};
        if (s.equals("submit")) {
            for (int i = 0; i < values.length; i++) {
                values[i] = Double.parseDouble(fields[i].getText());
            }
            for (JTextField i : fields) {
                i.setText("");
            }
            hasSubmitted = true;
        }
    }

    public boolean getHasSubmitted() {
        return hasSubmitted;
    }

    public double[] getValues() {
        return values;
    }

    public void setHasSubmitted(boolean hasSubmitted) {
        this.hasSubmitted = hasSubmitted;
    }
}
