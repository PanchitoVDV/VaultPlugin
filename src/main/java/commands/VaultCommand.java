package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class VaultCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            //Creating inventories. 1: Name of player inventory is linked to 2: How many slots in the inventory 3: Title of inventory
            Inventory vault = Bukkit.createInventory(player, 9, "Your Vault");

            //Put items in the inventory https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html
            ItemStack item1 = new ItemStack(Material.COOKED_BEEF, 16); //16 Beef
            vault.setItem(3, item1); //Puts the item in a specific item slot
            vault.addItem(item1); //Adds the item to the next available spot randomly
            vault.clear(); //Empties the inventory

            //A way to store multiple items
            ItemStack item2 = new ItemStack(Material.ACACIA_FENCE);

            //More on items
            item2.addUnsafeEnchantment(Enchantment.DURABILITY, 100); // Add enchantments
            ItemMeta meta = item2.getItemMeta(); //get the metadata of the item.
            meta.setDisplayName(ChatColor.AQUA + "Item name");
            ArrayList<String> lore = new ArrayList<>(); //Item lore: the stuff showed under the item title
            lore.add(ChatColor.GOLD + "some lore");
            lore.add(ChatColor.DARK_PURPLE + "some more lore heehehehe");
            meta.setLore(lore); //Add the lore to the item
            item2.setItemMeta(meta); //set all the metadata for the item


            ItemStack[] items = {item1, item2};
            vault.setContents(items); //Puts the item array into the inventory, replaces everything else
            //

            //You can get the contents of the inventory and save it
            ItemStack[] items_from_inventory = vault.getContents();

            player.openInventory(vault);
        }

        return true;
    }

}