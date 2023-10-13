package dev.bedcrab.nexus.core.select;

import dev.bedcrab.nexus.core.Nexus;
import dev.bedcrab.nexus.core.NexusTable;
import dev.bedcrab.nexus.core.results.QueryResult;
import dev.bedcrab.nexus.core.where.Match;
import dev.bedcrab.nexus.core.where.MatchPair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SelectQuery {
    private final Nexus nexus;
    private ColumnSelector columnSelector;
    private final List<MatchPair> rowSelectors = new ArrayList<>();

    public SelectQuery(Nexus nexus, ColumnSelector columnSelector) {
        this.nexus = nexus;
        this.columnSelector = columnSelector;
    }

    public SelectQuery where(String columnName, Match match, Object value) {
        rowSelectors.add(new MatchPair(columnName, match, value));
        return this;
    }

    public SelectQuery where(MatchPair rowSelector) {
        rowSelectors.add(rowSelector);
        return this;
    }

    public List<MatchPair> getRowSelectors() {
        return rowSelectors;
    }

    public void run(NexusTable table, Consumer<QueryResult> result) {
        nexus.getAPI().select(table, result);
    }
}
