// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------Declare Hero with Base Stat in interface--------------------------"); //At begin any Hero have same stat
        Warrior A = new Warrior("MAX");
        Warrior B = new Warrior("MIX");
        Archer C = new Archer("SAD");
        Archer D = new Archer("GAME");
        System.out.println("----------------------------Level up Hero----------------------------------------------");//Any class of Hero will unlock unique skill when level 5 and level 10
        for(int i = 0 ; i < 10 ; i++){ //Each class has difference stat but in same class have the same stat
            A.Level_UP();
            B.Level_UP();
            C.Level_UP();
            D.Level_UP();
        }
        System.out.println("-------------------------------Equip weapon--------------------------------------------");//Any class of Hero can use any weapon. don't match hero class that weapon will not at full efficiency
        A.equip_Weapon_Sword(); //The same class but difference weapon stat will difference too
        B.equip_Weapon_Bow();
        C.equip_Weapon_Sword();
        D.equip_Weapon_Bow();
        A.equip_Weapon_Bow(); //If you have to use any weapon you won't use other weapon until unequip that weapon before.
        B.equip_Weapon_Sword();
        C.equip_Weapon_Bow();
        D.equip_Weapon_Sword();
        System.out.println("----------------------------Enhance Weapon---------------------------------------------");//Any class of weapon will unlock unique skill when level 5 and level 10 and will automatically use until unequip that weapon
        for(int i = 0 ; i < 10 ; i++){ //Each class has difference stat but in same class have the same stat
            A.enhance();
            B.enhance();
            C.enhance();
            D.enhance();
            A.getCurrentInfo(); //As you see each hero has their stat
            B.getCurrentInfo();
            C.getCurrentInfo();
            D.getCurrentInfo();
        }
        System.out.println("----------------------------Warrior and Weapon Unique Skill----------------------------");//Any class of weapon will unlock unique skill when level 5 and level 10
        A.Crazy_Warrior(B); //This unique skill will attack by 1.5*atk
        B.getCurrentInfo();
        B.attack(A); //Hero B attack hero A with commander skill 60 ATK and A has DEF 58
        A.getCurrentInfo();
        B.unequipBow();
        B.equip_Weapon_Sword();
        for(int i=0;i<10;i++){
            B.enhance();
        }
        B.getCurrentInfo();
        A.getCurrentInfo();
        System.out.println("----------------------------Archer and Weapon Unique Skill----------------------------");//Any class of weapon will unlock unique skill when level 5 and level 10
        C.Arrow_Inferno(D);
        C.unequipSword();
        C.equip_Weapon_Bow();
        C.Arrow_Inferno(D);
        D.getCurrentInfo();
        D.attack(C);
        C.getCurrentInfo();
    }
}