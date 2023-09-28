package dev.bedcrab.nexus.core.columns;

public abstract class Column<T> {
    public final String name;
    public Column(String name) {
        this.name = name;
    }

    /**
     * Turns the T value into a String.
     * - Human readable values will be returned as-is
     * - Binary values will be returned as hex
     * @param value The value to convert
     * @return A String
     */
    public abstract String toString(T value);

    /**
     * Creates a T value from a String.
     * @param value The value to convert
     * @return A T
     */
    public abstract T fromString(String value);

    /**
     * Turns the T value into a byte array.
     * - When possible, the value's toBytes() method will be called
     * - If not, another method will be determined and called
     * @param value The value to convert
     * @return A byte array
     */
    public abstract byte[] toBytes(T value);

    /**
     * Turns a byte array into a T.
     * @param value The value to convert
     * @return A T
     */
    public abstract T fromBytes(byte[] value);
}
