import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
    private JTextField ItemNameOutputText;
    private JLabel ItemCostLabel;
    private JTextField ItemCostOutputText;
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

        timeForm.InitialInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeForm.NameText.getText().isEmpty()||timeForm.BeginTimeText.getText().isEmpty()||timeForm.OverTimeText.getText().isEmpty()){
                    timeForm.InitialInformationOutputLabel.setText("您还有信息未输入！请重新输入！");
                }else {
                    try {
                        ((TimeManage) timeMange).setBeginTime(((TimeManage) timeMange).StrToData(timeForm.BeginTimeText.getText()));
                        System.out.println("開始時間為："+((TimeManage) timeMange).getBeginTime());
                        ((TimeManage) timeMange).setOverTime(((TimeManage) timeMange).StrToData(timeForm.OverTimeText.getText()));
                        System.out.println("結束時間為"+((TimeManage) timeMange).getOverTime());
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    timeMange.inputInitialInfo(timeForm.NameText.getText(),((TimeManage) timeMange).calculateTotalTime(((TimeManage) timeMange).getOverTime(),((TimeManage) timeMange).getBeginTime()));
                    timeForm.InitialInformationOutputLabel.setText("您的姓名為："+((TimeManage) timeMange).getUserName()+"，您的規劃總時間為："+((TimeManage) timeMange).getTotalTime()+"小時");
                }
            }
        });
    }
}
