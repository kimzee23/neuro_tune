package org.gazar.neurotune.domain.model;

import lombok.Getter;
import org.gazar.neurotune.domain.event.FocusSessionEnded;
import org.gazar.neurotune.domain.event.FocusSessionStarted;
import org.gazar.neurotune.domain.exception.FocusSessionException;

import java.time.Instant;
import java.util.UUID;

@Getter
public class FocusSession {

    private final UUID id;
    private final UUID userId;
    private final FocusMode focusMode;
    private final Instant startTime;
    private Instant endTime;

    private FocusSession(UUID id,
                         UUID userId,
                         FocusMode focusMode,
                         Instant startTime) {
        this.id = id;
        this.userId = userId;
        this.focusMode = focusMode;
        this.startTime = startTime;
    }

    public static FocusSession start(UUID userId, FocusMode focusMode) {
        FocusSession session = new FocusSession(
                UUID.randomUUID(),
                userId,
                focusMode,
                Instant.now()
        );

        session.raiseEvent(new FocusSessionStarted(
                session.id,
                userId,
                focusMode.getName(),
                session.startTime
        ));

        return session;
    }

    public void end() {
        if (this.endTime != null) {
            throw new FocusSessionException("Focus session already ended");
        }

        this.endTime = Instant.now();

        raiseEvent(new FocusSessionEnded(
                this.id,
                this.userId,
                this.endTime
        ));
    }

    private void raiseEvent(Object event) {
        // domain event hook (handled later by application layer)
    }

}
