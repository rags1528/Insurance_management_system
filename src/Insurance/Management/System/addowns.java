package Insurance.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addowns extends JFrame implements ActionListener {


    JTextField tpersonid,tcarid;
    JButton add,back;
    addowns(){



        JLabel heading =new JLabel("ADD OWNER DETAILS");
        heading.setBounds(400,70,600,40);
        heading.setFont(new Font("Raleway",Font.BOLD,40));
        add(heading);

        JLabel id=new JLabel("PERSON ID:");
        id.setBounds(400,150,150,30);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(id);

        tpersonid=new JTextField();
        tpersonid.setBounds(575,150,200,30);
        tpersonid.setBackground(new Color(255,255,255));
        add( tpersonid);

        JLabel cid=new JLabel("CAR ID:");
        cid.setBounds(400,200,200,30);
        cid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(cid);

        tcarid=new JTextField();
        tcarid.setBounds(575,200,200,30);
        tcarid.setBackground(new Color(255,255,255));
        add(tcarid);



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
            String car_id=tcarid.getText();


            try{
                conn c=new conn();
                String query="insert into owns values('"+person_id+"','"+car_id+"')";
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
        new addowns();
    }
}


