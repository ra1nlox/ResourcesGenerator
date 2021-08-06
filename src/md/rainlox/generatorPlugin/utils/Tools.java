package md.rainlox.generatorPlugin.utils;

import md.rainlox.generatorPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class Tools {

//    Let's make some constants
//    Нужно ли использовать для таких маленьких значений byte?
//    Max - 40, Min - 5

//    Gap - 10 blocks
    private final int LEVEL_1_MAX = 40;
    private final int LEVEL_1_MIN = 30;

//    Gap - 4 blocks
    private final int LEVEL_2_MAX = 29;
    private final int LEVEL_2_MIN = 25;

//    Gap - 14 blocks
    private final int LEVEL_3_MAX = 24;
    private final int LEVEL_3_MIN = 10;

//    Gap - 5 blocks
    private final int LEVEL_4_MAX = 9;
    private final int LEVEL_4_MIN = 4;

    private final Main main;

    public Tools(Main plugin) {
        main = plugin;
    }

    public boolean isSuitableForLevel1(double y) {
        return y <= LEVEL_1_MAX & y >= LEVEL_1_MIN;
    }

    public boolean isSuitableForLevel2(double y) {
        return y <= LEVEL_2_MAX & y >= LEVEL_2_MIN;
    }

    public boolean isSuitableForLevel3(double y) {
        return y <= LEVEL_3_MAX & y >= LEVEL_3_MIN;
    }

    public boolean isSuitableForLevel4(double y) {
        return y <= LEVEL_4_MAX & y >= LEVEL_4_MIN;
    }

    public void displayChangedBlock(double x, double y, double z, Material ore, Material block) {
        main.log.info(ore +
                " X = " + new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlockX() +
                " Y = " + new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlockY() +
                " Z = " + new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlockZ() +
                " Prev: " + block);
    }
}
