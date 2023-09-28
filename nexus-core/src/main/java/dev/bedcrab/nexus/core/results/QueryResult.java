package dev.bedcrab.nexus.core.results;

import dev.bedcrab.nexus.core.NexusTable;

import java.util.Iterator;

public class QueryResult implements Iterator<ResultRow> {
    private final NexusTable table;
    private final Iterator<ResultRow> iterator;

    public QueryResult(NexusTable table, Iterator<ResultRow> iterator) {
        this.table = table;
        this.iterator = iterator;
    }

    public NexusTable getTable() {
        return table;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public ResultRow next() {
        return iterator.next();
    }
}
