import javax.swing.*;

public class RPGCombatSimulator extends JFrame{
    private JPanel mainPanel;
    private JTextField player1AttackTextField;
    private JTextField player2AttackTextField;
    private JLabel player1AttackLabel;
    private JLabel player2AttackLabel;
    private JTextField player1DexAttackTextField;
    private JTextField player2DexTextField;
    private JTextField player1DefenseTextField;
    private JTextField player2DefenseTextField;
    private JTextField player1MagicTextField;
    private JTextField player2MagicTextField;
    private JTextField player1HealthTextField;
    private JTextField player2HealthTextField;
    private JTextField attackEqTextField;
    private JTextField hitEqTextField;
    private JTextField retaliationEqTextField;
    private JButton loadEquationsButton;
    private JButton selectOutputFileButton;
    private JButton saveSettingsButton;
    private JButton runSimulationButton;
    private JLabel player1DexLabel;
    private JLabel player1DefenseLabel;
    private JLabel player1MagicLabel;
    private JLabel player1HealthLabel;
    private JLabel attackEqLabel;
    private JLabel hitEqLabel;
    private JLabel retaliationEqLabel;
    private JLabel player2StatsLabel;
    private JLabel player2DexLabel;
    private JLabel player2DefenseLabel;
    private JLabel player2MagicLabel;
    private JLabel player2HealthLabel;

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
