package dev.zbib.drive.modules.event;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IEventRepository extends JpaRepository<Event, UUID> {
    @Query("SELECT  e.eventId FROM Event  e WHERE e.eventId IN :eventIds")
    Set<UUID> findExistingEventIds( @Param("eventIds") List<UUID> eventIds);
}
