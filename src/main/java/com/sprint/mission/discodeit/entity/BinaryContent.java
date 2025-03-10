package com.sprint.mission.discodeit.entity;

import com.sprint.mission.discodeit.entity.base.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "binary_contents")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name = "id",
        column = @Column(name = "binary_content_id")
)
public class BinaryContent extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "file_name")
    private String fileName;

    private Long size;

    @Column(name = "content_type")
    private String contentType;

    private byte[] bytes;

    public BinaryContent(String fileName, Long size, String contentType, byte[] bytes) {
        this.fileName = fileName;
        this.size = size;
        this.contentType = contentType;
        this.bytes = bytes;
    }
}
