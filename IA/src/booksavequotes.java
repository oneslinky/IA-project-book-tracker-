import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class booksavequotes extends JFrame {
    private JPanel onebookquotes;
    private JButton btnaddnewquote;
    private JButton btnsave;

    public booksavequotes(){
        setContentPane(onebookquotes);
        setTitle("book tracker");
        setSize(815, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        btnaddnewquote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                allquotesform yes=new allquotesform();
                yes.show();
            }
        });
    }
}
