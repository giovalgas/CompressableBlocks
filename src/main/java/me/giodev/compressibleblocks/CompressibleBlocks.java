package me.giodev.compressibleblocks;

import com.cryptomorin.xseries.XMaterial;
import de.tr7zw.changeme.nbtapi.NBTItem;
import me.giodev.compressibleblocks.commands.BaseCommand;
import me.giodev.compressibleblocks.commands.compcommand.CompCommand;
import me.giodev.compressibleblocks.data.config.ConfigManager;
import me.giodev.compressibleblocks.data.language.LanguageManager;
import me.giodev.compressibleblocks.listeners.GUIClickListener;
import me.giodev.compressibleblocks.listeners.RecipeListener;
import me.giodev.compressibleblocks.listeners.ShapelessRecipeListener;
import me.giodev.compressibleblocks.listeners.SmeltListener;
import me.giodev.compressibleblocks.utils.LoggerUtil;
import me.giodev.compressibleblocks.utils.RecipeManager;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Iterator;


public final class CompressibleBlocks extends JavaPlugin {

  private ConfigManager configManager;
  private LanguageManager languageManager;
  private LoggerUtil log;
  private RecipeManager recipeManager;

  @Override
  public void onEnable(){
    //Load config, language & logger
    loadConfig();
    loadLang();
    log = new LoggerUtil(this);

    //Commands & Events
    loadCommands();
    loadEvents();

    this.recipeManager = new RecipeManager(configManager.getCompressibleBlocks(), this);

    log.info("Plugin fully started!");
  }

  @Override
  public void onDisable() {
    Iterator<Recipe> it = this.getServer().recipeIterator();

    while(it.hasNext()) {
      Recipe next = it.next();

      if(next.getResult().getType() != XMaterial.AIR.parseMaterial()) {
        NBTItem nbtItem = new NBTItem(next.getResult());
        if (nbtItem.hasKey("COMPRESSED_BLOCK")) {
          it.remove();
          log.info("Removed recipe for " + next.getResult().getType().toString());
        }
        ;
      }
    }

  }

  private void loadEvents() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new GUIClickListener(this), this);
    pm.registerEvents(new RecipeListener(), this);
    pm.registerEvents(new ShapelessRecipeListener(), this);
    pm.registerEvents(new SmeltListener(), this);
  }

  private void loadCommands() {
    loadCommand(new CompCommand(this));
  }

  private void loadCommand(BaseCommand command) {
    getCommand(command.getName()).setExecutor(command);
    getCommand(command.getName()).setTabCompleter(command);
    getCommand(command.getName()).setAliases(command.getAliases());
  }

  private void loadConfig(){
    try {
      this.configManager = new ConfigManager(this);
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    }
  }

  private void loadLang(){
    try {
      this.languageManager = new LanguageManager(this);
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    }
  }

  public RecipeManager getRecipeManager() { return recipeManager; }
  public LoggerUtil getLog() { return log; }
  public ConfigManager getConfigManager() { return configManager; }
  public LanguageManager getLanguageManager() { return languageManager; }

}
