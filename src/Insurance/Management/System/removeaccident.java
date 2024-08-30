package Insurance.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class removeaccident extends JFrame implements ActionListener {

    Choice choicereportno;
    JButton delete,back;
    removeaccident(){
        JLabel heading =new JLabel("REMOVE ACCIDENT DETAILS");
        heading.setBounds(400,70,700,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JLabel id=new JLabel("REPORT NO:");
        id.setBounds(400,150,200,30);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(id);

        choicereportno=new Choice();
        choicereportno.setBounds(600,150,150,40);
        add(  choicereportno);

        try{
            conn c=new conn();
            ResultSet res=c.stmt.executeQuery("select * from accident");
            while(res.next()){
                choicereportno.add(res.getString("report_no"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }

        JLabel date=new JLabel("ACCIDENT DATE:");
        date.setBounds(400,200,200,30);
        date.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(date);

        JLabel textdate=new JLabel();
        textdate.setBounds(600,200,150,30);
        textdate.setFont(new Font("Raleway",Font.BOLD,20));
        add(textdate);

        JLabel location=new JLabel("ACCIDENT LOCATION:");
        location.setBounds(400,250,230,30);
        location.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(location);

        JLabel textlocation=new JLabel();
        textlocation.setBounds(650,250,190,30);
        textlocation.setFont(new Font("Raleway",Font.BOLD,20));
        add(textlocation);


        try{
            conn c=new conn();
            ResultSet res=c.stmt.executeQuery("select * from accident where report_no='"+choicereportno.getSelectedItem()+"'");
            while(res.next()){
                textdate.setText(res.getString("accident_date"));
                textlocation.setText(res.getString("location"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        choicereportno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c=new conn();
                    ResultSet res=c.stmt.executeQuery("select * from accident where report_no='"+  choicereportno.getSelectedItem()+"'");
                    while(res.next()){
                        textdate.setText(res.getString("accident_date"));
                        textlocation.setText(res.getString("location"));
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
                String query="delete from accident where report_no='"+choicereportno.getSelectedItem()+"'";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"accident Deleted Successfully");
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
        new removeaccident();
    }
}


