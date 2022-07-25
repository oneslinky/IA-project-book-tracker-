import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Recommendationform extends JFrame {
    private JPanel reccomendations;
    private JLabel lblrecc;
    private JButton btnmain;
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

    public Recommendationform(){
        setContentPane(reccomendations);
        setTitle("Book Tracker");
        setSize(2000,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mainform mF1 = new Mainform();
                mF1.show();
            }
        });
    }
}
