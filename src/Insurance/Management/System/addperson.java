package Insurance.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addperson extends JFrame implements ActionListener {

    JComboBox boxgender;
    JTextField tpersonid,tpersonname;
    JButton add,back;
    addperson(){

        JLabel heading =new JLabel("ADD PERSON DETAILS");
        heading.setBounds(400,70,600,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JLabel id=new JLabel("PERSON ID:");
        id.setBounds(400,150,150,30);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(id);

        tpersonid=new JTextField();
        tpersonid.setBounds(605,150,200,30);
        tpersonid.setBackground(new Color(255,255,255));
        add(  tpersonid);

        JLabel name=new JLabel("PERSON NAME:");
        name.setBounds(400,200,200,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tpersonname=new JTextField();
        tpersonname.setBounds(605,200,200,30);
        tpersonname.setBackground(new Color(255,255,255));
        add( tpersonname);

        JLabel gender=new JLabel("PERSON GENDER:");
        gender.setBounds(400,250,200,30);
        gender.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(gender);


        String[] a={"Male","Female","Others"};
        boxgender=new JComboBox<>(a);
        boxgender.setBackground(new Color(255,255,255));
        boxgender.setBounds(605,250,200,30);
        add(boxgender);

        add =new JButton("ADD");
        add.setBounds(550,320,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back =new JButton("BACK");
        back.setBounds(700,320,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String person_id=tpersonid.getText();
            String name=tpersonname.getText();
            String gender=(String) boxgender.getSelectedItem();

            try{
                conn c=new conn();
                String query="insert into person values('"+person_id+"','"+name+"','"+gender+"')";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Inserted Successfully");
                setVisible(false);
                new Add();
            }
            catch(Exception E){
                E.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error "+E.getMessage());
            }

        }
        if(e.getSource()==back){
            setVisible(false);
            new Add();
        }
    }

    public static void main(String[] args) {
        new addperson();
    }
}
