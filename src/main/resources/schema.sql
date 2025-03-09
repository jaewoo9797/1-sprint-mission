-- USER
CREATE TABLE users
(
    user_id    UUID,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP    NOT NULL,
    username   VARCHAR(50)  NOT NULL,
    email      VARCHAR(100) NOT NULL,
    password   VARCHAR(60)  NOT NULL,
    profile_id UUID,
    CONSTRAINT pk_users_user_id PRIMARY KEY (user_id),
    CONSTRAINT uk_users_username UNIQUE (username),
    CONSTRAINT uk_users_email UNIQUE (email),
    CONSTRAINT fk_user_statuses_users
        FOREIGN KEY (profile_id)
            REFERENCES user_statuses (user_statuse_id)
            ON DELETE SET NULL
);

-- USER STATUSES
CREATE TABLE user_statuses
(
    user_statuses_id UUID,
    created_at       TIMESTAMP NOT NULL,
    updated_at       TIMESTAMP,
    user_id          UUID,
    last_active_at   TIMESTAMP NOT NULL,
    CONSTRAINT pk_user_statuses_id PRIMARY KEY (user_statuses_id),
    CONSTRAINT fk_users_user_statuses
        FOREIGN KEY (user_id)
            REFERENCES users (user_id) ON DELETE CASCADE
);

-- BINARY_CONTENT
