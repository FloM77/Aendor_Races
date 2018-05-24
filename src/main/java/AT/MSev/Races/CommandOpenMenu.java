package AT.MSev.Races;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class CommandOpenMenu implements CommandExecutor {
    static Inventory RaceMenu = Bukkit.createInventory(null, 54, "Race Menu");

    static{
        RaceMenu.setItem(10, new CustomItemMenuRace("MenuH", Material.ANVIL, Races.Race.Human) {
            {
                Rename("Human race");
                SetLore(new ArrayList<String>() {{add("Join the human race.");}});
            }
        }.Physical);


        RaceMenu.setItem(13, new CustomItemMenuRace("MenuE", Material.BOW, Races.Race.Elf) {
            {
                Rename("Elven race");
                SetLore(new ArrayList<String>() {{add("Join the elven race.");}});
            }
        }.Physical);


        RaceMenu.setItem(16, new CustomItemMenuRace("MenuO", Material.ROTTEN_FLESH, Races.Race.Orc) {
            {
                Rename("Orc race");
                SetLore(new ArrayList<String>() {{add("Join the orc race.");}});
            }
        }.Physical);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ((Player)commandSender).openInventory(RaceMenu);
        return true;
    }
}
