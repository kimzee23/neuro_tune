package org.gazar.neurotune.application.port.in.web;

import jakarta.validation.Valid;
import org.gazar.neurotune.application.dto.request.StartFocusSessionRequest;
import org.gazar.neurotune.application.dto.response.StartFocusSessionResponse;
import org.gazar.neurotune.infrastructure.adapter.in.FocusSessionUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
public class FocusSessionController {
    private final FocusSessionUseCase useCase;

    public FocusSessionController(FocusSessionUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/start")
    public StartFocusSessionResponse start(
            @RequestHeader("X-USER-ID") UUID userId,
            @Valid @RequestBody StartFocusSessionRequest request
    ) {
        UUID sessionId =
                useCase.startSession(userId, request.getFocusMode());

        return new StartFocusSessionResponse(sessionId);
    }

    @PostMapping("/end/{sessionId}")
    public void end(@PathVariable UUID sessionId) {
        useCase.endSession(sessionId);
    }
}
