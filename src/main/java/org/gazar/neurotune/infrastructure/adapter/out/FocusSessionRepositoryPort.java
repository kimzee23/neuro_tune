package org.gazar.neurotune.infrastructure.adapter.out;

import org.gazar.neurotune.domain.model.FocusSession;

import java.util.Optional;
import java.util.UUID;

public interface FocusSessionRepositoryPort {

    void save(FocusSession session);

    Optional<FocusSession> findById(UUID sessionId);
}
