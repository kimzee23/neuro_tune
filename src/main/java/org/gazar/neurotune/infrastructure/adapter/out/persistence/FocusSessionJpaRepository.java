package org.gazar.neurotune.infrastructure.adapter.out.persistence;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FocusSessionJpaRepository
        extends JpaRepository<FocusSessionEntity, UUID> {
}