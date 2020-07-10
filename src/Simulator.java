public class Simulator {

    private Character player1;
    private Character player2;

    public double player1wins;
    public double player2wins;
    public double averageNumberOfRounds;
    public int iterations;
    public double averageDamageDealt;
    Simulator(){


    }

    Simulator(int iterations, Character player1, Character player2){

        this.player1 = player1;
        this.player2 = player2;
        runSimulation();
        this.iterations = iterations;

    }

    public void simulateFight( ){


    }

    public void runSimulation(){

        player1wins = 0;
        player2wins = 0;
        averageNumberOfRounds = 0;
        averageDamageDealt = 0;
        int player1StartingHealth = player1.getHealth();
        int player2StartingHealth = player2.getHealth();

        for(int i = 0; i < iterations; i++ ) {

            //this loop will run until a player has died.
            //We will determine who died first elsewhere in the code
            boolean playerOneAttack = true;

            boolean player2HasRetaliated = true;
            boolean player1HasRetaliated = true;

            boolean isFirstAttack = true;

            while (!player1.isDead() && !player2.isDead()) {
                //System.out.println("inside while");
                averageNumberOfRounds++;
                if (playerOneAttack) {

                    if(player1HasRetaliated) {

                        player1.attack(player2);
                        playerOneAttack = false;
                        isFirstAttack = false;
                        player2HasRetaliated = false;
                        System.out.println(player2.getHealth());

                    } else{

                        player1.retaliate(player2);
                        player1HasRetaliated = true;
                    }

                } else {

                    if(player2HasRetaliated){

                        player2.attack(player1);
                        player1HasRetaliated = false;
                        playerOneAttack = true;
                    } else{

                        player2.retaliate(player1);
                        player2HasRetaliated = true;

                    }
                }
            }
            if(player1.isDead()){

                player2wins++;

            } else{

                player1wins++;
            }

            this.player1.setHealth(player1StartingHealth);
            this.player2.setHealth(player2StartingHealth);
        }
    }
}
