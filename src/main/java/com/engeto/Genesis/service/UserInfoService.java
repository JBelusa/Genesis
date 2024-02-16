package com.engeto.Genesis.service;

import com.engeto.Genesis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
    }


    public UserInfo createNewUser(UserInfo userInfo) {
        jdbcTemplate.update("INSERT into users (name,surname,personID,Uuid) VALUES (?,?,?,?)", userInfo.getName(), userInfo.getSurname(), userInfo.getPersonID(), userInfo.getUuid());
        return userInfo;
    }


    public ResponseEntity<String> deleteUser(long id) {
        boolean deletionSuccessful = jdbcTemplate.update("DELETE from users where id = ?", id) > 0;
        if (deletionSuccessful) {
            return new ResponseEntity<>("Uživatel s id " + id + " byl úspěšně vymazán.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Uživatele s id " + id + " nelze vymazat - nenachází se v databázi.", HttpStatus.BAD_REQUEST);
        }

    }

    public String getStreetNameById(String personID) {

        String sql = "SELECT personID FROM users WHERE personID=?";

        String streetName = (String) jdbcTemplate.queryForObject(sql, String.class,personID);

        return streetName;
    }


}

