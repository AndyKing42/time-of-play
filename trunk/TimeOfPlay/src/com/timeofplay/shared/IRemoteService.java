package com.timeofplay.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("TimeOfPlay")
public interface IRemoteService extends RemoteService {
//--------------------------------------------------------------------------------------------------
Integer login(final String userId, final String password);
//--------------------------------------------------------------------------------------------------
}