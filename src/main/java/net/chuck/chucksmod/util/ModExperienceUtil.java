package net.chuck.chucksmod.util;

public class ModExperienceUtil {
    public static int convertLevelToXp(int level){
        int xp = 0;
        while (level > 0){
            if(level > 30) xp += 112 +(level - 30)*9;
            else if (level > 15) {
                xp += 37+(level-15)*5;
            } else {
                xp += 7+level*2;
            }
            level--;
        }
        return xp;
    }
}
