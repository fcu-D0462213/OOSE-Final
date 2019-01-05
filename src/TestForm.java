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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observer;

public class TestForm extends JFrame {
    private JPanel Panel1;
    private JButton OutputButton;
    private JPanel Panel2;
    private JTextField NameText;
    private JLabel NameLabel;
    private JLabel TotalMoneyLabel;
    private JButton InitialInformationButton;
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
    private JLabel InitialInformantionOutputLabel;
    private JLabel ItemOutputLabel;
    private String userName;
    private double TotalMoney;

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        TotalMoney = totalMoney;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TestForm() {
        super("Test");
        setContentPane(Panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TestForm testForm = new TestForm();
        //sql連接
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        //配置mySql url
        String url = "jdbc:mysql://localhost:3306/oose_final";
        String user = "root";
        String password = "123456";
        //加載驅動程序
        Class.forName(JDBC_DRIVER);
        //創建連接
        Connection connection = DriverManager.getConnection(url,user,password);
        //創建statement對象來執行sql語句
        Statement statement =connection.createStatement();

        testForm.InitialInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (testForm.NameText.getText().isEmpty()||testForm.TotalMoneyText.getText().isEmpty()){
                    testForm.InitialInformantionOutputLabel.setText("您有信息還未輸入！請重新輸入！");
                    //System.out.println("您有信息還未輸入！請重新輸入！");
                }else {
                    testForm.setUserName(testForm.NameText.getText());
                    testForm.setTotalMoney(Double.parseDouble(testForm.TotalMoneyText.getText()));
                    testForm.InitialInformantionOutputLabel.setText("您的姓名為："+testForm.NameText.getText()+"，您的輸入的總金額為："
                    +testForm.TotalMoneyText.getText());
                    String sql ="INSERT INTO userinitialinformation VALUES ("+"\'"+testForm.getUserName()+"\',"+testForm.getTotalMoney()+")";
                    try {
                        //將姓名和總金額存入資料庫
                        statement.executeUpdate(sql);
                        //關閉資料庫，保證只能存入一次
                        statement.close();
                        connection.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    //System.out.println("username:"+testForm.getUserName()+"，Money:"+testForm.getTotalMoney());
                }
            }
        });


    }


}
