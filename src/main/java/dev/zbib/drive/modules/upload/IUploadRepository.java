package dev.zbib.drive.modules.upload;

import dev.zbib.drive.modules.upload.entity.UploadSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUploadRepository extends JpaRepository<UploadSession, UUID> {
}
