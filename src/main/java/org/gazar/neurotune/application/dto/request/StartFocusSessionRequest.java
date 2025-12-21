package org.gazar.neurotune.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StartFocusSessionRequest {

    @NotBlank
    private String focusMode;

}