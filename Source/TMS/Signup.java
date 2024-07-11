package Source.TMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {



    JButton create,back;
    JTextField tfname,tfusername,tfpass,tfanswer;
    Choice security;

    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        //creating panel

        JPanel p1=new JPanel();
        p1.setBackground((new Color(133,193,233)));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        //Username

        JLabel userName=new JLabel("User-Name");
        userName.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,18));
        userName.setBounds(50,20,125,25);
        p1.add(userName);

         tfusername=new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        //Name

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,18));
        name.setBounds(50,60,125,25);
        p1.add(name);

         tfname=new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        //Password

        JLabel password=new JLabel("Password");
        password.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,18));
        password.setBounds(50,100,125,25);
        p1.add(password);

         tfpass=new JTextField();
        tfpass.setBounds(190,100,180,25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);

        //Security Wuestion

        JLabel securityQuestion=new JLabel("Security Question");
        securityQuestion.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,18));
        securityQuestion.setBounds(50,140,125,25);
        p1.add(securityQuestion);

         security =new Choice();
        security.setFont(new Font("Times New Roman",Font.ITALIC,12));
        security.add("");
        security.add("Favourite Moive");
        security.add("KFC or McD");
        security.add("Favourite Color");
        security.add("Favourite Cartoon");
        security.setBounds(190,140,180,25);
        p1.add(security);

        //Security Field Answer

        JLabel answer=new JLabel("Answer");
        answer.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,18));
        answer.setBounds(50,180,125,25);
        p1.add(answer);

         tfanswer=new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        //Buttons-

         create=new JButton("Create Account");
        //create.setBackground(new Color(133,193,233));
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Times New Roman",Font.BOLD,12));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);

         back=new JButton("Back");
        //create.setBackground(new Color(133,193,233));
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Times New Roman",Font.BOLD,12));
        back.setBounds(250,250,100,30);
       back.addActionListener(this);
        p1.add(back);


        //image at right panel

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/useradd.jfif"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);






        setVisible(true);

    }


    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==create){
            String username= tfusername.getText();
            String name= tfname.getText();
            String password=tfpass.getText();
            String question=security.getSelectedItem();
            String answer=tfanswer.getText();

            String query="insert into account values('"+username+"', '"+name+"' ,'"+password+"','"+question+"','"+answer+"')";
            try{
                faker c=new faker();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account Created Successfully");

                setVisible(false);
                new Login();


            }catch (Exception e){
                e.printStackTrace();
            }


        }
        else{
            setVisible(false);
            new Login();

        }

    }


    public static void main(String[] args) {
        new Signup();
    }
}
