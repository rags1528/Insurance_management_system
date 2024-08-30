package Insurance.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;
    Login(){

        JLabel username=new JLabel("USERNAME:");
        username.setBounds(70,50,100,30);
        add(username);

        tusername =new JTextField();
        tusername.setBounds(150,50,150,30);
        add(tusername);

        JLabel password=new JLabel("PASSWORD:");
        password.setBounds(70,90,100,30);
        add(password);

        tpassword =new JPasswordField();
        tpassword.setBounds(150,90,150,30);
        add(tpassword);


        login=new JButton("LOGIN");
        login.setBounds(165,130,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back=new JButton("BACK");
        back.setBounds(165,170,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(420,300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,420,300);
        add(image);

        setSize(420,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            try{
                String username=tusername.getText();
                String password=tpassword.getText();

                conn con=new conn();
                System.out.print(username+ " "+password);
                String query="select * from login where username= '"+username+"' and password= '"+password+"'";
                System.out.println(query);
                ResultSet res=con.stmt.executeQuery(query);

                if(res.next()){
                    setVisible(false);
                    new Main_class();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username and password");
                }

            }catch(Exception E){
                E.printStackTrace();
            }

        }
        else if(e.getSource()==back){
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}






