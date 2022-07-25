import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Loginform extends JFrame {
    private JButton btnlogin;
    private JPasswordField txtpass;
    private JTextField txtuser;
    private JLabel lblpass;
    private JLabel lbluser;
    private JLabel lbltitle;
    private JPanel lpage;
    private JButton btncancel;
    private JCheckBox firstTImeCheckBox;

    public Loginform(){
        setContentPane(lpage);
        setSize(200,800);
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
                else if (txtuser.getText().equals("larapaulina")&& txtpass.getText().equals("0709")){
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
        firstTImeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    FileWriter fr = new FileWriter(qFile);
                    FileWriter br = new FileWriter(bFile);
                    String textQ = "Book Title~Quote 1~Quote 2~Quote 3~Quote 4~Quote 5~Quote 6~Quote 7~Quote 8~Quote 9~Quote 10";
                    String textB = "Book Title~Author Name~Star Rating~Genre~Character~Review~Emotional Scale";
                    fr.write(textQ);
                    br.write(textB);
                    fr.close();
                    br.close();
                }
                catch(IOException h){
                    System.out.println(h.getMessage());
                }

            }
        });
    }
    public static void main(String[] args){
        Loginform LF = new Loginform();
    }
}
