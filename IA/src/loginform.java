import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginform extends JFrame {
    private JButton btnlogin;
    private JPasswordField txtpass;
    private JTextField txtuser;
    private JLabel lblpass;
    private JLabel lbluser;
    private JLabel lbltitle;
    private JPanel lpage;
    private JButton btncancel;

    public loginform(){
        setContentPane(lpage);
        setSize(600,300);
        setTitle("book tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtuser.getText().equals("nwteren")&& txtpass.getText().equals("password")) {//this is where like databse comes in
                    dispose();
                    Mainform mainf1 = new Mainform();
                    mainf1.show();
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
        loginform pizza=new loginform();
    }
}
