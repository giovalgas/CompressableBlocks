package me.giodev.compressibleblocks.listeners;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;

public class SmeltListener implements Listener {

  @EventHandler
  public void onSmeltListener(FurnaceSmeltEvent event) {

    if(event.getSource() == null) return;

    NBTItem nbtItem = new NBTItem(event.getSource());

    if(nbtItem.hasKey("COMPRESSED_BLOCK")) {
      event.setResult(new ItemStack(event.getResult().getType(), 9));
    }

  }

}
