import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADD extends JDialog {
    JLabel lblUserName = new JLabel("User Name:"),
            lblPassWord = new JLabel("Password"),
            lblEmail  =  new JLabel("Email"),
            lblWebsite = new JLabel("Website");

    JTextField txtUserName = new JTextField(10),
                txtPassWord = new JTextField(10),
                txtEmail = new JTextField(10),
                txtWebsite = new JTextField(10);

    JButton btnaddedit = new JButton("ADD");
    Passwords newPassword;
    public int index = 0;
DefaultListModel<Passwords> parentDlm;
protected Passwords passwordSelected = new Passwords();


    public ADD(){
        JFrame add = new JFrame("ADD/EDIT");
        setBounds(100,100,500,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5,2));

        JPanel pnlbutton = new JPanel();
        pnlbutton.setSize(100,200);
        pnlbutton.add(btnaddedit);

        add(lblUserName);
        add(txtUserName);
        add(lblPassWord);
        add(txtPassWord);
        add(lblEmail);
        add(txtEmail);
        add(lblWebsite);
        add(txtWebsite);
        add(new JLabel());
        add(btnaddedit);
        parentDlm = new DefaultListModel<Passwords>();
        btnaddedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newPassword = new Passwords();
                newPassword.userName = txtUserName.getText();
                newPassword.passWord = txtPassWord.getText();
                newPassword.email = txtEmail.getText();
                newPassword.website=txtWebsite.getText();
                System.out.println(newPassword);
                dispose();


                if(btnaddedit.getText().equals("ADD")){
                    parentDlm.addElement(newPassword);
                    System.out.println(parentDlm.toString());
                    Clear();
                }

                if(btnaddedit.getText().equals("EDIT")){
                    parentDlm.removeElementAt(index);
                    parentDlm.add(index , newPassword);

                }
            }
        });


        }

    public void Clear(){
        txtEmail.setText("");
        txtPassWord.setText("");
        txtUserName.setText("");
        txtWebsite.setText("");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ADD frame = new ADD();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
