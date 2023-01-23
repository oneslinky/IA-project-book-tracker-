import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import java.util.Locale;

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
    private JButton editCurrentlyReadingButton;
    private JButton saveCurrentlyReadingButton;
    private JButton btnload;
    private JButton saveEditsToBookButton;
    private JPanel addbook;
    private JLabel lblbooktitle;
    private JLabel lblauthorname;
    private JLabel lblstar;
    private JLabel lblgenre;
    private JLabel lblcharacters;
    private JLabel lblreview;
    private JLabel lblemotion;
    static ArrayList <Finishedbook> finishedreading = new ArrayList<Finishedbook>();
    String StringOld;
    String StringNew;
    String booktitl;
    int editStart = 0;
    int editEnd = 0;
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
                    if (txtbtitle.getText().equals("")){
                        txtbtitle.setText("please fill out all book details");
                    }
                    else if (txtbtitle.getText().equals("enter book title you want to edit the details of")
                    ||txtbtitle.getText().equals("please fill out all book details")
                            ||txtbtitle.getText().equals("enter a different book")){
                        txtbtitle.setText("please fill out all book details");
                    }
                    else if (!(txtbtitle.getText()==null)){
                        String title = txtbtitle.getText();
                        String titleLow = title.toLowerCase(Locale.ROOT);
                        int flag = 0;
                        FileReader fr = new FileReader("Booktracker.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String s;
                        while ((s = br.readLine())!=null){
                            String[] detail = s.split("~");
                            String detailLow = detail[0].toLowerCase(Locale.ROOT);
                            if (titleLow.equals(detailLow)){
                                txtbtitle.setText("enter NEW different book");
                                flag++;
                                break;
                            }
                        }
                        if (flag==0){
                            //grab the written data from user
                            Finishedbook finBook = new Finishedbook (txtbtitle.getText(), txtauthname.getText(),
                                    txtstarrate.getText(), txtgenre.getText(), txtchar.getText(),
                                    txtreview.getText(), txtescale.getText());
                            String text = finBook.toString();
                            //place as a to string method so it has "~" symbol for Regex use when displaying
                            finishedreading.add(finBook);
                            //find and append the text file
                            FileWriter fwriter = new FileWriter( "Booktracker.txt", true);
                            /*use the file writer class to add new text on the file while
                            keeping data integrity from the true append*/
                            fwriter.write(text);
                            fwriter.close();
                            dispose();
                            Finishedreadingform fReading = new Finishedreadingform();
                            fReading.show();
                        }
                    }
                }
                catch (IOException h) {
                    System.out.println(h.getMessage());
                    dispose();
                }

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
                            //using the getter methods to set the text of text field
                            Finishedbook finBook = new Finishedbook(bookDetail[0],
                                    bookDetail[1],bookDetail[2],bookDetail[3],
                                    bookDetail[4],bookDetail[5],bookDetail[6]);
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
                    dispose();
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
                    finbookNew= new Finishedbook(txtbtitle.getText(),txtauthname.getText(),txtstarrate.getText(),
                            txtgenre.getText(),txtchar.getText(),txtreview.getText(),txtescale.getText());
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
        btnload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtbtitle.getText().equals("")){//validation check (did the user input anything?)
                    txtbtitle.setText("enter book title you want to edit the details of");
                    txtauthname.setText("");
                    txtstarrate.setText("");
                    txtgenre.setText("");
                    txtchar.setText("");
                    txtreview.setText("");
                    txtescale.setText("");
                }
                else {
                    booktitl = txtbtitle.getText();//input the existing string as the title for validation check
                    String booktitlLow = booktitl.toLowerCase(Locale.ROOT);
                    try {
                        FileReader fr = new FileReader("Booktracker.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String s;
                        while ((s = br.readLine())!=null){
                            //check if the line has words in the file and places the entire line in S
                            String [] bookDetail = s.split("~");//split the line into an array
                            editEnd++;//mark the end index of the found title for data integrity
                            String bookTitleLow = bookDetail[0].toLowerCase(Locale.ROOT);
                            if(booktitlLow.equals(bookTitleLow)){
                                txtbtitle.setText(bookDetail[0]);
                                txtauthname.setText(bookDetail[1]);
                                txtstarrate.setText(bookDetail[2]);
                                txtgenre.setText(bookDetail[3]);
                                txtchar.setText(bookDetail[4]);
                                txtreview.setText(bookDetail[5]);
                                txtescale.setText(bookDetail[6]);
                                break;//re-display the data back to client on dialouge boxes
                            }
                            else{//validation check that the book title inputted is a valid book in the file.
                                txtbtitle.setText(
                                        "enter book title you want to edit the details of");
                                txtauthname.setText("");
                                txtstarrate.setText("");
                                txtgenre.setText("");
                                txtchar.setText("");
                                txtreview.setText("");
                                txtescale.setText("");
                            }
                        }
                    }
                    catch (IOException h){
                        System.out.println(h.getMessage());
                    }
                }
            }
        });
        saveEditsToBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modifiedFileContent;
                String originalFileContent = "";
                Finishedbook finBookOld;
                Finishedbook finbookNew;
                BufferedWriter bw = null;
                try{
                    FileReader fr = new FileReader("Booktracker.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String s;
                    while ((s = br.readLine())!=null){
                        //if the start index while parsing the file matches with the marked index from above
                        if(editStart == editEnd-1){
                            String [] bookDetail = s.split("~");
                            //input old data for switching with new data
                            finBookOld= new Finishedbook(bookDetail[0],bookDetail[1],bookDetail[2],bookDetail[3],
                                    bookDetail[4], bookDetail[5],bookDetail[6]);
                            StringOld = finBookOld.toString();
                        }
                        editStart++;//increase the start index until start index matches with end index
                    }
                }
                catch (IOException h){
                    System.out.println(h.getMessage());
                }
                try{
                    FileReader fr = new FileReader("Booktracker.txt");
                    BufferedReader br = new BufferedReader(fr);
                    //input new data into another finishedbook object
                    finbookNew= new Finishedbook(txtbtitle.getText(),txtauthname.getText(),
                            txtstarrate.getText(),txtgenre.getText(),
                            txtchar.getText(),txtreview.getText(),txtescale.getText());
                    StringNew = finbookNew.toString();
                    String currentReadingLine = br.readLine();
                    while (currentReadingLine != null) {
                        originalFileContent += currentReadingLine + System.lineSeparator();
                        currentReadingLine = br.readLine();//compile entire file into a string
                    }
                    //switch the old data with the new data
                    modifiedFileContent = originalFileContent.replaceAll(StringOld,StringNew);
                    bw = new BufferedWriter(new FileWriter("Booktracker.txt"));
                    //rewrite the data with the change while keeping previous data the same
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
