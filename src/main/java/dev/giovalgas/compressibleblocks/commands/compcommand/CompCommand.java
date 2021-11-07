package dev.giovalgas.compressibleblocks.commands.compcommand;

import dev.giovalgas.compressibleblocks.commands.BaseCommand;
import dev.giovalgas.compressibleblocks.commands.compcommand.subcommands.CompListSubCommand;
import dev.giovalgas.compressibleblocks.commands.compcommand.subcommands.ReloadSubCommand;
import dev.giovalgas.compressibleblocks.data.permissions.Permission;
import dev.giovalgas.compressibleblocks.CompressibleBlocks;
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
