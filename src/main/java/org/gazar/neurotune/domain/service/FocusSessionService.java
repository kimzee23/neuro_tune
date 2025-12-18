package org.gazar.neurotune.domain.service;

import org.gazar.neurotune.domain.exception.FocusSessionException;
import org.gazar.neurotune.domain.model.FocusMode;
import org.gazar.neurotune.domain.model.FocusSession;
import org.gazar.neurotune.infrastructure.adapter.in.FocusSessionUseCase;
import org.gazar.neurotune.infrastructure.adapter.out.EventPublisherPort;
import org.gazar.neurotune.infrastructure.adapter.out.FocusSessionRepositoryPort;

import java.util.UUID;

public class FocusSessionService implements FocusSessionUseCase {

    private final FocusSessionRepositoryPort repository;
    private final EventPublisherPort eventPublisher;

    public FocusSessionService(
            FocusSessionRepositoryPort repository,
            EventPublisherPort eventPublisher
    ) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public UUID startSession(UUID userId, String focusModeName) {

        FocusMode focusMode = resolveFocusMode(focusModeName);

        FocusSession session = FocusSession.start(userId, focusMode);

        repository.save(session);

        // publish domain event
        eventPublisher.publish(
                new org.gazar.neurotune.domain.event.FocusSessionStarted(
                        session.getId(),
                        userId,
                        focusMode.getName(),
                        session.getStartTime()
                )
        );

        return session.getId();
    }

    @Override
    public void endSession(UUID sessionId) {

        FocusSession session = repository.findById(sessionId)
                .orElseThrow(() ->
                        new FocusSessionException("Focus session not found")
                );

        session.end();

        repository.save(session);

        eventPublisher.publish(
                new org.gazar.neurotune.domain.event.FocusSessionEnded(
                        session.getId(),
                        session.getUserId(),
                        session.getEndTime()
                )
        );
    }

    private FocusMode resolveFocusMode(String name) {
        return switch (name.toUpperCase()) {
            case "DEEP_FOCUS" -> FocusModeFactory.deepFocus();
            case "CALM_FOCUS" -> FocusModeFactory.calmFocus();
            case "HYPERFOCUS" -> FocusModeFactory.hyperFocus();
            default -> throw new FocusSessionException("Invalid focus mode");
        };
    }
}