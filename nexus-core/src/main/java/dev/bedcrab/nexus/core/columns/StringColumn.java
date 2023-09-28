package dev.bedcrab.nexus.core.columns;

public class StringColumn extends Column<String> {
    public StringColumn(String name) {
        super(name);
    }

    @Override
    public String toString(String value) {
        return value;
    }

    @Override
    public String fromString(String value) {
        return value;
    }

    @Override
    public byte[] toBytes(String value) {
        return value.getBytes();
    }

    @Override
    public String fromBytes(byte[] value) {
        return new String(value);
    }
}
