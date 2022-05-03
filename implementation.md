# COS126 Final Project: Implementation

Please complete the following questions and upload this `implementation.md`
file to the TigerFile assignment for the "Final Project Implementation".

**Do not alter the formatting**
(e.g. write your answer after the asterisks ** FIELD NAME ** or on the next
line after the header ### HEADER NAME). We have filled in a dummy response
for the first question in the first two sections as an example.

## Basic Information

You may copy and paste your answers from questions 1-8 in the status update.

1. **Name 1:** Vincent Nguyen


2. **NetID 1:** vn8615


3. **Name 2 (include if pair project):** Aster Zhang


4. **NetID 2 (include if pair project):** brentonz


5. **Project preceptor name:** Gianluca Bencomo


6. **Project title:** OscillationSimulatorWithGUI


7. **CodePost link for proposal:** https://codepost.io/code/566909


8. **CodePost link for revised proposal (include if submitted):** https://codepost.io/code/575840


9. **CodePost link for status update:** https://codepost.io/code/581939


10. **Link to project video:** https://youtu.be/92gO_ntuO6s


11. **Number of hours to complete implementation:** 25


## Required Questions

### A. Describe your implemented project in a few sentences below.

Our final project takes user input for seven parameters - tau, dt, spring constant, mass, amplitude, spring angle, and
damping constant - using Swing GUI and outputs spring motion based on these parameters to StdDraw in the form of a
spring (presented as a line with a weighted block at the end) against a table backdrop.

The output plays Olivia Rodrigo's "good 4 u" when the code is run, and the program runs indefinitely while restarting
upon new user input.

### B. Describe your three features.
*Be specific in your description of each feature.
In particular, specify **where** they are implemented
(e.g. .java file name, starting and ending line numbers, method names, etc.).*

  1. Takes user input for the seven parameters listed above using Swing GUI


  2. Simulates spring motion with damping based on the given damping constant


  3. Outputs spring motion to StdDraw while allowing continued user input and restarting; also uses StdAudio


### C. Describe in detail how to compile and run your program.
*Include a few example run commands and the expected results of running your program.
For non-textual outputs (e.g. graphical or auditory), feel free to describe in
words what the output should be or reference output files (e.g. images, audio files)
of the expected output.*

Complile Simulator.java and UserInterface.java. Run UserInterface.java with no command-line inputs.
Input requisite values into Swing GUI (recommended: tau = 100 and dt = 0.1) and hit "Submit".
StdDraw will output a small window in which spring motion is simulated against a wooden table from a bird's-eye view
while Olivia Rodrigo's "good 4 u" plays in the background.
To reset motion, input a new set of values and hit "Submit"; the program will stop the previous simulation and begin
the new one.

### D. Describe how your program accepts user input
*Mention the line number(s) at which your program accepts user input.*

Our program accepts user input via a number of text fields in Swing GUI.
The concrete action of transferring user input to the program takes place in lines 116-119 of UserInterface.java,
wherein we use getText() to collect the values in the current text fields and transfer them to an array for further
use.

### E. Describe how your program produces output based on user input
*Mention the line number(s) at which your program produces output.*

In the model() method in Simulator.java, we recover the individual parameters from the values[] array and calculate
the required omega and gamma values for motion and damping. Based on this input, we then use StdDraw to illustrate
the motion of a spring using a line and a filled square according to user input for mass and amplitude. We use line()
to draw the line.

Actual output happens in lines 77-82 of Simulator.java and also lines 132-137 for an overloaded testing method.

### F. Describe the data structure your program uses
*Also describe how it supports your program's functionality.
Include the variable name and the line number(s) at which it is declared
and initialized).*

We use a number of arrays over the course of both programs.

values[]: Declared and initialized on line 39 of UserInterface.java. Contains the values of the seven parameters,
collected from user input via Swing GUI.

fields[]: Declared and initialized on line 81 of UserInterface.java. Contains the seven text fields
labels[]: Declared and initialized on line 82 of UserInterface.java.

decomposition[]: Declared and initialized on line 129 of Simulator.java.



### G. List the two custom methods written by your project group
*Include method signatures and line numbers.
If your project group wrote more than two custom functions, choose the
two functions that were most extensively tested.*

1. public static double[] decompose(double r, double theta) (lines 149-152 of Simulator.java)

2. public static void model(double[] values) (lines 94-144 of Simulator.java)

### H. List the line numbers where you test each of your two custom methods twice.
*For each of the four tests (two for each method), explain what was being
tested and the expected result. For non-textual results (e.g. graphical or
auditory), you may describe in your own words what the expected result
should be or reference output files (e.g. images, audio files).*

All below lines reference Simulator.java.

1. Lines 19-20 test decompose() with expected output (0.707, 0.707).

2. Lines 21-22 test decompose() with expected output (0.0, 1.0).

3. Line 17 tests model() with expected output of a StdDraw window with a spring of amplitude 5 that is vertical.

4. Line 18 tests model() with expected output of a StdDraw window with a spring of amplitude 5, 40 degrees from vertical.


## Citing Resources

### A. List below *EVERY* resource your project group looked at
*Bullet lists and links suffice.*

https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html

https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html

https://docs.oracle.com/javase/tutorial/uiswing/layout/flow.html

https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html

https://www.geeksforgeeks.org/java-swing-jtextfield/

https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html#ListDialog

https://docs.oracle.com/javase/tutorial/uiswing/components/button.html

