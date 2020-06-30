import javax.swing.*;

public class RPGCombatSimulator extends JFrame{
    private JPanel mainPanel;
    private JTextField player1AttackTextField;
    private JTextField player2AttackTextField;
    private JLabel player1AttackLabel;
    private JLabel player2AttackLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JButton loadEquationsButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public RPGCombatSimulator( String appName){

        super(appName);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack( );
    }

    public static void main(  String[] args){

        JFrame frame = new RPGCombatSimulator("RPG Combat Simulator");
        frame.setVisible(true);
    }




}
