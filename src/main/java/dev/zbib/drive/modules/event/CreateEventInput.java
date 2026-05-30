package dev.zbib.drive.modules.event;

import dev.zbib.drive.common.types.EventType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Builder
@Getter
public class CreateEventInput {

    @NotNull
    private UUID eventId;

    @NotNull
    private UUID fileId;

    @NotNull
    private UUID deviceId;

    @NotNull
    private EventType eventType;

    private String storageKey;

    @NotNull
    private Instant clientTimestamp;
}