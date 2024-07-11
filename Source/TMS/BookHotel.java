package Source.TMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookHotel extends JFrame implements ActionListener {
    Choice seePackage;
    JTextField tfpersons;
    JLabel lblusername,labelphone,labelnumber,labelid,labelusername,lblid,lblnumber,lblphone,lbltotal,labelprice;
    String username;

    JButton checkPrice,BookPackage,back;

    BookHotel(String username){

        this.username=username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(new Color(204, 165, 198));

        JLabel text=new JLabel("Book Hotel");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Moonglade",Font.BOLD,25));
        add(text);

        lblusername=new JLabel("UserName");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblusername);

        labelusername=new JLabel();
        labelusername.setBounds(250,70,100,20);
        labelusername.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(labelusername);

        //Hotel selection Dropdown

        JLabel lblpackage=new JLabel("Select Hotel");
        lblpackage.setBounds(40,110,200,20);
        lblpackage.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblpackage);

        seePackage=new Choice();
       // seePackage.add("");
        faker c1=new faker();
        try {
            ResultSet rs=c1.s.executeQuery("select * from hotel");
            while (rs.next()){
                seePackage.add(rs.getString("name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


        seePackage.setFont(new Font("Bulgatti",Font.CENTER_BASELINE,12));
        seePackage.setBounds(250,110,200,20);
        add(seePackage);


        //number of people

        JLabel lblpersons=new JLabel("Total People");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblpersons);

        tfpersons=new JTextField();
        tfpersons.setBounds(250,150,200,20);
        tfpersons.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(tfpersons);

        //id

        lblid=new JLabel("Id");
        lblid.setBounds(40,190,150,20);
        lblid.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblid);

        labelid=new JLabel();
        labelid.setBounds(250,190,200,20);
        add(labelid);

        //Number

        lblnumber=new JLabel("Number");
        lblnumber.setBounds(40,230,150,20);
        lblnumber.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblnumber);

        labelnumber=new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);

        //phone

        lblphone=new JLabel("Phone");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblphone);

        labelphone=new JLabel();
        labelphone.setBounds(250,270,200,20);
        add(labelphone);

        //Number

        lbltotal=new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,20);
        lbltotal.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lbltotal);

        labelprice=new JLabel();
        labelprice.setBounds(250,310,150,25);
        add(labelprice);


        try {
            faker c=new faker();
            String query="select * from customer where username='"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        checkPrice=new JButton("Check Prices");
        checkPrice.setBackground(Color.darkGray);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBounds(60,380,120,25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        BookPackage=new JButton("Book Package");
        BookPackage.setBackground(Color.darkGray);
        BookPackage.setForeground(Color.WHITE);
        BookPackage.setBounds(200,380,120,25);
        BookPackage.addActionListener(this);
        add(BookPackage);

        back=new JButton("Back");
        back.setBackground(Color.darkGray);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l12=new JLabel(i3);
        l12.setBounds(550,50,500,300);
        add(l12);





        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==checkPrice){
            String pack=seePackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Premium Package")){
                cost+=1999;
            } else if (pack.equals("Luxury Package")) {
                cost+=1599;
            }else{
                cost +=999;
            }

            int persons=Integer.parseInt(tfpersons.getText());
            cost *=persons;
            labelprice.setText("$" + cost);


        } else if (ac.getSource()==BookPackage) {
            try {
                faker c=new faker();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+seePackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelnumber.getText()+"','"+labelid.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");

                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("Santosh");
    }
}
