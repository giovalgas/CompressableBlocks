package me.giodev.compressibleblocks.listeners;

import com.cryptomorin.xseries.XMaterial;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class UncompressRecipeListener implements Listener {

  @EventHandler(priority = EventPriority.NORMAL)
  public void onUncompressRecipe(PrepareItemCraftEvent event) {
    ItemStack recipeItem = null;

    int ingredientCount = 0;

    for(ItemStack is : event.getInventory().getMatrix()) {
      if (is != null && is.getType() != XMaterial.AIR.parseMaterial()) {
        recipeItem = is;
        ingredientCount++;
      }
    }

    if(ingredientCount == 1 && new NBTItem(recipeItem).hasKey("COMPRESSED_BLOCK")) {
      event.getInventory().setResult(new ItemStack(recipeItem.getType(), 9));
    }

  }

}
