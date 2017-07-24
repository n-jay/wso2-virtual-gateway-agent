package org.wso2.device.mgt.plugins;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.swing.*;
import java.awt.*;

/**
 * This is the main class of the program.
 * Purpose is to create the GUI and handle major logic code
 */

public class App extends JFrame {

    public static JFrame frame;
    public static JPanel panel;
    public static JLabel text;

    //main method
    public static void main( String[] args ) {
        new App();
    }

    //constructor for the GUI app
    public App() {
        guiMain();
    }

    //primary method including all GUI components and logic
    private void guiMain() {
        frame = new JFrame("Virtual Gateway");
        frame.setVisible(true);
        frame.setSize(800,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(900, 420));
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        text = new JLabel("Hello World");

        panel.add(text);
        frame.add(panel);
    }

}
