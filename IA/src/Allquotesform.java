import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Allquotesform extends JFrame {
    private JPanel allquote;
    private JButton btnMain;
    private JButton btnaddbook;
    private JButton btnserach;
    private JTable tblquotes;
    private JScrollPane tablepanel;
    private JTextField txtbooksearch;
    private JButton btnreset;

    public Allquotesform() {
        setContentPane(allquote);
        setTitle("Book Tracker");
        setSize(1400, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        File file = new File("Quotes.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split("~");
            DefaultTableModel model = (DefaultTableModel) tblquotes.getModel();
            model.setColumnIdentifiers(columnsName);
            Object[] tableLines = br.lines().toArray();
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("~");
                model.addRow(dataRow);
            }
            tblquotes.setRowHeight(0,30);
            packRows(tblquotes,50);
            tblquotes.setDefaultRenderer(String.class, new LineWrapCellRenderer());
            tablepanel.add(new JTable(model));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        btnMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mainform mF1 = new Mainform();
                mF1.show();
            }
        });
        btnaddbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Booksavequotes addBSQ = new Booksavequotes();
                addBSQ.show();
            }
        });
        btnserach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookSearched = txtbooksearch.getText();
            }
        });
        btnreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // reset the table back to alphbetic
                File file = new File("Quotes.txt");
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split("~");
                    DefaultTableModel model = (DefaultTableModel) tblquotes.getModel();
                    model.setColumnIdentifiers(columnsName);
                    Object[] tableLines = br.lines().toArray();
                    for (int i = 0; i < tableLines.length; i++) {
                        String line = tableLines[i].toString().trim();
                        String[] dataRow = line.split("~");
                        model.addRow(dataRow);
                    }
                    tblquotes.setRowHeight(0,30);
                    packRows(tblquotes,50);
                    tblquotes.setDefaultRenderer(String.class, new LineWrapCellRenderer());
                    tablepanel.add(new JTable(model));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
    public static class LineWrapCellRenderer extends JTextArea implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            this.setText((String) value);
            this.setWrapStyleWord(true);
            this.setLineWrap(true);
            int fontHeight = this.getFontMetrics(this.getFont()).getHeight();
            int textLength = this.getText().length();
            int lines = textLength / this.getColumnWidth();
            if (lines == 0) {
                lines = 1;
            }

            int height = fontHeight * lines;
            table.setRowHeight(row, height);

            return this;
        }
    }

    public int getPreferredRowHeight(JTable table, int rowIndex, int margin) {
        int height = table.getRowHeight();
        for (int c=0; c<table.getColumnCount(); c++) {
            TableCellRenderer renderer = table.getCellRenderer(rowIndex, c);
            Component comp = table.prepareRenderer(renderer, rowIndex, c);
            int h = comp.getPreferredSize().height + 2*margin;
            height = Math.max(height, h);
        }
        return height;
    }
    public void packRows(JTable table, int margin) {
        packRows(table, 0, table.getRowCount(), margin);
    }
    public void packRows(JTable table, int start, int end, int margin) {
        for (int r=0; r<table.getRowCount(); r++) {
            int h = getPreferredRowHeight(table, r, margin);
            if (table.getRowHeight(r) != h) {
                table.setRowHeight(r, h);
            }
        }
    }
}

