package dev.bedcrab.nexus.core.where;

public class MatchPair {
    public final String columnName;
    public final Match match;
    public final Object value;

    public MatchPair(String columnName, Match match, Object value) {
        this.columnName = columnName;
        this.match = match;
        this.value = value;
    }
}
