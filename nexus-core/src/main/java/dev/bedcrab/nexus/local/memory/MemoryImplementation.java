package dev.bedcrab.nexus.local.memory;

import dev.bedcrab.nexus.core.NexusImplementation;
import dev.bedcrab.nexus.core.NexusTable;
import dev.bedcrab.nexus.core.results.QueryResult;

import java.util.List;
import java.util.function.Consumer;

public class MemoryImplementation extends NexusImplementation {
    @Override
    public void init() throws RuntimeException {

    }

    @Override
    public void applyTables(List<NexusTable> tables) {

    }

    @Override
    public void close() {

    }

    @Override
    public void select(NexusTable table, Consumer<QueryResult> result) {

    }
}
