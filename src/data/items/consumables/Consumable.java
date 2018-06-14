package data.items.consumables;

import data.items.Item;
import data.items.ItemType;
import entities.Entity;

public abstract class Consumable extends Item {
    public Consumable(int durability, int worth) {
        super(durability, ItemType.Item, worth, false, false);
    }

    public abstract void effect(Entity e);

    @Override
    public boolean isWeapon() {
        return false;
    }

    public void use(Entity e){
        super.use();
        effect(e);
    }
}
