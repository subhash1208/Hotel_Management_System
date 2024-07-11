package Source.TMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfusername,tfname,tfquestion,tfanswer,tfpass;
    JButton search,retrieve,back;

    ForgetPassword(){
        setBounds(350,200,850,380);
       // setVisible(true);
        getContentPane().setBackground(new Color(169, 146, 222));
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/forget.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        p1.setBackground(new Color(228, 221, 244));
        add(p1);

        JLabel labelUsername=new JLabel("User-name");
        labelUsername.setBounds(40,20,100,25);
        labelUsername.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,14));
        p1.add(labelUsername);

        tfusername=new JTextField();
        tfusername.setBounds(220,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search=new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.BLACK);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);

        JLabel labelname=new JLabel("Name");
        labelname.setBounds(40,60,100,25);
        labelname.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,14));
        p1.add(labelname);

        tfname=new JTextField();
        tfname.setBounds(220,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel labelquestiion=new JLabel("Security Question");
        labelquestiion.setBounds(40,100,150,25);
        labelquestiion.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,14));
        p1.add(labelquestiion);

        tfquestion=new JTextField();
        tfquestion.setBounds(220,100,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel labelanswer=new JLabel("Answer");
        labelanswer.setBounds(40,140,150,25);
        labelanswer.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,14));
        p1.add(labelanswer);

        tfanswer=new JTextField();
        tfanswer.setBounds(220,140,150,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        retrieve=new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.black);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel labelpass=new JLabel("Password");
        labelpass.setBounds(40,180,150,25);
        labelpass.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,14));
        p1.add(labelpass);

        tfpass=new JTextField();
        tfpass.setBounds(220,180,150,25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);

        back=new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.black);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);



        setVisible(true);

    }

    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==search)
        {
            try {
                String query="select * from account where username='"+tfusername.getText()+"' ";
                faker c=new faker();
                ResultSet rs=c.s.executeQuery(query);
                while (rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("question"));
                }


            }catch (Exception e){
                e.printStackTrace();
            }


        } else if (ac.getSource()==retrieve) {
            try {
                String query="select * from account where answer='"+tfanswer.getText()+"' AND username='"+tfusername.getText()+"'";
                faker c=new faker();


                ResultSet rs=c.s.executeQuery(query);
                while (rs.next()){
                    tfpass.setText(rs.getString("password"));


                }


            }catch (Exception e){
                e.printStackTrace();
            }

        } else{
            setVisible(false);
            new Login();

        }

    }


    public static void main(String[] args) {
        new ForgetPassword();
    }

}
