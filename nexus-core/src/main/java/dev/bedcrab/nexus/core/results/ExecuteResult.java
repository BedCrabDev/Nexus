package dev.bedcrab.nexus.core.results;

/**
 * Result for execute queries that do not return a result.
 * @param success Whether the query was successful or not.
 * @param message The message if the query failed. Nullable.
 */
public record ExecuteResult(boolean success, String message) {

}
