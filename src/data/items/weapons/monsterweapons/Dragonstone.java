package data.items.weapons.monsterweapons;

import data.Stats;
import data.WeaponRank;
import data.items.ItemType;
import data.items.weapons.BonusFactory;
import data.items.weapons.DamageType;
import data.items.weapons.Weapon;

import java.util.HashMap;

public class Dragonstone extends Weapon {

    public static final String name = "Dracopierre";

    public Dragonstone() {
        super(50, ItemType.MonsterWeapon, 0, false, true, WeaponRank.Pf, 1,
                    1,0, 16, 100, 15, 0, BonusFactory.getInstance().getDragonstone(), DamageType.Hybrid);
    }

    public String name() {
        return name;
    }
}
