package dev.zbib.drive.modules.changes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IChangeRepository extends JpaRepository<Change, UUID> {

    @Query("SELECT c.changeId FROM Change c WHERE c.changeId IN :changeIds")
    Set<UUID> findExistingChangeIds(@Param("changeIds") List<UUID> changeIds);
}
