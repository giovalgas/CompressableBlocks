package me.giodev.compressibleblocks.listeners;

import me.giodev.compressibleblocks.CompressibleBlocks;
import me.giodev.compressibleblocks.data.gui.BaseGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class GUIClickListener implements Listener {

  private CompressibleBlocks plugin;

  public GUIClickListener(CompressibleBlocks plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onClick(InventoryClickEvent event) {

    InventoryHolder holder = event.getInventory().getHolder();

    if(holder instanceof BaseGUI) {

      event.setCancelled(true);
      plugin.getLanguageManager().getClickSound().play((Player) event.getWhoClicked());

      if(event.getCurrentItem() == null) return;

      BaseGUI gui = (BaseGUI) holder;

      gui.handleClick(event);

    }

  }


}
