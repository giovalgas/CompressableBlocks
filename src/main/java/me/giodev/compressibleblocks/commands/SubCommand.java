package me.giodev.compressibleblocks.commands;


import me.giodev.compressibleblocks.CompressibleBlocks;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SubCommand {
  void executeCommand(CommandSender sender, String[] args, CompressibleBlocks plugin);

  @NotNull String getPermission();

  @Nullable String[] getArguments();

}
