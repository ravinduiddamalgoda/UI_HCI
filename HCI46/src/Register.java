import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Register extends JFrame{
    private JLabel topic;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton registerBtn;
    private JPanel mainPanel1;


    public Register(){

        super("Register");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel1);
        this.pack();

        registerBtn.addActionListener(e ->{
            String name  = textField1.getText();
            char[] pw = passwordField1.getPassword();
            String password = new String(pw);
            writeUserName(name , password);
//            try{
//                ui lgFrame = new ui(true);
//                lgFrame.setVisible(true);
////                this.setVisible(false);
//            } catch(Exception er) {
//                er.printStackTrace();
//            }
        });

    }

    public static void main(String [] args) {
        try{
            Register rg = new Register();
            rg.setVisible(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void writeUserName(String username , String password){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("userList.txt", true));
            String text = username+","+password;
            writer.write(text + "\n");
            writer.close();
        }catch(Exception e){
            System.err.println("An error occurred while appending to the file: " + e.getMessage());
        }


    }

}
