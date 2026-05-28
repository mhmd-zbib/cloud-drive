package dev.zbib.drive.modules.file;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IFileRepository extends JpaRepository<File, UUID> {
}
