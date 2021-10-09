package me.giodev.compressibleblocks.data.language;

import com.cryptomorin.xseries.XSound;
import me.giodev.compressibleblocks.CompressibleBlocks;
import me.giodev.compressibleblocks.utils.FileManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class LanguageManager {

  private CompressibleBlocks plugin;
  private YamlConfiguration langFileConfig;

  //Messages
  private String chatPrefix;
  private String noPermission;
  private String[] help;
  private String reloadingPlugin;
  private String pageError;
  private String openingPage;

  //Sounds
  private XSound clickSound;

  public LanguageManager(CompressibleBlocks plugin) throws InvalidConfigurationException {
    this.plugin = plugin;
    load();
  }

  private void load() throws InvalidConfigurationException {
    File langFile = new File(plugin.getDataFolder(), "language.yml");
    this.langFileConfig = new YamlConfiguration();

    if (!langFile.exists()) {
      FileManager.loadResource(plugin, "language.yml");
    }

    try {
      langFileConfig.load(langFile);
    } catch (IOException | InvalidConfigurationException e) {
      e.printStackTrace();
    }

    loadValues();

  }

  private void loadValues() throws InvalidConfigurationException {
    //Messages
    this.chatPrefix = getString(LanguageKeys.MESSAGE_PREFIX, LanguageDefaults.MESSAGE_PREFIX);
    this.noPermission = chatPrefix + getString(LanguageKeys.NO_PERMISSION, LanguageDefaults.NO_PERMISSION);
    this.help = getStringList(LanguageKeys.HELP, LanguageDefaults.HELP);
    this.reloadingPlugin = chatPrefix + getString(LanguageKeys.RELOADING_PLUGIN, LanguageDefaults.RELOADING_PLUGIN);
    this.pageError = chatPrefix + getString(LanguageKeys.PAGE_ERROR, LanguageDefaults.PAGE_ERROR);
    this.openingPage = chatPrefix + getString(LanguageKeys.OPENING_PAGE, LanguageDefaults.OPENING_PAGE);

    //Sounds
    this.clickSound = getSound(LanguageKeys.CLICK_SOUND, LanguageDefaults.CLICK_SOUND);

  }

  private String getString(String p, String defaultString) throws InvalidConfigurationException {
    if(langFileConfig.isString(p)) {
      return langFileConfig.getString(p).replace('&', '§');
    } else if(langFileConfig.contains(p)){
      throw new InvalidConfigurationException("'language.yml' at path:" + p + "' is not a string");
    }else {
      langFileConfig.set(p, defaultString);
      return defaultString;
    }
  }

  @SuppressWarnings("unchecked")
  public String[] getStringList(String p, String[] defaultList) throws InvalidConfigurationException {
    if (langFileConfig.isList(p)) {
      List<?> unknownList = langFileConfig.getList(p);

      ArrayList<String> stringList = new ArrayList(unknownList.size());
      Iterator it = unknownList.iterator();

      while(it.hasNext()) {
        Object obj = it.next();
        if (obj instanceof String) {
          stringList.add((String) ((String) obj).replace("&", "§"));
        } else {
          if (!(obj instanceof Double) && !(obj instanceof Integer) && !(obj instanceof Boolean)) {
            throw new InvalidConfigurationException("'" + langFileConfig.getName() + "' at path: '" + p + "' is not a string list");
          }

          stringList.add(obj.toString());
        }
      }

      return (String[])stringList.toArray(new String[0]);
    } else if (langFileConfig.contains(p)) {
      throw new InvalidConfigurationException("'" + langFileConfig.getName() + "' at path: '" + p + "' is not a list");
    } else {
      langFileConfig.set(p, defaultList);
      return defaultList;
    }
  }

  private XSound getSound(String p, XSound defaultSound) throws InvalidConfigurationException {
    try{
      return XSound.matchXSound(langFileConfig.getString(p)).get();
    }catch (IllegalArgumentException e){
      throw new InvalidConfigurationException("'Language.yml' the value specified in " + p + "is not a sound", e);
    }
  }

  public String[] getHelp() {
    return help;
  }

  public String getReloadingPlugin() {
    return reloadingPlugin;
  }

  public String getPageError() {
    return pageError;
  }

  public String getOpeningPage() {
    return openingPage;
  }

  public String getNoPermission() {
    return noPermission;
  }

  public String getChatPrefix() {
    return chatPrefix;
  }

  public XSound getClickSound(){
    return clickSound;
  }

}
