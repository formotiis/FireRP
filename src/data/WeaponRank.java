package data;

import data.items.weapons.Weapon;

public enum WeaponRank {
    None, E, D, C, B, A, S, Pf;
    public int toInt(){
        if (this == WeaponRank.S)
            return 6;
        if (this == WeaponRank.A)
            return 5;
        if (this == WeaponRank.B)
            return 4;
        if (this == WeaponRank.C)
            return 3;
        if (this == WeaponRank.D)
            return 2;
        if (this == WeaponRank.E)
            return 1;
        if (this == WeaponRank.None)
            return 0;
        if (this == WeaponRank.Pf)
            return Integer.MAX_VALUE;
        return Integer.MIN_VALUE;
    }
}
