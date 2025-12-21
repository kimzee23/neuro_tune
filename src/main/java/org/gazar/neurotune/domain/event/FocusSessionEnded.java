package org.gazar.neurotune.domain.event;

import java.time.Instant;
import java.util.UUID;

public record FocusSessionEnded(
        UUID sessionId,
        UUID userId,
        Instant endedAt
) implements DomainEvent {
}
