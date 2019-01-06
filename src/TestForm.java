import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
    private JButton ItemOutputButton;
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
    public JButton ConfirmButton;
    public JLabel ItemMoneyLabel;
    public JTextField ItemMoneyText;
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
    //選擇RadioButton
    public JRadioButton selectRadioButton(JRadioButton rb1,JRadioButton rb2,JRadioButton rb3){
        if (rb1.isSelected()){
            return rb1;
        }else if (rb2.isSelected()){
            return rb2;
        }else {
            return rb3;
        }
    }
    //判斷RadioButton是否被選中
    public boolean checkRationButton(JRadioButton rb1,JRadioButton rb2,JRadioButton rb3){
        if ((rb1.isSelected()||rb2.isSelected()||rb3.isSelected())==false){
            return false;
        }else {
            return true;
        }
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
                        //connection.close();
                    } catch (SQLException e1) {
                        System.out.println("只能輸入一次姓名和總金額！");
                        e1.printStackTrace();
                    }

                    //System.out.println("username:"+testForm.getUserName()+"，Money:"+testForm.getTotalMoney());
                }
            }
        });
        testForm.ItemOutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (testForm.ItemNameText.getText().isEmpty()){
                    testForm.ItemOutputLabel.setText("開銷名稱未輸入！");
                    System.out.println("開銷名稱未輸入！");
                }else if (testForm.ItemMoneyText.getText().isEmpty()){
                    testForm.ItemOutputLabel.setText("開銷金額未輸入！");
                    System.out.println("開銷金額未輸入！");
                }else if (testForm.checkRationButton(testForm.CategoryRadioButton1,testForm.CategoryRadioButton2,testForm.CategoryRadioButton3)==false){
                    testForm.ItemOutputLabel.setText("開銷種類未選擇！");
                    System.out.println("開銷種類未選擇！");
                }else if (testForm.checkRationButton(testForm.PriorityRadioButton1,testForm.PriorityRadioButton2,testForm.PriorityRadioButton3)==false){
                    testForm.ItemOutputLabel.setText("開銷優先度未選擇！");
                    System.out.println("開銷優先度未選擇！");
                }else {
                    testForm.ItemOutputLabel.setText("您輸入的開銷名稱為："+testForm.ItemNameText.getText()+"，該物品開銷為："+testForm.ItemMoneyText.getText()
                            +"元，該物品的種類為："+testForm.selectRadioButton(testForm.CategoryRadioButton1,testForm.CategoryRadioButton2,testForm.CategoryRadioButton3).getText()
                            +", 該物品的優先度為："+testForm.selectRadioButton(testForm.PriorityRadioButton1,testForm.PriorityRadioButton2,testForm.PriorityRadioButton3).getText());
                }
            }
        });
        /*String sql = "SELECT userName,userMoney FROM userinitialinformation";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            String name = rs.getString("userName");
            double money = rs.getDouble("userMoney");
            System.out.println("name:"+name+" money:"+money);
        }*///读取数据模板

    }


}
