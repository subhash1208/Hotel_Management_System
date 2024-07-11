package Source.TMS;

import javax.print.attribute.standard.Destination;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonalDetails,deletePersonalDetails,about,calculators,notepad,payments,viewBookedHotels,bookHotels,Destinations,viewHotels,viewPackage,bookPackage,checkPackage,viewPersonalDetails,updatePersonalDetails;

    Dashboard(String username){
        this.username=username;
        //setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        //Header Panel

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(48, 49, 121));
        p1.setBounds(0,0,1600,65);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon =new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(new Color(228, 221, 244));
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

         addPersonalDetails=new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(228, 221, 244));
        addPersonalDetails.setForeground(new Color(45, 45, 45));
        addPersonalDetails.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

         updatePersonalDetails=new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(228, 221, 244));
        updatePersonalDetails.setForeground(new Color(45, 45, 45));
        updatePersonalDetails.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

         viewPersonalDetails=new JButton("View Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(228, 221, 244));
        viewPersonalDetails.setForeground(new Color(45, 45, 45));
        viewPersonalDetails.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,145));
       viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

         deletePersonalDetails=new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(228, 221, 244));
        deletePersonalDetails.setForeground(new Color(45, 45, 45));
        deletePersonalDetails.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,35));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);


         checkPackage=new JButton("Check Packages");
        checkPackage.setBounds(0,200,300,50);
        checkPackage.setBackground(new Color(228, 221, 244));
        checkPackage.setForeground(new Color(45, 45, 45));
        checkPackage.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        checkPackage.setMargin(new Insets(0,0,0,110));
        checkPackage.addActionListener(this);
        p2.add(checkPackage);


         bookPackage=new JButton("Book Packages");
        bookPackage.setBounds(0,250,300,50);
        bookPackage.setBackground(new Color(228, 221, 244));
        bookPackage.setForeground(new Color(45, 45, 45));
        bookPackage.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        bookPackage.setMargin(new Insets(0,0,0,115));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);


         viewPackage=new JButton("View Packages");
        viewPackage.setBounds(0,300,300,50);
        viewPackage.setBackground(new Color(228, 221, 244));
        viewPackage.setForeground(new Color(45, 45, 45));
        viewPackage.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        viewPackage.setMargin(new Insets(0,0,0,115));
        viewPackage.addActionListener(this);
        //viewPackage.addActionListener(this);
        p2.add(viewPackage);


         viewHotels=new JButton("View Hotels");
        viewHotels.setBounds(0,350,300,50);
        viewHotels.setBackground(new Color(228, 221, 244));
        viewHotels.setForeground(new Color(45, 45, 45));
        viewHotels.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        viewHotels.setMargin(new Insets(0,0,0,145));
        p2.add(viewHotels);


         bookHotels=new JButton("Book Hotel");
        bookHotels.setBounds(0,400,300,50);
        bookHotels.setBackground(new Color(228, 221, 244));
        bookHotels.setForeground(new Color(45, 45, 45));
        bookHotels.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        bookHotels.setMargin(new Insets(0,0,0,155));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);


         viewBookedHotels=new JButton("View Booked Hotel");
        viewBookedHotels.setBounds(0,450,300,50);
        viewBookedHotels.setBackground(new Color(228, 221, 244));
        viewBookedHotels.setForeground(new Color(45, 45, 45));
        viewBookedHotels.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        viewBookedHotels.setMargin(new Insets(0,0,0,80));
        viewBookedHotels.addActionListener(this);
        p2.add(viewBookedHotels);


         Destinations=new JButton("Destinations");
        Destinations.setBounds(0,500,300,50);
        Destinations.setBackground(new Color(228, 221, 244));
        Destinations.setForeground(new Color(45, 45, 45));
        Destinations.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        Destinations.setMargin(new Insets(0,0,0,135));
        Destinations.addActionListener(this);
        p2.add(Destinations);


         payments=new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(228, 221, 244));
        payments.setForeground(new Color(45, 45, 45));
        payments.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        payments.setMargin(new Insets(0,0,0,160));
        payments.addActionListener(this);
        p2.add(payments);

         calculators=new JButton("Calculator");
        calculators.setBounds(0,600,300,50);
        calculators.setBackground(new Color(228, 221, 244));
        calculators.setForeground(new Color(45, 45, 45));
        calculators.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        calculators.setMargin(new Insets(0,0,0,155));
        calculators.addActionListener(this);
        p2.add(calculators);


         notepad=new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(228, 221, 244));
        notepad.setForeground(new Color(45, 45, 45));
        notepad.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        notepad.setMargin(new Insets(0,0,0,170));
        notepad.addActionListener(this);
        p2.add(notepad);

         about=new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(228, 221, 244));
        about.setForeground(new Color(45, 45, 45));
        about.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        about.setMargin(new Insets(0,0,0,190));
        about.addActionListener(this);
        p2.add(about);


        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/dow1.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);

        JLabel text=new JLabel("Travel And Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setForeground(new Color(45, 45, 45));
        text.setFont(new Font("Raleway",Font.PLAIN,55));
        image.add(text);




        setVisible(true);




    }

    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()==addPersonalDetails){
            new AddCustomer(username);
        } else if (ac.getSource()==viewPersonalDetails) {
            new ViewcCustomer(username);
            
        } else if (ac.getSource()==updatePersonalDetails) {
            new UpdateCustomer(username);

        } else if (ac.getSource()==checkPackage) {
            new CheckPackage();
        } else if (ac.getSource()==bookPackage) {
            new BookPackage(username);
        } else if (ac.getSource()==viewPackage) {
            new ViewPackage(username);
        } else if (ac.getSource()==viewHotels) {
            new CheckHotels();
        } else if (ac.getSource()==Destinations) {
            new Destinations();
        } else if (ac.getSource()==bookHotels) {
            new BookHotel(username);
        }else if (ac.getSource()==viewBookedHotels){
            new ViewBookedHotel(username);
        }else if(ac.getSource()==payments){
            new Payment();
        } else if (ac.getSource()==calculators) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ac.getSource()==notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ac.getSource()==deletePersonalDetails) {
            new DeletePersonalDetails(username);
        } else {
            new About();
        }
    }


    public static void main(String[] args) {
        new Dashboard("");
    }
}
