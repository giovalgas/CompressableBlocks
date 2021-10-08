package me.giodev.compressibleblocks.commands.examplecommand;

import me.giodev.compressibleblocks.CompressibleBlocks;
import me.giodev.compressibleblocks.commands.BaseCommand;
import me.giodev.compressibleblocks.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;

public class CompressibleCommand extends BaseCommand {

  public CompressibleCommand(CompressibleBlocks plugin) {
    super(plugin);
  }

  @Override
  public void executeStockSubCommand(CommandSender sender) {
    plugin.getLog().info("executing stock command!");
  }

  @Override
  public @NotNull String getPermission() {
    return Permission.TPCOMMAND;
  }

  @Override
  public @NotNull String getName() {
    return "compressibleblocks";
  }


  @Override
  public @NotNull List<String> getAliases() { return Arrays.asList(new String[]{"cp"}.clone()); }

  @Override
  public boolean isPlayerOnly() {
    return false;
  }


}
