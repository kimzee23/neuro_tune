package org.gazar.neurotune.infrastructure.adapter.out.persistence;

import org.gazar.neurotune.domain.model.FocusSession;
import org.gazar.neurotune.infrastructure.adapter.out.FocusSessionRepositoryPort;
import org.gazar.neurotune.infrastructure.adapter.out.persistence.mapper.FocusSessionMapper;

import java.util.Optional;
import java.util.UUID;

public class FocusSessionRepositoryAdapter
        implements FocusSessionRepositoryPort {

    private final FocusSessionJpaRepository repository;

    public FocusSessionRepositoryAdapter(
            FocusSessionJpaRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public void save(FocusSession session) {
        repository.save(FocusSessionMapper.toEntity(session));
    }

    @Override
    public Optional<FocusSession> findById(UUID sessionId) {
        return repository.findById(sessionId)
                .map(FocusSessionMapper::toDomain);
    }
}