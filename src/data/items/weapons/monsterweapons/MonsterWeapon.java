package data.items.weapons.monsterweapons;

import data.Stats;
import data.WeaponRank;
import data.items.ItemType;
import data.items.weapons.DamageType;
import data.items.weapons.Weapon;
import entities.Attribute;

import java.util.HashMap;

public abstract class MonsterWeapon extends Weapon {

    public MonsterWeapon(int durability, int worth, boolean infinite, boolean priceless,
                         WeaponRank rank, int min, int range, int weight, int might, int hit, int crit,
                         int weaponExp, HashMap<Stats, Integer> bonus, DamageType damage, Attribute... attributes) {
        super(durability, ItemType.MonsterWeapon, worth, infinite, priceless,
                rank, min, range, weight, might, hit, crit, weaponExp, bonus, damage, attributes);
    }
}
