package com.ss.jme.plugin.jmb.command.client;

import com.ss.rlib.common.network.annotation.PacketDescription;
import com.ss.rlib.common.util.array.Array;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.nio.file.Path;

/**
 * The command to load module libraries in jMB.
 *
 * @author JavaSaBr
 */
@PacketDescription(id = 2)
public class LoadLocalLibrariesClientCommand extends ClientCommand {

    /**
     * The libraries.
     */
    @NotNull
    private final Array<Path> libraries;

    public LoadLocalLibrariesClientCommand(@NotNull Array<Path> libraries) {
        this.libraries = libraries;
    }

    @Override
    protected void writeImpl(@NotNull ByteBuffer buffer) {
        super.writeImpl(buffer);
        writeInt(buffer, libraries.size());
        libraries.forEach(library -> writeString(buffer, library.toString()));
    }
}
