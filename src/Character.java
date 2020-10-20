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
    Random rand = new Random();

    Character( ){


    }

    Character(int attack, int dex, int health, int defense, int magic, int damage){

        this.attack = attack;
        this.dex = dex;
        this.health = health;
        this.defense = defense;
        this.magic = magic;
        this.damage = damage;
        this.totalDamageDealt = 0;
    }

    //takes in the attacking character and calculates how much health is lost
    public void takeHit( Character attackingCharacter){

        int damageDealt = (attackingCharacter.damage + rand.nextInt(12) ) - this.defense;
        //System.out.println("damageDealth = " + damageDealt);
        if(damageDealt <= 0){
            damageDealt = 1;
        }

        this.health -= damageDealt;
        totalDamageDealt += damageDealt;
    }

    //performs the attack action
    public void attack( Character characterToBeAttacked){

        if(this.attack + rand.nextInt(12) >= characterToBeAttacked.dex + rand.nextInt(12)){
            //if you enter this if, it means you have hit
            characterToBeAttacked.takeHit(this);
        }
    }

    //retaliation code
    //need to fix this
    public void retaliate(Character characterToRetaliateAgainst){

        if(this.attack + rand.nextInt(12) - 1 >= characterToRetaliateAgainst.dex + rand.nextInt(12)){
            //if you enter this if, it means you have hit
            characterToRetaliateAgainst.takeHit(this);
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
