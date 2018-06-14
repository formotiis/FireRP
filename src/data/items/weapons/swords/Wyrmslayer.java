package data.items.weapons.swords;

import data.Stats;
import data.WeaponRank;
import data.items.weapons.DamageType;
import entities.Attribute;

import java.util.HashMap;

public class Wyrmslayer extends Sword{

    public static final String name ="Dracocide";

    public Wyrmslayer() {
        super(30, 4500, false, false,
                WeaponRank.C, 1, 1, 5, 8, 75, 0, 1, new HashMap<>(),
                DamageType.Physical, Attribute.Dragon);
    }

    @Override
    protected String name() {
        return name;
    }
}
