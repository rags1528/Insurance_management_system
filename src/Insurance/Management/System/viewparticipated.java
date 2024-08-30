package Insurance.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewparticipated extends JFrame {

    JTable table;
    viewparticipated(){


        JLabel heading =new JLabel("VIEW PARTICIPATED");
        heading.setBounds(400,70,700,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        table=new JTable();
        try{
            conn c= new conn();
            ResultSet res=c.stmt.executeQuery("select * from participated");
            table.setModel(DbUtils.resultSetToTableModel(res));

        }
        catch(Exception E){
            E.printStackTrace();
        }
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial",Font.HANGING_BASELINE,18));
        table.setFont(new Font("Arial",Font.PLAIN,15));
        JScrollPane jp=new JScrollPane(table);
        jp.setBounds(280,150,600,150);
        add(jp);

        JButton back=new JButton("BACK");
        back.setBounds(500,350,200,40);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.black);
        back.setFont(new Font("Raleway",Font.BOLD,18));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new view();

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
        new viewparticipated();
    }
}
