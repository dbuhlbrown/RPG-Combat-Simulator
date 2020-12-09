import java.util.Random;

public class Character {

    private int attack;
    private int dex;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private int health;
    private int defense;
    private int magic;
    private int damage;
    private int totalDamageDealt;
    private String playerClass;
    Random rand = new Random();

    Character( ){


    }

    Character(int attack, int dex, int health, int defense, int magic, int damage, String playerClass){

        this.attack = attack;
        this.dex = dex;
        this.health = health;
        this.defense = defense;
        this.magic = magic;
        this.damage = damage;
        this.totalDamageDealt = 0;
        this.playerClass = playerClass;
    }

    //takes in the attacking character and calculates how much health is lost
    public void takeHit( Character attackingCharacter){
        int attack_d6 = rand.nextInt(6) + 1;


        int damageDealt = (attackingCharacter.damage + attack_d6 ) - this.defense;
        //System.out.println("damageDealt = " + damageDealt);

        if(damageDealt <= 0){
            damageDealt = 0;
        }

        if(attack_d6 == 6){
            damageDealt++;
        }

        //System.out.println("damageDealth = " + damageDealt);
        this.health -= damageDealt;
        this.totalDamageDealt += damageDealt;
    }

    //performs the attack action
    public void attack( Character characterToBeAttacked){
        //System.out.println(playerClass);

        int hitD6 = rand.nextInt(6) + 1;
        int defendingPlayerHitD6 = rand.nextInt(6) + 1;

        if(playerClass.equals("Warrior") || playerClass.equals("Rogue")) {
           // System.out.println("class is warrior");

          //  System.out.println("hit D6 = " + hitD6);
            if ( (this.attack + hitD6 >= characterToBeAttacked.dex + defendingPlayerHitD6 - 1)|| hitD6 == 6) {
                //if you enter this if, it means you have hit
                characterToBeAttacked.takeHit(this);
            }

        } else if( playerClass.equals("Ranger") ){

            if ( (this.dex + hitD6) >= characterToBeAttacked.dex + defendingPlayerHitD6 - 1  || hitD6 == 6) {
                //if you enter this if, it means you have hit
                characterToBeAttacked.takeHit(this);
            }
        } else if( playerClass.equals("Mage")){

            if ( (this.magic + hitD6) >= characterToBeAttacked.magic + defendingPlayerHitD6 - 1  || hitD6 == 6) {
                //if you enter this if, it means you have hit
                characterToBeAttacked.takeHit(this);
            }
        }
    }

    //retaliation code
    //need to fix this
    public void retaliate(Character characterToRetaliateAgainst){

        int hitD6 = rand.nextInt(6) + 1;


        int retaliationHitD6 = rand.nextInt(6) + 1;


        if(playerClass.equals("Warrior") || playerClass.equals("Rogue")) {

            if(this.attack + hitD6 - 1 >= characterToRetaliateAgainst.dex + retaliationHitD6){
                //if you enter this if, it means you have hit
                characterToRetaliateAgainst.takeHit(this);
            }
        }

        else if(playerClass.equals("Ranger")) {

            if(this.dex + hitD6 - 1 >= characterToRetaliateAgainst.dex + retaliationHitD6){
                //if you enter this if, it means you have hit
                characterToRetaliateAgainst.takeHit(this);
            }
        } else if(playerClass.equals("Mage")) {

            if(this.magic + hitD6 - 1 >= characterToRetaliateAgainst.magic + retaliationHitD6){
                //if you enter this if, it means you have hit
                characterToRetaliateAgainst.takeHit(this);
            }
        }
    }

    public boolean isDead( ){

        if(this.health <= 0){
            System.out.println("inside isDead if");
            return true;
        } else {
            return false;
        }
    }

    //ignore this for now
    public void levelUp( ){


    }


}
