import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Allquotesform extends JFrame{
    private JPanel allquote;
    private JButton btnMain;
    private JButton btnaddbook;
    private JButton btnview;
    private JTextField txtbookname;

    public Allquotesform(){
        setContentPane(allquote);
        setTitle("Book Tracker");
        setSize(815, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        try{
            FileReader fr = new FileReader("Quotes.txt");
            BufferedReader br = new BufferedReader(fr);
            String text;
            br.skip(11);
            text=br.readLine();
            txtbookname.setText(text);

        }
        catch(IOException h){
            System.out.println(h.getMessage());
        }
        btnMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mainform mF1 = new Mainform();
                mF1.show();
            }
        });
        btnview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               Booksavequotes bSQ = new Booksavequotes();
               bSQ.show();
            }
        });
        btnaddbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Booksavequotes addBSQ= new Booksavequotes();
                addBSQ.show();
            }
        });
    }

}
