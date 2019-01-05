import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

public class TestForm extends JFrame {
    public JPanel Panel1;
    private JButton OutputButton;
    private JPanel Panel2;
    private JTextField NameText;
    public JButton NameButton;
    private JLabel NameLabel;
    private JLabel TotalMoneyLabel;
    private JButton TotalMoneyButton;
    private JTextField TotalMoneyText;
    private JLabel ItemNameLabel;
    private JTextField ItemNameText;
    private JButton ItemNameButton;
    private JRadioButton CategoryRadioButton1;
    private JRadioButton CategoryRadioButton2;
    private JRadioButton CategoryRadioButton3;
    private JRadioButton PriorityRadioButton1;
    private JRadioButton PriorityRadioButton2;
    private JRadioButton PriorityRadioButton3;
    private JButton ContinueButton;
    private JButton FinishButton;
    private JLabel CategoryLabel;
    private JLabel PriorityLabel;
    private JPanel Panel3;
    private JLabel NameOutputLabel;
    private JLabel TotalMoneyOutputLabel;
    private JLabel ItemOutputLabel;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TestForm() {
        super("Test");
        NameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //userName = NameText.getText();
                setUserName(NameText.getText());
                System.out.println("内部里的username："+getUserName());
                NameOutputLabel.setText("        您的姓名為：" + NameText.getText());

                //System.out.println(userName);
            }
        });
        setContentPane(Panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        //String username;
        TestForm testForm = new TestForm();
        //username=testForm.NameText.getText();
        testForm.NameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("main里的username："+testForm.getUserName());
            }
        });
    }

}
