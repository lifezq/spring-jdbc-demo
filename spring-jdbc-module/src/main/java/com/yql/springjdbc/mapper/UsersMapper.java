package com.yql.springjdbc.mapper;

import com.yql.springjdbc.model.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Package com.yql.springjdbc.mapper
 * @ClassName UsersMapper
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/28
 */
public class UsersMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users users = new Users();
        users.setId(Integer.valueOf(rs.getInt("id")).longValue());
        users.setName(rs.getString("name"));
        users.setAddress(rs.getString("address"));
        users.setAge(rs.getInt("age"));
        users.setGender(rs.getString("gender"));
        users.setSalary(rs.getDouble("salary"));
        users.setCreated(LocalDateTime.from(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnn")
                        .parse(rs.getString("created"))));
        return users;
    }
}
