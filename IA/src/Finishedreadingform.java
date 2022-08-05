import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Finishedreadingform extends JFrame {
    private JButton btnmain;
    private JButton btnalldetails;
    private JButton btneditcurread;
    private JButton btnadd;
    private JPanel finished;
    private JTextField txtbtitlecurr;
    private JTextField txtauthcurr;
    private JTextField txtstarcurr;
    private JLabel lbltitle;
    private JLabel lblcurrread;
    private JLabel lblbtitlecurr;
    private JLabel lblaNamecurr;
    private JLabel lblstarratecurr;
    private JTable tblread;
    private JScrollPane tablepanel;
    int startlineNumber = 0;
    int endLineNumber = 0 ;
    public Finishedreadingform(){
        setContentPane(finished);
        setSize(1400,800);
        setTitle("Book Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
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
                    txtauthcurr.setText(finBook.getAuthorName());
                    txtstarcurr.setText(finBook.getStarRating());
                }
                startlineNumber++;
            }
        }
        catch (IOException h){
            System.out.println(h.getMessage());
        }

        btnalldetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("Booktracker.txt");
                try {
                    tblread.setRowHeight(0, 60);
                    tblread.setRowHeight(32);
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split("~");
                    DefaultTableModel model =(DefaultTableModel) tblread.getModel();
                    model.setColumnIdentifiers(columnsName);
                    Object[] tableLines = br.lines().toArray();
                    for(int i = 0; i < tableLines.length; i++)
                    {
                        String line = tableLines[i].toString().trim();
                        String[] dataRow = line.split("~");
                        model.addRow(dataRow);
                    }
                    packRows(tblread,50);
                    tablepanel.add(new JTable(model));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Addnewfinishedbookform newBook = new Addnewfinishedbookform();
                newBook.show();
            }
        });
        btnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mainform mF1 = new Mainform();
                mF1.show();
            }
        });

        btneditcurread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Addnewfinishedbookform newBook = new Addnewfinishedbookform();
                newBook.show();
            }
        });
    }
    public int getPreferredRowHeight(JTable table, int rowIndex, int margin) {
        int height = table.getRowHeight();
        for (int c = 0; c < table.getColumnCount(); c++) {
            TableCellRenderer renderer = table.getCellRenderer(rowIndex, c);
            Component comp = table.prepareRenderer(renderer, rowIndex, c);
            int h = comp.getPreferredSize().height + 2 * margin;
            height = Math.max(height, h);
        }
        return height;
    }
    public void packRows(JTable table, int margin) {
        packRows(table, 0, table.getRowCount(), margin);
    }
    public void packRows(JTable table, int start, int end, int margin) {
        for (int r = 0; r < table.getRowCount(); r++) {
            int h = getPreferredRowHeight(table, r, margin);
            if (table.getRowHeight(r) != h) {
                table.setRowHeight(r, h);
            }
        }
    }

}
