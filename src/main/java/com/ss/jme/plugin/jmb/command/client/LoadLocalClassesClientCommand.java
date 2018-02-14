package com.ss.jme.plugin.jmb.command.client;

import com.ss.rlib.network.annotation.PacketDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;
import java.nio.file.Path;

/**
 * The command to load module compiled classes in jMB.
 *
 * @author JavaSaBr
 */
@PacketDescription(id = 3)
public class LoadLocalClassesClientCommand extends ClientCommand {

    /**
     * The output folder.
     */
    @Nullable
    private final Path output;

    public LoadLocalClassesClientCommand(@Nullable final Path output) {
        this.output = output;
    }

    @Override
    protected void writeImpl(@NotNull final ByteBuffer buffer) {
        super.writeImpl(buffer);
        writeString(buffer, output == null ? "" : output.toString());
    }
}