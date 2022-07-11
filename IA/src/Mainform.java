import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainform extends JFrame {
    private JButton btnfinread;
    private JButton btnaddfinread;
    private JButton btnallbookquote;
    private JButton btnquotes;
    private JButton btncurrread;
    private JButton btneditcurr;
    private JButton btnrecc;
    private JPanel mform;
    private JScrollPane jpdisplayread;
    private JScrollPane jpdisplayquote;
    private JScrollPane jpdisplaycurr;
    private JScrollPane jpdisplayrec;
    private JButton btnexit;

    public Mainform() {
        setContentPane(mform);
        setTitle("book tracker");
        setSize(815, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnfinread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                finishedreadingform potato= new finishedreadingform();
                potato.show();

            }
        });
        btnaddfinread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                addnewfinishedbookform potato= new addnewfinishedbookform();
                potato.show();

            }
        });
        btncurrread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                currentlyreadingform everyone=new currentlyreadingform();
                everyone.show();
            }
        });
        btnallbookquote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                allquotesform quote=new allquotesform();
                quote.show();
            }
        });
        btnquotes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                booksavequotes bookq=new booksavequotes();
                bookq.show();
            }
        });
        btneditcurr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                currentlyreadingeditform curryedit=new currentlyreadingeditform();
                curryedit.show();
            }
        });
        btnrecc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                recommendationform delicous= new recommendationform();
                delicous.show();
            }
        });
        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public static void main(String[] args){
        Mainform pizza=new Mainform();
    }
}
