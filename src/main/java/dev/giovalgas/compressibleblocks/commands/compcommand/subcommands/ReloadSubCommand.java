package dev.giovalgas.compressibleblocks.commands.compcommand.subcommands;

import dev.giovalgas.compressibleblocks.CompressibleBlocks;
import dev.giovalgas.compressibleblocks.commands.SubCommand;
import dev.giovalgas.compressibleblocks.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReloadSubCommand implements SubCommand {

  @Override
  public void executeCommand(CommandSender sender, String[] args, CompressibleBlocks plugin) {

    sender.sendMessage(plugin.getLanguageManager().getReloadingPlugin());

    try {
      plugin.getConfigManager().reload();
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    }

    plugin.getRecipeManager().reload(plugin.getConfigManager().getCompressibleBlocks());

  }

  @Override
  public @NotNull String getPermission() {
    return Permission.ADMIN;
  }

  @Override
  public @Nullable String[] getArguments() {
    return new String[0];
  }

}
