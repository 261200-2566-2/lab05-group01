public interface Hero {
    final double atk = 10;
    final double def = 8;
    final double speed = 10;
    final double Mana = 10;
    final double HP = 100;
    public double attack(Warrior w);
    public double attack(Archer w);
    public void equip_Weapon_Sword();
    public void equip_Weapon_Bow();
    public void unequipSword();
    public void unequipBow();
    public void Level_UP();
    public void getMaxInfo();
    public void getCurrentInfo();
    public void enhance();
}
