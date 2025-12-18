package org.gazar.neurotune.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter

public class FocusMode {

    private final String name;
    private final int minTempo;
    private final int maxTempo;
    private final double minEnergy;
    private final double maxEnergy;
    private final double minInstrumentalness;
    private final double maxSpeechiness;
    private final double minValence;
    private final double maxValence;

    public FocusMode(
            String name,
            int minTempo,
            int maxTempo,
            double minEnergy,
            double maxEnergy,
            double minInstrumentalness,
            double maxSpeechiness,
            double minValence,
            double maxValence
    ) {
        this.name = Objects.requireNonNull(name);
        this.minTempo = minTempo;
        this.maxTempo = maxTempo;
        this.minEnergy = minEnergy;
        this.maxEnergy = maxEnergy;
        this.minInstrumentalness = minInstrumentalness;
        this.maxSpeechiness = maxSpeechiness;
        this.minValence = minValence;
        this.maxValence = maxValence;
    }

}
