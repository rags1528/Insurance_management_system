package Insurance.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addinsurancepolicies extends JFrame implements ActionListener {


    JTextField tpolicyid,tcarid,tstartdate,tenddate;
    JButton add,back;
    addinsurancepolicies(){



        JLabel heading =new JLabel("ADD INSURANCE POLICIES DETAILS");
        heading.setBounds(400,70,800,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JLabel id=new JLabel("POLICY ID:");
        id.setBounds(400,150,150,30);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(id);

        tpolicyid=new JTextField();
        tpolicyid.setBounds(575,150,200,30);
        tpolicyid.setBackground(new Color(255,255,255));
        add(tpolicyid);

        JLabel cid=new JLabel("CAR ID:");
        cid.setBounds(400,200,200,30);
        cid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add( cid);

        tcarid=new JTextField();
        tcarid.setBounds(575,200,200,30);
        tcarid.setBackground(new Color(255,255,255));
        add(tcarid);

        JLabel sdate=new JLabel("START DATE:");
        sdate.setBounds(400,250,200,30);
        sdate.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(sdate);

        tstartdate=new JTextField();
        tstartdate.setBounds(575,250,200,30);
        tstartdate.setBackground(new Color(255,255,255));
        add(tstartdate);

        JLabel edate=new JLabel("END DATE:");
        edate.setBounds(400,300,200,30);
        edate.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(edate);

        tenddate=new JTextField();
        tenddate.setBounds(575,300,200,30);
        tenddate.setBackground(new Color(255,255,255));
        add(tenddate);



        add =new JButton("ADD");
        add.setBounds(550,420,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back =new JButton("BACK");
        back.setBounds(700,420,100,30);
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
            String p_id=tpolicyid.getText();
            String car_id=tcarid.getText();
            String s_date=tstartdate.getText();
            String e_date=tenddate.getText();

            try{
                conn c=new conn();
                String query="insert into insurancepolicies values('"+p_id+"','"+car_id+"','"+s_date+"','"+e_date+"')";
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
        new addinsurancepolicies();
    }
}

