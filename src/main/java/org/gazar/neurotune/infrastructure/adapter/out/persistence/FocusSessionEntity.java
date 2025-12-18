package org.gazar.neurotune.infrastructure.adapter.out.persistence;

import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "focus_sessions")
public class FocusSessionEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String focusMode;

    @Column(nullable = false)
    private Instant startTime;

    private Instant endTime;

    protected FocusSessionEntity() {}

    public FocusSessionEntity(
            UUID id,
            UUID userId,
            String focusMode,
            Instant startTime,
            Instant endTime
    ) {
        this.id = id;
        this.userId = userId;
        this.focusMode = focusMode;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
