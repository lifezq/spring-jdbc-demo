package com.yql.springjdbc.repository;

import com.yql.springjdbc.mapper.UsersMapper;
import com.yql.springjdbc.model.Users;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Package com.yql.springjdbc.repository
 * @ClassName UserRepository
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/28
 */
@Repository
public class UserRepository {
    private static JdbcTemplate jdbcTemplate;
    private final RowMapper<Users> usersRowMapper = new UsersMapper();

    static {
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .username("sa")
                .type(JdbcDataSource.class)
                .url("jdbc:h2:mem:jdbc-demo").build();
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Users> findAll() {
        return jdbcTemplate.query("select * from users", usersRowMapper);
    }

    public Users findById(Long id) {
        return jdbcTemplate.queryForObject("select * from users where id=?", usersRowMapper, id);
    }

    public Users save(Users users) {
        String sql = String.format("insert into users values(%d,'%s','%s',%d,'%s',%f,'%s')",
                users.getId(), users.getName(), users.getAddress(), users.getAge(),
                users.getGender(), users.getSalary(), users.getCreated());
        jdbcTemplate.execute(sql);
        return users;
    }

    public void saveAll(List<Users> users) {
        users.forEach(this::save);
    }

    public void delete(Long id) {
        jdbcTemplate.execute("delete from users where id=" + id);
    }

    public Long getNextId() {
        Long maxId = jdbcTemplate.queryForObject("select max(id) as id from users", Long.class);
        if (maxId == null) {
            return 0L;
        }
        return maxId + 1;
    }

    public Users update(Users users) {
        jdbcTemplate.execute(String.format(
                "update users set name='%s',address='%s',age=%d,gender='%s',salary=%f where id=%d",
                users.getName(), users.getAddress(), users.getAge(), users.getGender(),
                users.getSalary(), users.getId()
        ));
        return users;
    }
}
