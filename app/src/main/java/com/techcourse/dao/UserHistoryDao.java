package com.techcourse.dao;

import com.techcourse.domain.UserHistory;
import java.time.LocalDateTime;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserHistoryDao {

    private final JdbcTemplate jdbcTemplate;

    public UserHistoryDao(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public UserHistoryDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void log(final UserHistory userHistory) {
        final var sql = "insert into user_history (user_id, account, password, email, created_at, created_by) values (?, ?, ?, ?, ?, ?)";
        final long userId = userHistory.getUserId();
        final String account = userHistory.getAccount();
        final String password = userHistory.getPassword();
        final String email = userHistory.getEmail();
        final LocalDateTime createdAt = userHistory.getCreatedAt();
        final String createBy = userHistory.getCreateBy();
        jdbcTemplate.update(sql, userId, account, password, email, createdAt, createBy);
    }
}
