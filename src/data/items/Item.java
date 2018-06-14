package data.items;

public abstract class Item {

    int durability;
    int usesLeft;
    ItemType type;
    int worth;

    boolean infinite;
    boolean priceless;

    public Item(int durability, ItemType type, int worth, boolean infinite, boolean priceless) {
        this.durability = durability;
        this.usesLeft =durability;
        this.type = type;
        this.worth = worth;
        this.infinite = infinite;
        this.priceless = priceless;
    }

    public boolean isInfinite() {
        return infinite;
    }

    public boolean isPriceless() {
        return priceless;
    }

    public void use(){
        if (!isInfinite())
            usesLeft -=1;
        if (usesLeft == 0){
            //TODO:Weapon Broke
        }
    }

    public ItemType getType() {
        return type;
    }

    public boolean hasUsesLeft(){
        return usesLeft>0;
    }

    public abstract boolean isWeapon();

    protected abstract String name();

    @Override
    public String toString() {
        if (isInfinite())
            return name()+" -/-";
        return name()+" "+usesLeft+"/"+durability;
    }
}
