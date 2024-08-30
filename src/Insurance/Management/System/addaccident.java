package Insurance.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addaccident extends JFrame implements ActionListener {


    JTextField treportno,tdate,tlocation;
    JButton add,back;
    addaccident(){



        JLabel heading =new JLabel("ADD ACCIDENT DETAILS");
        heading.setBounds(400,70,600,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JLabel number=new JLabel("REPORT NO:");
        number.setBounds(400,150,150,30);
        number.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(number);

        treportno=new JTextField();
        treportno.setBounds(625,150,200,30);
        treportno.setBackground(new Color(255,255,255));
        add(treportno);

        JLabel date=new JLabel("ACCIDENT DATE:");
        date.setBounds(400,200,200,30);
        date.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(date);

        tdate=new JTextField();
        tdate.setBounds(625,200,200,30);
        tdate.setBackground(new Color(255,255,255));
        add(tdate);

        JLabel location=new JLabel("ACCIDENT LOCATION:");
        location.setBounds(400,250,230,30);
        location.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(location);

        tlocation=new JTextField();
        tlocation.setBounds(625,250,200,30);
        tlocation.setBackground(new Color(255,255,255));
        add( tlocation);


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
            String report_no=treportno.getText();
            String date=tdate.getText();
            String location=tlocation.getText();

            try{
                conn c=new conn();
                String query="insert into accident values('"+report_no+"','"+date+"','"+location+"')";
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
        new addaccident();
    }
}


