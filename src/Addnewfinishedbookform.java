import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;

public class Addnewfinishedbookform extends JFrame {
    private JTextArea txtgenre;
    private JTextArea txtchar;
    private JTextArea txtreview;
    private JTextField txtbtitle;
    private JTextField txtauthname;
    private JTextField txtstarrate;
    private JButton btnsave;
    private JTextArea txtescale;
    private JLabel lblbooktitle;
    private JLabel lblauthname;
    private JLabel lblstar;
    private JLabel lblgenre;
    private JLabel lblcharacters;
    private JLabel lblreview;
    private JLabel lblemotion;
    private JPanel addbook;
    private JButton goBackButton;
    static ArrayList<Finishedbook> finsihedbookslist = new ArrayList<Finishedbook>();
    public Addnewfinishedbookform(){
        setContentPane(addbook);
        setTitle("Book Tracker");
        setSize(815, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        /*try {
            FileReader fr = new FileReader("Booktracker.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                String temp = br.readLine();
                String[] bInfo = temp.split("~");
                String btitle = bInfo[0];
                String aName = bInfo[1];
                String sRate = bInfo[2];
                String gen = bInfo[3];
                String chars = bInfo[4];
                String revs = bInfo[5];
                String eScale = bInfo[6];
                Finishedbook tempBook = new Finishedbook(btitle, aName, sRate, gen, chars, revs, eScale);
                finsihedbookslist.add(tempBook);
            }
        }
        catch (IOException h){
            System.out.println((h.getMessage()));
        }*/
        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Finishedbook finBook = new Finishedbook (txtbtitle.getText(), txtauthname.getText(), txtstarrate.getText(), txtgenre.getText(), txtchar.getText(), txtreview.getText(), txtescale.getText());
                    finsihedbookslist.add(finBook);
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
