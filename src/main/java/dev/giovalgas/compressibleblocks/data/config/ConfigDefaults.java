package dev.giovalgas.compressibleblocks.data.config;

import org.bukkit.ChatColor;

public class ConfigDefaults {

  public static final String CONSOLE_PREFIX = "[CompressibleBlocks] ";
  public static final String COMPRESSED_NAME = ChatColor.BLUE + "Compressed %material_type% block";
  public static final String[] COMPRESSED_LORE = {
          ChatColor.GRAY + "This is a compressed " + ChatColor.YELLOW + "%material_type%" + ChatColor.YELLOW + " block",
          ChatColor.GRAY + "Place this in a crafting table to get 9 " + ChatColor.YELLOW + "%material_type%" + ChatColor.GRAY + " blocks"
  };
  public static final String[] COMPRESSIBLE_BLOCKS = {"STONE","BRICKS"};

}
