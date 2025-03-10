package com.sprint.mission.discodeit.entity.base;

import java.time.Instant;
import org.springframework.data.annotation.LastModifiedDate;

public abstract class BaseUpdatableEntity extends BaseEntity {

    @LastModifiedDate
    private Instant updatedAt;

}
