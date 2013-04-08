package com.timeofplay.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IRemoteServiceAsync {
//--------------------------------------------------------------------------------------------------
void login(String userId, String password, AsyncCallback<Integer> callback);
//--------------------------------------------------------------------------------------------------
}