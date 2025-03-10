package com.sprint.mission.discodeit.entity;

import com.sprint.mission.discodeit.entity.base.BaseUpdatableEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "messages")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name = "id",
        column = @Column(name = "message_id")
)
public class Message extends BaseUpdatableEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @OneToMany(mappedBy = "binary_content_id")
    private List<BinaryContent> attachments = new ArrayList<>();

    public Message(String content, UUID channelId, UUID authorId, List<UUID> attachmentIds) {
        this.content = content;
    }

    public void update(String newContent) {
        if (newContent != null && !newContent.equals(this.content)) {
            this.content = newContent;
        }
    }
}
