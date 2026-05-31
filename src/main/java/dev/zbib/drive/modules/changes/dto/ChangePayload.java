package dev.zbib.drive.modules.changes.dto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "eventType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FileCreatedPayload.class, name = "FILE_CREATED"),
        @JsonSubTypes.Type(value = FileModifiedPayload.class, name = "FILE_MODIFIED"),
        @JsonSubTypes.Type(value = FileRenamedPayload.class, name = "FILE_RENAMED"),
        @JsonSubTypes.Type(value = FileMovedPayload.class, name = "FILE_MOVED"),
        @JsonSubTypes.Type(value = FileDeletedPayload.class,   name = "FILE_DELETED"),
        @JsonSubTypes.Type(value = FolderCreatedPayload.class, name = "FOLDER_CREATED"),
        @JsonSubTypes.Type(value = FolderRenamedPayload.class, name = "FOLDER_RENAMED"),
        @JsonSubTypes.Type(value = FolderMovedPayload.class,   name = "FOLDER_MOVED"),
        @JsonSubTypes.Type(value = FolderDeletedPayload.class, name = "FOLDER_DELETED")
})
public interface ChangePayload {
}
