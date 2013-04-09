package com.timeofplay.client.cache;

import com.google.gwt.user.client.Random;
import com.timeofplay.client.IClientFactory;
import com.timeofplay.client.model.IUserProxy;
import com.timeofplay.shared.IUserRequestContext;

public class TimeOfPlayCache {
//--------------------------------------------------------------------------------------------------
private IClientFactory _clientFactory;
//--------------------------------------------------------------------------------------------------
public void initialize(final IClientFactory clientFactory) {
  _clientFactory = clientFactory;
} // initialize()
//--------------------------------------------------------------------------------------------------
public final IUserProxy newUser(final IUserRequestContext userRequestContext) {
  final IUserProxy result = userRequestContext.create(IUserProxy.class);
  {
  } // the id should be set by from a call to the server
  final int id = Random.nextInt(10000);
  result.setId(id);
  result.setVersion(0);
  return result;
} // newUser()
//--------------------------------------------------------------------------------------------------
}