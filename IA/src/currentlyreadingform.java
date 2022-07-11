import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class currentlyreadingform extends JFrame {
    private JPanel currreading;
    private JButton btnmain;
    private JButton btnfinread;
    private JButton btncurrread;
    private JButton btnrec;
    private JButton btnedit;

    public currentlyreadingform() {
    setContentPane(currreading);
    setTitle("book tracker");
    setSize(815,600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
        btnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mainform honest=new Mainform();
                honest.show();
            }
        });
        btnfinread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                finishedreadingform haze=new finishedreadingform();
                haze.show();
            }
        });
        btncurrread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                currentlyreadingform koko=new currentlyreadingform();
                koko.show();
            }
        });
        btnrec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                recommendationform reccs= new recommendationform();
                reccs.show();
            }
        });
        btnedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                currentlyreadingeditform blue =new currentlyreadingeditform();
                blue.show();
            }
        });
    }
}
