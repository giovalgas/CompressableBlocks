package dev.giovalgas.compressibleblocks.data.data;

import com.cryptomorin.xseries.XEnchantment;
import de.tr7zw.changeme.nbtapi.NBTItem;
import dev.giovalgas.compressibleblocks.CompressibleBlocks;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.stream.Collectors;

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

    String formattedType = WordUtils.capitalize(mat.toString()
            .toLowerCase()
            .replace("_", " ")
    );

    meta.setDisplayName(plugin.getConfigManager().getCompressedName().replace("%material_type%", formattedType));
    meta.setLore(plugin.getConfigManager().getCompressedLore().stream().map(s -> s.replace("%material_type%", formattedType)).collect(Collectors.toList()));
    meta.addEnchant(XEnchantment.DURABILITY.parseEnchantment(), 1, true);
    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

    compressedBlock.setItemMeta(meta);

    NBTItem nbtItem = new NBTItem(compressedBlock);
    nbtItem.setBoolean("COMPRESSED_BLOCK", true);

    return nbtItem.getItem();
  }

}
