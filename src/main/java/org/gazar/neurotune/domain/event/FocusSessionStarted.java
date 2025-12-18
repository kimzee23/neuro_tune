package org.gazar.neurotune.domain.event;

import java.time.Instant;
import java.util.UUID;

public record FocusSessionStarted(
        UUID sessionId,
        UUID userId,
        String focusMode,
        Instant startedAt
) implements DomainEvent{}