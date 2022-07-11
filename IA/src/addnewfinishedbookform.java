import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addnewfinishedbookform extends JFrame {
    private JTextArea txtgenre;
    private JTextArea txtchar;
    private JTextArea txtreview;
    private JTextField txtbtitle;
    private JTextField txtauthname;
    private JTextField txtstarrate;
    private JButton btnsave;
    private JTextArea txtescale;
    private JTextField txtdeath;
    private JTextField txtlove;
    private JTextField txtptwist;
    private JTextField txtcry;
    private JTextField txtnewchar;
    private JLabel lblbooktitle;
    private JLabel lblauthname;
    private JLabel lblstar;
    private JLabel lblgenre;
    private JLabel lblcharacters;
    private JLabel lblreview;
    private JLabel lblemotion;
    private JLabel lblnewchar;
    private JLabel lblcry;
    private JLabel lblptwist;
    private JLabel lbllove;
    private JLabel lbldeath;
    private JLabel lblsigmo;
    private JPanel addbook;
    public addnewfinishedbookform(){
        setContentPane(addbook);
        setTitle("book tracker");
        setSize(815, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                finishedreadingform haze= new finishedreadingform();
                haze.show();
            }
        });
    }
}
