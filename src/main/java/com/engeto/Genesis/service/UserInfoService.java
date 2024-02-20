package com.engeto.Genesis.service;

import com.engeto.Genesis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class UserInfoService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<UserInfo> getAllUsers(boolean detail) {
        return jdbcTemplate.query("SELECT * FROM users", new RowMapper<UserInfo>() {

            public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(rs.getLong("ID"));
                userInfo.setName(rs.getString("name"));
                userInfo.setSurname(rs.getString("surname"));
                if (detail) {
                    userInfo.setPersonID(rs.getString("personID"));
                    userInfo.setUuid(rs.getString("Uuid"));
                }
                return userInfo;
            }
        });
    }

    public UserInfo getUserById(long id, boolean detail) {
        String sql = "SELECT * from users WHERE id = " + id;

        try {
            return (UserInfo) jdbcTemplate.queryForObject(sql, new RowMapper<Object>() {
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setId(rs.getLong("ID"));
                    userInfo.setName(rs.getString("name"));
                    userInfo.setSurname(rs.getString("surname"));
                    if (detail) {
                        userInfo.setPersonID(rs.getString("personID"));
                        userInfo.setUuid(rs.getString("Uuid"));
                    }
                    return userInfo;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public UserInfo createNewUser(UserInfo userInfo) {
        UUID uuid = UUID.randomUUID();
        userInfo.setUuid(String.valueOf(uuid));

        if (userInfo.getPersonID().length() != 12) {
            return null;
        }

        if (checkNewUser(userInfo.getPersonID(), userInfo.getUuid())) {
            return null;
        } else {
            jdbcTemplate.update("INSERT into users (name,surname,personID,Uuid) VALUES (?,?,?,?)", userInfo.getName(), userInfo.getSurname(), userInfo.getPersonID(), userInfo.getUuid());
            return userInfo;
        }
    }

    public boolean deleteUser(long id) {
        return jdbcTemplate.update("DELETE from users where id = ?", id) > 0;
    }

    public boolean checkNewUser(String personID, String uuid) {
        boolean containsPersonID = false;
        boolean containsUuID = false;

        String sqlPersonID = "select EXISTS (SELECT personID FROM users WHERE personID = ?)";
        Integer personIdExists = jdbcTemplate.queryForObject(sqlPersonID, Integer.class, personID);

        if (personIdExists != null) {
            containsPersonID = personIdExists == 1;
        }

        String sqlUuid = "select EXISTS (SELECT personID FROM users WHERE Uuid = ?)";
        Integer uuIdExists = jdbcTemplate.queryForObject(sqlUuid, Integer.class, uuid);
        if (uuIdExists != null) {
            containsUuID = uuIdExists == 1;
        }

        return containsPersonID || containsUuID;
    }

    public void updateUser(long id, UserInfo userInfo) {
        jdbcTemplate.update("update users set name = ? , surname = ? where id = ?", userInfo.getName(), userInfo.getSurname(), id);
    }
}

