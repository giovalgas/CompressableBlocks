package dev.giovalgas.compressibleblocks.data.config;

import com.cryptomorin.xseries.XMaterial;
import dev.giovalgas.compressibleblocks.CompressibleBlocks;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ConfigManager {

  //Plugin
  private final CompressibleBlocks plugin;

  //Config Values
  private String consolePrefix;
  private String compressedName;
  private ArrayList<String> compressedLore;
  private ArrayList<Material> compressibleBlocks;

  public ConfigManager(CompressibleBlocks plugin) throws InvalidConfigurationException {
    this.plugin = plugin;
    load();
  }

  private void load() throws InvalidConfigurationException {
    ConfigFile config = new ConfigFile(plugin);
    config.load();

    this.consolePrefix = config.getString(ConfigKeys.CONSOLE_PREFIX, ConfigDefaults.CONSOLE_PREFIX);
    this.compressedName = ChatColor.translateAlternateColorCodes('&', config.getString(ConfigKeys.COMPRESSED_NAME, ConfigDefaults.COMPRESSED_NAME));
    this.compressedLore = new ArrayList<>(Arrays.asList(config.getStringList(ConfigKeys.COMPRESSED_LORE, ConfigDefaults.COMPRESSED_LORE))).stream().map(s -> ChatColor.translateAlternateColorCodes('&', s)).collect(Collectors.toCollection(ArrayList::new));
    this.compressibleBlocks = Arrays.stream(config.getStringList(ConfigKeys.COMPRESSIBLE_BLOCKS, ConfigDefaults.COMPRESSIBLE_BLOCKS)).map(s -> XMaterial.matchXMaterial(s).get().parseMaterial()).collect(Collectors.toCollection(ArrayList::new));

  }

  public void reload() throws InvalidConfigurationException {
    load();
  }

  public String getConsolePrefix() {
    return consolePrefix;
  }

  public String getCompressedName() {
    return compressedName;
  }

  public ArrayList<String> getCompressedLore() {
    return compressedLore;
  }

  public ArrayList<Material> getCompressibleBlocks() {
    return compressibleBlocks;
  }

}
