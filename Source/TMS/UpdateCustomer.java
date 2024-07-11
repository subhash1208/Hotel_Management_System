package Source.TMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelusername,labelname;
    JComboBox comboId;
    JTextField tfnumber,tfid,tfgender,tfcountry,tfaddress,tfemail,tfphone;

    JRadioButton rmale,rfemale;

    JButton add,back;
    UpdateCustomer(String username){
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(new Color(228, 221, 244));

        JLabel text=new JLabel("Update Customer Details");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(text);


        JLabel lblusername=new JLabel("UserName");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);


        //Id

        JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);

        //Id Type
        tfid=new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);


        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);

        tfnumber=new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);

        labelname=new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);

        //radio button gender

        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);

        tfgender=new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);

        //country

        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);

        tfcountry=new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);

        //Address
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);

        tfaddress=new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);

        //E-Mail

        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(30,330,150,25);
        add(lblphone);

        tfphone=new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);

        //Address
        JLabel lblemail=new JLabel("E-Mail");
        lblemail.setBounds(30,370,150,25);
        add(lblemail);

        tfemail=new JTextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);

        //Add Button
        add=new JButton("Update");
        add.setBackground(Color.gray);
        add.setForeground(Color.black);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back=new JButton("Back");
        back.setBackground(Color.gray);
        back.setForeground(Color.black);
        back.setBounds(230,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/update.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,100,450,300);
        add(image);

        try {
            faker c=new faker();
            ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);


    }

    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==add){
            String username=labelusername.getText();
            String id= tfid.getText();
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender=tfgender.getText();
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String emal=tfemail.getText();

            try {
                faker c=new faker();
                String query="update customer set username='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+emal+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);


            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new UpdateCustomer("Santosh");
    }

}
