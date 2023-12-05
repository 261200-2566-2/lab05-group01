public class Archer implements Hero{
    private double Max_HP; 
    protected double HP;
    private double Max_Mana;
    private double Mana;
    private double Max_Speed;
    private double speed;
    private double Base_ATK;
    private double atk;
    private double Base_DEF;
    protected double def;
    private int level = 0;
    private boolean equipSword = false;
    private boolean equipBow = false;
    protected int turn = 0;
    private Sword s1;
    private Bow b1;
    String name;
    Archer(String name){
        this.name = name;
        this.HP = Hero.HP;
        this.Mana = Hero.Mana;
        this.atk = Hero.atk;
        this.def = Hero.def;
        this.speed = Hero.speed;
        this.Max_Speed = Hero.speed;
        this.Max_HP = Hero.HP;
        this.Max_Mana = Hero.Mana;
        this.Base_ATK = Hero.atk;
        this.Base_DEF = Hero.def;
        System.out.println("Create Warrior Name: " + this.name + " Level: " + this.level + " Maximum HP: "+this.Max_HP+ " Maximum Mana: "+this.Max_Mana+" Max Speed: "+this.Max_Speed+ " Base ATK: "+this.Base_ATK+" Base DEF: "+this.Base_DEF);
    }

    @Override
    public double attack(Warrior w) { //There are Warrior and Archer attacks that check whether the attack will kill the enemy or not. and display the result message.
        if (atk - w.def > 0) {
            if(atk-w.def >= w.HP){
                w.HP = 0;
            }else{
                w.HP = w.HP - (atk - w.def);
            }
            System.out.println("Archer " + this.name + " Attack Warrior " + w.name + " Attack: " + (this.atk - w.def) + " Warrior HP: " + w.HP);
            return atk - w.def;
        } else {
            return 0;
        }
    }

    @Override
    public double attack(Archer a) { //There are Warrior and Archer attacks that check whether the attack will kill the enemy or not. and display the result message.
        if(a.HP <= 0){//Start new turn when HP = 0
            System.out.println("This round was ended pls restart again.");
            return 0;
        }
        if(atk - a.def > 0){//When the attack value is greater than 0, it may cause HP loss or all HP.
            if(atk-a.def >= a.HP){
                a.HP = 0;
            }else{
                a.HP = a.HP - (atk - a.def);
            }
            System.out.println("Archer "+this.name + " Attack Archer "+a.name+ " Attack: "+(this.atk-a.def)+" Archer HP: "+a.HP);
            return atk - a.def;
        }else{
            return 0;
        }
    }

    @Override
    public void equip_Weapon_Sword() {//Used for changing weapons according to conditions.
        if(!equipBow){
            s1 = new Sword("Fire Sword");
            atk = Base_ATK + (2.5*level) + (double)(1/2)*s1.getAtk();
            speed = speed - s1.getReduceSpeed();
            equipSword = true;
            getCurrentInfo();
        }else{
            System.out.println("You should unequip bow before equip another weapon by unequipBow() method");
        }
    }
    @Override
    public void equip_Weapon_Bow() {//Used for changing weapons according to conditions.
        if(!equipSword){
            b1 = new Bow("Cross Bow");
            atk = Base_ATK + (2.5*level) + b1.getAtk();
            speed = speed - b1.getReduceSpeed();
            equipBow = true;
            getCurrentInfo();
        }else{
            System.out.println("You should unequip sword before equip another weapon by unequipSword() method");
        }
    }

    @Override
    public void unequipSword() {
        equipSword = false;
        atk = Base_ATK + (15*level);
        speed = Max_Speed;
    }

    @Override
    public void unequipBow() {
        equipBow = false;
        atk = Base_ATK + (15*level);
        speed = Max_Speed;
    }
    public double Arrow_Inferno(Warrior w){//Function to check level advancement and unlock skills
        if(w.HP <= 0){//Start new turn when HP = 0
            System.out.println("This round was ended pls restart again.");
            return 0;
        }
        if(equipBow){
            if(level >= 5){
                Mana = Mana-(double)(1/4)*Mana;
                if(w.HP < atk + 2.5* b1.getAtk()){
                    w.HP = 0;
                }else{
                    w.HP = w.HP - (atk+2.5*b1.getAtk());
                }
                System.out.println("Archer "+this.name + " Attack warrior "+w.name + " by unique skill Arrow Inferno ATK: "+(atk+b1.getAtk()*2.5)+" Warrior HP: "+w.HP);
                gameEnd(w);
                return (atk + 2.5*b1.getAtk());
            }else{
                System.out.println("You can't use this skill this skill will unlock when you level 5");
                return 0;
            }
        }else {
            System.out.println("You should equip Bow before");
        }
        return 0;
    }

    public double Arrow_Inferno(Archer a){//Function to check level advancement and unlock skills
        if(a.HP <= 0){//Start new turn when HP = 0
            System.out.println("This round was ended pls restart again.");
            return 0;
        }
        if(equipBow){
            if(level >= 5){
                Mana = Mana-(double)(1/4)*Mana;
                if(a.HP < atk + 2.5*b1.getAtk()){
                    a.HP = 0;
                }else{
                    a.HP = a.HP - (atk + 2.5*b1.getAtk());
                }
                System.out.println("Archer "+this.name + " Attack archer "+a.name + " by unique skill Arrow Inferno ATK:"+(atk + 2.5*b1.getAtk())+" Archer HP: "+a.HP);
                gameEnd(a);
                return (atk+2.5*b1.getAtk());
            }else{
                System.out.println("You can't use this skill this skill will unlock when you level 5");
                return 0;
            }
        }else{
            System.out.println("You should equip Bow before");
            return 0;
        }
    }
    @Override
    public void Level_UP() { //Increase various power points for the character.
        level = level+1;
        Max_HP = Max_HP + (8*level);
        Max_Mana = Max_Mana + (5*level);
        Max_Speed = Max_Speed + (5*level);
        HP = Max_HP;
        Mana = Max_Mana;
        speed = Max_Speed;
        atk = Base_ATK + (15*level);
        def = Base_DEF+(3*level);
        if(level == 5){
            System.out.println("Unlock 1st unique skill Arrow Inferno");
        }
        getCurrentInfo();
    }

    @Override
    public void getMaxInfo() {//Shows Archer's peak and current data.
        System.out.println("Name: "+this.name + " Level: " + this.level + " Maximum HP: "+this.Max_HP+ " Maximum Mana: "+this.Max_Mana+" Max Speed: "+this.Max_Speed+ " Base ATK: "+this.Base_ATK+" Base DEF: "+this.Base_DEF);
    }

    @Override
    public void getCurrentInfo(){
        System.out.println("Name: "+this.name + " Level: " + this.level + " Current HP: "+this.HP+ " Current Mana: "+this.Mana+" Current Speed: "+this.speed+ " Current ATK: "+this.atk+" Current DEF: "+this.def);
    }
    private void gameEnd(Warrior w){
        if(w.HP <= 0){
            System.out.println("Warrior "+w.name + " died! Warrior "+this.name+" Win!");
        }
    }
    private void gameEnd(Archer a){
        if(a.HP <= 0){
            System.out.println("Archer "+a.name + " died! Warrior "+this.name+" Win!");
        }
    }
    @Override
    public void enhance(){//Used to strengthen the weapons used.
        if(equipSword && !equipBow){
            s1.enhance();
            atk = Base_ATK + (2.5*level) + (double)(1/2)*s1.getAtk();
            speed = speed - s1.getReduceSpeed();
        }
        if(!equipSword && equipBow){
            b1.enhance();
            atk = Base_ATK + (2.5*level) + b1.getAtk();
            speed = speed - b1.getReduceSpeed();
        }
    }
}
