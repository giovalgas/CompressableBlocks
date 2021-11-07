package dev.giovalgas.compressibleblocks.listeners;

import com.cryptomorin.xseries.XMaterial;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class RecipeListener implements Listener {

  @EventHandler(priority = EventPriority.LOW)
  public void onRecipe(PrepareItemCraftEvent event) {

    ItemStack[] matrix = event.getInventory().getMatrix();

    for(ItemStack is : matrix) {
      if(is != null && is.getType() != XMaterial.AIR.parseMaterial() && new NBTItem(is).hasKey("COMPRESSED_BLOCK")) {
        event.getInventory().setResult(new ItemStack(XMaterial.AIR.parseMaterial()));
        break;
      }
    }

  }

}
