import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finishedreadingform extends JFrame {
    private JButton btnmain;
    private JButton btnalldetails;
    private JPanel finished;
    private JLabel lbltitle;
    private JLabel lblauthor;
    private JLabel lblstarrat;
    private JLabel lblbooktitle;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton btnadd;

    public Finishedreadingform(){
        setContentPane(finished);
        setSize(815,600);
        setTitle("Book Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnalldetails.addActionListener(new ActionListener() {
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
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Addnewfinishedbookform newBook = new Addnewfinishedbookform();
                newBook.show();
            }
        });
    }
}
