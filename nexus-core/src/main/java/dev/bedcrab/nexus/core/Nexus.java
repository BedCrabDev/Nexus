package dev.bedcrab.nexus.core;

import java.util.ArrayList;
import java.util.List;

public class Nexus {
    public static Builder builder(NexusImplementation implementation) {
        return new Builder(implementation);
    }

    private final NexusImplementation implementation;
    private final List<NexusTable> tables;
    public Nexus(Builder builder) {
        this.implementation = builder.implementation;
        this.tables = List.of(builder.tables.toArray(NexusTable[]::new));
    }


    public NexusImplementation getAPI() {
        return implementation;
    }

    public <T extends NexusTable> T resolveTable(Class<T> clazz) {
        return tables.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }

    public static class Builder {
        private final NexusImplementation implementation;
        private final ArrayList<NexusTable> tables = new ArrayList<>();
        public Builder(NexusImplementation implementation) {
            this.implementation = implementation;
        }

        public Builder addTable(NexusTable... tables) {
            this.tables.addAll(List.of(tables));
            return this;
        }

        public Nexus build() {
            return new Nexus(this);
        }
    }
}
