package me.giodev.compressibleblocks.listeners;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class ShapelessRecipeListener implements Listener {

  @EventHandler
  public void onShapelessRecipe(PrepareItemCraftEvent event) {
    if(!(event.getRecipe() instanceof ShapelessRecipe)) return;

    ShapelessRecipe recipe = (ShapelessRecipe) event.getRecipe();
    ItemStack recipeItem = null;

    for(ItemStack is : event.getInventory().getMatrix()) {
      if(is != null){
        recipeItem = is;
        break;
      }
    }

    if(recipe.getIngredientList().size() == 1 && new NBTItem(recipeItem).hasKey("COMPRESSED_BLOCK")) {
      event.getInventory().setResult(new ItemStack(recipeItem.getType(), 9));
    }

  }

}
