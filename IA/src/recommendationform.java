import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class recommendationform extends JFrame {
    private JPanel reccomendations;
    private JLabel lblrecc;
    private JButton btnmain;
    private JButton btnfinread;
    private JButton btnquote;
    private JButton btncurr;
    private JLabel lblbook1;
    private JLabel lblbook1title;
    private JLabel lblbook1aname;
    private JLabel lblbook1genre;
    private JLabel lblbook2;
    private JLabel lblbook2title;
    private JLabel lblbook2aname;
    private JLabel lblbook2genre;
    private JLabel lblbook3;
    private JLabel lblbook3title;
    private JLabel lblbook3aname;
    private JLabel lblbook3genre;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;

    public recommendationform(){
        setContentPane(reccomendations);
        setTitle("book tracker");
        setSize(815,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mainform haze=new Mainform();
                haze.show();
            }
        });
        btnfinread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                finishedreadingform koko=new finishedreadingform();
                koko.show();
            }
        });
        btnquote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                allquotesform plastic=new allquotesform();
                //plastic.show();
            }
        });
        btncurr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                currentlyreadingform traffic=new currentlyreadingform();
                //traffic.show();
            }
        });
    }
}
