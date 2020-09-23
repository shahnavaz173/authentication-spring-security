package com.saiyad.auth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private List<User> users;
	
	public User findUserByName(String userName){
		String sql = "SELECT * FROM user WHERE username='"+userName+"'";
		User user = null;
		try{
			user = jdbcTemplate.queryForObject(sql, new UserRowMapper());	
		}catch(EmptyResultDataAccessException e){
			System.out.println(e.getMessage());
		}
		return user;
	}
	public void createUser(User user){
		String sql = "INSERT INTO user (username,password) VALUES ('"
										+user.getUsername()+"','"
										+user.getPassword()+"')";
		jdbcTemplate.update(sql);
	}

	public boolean isUserExists(String username) {
		User user = findUserByName(username);
		if(Objects.isNull(user))
			return false;
		return true;
	}
	
	class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		
	}

}
