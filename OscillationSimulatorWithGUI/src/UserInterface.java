/****************************************************************************
 *  Compilation:  javac-introcs UserInterface.java
 *  Execution:    java-introcs UserInterface
 *  Dependencies: none
 *
 *  GUI User Interface .java class for this program. Displays a GUI and then
 *  collects user input then stores the input into a state variable array.
 ******************************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JPanel implements ActionListener {
    // declare instance variables for swing elements: frame, button, text fields, labels
    // for convenience purposes, some basic naming conventions are borrowed from GeeksforGeeks,
    // including f for JFrame and b for JButton.
    // Source: https://www.geeksforgeeks.org/java-swing-jtextfield/
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

    // GridLayout techniques learned and adapted from https://bit.ly/3KCCt2k
    // Swing GUI is a fairly standard practice and my code was largely consulted from https://bit.ly/3KCCt2k and
    // https://www.geeksforgeeks.org/java-swing-jtextfield/. Lines of code are excerpted or adapted throughout whenever
    // they resemble the general structure; more explicit borrowings are cited.
    GridLayout layout = new GridLayout(0, 2);

    // declare and initialize array to store the physical values from Swing input
    private double[] values = new double[7];

    // declare and initialize boolean for whether "submit" has been pressed
    // Variable set to volatile so that it's updated universally into main memory
    // Purpose is because we are running two threads: StdDraw and the Swing GUI with
    // the StdDraw's behavior depending on the Swing GUI. So here the volatile keyword
    // ensures that both threads are on the same page whenever submit is pressed.
    // consultation from https://jenkov.com/tutorials/java-concurrency/volatile.html
    private volatile boolean hasSubmitted = false;

    // method for showing the Swing GUI
    public void showGUI() {
        // initialize instance variables to sizes, names and other settings; add
        // Action Listener to submit button

        // method use adapted from https://bit.ly/3KCCt2k
        f = new JFrame("inputs");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // implementation of JButton(), addActionListener() from https://www.geeksforgeeks.org/java-swing-jtextfield/
        b = new JButton("Submit");
        b.addActionListener(this);

        tau = new JTextField(20);
        tauText = new JLabel("Tau (seconds)");
        dt = new JTextField(20);
        dtText = new JLabel("Time interval (seconds)");
        k = new JTextField(20);
        kText = new JLabel("Spring constant (N/m)");
        m = new JTextField(20);
        mText = new JLabel("Mass (kg)");
        A = new JTextField(20);
        AText = new JLabel("Amplitude (m)");
        theta = new JTextField(20);
        thetaText = new JLabel("Angle (degrees)");
        beta = new JTextField(20);
        betaText = new JLabel("Beta (kg/s)");
        JPanel p = new JPanel();
        p.setLayout(layout);

        // create another panel for button
        // formatting, panel separation learned from https://bit.ly/3KCCt2k
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
        // BorderLayout suggestions adapted from https://bit.ly/3KCCt2k
        f.add(p, BorderLayout.CENTER);
        f.add(pButton, BorderLayout.SOUTH);

        // Set window size to 500x500
        f.setSize(500, 500);

        // centers the window on the screen
        f.setLocationRelativeTo(null);

        f.setVisible(true);
    }

    // determines actions following user input event
    public void actionPerformed(ActionEvent e) {
        // store command from action event in s
        // structure and syntax adapted from https://www.geeksforgeeks.org/java-swing-jtextfield/
        String action = e.getActionCommand();
        JTextField[] fields = {tau, dt, k, m, A, theta, beta};

        // store input values in instance array "values" and reset text fields to empty
        if (action.equals("Submit")) {
            for (int i = 0; i < values.length; i++) {
                values[i] = Double.parseDouble(fields[i].getText());
            }
            for (JTextField i : fields) {
                i.setText("");
            }
            // hasSubmitted becomes true
            hasSubmitted = true;

            // Test
            System.out.println("Submit Button Pressed");
            System.out.print("The values are: ");

            for (double i : values) {
                System.out.print(i + ", ");
            }
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

    // Main method use for testing!
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        // Should print false
        System.out.println(ui.getHasSubmitted());

        ui.setHasSubmitted(true);
        // Should print true since we changed the value
        System.out.println(ui.getHasSubmitted());

        // Displays the GUI. Everytime we hit submit, the program
        // should print "Submit Button Pressed" then "The values are: "
        ui.showGUI();
    }
}
