package com.timeofplay.server.model.dto;

import com.greatlogic.glbase.gldb.GLDBException;
import com.greatlogic.glbase.gldb.GLSQL;
import com.timeofplay.server.ITimeOfPlayServerEnums.CircleUserCol;
import com.timeofplay.server.ITimeOfPlayServerEnums.UserCol;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CircleUser {
//--------------------------------------------------------------------------------------------------
@Column(name = "CircleId", nullable = false)
private int     _circleId;
@Column(name = "CircleUserId", nullable = false, unique = true)
@Id
private Integer _circleUserId;
@Column(name = "MemberUserId", nullable = false)
private Integer _memberUserId;
@Column(name = "Version", nullable = false)
private Integer _version;
//--------------------------------------------------------------------------------------------------
public CircleUser() {
  // used by the GWT request factory
} // User()
//--------------------------------------------------------------------------------------------------
public CircleUser(final GLSQL circleUserSQL) throws GLDBException {
  this(circleUserSQL.asInt(CircleUserCol.CircleUserId),
       circleUserSQL.asInt(CircleUserCol.CircleId),
       circleUserSQL.asInt(CircleUserCol.MemberUserId), circleUserSQL.asInt(UserCol.Version));
} // User()
//--------------------------------------------------------------------------------------------------
public CircleUser(final int circleUserId, final int circleId, final int memberUserId,
                  final int version) {
  setId(circleUserId);
  setCircleId(circleId);
  setMemberUserId(memberUserId);
  setVersion(version);
} // User()
//--------------------------------------------------------------------------------------------------
public int getCircleId() {
  return _circleId;
} // getCircleId()
//--------------------------------------------------------------------------------------------------
public int getId() {
  return _circleUserId;
} // getId()
//--------------------------------------------------------------------------------------------------
public int getMemberUserId() {
  return _memberUserId;
} // getMemberUserId()
//--------------------------------------------------------------------------------------------------
public int getVersion() {
  return _version;
} // getVersion()
//--------------------------------------------------------------------------------------------------
public void setCircleId(final Integer circleId) {
  _circleId = circleId;
} // setCircleId()
//--------------------------------------------------------------------------------------------------
public void setId(final Integer circleUserId) {
  _circleUserId = circleUserId;
} // setId()
//--------------------------------------------------------------------------------------------------
public void setMemberUserId(final Integer memberUserId) {
  _memberUserId = memberUserId;
} // setMemberUserId()
//--------------------------------------------------------------------------------------------------
public void setVersion(final Integer version) {
  _version = version;
} // setVersion()
//--------------------------------------------------------------------------------------------------
@Override
public String toString() {
  return "CircleUserId:" + _circleUserId + " CircleId:" + _circleId + " MemberUserId:" +
         _memberUserId + " Version:" + _version;
} // toString()
//--------------------------------------------------------------------------------------------------
}