package com.sprint.mission.discodeit.entity;

import com.sprint.mission.discodeit.entity.base.BaseUpdatableEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_statuses")
@AttributeOverride(
        name = "id",
        column = @Column(name = "user_status_id")
)
public class UserStatus extends BaseUpdatableEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  private Instant lastActiveAt;

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  public UserStatus(UUID userId, Instant lastActiveAt) {
    this.lastActiveAt = lastActiveAt;
  }

  public void update(Instant lastActiveAt) {
    boolean anyValueUpdated = false;
    if (lastActiveAt != null && !lastActiveAt.equals(this.lastActiveAt)) {
      this.lastActiveAt = lastActiveAt;
      anyValueUpdated = true;
    }
  }

  public Boolean isOnline() {
    Instant instantFiveMinutesAgo = Instant.now().minus(Duration.ofMinutes(5));

    return lastActiveAt.isAfter(instantFiveMinutesAgo);
  }
}
