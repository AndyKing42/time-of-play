package com.timeofplay.server.model.dto;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.timeofplay.server.model.dao.UserDAOLocator;

public class UserLocator extends Locator<User, Integer> {
//--------------------------------------------------------------------------------------------------
@Override
public User create(final Class<? extends User> clazz) {
  return new User();
} // create()
//--------------------------------------------------------------------------------------------------
@Override
public User find(final Class<? extends User> clazz, final Integer id) {
  return UserDAOLocator.getUserDAO().findById(id);
} // find()
//--------------------------------------------------------------------------------------------------
@Override
public Class<User> getDomainType() {
  return User.class;
} // getDomainType()
//--------------------------------------------------------------------------------------------------
@Override
public Integer getId(final User user) {
  return user.getId();
} // getId()
//--------------------------------------------------------------------------------------------------
@Override
public Class<Integer> getIdType() {
  return Integer.class;
} // getIdType()
//--------------------------------------------------------------------------------------------------
@Override
public Object getVersion(final User user) {
  return user.getVersion();
} // getVersion()
//--------------------------------------------------------------------------------------------------
@Override
public boolean isLive(final User user) {
  return true;
} // isLive()
//--------------------------------------------------------------------------------------------------
}