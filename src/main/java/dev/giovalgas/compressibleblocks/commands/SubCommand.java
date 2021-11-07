package dev.giovalgas.compressibleblocks.commands;


import dev.giovalgas.compressibleblocks.CompressibleBlocks;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SubCommand {
  void executeCommand(CommandSender sender, String[] args, CompressibleBlocks plugin);

  @NotNull String getPermission();

  @Nullable String[] getArguments();

}
