import javax.swing.*;
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
    private JTable table1;

    public Finishedreadingform(){
        setContentPane(finished);
        setSize(2000,800);
        setTitle("Book Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnalldetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader fr = new FileReader("Booktracker.txt");
                }
                catch (IOException h){
                    System.out.println(h.getMessage());
                }
                dispose();
                Addnewfinishedbookform newBook = new Addnewfinishedbookform();
                newBook.show();
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
                try {
                    FileReader fr = new FileReader("Booktracker.txt");
                }
                catch (IOException h){
                    System.out.println(h.getMessage());
                }
                dispose();
                Addnewfinishedbookform newBook = new Addnewfinishedbookform();
                newBook.show();
            }
        });
    }
}
