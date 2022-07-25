import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Allquotesform extends JFrame{
    private JPanel allquote;
    private JButton btnMain;
    private JButton btnaddbook;
    private JButton btnview;
    private JTable tblquotes;
    private JScrollPane tablepanel;
    private JTextField textField1;

    public Allquotesform(){
        setContentPane(allquote);
        setTitle("Book Tracker");
        setSize(2000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

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
                File file = new File("Quotes.txt");
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    // get the first line
                    // get the columns name from the first line
                    // set columns name to the jtable model
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split("~");
                    DefaultTableModel model =(DefaultTableModel) tblquotes.getModel();
                    model.setColumnIdentifiers(columnsName);
                    // get lines from txt file
                    Object[] tableLines = br.lines().toArray();
                    // extratct data from lines
                    // set data to jtable model
                    for(int i = 0; i < tableLines.length; i++)
                    {
                        String line = tableLines[i].toString().trim();
                        String[] dataRow = line.split("~");
                        model.addRow(dataRow);
                    }
                    tablepanel.add(new JTable(model));



                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
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
