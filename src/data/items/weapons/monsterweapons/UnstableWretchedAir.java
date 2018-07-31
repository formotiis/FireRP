package data.items.weapons.monsterweapons;

import data.Stats;
import data.WeaponRank;
import data.items.weapons.DamageType;
import entities.Attribute;

import java.util.HashMap;

public class UnstableWretchedAir extends MonsterWeapon {

    public static String name = "Air Vicié (Instable)";

    public UnstableWretchedAir() {
        super(60, 0, true, true, WeaponRank.Pf, 1, 2, 0, 10,
                100, 0, 0, getLocalbonues(), DamageType.Hybrid, Attribute.IgnoresArmor);
    }

    public static HashMap<Stats, Integer> getLocalbonues(){
        HashMap<Stats, Integer> b = new HashMap<>();
        b.put(Stats.Atk, -5);
        b.put(Stats.Tec, -5);
        b.put(Stats.Def, -8);
        b.put(Stats.Res, -10);
        return b;
    }

    @Override
    protected String name() {
        return name;
    }
}
