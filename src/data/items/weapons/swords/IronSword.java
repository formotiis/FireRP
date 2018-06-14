package data.items.weapons.swords;

import data.Stats;
import data.WeaponRank;
import data.items.weapons.DamageType;

import java.util.HashMap;

public class IronSword extends Sword{

    public static final String name ="Epee fer";

    public IronSword() {
        super(46, 460,false, false, WeaponRank.E,
                1, 5, 5, 90, 0, 1,
                new HashMap<>(), DamageType.Physical);
    }

    @Override
    protected String name() {
        return name;
    }
}
