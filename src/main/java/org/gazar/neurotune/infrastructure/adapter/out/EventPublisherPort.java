package org.gazar.neurotune.infrastructure.adapter.out;

public interface EventPublisherPort {

    void publish(Object event);
}
