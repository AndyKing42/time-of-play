package com.timeofplay.client;

import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.timeofplay.shared.IUserRequestContext;

public interface IRequestFactory extends RequestFactory {
//--------------------------------------------------------------------------------------------------
IUserRequestContext newUserRequestContext();
//--------------------------------------------------------------------------------------------------
}