package entities;

import data.DataCenter;
import data.Stats;
import data.WeaponRank;
import data.classes.Job;
import data.items.Item;
import data.items.ItemType;
import data.items.consumables.Consumable;
import data.items.weapons.DamageType;
import data.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Entity {

    private HashMap<Stats, Integer> stats;
    private HashMap<Stats, Integer> growth;
    private HashMap<Stats, Integer> caps;

    private Weapon equiped;
    private Item selected;
    private ArrayList<Attribute> attributes;
    private HashMap<ItemType, Integer> mastery;

    private int currentHP;

    private Job job;
    private int level;
    private int exp;

    protected int entityID;

    private ArrayList<Integer> freeSlots;

    private Item[] items;
    private int itemAmount;
    protected Entity(HashMap<Stats, Integer> stats, HashMap<Stats, Integer> growth, HashMap<Stats, Integer> caps,
                     Job job,int level, int eid, Attribute... attributes){
        this.stats = stats;
        this.growth = growth;
        this.caps = caps;
        this.job = job;
        entityID = eid;
        this.attributes = new ArrayList<>(Arrays.asList(attributes));
        this.level = level;
        this.itemAmount = 0;
        this.exp = 0;
        this.items = new Item[5];
        initFreeSlots();
        this.currentHP = stats.get(Stats.Hp);
    }

    protected void hpReset(){
        this.currentHP = stats.get(Stats.Hp);
    }

    public void setCurrentHP(int v){
        this.currentHP = v;
    }

    public void printStats(){
        System.out.println(this+" lv"+level+":");
        System.out.println("Hp :"+stats.get(Stats.Hp)+" "+growth.get(Stats.Hp)+"%");
        System.out.println("Atk :"+stats.get(Stats.Atk)+" "+growth.get(Stats.Atk)+"%");
        System.out.println("Tec :"+stats.get(Stats.Tec)+" "+growth.get(Stats.Tec)+"%");
        System.out.println("Vit :"+stats.get(Stats.Vit)+" "+growth.get(Stats.Vit)+"%");
        System.out.println("Cha :"+stats.get(Stats.Cha)+" "+growth.get(Stats.Cha)+"%");
        System.out.println("Def :"+stats.get(Stats.Def)+" "+growth.get(Stats.Def)+"%");
        System.out.println("Res :"+stats.get(Stats.Res)+" "+growth.get(Stats.Res)+"%");
        System.out.println("Mvt :"+stats.get(Stats.Mvt));
    }

    public String getToolTipString(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>"+this+" lv"+level+":<br>");
        if(hasWeapon()){
            sb.append("<b>Equipped </b>:"+this.equiped+"<br>");
        }
        sb.append("<b>Hp </b>:"+getCurrentHP()+"/"+stats.get(Stats.Hp)+"<br>");
        sb.append("<b>Atk </b>:"+stats.get(Stats.Atk)+"<br>");
        sb.append("<b>Tec </b>:"+stats.get(Stats.Tec)+"<br>");
        sb.append("<b>Vit </b>:"+stats.get(Stats.Vit)+"<br>");
        sb.append("<b>Cha</b> :"+stats.get(Stats.Cha)+"<br>");
        sb.append("<b>Def </b>:"+stats.get(Stats.Def)+"<br>");
        sb.append("<b>Res </b>:"+stats.get(Stats.Res)+"<br>");
        sb.append("<b>Mvt </b>:"+stats.get(Stats.Mvt)+"</html>");
        return sb.toString();
    }

    public void printLevelUp(HashMap<Stats, Integer> levels){
        levels.forEach((k, v)-> {
            if(v!=0) {
                System.out.println(k.name()+" :"+stats.get(k)+" +"+v+" "+growth.get(k)+"%");
            }else {
                System.out.println(k.name()+" :"+stats.get(k)+" "+growth.get(k)+"%");
            }
        });
        System.out.println("Mvt :"+stats.get(Stats.Mvt));
    }

    public HashMap<Stats, Integer> levelUp(){
        HashMap<Stats, Integer> hm = new HashMap<>();
        Random r = new Random();
        growth.forEach((k, v)-> hm.put(k, levelCheck(r.nextInt(100), v)));
        return hm;
    }

    private int levelCheck(int random, int growth){
        int i =0;
        int x = growth;
        while (x> 100){
            x = x-100;
            i++;
        }
        if (random<growth){
            return i+1;
        }
        return i;
    }

    public void setMastery(ItemType type, int value) {
        this.mastery.put(type, value);
    }

    public WeaponRank getWeaponRank(ItemType t){
        Integer wexp = mastery.get(t);
        if (wexp != null){
            if(wexp < 31){
                return WeaponRank.E;
            } else if (wexp < 71){
                return WeaponRank.D;
            } else if (wexp < 121){
                return WeaponRank.C;
            } else if (wexp < 181){
                return WeaponRank.B;
            } else if (wexp < 251) {
                return WeaponRank.A;
            } else if (wexp>= 251){
                return WeaponRank.S;
            }
        }
        return WeaponRank.None;
    }

    public boolean canUse(Weapon w){
        return w.getRank().toInt()<=getWeaponRank(w.getType()).toInt();
    }

    public HashMap<Stats, Integer> concreteLevelUp(){
        HashMap<Stats, Integer> hm = levelUp();
        hm.forEach((k, v)-> {if (!(stats.get(k)>=caps.get(k))){
            stats.put(k, stats.get(k)+v); }
        });
        level++;
        return hm;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }

    public HashMap<Stats, Integer> getGrowth() {
        return growth;
    }

    public Job getJob() {
        return job;
    }

    public int getEntityID() {
        return entityID;
    }

    public int getLevel() {
        return level;
    }

    private void initFreeSlots(){
        this.freeSlots = new ArrayList<>(5);
        for (int i=0;i<5;i++){
            freeSlots.add(i);
        }
    }

    public void addItem(Item i){
        if (!freeSlots.isEmpty()){
            this.items[freeSlots.get(0)] = i;
            if((equiped == null)&&(i.isWeapon())){
                this.equiped = (Weapon) i;
            }
            this.freeSlots.remove(freeSlots.get(0));
        } else {
            System.out.println("Maximal amount of items reached");
        }
    }

    public void removeItem(int slot){
        if (this.equiped==this.items[slot]){
            this.equiped = null;
        }
        this.items[slot] = null;
        this.freeSlots.add(slot);
    }

    public void equip(int slot){
        if (items[slot].isWeapon()){
            this.equiped = (Weapon)items[slot];
        } else {
            this.selected = items[slot];
        }
    }

    public void gainExp(int exp, int mastery){
        int sum = this.exp+exp;
        if (sum >100){
            this.exp = sum- 100;
            concreteLevelUp();
        }

        if (mastery>0&&(equiped!=null)){
            sum = getWeaponRank(equiped.getType()).toInt();
            this.mastery.put(equiped.getType(),this.mastery.get(equiped.getType())+mastery);
            if (sum < getWeaponRank(equiped.getType()).toInt()){
                rankUp();
            }
        }

    }

    public boolean canAttackAtRange(int i){
        if (hasWeapon()) {
            return equiped.getMinRange() <= i && i <= equiped.getRange();
        }
        return false;
    }

    public void rankUp(){

    }

    //TODO:Fixme
    public void trade(int slot, Item j){
        Item tmp;
        tmp = items[slot];
        items[slot] = j ;
        j = tmp;
    }


    public int getMaxHP() {
        return stats.get(Stats.Hp);
    }

    public int getAtk() {
        return stats.get(Stats.Atk);
    }
    public int getFullAtk(){
        if (this.equiped!=null&&equiped.getBonus().get(Stats.Atk)!=null){
            return getAtk()+equiped.getBonus().get(Stats.Atk);
        }
        return getAtk();
    }

    public int getTec() {
        return stats.get(Stats.Tec);
    }
    public int getFullTec(){
        if (this.equiped!=null&&equiped.getBonus().get(Stats.Tec)!=null){
            return getTec()+equiped.getBonus().get(Stats.Tec);
        }
        return getTec();
    }

    public int getVit() {
        return stats.get(Stats.Vit);
    }
    public int getFullVit(){
        if (this.equiped!=null&&equiped.getBonus().get(Stats.Vit)!=null){
            return getVit()+equiped.getBonus().get(Stats.Vit);
        }
        return getVit();
    }

    public int getCha() {
        return stats.get(Stats.Cha);
    }
    public int getFullCha(){
        if (this.equiped!=null&&equiped.getBonus().get(Stats.Cha)!=null){
            return getCha()+equiped.getBonus().get(Stats.Cha);
        }
        return getCha();
    }

    public int getDef() {
        return stats.get(Stats.Def);
    }
    public int getFullDef(){
        if (this.equiped!=null&&equiped.getBonus().get(Stats.Def)!=null){
            return getDef()+equiped.getBonus().get(Stats.Def);
        }
        return getDef();
    }

    public int getRes() {
        return stats.get(Stats.Res);
    }

    public int getFullRes(){
        if (this.equiped!=null&&equiped.getBonus().get(Stats.Res)!=null){
            return getRes()+equiped.getBonus().get(Stats.Res);
        }
        return getRes();
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public DamageType getDamageType(){
        if(equiped==null)
            return null;
        return equiped.getDamageType();
    }

    public ItemType getWeaponType(){
        if(equiped!=null){
            return equiped.getType();
        }
        return null;
    }

    public Weapon getEquiped() {
        return equiped;
    }

    public boolean hasWeapon(){
        return equiped != null;
    }

    public int effectiveness(Weapon w){
        for(Attribute a:w.getAttributes()){
            if (attributes.contains(a)){
                return 3;
            }
            if (w.getAttributes().contains(Attribute.Legendary)){
                return 2;
            }
        }
        return 1;
    }

    public int critBonus(){
        return 0;
    }

    public Item[] getItems() {
        return items;
    }

    public boolean levelMax(){
        return level==job.getMaxLevel();
    }

    public int getExp() {
        return exp;
    }

    public void receiveDamages(int damages){
        this.currentHP = Integer.max(0, currentHP -damages);
    }

    public boolean isDead(){
        return currentHP <=0;
    }

    public boolean isPlayer(){
        return false;
    }

    public void gainHP(int gain){
        this.currentHP+=gain;
        if (currentHP>getMaxHP()){
            currentHP = getMaxHP();
        }
    }

    public void gain(Stats s, int value){
        this.stats.put(s, this.stats.get(s)+value);
        if (this.stats.get(s)>this.caps.get(s)){
            this.stats.put(s, this.caps.get(s));
        }
    }

    public void useSelected(){
        if(!selected.isWeapon())
            ((Consumable)this.selected).use(this);
    }

    public void setStat(Stats s, int value){
        this.stats.put(s, value);
        gain(s,0);
        if (s.equals(Stats.Hp)){
            gainHP(0);
        }
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Entity";
    }


    public int getEquipedSlot(){
        for (int i  = 0; i<5;i++){
            if (equiped.equals(items[i])){
                return i;
            }
        }
        return -1;
    }


}
