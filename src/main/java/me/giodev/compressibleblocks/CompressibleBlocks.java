package me.giodev.compressibleblocks;

import me.giodev.compressibleblocks.commands.BaseCommand;
import me.giodev.compressibleblocks.commands.examplecommand.CompressibleCommand;
import me.giodev.compressibleblocks.data.config.ConfigManager;
import me.giodev.compressibleblocks.data.language.LanguageManager;
import me.giodev.compressibleblocks.listeners.GUIClickListener;
import me.giodev.compressibleblocks.utils.LoggerUtil;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class CompressibleBlocks extends JavaPlugin {

  private ConfigManager configManager;
  private LanguageManager languageManager;
  private LoggerUtil log;

  @Override
  public void onEnable(){
    //Load config, language & logger
    loadConfig();
    loadLang();
    log = new LoggerUtil(this);

    //Commands & Events
    loadCommands();
    loadEvents();

    log.info("Plugin fully started!");
  }

  private void loadEvents() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new GUIClickListener(this), this);
  }

  private void loadCommands() {
    loadCommand(new CompressibleCommand(this));
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

  public LoggerUtil getLog() { return log; }
  public ConfigManager getConfigManager() { return configManager; }
  public LanguageManager getLanguageManager() { return languageManager; }

}
