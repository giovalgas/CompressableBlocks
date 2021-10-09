package me.giodev.compressibleblocks.listeners;

import com.cryptomorin.xseries.XMaterial;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeListener implements Listener {

  @EventHandler
  public void onShapedRecipe(PrepareItemCraftEvent event) {

    ItemStack[] matrix = event.getInventory().getMatrix();

    for(ItemStack is : matrix) {
      if(is != null && new NBTItem(is).hasKey("COMPRESSED_BLOCK")) {
        event.getInventory().setResult(new ItemStack(XMaterial.AIR.parseMaterial()));
        break;
      }
    }

  }

}
