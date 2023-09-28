package dev.bedcrab.nexus.core;

import dev.bedcrab.nexus.core.results.QueryResult;

import java.util.List;
import java.util.function.Consumer;

public abstract class NexusImplementation {
    /**
     * Connect to the database.
     * @throws RuntimeException connection could not be established
     */
    public abstract void init() throws RuntimeException;

    /**
     * Create tables on the database if they don't exist.
     * @param tables the registered tables
     */
    public abstract void applyTables(List<NexusTable> tables);

    /**
     * Close the database connection.
     */
    public abstract void close();



    public abstract void select(NexusTable table, Consumer<QueryResult> result);
}
