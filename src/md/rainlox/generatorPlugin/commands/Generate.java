package md.rainlox.generatorPlugin.commands;

import md.rainlox.generatorPlugin.Main;
import md.rainlox.generatorPlugin.utils.Tools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Random;
import java.util.logging.Level;

public class Generate implements CommandExecutor {

    /*
    * Уголь: от 52 до 5
    * Железо: от 54 до 5
    * Лазурит: от 17 до 13
    * Золото: от 29 до 5
    * Редстоун: от 12 до 5
    * Изумруды от 29 до 5
    * */

    /*
    * Крайние координаты
    * Y = 40 - 5
    * X = 30719
    * -X =
    * Z = 15871
    * -Z =
    * */

    /* Levels
     * 1 - Iron, coal
     * 2 - Iron, coal, gold
     * 3 - Iron, coal, lapis
     * 4 - Iron, coal, lapis, redstone, emeralds
     * */

//    56 + 12 + 6 + 1 + 1 + 2 + 1 = 79
//    LEVEL 1 - 74
//    LEVEL 2 - 75
//    LEVEL 3 -
    private final Material[] LEVEL1 = new Material[] {
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.IRON_ORE, Material.IRON_ORE, Material.IRON_ORE, Material.IRON_ORE,
            Material.IRON_ORE, Material.IRON_ORE
    };

    private final Material[] LEVEL2 = new Material[] {
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.IRON_ORE, Material.IRON_ORE, Material.IRON_ORE, Material.IRON_ORE,
            Material.IRON_ORE, Material.IRON_ORE,
            Material.GOLD_ORE
    };

    private final Material[] LEVEL3 = new Material[] {
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.IRON_ORE, Material.IRON_ORE, Material.IRON_ORE, Material.IRON_ORE,
            Material.IRON_ORE, Material.IRON_ORE,
            Material.LAPIS_ORE
    };

    private final Material[] LEVEL4 = new Material[] {
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.STONE, Material.STONE, Material.STONE, Material.STONE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE, Material.COAL_ORE,
            Material.IRON_ORE, Material.IRON_ORE, Material.IRON_ORE, Material.IRON_ORE,
            Material.IRON_ORE, Material.IRON_ORE,
            Material.LAPIS_ORE,
            Material.REDSTONE_ORE, Material.REDSTONE_ORE,
            Material.EMERALD_ORE
    };

    private final double SEA_Y = 40;
    private final double MIN_Y = 5;
    private final double MAX_X = 30719;
    private final double MIN_X = 0;
    private final double MAX_Z = 15817;
    private final double MIN_Z = 0;

    private final Main main;
    private final Tools tools;

    public Generate(Main main) {
        this.main = main;
        tools = new Tools(main);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!sender.hasPermission("tech.admin")) {
            sender.sendMessage(ChatColor.RED + "Нет разрешения тех админа");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Вы не ввели координаты");
            return false;
        }
        if (args.length < 4) return false;

