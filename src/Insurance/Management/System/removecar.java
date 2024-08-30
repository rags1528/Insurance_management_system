package Insurance.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class removecar extends JFrame implements ActionListener {

    Choice choicecarid;
    JButton delete,back;
    removecar(){
        JLabel heading =new JLabel("REMOVE CAR");
        heading.setBounds(400,70,700,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JLabel id=new JLabel("PERSON ID:");
        id.setBounds(400,150,120,30);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(id);

        choicecarid=new Choice();
        choicecarid.setBounds(600,150,150,40);
        add(choicecarid);

        try{
            conn c=new conn();
            ResultSet res=c.stmt.executeQuery("select * from car");
            while(res.next()){
                choicecarid.add(res.getString("car_id"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }

        JLabel mod=new JLabel("MODEL:");
        mod.setBounds(400,200,170,30);
        mod.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add( mod);

        JLabel textmod=new JLabel();
        textmod.setBounds(600,200,150,30);
        textmod.setFont(new Font("Raleway",Font.BOLD,20));
        add(textmod);

        JLabel year=new JLabel(" YEAR:");
        year.setBounds(400,250,200,30);
        year.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(year);

        JLabel textyear=new JLabel();
        textyear.setBounds(600,250,150,30);
        textyear.setFont(new Font("Raleway",Font.BOLD,20));
        add(textyear);


        try{
            conn c=new conn();
            ResultSet res=c.stmt.executeQuery("select * from car where car_id='"+choicecarid.getSelectedItem()+"'");
            while(res.next()){
                textmod.setText(res.getString("model"));
                textyear.setText(res.getString("year"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        choicecarid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c=new conn();
                    ResultSet res=c.stmt.executeQuery("select * from car where car_id='"+choicecarid.getSelectedItem()+"'");
                    while(res.next()){
                        textmod.setText(res.getString("model"));
                        textyear.setText(res.getString("year"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete =new JButton("DELETE");
        delete.setBounds(550,350,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);


        back =new JButton("BACK");
        back.setBounds(700,350,100,30);
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
        if(e.getSource()==delete){
            try{
                conn c=new conn();
                String query="delete from car where car_id='"+choicecarid.getSelectedItem()+"'";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"car Deleted Successfully");
                setVisible(false);
                new remove();
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        if(e.getSource()==back){
            setVisible(false);
            new remove();

        }
    }

    public static void main(String[] args) {
        new removecar();
    }
}

