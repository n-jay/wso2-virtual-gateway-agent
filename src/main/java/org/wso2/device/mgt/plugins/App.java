package org.wso2.device.mgt.plugins;

import org.apache.commons.lang3.StringEscapeUtils;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 * This is the main class of the program.
 * Purpose is to create the GUI and handle major logic code
 */

public class App extends JFrame {

    //URL and credentials for DB access
    String url = "jdbc:mysql://localhost:3306/demo";
    String uName = "root";
    String passWrd = "";


    public static JFrame frame;
    public static JPanel panel;
    public static JLabel text;

    //main method
    public static void main( String[] args ) {
        new App();
    }

    //constructor for the GUI app
    public App() {
        connTest();

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
        text = new JLabel("Sample Text");

        panel.add(text);
        frame.add(panel);
    }


    private void connTest() {
        try {
            //1.get connection to database
            Connection myConn = DriverManager.getConnection(url,uName,passWrd);

            //2.create statement
            Statement myStat = myConn.createStatement();

            //3.SQL query
            ResultSet myRs = myStat.executeQuery("SELECT * FROM employees");
//            System.out.print("SUCCESS!");

            //4.process the result set
            while(myRs.next()) {
                System.out.println(myRs.getString("last_name") +  "," + myRs.getString("first_name"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
