package Source.TMS;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {
    JButton back;


    ViewPackage(String username){
        setBounds(450,200,900,450);
        getContentPane().setBackground(new Color(228, 221, 244));
        setLayout(null);

        JLabel text=new JLabel("View Package Details");
        text.setFont(new Font("MoonGlade",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);

        JLabel lblusername=new JLabel("UserName");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        //package

        JLabel lblid=new JLabel("Package");
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

        //id

        JLabel lblname=new JLabel("Id");
        lblname.setBounds(30,170,100,25);
        add(lblname);

        JLabel labelid=new JLabel();
        labelid.setBounds(220,170,100,25);
        add(labelid);

        //number

        JLabel lblgender=new JLabel("Number");
        lblgender.setBounds(30,210,100,25);
        add(lblgender);

        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,210,100,25);
        add(labelnumber);

        //phone

        JLabel lblcountry=new JLabel("Phone");
        lblcountry.setBounds(30,250,100,25);
        add(lblcountry);

        JLabel labelphone=new JLabel();
        labelphone.setBounds(220,250,100,25);
        add(labelphone);

        //price

        JLabel lbladdress=new JLabel("Price");
        lbladdress.setBounds(30,290,100,25);
        add(lbladdress);

        JLabel labelprice=new JLabel();
        labelprice.setBounds(220,290,100,25);
        add(labelprice);


        back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(130,360,100,25);
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
            String query="select * from bookpackage where username='"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));

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
        new ViewPackage("Santosh");
    }

}
