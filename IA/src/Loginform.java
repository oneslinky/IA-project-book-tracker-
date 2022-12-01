import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Loginform extends JFrame {
    private JButton btnlogin;
    private JPasswordField txtpass;
    private JTextField txtuser;
    private JLabel lblpass;
    private JLabel lbluser;
    private JLabel lbltitle;
    private JPanel lpage;
    private JButton btncancel;
    private JCheckBox firstTImeCheckBox;

    public Loginform(){
        setContentPane(lpage);
        setSize(800,400);
        setTitle("Book Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        File bFile = new File("Booktracker.txt");
        File qFile = new File("Quotes.txt");
        File pfile = new File("Password.txt");//file to store login is created
        try {
            FileWriter psfw = new FileWriter(pfile);
            String password = "Lara Paulina Tsai~122021";
            psfw.write(password);//login information is put on the file
            psfw.close();
        }
        catch (IOException i){
            dispose();
            System.out.println(i.getMessage());
        }
        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String line = (new String(readFromFile("Password.txt",
                            0, 24)));
                    String [] l1 = line.split("~");
                    if (txtuser.getText().equals(l1[0])&& txtpass.getText().equals(l1[1])){
                        //if password is put correctly then
                        writeToFile(pfile.getPath(), "13h4j1oi4n5k2i34", 3);
                        //use of random acces code to scramble the files contents
                        dispose();
                        Mainform mF1 = new Mainform();
                        mF1.show();
                    }
                    else{
                        txtuser.setText("incorrect username or password. retry");
                        txtpass.setText("");//validation check if the user inputs the right password
                    }
                }
                catch (IOException i){
                    dispose();
                    System.out.println(i.getMessage());
                }

            }
        });

        btncancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtuser.setText("");
                txtpass.setText("");
            }
        });
        firstTImeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    FileWriter fr = new FileWriter(qFile);
                    FileWriter br = new FileWriter(bFile);
                    String textQ = "Book Title~Quote 1~Quote 2~Quote 3~Quote 4~Quote 5~Quote 6~Quote 7~Quote 8~Quote 9~Quote 10";
                    String textB = "Book Title~Author Name~Star Rating~Genre~Character~Review~Emotional Scale";
                    fr.write(textQ);
                    br.write(textB);
                    fr.close();
                    br.close();
                }
                catch(IOException h){
                    System.out.println(h.getMessage());
                }

            }
        });
    }
    public static void main(String[] args){
        Loginform LF = new Loginform();
    }
    private static byte[] readFromFile(String filePath, int position, int size)
            throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        file.seek(position);
        byte[] bytes = new byte[size];
        file.read(bytes);
        file.close();
        return bytes;
    }
    private static void writeToFile(String filePath, String data, int position)
            throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        file.seek(position);
        file.write(data.getBytes());
        file.close();
    }
}
