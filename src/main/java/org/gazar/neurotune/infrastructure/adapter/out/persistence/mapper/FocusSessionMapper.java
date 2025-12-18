package org.gazar.neurotune.infrastructure.adapter.out.persistence.mapper;


import org.gazar.neurotune.domain.model.FocusMode;
import org.gazar.neurotune.domain.model.FocusSession;
import org.gazar.neurotune.domain.service.FocusModeFactory;
import org.gazar.neurotune.infrastructure.adapter.out.persistence.FocusSessionEntity;

public class FocusSessionMapper {

    public static FocusSessionEntity toEntity(FocusSession session) {
        return new FocusSessionEntity(
                session.getId(),
                session.getUserId(),
                session.getFocusMode().getName(),
                session.getStartTime(),
                session.getEndTime()
        );
    }

    public static FocusSession toDomain(FocusSessionEntity entity) {
        FocusMode mode = switch (entity.getFocusMode()) {
            case "DEEP_FOCUS" -> FocusModeFactory.deepFocus();
            case "CALM_FOCUS" -> FocusModeFactory.calmFocus();
            case "HYPERFOCUS" -> FocusModeFactory.hyperFocus();
            default -> throw new IllegalStateException("Unknown focus mode");
        };

        FocusSession session = FocusSession.start(entity.getUserId(), mode);

        if (entity.getEndTime() != null) {
            session.end();
        }

        return session;
    }
}
