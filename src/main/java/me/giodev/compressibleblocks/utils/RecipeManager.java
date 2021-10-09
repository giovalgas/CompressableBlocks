package me.giodev.compressibleblocks.utils;

import com.cryptomorin.xseries.XMaterial;
import me.giodev.compressibleblocks.CompressibleBlocks;
import me.giodev.compressibleblocks.data.data.CompressedBlock;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import java.util.ArrayList;

public class RecipeManager {

  private ArrayList<Material> materials;
  private CompressibleBlocks plugin;


  public RecipeManager(ArrayList<Material> materials, CompressibleBlocks plugin) {
    this.plugin = plugin;
    this.materials = materials;

    loadRecipes();
  }

  public void loadRecipes() {
    for(Material material : materials) this.loadSingleRecipe(material);
  }

  private void loadSingleRecipe(Material material) {

    ItemStack finalItem = new CompressedBlock(plugin, material).getItemStack();
    ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "COMP_" + material.toString()), finalItem);

    recipe.shape("XXX", "XXX", "XXX");
    recipe.setIngredient('X', material);

    Bukkit.addRecipe(recipe);
    plugin.getLog().info("Loaded -> " + material.toString() + " Recipe");

  }

  public void reload(ArrayList<Material> newMaterials) {
    for(Material m : newMaterials) {
      if(!materials.contains(m)) {
        loadSingleRecipe(m);
        materials.add(m);
      }
    }
  }

}
