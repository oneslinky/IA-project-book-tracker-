import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
public class Loginform extends JFrame {
    private JButton btnlogin;
    private JPasswordField txtpass;
    private JTextField txtuser;
    private JLabel lblpass;
    private JLabel lbluser;
    private JLabel lbltitle;
    private JPanel lpage;
    private JButton btncancel;
    public Loginform(){
        setContentPane(lpage);
        setSize(600,300);
        setTitle("Book Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        File bFile = new File("Booktracker.txt");
        File qFile = new File("Quotes.txt");
        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtuser.getText().equals("nwteren")&& txtpass.getText().equals("password")) {
                    dispose();
                    Mainform mF1 = new Mainform();
                    mF1.show();
                }
                else{
                    txtuser.setText("incorrect username or password. retry");
                    txtpass.setText("");
                }
            }
        });

        btncancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtuser.setText("");
                txtpass.setText("");
            }
        });
    }
    public static void main(String[] args){
        Loginform LF = new Loginform();
    }
}
