import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{


    public JButton btnAdd = new JButton("ADD"),
                   btndelete = new JButton("Delete"),
                    btnEdit = new JButton("EDIT");


    static DefaultListModel<Passwords> dlm = new DefaultListModel<Passwords>();

    JList<Passwords> lstPasswords;
    JScrollPane scrollPane;

    static ADD add = new ADD();
    protected Passwords passwordSelected;
    public MainFrame(){
        JFrame mainFrame = new JFrame("PassWord Saver");
        setBounds(100,100,1000,279);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JMenuBar menuBar=new JMenuBar();
        add(menuBar,BorderLayout.NORTH);



        dlm = new DefaultListModel<Passwords>();
        lstPasswords = new JList(dlm);
        scrollPane = new JScrollPane(lstPasswords);

        add(lstPasswords,BorderLayout.CENTER);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenu menuSave = new JMenu("Save");
        mnFile.add(menuSave);

        JMenuItem menuItemSaveText = new JMenuItem("Text file");
        menuSave.add(menuItemSaveText);

        JMenuItem menuItemSaveSeq = new JMenuItem("Sequential File");
        menuSave.add(menuItemSaveSeq);

        JMenu menuLoad = new JMenu("Load");
        mnFile.add(menuLoad);

        JMenuItem menuItemLoadText = new JMenuItem("From text file");

        menuLoad.add(menuItemLoadText);

        JMenuItem menuItemLoadSeq = new JMenuItem("from seq. file");
        menuLoad.add(menuItemLoadSeq);


        JPanel pnlSouth = new JPanel();
        pnlSouth.add(btnAdd);
        pnlSouth.add(btndelete);
        pnlSouth.add(btnEdit);

        add(pnlSouth,BorderLayout.SOUTH);
        btnEdit.setEnabled(false);
        btndelete.setEnabled(false);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                add.setVisible(true);
                add.setTitle("ADD");
                add.parentDlm=dlm;
                add.btnaddedit.setText("ADD");


            }
        });
        lstPasswords.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                btndelete.setEnabled(lstPasswords.getSelectedIndex() >= 0);
                btnEdit.setEnabled(lstPasswords.getSelectedIndex() >= 0);
            }
        });

        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlm.remove(lstPasswords.getSelectedIndex());
            }
        });


        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                add.setVisible(true);
                add.setTitle("Edit");
                add.btnaddedit.setText("EDIT");
                Passwords password = ((Passwords) (lstPasswords.getSelectedValue()));
                add.passwordSelected = password;
                add.parentDlm=dlm;
                add.txtWebsite.setText(String.valueOf(password.website));
                add.txtUserName.setText(String.valueOf(password.userName));
                add.txtPassWord.setText(String.valueOf(password.passWord));
                add.txtEmail.setText(String.valueOf(password.email));



            }
        });

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}