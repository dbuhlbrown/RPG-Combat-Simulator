import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionAdapter;import java.beans.JavaBean;
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
    private JButton selectOutputFileButton;
    private JButton runSimulationButton;
    private JLabel player1DexLabel;
    private JLabel player1DefenseLabel;
    private JLabel player1MagicLabel;
    private JLabel player1HealthLabel;
    private JLabel player2StatsLabel;
    private JLabel player2DexLabel;
    private JLabel player2DefenseLabel;
    private JLabel player2MagicLabel;
    private JLabel player2HealthLabel;
    private JTextField player1DamageTextField;
    private JTextField player2DamageTextField;
    private JLabel player2DamageLabel;
    private JTextField player1StartingDistance;
    private JComboBox player1Class;
    private JComboBox player2Class;
    private JButton player1Level2Button;
    private JButton player1Level3Button;
    private JButton player1Level1Button;
    private JButton player2Level1;
    private JButton player2Level2;
    private JButton player2Level3;
    private JComboBox player1Race;
    private JComboBox player2Race;

    private Character player1;
    private Character player2;

    private File directoryChosen;

    public RPGCombatSimulator( String appName) {

        super(appName);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack( );

        player1Class.addItem("Warrior");
        player1Class.addItem("Ranger");
        player1Class.addItem("Rogue");
        player1Class.addItem("Mage");
        player1Class.addItem("Priest");

        player2Class.addItem("Warrior");
        player2Class.addItem("Ranger");
        player2Class.addItem("Rogue");
        player2Class.addItem("Mage");
        player2Class.addItem("Priest");

        player1Race.addItem("Human");
        player1Race.addItem("Undead");

        player2Race.addItem("Human");
        player2Race.addItem("Undead");

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
        player1Level1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if( player1Class.getSelectedItem().toString().equals("Warrior")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("5");
                        player1DamageTextField.setText("7");
                        player1DexTextField.setText("4");
                        player1DefenseTextField.setText("6");
                        player1MagicTextField.setText("3");
                        player1HealthTextField.setText("13");

                    } else {

                        player1AttackTextField.setText("5");
                        player1DamageTextField.setText("7");
                        player1DexTextField.setText("5");
                        player1DefenseTextField.setText("5");
                        player1MagicTextField.setText("3");
                        player1HealthTextField.setText("13");


                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Ranger")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("5");
                        player1DamageTextField.setText("3");
                        player1DexTextField.setText("6");
                        player1DefenseTextField.setText("4");
                        player1MagicTextField.setText("3");
                        player1HealthTextField.setText("11");

                    } else {

                        player1AttackTextField.setText("5");
                        player1DamageTextField.setText("3");
                        player1DexTextField.setText("7");
                        player1DefenseTextField.setText("3");
                        player1MagicTextField.setText("3");
                        player1HealthTextField.setText("11");
                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Rogue")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("4");
                        player1DamageTextField.setText("4");
                        player1DexTextField.setText("7");
                        player1DefenseTextField.setText("5");
                        player1MagicTextField.setText("3");
                        player1HealthTextField.setText("11");

                    } else {

                        player1AttackTextField.setText("4");
                        player1DamageTextField.setText("5");
                        player1DexTextField.setText("7");
                        player1DefenseTextField.setText("4");
                        player1MagicTextField.setText("3");
                        player1HealthTextField.setText("11");
                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Mage")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("3");
                        player1DamageTextField.setText("6");
                        player1DexTextField.setText("3");
                        player1DefenseTextField.setText("4");
                        player1MagicTextField.setText("6");
                        player1HealthTextField.setText("9");

                    } else {

                        player1AttackTextField.setText("3");
                        player1DamageTextField.setText("6");
                        player1DexTextField.setText("4");
                        player1DefenseTextField.setText("3");
                        player1MagicTextField.setText("6");
                        player1HealthTextField.setText("9");
                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Priest")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("3");
                        player1DamageTextField.setText("3");
                        player1DexTextField.setText("4");
                        player1DefenseTextField.setText("4");
                        player1MagicTextField.setText("6");
                        player1HealthTextField.setText("9");

                    } else {

                        player1AttackTextField.setText("3");
                        player1DamageTextField.setText("3");
                        player1DexTextField.setText("5");
                        player1DefenseTextField.setText("3");
                        player1MagicTextField.setText("6");
                        player1HealthTextField.setText("9");

                    }
                }

            }
        });
        player1Level2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if( player1Class.getSelectedItem().toString().equals("Warrior")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("7");
                        player1DamageTextField.setText("9");
                        player1DexTextField.setText("6");
                        player1DefenseTextField.setText("8");
                        player1MagicTextField.setText("5");
                        player1HealthTextField.setText("15");

                    } else {

                        player1AttackTextField.setText("7");
                        player1DamageTextField.setText("9");
                        player1DexTextField.setText("7");
                        player1DefenseTextField.setText("7");
                        player1MagicTextField.setText("5");
                        player1HealthTextField.setText("15");


                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Ranger")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("7");
                        player1DamageTextField.setText("5");
                        player1DexTextField.setText("8");
                        player1DefenseTextField.setText("6");
                        player1MagicTextField.setText("5");
                        player1HealthTextField.setText("13");

                    } else {

                        player1AttackTextField.setText("7");
                        player1DamageTextField.setText("5");
                        player1DexTextField.setText("9");
                        player1DefenseTextField.setText("5");
                        player1MagicTextField.setText("5");
                        player1HealthTextField.setText("13");
                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Rogue")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("6");
                        player1DamageTextField.setText("6");
                        player1DexTextField.setText("9");
                        player1DefenseTextField.setText("7");
                        player1MagicTextField.setText("5");
                        player1HealthTextField.setText("13");

                    } else {

                        player1AttackTextField.setText("6");
                        player1DamageTextField.setText("7");
                        player1DexTextField.setText("9");
                        player1DefenseTextField.setText("6");
                        player1MagicTextField.setText("5");
                        player1HealthTextField.setText("13");
                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Mage")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("5");
                        player1DamageTextField.setText("8");
                        player1DexTextField.setText("5");
                        player1DefenseTextField.setText("6");
                        player1MagicTextField.setText("8");
                        player1HealthTextField.setText("11");

                    } else {

                        player1AttackTextField.setText("5");
                        player1DamageTextField.setText("8");
                        player1DexTextField.setText("6");
                        player1DefenseTextField.setText("5");
                        player1MagicTextField.setText("8");
                        player1HealthTextField.setText("11");
                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Priest")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("5");
                        player1DamageTextField.setText("5");
                        player1DexTextField.setText("6");
                        player1DefenseTextField.setText("6");
                        player1MagicTextField.setText("8");
                        player1HealthTextField.setText("11");

                    } else {

                        player1AttackTextField.setText("5");
                        player1DamageTextField.setText("5");
                        player1DexTextField.setText("7");
                        player1DefenseTextField.setText("5");
                        player1MagicTextField.setText("8");
                        player1HealthTextField.setText("11");

                    }
                }

            }
        });
        player1Level3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if( player1Class.getSelectedItem().toString().equals("Warrior")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("9");
                        player1DamageTextField.setText("11");
                        player1DexTextField.setText("8");
                        player1DefenseTextField.setText("10");
                        player1MagicTextField.setText("7");
                        player1HealthTextField.setText("17");

                    } else {

                        player1AttackTextField.setText("9");
                        player1DamageTextField.setText("11");
                        player1DexTextField.setText("9");
                        player1DefenseTextField.setText("9");
                        player1MagicTextField.setText("7");
                        player1HealthTextField.setText("17");


                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Ranger")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("9");
                        player1DamageTextField.setText("7");
                        player1DexTextField.setText("10");
                        player1DefenseTextField.setText("8");
                        player1MagicTextField.setText("7");
                        player1HealthTextField.setText("15");

                    } else {

                        player1AttackTextField.setText("9");
                        player1DamageTextField.setText("7");
                        player1DexTextField.setText("11");
                        player1DefenseTextField.setText("7");
                        player1MagicTextField.setText("7");
                        player1HealthTextField.setText("15");
                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Rogue")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("8");
                        player1DamageTextField.setText("8");
                        player1DexTextField.setText("11");
                        player1DefenseTextField.setText("9");
                        player1MagicTextField.setText("7");
                        player1HealthTextField.setText("15");

                    } else {

                        player1AttackTextField.setText("8");
                        player1DamageTextField.setText("9");
                        player1DexTextField.setText("11");
                        player1DefenseTextField.setText("8");
                        player1MagicTextField.setText("7");
                        player1HealthTextField.setText("15");
                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Mage")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("7");
                        player1DamageTextField.setText("10");
                        player1DexTextField.setText("7");
                        player1DefenseTextField.setText("8");
                        player1MagicTextField.setText("10");
                        player1HealthTextField.setText("13");

                    } else {

                        player1AttackTextField.setText("7");
                        player1DamageTextField.setText("10");
                        player1DexTextField.setText("8");
                        player1DefenseTextField.setText("7");
                        player1MagicTextField.setText("10");
                        player1HealthTextField.setText("13");
                    }
                }

                if( player1Class.getSelectedItem().toString().equals("Priest")){

                    if( player1Race.getSelectedItem().toString().equals("Human") ){

                        player1AttackTextField.setText("7");
                        player1DamageTextField.setText("7");
                        player1DexTextField.setText("8");
                        player1DefenseTextField.setText("8");
                        player1MagicTextField.setText("10");
                        player1HealthTextField.setText("13");

                    } else {

                        player1AttackTextField.setText("7");
                        player1DamageTextField.setText("7");
                        player1DexTextField.setText("9");
                        player1DefenseTextField.setText("7");
                        player1MagicTextField.setText("10");
                        player1HealthTextField.setText("13");

                    }
                }


            }
        });

        player2Level1.addMouseMotionListener(new MouseMotionAdapter() { } );

        //confirmed correct
        player2Level1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if( player2Class.getSelectedItem().toString().equals("Warrior")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("5");
                        player2DamageTextField.setText("7");
                        player2DexTextField.setText("4");
                        player2DefenseTextField.setText("6");
                        player2MagicTextField.setText("3");
                        player2HealthTextField.setText("13");

                    } else {

                        player2AttackTextField.setText("5");
                        player2DamageTextField.setText("7");
                        player2DexTextField.setText("5");
                        player2DefenseTextField.setText("5");
                        player2MagicTextField.setText("3");
                        player2HealthTextField.setText("13");


                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Ranger")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("5");
                        player2DamageTextField.setText("3");
                        player2DexTextField.setText("6");
                        player2DefenseTextField.setText("4");
                        player2MagicTextField.setText("3");
                        player2HealthTextField.setText("11");

                    } else {

                        player2AttackTextField.setText("5");
                        player2DamageTextField.setText("3");
                        player2DexTextField.setText("7");
                        player2DefenseTextField.setText("3");
                        player2MagicTextField.setText("3");
                        player2HealthTextField.setText("11");
                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Rogue")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("4");
                        player2DamageTextField.setText("4");
                        player2DexTextField.setText("7");
                        player2DefenseTextField.setText("5");
                        player2MagicTextField.setText("3");
                        player2HealthTextField.setText("11");

                    } else {

                        player2AttackTextField.setText("4");
                        player2DamageTextField.setText("5");
                        player2DexTextField.setText("7");
                        player2DefenseTextField.setText("4");
                        player2MagicTextField.setText("3");
                        player2HealthTextField.setText("11");
                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Mage")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("3");
                        player2DamageTextField.setText("6");
                        player2DexTextField.setText("3");
                        player2DefenseTextField.setText("4");
                        player2MagicTextField.setText("6");
                        player2HealthTextField.setText("9");

                    } else {

                        player2AttackTextField.setText("3");
                        player2DamageTextField.setText("6");
                        player2DexTextField.setText("4");
                        player2DefenseTextField.setText("3");
                        player2MagicTextField.setText("6");
                        player2HealthTextField.setText("9");
                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Priest")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("3");
                        player2DamageTextField.setText("3");
                        player2DexTextField.setText("4");
                        player2DefenseTextField.setText("4");
                        player2MagicTextField.setText("6");
                        player2HealthTextField.setText("9");

                    } else {

                        player2AttackTextField.setText("3");
                        player2DamageTextField.setText("3");
                        player2DexTextField.setText("5");
                        player2DefenseTextField.setText("3");
                        player2MagicTextField.setText("6");
                        player2HealthTextField.setText("9");

                    }
                }

            }

        });
        //confirmed correct
        player2Level2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if( player2Class.getSelectedItem().toString().equals("Warrior")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("7");
                        player2DamageTextField.setText("9");
                        player2DexTextField.setText("6");
                        player2DefenseTextField.setText("8");
                        player2MagicTextField.setText("5");
                        player2HealthTextField.setText("15");

                    } else {

                        player2AttackTextField.setText("7");
                        player2DamageTextField.setText("9");
                        player2DexTextField.setText("7");
                        player2DefenseTextField.setText("7");
                        player2MagicTextField.setText("5");
                        player2HealthTextField.setText("15");


                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Ranger")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("7");
                        player2DamageTextField.setText("5");
                        player2DexTextField.setText("8");
                        player2DefenseTextField.setText("6");
                        player2MagicTextField.setText("5");
                        player2HealthTextField.setText("13");

                    } else {

                        player2AttackTextField.setText("7");
                        player2DamageTextField.setText("5");
                        player2DexTextField.setText("9");
                        player2DefenseTextField.setText("5");
                        player2MagicTextField.setText("5");
                        player2HealthTextField.setText("13");
                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Rogue")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("6");
                        player2DamageTextField.setText("6");
                        player2DexTextField.setText("9");
                        player2DefenseTextField.setText("7");
                        player2MagicTextField.setText("5");
                        player2HealthTextField.setText("13");

                    } else {

                        player2AttackTextField.setText("6");
                        player2DamageTextField.setText("7");
                        player2DexTextField.setText("9");
                        player2DefenseTextField.setText("6");
                        player2MagicTextField.setText("5");
                        player2HealthTextField.setText("13");
                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Mage")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("5");
                        player2DamageTextField.setText("8");
                        player2DexTextField.setText("5");
                        player2DefenseTextField.setText("6");
                        player2MagicTextField.setText("8");
                        player2HealthTextField.setText("11");

                    } else {

                        player2AttackTextField.setText("5");
                        player2DamageTextField.setText("8");
                        player2DexTextField.setText("6");
                        player2DefenseTextField.setText("5");
                        player2MagicTextField.setText("8");
                        player2HealthTextField.setText("11");
                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Priest")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("5");
                        player2DamageTextField.setText("5");
                        player2DexTextField.setText("6");
                        player2DefenseTextField.setText("6");
                        player2MagicTextField.setText("8");
                        player2HealthTextField.setText("11");

                    } else {

                        player2AttackTextField.setText("5");
                        player2DamageTextField.setText("5");
                        player2DexTextField.setText("7");
                        player2DefenseTextField.setText("5");
                        player2MagicTextField.setText("8");
                        player2HealthTextField.setText("11");

                    }
                }
            }
        });

        //to be tested
        player2Level3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( player2Class.getSelectedItem().toString().equals("Warrior")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("9");
                        player2DamageTextField.setText("11");
                        player2DexTextField.setText("8");
                        player2DefenseTextField.setText("10");
                        player2MagicTextField.setText("7");
                        player2HealthTextField.setText("17");

                    } else {

                        player2AttackTextField.setText("9");
                        player2DamageTextField.setText("11");
                        player2DexTextField.setText("9");
                        player2DefenseTextField.setText("9");
                        player2MagicTextField.setText("7");
                        player2HealthTextField.setText("17");


                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Ranger")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("9");
                        player2DamageTextField.setText("7");
                        player2DexTextField.setText("10");
                        player2DefenseTextField.setText("8");
                        player2MagicTextField.setText("7");
                        player2HealthTextField.setText("15");

                    } else {

                        player2AttackTextField.setText("9");
                        player2DamageTextField.setText("7");
                        player2DexTextField.setText("11");
                        player2DefenseTextField.setText("7");
                        player2MagicTextField.setText("7");
                        player2HealthTextField.setText("15");
                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Rogue")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("8");
                        player2DamageTextField.setText("8");
                        player2DexTextField.setText("11");
                        player2DefenseTextField.setText("9");
                        player2MagicTextField.setText("7");
                        player2HealthTextField.setText("15");

                    } else {

                        player2AttackTextField.setText("8");
                        player2DamageTextField.setText("9");
                        player2DexTextField.setText("11");
                        player2DefenseTextField.setText("8");
                        player2MagicTextField.setText("7");
                        player2HealthTextField.setText("15");
                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Mage")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("7");
                        player2DamageTextField.setText("10");
                        player2DexTextField.setText("7");
                        player2DefenseTextField.setText("8");
                        player2MagicTextField.setText("10");
                        player2HealthTextField.setText("13");

                    } else {

                        player2AttackTextField.setText("7");
                        player2DamageTextField.setText("10");
                        player2DexTextField.setText("8");
                        player2DefenseTextField.setText("7");
                        player2MagicTextField.setText("10");
                        player2HealthTextField.setText("13");
                    }
                }

                if( player2Class.getSelectedItem().toString().equals("Priest")){

                    if( player2Race.getSelectedItem().toString().equals("Human") ){

                        player2AttackTextField.setText("7");
                        player2DamageTextField.setText("7");
                        player2DexTextField.setText("8");
                        player2DefenseTextField.setText("8");
                        player2MagicTextField.setText("10");
                        player2HealthTextField.setText("13");

                    } else {

                        player2AttackTextField.setText("7");
                        player2DamageTextField.setText("7");
                        player2DexTextField.setText("9");
                        player2DefenseTextField.setText("7");
                        player2MagicTextField.setText("10");
                        player2HealthTextField.setText("13");

                    }
                }
            }
        });
    }


    public void runSimulation( ){

        //create characters here
        //int attack, int dex, int health, int defense, int magic
        player1 = new Character( Integer.valueOf(player1AttackTextField.getText()),  Integer.valueOf(player1DexTextField.getText()),
                Integer.valueOf(player1HealthTextField.getText()),  Integer.valueOf(player1DefenseTextField.getText()),
                Integer.valueOf(player1MagicTextField.getText()), Integer.valueOf(player1DamageTextField.getText()), player1Class.getSelectedItem().toString()
        );

        player2 = new Character( Integer.valueOf(player2AttackTextField.getText()),  Integer.valueOf(player2DexTextField.getText()),
                Integer.valueOf(player2HealthTextField.getText()),  Integer.valueOf(player2DefenseTextField.getText()),
                Integer.valueOf(player2MagicTextField.getText()), Integer.valueOf(player2DamageTextField.getText()),player2Class.getSelectedItem().toString()
        );
        int iterations = 10000;
        Simulator currentSimulation = new Simulator(iterations, player1, player2, Integer.valueOf(player1StartingDistance.getText()) );
        currentSimulation.runSimulation();
        System.out.println(currentSimulation.averageDamageDealt/iterations);
        System.out.println(currentSimulation.averageNumberOfRounds/iterations);
        System.out.println(currentSimulation.player1wins/iterations);
        System.out.println(currentSimulation.player2wins/iterations);
        System.out.print("Win Difference = " + String.valueOf((currentSimulation.player1wins/iterations) - (currentSimulation.player2wins/iterations)));
        //try (PrintStream out = new PrintStream(new FileOutputStream(directoryChosen.getPath()+"\\filename.txt"))) {
        //    out.print(text);
       // }

        try {
            PrintStream output = new PrintStream(new FileOutputStream(directoryChosen.getPath() + "\\filename.txt", true));

            output.println(currentSimulation.averageDamageDealt/iterations + "," + currentSimulation.averageNumberOfRounds/iterations + "," +
                           currentSimulation.player1wins/iterations + "," + currentSimulation.player2wins/iterations);

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
