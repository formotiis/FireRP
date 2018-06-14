package data.items.weapons.swords;

import data.Stats;
import data.WeaponRank;
import data.items.weapons.BonusFactory;
import data.items.weapons.DamageType;

import java.util.HashMap;

public class GodSword extends Sword {

    public static final String name = "Heavenly sent";

    public GodSword() {
        super(2, 0, true, true, WeaponRank.Pf,
                1,5, 1, 20, 110, 80, 0,
                BonusFactory.getInstance().getHeavenly(), DamageType.Hybrid);
    }

    @Override
    protected String name() {
        return name;
    }
}
