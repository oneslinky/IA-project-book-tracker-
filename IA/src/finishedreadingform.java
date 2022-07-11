import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class finishedreadingform extends JFrame {
    private JButton btnmain;
    private JButton btnquote;
    private JButton btncurr;
    private JButton btnrecc;
    private JButton btnalldetails;
    private JPanel finished;
    private JLabel lbltitle;
    private JLabel lblauthor;
    private JLabel lblstarrat;
    private JLabel lblbooktitle;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public finishedreadingform(){
        setContentPane(finished);
        setSize(815,600);
        setTitle("book tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnalldetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                addnewfinishedbookform plastic=new addnewfinishedbookform();
                plastic.show();
            }
        });
        btnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mainform love=new Mainform();
                love.show();
            }
        });
        btnquote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                allquotesform quote=new allquotesform();
                //quote.show();
            }
        });
        btncurr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                currentlyreadingform curry=new currentlyreadingform();
                //curry.show();
            }
        });
        btnrecc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                recommendationform haze=new recommendationform();
                haze.show();
            }
        });
    }
}
