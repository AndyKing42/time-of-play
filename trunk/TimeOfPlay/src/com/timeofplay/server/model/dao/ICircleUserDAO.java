package com.timeofplay.server.model.dao;

import com.timeofplay.server.model.dto.CircleUser;

public interface ICircleUserDAO {
//--------------------------------------------------------------------------------------------------
public CircleUser findById(final Integer circleUserId);
public Integer save(final CircleUser circleUser);
//--------------------------------------------------------------------------------------------------
}