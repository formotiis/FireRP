package entities.monsters;

import data.DataCenter;
import data.Stats;
import data.classes.Job;
import entities.Attribute;
import entities.Entity;

import java.util.HashMap;

public abstract class Monster extends Entity{

    protected Monster(HashMap<Stats, Integer> stats, HashMap<Stats, Integer> growth, HashMap<Stats, Integer> caps, Job job, int level) {
        super(stats, growth, caps, job, level, DataCenter.nextId++, Attribute.Monster);
        for (int i=1;(i<level&&!levelMax());i++) {
            this.concreteLevelUp();
        }
        hpReset();
    }

    public abstract String name();

    @Override
    public String toString() {
        return name() + entityID + " lv" + getLevel();
    }


}
