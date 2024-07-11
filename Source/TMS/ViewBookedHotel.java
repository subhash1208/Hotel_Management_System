package Source.TMS;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JButton back;


    ViewBookedHotel(String username){
        setBounds(400,200,1000,600);
        getContentPane().setBackground(new Color(204, 165, 198));
        setLayout(null);

        JLabel text=new JLabel("View Booked Hotel Details");
        text.setFont(new Font("MoonGlade",Font.BOLD,20));
        text.setBounds(60,0,400,30);
        add(text);

        JLabel lblusername=new JLabel("UserName");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        //package

        JLabel lblid=new JLabel("Hotel Name");
        lblid.setBounds(30,90,150,25);
        add(lblid);

        JLabel labelpackage=new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);

        //number of people

        JLabel lblnumber=new JLabel("Total Persons");
        lblnumber.setBounds(30,130,100,25);
        add(lblnumber);

        JLabel labelpersons=new JLabel();
        labelpersons.setBounds(220,130,100,25);
        add(labelpersons);

        //number of days

        JLabel lbldays=new JLabel("Total Days");
        lbldays.setBounds(30,170,100,25);
        add(lbldays);

        JLabel labeldays=new JLabel();
        labeldays.setBounds(220,170,100,25);
        add(labeldays);

        //AC/NAC

        JLabel lblac=new JLabel("Ac/Non-Ac");
        lblac.setBounds(30,210,100,25);
        add(lblac);

        JLabel labelac=new JLabel();
        labelac.setBounds(220,210,100,25);
        add(labelac);

        //number of people

        JLabel lblfood=new JLabel("Food Inclusion");
        lblfood.setBounds(30,250,100,25);
        add(lblfood);

        JLabel labelfood=new JLabel();
        labelfood.setBounds(220,250,100,25);
        add(labelfood);

        //id

        JLabel lblname=new JLabel("Id");
        lblname.setBounds(30,290,100,25);
        add(lblname);

        JLabel labelid=new JLabel();
        labelid.setBounds(220,290,100,25);
        add(labelid);

        //number

        JLabel lblgender=new JLabel("Number");
        lblgender.setBounds(30,330,100,25);
        add(lblgender);

        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,330,100,25);
        add(labelnumber);

        //phone

        JLabel lblcountry=new JLabel("Phone");
        lblcountry.setBounds(30,370,100,25);
        add(lblcountry);

        JLabel labelphone=new JLabel();
        labelphone.setBounds(220,370,100,25);
        add(labelphone);

        //price

        JLabel lbladdress=new JLabel("Price");
        lbladdress.setBounds(30,410,100,25);
        add(lbladdress);

        JLabel labelprice=new JLabel();
        labelprice.setBounds(220,410,100,25);
        add(labelprice);


        back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(130,460,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);



        try {
            faker c=new faker();
            String query="select * from bookhotel where username='"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labeldays.setText(rs.getString("days"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }





        setVisible(true);

    }

    public void actionPerformed(ActionEvent ac){
        setVisible(false);
    }





    public static void main(String[] args) {
        new ViewBookedHotel("Santosh");
    }

}
