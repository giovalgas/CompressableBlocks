package dev.giovalgas.multiversion;

import com.cryptomorin.xseries.XMaterial;
import dev.giovalgas.compressibleblocks.CompressibleBlocks;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class MultiVersionRecipe {

  private CompressibleBlocks plugin;
  private String key;
  private ItemStack finalItem;

  public MultiVersionRecipe(CompressibleBlocks plugin, String key, ItemStack finalItem) {
    this.finalItem = finalItem;
    this.plugin = plugin;
    this.key = key;
  }

  public ShapedRecipe getShapedRecipe() {
    return XMaterial.supports(12) ? new ShapedRecipe(new NamespacedKey(plugin, key), finalItem) : new ShapedRecipe(finalItem);
  }

  public ShapelessRecipe getShapelessRecipe() {
    return XMaterial.supports(12) ? new ShapelessRecipe(new NamespacedKey(plugin, key), finalItem) : new ShapelessRecipe(finalItem);
  }

}
