package Source.TMS;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame implements Runnable {
    Thread thread;
    //Jframe from swing package
    splash(){
      //  setSize(1220,600);
        //setLocation(200,150);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/splash.jpg"));
        Image i2= i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);

        setVisible(true);
        thread=new Thread(this);
        thread.start();
    }

    public void run(){
        try {
            Thread.sleep(7000);
            //new Login();
            setVisible(false);
        }catch (Exception e){}

    }



    public static void main(String[] args) {
   splash frame= new splash();    //calling constructor
        int x=1;
        for (int i = 0; i < 500; x+=7,i+=6) {
            frame.setLocation(750-(x+1)/2,400-(i/2));
            frame.setSize(x+1,i);
            try{
                Thread.sleep(5);
            }catch (Exception e){ }

        }
    }
}
