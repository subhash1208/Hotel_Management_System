package Source.TMS;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeletePersonalDetails extends JFrame implements ActionListener {
    JButton back;
    String username;

    DeletePersonalDetails(String username){
        this.username=username;
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername=new JLabel("UserName");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        //id

        JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,110,150,25);
        add(lblid);

        JLabel labelid=new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);

        //number

        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,170,100,25);
        add(lblnumber);

        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,170,100,25);
        add(labelnumber);

        //name

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,230,100,25);
        add(lblname);

        JLabel labelname=new JLabel();
        labelname.setBounds(220,230,100,25);
        add(labelname);

        //gender

        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,290,100,25);
        add(lblgender);

        JLabel labelgender=new JLabel();
        labelgender.setBounds(220,290,100,25);
        add(labelgender);

        //country

        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(500,50,100,25);
        add(lblcountry);

        JLabel labelcounty=new JLabel();
        labelcounty.setBounds(690,50,100,25);
        add(labelcounty);

        //address

        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(500,110,100,25);
        add(lbladdress);

        JLabel labeladdress=new JLabel();
        labeladdress.setBounds(690,110,100,25);
        add(labeladdress);

        //phone

        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(500,170,100,25);
        add(lblphone);

        JLabel labelPhone=new JLabel();
        labelPhone.setBounds(690,170,100,25);
        add(labelPhone);

        //e-mail
        JLabel lblemail=new JLabel("E-Mail");
        lblemail.setBounds(500,230,100,25);
        add(lblemail);

        JLabel labelemail=new JLabel();
        labelemail.setBounds(690,230,100,25);
        add(labelemail);

        back=new JButton("Delete");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(350,350,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/viewall.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(20,400,600,200);
        add(image);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/viewall.jpg"));
        Image i5=i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(600,400,600,200);
        add(image2);

        try {
            faker c=new faker();
            String query="select * from customer where username='"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcounty.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelPhone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }





        setVisible(true);

    }

    public void actionPerformed(ActionEvent ac){
        try {
            faker c=new faker();
            c.s.executeUpdate("delete from account where username='"+username+"'");
            c.s.executeUpdate("delete from customer where username='"+username+"'");
            c.s.executeUpdate("delete from bookpackage where username='"+username+"'");
            c.s.executeUpdate("delete from bookhotel where username='"+username+"'");

            JOptionPane.showMessageDialog(null,"Data Deleted Successfully");

            System.exit(0);



        }catch (Exception e){
            e.printStackTrace();
        }
    }





    public static void main(String[] args) {
        new DeletePersonalDetails("Santosh");
    }

}
