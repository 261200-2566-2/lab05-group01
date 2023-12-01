public class Sword implements Weapon{
    String name;
    private final double Base_atk;
    private double atk;
    private int level = 0;
    private final double Base_Reduce_speed;
    private double reduce_speed;
    Sword(String name){
        this.name = name;
        this.Base_atk = 20;
        this.atk = 20;
        this.Base_Reduce_speed = 2.5;
        this.reduce_speed = 2.5;
    }

    @Override
    public void enhance() {
        level = level+1;
        if(level < 5){
            this.atk = Base_atk + (0.5)*(double) level;
            reduce_speed = Base_Reduce_speed + (double)(level);
        }
        unique_Skill(level);
        if(level > 5 && level < 10){
            this.atk = 1.5*(Base_atk + (0.5)*(double) level);
            reduce_speed = Base_Reduce_speed + (double)(level);
        }
        if(level >= 10){
            atk = (double)(2)*(Base_atk+(0.5)*(double) level);
            reduce_speed = Base_Reduce_speed + (double)(level);
        }
        getCurrentInfo();
    }

    @Override
    public double getAtk() {
        double deep_atk = atk;
        return deep_atk;
    }
    @Override
    public double getReduceSpeed(){
        double deep_redeceSpeed = reduce_speed;
        return deep_redeceSpeed;
    }

    private void unique_Skill(int level) {
        if(level == 5){
            System.out.println("You unlock unique skill fire sword.");
            atk = 1.5*(Base_atk + (double)(1/2)*level);
            reduce_speed = Base_Reduce_speed + (double)(2*level);
        }
        if(level == 10){
            System.out.println("You unlock unique skill severe sword.");
            atk = (double)(2)*(Base_atk+(double)(1/2)*level);
            reduce_speed = Base_Reduce_speed + (double)(2*level);
        }
    }
    protected void getCurrentInfo(){
        System.out.println("Atk:"+this.getAtk() + " Reduce speed:"+this.getReduceSpeed());
    }
}
