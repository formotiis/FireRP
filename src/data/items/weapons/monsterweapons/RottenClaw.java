package data.items.weapons.monsterweapons;

import data.Stats;
import data.WeaponRank;
import data.items.ItemType;
import data.items.weapons.DamageType;
import data.items.weapons.Weapon;

import java.util.HashMap;

public class RottenClaw extends Weapon {

    public static final String name ="Griffes Putrides";

    public RottenClaw() {
        super(1, ItemType.MonsterWeapon, 0, true, true, WeaponRank.None, 1,
                1, 8, 7, 80, 0, 0, new HashMap<>(), DamageType.Physical);
    }

    public String name() {
        return name;
    }
}
