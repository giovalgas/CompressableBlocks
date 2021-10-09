package me.giodev.compressibleblocks.data.data;

import com.cryptomorin.xseries.XEnchantment;
import de.tr7zw.changeme.nbtapi.NBTItem;
import me.giodev.compressibleblocks.CompressibleBlocks;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class CompressedBlock {

  private CompressibleBlocks plugin;
  private Material mat;

  public CompressedBlock(CompressibleBlocks plugin, Material mat) {
    this.plugin = plugin;
    this.mat = mat;
  }

  public ItemStack getItemStack() {

    ItemStack compressedBlock = new ItemStack(mat);
    ItemMeta meta = compressedBlock.getItemMeta();

    //TODO -> Move formatting to config.yml
    String formattedType = WordUtils.capitalize(mat.toString()
            .toLowerCase()
            .replace("_", " ")
    );
    ArrayList<String> lore = new ArrayList<>();
    lore.add(ChatColor.GRAY + "This is a compressed " + ChatColor.YELLOW + formattedType + ChatColor.GRAY + " block");
    lore.add(ChatColor.GRAY + "Place this in a crafting table to get 9 " + ChatColor.YELLOW + formattedType + ChatColor.GRAY + " blocks");

    meta.setDisplayName(ChatColor.BLUE + "Compressed " + formattedType + " Block");
    meta.setLore(lore);
    meta.addEnchant(XEnchantment.DURABILITY.parseEnchantment(), 1, true);
    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

    compressedBlock.setItemMeta(meta);

    NBTItem nbtItem = new NBTItem(compressedBlock);
    nbtItem.setBoolean("COMPRESSED_BLOCK", true);

    return nbtItem.getItem();
  }

}
