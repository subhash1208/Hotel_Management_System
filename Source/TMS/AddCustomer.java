package Source.TMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel labelusername,labelname;
    JComboBox comboId;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone;

    JRadioButton rmale,rfemale;

    JButton add,back;
    AddCustomer(String username){
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(new Color(228, 221, 244));


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
        comboId=new JComboBox(new String[]{"Passport","Aadhar Card","PAN Card","Ration Card"});
        comboId.setBounds(220,90,150,25);
        comboId.setBackground(Color.WHITE);
        add(comboId);

        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);

        tfnumber=new JTextField();
        tfnumber.setBounds(220,130,150,25);
        tfnumber.setBorder(BorderFactory.createEmptyBorder());
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

        rmale=new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.WHITE);
        add(rmale);


        rfemale=new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        //use button group to group individual buttons
        ButtonGroup bg=new ButtonGroup();
        bg.add(rfemale);
        bg.add(rmale);

        //country

        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);

        tfcountry=new JTextField();
        tfcountry.setBounds(220,250,150,25);
        tfcountry.setBorder(BorderFactory.createEmptyBorder());
        add(tfcountry);

        //Address
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);

        tfaddress=new JTextField();
        tfaddress.setBounds(220,290,150,25);
        tfaddress.setBorder(BorderFactory.createEmptyBorder());
        add(tfaddress);

        //E-Mail

        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(30,330,150,25);
        add(lblphone);

        tfphone=new JTextField();
        tfphone.setBounds(220,330,150,25);
        tfphone.setBorder(BorderFactory.createEmptyBorder());
        add(tfphone);

        //Address
        JLabel lblemail=new JLabel("E-Mail");
        lblemail.setBounds(30,370,150,25);
        add(lblemail);

        tfemail=new JTextField();
        tfemail.setBounds(220,370,150,25);
        tfemail.setBorder(BorderFactory.createEmptyBorder());
        add(tfemail);

        //Add Button
        add=new JButton("Add");
        add.setBackground(Color.gray);
        add.setForeground(Color.WHITE);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back=new JButton("Back");
        back.setBackground(Color.gray);
        back.setForeground(Color.WHITE);
        back.setBounds(230,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/newcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,40,450,420);
        add(image);

        try {
            faker c=new faker();
            ResultSet rs=c.s.executeQuery("select * from account where username='"+username+"'");
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);


    }

    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==add){
            String username=labelusername.getText();
            String id=(String) comboId.getSelectedItem();
            String number=(String)tfnumber.getText();
            String name=labelname.getText();
            String gender=null;
            if(rmale.isSelected()){
                gender="Male";
            }
            else {
                gender = "Female";

            }
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String emal=tfemail.getText();

            try {
                faker c=new faker();
                String query="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+emal+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Details Addes Successfully");
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
        new AddCustomer("");
    }

}
