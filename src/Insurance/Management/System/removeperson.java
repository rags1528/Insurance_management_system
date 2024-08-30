package Insurance.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class removeperson extends JFrame implements ActionListener {

    Choice choicepersonid;
    JButton delete,back;
    removeperson(){
        JLabel heading =new JLabel("REMOVE PERSON");
        heading.setBounds(400,70,700,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JLabel id=new JLabel("PERSON ID:");
        id.setBounds(400,150,120,30);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(id);

        choicepersonid=new Choice();
        choicepersonid.setBounds(600,150,150,40);
        add(choicepersonid);

        try{
            conn c=new conn();
            ResultSet res=c.stmt.executeQuery("select * from person");
            while(res.next()){
                choicepersonid.add(res.getString("person_id"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }

        JLabel name=new JLabel("PERSON NAME:");
        name.setBounds(400,200,170,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel textname=new JLabel();
        textname.setBounds(600,200,150,30);
        textname.setFont(new Font("Raleway",Font.BOLD,20));
        add(textname);

        JLabel gender=new JLabel("PERSON GENDER:");
        gender.setBounds(400,250,200,30);
        gender.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(gender);

        JLabel textgender=new JLabel();
        textgender.setBounds(600,250,150,30);
        textgender.setFont(new Font("Raleway",Font.BOLD,20));
        add(textgender);


        try{
            conn c=new conn();
            ResultSet res=c.stmt.executeQuery("select * from person where person_id='"+choicepersonid.getSelectedItem()+"'");
            while(res.next()){
                textname.setText(res.getString("name"));
                textgender.setText(res.getString("gender"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        choicepersonid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c=new conn();
                    ResultSet res=c.stmt.executeQuery("select * from person where person_id='"+choicepersonid.getSelectedItem()+"'");
                    while(res.next()){
                        textname.setText(res.getString("name"));
                        textgender.setText(res.getString("gender"));
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
                String query="delete from person where person_id='"+choicepersonid.getSelectedItem()+"'";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"person Deleted Successfully");
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
        new removeperson();
    }
}

