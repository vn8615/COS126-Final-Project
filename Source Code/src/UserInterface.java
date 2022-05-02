import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JPanel implements ActionListener {
    // declare instance variables for swing elements: frame, button, text fields, labels
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

    GridLayout layout = new GridLayout(0, 2);

    // declare and initialize array to store values from Swing input
    private double[] values = new double[7];

    // declare and initialize boolean for whether "submit" has been pressed
    private volatile boolean hasSubmitted = false;

    // method for showing the Swing GUI
    public void showGUI() {
        // initialize instance variables to sizes, names and other settings; add Action Listener to submit button
        f = new JFrame("inputs");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b = new JButton("Submit");
        b.addActionListener(this);

        tau = new JTextField(20);
        tauText = new JLabel("Tau (seconds)");
        dt = new JTextField(20);
        dtText = new JLabel("Time interval (seconds)");
        k = new JTextField(20);
        kText = new JLabel("Spring constant (N/m)");
        m = new JTextField(20);
        mText = new JLabel("Mass (g)");
        A = new JTextField(20);
        AText = new JLabel("Amplitude (m)");
        theta = new JTextField(20);
        thetaText = new JLabel("Angle (degrees)");
        beta = new JTextField(20);
        betaText = new JLabel("Beta (kg/s)");
        JPanel p = new JPanel();
        p.setLayout(layout);

        // create another panel for button
        JPanel pButton = new JPanel();

        // store text fields and labels in arrays for easy addition to panel
        JTextField[] fields = {tau, dt, k, m, A, theta, beta};
        JLabel[] labels = {tauText, dtText, kText, mText, AText, thetaText, betaText};

        // add text fields and labels to first panel
        for (int i = 0; i < fields.length; i++) {
            p.add(labels[i]);
            p.add(fields[i]);
        }

        // add button to corresponding panel
        pButton.add(b);

        // add respective panels to JFrame with proper layout, present frame
        f.add(p, BorderLayout.CENTER);
        f.add(pButton, BorderLayout.SOUTH);

        f.setSize(500, 500);
        f.setVisible(true);
    }

    // determines actions following user input event
    public void actionPerformed(ActionEvent evt) {
        // store command from action event in s
        String s = evt.getActionCommand();
        JTextField[] fields = {tau, dt, k, m, A, theta, beta};

        // store input values in instance array "values" and reset text fields to empty
        if (s.equals("Submit")) {
            for (int i = 0; i < values.length; i++) {
                values[i] = Double.parseDouble(fields[i].getText());
            }
            for (JTextField i : fields) {
                i.setText("");
            }
            // hasSubmitted becomes true
            hasSubmitted = true;
        }
    }

    // return value of hasSubmitted
    public boolean getHasSubmitted() {
        return hasSubmitted;
    }

    // return array of input values
    public double[] getValues() {
        return values;
    }

    // set the hasSubmitted value of the object to the existing hasSubmitted
    public void setHasSubmitted(boolean hasSubmitted) {
        this.hasSubmitted = hasSubmitted;
    }
}
