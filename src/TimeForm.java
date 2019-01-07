import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Iterator;

public class TimeForm {
    private JPanel Panel1;
    private JPanel Panel2;
    private JButton OutputButton;
    private JTextField NameText;
    private JLabel NameLabel;
    private JTextField BeginTimeText;
    private JLabel BeginTimeLabel;
    private JLabel OverTimeLabel;
    private JTextField OverTimeText;
    private JButton InitialInformationButton;
    private JLabel InitialInformationOutputLabel;
    private JLabel ItemNameLabel;
    private JTextField ItemNameText;
    private JLabel ItemCostLabel;
    private JTextField ItemCostText;
    private JLabel ItemCategoryLabel;
    private JRadioButton CategoryRadioButton1;
    private JRadioButton CategoryRadioButton2;
    private JRadioButton CategoryRadioButton3;
    private JLabel ItemPriorityLabel;
    private JRadioButton PriorityRadioButton1;
    private JRadioButton PriorityRadioButton2;
    private JRadioButton PriorityRadioButton3;
    private JButton ItemOutputButton;
    private JLabel ItemOutputLabel;
    private JButton ConfirmButton;
    private JButton FinishButton;
    private JLabel TimeExampleLabel;

    public TimeForm() {
        JFrame frame = new JFrame("TimeForm");
        frame.setContentPane(Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TimeForm timeForm = new TimeForm();
        ManageSystem timeMange = new TimeManage();

        //將時間format到小數點后兩位
        DecimalFormat df = new DecimalFormat("0.00");

        //實作計算時間按鈕
        timeForm.InitialInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeForm.NameText.getText().isEmpty()||timeForm.BeginTimeText.getText().isEmpty()||timeForm.OverTimeText.getText().isEmpty()){
                    timeForm.InitialInformationOutputLabel.setText("您还有信息未输入！请重新输入！");
                }else {
                    try {
                        ((TimeManage) timeMange).setBeginTime(((TimeManage) timeMange).StrToData(timeForm.BeginTimeText.getText()));
                        //System.out.println("開始時間為："+((TimeManage) timeMange).getBeginTime());
                        ((TimeManage) timeMange).setOverTime(((TimeManage) timeMange).StrToData(timeForm.OverTimeText.getText()));
                        //System.out.println("結束時間為"+((TimeManage) timeMange).getOverTime());
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    timeMange.inputInitialInfo(timeForm.NameText.getText(),((TimeManage) timeMange).calculateTotalTime(((TimeManage) timeMange).getOverTime(),((TimeManage) timeMange).getBeginTime()));
                    timeForm.InitialInformationOutputLabel.setText("您的姓名為："+((TimeManage) timeMange).getUserName()+"，您的規劃總時間為："+df.format(((TimeManage) timeMange).getTotalTime())+"小時");
                }
            }
        });

        //實作item按鈕
        timeForm.ItemOutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeForm.ItemNameText.getText().isEmpty()){
                    timeForm.ItemOutputLabel.setText("活動名稱未輸入！");
                }else if (timeForm.ItemCostText.getText().isEmpty()){
                    timeForm.ItemOutputLabel.setText("活動所需時間未輸入！");
                }else if (RationButton.checkRationButton(timeForm.CategoryRadioButton1,timeForm.CategoryRadioButton2,timeForm.CategoryRadioButton3)==false){
                    timeForm.ItemOutputLabel.setText("活動種類未選擇！");
                }else if (RationButton.checkRationButton(timeForm.PriorityRadioButton1,timeForm.PriorityRadioButton2,timeForm.PriorityRadioButton3)==false){
                    timeForm.ItemOutputLabel.setText("活動優先度未選擇！");
                }else {
                    timeForm.ItemOutputLabel.setText("您輸入的活動名稱為："+timeForm.ItemNameText.getText()+"，該活動所需時間為："+timeForm.ItemCostText.getText()
                    +"小時，該活動種類為："+RationButton.selectRadioButton(timeForm.CategoryRadioButton1,timeForm.CategoryRadioButton2,timeForm.CategoryRadioButton3).getText()
                    +"，該活動的優先度為："+RationButton.selectRadioButton(timeForm.PriorityRadioButton1,timeForm.PriorityRadioButton2,timeForm.PriorityRadioButton3).getText());
                }
            }
        });

        //加入item按鈕實作
        timeForm.ConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeForm.ItemNameText.getText().isEmpty()||timeForm.ItemCostText.getText().isEmpty()||
                        RationButton.checkRationButton(timeForm.CategoryRadioButton1,timeForm.CategoryRadioButton2,timeForm.CategoryRadioButton3)==false
                        ||RationButton.checkRationButton(timeForm.PriorityRadioButton1,timeForm.PriorityRadioButton2,timeForm.PriorityRadioButton3)==false){
                    timeForm.ItemOutputLabel.setText("您還有信息未輸入");
                }else {
                    timeMange.addItem(timeForm.ItemNameText.getText(),Double.parseDouble(timeForm.ItemCostText.getText()),
                            timeMange.chooseCategory(RationButton.selectRadioButton(timeForm.CategoryRadioButton1,timeForm.CategoryRadioButton2,timeForm.CategoryRadioButton3).getText()),
                            timeMange.choosePriority(RationButton.selectRadioButton(timeForm.PriorityRadioButton1,timeForm.PriorityRadioButton2,timeForm.PriorityRadioButton3).getText()));
                }
            }
        });

        //實作finish按鈕
        timeForm.FinishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("--------當前用戶信息----------");
                System.out.println("姓名:"+((TimeManage) timeMange).getUserName()+",計劃總時間:"+((TimeManage) timeMange).getTotalTime()+"小時");
                System.out.println("--------規劃活動列表---------");
                Iterator<Item> itemIterator = ((TimeManage) timeMange).timeItems.iterator();
                while (itemIterator.hasNext()){
                    Item timeItem = itemIterator.next();
                    System.out.println("活動名稱："+timeItem.getItemName()+",所需時間："+timeItem.getCost()+"小時，活動種類："+timeItem.backTimeCategory()+"，活動優先度："+
                    timeItem.backTimePriority());
                }
            }
        });
    }
}
