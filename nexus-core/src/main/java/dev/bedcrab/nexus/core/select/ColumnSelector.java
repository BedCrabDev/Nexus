package dev.bedcrab.nexus.core.select;

import dev.bedcrab.nexus.core.NexusTable;
import dev.bedcrab.nexus.core.columns.Column;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ColumnSelector {
    public static ColumnSelector of(Function<NexusTable, Column<?>[]> selector) {
        return new ColumnSelector(selector);
    }

    public static ColumnSelector ALL = new ColumnSelector(NexusTable::columns);
    public static ColumnSelector COLUMNS(String... namesArray) {
        List<String> names = Arrays.asList(namesArray);
        return new ColumnSelector(nexusTable -> Arrays.stream(nexusTable.columns()).filter(c -> names.contains(c.name)).toArray(Column[]::new));
    }

    private final Function<NexusTable, Column<?>[]> selector;
    private ColumnSelector(Function<NexusTable, Column<?>[]> selector) {
        this.selector = selector;
    }

    public Column<?>[] select(NexusTable table) {
        return selector.apply(table);
    }
}