        double fTargetX;
        double sTargetX;
        double fTargetZ;
        double sTargetZ;

//        Парсинг списка аргументов в переменные
        try {
            fTargetX = Double.parseDouble(args[0]);
            sTargetX = Double.parseDouble(args[1]);
            fTargetZ = Double.parseDouble(args[2]);
            sTargetZ = Double.parseDouble(args[3]);

//            Проверка на отрицательное число
            if (fTargetX < 0 || sTargetX < 0 || fTargetZ < 0 || sTargetZ < 0) {
                sender.sendMessage(ChatColor.RED + "Координаты не могут быть отрицательными");
                return true;
            }


            //        Проверка координат X
            if (fTargetX > MAX_X) {
                sender.sendMessage(ChatColor.RED + "Координата больше максимальной, MAX_X = " + MAX_X);
                return true;
            }
            if (fTargetX < MIN_X) {
                sender.sendMessage(ChatColor.RED + "Координата меньше минимальной, MIN_X = " + MIN_X);
                return true;
            }
            if (sTargetX > MAX_X) {
                sender.sendMessage(ChatColor.RED + "Координата больше максимальной, MAX_X = " + MAX_X);
                return true;
            }
            if (sTargetX < MIN_X) {
                sender.sendMessage(ChatColor.RED + "Координата меньше минимальной, MIN_X = " + MIN_X);
                return true;
            }

//        Проверка координат Z
            if (fTargetZ > MAX_X) {
                sender.sendMessage(ChatColor.RED + "Координата больше максимальной, MAX_Z = " + MAX_Z);
                return true;
            }
            if (fTargetZ < MIN_X) {
                sender.sendMessage(ChatColor.RED + "Координата меньше минимальной, MIN_Z = " + MIN_Z);
                return true;
            }
            if (sTargetZ > MAX_X) {
                sender.sendMessage(ChatColor.RED + "Координата больше максимальной, MAX_Z = " + MAX_Z);
                return true;
            }
            if (sTargetZ < MIN_X) {
                sender.sendMessage(ChatColor.RED + "Координата меньше минимальной, MIN_Z = " + MIN_Z);
                return true;
            }
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "Неверные координаты, возможно вы использовали не цифры");
            return false;
        }

        if (fTargetX == 0.0 && sTargetX == 0.0 && fTargetZ == 0.0 && sTargetZ == 0.0) {
            sender.sendMessage(ChatColor.RED + "Вы не ввели координаты");
            return false;
        }

        System.out.println(fTargetX + " " + sTargetX + " " + fTargetZ + " " + sTargetZ);

        Random rnd = new Random();

        for (double y = SEA_Y; y > MIN_Y; y--) {
            for (double x = fTargetX; x < sTargetX; x=x+rnd.nextInt(3)) {
                for (double z = fTargetZ; z < sTargetZ; z=z+rnd.nextInt(3)) {
                    Material block = new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlock().getType();

                    if (block == Material.SAND
                            ||
                            block == Material.DIRT
                            ||
                            block == Material.GRASS_BLOCK
                            ||
                            block == Material.SANDSTONE
                            ||
                            block == Material.AIR
                            ||
                            block == Material.WATER
                            ||
                            block == Material.END_PORTAL_FRAME
                            ||
                            block == Material.END_PORTAL
                            ||
                            block == Material.LAVA
                            ||
                            block == Material.CHISELED_SANDSTONE
                            ||
                            block == Material.CUT_SANDSTONE
                            ||
                            block == Material.ICE
                            ||
                            block == Material.BLUE_ICE
                            ||
                            block == Material.PACKED_ICE
                            ||
                            block == Material.FROSTED_ICE
                    ) {
                        System.out.println("Founded wrong block: " + new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlock().getType() + " On location: " + "X = " + new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlockX() + " Y = " + new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlockY() + " Z = " + new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlockZ());
                        z = z + 20;
                        continue;
                    }

                    if (tools.isSuitableForLevel1(y)) {
                        int rndNum = rnd.nextInt(LEVEL1.length);
                        new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlock().setType(LEVEL1[rndNum]);
                        tools.displayChangedBlock(x, y, z, LEVEL1[rndNum], block);
                    } else if (tools.isSuitableForLevel2(y)) {
                        int rndNum = rnd.nextInt(LEVEL2.length);
                        new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlock().setType(LEVEL2[rndNum]);
                        tools.displayChangedBlock(x, y, z, LEVEL2[rndNum], block);
                    } else if (tools.isSuitableForLevel3(y)) {
                        int rndNum = rnd.nextInt(LEVEL3.length);
                        new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlock().setType(LEVEL3[rndNum]);
                        tools.displayChangedBlock(x, y, z, LEVEL3[rndNum], block);
                    } else if (tools.isSuitableForLevel4(y)) {
                        int rndNum = rnd.nextInt(LEVEL4.length);
                        new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlock().setType(LEVEL4[rndNum]);
                        tools.displayChangedBlock(x, y, z, LEVEL4[rndNum], block);
                    } else {
                        main.log.log(Level.SEVERE, "This couldn't happened");
                    }
                }
            }
        }
        return true;
    }
}
