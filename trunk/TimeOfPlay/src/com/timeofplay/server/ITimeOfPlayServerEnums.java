package com.timeofplay.server;

import com.greatlogic.glbase.gldb.GLDBException;
import com.greatlogic.glbase.gldb.GLDBUtil;
import com.greatlogic.glbase.gldb.IGLColumn;
import com.greatlogic.glbase.gldb.IGLTable;
import com.greatlogic.glbase.glxml.IGLXMLAttributeEnum;

public interface ITimeOfPlayServerEnums {
//--------------------------------------------------------------------------------------------------
public enum ETimeOfPlayConfigAttribute implements IGLXMLAttributeEnum {
// configuration attributes
} // enum ETimeOfPlayConfigAttribute
//--------------------------------------------------------------------------------------------------
public enum ETimeOfPlaySequence {
CircleId(1),
CircleUserId(2),
UserId(3);
private final int _dbSequenceId;
private ETimeOfPlaySequence(final int dbSequenceId) {
  _dbSequenceId = dbSequenceId;
} // enum ETimeOfPlaySequence
public int getDBSequenceId() {
  return _dbSequenceId;
} // getDBSequenceId()
public int getNextValue(final int numberOfValues) throws GLDBException {
  return (int)GLDBUtil.getNextSequenceValue(name(), ETimeOfPlayTable.DBSequence,
                                            DBSequenceCol.NextValue, DBSequenceCol.DBSequenceId +
                                                                     "=" + _dbSequenceId,
                                            numberOfValues);
} // getNextValue()
} // enum ETimeOfPlaySequence
//--------------------------------------------------------------------------------------------------
public enum ETimeOfPlayTable implements IGLTable {
Circle(CircleCol.class),
CircleUser(CircleUserCol.class),
DBSequence(DBSequenceCol.class),
User(UserCol.class);
private final Class<? extends Enum<?>> _columnEnumClass;
private ETimeOfPlayTable(final Class<? extends Enum<?>> columnEnumClass) {
  _columnEnumClass = columnEnumClass;
  GLDBUtil.registerTable(this);
} // ETimeOfPlayTable()
@Override
public String getAbbrev() {
  return _columnEnumClass.getSimpleName();
} // getAbbrev()
@Override
public Class<? extends Enum<?>> getColumnEnumClass() {
  return _columnEnumClass;
} // getColumnEnumClass()
@Override
public String getDataSourceName() {
  return null;
} // getDataSourceName()
} // enum ETimeOfPlayTable
//--------------------------------------------------------------------------------------------------
public enum CircleCol implements IGLColumn {
CircleDesc,
CircleId,
CircleName,
UserId,
Version
} // enum CircleCol
//--------------------------------------------------------------------------------------------------
public enum CircleUserCol implements IGLColumn {
CircleId,
CircleUserId,
MemberUserId,
Version
} // enum CircleUserCol
//--------------------------------------------------------------------------------------------------
public enum DBSequenceCol implements IGLColumn {
DBSequenceId,
NextValue
} // enum DBSequenceCol
//--------------------------------------------------------------------------------------------------
public enum UserCol implements IGLColumn {
PasswordHash,
RegistrationDate,
ScreenName,
UserId,
UserLoginId,
Version
} // enum UserCol
//--------------------------------------------------------------------------------------------------
}