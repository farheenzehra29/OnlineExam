import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class Login extends JFrame {

    JButton submit;
    JFrame jFrame;
    JLabel jLabel1, jLabel2, head;
    final JTextField text1;
    final JPasswordField text2;

    Login() {
        jFrame = new JFrame();
        jLabel1 = new JLabel();
        jLabel1.setText("Username: ");
        text1 = new JTextField();

        jLabel2 = new JLabel();
        jLabel2.setText("Password:");
        text2 = new JPasswordField();
        submit = new JButton("SUBMIT");

        jLabel1.setBounds(80, 70, 200, 30);
        jLabel2.setBounds(80, 110, 200, 30);
        text1.setBounds(300, 70, 200, 30);
        text2.setBounds(300, 110, 200, 30);
        submit.setBounds(150, 160, 100, 30);
        jFrame.setSize(600, 600);
        jFrame.setLayout(null);

        jFrame.add(jLabel1);
        jFrame.add(text1);
        jFrame.add(jLabel2);
        jFrame.add(text2);
        jFrame.add(submit);
        jFrame.setTitle("Login Form");
        jFrame.setVisible(true);

        String val1 = text1.getText();


        ActionListener a1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String value2 = String.valueOf(text2.getPassword());
                String value1 = text1.getText();

                if (value1.equals("") || value2.equals("")) {
                    JOptionPane.showMessageDialog(jFrame, "Please enter the username/password");
                } else {
                    if (Pattern.matches("^[a-zA-Z0-9]+$", value1)) {


                        if((value2.length() > 8) && Pattern.matches("^[a-zA-Z0-9]+$", value2)) {
                            writeIntoFile(value1, value2);
                            jFrame.dispose();
                            QuestionLayout questionLayout = new QuestionLayout(value1);
                        }
                        else
                            JOptionPane.showMessageDialog(jFrame, "Enter valid password(atleast 8 characters)");

                    } else {
                        try {

                            throw new InvalidNameException();
                        } catch (InvalidNameException e1) {
                            JOptionPane.showMessageDialog(jFrame, "No special characters are allowed");
                            e1.printStackTrace();
                        }

                    }

                }
            }
        };

        submit.addActionListener(a1);


    }

    public void writeIntoFile(String value1, String value2) {
        try {
            File f = new File("C:\\Users\\farhe\\pes-sem3\\Java-sem3\\UserData.txt");
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println(bw);
            bw.newLine();
            bw.write("Username : " + value1 + " ");
            bw.write("Password: " + value2);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class LoginDemo {
    public static void main(String[] args) {
        try {
            Login login = new Login();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}