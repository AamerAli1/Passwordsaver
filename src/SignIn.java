import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
        Sign in Page
 */

public class SignIn extends JFrame {

    JLabel lblUsername = new JLabel("UserName"),
            lblPassword = new JLabel ("Password");


    JTextField txtuserName = new JTextField(10);
    JPasswordField password = new JPasswordField(10);

    JButton btnsign =new JButton("Sign in"),
            btnclear=new JButton("clear");

   static MainFrame main = new MainFrame() ;

 Users s =null;
    public SignIn(){

        try {
            FileInputStream fileIn = new FileInputStream("Users.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            s = (Users) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }


        JFrame Main = new JFrame("Sign in");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,200,200);
        setLayout(new BorderLayout());

        JPanel pnlCenter = new JPanel();
        pnlCenter.add(lblUsername);
        pnlCenter.add(txtuserName);
        pnlCenter.add(lblPassword);
        pnlCenter.add(password);
        add(new JPanel(),BorderLayout.NORTH);
        add(pnlCenter,BorderLayout.CENTER);

        JPanel pnlSouth = new JPanel();
        pnlSouth.setLayout(new FlowLayout());
        pnlSouth.add(btnsign);
        pnlSouth.add(btnclear);

        add(pnlSouth,BorderLayout.SOUTH);


        btnclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtuserName.setText("");
                password.setText("");
            }
        });

        btnsign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((txtuserName.getText().equals(s.UserName))&&(new String(password.getPassword()).equals(s.PassWord))) {
                    JOptionPane.showMessageDialog(null, "Success");
                    main.setVisible(true);
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Password Try again");

            }
        });

    }



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignIn frame = new SignIn();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
