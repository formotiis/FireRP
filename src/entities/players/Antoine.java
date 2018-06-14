package entities.players;

import data.classes.units.Manakete;
import data.items.weapons.monsterweapons.Dragonstone;
import entities.Attribute;

public class Antoine extends Player{


    public Antoine(Manakete m, int level) {
        super(m.getAntoineBase(), m.getAntoineGrowth(),m.getCaps(),
                m, level,0, Attribute.Dragon);
        this.addItem(new Dragonstone());
    }

    @Override
    public String toString(){
        return "Antoine";
    }
}
