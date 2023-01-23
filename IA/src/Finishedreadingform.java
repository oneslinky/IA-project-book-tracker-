import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class Finishedreadingform extends JFrame {
    private JButton btnmain;
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
    private JButton btnfilter;
    private JTextField txtfilter;
    private JButton btnreset;
    private JComboBox cmbfilter;
    int startlineNumber = 0;
    int endLineNumber = 0 ;
    ArrayList <String> finishedbooksunsort = new ArrayList<String>();
    static Stack<String> sStack = new Stack<String>();
    ArrayList <String> bookforfilter = new ArrayList<String>();
    static Queue <String> fQueue = new PriorityQueue<String>();
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
        //Stack
       try{
            FileReader fr = new FileReader("Booktracker.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine())!=null){
                sStack.push(s);//add all lines of the text file to the stack
            }
            String currLine = sStack.pop();//pop out the last line of string in the stack
            String [] bookDetail = currLine.split("~");
            Finishedbook finBook = new Finishedbook(bookDetail[0],bookDetail[1],bookDetail[2],bookDetail[3],
                    bookDetail[4],bookDetail[5],bookDetail[6]);
            txtbtitlecurr.setText(finBook.getBookTitle());
            txtauthcurr.setText(finBook.getAuthorName());
            txtstarcurr.setText(finBook.getStarRating());
        }
        catch (IOException h){
            System.out.println(h.getMessage());
        }
        try{
        tblread.setRowHeight(0, 60);
        tblread.setRowHeight(100);
        BufferedReader br = new BufferedReader(new FileReader("Booktracker.txt"));
        String firstLine = br.readLine().trim();
        //have the first line in the book tracker file used as column titles
        String[] columnsName = firstLine.split("~");
        //create table model
        DefaultTableModel model =(DefaultTableModel) tblread.getModel();
        //set the table columns using the array from before
        model.setColumnIdentifiers(columnsName);
        //put all the text file lines into an array
        Object[] tableLines = br.lines().toArray();
        //using size of array parse through the array
        for(int i = 0; i < tableLines.length; i++)
        {
            String line = tableLines[i].toString().trim();
            //add the line of text containing each book to an arrayList
            finishedbooksunsort.add(line);
        }
        //using collections sort the arrayList alphabetically
        Collections.sort(finishedbooksunsort);
        for(int i = 0; i<tableLines.length; i++){
            String line = finishedbooksunsort.get(i);
            //split each line(book detail) into an array
            String [] sortedbook = line.split("~");
            //place the array into the table as a row
            model.addRow(sortedbook);
        }
        packRows(tblread,50);
        tablepanel.add(new JTable(model));
        }
        catch (Exception ex) {
        System.out.println(ex.getMessage());
        }

        btnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mainform mF1 = new Mainform();
                mF1.show();
            }//returns back to the main form but this page cannont acces any other form except the add book
            //only from the main form can you access all the other forms
        });

        btneditcurread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Addnewfinishedbookform newBook = new Addnewfinishedbookform();
                newBook.show();
            }//goes to the add book form
            //only able to access this form from the add form hiding the rest of the info
        });
        btnfilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filter = txtfilter.getText();
                String filterLow = filter.toLowerCase(Locale.ROOT);
                try{
                    ((DefaultTableModel)tblread.getModel()).setNumRows(0);
                    if(cmbfilter.getSelectedIndex() == 2){
                        tblread.setRowHeight(0, 60);
                        tblread.setRowHeight(100);
                        BufferedReader br = new BufferedReader(new FileReader("Booktracker.txt"));
                        String firstLine = br.readLine().trim();
                        String[] columnsName = firstLine.split("~");
                        DefaultTableModel model =(DefaultTableModel) tblread.getModel();
                        model.setColumnIdentifiers(columnsName);
                        Object[] tableLines = br.lines().toArray();
                        for(int i = 0; i < tableLines.length; i++)
                        {
                            String line = tableLines[i].toString().trim();
                            //put text file into an arraylist
                            bookforfilter.add(line);
                        }
                        //recursion search
                        recSearch(bookforfilter, bookforfilter.size()-1, 3,filterLow);
                        while(!fQueue.isEmpty()){
                            //place the items in the queue into the table
                            String temp = fQueue.remove();
                            String [] tempRow = temp.split("~");
                            model.addRow(tempRow);
                        }
                        packRows(tblread,50);
                        tablepanel.add(new JTable(model));
                        if(model.getRowCount()==0){
                            txtfilter.setText("If table is blank reset and try inputting again");
                        }
                    }
                    else if (cmbfilter.getSelectedIndex()==1){
                        tblread.setRowHeight(0, 60);
                        tblread.setRowHeight(100);
                        BufferedReader br = new BufferedReader(new FileReader("Booktracker.txt"));
                        String firstLine = br.readLine().trim();
                        String[] columnsName = firstLine.split("~");
                        DefaultTableModel model =(DefaultTableModel) tblread.getModel();
                        model.setColumnIdentifiers(columnsName);
                        Object[] tableLines = br.lines().toArray();
                        for(int i = 0; i < tableLines.length; i++)
                        {
                            String line = tableLines[i].toString().trim();
                            //put text file into an arraylist
                            bookforfilter.add(line);
                        }
                        //recursion search
                        recSearch(bookforfilter, bookforfilter.size()-1, 1,filterLow);
                        while(!fQueue.isEmpty()){
                            //place the items in the queue into the table
                            String temp = fQueue.remove();
                            String [] tempRow = temp.split("~");
                            model.addRow(tempRow);
                        }
                        packRows(tblread,50);
                        tablepanel.add(new JTable(model));
                        if(model.getRowCount()==0){
                            txtfilter.setText("If table is blank reset and try inputting again");
                        }
                    }
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        btnreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ((DefaultTableModel)tblread.getModel()).setNumRows(0);
                    tblread.setRowHeight(0, 60);
                    tblread.setRowHeight(100);
                    BufferedReader br = new BufferedReader(new FileReader("Booktracker.txt"));
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split("~");
                    DefaultTableModel model =(DefaultTableModel) tblread.getModel();
                    model.setColumnIdentifiers(columnsName);
                    Object[] tableLines = br.lines().toArray();
                    Collections.sort(finishedbooksunsort);
                    for(int i = 0; i<tableLines.length; i++){
                        String line = finishedbooksunsort.get(i);
                        String [] sortedbook = line.split("~");
                        model.addRow(sortedbook);
                    }
                    packRows(tblread,50);
                    tablepanel.add(new JTable(model));
                }
                catch (Exception ex) {
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
    }
    static void recSearch(ArrayList<String> arrayList, int l, int selectIndex, String filter) {
        //get line at the index of the arraylist
        String lineDetail = arrayList.get(l);
        //split line using regex
        String [] detail = lineDetail.split("~");
        //compare the book with the filter
        String detailLow = detail[selectIndex].toLowerCase(Locale.ROOT);
        if (detailLow.equals(filter)) {
            //add book to queue
            fQueue.add(arrayList.get(l));
        }
        if(!(l == 0)) {
            //recurse
            recSearch(arrayList, l-1, selectIndex, filter);
        }
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
