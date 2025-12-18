package org.gazar.neurotune;

import org.gazar.neurotune.domain.model.FocusSession;
import org.gazar.neurotune.infrastructure.adapter.out.FocusSessionRepositoryPort;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryFocusSessionRepository
        implements FocusSessionRepositoryPort {

    private final Map<UUID, FocusSession> store = new HashMap<>();

    @Override
    public void save(FocusSession session) {
        store.put(session.getId(), session);
    }

    @Override
    public Optional<FocusSession> findById(UUID sessionId) {
        return Optional.ofNullable(store.get(sessionId));
    }
}