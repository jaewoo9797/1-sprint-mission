package com.sprint.mission.discodeit.dbconnect;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void writeHereTestName() {
        // given
        try (Connection connection = dataSource.getConnection()) {
            assertThat(connection).isNotNull();
            assertThat(connection.isClosed()).isFalse();

            System.out.println("Database Product Name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("Database URL: " + connection.getMetaData().getURL());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // when

        // then
    }

}
