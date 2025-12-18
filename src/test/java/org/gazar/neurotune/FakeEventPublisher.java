package org.gazar.neurotune;

import org.gazar.neurotune.infrastructure.adapter.out.EventPublisherPort;

import java.util.ArrayList;
import java.util.List;

public class FakeEventPublisher implements EventPublisherPort {

    private final List<Object> events = new ArrayList<>();

    @Override
    public void publish(Object event) {
        events.add(event);
    }

    public List<Object> getEvents() {
        return events;
    }
}
