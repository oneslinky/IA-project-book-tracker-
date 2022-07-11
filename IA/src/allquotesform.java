import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class allquotesform extends JFrame{
    private JPanel allquote;
    private JButton btnMain;
    private JButton btnfin;
    private JButton btncur;
    private JButton btnrec;
    private JButton btnaddbook;
    private JButton btnview;

    public allquotesform(){
        setContentPane(allquote);
        setTitle("book tracker");
        setSize(815, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mainform city=new Mainform();
                city.show();
            }
        });
        btnfin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                finishedreadingform plastic=new finishedreadingform();
                plastic.show();
            }
        });
        btncur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                currentlyreadingform haze= new currentlyreadingform();
                haze.show();
            }
        });
        btnrec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                recommendationform recs=new recommendationform();
                recs.show();
            }
        });
        btnview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               booksavequotes real = new booksavequotes();
               real.show();
            }
        });
        btnaddbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                booksavequotes fake= new booksavequotes();
                fake.show();
            }
        });
    }

}
