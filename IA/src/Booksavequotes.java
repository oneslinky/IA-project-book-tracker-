import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
public class Booksavequotes extends JFrame {
    private JPanel onebookquotes;
    private JButton btnsave;
    private JButton goBackButton;
    private JButton btneditsave;
    private JButton btneditload;
    private JTextArea txtbtitle;
    private JTextArea txtq0;
    private JTextArea txtq1;
    private JTextArea txtq2;
    private JTextArea txtq3;
    private JTextArea txtq4;
    private JTextArea txtq5;
    private JTextArea txtq6;
    private JTextArea txtq7;
    private JTextArea txtq8;
    private JTextArea txtq9;
    static ArrayList <Quotes> quoteList = new ArrayList<>();
    String StringOld;
    String StringNew;
    String quotetitle;
    int editStart = 0;
    int editEnd = 0;
    public Booksavequotes(){
        setContentPane(onebookquotes);
        setTitle("Book Tracker");
        setSize(1400, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Quotes bookquotes = new Quotes (txtbtitle.getText(), txtq0.getText(), txtq1.getText(), txtq2.getText(), txtq3.getText(), txtq4.getText(), txtq5.getText() , txtq6.getText(), txtq7.getText(),txtq8.getText(),txtq9.getText());
                    quoteList.add(bookquotes);
                    String text = bookquotes.toString();
                    FileWriter fwriter = new FileWriter( "Quotes.txt", true);
                    fwriter.write(text);
                    fwriter.close();
                }
                catch (IOException h) {
                    System.out.print(h.getMessage());
                }
                dispose();
                Allquotesform aQuotes = new Allquotesform();
                aQuotes.show();

            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Allquotesform aQuotes = new Allquotesform();
                aQuotes.show();
            }
        });
        btneditload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtbtitle.getText().equals("")){
                    txtbtitle.setText("enter book title you want to edit the details of(case sensitive)");
                    txtq0.setText("");
                    txtq1.setText("");
                    txtq2.setText("");
                    txtq3.setText("");
                    txtq4.setText("");
                    txtq5.setText("");
                    txtq6.setText("");
                    txtq7.setText("");
                    txtq8.setText("");
                    txtq9.setText("");
                }
                else {
                    quotetitle = txtbtitle.getText();
                    try {
                        FileReader fr = new FileReader("Quotes.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String s;
                        while ((s = br.readLine())!=null){
                            String [] quotedetails = s.split("~");
                            editEnd++;
                            if(quotetitle.equals(quotedetails[0])){
                                txtbtitle.setText(quotedetails[0]);
                                txtq0.setText(quotedetails[1]);
                                txtq1.setText(quotedetails[2]);
                                txtq2.setText(quotedetails[3]);
                                txtq3.setText(quotedetails[4]);
                                txtq4.setText(quotedetails[5]);
                                txtq5.setText(quotedetails[6]);
                                txtq6.setText(quotedetails[7]);
                                txtq7.setText(quotedetails[8]);
                                txtq8.setText(quotedetails[9]);
                                txtq9.setText(quotedetails[10]);
                                break;
                            }
                            else{
                                txtbtitle.setText("enter book title you want to edit the details of(case sensitive)");
                                txtq0.setText("");
                                txtq1.setText("");
                                txtq2.setText("");
                                txtq3.setText("");
                                txtq4.setText("");
                                txtq5.setText("");
                                txtq6.setText("");
                                txtq7.setText("");
                                txtq8.setText("");
                                txtq9.setText("");
                            }
                        }
                    }
                    catch (IOException h){
                        System.out.println(h.getMessage());
                    }
                }
            }
        });
        btneditsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modifiedFileContent;
                String originalFileContent = "";
                Quotes quotesOld;
                Quotes quotesNew;
                BufferedWriter bw = null;
                try{
                    FileReader fr = new FileReader("Quotes.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String s;
                    while ((s = br.readLine())!=null){
                        if(editStart == editEnd-1){
                            String [] quoteDetail = s.split("~");
                            quotesOld = new Quotes(quoteDetail[0],quoteDetail[1],quoteDetail[2],quoteDetail[3],quoteDetail[4],quoteDetail[5],quoteDetail[6],quoteDetail[7],quoteDetail[8],quoteDetail[9],quoteDetail[10]);
                            StringOld = quotesOld.toString();
                        }
                        editStart++;
                    }
                }
                catch (IOException h){
                    System.out.println(h.getMessage());
                }
                try{
                    FileReader fr = new FileReader("Quotes.txt");
                    BufferedReader br = new BufferedReader(fr);
                    quotesNew = new Quotes(txtbtitle.getText(),txtq0.getText(), txtq1.getText(), txtq2.getText(), txtq3.getText(), txtq4.getText(), txtq5.getText() , txtq6.getText(), txtq7.getText(),txtq8.getText(),txtq9.getText());
                    StringNew = quotesNew.toString();
                    String currentReadingLine = br.readLine();
                    while (currentReadingLine != null) {
                        originalFileContent += currentReadingLine + System.lineSeparator();
                        currentReadingLine = br.readLine();
                    }
                    bw = new BufferedWriter(new FileWriter("Quotes.txt"));
                    modifiedFileContent = originalFileContent.replaceAll(StringOld,StringNew);
                    bw.write(modifiedFileContent);
                    bw.close();
                    br.close();
                }
                catch (IOException h){
                    System.out.println(h.getMessage());
                }
                dispose();
                Allquotesform Qa = new Allquotesform();
                Qa.show();
            }
        });
    }
}
