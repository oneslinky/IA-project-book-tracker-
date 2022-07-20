import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
public class Mainform extends JFrame {
    private JButton btnfinread;
    private JButton btnaddfinread;
    private JButton btnallbookquote;
    private JButton btnquotes;
    private JButton btneditcurr;
    private JButton btnrecc;
    private JButton btnexit;
    private JPanel mform;
    private JScrollPane jpdisplayread;
    private JScrollPane jpdisplaycurr;
    private JScrollPane jpdisplayrec;
    private JTextArea txtranquote;
    static ArrayList<String> allquotes = new ArrayList<String>();
    int lineNumber;
    public Mainform() {
        setContentPane(mform);
        setTitle("Book Tracker");
        setSize(815, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        try{
            FileReader fr = new FileReader("Quotes.txt");
            BufferedReader br = new BufferedReader(fr);
            lineNumber = 1;
            String[] quotes = null;
            String s;
            while ((s = br.readLine())!=null){
                if(lineNumber % 2 == 0){
                     quotes = s.split("~");
                    for(int i = 0; i < quotes.length; i++){
                        allquotes.add(quotes[i]);
                    }
                }
                lineNumber++;
            }
        }
        catch (IOException h){
            System.out.println(h.getMessage());
        }
        if(allquotes.size() > 0){
            int dquote = (int)(Math.random()*(allquotes.size()+1+1));
            txtranquote.setText(allquotes.get(dquote));
        }
        else{
            txtranquote.setText("Enter quotes for this feature to work");
        }
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