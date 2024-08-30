package Insurance.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class view extends JFrame {

    view(){
        JLabel heading =new JLabel("INSURANCE DATABASE MANAGEMENT");
        heading.setBounds(265,70,900,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JButton viewperson=new JButton("VIEW PERSON");
        viewperson.setBounds(300,140,200,40);
        viewperson.setForeground(Color.WHITE);
        viewperson.setBackground(Color.black);
        viewperson.setFont(new Font("Raleway",Font.BOLD,20));
        viewperson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new  viewperson();

            }
        });
        add(viewperson);

        JButton viewcar=new JButton("VIEW CAR");
        viewcar.setBounds(650,140,220,40);
        viewcar.setForeground(Color.WHITE);
        viewcar.setBackground(Color.black);
        viewcar.setFont(new Font("Raleway",Font.BOLD,20));
        viewcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new viewcar();

            }
        });
        add(viewcar);

        JButton viewaccident=new JButton("VIEW ACCIDENT");
        viewaccident.setBounds(300,200,200,40);
        viewaccident.setForeground(Color.WHITE);
        viewaccident.setBackground(Color.black);
        viewaccident.setFont(new Font("Raleway",Font.BOLD,20));
        viewaccident.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new viewaccident();

            }
        });
        add(viewaccident);

        JButton viewparticipated=new JButton("VIEW PARTICIPATED");
        viewparticipated.setBounds(650,200,270,40);
        viewparticipated.setForeground(Color.WHITE);
        viewparticipated.setBackground(Color.black);
        viewparticipated.setFont(new Font("Raleway",Font.BOLD,20));
        viewparticipated.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new  viewparticipated();

            }
        });
        add( viewparticipated);

        JButton viewowns=new JButton("VIEW OWNS");
        viewowns.setBounds(300,280,220,40);
        viewowns.setForeground(Color.WHITE);
        viewowns.setBackground(Color.black);
        viewowns.setFont(new Font("Raleway",Font.BOLD,20));
        viewowns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new viewowns();

            }
        });
        add(viewowns);

        JButton viewinsurancepolicies=new JButton("VIEW INSURANCE POLICIES");
        viewinsurancepolicies.setBounds(650,280,350,40);
        viewinsurancepolicies.setForeground(Color.WHITE);
        viewinsurancepolicies.setBackground(Color.black);
        viewinsurancepolicies.setFont(new Font("Raleway",Font.BOLD,20));
        viewinsurancepolicies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new viewinsurancepolicies();

            }
        });
        add(viewinsurancepolicies);

        JButton back=new JButton("BACK");
        back.setBounds(500,350,200,40);
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


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/print.jpg"));
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
        new view();
    }
}


