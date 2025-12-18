package org.gazar.neurotune.domainTest.service;

import org.gazar.neurotune.FakeEventPublisher;
import org.gazar.neurotune.InMemoryFocusSessionRepository;
import org.gazar.neurotune.domain.event.FocusSessionStarted;
import org.gazar.neurotune.domain.service.FocusSessionService;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FocusSessionServiceTest {

    @Test
    void should_start_focus_session_and_publish_event() {

        InMemoryFocusSessionRepository repo =
                new InMemoryFocusSessionRepository();
        FakeEventPublisher publisher =
                new FakeEventPublisher();

        FocusSessionService service =
                new FocusSessionService(repo, publisher);

        UUID userId = UUID.randomUUID();

        UUID sessionId = service.startSession(userId, "DEEP_FOCUS");

        assertNotNull(sessionId);
        assertEquals(1, publisher.getEvents().size());
        assertTrue(publisher.getEvents().get(0)
                instanceof FocusSessionStarted);
    }
}
