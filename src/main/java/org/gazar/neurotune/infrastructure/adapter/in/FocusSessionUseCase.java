package org.gazar.neurotune.infrastructure.adapter.in;

import java.util.UUID;

public interface FocusSessionUseCase {

    UUID startSession(UUID userId, String focusMode);

    void endSession(UUID sessionId);
}