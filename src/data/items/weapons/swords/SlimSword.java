package data.items.weapons.swords;

import data.Stats;
import data.WeaponRank;
import data.items.weapons.DamageType;

import java.util.HashMap;

public class SlimSword extends Sword {
    public static final String name ="Epee fine";
    public SlimSword(){
        super(30, 480, false, false, WeaponRank.E,
                1, 2, 3, 100, 5, 1,
                new HashMap<>(), DamageType.Physical);
    }

    @Override
    protected String name() {
        return name;
    }
}
