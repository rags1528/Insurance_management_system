package Insurance.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    signup() {
        JLabel head = new JLabel("SIGN UP");
        head.setBounds(150, 10, 100, 50);
        add(head);

        JLabel username = new JLabel("USERNAME:");
        username.setBounds(70, 50, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 50, 150, 30);
        add(tusername);

        JLabel password = new JLabel("PASSWORD:");
        password.setBounds(70, 90, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 90, 150, 30);
        add(tpassword);


        login = new JButton("CREATE");
        login.setBounds(165, 130, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(165, 170, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(420, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 420, 300);
        add(image);

        setSize(420, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {

            String id = tusername.getText();
            String name = tpassword.getText();

            if ( id.isEmpty() || name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER BOTH USERNAME AND PASSWORD");
            }
            else {
                char ch = id.charAt(0);

                if (Character.isLetter(ch)) {
                    try {
                        conn c = new conn();
                        String query = "insert into login values('" + id + "','" + name + "')";
                        c.stmt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "USER CREATED SUCCESSFULLY");
                        setVisible(false);
                        new Login();
                    } catch (Exception E) {
                        E.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error " + E.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "USERNAME SHOULD NOT START WITH NUMBERS ");
                }
            }
        }
        else if(e.getSource()==back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new signup();
    }
}




