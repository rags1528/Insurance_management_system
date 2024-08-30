package Insurance.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class removeinsurancepolicies extends JFrame implements ActionListener {

    Choice choicepolicyid;
    JButton delete,back;
    removeinsurancepolicies(){
        JLabel heading =new JLabel("REMOVE INSURANCE POLICIES");
        heading.setBounds(400,70,700,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JLabel id=new JLabel("POLICY ID:");
        id.setBounds(400,150,120,30);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(id);

        choicepolicyid=new Choice();
        choicepolicyid.setBounds(600,150,150,40);
        add(choicepolicyid);

        try{
            conn c=new conn();
            ResultSet res=c.stmt.executeQuery("select * from insurancepolicies");
            while(res.next()){
                choicepolicyid.add(res.getString("policy_id"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }

        JLabel name=new JLabel("CAR ID:");
        name.setBounds(400,200,170,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel textname=new JLabel();
        textname.setBounds(600,200,150,30);
        textname.setFont(new Font("Raleway",Font.BOLD,20));
        add(textname);

        JLabel stdate=new JLabel("START DATE:");
        stdate.setBounds(400,250,200,30);
        stdate.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(stdate);

        JLabel textstdate=new JLabel();
        textstdate.setBounds(600,250,150,30);
        textstdate.setFont(new Font("Raleway",Font.BOLD,20));
         add(textstdate);

        JLabel edate=new JLabel("END DATE:");
        edate.setBounds(400,300,200,30);
        edate.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(edate);

        JLabel textedate=new JLabel();
        textedate.setBounds(600,300,150,30);
        textedate.setFont(new Font("Raleway",Font.BOLD,20));
        add(textedate);


        try{
            conn c=new conn();
            ResultSet res=c.stmt.executeQuery("select * from insurancepolicies where policy_id='"+choicepolicyid.getSelectedItem()+"'");
            while(res.next()){
                textname.setText(res.getString("car_id"));
                textstdate.setText(res.getString("start_date"));
                textedate.setText(res.getString("end_date"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        choicepolicyid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c=new conn();
                    ResultSet res=c.stmt.executeQuery("select * from insurancepolicies where policy_id='"+choicepolicyid.getSelectedItem()+"'");
                    while(res.next()){
                        textname.setText(res.getString("car_id"));
                        textstdate.setText(res.getString("start_date"));
                        textedate.setText(res.getString("end_date"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete =new JButton("DELETE");
        delete.setBounds(550,390,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);


        back =new JButton("BACK");
        back.setBounds(700,390,100,30);
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
                String query="delete from insurancepolicies where policy_id='"+choicepolicyid.getSelectedItem()+"'";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"insurancepolicies Deleted Successfully");
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
        new removeinsurancepolicies();
    }
}


