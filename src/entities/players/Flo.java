package entities.players;

import data.classes.units.Priest;

public class Flo extends Player{

    public Flo(Priest m, int level) {
        super(m.getFloBase(), m.getFloGrowth(),m.getCaps(), m,3, level);
    }

    @Override
    public String toString(){
        return "Florian";
    }
}
