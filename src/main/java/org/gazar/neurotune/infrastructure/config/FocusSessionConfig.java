package org.gazar.neurotune.infrastructure.config;

import org.gazar.neurotune.domain.service.FocusSessionService;
import org.gazar.neurotune.infrastructure.adapter.out.EventPublisherPort;
import org.gazar.neurotune.infrastructure.adapter.out.FocusSessionRepositoryPort;
import org.gazar.neurotune.infrastructure.adapter.out.persistence.FocusSessionJpaRepository;
import org.gazar.neurotune.infrastructure.adapter.out.persistence.FocusSessionRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FocusSessionConfig {

    @Bean
    FocusSessionRepositoryPort focusSessionRepositoryPort(
            FocusSessionJpaRepository jpaRepository
    ) {
        return new FocusSessionRepositoryAdapter(jpaRepository);
    }

    @Bean
    FocusSessionService focusSessionService(
            FocusSessionRepositoryPort repository,
            EventPublisherPort eventPublisher
    ) {
        return new FocusSessionService(repository, eventPublisher);
    }
}
