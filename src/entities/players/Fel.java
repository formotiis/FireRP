package entities.players;

import data.Stats;
import data.classes.Job;
import data.classes.units.PegasusKnight;
import entities.Attribute;

import java.util.HashMap;

public class Fel extends Player {
    public Fel(PegasusKnight m, int level) {
        super(m.getFelBase(), m.getFelGrowth(),m.getCaps(), m, level,2, Attribute.Flying);
    }

    @Override
    public String toString(){
        return "Felicien";
    }
}
