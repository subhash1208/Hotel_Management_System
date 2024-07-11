package Source.TMS;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    CheckPackage(){
        setBounds(450,200,900,600);


       String[] pack1={"Premium Package","6 Days and 7 Nights","Airport Assistance","Customizable Schedule","All meals included","Cruise Included","Guide Provided","Book Now","Summer Special","All at $1999","pack1.jpg"};
        String[] pack2={"Luxury Package","4 Days and 5 Nights","Airport Assistance","Flexible Schedule","Lunch/Breakfast included","Transport Included","Guide Provided","Book Now","Limited Deal","All at $1599","pack2 (1).jpg"};
       String[] pack3={"Deluxe Package","3 Days and 4 Nights","Refundable Airfare","Rampant Schedule","Breakfast included","Transport Included","Guide Provided","Book Now","Standard Deal","All at $999","pack3.jpg"};

       // String[] pack1 = new String[]{"package1.jpg","GOLD PACKAGE","6 days and 7 Nights", "Airport Assistance at Aiport", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs 12000 only"};
        //String[] pack2 = new String[]{"package2.jpg","SILVER PACKAGE","4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", "Winter Special", "Rs 25000 only"};
       // String[] pack3 = new String[]{"package3.jpg","BRONZE PACKAGE","6 days and 5 Nights", "Return Airfare", "Free Clubbing, Horse Riding & other Games", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "Winter Special", "Rs 32000 only"};

        JTabbedPane tab=new JTabbedPane();

        JPanel p1=createPackage(pack1);
        tab.addTab("Package 1",null,p1);

        JPanel p2=createPackage(pack2);
        tab.addTab("Package 2",null,p2);

        JPanel p3=createPackage(pack3);
        tab.addTab("Package 3",null,p3);
        add(tab);




        setVisible(true);

    }

    public JPanel createPackage(String[]pack){
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(224, 169, 109));

        JLabel l1=new JLabel(pack[0]);
        l1.setBounds(50,5,300,30);
        l1.setForeground(new Color(32, 30, 32));
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        p1.add(l1);

        JLabel l2=new JLabel(pack[1]);
        l2.setBounds(30,60,300,30);
        //l2.setBackground(new Color(0,83,156));
        l2.setForeground(new Color(252, 246, 245));
        l2.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        p1.add(l2);

        JLabel l3=new JLabel(pack[2]);
        l3.setBounds(30,110,300,30);
        //l2.setBackground(new Color(0,83,156));
        l3.setForeground(new Color(252, 246, 245));
        l3.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        p1.add(l3);

        JLabel l4=new JLabel(pack[3]);
        l4.setBounds(30,160,300,30);
        //l2.setBackground(new Color(0,83,156));
        l4.setForeground(new Color(252, 246, 245));
        l4.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        p1.add(l4);

        JLabel l5=new JLabel(pack[4]);
        l5.setBounds(30,210,300,30);
        //l2.setBackground(new Color(0,83,156));
        l5.setForeground(new Color(252, 246, 245));
        l5.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        p1.add(l5);

        JLabel l6=new JLabel(pack[5]);
        l6.setBounds(30,260,300,30);
        //l2.setBackground(new Color(0,83,156));
        l6.setForeground(new Color(252, 246, 245));
        l6.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        p1.add(l6);

        JLabel l7=new JLabel(pack[6]);
        l7.setBounds(30,310,300,30);
        //l2.setBackground(new Color(0,83,156));
        l7.setForeground(new Color(252, 246, 245));
        l7.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        p1.add(l7);

        JLabel l8=new JLabel(pack[7]);
        l8.setBounds(30,380,300,30);
        //l2.setBackground(new Color(0,83,156));
        l8.setForeground(new Color(252, 246, 245));
        l8.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        p1.add(l8);

        JLabel l9=new JLabel(pack[8]);
        l9.setBounds(30,430,300,30);
        //l2.setBackground(new Color(0,83,156));
        l9.setForeground(new Color(252, 246, 245));
        l9.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        p1.add(l9);

        JLabel l10=new JLabel(pack[9]);
        l10.setBounds(500,430,300,30);
        //l2.setBackground(new Color(0,83,156));
        l10.setForeground(new Color(252, 246, 245));
        l10.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        p1.add(l10);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/"+pack[10]));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l12=new JLabel(i3);
        l12.setBounds(350,20,500,300);
        p1.add(l12);

        return p1;
    }

    public static void main(String[] args) {
        new CheckPackage();
    }
}
