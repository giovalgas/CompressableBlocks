package me.giodev.compressibleblocks.data.language;

import com.cryptomorin.xseries.XSound;
import org.bukkit.ChatColor;

public class LanguageDefaults {

  //messages
  public static final String MESSAGE_PREFIX = ChatColor.RED + "[" + ChatColor.GOLD + "Compressible Blocks" + ChatColor.RED + "] ";
  public static final String NO_PERMISSION = MESSAGE_PREFIX + ChatColor.RED + "You don't have the permission needed to execute that command.";
  public static final String RELOADING_PLUGIN = MESSAGE_PREFIX + ChatColor.YELLOW + "Plugin reloaded successfully!";
  public static final String PAGE_ERROR = MESSAGE_PREFIX + ChatColor.RED + "There is no next/previous page.";
  public static final String OPENING_PAGE = MESSAGE_PREFIX + ChatColor.YELLOW + "Opening the compressible blocks list!";

  public static final String[] HELP = {
          "&8&m---------------------------------",
          "&e&lCompressibleBlocks",
          "&7▪ &e/cp &7- Displays this list",
          "&7▪ &e/cp list &7- Opens the compressible blocks list",
          "&8&m---------------------------------"
  };

  //sounds
  public static final XSound CLICK_SOUND = XSound.UI_BUTTON_CLICK;

}
