import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;


public class Login extends JFrame {
    private JPanel panel1;
    private JTextField usernameText;
    private JButton loginBtn;
    private JLabel userName;
    private JLabel password;
    private JPanel panelMain;
    private JPasswordField passwordtext;
    private JButton newUserBtn;


    public Login() {

        super("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);
        this.pack();

        loginBtn.addActionListener(e ->{
            String userName = usernameText.getText();
            char[] passwordChars = passwordtext.getPassword();
            String password = new String(passwordChars);

            boolean valid = getUserData(userName , password);
            if(valid){
                JOptionPane.showMessageDialog(this , "Welcome " + userName);
//                try{
//                    ui frame = new ui(false);
////                    this.setVisible(false);
//                    frame.setVisible(true);
//                }catch (Exception er){
//                    er.printStackTrace();
//                }
            }else{
                JOptionPane.showMessageDialog(this , "User Data Wrong please check the details");
            }

        });


        newUserBtn.addActionListener(e -> {
            try {
                Register RegisterFrame = new Register();
                RegisterFrame.setVisible(true);
//                this.setVisible(false);
            } catch (Exception er) {
                er.printStackTrace();
            }
        });

    }

    public static void main(String[] args) {
        try {
            Login loginFrame = new Login();
            loginFrame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean getUserData(String username, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("userList.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                System.out.println(username + password);
                if (userData[0].equals(username) && userData[1].equals(password)) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.err.println("An error occurred : " + e.getMessage());
        }
        return false;
    }



}
