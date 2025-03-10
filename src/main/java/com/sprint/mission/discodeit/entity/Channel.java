package com.sprint.mission.discodeit.entity;

import com.sprint.mission.discodeit.entity.base.BaseUpdatableEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "channels")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name = "id",
        column = @Column(name = "channel_id")
)
public class Channel extends BaseUpdatableEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private ChannelType type;
    private String name;
    private String description;

    public Channel(ChannelType type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public void update(String newName, String newDescription) {
        if (newName != null && !newName.equals(this.name)) {
            this.name = newName;
        }
        if (newDescription != null && !newDescription.equals(this.description)) {
            this.description = newDescription;
        }
    }
}
