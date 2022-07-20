import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Mainform extends JFrame {
    private JButton btnfinread;
    private JButton btnaddfinread;
    private JButton btnallbookquote;
    private JButton btnquotes;
    private JButton btneditcurr;
    private JButton btnrecc;
    private JPanel mform;
    private JScrollPane jpdisplayread;
    private JScrollPane jpdisplaycurr;
    private JScrollPane jpdisplayrec;
    private JButton btnexit;
    private JTextField txtdquote;
    static ArrayList<String> allquotes = new ArrayList<String>();

    public Mainform() {
        setContentPane(mform);
        setTitle("Book Tracker");
        setSize(815, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        /*int dquote= (int)(Math.random()*(allquotes.size()+1+1));
        txtdquote.setText(allquotes.get(dquote));*/
        btnfinread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Finishedreadingform finread1 = new Finishedreadingform();
                finread1.show();
            }
        });
        btnaddfinread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Addnewfinishedbookform addFinread1 = new Addnewfinishedbookform();
                addFinread1.show();

            }
        });
        btnallbookquote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Allquotesform quote=new Allquotesform();
                quote.show();
            }
        });
        btnquotes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Booksavequotes bookq=new Booksavequotes();
                bookq.show();
            }
        });
        btneditcurr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Addnewfinishedbookform curredit=new Addnewfinishedbookform();
                curredit.show();
            }
        });
        btnrecc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Recommendationform bookreccs = new Recommendationform();
                bookreccs.show();
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
        Mainform MF = new Mainform();
    }
}
