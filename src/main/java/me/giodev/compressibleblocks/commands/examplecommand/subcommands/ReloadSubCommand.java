package me.giodev.compressibleblocks.commands.examplecommand.subcommands;

import me.giodev.compressibleblocks.CompressibleBlocks;
import me.giodev.compressibleblocks.commands.SubCommand;
import me.giodev.compressibleblocks.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReloadSubCommand implements SubCommand {

  @Override
  public void executeCommand(CommandSender sender, String[] args, CompressibleBlocks plugin) {

    //TODO -> Add message: "Reloading configuration file"

    plugin.loadConfig();

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
