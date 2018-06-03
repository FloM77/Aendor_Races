package AT.MSev.Races;

import AT.MSev.Mango_Core.Items.ItemInteractable;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CustomItemMenuRace extends ItemInteractable {
    Races.Race Race;
    public CustomItemMenuRace(String name, Material appearance, Races.Race race)
    {
        super(name, appearance);
        Race = race;
    }

    @Override
    public void OnInventoryClick(InventoryClickEvent e) {
        super.OnInventoryClick(e);
        if(Races.GetRace((Player)e.getWhoClicked()) != Race)
        {
            Races.SetRace((Player)e.getWhoClicked(), Race);
            e.getWhoClicked().sendMessage(ChatColor.YELLOW + "You are now a "  + Race.toString() + ".");
        }
        else
        {
            e.getWhoClicked().sendMessage(ChatColor.YELLOW + "You already are a " + Race.toString() + ".");
        }

        e.setCancelled(true);
        e.getCursor().setType(Material.AIR);
    }
}
