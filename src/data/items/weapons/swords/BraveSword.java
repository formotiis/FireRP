package data.items.weapons.swords;

import data.Stats;
import data.WeaponRank;
import data.items.weapons.DamageType;

import java.util.HashMap;

public class BraveSword extends Sword {
    public static final String name="Epee Heros";

    public BraveSword() {
        super(30, 7500, false ,false ,
                WeaponRank.B, 1,1, 12,
                9, 75, 0, 1,
                new HashMap<>(), DamageType.Physical);
    }

    @Override
    protected String name() {
        return name;
    }
}
