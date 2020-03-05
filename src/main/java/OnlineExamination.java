import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class OnlineExamination extends JFrame implements ActionListener
{
    /**
     *
     */
    int MAX_NUMBER_OF_QUESTIONS = 10;
    int MAX_NUMBER_OF_OPTIONS = 4;
    private static final long serialVersionUID = 1L;
    JLabel jLabel;
    JRadioButton jRadioBut[]=new JRadioButton[5];
    String[] selectedValues = new String[MAX_NUMBER_OF_QUESTIONS];
    JButton previousButton, nextButton, bookmarkButton;
    ButtonGroup buttonGroup;
    int count=0,current=0,x=1,y=1,now=0;
    int bookmarked[]=new int[MAX_NUMBER_OF_QUESTIONS];
    List<QuestionDetail> questionDetails = new ArrayList<QuestionDetail>();

    OnlineExamination(String s)
    {
        super(s);
        jLabel=new JLabel();
        jLabel.setBounds(30,40,450,20);
        add(jLabel);

        populateQuestionDetails();

        initiateButtons();

        initiateRadioGroup();

        set();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(600,350);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void populateQuestionDetails()
    {
        String question = "What is the size of float variable";
        String answer = "32 bit";
        String[] answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "8 bit";
        answerOptions[1] = "16 bit";
        answerOptions[2] = "32 bit";
        answerOptions[3] = "64 bit";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "Which of these operators is used to allocate memory to array variable in Java?";
        answer = "new";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "malloc";
        answerOptions[1] = "alloc";
        answerOptions[2] = "new";
        answerOptions[3] = "new malloc";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "Which of these keywords is used to manually throw an exception";
        answer = "throw";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "try";
        answerOptions[1] = "throw";
        answerOptions[2] = "finally";
        answerOptions[3] = "catch4";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "Which one of these lists contains only Java programming language keywords";
        answer = "goto, instanceof, native, finally, default, throws";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "class, if, void, long, Int, continue";
        answerOptions[1] = "goto, instanceof, native, finally, default, throws";
        answerOptions[2] = "try, virtual, throw, final, volatile, transient";
        answerOptions[3] = "strictfp, constant, super, implements, do";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "Which is a valid keyword in java";
        answer = "interface";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "interface";
        answerOptions[1] = "string";
        answerOptions[2] = "unsigned";
        answerOptions[3] = "signature";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "What is the process of defining two or more methods within same class that have same name but different parameters declaration";
        answer = "method overloading";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "method overloading";
        answerOptions[1] = "method overriding";
        answerOptions[2] = "method hiding";
        answerOptions[3] = "none of the mentioned";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "Which of these classes is not part of Java’s collection framework?";
        answer = "Sorted List";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "Sorted List";
        answerOptions[1] = "Array";
        answerOptions[2] = "Stack";
        answerOptions[3] = "Math";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "Which of these exception is thrown by close() and read() methods?";
        answer = "IOException";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "FileException";
        answerOptions[1] = "FileNotFoundException";
        answerOptions[2] = "FileInputOutputException";
        answerOptions[3] = "IOException";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "Which of these class contains the methods used to write in a file?";
        answer = "FileInputStream";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "FileStream";
        answerOptions[1] = "FileInputStream";
        answerOptions[2] = "BufferedOutputStream";
        answerOptions[3] = "FileBufferStream";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "What is Truncation is Java?";
        answer = "Floating-point value assigned to an integer type";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "Floating-point value assigned to an integer type";
        answerOptions[1] = "Integer value assigned to floating type";
        answerOptions[2] = "Floating-point value assigned to an Floating type";
        answerOptions[3] = "Integer value assigned to floating type";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "Which of these will happen if recursive method does not have a base case?";
        answer = "An infinite loop occurs";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "System stops the program after some time";
        answerOptions[1] = "After 1000000 calls it will be automatically stopped";
        answerOptions[2] = "An infinite loop occurs";
        answerOptions[3] = "It results in application being stable";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "What is it called where child object gets killed if parent object is killed";
        answer = "Composition";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "Aggregation";
        answerOptions[1] = "Composition";
        answerOptions[2] = "Encapsulation";
        answerOptions[3] = "Association";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "Which of these access specifiers can be used for an interface";
        answer = "Public";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "Public";
        answerOptions[1] = "Protected";
        answerOptions[2] = "private";
        answerOptions[3] = "Transient";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

        question = "What will this code print? int arr[] = new int [5]; System.out.print(arr);";
        answer = "";
        answerOptions = new String[MAX_NUMBER_OF_OPTIONS];
        answerOptions[0] = "0";
        answerOptions[1] = "value stored in arr[0] .C. 00000";
        answerOptions[2] = "Class name";
        answerOptions[3] = "hashcode in hexadecimal form";
        questionDetails.add(new QuestionDetail(question, answerOptions, answer));

    }

    private void initiateRadioGroup()
    {
        buttonGroup=new ButtonGroup();
        int defaultPosition = 50;
        for(int i=0; i < MAX_NUMBER_OF_OPTIONS; i++)
        {
            jRadioBut[i]=new JRadioButton();
            jRadioBut[i].setBounds(50,defaultPosition+=30,100,20);
            add(jRadioBut[i]);
            buttonGroup.add(jRadioBut[i]);
        }
    }

    private void initiateButtons()
    {
        previousButton=new JButton("Previous");
        nextButton=new JButton("Next");
        bookmarkButton=new JButton("Bookmark");

        previousButton.addActionListener(this);
        nextButton.addActionListener(this);
        bookmarkButton.addActionListener(this);

        previousButton.setBounds(100,240,100,30);
        previousButton.setVisible(false);
        nextButton.setBounds(200,240,100,30);
        bookmarkButton.setBounds(300,240,100,30);

        add(previousButton);
        add(nextButton);
        add(bookmarkButton);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == nextButton)
        {
            if (check())
            {
                count = count + 1;
            }
            current++;
            if (current > 0)
            {
                previousButton.setVisible(true);
            }
            set();
            if (current == 9)
            {
                nextButton.setEnabled(false);
                bookmarkButton.setText("Result");
            }
        }

        if (e.getSource() == previousButton)
        {
            current --;
            set();
            if (current == 0)
            {
                previousButton.setVisible(false);
            }

            if (current < 9) {
                nextButton.setEnabled(true);
            }

        }

        if(e.getActionCommand().equals("Bookmark"))
        {
            JButton bk=new JButton("Bookmark"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            bookmarked[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                bookmarkButton.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if (e.getActionCommand().equals("Bookmark" + y))
            {
                if (check())
                    count = count + 1;
                now = current;
                current = bookmarked[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this,"correct ans="+count);
            System.exit(0);
        }
    }
    void set()
    {
        // jRadioBut[4].setSelected(true);
        QuestionDetail optionData = questionDetails.get(current);
        jLabel.setText(optionData.getQuestion());

        int count = 0;
        for (String option : optionData.getAnswerOptions())
        {
            jRadioBut[count].setText(option);
            count++;

        }

       /* if(current==0)
        {
            jLabel.setText("Que1: Which one among these is not a primitive datatype?");
            jRadioBut[0].setText("int");
            jRadioBut[1].setText("Float");
            jRadioBut[2].setText("boolean");
            jRadioBut[3].setText("char");

            //if ()

        }
        if(current==1)
        {
            jLabel.setText("Que2: Which class is available to all the class automatically?");
            jRadioBut[0].setText("Swing");
            jRadioBut[1].setText("Applet");
            jRadioBut[2].setText("Object");
            jRadioBut[3].setText("ActionEvent");
        }
        if(current==2)
        {
            jLabel.setText("Que3: Which package is directly available to our class without importing it?");
            jRadioBut[0].setText("swing");
            jRadioBut[1].setText("applet");
            jRadioBut[2].setText("net");
            jRadioBut[3].setText("lang");
        }
        if(current==3)
        {
            jLabel.setText("Que4: String class is defined in which package?");
            jRadioBut[0].setText("lang");
            jRadioBut[1].setText("Swing");
            jRadioBut[2].setText("Applet");
            jRadioBut[3].setText("awt");
        }
        if(current==4)
        {
            jLabel.setText("Que5: Which institute is best for java coaching?");
            jRadioBut[0].setText("Utek");
            jRadioBut[1].setText("Aptech");
            jRadioBut[2].setText("SSS IT");
            jRadioBut[3].setText("jtek");
        }
        if(current==5)
        {
            jLabel.setText("Que6: Which one among these is not a keyword?");
            jRadioBut[0].setText("class");
            jRadioBut[1].setText("int");
            jRadioBut[2].setText("get");
            jRadioBut[3].setText("if");
        }
        if(current==6)
        {
            jLabel.setText("Que7: Which one among these is not a class? ");
            jRadioBut[0].setText("Swing");
            jRadioBut[1].setText("Actionperformed");
            jRadioBut[2].setText("ActionEvent");
            jRadioBut[3].setText("Button");
        }
        if(current==7)
        {
            jLabel.setText("Que8: which one among these is not a function of Object class?");
            jRadioBut[0].setText("toString");
            jRadioBut[1].setText("finalize");
            jRadioBut[2].setText("equals");
            jRadioBut[3].setText("getDocumentBase");
        }
        if(current==8)
        {
            jLabel.setText("Que9: which function is not present in Applet class?");
            jRadioBut[0].setText("init");jRadioBut[1].setText("main");jRadioBut[2].setText("start");jRadioBut[3].setText("destroy");
        }
        if(current==9)
        {
            jLabel.setText("Que10: Which one among these is not a valid component?");
            jRadioBut[0].setText("JButton");
            jRadioBut[1].setText("JList");
            jRadioBut[2].setText("JButtonGroup");
            jRadioBut[3].setText("JTextArea");
        }  */
        jLabel.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
        {
            jRadioBut[j].setBounds(50,80+i,200,20);
        }
    }
    boolean check()
    {
        if(current==0)
            return(jRadioBut[1].isSelected());
        if(current==1)
            return(jRadioBut[2].isSelected());
        if(current==2)
            return(jRadioBut[3].isSelected());
        if(current==3)
            return(jRadioBut[0].isSelected());
        if(current==4)
            return(jRadioBut[2].isSelected());
        if(current==5)
            return(jRadioBut[2].isSelected());
        if(current==6)
            return(jRadioBut[1].isSelected());
        if(current==7)
            return(jRadioBut[3].isSelected());
        if(current==8)
            return(jRadioBut[1].isSelected());
        if(current==9)
            return(jRadioBut[2].isSelected());
        return false;
    }
    public static void main(String s[])
    {
        new OnlineExamination("Online Examination Of Java");
    }

}
