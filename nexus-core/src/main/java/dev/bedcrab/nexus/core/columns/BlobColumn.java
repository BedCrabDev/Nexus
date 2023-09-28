package dev.bedcrab.nexus.core.columns;

import java.util.HexFormat;

public class BlobColumn extends Column<byte[]> {
    public BlobColumn(String name) {
        super(name);
    }

    @Override
    public String toString(byte[] value) {
        return HexFormat.of().formatHex(value);
    }

    @Override
    public byte[] fromString(String value) {
        return HexFormat.of().parseHex(value);
    }

    @Override
    public byte[] toBytes(byte[] value) {
        return value;
    }

    @Override
    public byte[] fromBytes(byte[] value) {
        return value;
    }
}
