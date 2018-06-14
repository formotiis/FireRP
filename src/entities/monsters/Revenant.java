package entities.monsters;

import data.DataCenter;
import data.Stats;
import data.classes.Job;
import data.classes.monsters.RevenantClass;
import data.items.weapons.monsterweapons.RottenClaw;

import java.util.HashMap;

public class Revenant extends Monster{

    public static final String name= "Revenant";

    private Revenant(RevenantClass m, int level) {
        super(m.getBase(), m.getGrowth(), m.getCaps(), m, level);
    }

    public Revenant(int level){
        this(new RevenantClass(), level);
        this.addItem(new RottenClaw());
    }

    public Revenant(){
        this(DataCenter.random().nextInt(6)+4);
        this.addItem(new RottenClaw());
    }

    public String name() {
        return name;
    }
}
