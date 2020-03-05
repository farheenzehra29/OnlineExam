import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionLayout extends JFrame implements ActionListener {

    JFrame jFrame;
    JButton jButton;
    JLabel jlabel;
    ButtonGroup buttonGroup;

    QuestionLayout(String value1) {

        jFrame = new JFrame();
        setLayout(new BorderLayout());
        jlabel = new JLabel("Welcome "+value1);
        jButton = new JButton("Click here to start");


        jFrame.add(jlabel, BorderLayout.NORTH);
        jFrame.add(jButton, BorderLayout.CENTER);

        jlabel.setHorizontalAlignment(SwingConstants.CENTER);
        jlabel.setVerticalAlignment(SwingConstants.CENTER);
        jlabel.setFont(new Font("Courier New", Font.BOLD, 25));
        jlabel.setForeground(Color.RED);
        jButton.setFont(new Font("Dialog", Font.HANGING_BASELINE, 20));


        jFrame.setVisible(true);
        jFrame.setSize(600, 600);


        jButton.addActionListener(this);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void actionPerformed(ActionEvent e) {
            jFrame.dispose();
            OnlineExamination onlineExamination=new OnlineExamination("Welcome");

    }
}

class QuestionsMain {
    public static void main(String[] args) {
        QuestionLayout questionLayout = new QuestionLayout("User");

    }
}
