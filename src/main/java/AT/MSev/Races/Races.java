package AT.MSev.Races;

import org.apache.commons.lang.enums.Enum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class Races extends JavaPlugin {
    public static NamespacedKey key;
    public static Races config;
    @Override
    public void onEnable() {
        key = new NamespacedKey(this, this.getDescription().getName());
        config = this;

        this.getCommand("Races").setExecutor(new CommandOpenMenu());
        getServer().getPluginManager().registerEvents(new Handler(), this);
    }
    @Override
    public void onDisable() {

    }
    public enum Race { Human, Elf, Orc, NoRace }
    public static Race GetRace(Player player)
    {
        if(!config.getConfig().contains("race." + player.getUniqueId().toString())) return Race.NoRace;

        return Race.valueOf((String)(config.getConfig().get("race." + player.getUniqueId().toString())));
    }

    public static void SetRace(Player player, Race race)
    {
        UUID id = player.getUniqueId();
        config.getConfig().set("race." + id.toString(), race.toString());
        config.saveConfig();
    }
}
