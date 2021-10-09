package me.giodev.compressibleblocks.commands.compcommand.subcommands;

import me.giodev.compressibleblocks.CompressibleBlocks;
import me.giodev.compressibleblocks.commands.SubCommand;
import me.giodev.compressibleblocks.data.permissions.Permission;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;

public class ReloadSubCommand implements SubCommand {

  @Override
  public void executeCommand(CommandSender sender, String[] args, CompressibleBlocks plugin) {

    //TODO -> Add message: "Reloading configuration file"

    plugin.loadConfig();

    //TODO -> Remove test code
    ArrayList<Material> materials = new ArrayList<>();
    materials.add(Material.APPLE);

    plugin.getRecipeManager().reload(materials);


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
