package battles;

import data.DataCenter;
import data.WeaponRank;
import data.items.ItemType;
import data.items.weapons.DamageType;
import data.items.weapons.Weapon;
import entities.Attribute;
import entities.Entity;

import javax.swing.*;
import java.util.Random;

public class BattleOracle {

    public BattleOracle() {
    }

    private static BattleOracle instance;

    public static BattleOracle getInstance(){
        if (instance==null) {
            instance = new BattleOracle();
        }
        return instance;
    }

    public String predictions(Entity attack, Entity defense, int range){
        StringBuilder sb= new StringBuilder();
        sb.append(attack+"@"+attack.getEquiped());
        if (defense.hasWeapon())
        sb.append("\t"+defense+"@"+defense.getEquiped());
                sb.append("\n");
        sb.append("Predictions: \nHp: \n");
        sb.append(attack+"\t"+attack.getCurrentHP()+"/"+attack.getMaxHP()+"\n");
        sb.append(defense+"\t"+defense.getCurrentHP()+"/"+defense.getMaxHP()+"\n");
        sb.append("Damages: \n");
        sb.append(attack+"\t"+calcDamages(attack, defense, range)+sDoubleAttack(attack, defense)+"\n");
        sb.append(defense+"\t"+calcDamages(defense, attack, range)+sDoubleAttack(defense,attack)+"\n");
        sb.append("Accuracy: \n");
        sb.append(attack+"\t"+accuracy(attack, defense)+"\n");
        sb.append(defense+"\t"+accuracy(defense,attack)+"\n");

        return sb.toString();
    }

    public String fight(Entity attack, Entity defense, int range){

        StringBuilder log = new StringBuilder();

        if (attack.hasWeapon()){
            if (attack.getEquiped().getAttributes().contains(Attribute.Brave)){
                log.append(offenseive(attack, defense, range));
            }
            log.append(offenseive(attack, defense, range));
        }
        if (!defense.isDead()) {
            if (defense.hasWeapon()) {
                if (defense.getEquiped().getAttributes().contains(Attribute.Brave)) {
                    log.append(offenseive(defense, attack, range));
                }
                log.append(offenseive(defense, attack, range));
            }
            if(!attack.isDead()) {
                if (doubleAttack(attack, defense)) {
                    if (attack.hasWeapon()) {
                        if (attack.getEquiped().getAttributes().contains(Attribute.Brave)) {
                            log.append(offenseive(attack, defense, range));
                        }
                        log.append(offenseive(attack, defense, range));
                    }
                } else if (doubleAttack(defense, attack)) {
                    if (defense.hasWeapon()) {
                        if (defense.getEquiped().getAttributes().contains(Attribute.Brave)) {
                            log.append(offenseive(defense, attack, range));
                        }
                        log.append(offenseive(defense, attack, range));
                    }
                }
            }
        }
        DataCenter.getInstance().forceRefresh();
        return log.toString();
    }

    private String offenseive(Entity attack, Entity defense, int range){
        int prc, xp, dmg;boolean crit;
        StringBuilder log = new StringBuilder();
        Random r = DataCenter.random();

        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        String nom =null;
        while (nom == null)
        nom = jop.showInputDialog(null, "Roll :",
                "Precision "+attack, JOptionPane.QUESTION_MESSAGE);
        //jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);

        prc = Integer.parseInt(nom);

        if (prc <= accuracy(attack, defense)){
            dmg = calcDamages(attack,defense,range);
            crit = critical(attack,defense)>=r.nextInt(101);
            defense.receiveDamages(getCritDamages(dmg,crit));
            log.append(attack+" inflicted "+getCritDamages(dmg,crit));
            if(crit)
                log.append(" as a crit");
            if (defense.getCurrentHP()==0)
                log.append(" to "+defense+" who died.");
            else
                log.append(" to "+defense+" who has now "+defense.getCurrentHP()+"hp.");
            attack.getEquiped().use();
        } else log.append(attack+"'s attack missed");

        return log.append("\n").toString();
    }

