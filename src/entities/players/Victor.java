package entities.players;

import data.classes.units.Myrmidon;
import data.items.weapons.swords.IronSword;

public class Victor extends Player {
    public Victor(Myrmidon m, int level) {
        super(m.getVictorBase(), m.getVictorGrowth(),m.getCaps(), m, level, 1);
        addItem(new IronSword());
    }

    @Override
    public String toString(){
        return "Victor";
    }
}
