package Insurance.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends JFrame {
    Add(){

        JLabel heading =new JLabel("INSURANCE DATABASE MANAGEMENT");
        heading.setBounds(430,100,800,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JButton addperson=new JButton("ADD PERSON");
        addperson.setBounds(300,200,200,40);
        addperson.setForeground(Color.WHITE);
        addperson.setBackground(Color.black);
        addperson.setFont(new Font("Raleway",Font.BOLD,20));
        addperson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new addperson();
            }
        });
        add(addperson);

        JButton addcar=new JButton("ADD CAR");
        addcar.setBounds(650,200,200,40);
        addcar.setForeground(Color.WHITE);
        addcar.setBackground(Color.black);
        addcar.setFont(new Font("Raleway",Font.BOLD,20));
        addcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Insurance.Management.System.addcar();
            }
        });
        add(addcar);

        JButton addaccident=new JButton("ADD ACCIDENT");
        addaccident.setBounds(300,300,200,40);
        addaccident.setForeground(Color.WHITE);
        addaccident.setBackground(Color.black);
        addaccident.setFont(new Font("Raleway",Font.BOLD,20));
        addaccident.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Insurance.Management.System.addaccident();
            }
        });
        add(addaccident);

        JButton addowns=new JButton("ADD OWNS");
        addowns.setBounds(650,300,205,40);
        addowns.setForeground(Color.WHITE);
        addowns.setBackground(Color.black);
        addowns.setFont(new Font("Raleway",Font.BOLD,20));
        addowns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Insurance.Management.System.addowns();
            }
        });
        add(addowns);

        JButton addparticipated=new JButton("ADD PARTICIPATED");
        addparticipated.setBounds(300,400,300,40);
        addparticipated.setForeground(Color.WHITE);
        addparticipated.setBackground(Color.black);
        addparticipated.setFont(new Font("Raleway",Font.BOLD,20));
        addparticipated.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Insurance.Management.System.addparticipated();
            }
        });
        add(addparticipated);

        JButton addinsurancepolicies=new JButton("ADD INSURANCE POLICIES");
        addinsurancepolicies.setBounds(650,400,300,40);
        addinsurancepolicies.setForeground(Color.WHITE);
        addinsurancepolicies.setBackground(Color.black);
        addinsurancepolicies.setFont(new Font("Raleway",Font.BOLD,20));
        addinsurancepolicies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new Insurance.Management.System.addinsurancepolicies();
            }
        });
        add(addinsurancepolicies);

        JButton back=new JButton("BACK");
        back.setBounds(500,600,200,40);
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
        new Add();
    }
}
