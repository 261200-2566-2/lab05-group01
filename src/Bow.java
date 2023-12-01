public class Bow implements Weapon{
    String name ;
    private int level = 0;
    private final double Base_atk;
    private double atk = 0;
    private final double Base_Reduce_speed;
    private double reduce_speed;
    Bow(String name){
        this.name = name;
        this.Base_atk = 30;
        this.Base_Reduce_speed = 1;
        this.atk = Base_atk;
        this.reduce_speed = Base_Reduce_speed;
    };

    @Override
    public void enhance() {
        level = level+1;
        if(level < 5){
            this.atk = Base_atk + (double)(0.5)*level;
            reduce_speed = Base_Reduce_speed + (1.5*(double) level);
        }
        unique_Skill(level);
        if(level > 5 && level < 10){
            this.atk = (double)3*(Base_atk + (double)(0.5)*level);
            reduce_speed = Base_Reduce_speed + (1.5*(double) level);
        }
        if(level >= 10){
            atk = (double)(4)*(Base_atk+(double)(0.5)*level);
            reduce_speed = Base_Reduce_speed + (1.5*(double) level);
        }
        getCurrentInfo();
    }

    private void unique_Skill(int level) {
        if(level == 5){
            System.out.println("You unlock unique skill poison arrow.");
            atk = (double)3*(Base_atk + (double)(1/2)*level);
            reduce_speed = Base_Reduce_speed + (double)(2*level);
        }
        if(level == 10){
            System.out.println("You unlock unique skill fire arrow.");
            atk = (double)(4)*(Base_atk+(double)(1/2)*level);
            reduce_speed = Base_Reduce_speed + (double)(2*level);
        }
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
    protected void getCurrentInfo(){
        System.out.println("Atk:"+this.getAtk() + " Reduce speed:"+this.getReduceSpeed());
    }
}
