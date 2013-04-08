package com.timeofplay.client.cache;

import com.timeofplay.client.IClientFactory;

public class TimeOfPlayCache {
//--------------------------------------------------------------------------------------------------
private IClientFactory _clientFactory;
//--------------------------------------------------------------------------------------------------
public void initialize(final IClientFactory clientFactory) {
  _clientFactory = clientFactory;
} // initialize()
//--------------------------------------------------------------------------------------------------
}