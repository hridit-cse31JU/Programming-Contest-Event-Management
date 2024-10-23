

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class login extends JFrame {
    private ImageIcon ic;
    private Container bc;
    private JLabel n1,n2,n3;
    private JTextField t1,t2;
    private JButton j1;
    private JPasswordField p1;

    public login()
    {
        try
        {
            File input = new File("C:/Users/Oywon/Downloads/icon.jpeg");
            ic= new ImageIcon(input.getAbsolutePath());
            setIconImage(ic.getImage());
        }catch(Exception e)
        {
            System.out.println(" error is in "+e.getMessage());
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("cse -31");
        setResizable(false);
        bc();

    }
    void bc()
    {
        bc=getContentPane();
        bc.setLayout(null);
        bc.setBackground(Color.white);

        n1=new JLabel("Welcome to NCPC 2K24");
        n1.setBounds(100,40,200,30);
        n1.setForeground(Color.BLACK);

        t1=new JTextField();
        t1.setBounds(100,80,250,40);
        Font f1= new Font("arial",Font.BOLD,18);
        t1.setFont(f1);

        n2= new JLabel("Login");
        n2.setBounds(100,160,200,20);
        n2.setForeground(Color.black);
        n2.setFont(f1);

        t2=new JTextField();
        t2.setBounds(100,190,200,20);
        t2.setFont(f1);

        j1=new JButton("Signup");
        j1.setBounds(100,320,300,30);
        j1.setForeground(Color.black);

        n3= new JLabel("Enter Password: ");
        n3.setBounds(100,220,200,20);
        n3.setForeground(Color.black);
        n3.setFont(f1);

        p1=new JPasswordField();
        p1.setBounds(100,260,200,20);
        p1.setFont(f1);










        bc.add(t1);
        bc.add(n1);
        bc.add(n2);
        bc.add(t2);
        bc.add(j1);
        bc.add(n3);
        bc.add(p1);






    }

    public static void main(String[] args) {
        CSE_31.login ll= new CSE_31.login();
        ll.setVisible(true);

    }
}

