package data.maps;

import java.awt.*;

public enum Square {
    Default, Colums, Trees, Fort, Wall, Mountain, Blocked,
    allySpawn, enemySpawn;

    public int toInt(){
        if (this ==Default){
            return 0;
        } else if (this == Colums){
            return 1;
        } else if (this == Trees){
            return 2;
        } else if (this == Fort){
            return 3;
        } else if (this == Wall){
            return 4;
        } else if (this == Mountain){
            return 5;
        } else if (this == Blocked){
            return 6;
        } else if (this == allySpawn){
            return 7;
        } else if (this == enemySpawn){
            return 8;
        } else {
            return 9;
        }
    }

    public Color toColor(){
        if (this ==Default){
            return Color.lightGray;
        } else if (this == Colums){
            return Color.darkGray;
        } else if (this == Trees){
            return new Color(5, 70, 50);
        } else if (this == Fort){
            return new Color(126, 126, 156);
        } else if (this == Wall){
            return Color.magenta;
        } else if (this == Mountain){
            return new Color(139,69,19);
        } else if (this == Blocked){
            return Color.black;
        } else if (this == allySpawn){
            return Color.cyan;
        } else if (this == enemySpawn){
            return Color.red;
        } else {
            return Color.magenta;
        }
    }

    public static Square fromInt(int i){
        if (i == 0){
            return Default;
        } else if (i == 1){
            return Colums;
        }else if (i == 2){
            return Trees;
        }else if (i == 3){
            return Fort;
        }else if (i == 4){
            return Wall;
        }else if (i == 5){
            return Mountain;
        }else if (i == 6){
            return Blocked;
        }else if (i == 7){
            return allySpawn;
        }else if (i == 8){
            return enemySpawn;
        }else {
            return Blocked;
        }
    }

}
