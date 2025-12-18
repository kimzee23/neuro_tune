package org.gazar.neurotune.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public class StartFocusSessionRequest {

    @NotBlank
    private String focusMode;

    public String getFocusMode() {
        return focusMode;
    }

    public void setFocusMode(String focusMode) {
        this.focusMode = focusMode;
    }
}