    public int calcDamages(Entity attack, Entity defense, int range){
        int att, def=0, total;

        if (attack.getDamageType() == null||!attack.canAttackAtRange(range)){
            att = 0;
        }else {
            DamageType d = attack.getDamageType();
            Weapon w= attack.getEquiped();
            att = attack.getFullAtk() + (w.getMight()+triangleBonus(attack,defense))*defense.effectiveness(w);

            if (d == DamageType.Physical){

                if (attack.getEquiped().getAttributes().contains(Attribute.IgnoresArmor)) {
                    def = 0;
                } else {
                    def = defense.getFullDef();
                }
            } else if (d == DamageType.Magic){
                def = defense.getFullRes();
            } else {
                if (attack.getEquiped().getAttributes().contains(Attribute.IgnoresArmor)){
                    def = defense.getFullRes() / 2;
                } else {
                    def = defense.getFullRes() / 2 + defense.getFullDef() / 2;
                }
            }
            if (attack.getEquiped().getAttributes().contains(Attribute.IgnoresArmor)){
                def =0;
            }
        }
        total = att-def;
        if (total<0){
            total =0;
        }
        return total;
    }

    public int accuracy(Entity attack, Entity defense){
        int att, def, total;
        if (attack.getDamageType() ==null){
            att = 0;
        }else {
            att = attack.getEquiped().getHit()+attack.getFullTec()*2+attack.getFullCha()/2+triangleBonus(attack,defense)*15;
            if (attack.getEquiped().getRank()== WeaponRank.S){
                att+=5;
            }
        }
        def = defense.getFullVit()*2+defense.getFullCha();

        total = att-def;
        if (total<0){
            total =0;
        }else if (total>100)
            total =100;
        return total;
    }

    public boolean doubleAttack(Entity attack, Entity defense){
        int att=0, def=0;
        att = attack.getFullVit();
        if (attack.hasWeapon()){
            att = att - Integer.max(attack.getEquiped().getWeight()-8,0);
        }

        def = defense.getFullVit();
        if (defense.hasWeapon()){
            def= def - Integer.max(defense.getEquiped().getWeight()-8,0);
        }

        return (att-def)>=4;
    }
    public String sDoubleAttack(Entity a, Entity d){
        int mult=0;

        if (doubleAttack(a,d)){
            mult =2;
        }

        if (a.hasWeapon()){
            if (a.getEquiped().getAttributes().contains(Attribute.Brave))
                mult += 2;
        }

        if (mult !=0)
            return "x"+mult;
        return "";
    }


    private int triangleBonus(Entity a, Entity d){
        int b = 0;
        if (a.hasWeapon()&&d.hasWeapon()){
            if(a.getWeaponType()== ItemType.Sword){
                if(d.getWeaponType() == ItemType.Lance){
                    b = -1;
                } else if (d.getWeaponType() == ItemType.Axe){
                    b = 1;
                }
            }

            else if(a.getWeaponType()== ItemType.Lance){
                if(d.getWeaponType() == ItemType.Axe){
                    b = -1;
                } else if (d.getWeaponType() == ItemType.Sword){
                    b = 1;
                }
            }

             else if(a.getWeaponType()== ItemType.Axe){
                if(d.getWeaponType() == ItemType.Sword){
                    b = -1;
                } else if (d.getWeaponType() == ItemType.Lance){
                    b = 1;
                }
            }

            else if(a.getWeaponType()== ItemType.AnimaMagic){
                if(d.getWeaponType() == ItemType.LightMagic){
                    b = -1;
                } else if (d.getWeaponType() == ItemType.DarkMagic){
                    b = 1;
                }
            }

            else if(a.getWeaponType()== ItemType.LightMagic){
                if(d.getWeaponType() == ItemType.AnimaMagic){
                    b = -1;
                } else if (d.getWeaponType() == ItemType.DarkMagic){
                    b = 1;
                }
            }

            else if(a.getWeaponType()== ItemType.DarkMagic){
                if(d.getWeaponType() == ItemType.LightMagic){
                    b = -1;
                } else if (d.getWeaponType() == ItemType.AnimaMagic){
                    b = 1;
                }
            }
        }
        return b;
    }

    public int critical(Entity attack, Entity defense){
        int att, def, total;
        if (attack.hasWeapon()){
            att = attack.getEquiped().getCrit()+ attack.getFullTec()/2 + attack.critBonus() ;
            if (attack.getEquiped().getRank()== WeaponRank.S){
                att+=5;
            }
        } else att=0;

        def = defense.getCha();

        total = att-def;
        if (total<0){
            total =0;
        }else if (total>100)
            total =100;
        return total;
    }

    public int getCritDamages(int dmg, boolean crit){
        if (crit)
            return dmg*3;
        return dmg;
    }

}
