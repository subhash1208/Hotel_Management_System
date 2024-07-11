package Source.TMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton fpass,signup,login;
    JTextField userNameTextField,passwordTextField;
    Login(){
        setSize(800,400);
        setLocation(350,200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        //use panel to spit screen

        JPanel p1=new JPanel();
        p1.setBackground(new Color(95, 44, 62));
        //p1.setBackground(new Color(221, 208, 200));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Source/icons/icons/useradd.jfif"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);


        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(209, 173, 204));
        p2.setBounds(400,30,450,300);
        add(p2);

        JLabel labelUsername=new JLabel("User Name");
        labelUsername.setBounds(60,20,100,25);
        labelUsername.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        p2.add(labelUsername);

         userNameTextField=new JTextField();
        userNameTextField.setBounds(60,60,300,20);
        userNameTextField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(userNameTextField);

        JLabel labelPassword=new JLabel("Password");
        labelPassword.setBounds(60,110,100,25);
        labelPassword.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,16));
        p2.add(labelPassword);

         passwordTextField=new JTextField();
        passwordTextField.setBounds(60,150,300,30);
        passwordTextField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(passwordTextField);

         login=new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(228, 221, 244));
        login.setForeground(Color.BLACK);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);


         signup=new JButton("Sign-Up");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(228, 221, 244));
        signup.setForeground(Color.BLACK);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        p2.add(signup);

         fpass=new JButton("Forgot Password");
        fpass.setBounds(130,250,130,30);
        fpass.setBackground(new Color(200, 185, 235));
        fpass.setForeground(new Color(45, 45, 45));
        fpass.setBorder(BorderFactory.createEmptyBorder());
        fpass.addActionListener(this);
        p2.add(fpass);

        //JLabel text=new JLabel("Have Trouble Logging in");
        //text.setBounds(300,250,150,20);
        //text.setForeground(Color.RED);
        //p2.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()==login){
            try {
                String username= userNameTextField.getText();
                String pass= passwordTextField.getText();

                String query="select * from account where username='"+username+"' AND password='"+pass+"'";
                faker c=new faker();
                ResultSet rs=c.s.executeQuery(query);

                if(rs.next()) {
                    setVisible(false);
                    new Loading(username);
                }
                    else{
                        JOptionPane.showMessageDialog(null,"Incorrect Username/Password");


                }



            }catch (Exception e){
                e.printStackTrace();
            }


        } else if (ac.getSource()==signup) {
            setVisible(false);
            new Signup();

        }
        else{
            setVisible(false);
            new ForgetPassword();

        }
    }
    public static void main(String[] args) {
        Login l=new Login();
    }

}
