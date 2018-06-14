package data.items.weapons;

import data.Stats;
import data.WeaponRank;
import data.items.Item;
import data.items.ItemType;
import entities.Attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class Weapon extends Item {
    WeaponRank rank;
    private int minRange;
    private int range;
    private int weight;
    private int might;
    private int hit;
    private ArrayList<Attribute> attributes;
    private int crit;
    private int weaponExp;
    private DamageType type;


    HashMap<Stats, Integer> bonus;

    public Weapon(int durability, ItemType type, int worth, boolean infinite, boolean priceless, WeaponRank rank,
                  int min, int range, int weight, int might, int hit, int crit, int weaponExp,
                  HashMap<Stats, Integer> bonus, DamageType damage, Attribute... attributes) {
        super(durability, type, worth, infinite, priceless);
        this.rank = rank;
        this.minRange = min;
        this.range = range;
        this.weight = weight;
        this.might = might;
        this.hit = hit;
        this.crit = crit;
        this.type = damage;
        this.attributes = new ArrayList<>(Arrays.asList(attributes));
        this.weaponExp = weaponExp;
        this.bonus = bonus;
    }

    public WeaponRank getRank() {
        return rank;
    }

    public DamageType getDamageType() {
        return type;
    }

    public int getRange() {
        return range;
    }

    public int getWeight() {
        return weight;
    }

    public int getMight() {
        return might;
    }

    public int getHit() {
        return hit;
    }

    public int getCrit() {
        return crit;
    }

    public int getWeaponExp() {
        return weaponExp;
    }

    public HashMap<Stats, Integer> getBonus() {
        return bonus;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public int getMinRange() {
        return minRange;
    }

    @Override
    public boolean isWeapon() {
        return true;
    }

}
