package dev.zbib.drive.modules.event.dto;

import dev.zbib.drive.common.types.EventType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Builder
@Getter
public class EventInput {

    @NotNull
    private UUID eventId;

    @NotNull
    private UUID deviceId;

    @NotNull
    private EventType eventType;

    @NotNull
    private Instant timestamp;
}