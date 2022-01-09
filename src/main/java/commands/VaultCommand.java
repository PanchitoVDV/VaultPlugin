package commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class VaultCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("vault.open")) {

                Inventory vault = Bukkit.createInventory(player, 9, "Your private vault");
                player.openInventory(vault);

                Material type;
                ItemStack diamond = new ItemStack(Material.DIAMOND);

                vault.setItem(4, diamond);

                vault.addItem(diamond);

                vault.clear();
                //

                ItemStack beef = new ItemStack(Material.COOKED_BEEF);
                ItemStack[] items = {diamond, beef};

                vault.setContents(items);


                player.openInventory(vault);


                player.openInventory(vault);


            }
        } else {
            System.out.printf("You have to be a player to run this command!");
        }


        return true;
    }
}
