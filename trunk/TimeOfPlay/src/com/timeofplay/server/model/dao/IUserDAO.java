package com.timeofplay.server.model.dao;

import com.timeofplay.server.model.dto.User;
import java.util.List;

public interface IUserDAO {
//--------------------------------------------------------------------------------------------------
public User findById(final Integer id);
public User findByUserIdAndPassword(final String userId, final String password);
public Integer save(final User user);
public List<User> selectAllUsers();
//--------------------------------------------------------------------------------------------------
}