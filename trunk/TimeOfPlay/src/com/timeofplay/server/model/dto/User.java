package com.timeofplay.server.model.dto;

import com.greatlogic.glbase.gldb.GLDBException;
import com.greatlogic.glbase.gldb.GLSQL;
import com.timeofplay.server.ITimeOfPlayServerEnums.UserCol;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
//--------------------------------------------------------------------------------------------------
@Column(length = 200, name = "PasswordHash", nullable = false)
private String  _passwordHash;
@Column(length = 50, name = "ScreenName", nullable = false)
private String  _screenName;
@Column(name = "UserId", nullable = false, unique = true)
@Id
private Integer _userId;
@Column(length = 50, name = "UserLoginId", nullable = false, unique = true)
private String  _userLoginId;
@Column(name = "Version", nullable = false)
private Integer _version;
//--------------------------------------------------------------------------------------------------
public User() {
  // used by the GWT request factory
} // User()
//--------------------------------------------------------------------------------------------------
public User(final GLSQL userSQL) throws GLDBException {
  this(userSQL.asInt(UserCol.UserId), userSQL.asString(UserCol.PasswordHash),
       userSQL.asString(UserCol.UserLoginId), userSQL.asString(UserCol.ScreenName),
       userSQL.asInt(UserCol.Version));
} // User()
//--------------------------------------------------------------------------------------------------
public User(final int userId, final String passwordHash, final String userLoginId,
            final String screenName, final int version) {
  setUserId(userId);
  setPasswordHash(passwordHash);
  setUserLoginId(userLoginId);
  setScreenName(screenName);
  setVersion(version);
} // User()
//--------------------------------------------------------------------------------------------------
public String getPasswordHash() {
  return _passwordHash;
} // getPasswordHash()
//--------------------------------------------------------------------------------------------------
public String getScreenName() {
  return _screenName;
} // getScreenName()
//--------------------------------------------------------------------------------------------------
public int getUserId() {
  return _userId;
} // getUserId()
//--------------------------------------------------------------------------------------------------
public String getUserLoginId() {
  return _userLoginId;
} // getUserLoginId()
//--------------------------------------------------------------------------------------------------
public int getVersion() {
  return _version;
} // getVersion()
//--------------------------------------------------------------------------------------------------
public void setPasswordHash(final String passwordHash) {
  _passwordHash = passwordHash;
} // setPasswordHash()
//--------------------------------------------------------------------------------------------------
public void setScreenName(final String screenName) {
  _screenName = screenName;
} // setScreenName()
//--------------------------------------------------------------------------------------------------
public void setUserId(final Integer userId) {
  _userId = userId;
} // setUserId()
//--------------------------------------------------------------------------------------------------
public void setUserLoginId(final String userLoginId) {
  _userLoginId = userLoginId;
} // setUserLoginId()
//--------------------------------------------------------------------------------------------------
public void setVersion(final Integer version) {
  _version = version;
} // setVersion()
//--------------------------------------------------------------------------------------------------
@Override
public String toString() {
  return "UserId:" + _userId + " UserLoginId:" + _userLoginId + " Version:" + _version;
} // toString()
//--------------------------------------------------------------------------------------------------
}