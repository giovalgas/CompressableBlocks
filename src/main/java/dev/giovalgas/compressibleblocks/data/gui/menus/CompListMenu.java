package dev.giovalgas.compressibleblocks.data.gui.menus;

import com.cryptomorin.xseries.XMaterial;
import de.tr7zw.changeme.nbtapi.NBTItem;
import dev.giovalgas.compressibleblocks.data.data.CompressedBlock;
import dev.giovalgas.compressibleblocks.CompressibleBlocks;
import dev.giovalgas.compressibleblocks.data.gui.GUIButton;
import dev.giovalgas.compressibleblocks.data.gui.PaginatedGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CompListMenu extends PaginatedGUI {

  public CompListMenu(Player player, CompressibleBlocks plugin) {
    super(player, plugin);
  }


  @Override
  public void handleClick(InventoryClickEvent event) {

    NBTItem nbtItem = new NBTItem(event.getCurrentItem());

    if(nbtItem.hasKey(GUIButton.IDENTIFIER_KEY)) {
      switch(nbtItem.getString(GUIButton.IDENTIFIER_KEY)) {
        case "NEXT_PAGE":
          setPage(page + 1);
          break;
        case "PREVIOUS_PAGE":
          setPage(page - 1);
          break;
      }
    }
  }

  @Override
  public void setupInventoryItems() {

    ItemStack next = new ItemStack(XMaterial.STONE_BUTTON.parseMaterial()); {
      ItemMeta nextMeta = next.getItemMeta();
      nextMeta.setDisplayName(ChatColor.BLUE + "Next page");
      next.setItemMeta(nextMeta);
    }

    ItemStack previous = new ItemStack(XMaterial.STONE_BUTTON.parseMaterial()); {
      ItemMeta previousMeta = previous.getItemMeta();
      previousMeta.setDisplayName(ChatColor.BLUE + "Previous page");
      previous.setItemMeta(previousMeta);
    }

    inventory.setItem(30, new GUIButton(previous, "PREVIOUS_PAGE").getItemStack());
    inventory.setItem(32, new GUIButton(next, "NEXT_PAGE").getItemStack());
    fillInventory(27, getSize());

  }

  @Override
  public @NotNull String getName() {
    return "Compressible Blocks";
  }

  @Override
  public int getSize() {
    return 36;
  }

  @Override
  public @NotNull ArrayList<ItemStack> getPageItems() {

    ArrayList<ItemStack> items = new ArrayList<>();

    for(Material m : plugin.getRecipeManager().getMaterials()) {
      items.add(new CompressedBlock(plugin, m).getItemStack());
    }

    return items;

  }

  @Override
  public int getPageSize() {
    return 27 ;
  }
}
