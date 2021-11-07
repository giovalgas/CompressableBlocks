package dev.giovalgas.compressibleblocks.commands.compcommand.subcommands;

import dev.giovalgas.compressibleblocks.CompressibleBlocks;
import dev.giovalgas.compressibleblocks.commands.SubCommand;
import dev.giovalgas.compressibleblocks.data.gui.menus.CompListMenu;
import dev.giovalgas.compressibleblocks.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompListSubCommand implements SubCommand {

  @Override
  public void executeCommand(CommandSender sender, String[] args, CompressibleBlocks plugin) {

    Player player = (Player) sender;
    player.sendMessage(plugin.getLanguageManager().getOpeningPage());
    new CompListMenu(player, plugin).open();

  }

  @Override
  public @NotNull String getPermission() {
    return Permission.COMP_LIST;
  }

  @Override
  public @Nullable String[] getArguments() {
    return new String[0];
  }

}
