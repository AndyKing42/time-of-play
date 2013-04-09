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
UserId(1);
private final int _id;
private ETimeOfPlaySequence(final int id) {
  _id = id;
} // enum ETimeOfPlaySequence
public int getId() {
  return _id;
} // getId()
public int getNextValue(final int numberOfValues) throws GLDBException {
  return (int)GLDBUtil.getNextSequenceValue(name(), ETimeOfPlayTable.DBSequence,
                                            DBSequenceCol.NextValue, DBSequenceCol.Id + "=" + _id,
                                            numberOfValues);
} // getNextValue()
} // enum ETimeOfPlaySequence
//--------------------------------------------------------------------------------------------------
public enum ETimeOfPlayTable implements IGLTable {
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
public enum DBSequenceCol implements IGLColumn {
Id,
NextValue
} // enum DBSequenceCol
//--------------------------------------------------------------------------------------------------
public enum UserCol implements IGLColumn {
Id,
PasswordHash,
UserId,
Version
} // enum UserCol
//--------------------------------------------------------------------------------------------------
}