import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private JButton editCurrentlyReadingButton;
    private JButton saveCurrentlyReadingButton;
    static ArrayList <Finishedbook> finishedreading = new ArrayList<Finishedbook>();
    static String StringOld;
    static String StringNew;
    public Addnewfinishedbookform(){
        setContentPane(addbook);
        setTitle("Book Tracker");
        setSize(1400, 800);
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
        editCurrentlyReadingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int startlineNumber = 0;
                int endLineNumber = 0;
                try {
                    FileReader fr = new FileReader("Booktracker.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String s;
                    while ((s = br.readLine())!=null){
                        endLineNumber++;
                    }
                }
                catch (IOException h){
                    System.out.println(h.getMessage());
                }
                try{
                    FileReader fr = new FileReader("Booktracker.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String s;
                    while ((s = br.readLine())!=null){
                        if(startlineNumber == endLineNumber-1){
                            String [] bookDetail = s.split("~");
                            Finishedbook finBook = new Finishedbook(bookDetail[0],bookDetail[1],bookDetail[2],bookDetail[3],bookDetail[4],bookDetail[5],bookDetail[6]);
                            txtbtitle.setText(finBook.getBookTitle());
                            txtauthname.setText(finBook.getAuthorName());
                            txtstarrate.setText(finBook.getStarRating());
                            txtgenre.setText(finBook.getGenre());
                            txtchar.setText(finBook.getCharacter());
                            txtreview.setText(finBook.getReview());
                            txtescale.setText(finBook.getEmotionScale());
                        }
                        startlineNumber++;
                    }
                }
                catch (IOException h){
                    System.out.println(h.getMessage());
                }

            }
        });
        saveCurrentlyReadingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int startlineNumber = 0;
                int endLineNumber = 0;
                String modifiedFileContent;
                String originalFileContent = "";
                Finishedbook finBookOld;
                Finishedbook finbookNew;
                BufferedWriter bw = null;
                try {
                    FileReader fr = new FileReader("Booktracker.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String s;
                    while ((s = br.readLine())!=null){
                        endLineNumber++;
                    }
                }
                catch (IOException h){
                    System.out.println(h.getMessage());
                }
                try{
                    FileReader fr = new FileReader("Booktracker.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String s;
                    while ((s = br.readLine())!=null){
                        if(startlineNumber == endLineNumber-1){
                            String [] bookDetail = s.split("~");
                            finBookOld= new Finishedbook(bookDetail[0],bookDetail[1],bookDetail[2],bookDetail[3],bookDetail[4],bookDetail[5],bookDetail[6]);
                            StringOld = finBookOld.toString();
                        }
                        startlineNumber++;
                    }
                }
                catch (IOException h){
                    System.out.println(h.getMessage());
                }
                try{
                    FileReader fr = new FileReader("Booktracker.txt");
                    BufferedReader br = new BufferedReader(fr);
                    finbookNew= new Finishedbook(txtbtitle.getText(),txtauthname.getText(),txtstarrate.getText(),txtgenre.getText(),txtchar.getText(),txtreview.getText(),txtescale.getText());
                    StringNew = finbookNew.toString();
                    String currentReadingLine = br.readLine();
                    while (currentReadingLine != null) {
                        originalFileContent += currentReadingLine + System.lineSeparator();
                        currentReadingLine = br.readLine();
                    }
                    modifiedFileContent = originalFileContent.replaceAll(StringOld,StringNew);
                    bw = new BufferedWriter(new FileWriter("Booktracker.txt"));
                    bw.write(modifiedFileContent);
                    bw.close();
                    br.close();
                }
                catch (IOException h){
                    System.out.println(h.getMessage());
                }
                dispose();
                Finishedreadingform fReading = new Finishedreadingform();
                fReading.show();
            }
        });
    }
}
