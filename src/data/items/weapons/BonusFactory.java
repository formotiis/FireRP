package data.items.weapons;

import data.Stats;

import java.util.HashMap;

public class BonusFactory {

    private static BonusFactory instance;

    public static BonusFactory getInstance(){
        if (instance==null) {
            instance = new BonusFactory();
        }
        return instance;
    }

    public HashMap<Stats, Integer> getDragonstone() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Atk, 12);
        hm.put(Stats.Tec, 12);
        hm.put(Stats.Def, 15);
        hm.put(Stats.Res, 20);
        return hm;
    }

    public HashMap<Stats, Integer> getHeavenly() {
        HashMap<Stats, Integer> hm = new HashMap<>();
        hm.put(Stats.Atk, 20);
        hm.put(Stats.Tec, 20);
        hm.put(Stats.Vit, 20);
        hm.put(Stats.Cha, 20);
        hm.put(Stats.Def, 20);
        hm.put(Stats.Res, 20);
        return hm;
    }
}