https://docs.oracle.com/javase/tutorial/uiswing/start/index.html

https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/GridLayoutDemoProject/src/layout/GridLayoutDemo.java

https://stackoverflow.com/questions/28017323/how-to-accept-user-input-in-gui-java

https://docs.oracle.com/javase/tutorial/uiswing/components/editorpane.html

https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html

https://docs.oracle.com/javase/tutorial/uiswing/components/buttongroup.html

https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html

https://www.tutorialspoint.com/swingexamples/show_input_dialog_text.htm

https://jenkov.com/tutorials/java-concurrency/volatile.html

### B. Did you cite every resource that influenced your code in the code itself?
*Every resource that informed your code should be cited in a comment at/near the
line(s) of code that it informed.*

**Yes or No?** Yes

### C. Did you receive help from classmates, past COS 126 students, or anyone else?
*If so, please list their names. ("A Sunday lab TA" or "Office hours on
Thursday" is ok if you don't know their name.)*

**Yes or No?** No



### D. Did you encounter any serious problems? If so, please describe.

**Yes or No?** No




### E. List any other comments here. ###

It was a pleasure to work on this project.


## Submission Checklist
*Please mark that you’ve done all of the following steps
(fill in square bracket with x, i.e. [x]):*

* [X] Created a project.zip file, unzipped its contents, and checked that our
    compile and run commands work on the unzipped contents. Ensure that the .zip
    file is under 50MB in size.
* [X] Created and uploaded a Loom or YouTube video that...
  * [X] is maximum 2 minutes in length
  * [X] demonstrates live your program's input(s) and output(s)
  * [X] demonstrates live your 3 features
  * [X] does **not** reveal any code
  * [X] includes your project name and the name of each student
  * [X] has its thumbnail and/or starting frame set to an image of your program
        or a title slide
  * [X] is publicly viewable (check in an incognito browser)
  * [X] is linked to in this `implementation.md` file (Q10 under Basic Information)
* [X] Uploaded all .java files to TigerFile. Each .java file should be uploaded
      separately as an additional file.
* [X] Uploaded project.zip file to TigerFile.

*After you’ve submitted the above on TigerFile, **remember to do the following**:*
* [X] Complete and upload this `implementation.md` file to TigerFile.
* [X] Complete and submit this Google Form
    (https://forms.cs50.io/27ca51e0-4d81-4d97-8621-ba1e5d26cd78).


## Partial Credit: Bug Report(s)
*For partial credit for buggy features, you may include a bug report for at
most 4 bugs that your project group was not able to fix before the submission
deadline. For each bug report, copy and paste the following questions and
answer them in full. Your bug report should be detailed enough for the grader
to reproduce the bug.*

***Note:** if your code appears bug-free, you should **not** submit any bug reports.*

### BUG REPORT #1:
**1. Describe in a sentence or two the bug below.**




**2. Describe in detail how to reproduce the bug (e.g. run commands, user input,
etc.).**




**3. Describe the resulting effect of bug and provide evidence
(e.g. copy-and-paste the buggy output, reference screenshot files and/or buggy
output files, include a Loom video of reproducing and showing the effects of
the bug, etc.).**




**4. Describe where in your program code you believe the bug occurs (e.g. line
numbers).**




**5. Please describe what steps you tried to fix the bug.**





## Extra Credit

### A. Going above and beyond the scope of COS126

#### Did your program go above and beyond the scope of COS126?

**Yes or No?** YES

*If yes, please answer the following question.*

#### Describe in detail how your program went above and beyond the scope of COS126.

We use the Swing GUI to accept input and output, and we also make use of volatility/threads/concurrency so that our
program can run continuously and reset output every time "Submit" is pressed on Swing GUI.

In other words, our program updates a "hasSubmitted" boolean instance variable
universally using the voltaile keyword.

### B. Runtime Analysis

#### Did you analyze the efficiency of a substantial component of your project?

**Yes or No?** YES

*If yes, please answer the following questions.*

**1. Specify the scope of the component you are analyzing
(e.g. function name, starting and ending lines of specific .java file).**

public static void model(double[] values) (lines 94-144 of Simulator.java)

**2. What is the estimated runtime (e.g. big-O complexity) of this component?
Provide justification for this runtime (i.e. explain in your own words why
you expect this component to have this runtime performance).**

linear (n). This has a linear runtime big-O complexity because it only has one
singular for loop that loops over a set given Tau and dt. Therefore, it is linear.

**3. Provide experimental evidence in the form of timed analysis supporting this
runtime estimate. (Hint: you may find it helpful to use command-line
arguments/flags to run just the specified component being analyzed).**


### C. Packaging project as an executable .jar file

#### Did you package your project as an executable .jar file?

**Yes or No?** Yes

*If yes, please answer the following question.*

#### Describe in detail how to execute your .jar application (e.g. what execution command to use on the terminal).
*Include a few example execution commands and the expected results of running
your program. For non-textual outputs (e.g. graphical or auditory), feel free
to describe in words what the output should be or reference output files
(e.g. images, audio files) of the expected output.*

The jar file is extremely simple to run. the Jar file does not have test cases
so its just the simulator. When you open the jar file it gives you a Swing GUI
wherein you can input your desired simulation values. Once you hit submit a model
will be displayed accordingly. The program runs indefinitely and you can resubmit
new values anytime you wish. If you do so while the previous model is still taking place
it simply replaces that old model and starts with the new one you just submit.
