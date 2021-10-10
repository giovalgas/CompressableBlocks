package me.giodev.compressibleblocks.commands.compcommand;

import me.giodev.compressibleblocks.CompressibleBlocks;
import me.giodev.compressibleblocks.commands.BaseCommand;
import me.giodev.compressibleblocks.commands.compcommand.subcommands.CompListSubCommand;
import me.giodev.compressibleblocks.commands.compcommand.subcommands.ReloadSubCommand;
import me.giodev.compressibleblocks.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;

public class CompCommand extends BaseCommand {

  public CompCommand(CompressibleBlocks plugin) {
    super(plugin);
    subCommands.put("LIST", new CompListSubCommand());
    subCommands.put("RELOAD", new ReloadSubCommand());
  }

  @Override
  public void executeStockSubCommand(CommandSender sender) {
    sender.sendMessage(plugin.getLanguageManager().getHelp());
  }

  @Override
  public @NotNull String getPermission() {
    return Permission.COMP_COMMAND;
  }

  @Override
  public @NotNull String getName() {
    return "compressibleblocks";
  }


  @Override
  public @NotNull List<String> getAliases() { return Arrays.asList(new String[]{"cp"}.clone()); }

  @Override
  public boolean isPlayerOnly() {
    return true;
  }


}
