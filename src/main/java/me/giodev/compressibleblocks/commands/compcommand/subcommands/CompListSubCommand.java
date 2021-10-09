package me.giodev.compressibleblocks.commands.compcommand.subcommands;

import me.giodev.compressibleblocks.CompressibleBlocks;
import me.giodev.compressibleblocks.commands.SubCommand;
import me.giodev.compressibleblocks.data.gui.menus.CompListMenu;
import me.giodev.compressibleblocks.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompListSubCommand implements SubCommand {

  @Override
  public void executeCommand(CommandSender sender, String[] args, CompressibleBlocks plugin) {

    //TODO -> Add message: "Now opening the compressible blocks list"

    Player player = (Player) sender;
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
