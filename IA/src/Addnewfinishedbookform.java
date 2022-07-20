import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;

public class Addnewfinishedbookform extends JFrame {
    private JTextArea txtgenre;
    private JTextArea txtchar;
    private JTextArea txtreview;
    private JTextArea txtescale;
    private JTextField txtbtitle;
    private JTextField txtauthname;
    private JTextField txtstarrate;
    private JButton btnsave;
    private JButton goBackButton;
    private JPanel addbook;
    private JLabel lblbooktitle;
    private JLabel lblauthorname;
    private JLabel lblstar;
    private JLabel lblgenre;
    private JLabel lblcharacters;
    private JLabel lblreview;
    private JLabel lblemotion;
    public Addnewfinishedbookform(){
        setContentPane(addbook);
        setTitle("Book Tracker");
        setSize(815, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Finishedbook finBook = new Finishedbook (txtbtitle.getText(), txtauthname.getText(), txtstarrate.getText(), txtgenre.getText(), txtchar.getText(), txtreview.getText(), txtescale.getText());
                    String text = finBook.toString();
                    FileWriter fwriter = new FileWriter( "Booktracker.txt", true);
                    fwriter.write(text);
                    fwriter.close();
                }
                catch (IOException h) {
                    System.out.print(h.getMessage());
                }
                dispose();
                Finishedreadingform fReading = new Finishedreadingform();
                fReading.show();
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Finishedreadingform fReading = new Finishedreadingform();
                fReading.show();
            }
        });
    }
}
