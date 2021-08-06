package md.rainlox.generatorPlugin.commands;

import md.rainlox.generatorPlugin.Main;
import md.rainlox.generatorPlugin.utils.Tools;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Eggs implements CommandExecutor {

    private final Main main;

    private final Tools tools;

    public Eggs(Main main) {
        this.main = main;
        tools = new Tools(main);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("tech.admin")) return true;
        if (args.length == 0) return false;
        if (args[0].equals("потоп")) {
            NoahFlood();
            return true;
        }
        if (args.length > 1) {
            sender.sendMessage("Да падажжи, не реализованно");
        }
        return true;
    }

    private void NoahFlood() {
        final double MIN_Y = 40;
        final double MAX_Y = 100;
        final double MAX_X = 30719;
        final double MIN_X = 0;
        final double MAX_Z = 15817;
        final double MIN_Z = 0;

        for (double y = MIN_Y; y < MAX_Y; y++) {
            for (double x = MIN_X; x < MAX_X; x++) {
                for (double z = MIN_Z; z < MAX_Z; z++) {
                    Block block = new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlock();
                    Material blockType = new Location(Bukkit.getServer().getWorld("world"), x, y, z).getBlock().getType();
                    if (blockType == Material.AIR) {
                        block.setType(Material.WATER);
                        tools.displayChangedBlock(x, y, z, Material.WATER, blockType);
                    }
                }
            }
        }
    }
}
