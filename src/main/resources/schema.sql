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
            REFERENCES binary_contents (binary_content_id)
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
            REFERENCES users (user_id)
            ON DELETE CASCADE
);

-- BINARY_CONTENT
CREATE TABLE binary_contents
(
    binary_content_id UUID,
    created_at        TIMESTAMP    NOT NULL,
    file_name         VARCHAR(255) NOT NULL,
    size              BIGINT       NOT NULL,
    content_type      VARCHAR(100) NOT NULL,
    bytes             BYTEA        NOT NULL,
    CONSTRAINT pk_binary_contents_id PRIMARY KEY (binary_content_id),

);

-- CHANNELS
CREATE TABLE channels
(
    channel_id  UUID,
    created_at  TIMESTAMP   NOT NULL,
    updated_at  TIMESTAMP,
    name        VARCHAR(100),
    description VARCHAR(500),
    type        VARCHAR(10) NOT NULL,
    CONSTRAINT pk_channels_id PRIMARY KEY (channel_id)
);

-- MESSAGES
CREATE TABLE messages
(
    message_id UUID,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    content    TEXT,
    channel_id UUID,
    author_id  UUID,
    CONSTRAINT pk_messages_id PRIMARY KEY (message_id),
    CONSTRAINT fk_messages_channels
        FOREIGN KEY (channel_id)
            REFERENCES channels (channel_id)
            ON DELETE CASCADE,
    CONSTRAINT fk_messages_users
        FOREIGN KEY (author_id)
            REFERENCES users (user_id)
            ON DELETE SET NULL
);

-- MESSAGE_ATTACHMENTS
CREATE TABLE message_attachments
(
    message_id    UUID,
    attachment_id UUID,
    CONSTRAINT fk_message_attachments_message
        FOREIGN KEY (message_id)
            REFERENCES messages (message_id)
            ON DELETE CASCADE,
    CONSTRAINT fk_message_attachments_binary_content
        FOREIGN KEY (attachment_id)
            REFERENCES binary_contents (binary_content_id)
            ON DELETE CASCADE
);

-- READ_STATUSES
CREATE TABLE read_statuses
(
    read_status_id UUID,
    created_at     TIMESTAMP NOT NULL,
    updated_at     TIMESTAMP,
    user_id        UUID,
    channel_id     UUID,
    last_read_at   TIMESTAMP NOT NULL,
    CONSTRAINT pk_read_statuses_id PRIMARY KEY (read_status_id),
    CONSTRAINT fk_read_statuses_users
        FOREIGN KEY (user_id)
            REFERENCES users (user_id)
            ON DELETE CASCADE,
    CONSTRAINT fk_read_statuses_channels
        FOREIGN KEY (channel_id)
            REFERENCES channels (channel_id)
            ON DELETE CASCADE
);
