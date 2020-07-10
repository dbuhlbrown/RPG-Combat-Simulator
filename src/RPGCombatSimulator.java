import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.JavaBean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RPGCombatSimulator extends JFrame{
    private JPanel mainPanel;
    private JTextField player1AttackTextField;
    private JTextField player2AttackTextField;
    private JLabel player1AttackLabel;
    private JLabel player2AttackLabel;
    private JTextField player1DexTextField;
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

    private Character player1;
    private Character player2;

    private File directoryChosen;

    public RPGCombatSimulator( String appName) {

        super(appName);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack( );

        runSimulationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("inside runSimulation");
                runSimulation( );
            }
        });


        selectOutputFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("select folder");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.showOpenDialog(null);

                if( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ){
                    directoryChosen = chooser.getSelectedFile();
                    System.out.println(directoryChosen);
                }
            }
        });
    }


    public void runSimulation( ){

        //create characters here
        //int attack, int dex, int health, int defense, int magic
        player1 = new Character( Integer.valueOf(player1AttackTextField.getText()),  Integer.valueOf(player1DexTextField.getText()),
                Integer.valueOf(player1HealthTextField.getText()),  Integer.valueOf(player1DefenseTextField.getText()),
                Integer.valueOf(player1MagicTextField.getText()), 4
        );

        player2 = new Character( Integer.valueOf(player2AttackTextField.getText()),  Integer.valueOf(player2DexTextField.getText()),
                Integer.valueOf(player2HealthTextField.getText()),  Integer.valueOf(player2DefenseTextField.getText()),
                Integer.valueOf(player2MagicTextField.getText()), 4
        );

        Simulator currentSimulation = new Simulator(10000, player1, player2);
        currentSimulation.runSimulation();
        System.out.println(currentSimulation.averageDamageDealt);
        System.out.println(currentSimulation.averageNumberOfRounds);
        System.out.println(currentSimulation.player1wins);
        System.out.println(currentSimulation.player2wins);

        //try (PrintStream out = new PrintStream(new FileOutputStream(directoryChosen.getPath()+"\\filename.txt"))) {
        //    out.print(text);
       // }

        try {
            PrintStream output = new PrintStream(new FileOutputStream(directoryChosen.getPath() + "\\filename.txt", true));

            output.println(currentSimulation.averageDamageDealt + "," + currentSimulation.averageNumberOfRounds + "," +
                           currentSimulation.player1wins + "," + currentSimulation.player2wins);

            output.close();
        } catch(IOException e){

            System.out.println("File not found");
        }
    }

    public static void main(  String[] args){

        JFrame frame = new RPGCombatSimulator("RPG Combat Simulator");
        frame.setVisible(true);
    }




}
