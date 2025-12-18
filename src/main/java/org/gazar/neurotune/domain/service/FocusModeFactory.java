package org.gazar.neurotune.domain.service;

import org.gazar.neurotune.domain.model.FocusMode;

public class FocusModeFactory {

    public static FocusMode deepFocus() {
        return new FocusMode(
                "DEEP_FOCUS",
                60, 90,
                0.2,0.6,
                0.7,
                0.2,
                0.3, 0.6
        );
    }
    public static FocusMode calmFocus() {
        return new FocusMode(
                "CALM_FOCUS",
                50,80,
                0.1,0.4,
                0.8,
                0.15,
                0.2, 0.5
        );
    }
    public static FocusMode hyperFocus() {
        return new FocusMode(
                "HYPERFOCUS",
                100, 140,
                0.6, 0.85,
                0.5,
                0.3,
                0.5, 0.8
        );
    }
}
