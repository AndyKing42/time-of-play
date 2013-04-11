package com.timeofplay.server.model.dao;

import com.greatlogic.glbase.gldb.GLDBEnums.EGLDBOp;
import com.greatlogic.glbase.gldb.GLDBException;
import com.greatlogic.glbase.gldb.GLSQL;
import com.greatlogic.glbase.gllib.GLLog;
import com.timeofplay.server.ITimeOfPlayServerEnums.CircleUserCol;
import com.timeofplay.server.ITimeOfPlayServerEnums.ETimeOfPlaySequence;
import com.timeofplay.server.ITimeOfPlayServerEnums.ETimeOfPlayTable;
import com.timeofplay.server.ITimeOfPlayServerEnums.UserCol;
import com.timeofplay.server.model.dto.CircleUser;

public class CircleUserDAO implements ICircleUserDAO {
//--------------------------------------------------------------------------------------------------
private static CircleUserDAO _circleUserDAO;
//--------------------------------------------------------------------------------------------------
static CircleUserDAO getInstance() {
  if (_circleUserDAO == null) {
    _circleUserDAO = new CircleUserDAO();
  }
  return _circleUserDAO;
} // getInstance()
//--------------------------------------------------------------------------------------------------
@Override
public CircleUser findById(final Integer circleUserId) {
  CircleUser result = null;
  try {
    final GLSQL circleUserSQL = GLSQL.select();
    circleUserSQL.from(ETimeOfPlayTable.CircleUser);
    circleUserSQL.whereAnd(CircleUserCol.CircleUserId, EGLDBOp.Equals, circleUserId);
    circleUserSQL.open();
    try {
      if (circleUserSQL.next()) {
        result = new CircleUser(circleUserSQL);
      }
    }
    finally {
      circleUserSQL.close();
    }
  }
  catch (final GLDBException dbe) {
    GLLog.major("Error attempting to get circle user id:" + circleUserId, dbe);
  }
  return result;
} // findById()
//--------------------------------------------------------------------------------------------------
/**
 * Saves a circle user.
 * @return For a new circle user this will be a new id; for an existing circle user this will be the
 * same as the circleUserId that was in the supplied CircleUser object.
 */
@Override
public Integer save(final CircleUser circleUser) {
  int result = circleUser.getId();
  try {
    GLSQL circleUserSQL;
    if (circleUser.getId() == 0) {
      result = ETimeOfPlaySequence.CircleUserId.getNextValue(1);
      circleUserSQL = GLSQL.insert(ETimeOfPlayTable.CircleUser, false);
      circleUserSQL.setValue(CircleUserCol.CircleUserId, result);
    }
    else {
      circleUserSQL = GLSQL.update(ETimeOfPlayTable.User);
      circleUserSQL.whereAnd(UserCol.UserId, EGLDBOp.Equals, result);
    }
    circleUserSQL.setValue(UserCol.UserId, circleUser.getId());
    circleUserSQL.setValue(UserCol.Version, circleUser.getVersion());
    circleUserSQL.execute();
  }
  catch (final GLDBException dbe) {
    GLLog.major("Update failed for circle user:" + circleUser, dbe);
  }
  return result;
} // save()
//--------------------------------------------------------------------------------------------------
}