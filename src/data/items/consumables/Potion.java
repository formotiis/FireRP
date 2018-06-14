package data.items.consumables;

import entities.Entity;

public class Potion extends Consumable{

    public static String name = "Potion";

    public Potion() {
        super(3, 150);
    }

    @Override
    public void effect(Entity e) {
        e.gainHP(10);
        System.out.println(e+" used a Potion to recover HP\n"+e+" has now "+e.getCurrentHP()+"hp.");
    }

    @Override
    protected String name() {
        return name;
    }
}
