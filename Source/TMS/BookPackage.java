package Source.TMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {
    Choice seehotel,cac,cfood;
    JTextField tfpersons,tfdays;
    JLabel lblusername,labelphone,labelnumber,labelid,labelusername,lblid,lblnumber,lblphone,lbltotal,labelprice;
    String username;

    JButton checkPrice,BookPackage,back;

    BookPackage(String username){

        this.username=username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(new Color(204, 165, 198));

        JLabel text=new JLabel("Book Package");
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

        //Package selection Dropdown

        JLabel lblpackage=new JLabel("Select Package");
        lblpackage.setBounds(40,110,200,20);
        lblpackage.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblpackage);

       seehotel=new Choice();
        seehotel.setFont(new Font("Bulgatti",Font.CENTER_BASELINE,12));
        seehotel.setBounds(250,110,200,20);
       add(seehotel);

       try {
           faker c=new faker();
           ResultSet  rs=c.s.executeQuery("select * from hotel");

           while (rs.next()){
               seehotel.add(rs.getString("name"));
           }

       }catch (Exception e){
           e.printStackTrace();
       }


        //number of people

        JLabel lblpersons=new JLabel("Total People");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblpersons);

        tfpersons=new JTextField();
        tfpersons.setBounds(250,150,200,20);
        tfpersons.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(tfpersons);

        //AC or Not

        JLabel lbldays=new JLabel("No Of Days");
        lbldays.setBounds(40,190,150,25);
        lbldays.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lbldays);

        tfdays=new JTextField();
        tfdays.setBounds(250,190,200,20);
        tfdays.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(tfdays);

        //AC/N-AC

        JLabel lblac=new JLabel("AC/Non-AC");
        lblac.setBounds(40,230,150,25);
        lblac.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblac);

        cac=new Choice();
        cac.setFont(new Font("Bulgatti",Font.CENTER_BASELINE,12));
        cac.setBounds(250,230,200,20);
        cac.add("AC");
        cac.add("Non-AC");
        add(cac);

        //Food Included

        JLabel lblfood=new JLabel("Food Inclusion");
        lblfood.setBounds(40,270,150,25);
        lblfood.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblfood);

        cfood=new Choice();
        cfood.setFont(new Font("Bulgatti",Font.CENTER_BASELINE,12));
        cfood.setBounds(250,270,200,20);
        cfood.add("Yes");
        cfood.add("No");
        add(cfood);

        //id

         lblid=new JLabel("Id");
        lblid.setBounds(40,310,150,20);
        lblid.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblid);

         labelid=new JLabel();
        labelid.setBounds(250,310,200,20);
        add(labelid);

        //Number

         lblnumber=new JLabel("Number");
        lblnumber.setBounds(40,350,150,20);
        lblnumber.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblnumber);

         labelnumber=new JLabel();
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);

        //phone

         lblphone=new JLabel("Phone");
        lblphone.setBounds(40,390,150,20);
        lblphone.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lblphone);

         labelphone=new JLabel();
        labelphone.setBounds(250,390,200,20);
        add(labelphone);

        //Number

         lbltotal=new JLabel("Total Price");
        lbltotal.setBounds(40,430,150,20);
        lbltotal.setFont(new Font("Moonglade",Font.CENTER_BASELINE,16));
        add(lbltotal);

         labelprice=new JLabel();
        labelprice.setBounds(250,430,150,25);
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
        checkPrice.setBounds(60,490,120,25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        BookPackage=new JButton("Book Hotel");
        BookPackage.setBackground(Color.darkGray);
        BookPackage.setForeground(Color.WHITE);
        BookPackage.setBounds(200,490,120,25);
        BookPackage.addActionListener(this);
        add(BookPackage);

        back=new JButton("Back");
        back.setBackground(Color.darkGray);
        back.setForeground(Color.WHITE);
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        add(back);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/hotel1.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l12=new JLabel(i3);
        l12.setBounds(500,50,600,400);
        add(l12);





        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==checkPrice){

            try {


                faker c = new faker();
                ResultSet rs = c.s.executeQuery("select * from hotel where name='" + seehotel.getSelectedItem() + "'");
                while (rs.next()){
                    int cost=Integer.parseInt(rs.getString("costperperson"));
                    int food=Integer.parseInt(rs.getString("foodincluded"));
                    int acr=Integer.parseInt(rs.getString("acroom"));

                    int persons=Integer.parseInt(tfpersons.getText());
                    int days=Integer.parseInt(tfdays.getText());

                    String acselected=cac.getSelectedItem();
                    String foodselected=cfood.getSelectedItem();

                    if(persons*days>0){
                        int total=0;
                        total += acselected.equals("AC")?acr:0;
                        total += foodselected.equals("Yes")?food:0;
                        total += cost;
                        total =total*persons*days;
                        labelprice.setText("Rs"+total);

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Enter Valid Number");
                    }

                }


            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ac.getSource()==BookPackage) {
            try {
                faker c=new faker();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+seehotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelnumber.getText()+"','"+labelid.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");

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
        new BookPackage("Santosh");
    }
}
