/*WAP to design a GUI for stop watch which provides the buttons to START/STOP and PAUSE/RESUME such that the relevant functionalities are implemented to visualize the STOP-WATCH
 with Minutes, Seconds and Milli-Seconds components of Time. [Use Swing and Event Handling] */

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

public class MyGUI {
   static int min = 0, sec = 0, mili = 0; static boolean flag = true;// timer variables
   public static void main(String args[])
     {
        JFrame f = new JFrame();
        f.setSize(650,600);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.setVisible(true);
        f.setLocationRelativeTo(null);

        /*//Adding Background image to the frame
        ImageIcon ic = new ImageIcon("D:/Coding/Java/JAVA Desktop Development Course using Swing and JDBC/background.jpg"); // ImageIcon object ic holds the background image
        JLabel l1 = new JLabel(ic); // label l1 to hold the ImageIcon object ic
        f.setContentPane(l1); // Background image in label l1 is added to the content pane of frame f */
        
        //Adding Icon image to the frame
        ImageIcon ic1 = new ImageIcon("D:/Coding/Java/JAVA Desktop Development Course using Swing and JDBC/icon.jpg"); // ImageIcon object ic1 to hold the icon image
        f.setIconImage(ic1.getImage());

        JPanel p = new JPanel(); // To add START STOP button
        JButton b1 = new JButton("START"); // b1 START button
        JButton b2 = new JButton("STOP");  // b2 STOP button
        JButton b3 = new JButton("RESET");  // b3 RESET button
        p.add(b1); // adding button b1 to panel p
        p.add(b2); // adding button b2 to panel p
        p.add(b3); // adding button b3 to panel p

        JLabel l = new JLabel("STOPWATCH",JLabel.CENTER); // A label to display text STOPWATCH
        JLabel timer = new JLabel(); // A label to display the timer (minutes, seconds, mili-seconds)

        Font font1 = new Font("BOLD",1,50); // Font class object font 1
        Font font2 = new Font("BOLD",1,30); // Font class object font2
        //Settings fonts for labels l,timer and buttons b1,b2,b3
        b1.setFont(font2); 
        b2.setFont(font2);
        b3.setFont(font2);
        l.setFont(font1);
        timer.setFont(font1);

        f.add(p, BorderLayout.SOUTH); // adding panel p to frame f
        f.add(l, BorderLayout.NORTH); // adding label l to frame f
        f.add(timer); // adding label timer to frame f

        //int min = 0, sec = 0, mili = 0;
        timer.setText("    "+min+" min : "+sec+" sec : "+mili+" mili");

        Thread t = new Thread(
          ()-> {                        // run() of thread implemented using lambda expression 
            while(flag == true)
            {
              mili++;
              if(mili==60)
              {
                sec++;
                mili=0;
              }
              if(sec==60)
              {
                min++;
                sec=0;
              }
             
              try                                                               
              {                                          
               Thread.sleep(10); // Thread.sleep() inside try-catch block 
               }
               catch(Exception e)
               {
                System.out.println(e);
               }
               
               timer.setText("    "+min+" min : "+sec+" sec : "+mili+" mili");

          } }
        );
        //t.start();
        //LOCAL LISTENER CLASS
        class Mylistener implements ActionListener
        {
           public void actionPerformed(ActionEvent ae)
           {
              if (ae.getSource()==b1)  // if the button source is b1(start) the timer starts working
              {
                 flag = true;
                  //System.out.println("Working");
                  t.start();
                 
                   
              }
              
              if(ae.getSource()==b2) // if the button source is b2(stop) the timer stops working
              {
                //min = 0;
                //mili = 0;
                //sec = 0;
                flag = false;
                timer.setText("    "+min+" min : "+sec+" sec : "+mili+" mili");
              }

              if(ae.getSource()==b3) // if the button source is b3(reset) the timer resets to 0
              {
                min = 0;
                mili = 0;
                sec = 0;
                flag = false;
                timer.setText("    "+min+" min : "+sec+" sec : "+mili+" mili");
            }
           }
        } // LOCAL LISTENER CLASS ENDS HERE

        //REGISTERING THE ACTION BUTTONS TO THE LISTENER
        Mylistener ml = new Mylistener();
        b1.addActionListener(ml);
        b2.addActionListener(ml);
        b3.addActionListener(ml);


        f.setVisible(true);
     }
    
}
