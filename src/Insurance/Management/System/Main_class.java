package Insurance.Management.System;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class(){



        JLabel heading =new JLabel("INSURANCE DATABASE MANAGEMENT");
        heading.setBounds(380,100,800,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JButton add=new JButton("ADD DETAILS");
        add.setBounds(515,250,200,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.setFont(new Font("Raleway",Font.BOLD,20));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new Add();

            }
        });

        add(add);

        JButton view=new JButton("VIEW DETAILS");
        view.setBounds(920,250,200,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.setFont(new Font("Raleway",Font.BOLD,20));
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new view();

            }
        });
        add(view);

        JButton rem=new JButton("REMOVE DETAILS");
        rem.setBounds(700,400,250,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.black);
        rem.setFont(new Font("Raleway",Font.BOLD,20));
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new remove();

            }
        });
        add(rem);


        JButton create=new JButton("CREATE NEW USER");
        create.setBounds(500,600,250,40);
        create.setForeground(Color.black);
        create.setBackground(Color.blue);
        create.setFont(new Font("Raleway",Font.BOLD,20));
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new signup();
            }
        });
        add(create);
        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);


        JButton back=new JButton("LOG OUT");
        back.setBounds(900,600,200,40);
        back.setForeground(Color.black);
        back.setBackground(Color.blue);
        back.setFont(new Font("Raleway",Font.BOLD,20));
        back.addActionListener(new ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       setVisible(false);
                                       new Login();
                                   }
                               });
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(1160,650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1160,650);
        add(image);


        setSize(1170,650);
        setLocation(100,20);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
