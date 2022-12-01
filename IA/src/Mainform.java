import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private JButton btnexit;
    private JPanel mform;
    private JScrollPane scrollpanel;
    private JTextArea txtranquote;
    private JTable tblbooks;
    private JLabel lblcurrreadtitle;
    private JTextField txtbtitlecurr;
    private JLabel lblnotescurr;
    private JTextArea txtreviewcurr;
    static ArrayList<String> allquotes = new ArrayList<String>();
    int lineNumber;
    int startlineNumber = 0;
    int endLineNumber = 0;
    public Mainform() {
        setContentPane(mform);
        setTitle("Book Tracker");
        setSize(1400, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        try{
            FileReader fr = new FileReader("Quotes.txt");
            BufferedReader br = new BufferedReader(fr);
            lineNumber = 1;
            String s;
            while ((s = br.readLine())!=null){//read the current line until there are no more lines
                if(lineNumber > 1){
                     String [] quotes = s.split("~");//placing all the data into an array
                     String [] quotes2 = new String[] {quotes[1],quotes[2],quotes[3],quotes[4],quotes[5],
                             quotes[6],quotes[7],quotes[8],quotes[9]};
                     //transferring the data and removing the unneeded value
                    for(int i = 0; i < quotes2.length; i++){
                        allquotes.add(quotes2[i]);//adding the strings to an arraylist
                    }
                }
                lineNumber++;
            }
        }
        catch (IOException h){
            System.out.println(h.getMessage());
        }
        if(allquotes.size() > 0){//validation check if the arraylist contains values
            int dquote = (int)(Math.random()*(allquotes.size()+1+1));//randomize an index based on the size of the arraylist
            txtranquote.setText(allquotes.get(dquote));//displaying the choosen data value from the random index number
        }
        else{
            txtranquote.setText("Enter quotes for this feature to work");//validation check
        }
        File file = new File("Booktracker.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine().trim();
            String[] columnsName = new String[1];
            columnsName[0] = "Book title";
            DefaultTableModel model = (DefaultTableModel) tblbooks.getModel();
            model.setColumnIdentifiers(columnsName);
            Object[] tableLines = br.lines().toArray();
            for (int i = 0; i < tableLines.length; i++ ) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("~",2);
                String[] row = new String[1];
                row[0] = dataRow[0];
                model.addRow(row);
            }
            scrollpanel.add(new JTable(model));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
                    txtbtitlecurr.setText(finBook.getBookTitle());
                    txtreviewcurr.setText(finBook.getReview());
                }
                startlineNumber++;
            }
        }
        catch (IOException h){
            System.out.println(h.getMessage());
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
                Allquotesform quote = new Allquotesform();
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