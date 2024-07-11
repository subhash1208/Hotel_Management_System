package Source.TMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {

    Paytm(){
    setBounds(500,200,800,600);

    JEditorPane pane=new JEditorPane();
    //pane.setBackground(new Color(204, 165, 198));
    pane.setEditable(false);
    try {

        pane.setPage("https://paytm.com/rent-payment");
    }catch (Exception e){
        pane.setContentType("text/html");
        pane.setText("<html>Could not load,Error 404<html>");
    }

    JScrollPane sp=new JScrollPane(pane);
    getContentPane().add(sp);

    JButton back=new JButton("back");
    back.setBounds(610,20,80,40);
        back.addActionListener(this);
    pane.add(back);

    setVisible(true);

    }

    public void actionPerformed(ActionEvent ac){
        setVisible(false);

    }



    public static void main(String[] args) {
        new Paytm();
    }
}
