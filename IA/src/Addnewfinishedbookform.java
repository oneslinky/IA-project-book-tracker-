import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.*;
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
    static ArrayList <Finishedbook> finishedreading = new ArrayList<Finishedbook>();
    public Addnewfinishedbookform(){
        setContentPane(addbook);
        setTitle("Book Tracker");
        setSize(2000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Finishedbook finBook = new Finishedbook (txtbtitle.getText(), txtauthname.getText(), txtstarrate.getText(), txtgenre.getText(), txtchar.getText(), txtreview.getText(), txtescale.getText());
                    String text = finBook.toString();
                    finishedreading.add(finBook);
                    FileWriter fwriter = new FileWriter( "Booktracker.txt", true);
                    FileReader fr = new FileReader ("Booktracker.txt");
                    BufferedReader br = new BufferedReader(fr);
                    int index;
                    String btitle = "";
                    char[] title = new char[50];
                    while (br.readLine()!=null){
                        Pattern p = Pattern.compile(br.readLine());
                        Matcher m = p.matcher("Book title:");
                        index = m.end();
                        br.read(title,index,50);
                        for(int i = 0; i < title.length; i++){
                            btitle = btitle + title[i];
                        }
                        if((btitle).equals(finBook.getBookTitle())){

                        }
                    }
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
