package md.rainlox.generatorPlugin;

import md.rainlox.generatorPlugin.commands.Eggs;
import md.rainlox.generatorPlugin.commands.Generate;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public final Logger log = Logger.getLogger("ResourcesGenerator");
    public final FileConfiguration conf = getConfig();

    private final CommandExecutor generate = new Generate(this);
    private final CommandExecutor eggs = new Eggs(this);

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("generate")).setExecutor(generate);
        Objects.requireNonNull(getCommand("eggs")).setExecutor(eggs);

        log.info(conf.getString("texts.onEnable"));
    }

    @Override
    public void onDisable() {
        log.info(conf.getString("texts.onDisable"));
    }


}
