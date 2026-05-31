package dev.zbib.drive.modules.folder;

import dev.zbib.drive.common.entity.BaseEntity;
import dev.zbib.drive.common.types.Visibility;
import dev.zbib.drive.modules.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "folders", indexes = {
        @Index(name = "idx_folders_owner_id", columnList = "owner_id"),
        @Index(name = "idx_folders_parent_id", columnList = "parent_id")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Folder extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Folder parent;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;
}
