import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Booksavequotes extends JFrame {
    private JPanel onebookquotes;
    private JButton btnsave;
    private JButton goBackButton;
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
    public Booksavequotes(){
        setContentPane(onebookquotes);
        setTitle("Book Tracker");
        setSize(1000, 800);
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
                try{
                    char[] charBuffer = new char[50];
                    FileReader fr = new FileReader("Quotes.txt");
                    while (fr.read()!= -1){
                        fr.read(charBuffer,10,-1);
                        String btitle = ""+charBuffer[0];
                        for(int i = 1; i<charBuffer.length;i++){
                            btitle = charBuffer[i]+btitle;
                        }
                        if(btitle.equals(txtbtitle.getText())){

                        }
                    }
                }
                catch (IOException h){
                    System.out.println(h.getMessage());
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
    }
}
