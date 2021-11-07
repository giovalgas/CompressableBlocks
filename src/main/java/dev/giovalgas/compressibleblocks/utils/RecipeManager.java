package dev.giovalgas.compressibleblocks.utils;

import dev.giovalgas.compressibleblocks.data.data.CompressedBlock;
import dev.giovalgas.compressibleblocks.CompressibleBlocks;
import dev.giovalgas.multiversion.MultiVersionRecipe;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

import java.util.ArrayList;
import java.util.Iterator;

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
    ShapedRecipe recipe = new MultiVersionRecipe(plugin, "COMP_" + material.toString(), finalItem).getShapedRecipe();
    recipe.shape("XXX", "XXX", "XXX");
    recipe.setIngredient('X', material);

    loadUncompressRecipe(material);
    Bukkit.addRecipe(recipe);
    plugin.getLog().info("Loaded -> " + material.toString() + " Recipe");

  }

  private void loadUncompressRecipe(Material material) {

    ShapelessRecipe recipe = new MultiVersionRecipe(plugin, "UNCOMP_" + material.toString(), new ItemStack(material, 9)).getShapelessRecipe();
    recipe.addIngredient(material);

    Iterator<Recipe> it = plugin.getServer().recipeIterator();

    boolean overlappingRecipes = false;

    while(it.hasNext()) {

      Recipe itRecipe = it.next();

      if(itRecipe instanceof ShapelessRecipe){

        ShapelessRecipe shapelessRecipe = (ShapelessRecipe) itRecipe;

        if(shapelessRecipe.getIngredientList().equals(recipe.getIngredientList())) {
          overlappingRecipes = true;
          break;
        }
      }
    }

    if(!overlappingRecipes){
      Bukkit.addRecipe(recipe);
    }

  }

  public void reload(ArrayList<Material> newMaterials) {
    for(Material m : newMaterials) {
      if(!materials.contains(m)) {
        loadSingleRecipe(m);
        materials.add(m);
      }
    }
  }

  public ArrayList<Material> getMaterials() {
    return materials;
  }

}
