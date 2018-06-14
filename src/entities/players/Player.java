package entities.players;

import data.Stats;
import data.classes.Job;
import entities.Attribute;
import entities.Entity;

import javax.print.AttributeException;
import java.util.HashMap;

public abstract class Player extends Entity {


    protected Player(HashMap<Stats, Integer> stats, HashMap<Stats, Integer> growth,
                     HashMap<Stats, Integer> caps, Job job, int level,int uid,  Attribute... attributes) {
        super(stats, growth, caps, job, level,uid, attributes);
    }

    @Override
    public boolean isPlayer() {
        return true;
    }
}
