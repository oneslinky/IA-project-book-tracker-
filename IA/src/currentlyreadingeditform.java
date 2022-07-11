import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class currentlyreadingeditform extends JFrame {
    private JPanel currreadedit;
    private JButton btnSave;

    public currentlyreadingeditform(){
        setContentPane(currreadedit);
        setTitle("book tracker");
        setSize(815, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                currentlyreadingform love=new currentlyreadingform();
                love.show();
            }
        });
    }
}
