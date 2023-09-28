package dev.bedcrab.nexus.core;

import dev.bedcrab.nexus.core.columns.Column;

public interface NexusTable {
    String name();
    Column[] columns();
}
