import javax.swing.*;

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

    public TimeForm() {
        JFrame frame = new JFrame("TimeForm");
        frame.setContentPane(Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TimeForm timeForm = new TimeForm();
    }
}
