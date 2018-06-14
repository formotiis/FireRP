package data.items.weapons.swords;

import data.Stats;
import data.WeaponRank;
import data.items.weapons.DamageType;
import entities.Attribute;

import java.util.HashMap;

public class RuneSword extends Sword {

    public static final String name = "Epee Runique";

    public RuneSword() {
        super(15, 3300, false, false, WeaponRank.A,
                1, 2, 11, 12, 65, 0, 1, new HashMap<>(),
                DamageType.Magic, Attribute.LifeSteal);
    }

    @Override
    protected String name() {
        return name;
    }
}
