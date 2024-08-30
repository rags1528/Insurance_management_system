package Insurance.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class remove extends JFrame {
    remove(){
        JLabel heading =new JLabel("INSURANCE DATABASE MANAGEMENT");
        heading.setBounds(265,80,800,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JButton removeperson=new JButton("REMOVE PERSON");
        removeperson.setBounds(300,170,230,40);
        removeperson.setForeground(Color.WHITE);
        removeperson.setBackground(Color.black);
        removeperson.setFont(new Font("Raleway",Font.BOLD,20));
        removeperson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new removeperson();
            }
        });
        add(removeperson);

        JButton removecar=new JButton("REMOVE CAR");
        removecar.setBounds(650,170,250,40);
        removecar.setForeground(Color.WHITE);
        removecar.setBackground(Color.black);
        removecar.setFont(new Font("Raleway",Font.BOLD,20));
        removecar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new removecar();

            }
        });
        add(removecar);

        JButton removeaccident=new JButton("REMOVE ACCIDENT");
        removeaccident.setBounds(300,240,230,40);
        removeaccident.setForeground(Color.WHITE);
        removeaccident.setBackground(Color.black);
        removeaccident.setFont(new Font("Raleway",Font.BOLD,20));
        removeaccident.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new removeaccident();

            }
        });
        add(removeaccident);

        JButton removeparticipated=new JButton("REMOVE PARTICIPATED");
        removeparticipated.setBounds(650,240,300,40);
        removeparticipated.setForeground(Color.WHITE);
        removeparticipated.setBackground(Color.black);
        removeparticipated.setFont(new Font("Raleway",Font.BOLD,20));
        removeparticipated.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new removeparticipated();

            }
        });
        add(removeparticipated);

        JButton removeowns=new JButton("REMOVE OWNS");
        removeowns.setBounds(300,310,230,40);
        removeowns.setForeground(Color.WHITE);
        removeowns.setBackground(Color.black);
        removeowns.setFont(new Font("Raleway",Font.BOLD,20));
        removeowns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new removeowns();

            }
        });
        add(removeowns);

        JButton removeinsurancepolicies=new JButton("REMOVE INSURANCE POLICIES");
        removeinsurancepolicies.setBounds(650,310,350,40);
        removeinsurancepolicies.setForeground(Color.WHITE);
        removeinsurancepolicies.setBackground(Color.black);
        removeinsurancepolicies.setFont(new Font("Raleway",Font.BOLD,20));
        removeinsurancepolicies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new removeinsurancepolicies();

            }
        });
        add(removeinsurancepolicies);

        JButton back=new JButton("BACK");
        back.setBounds(500,380,200,40);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.black);
        back.setFont(new Font("Raleway",Font.BOLD,20));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main_class();

            }
        });
        add(back);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
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
        new remove();
    }
}
