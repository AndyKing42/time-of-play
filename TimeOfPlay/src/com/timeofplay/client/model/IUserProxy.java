package com.timeofplay.client.model;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.timeofplay.server.model.dto.User;
import com.timeofplay.server.model.dto.UserLocator;

@ProxyFor(value = User.class, locator = UserLocator.class)
public interface IUserProxy extends EntityProxy {
//--------------------------------------------------------------------------------------------------
String getScreenName();
String getUserLoginId();
int getUserId();
int getVersion();
//--------------------------------------------------------------------------------------------------
void setScreenName(final String screenName);
void setUserId(final Integer userId);
void setUserLoginId(final String userLoginId);
void setVersion(final Integer version);
//--------------------------------------------------------------------------------------------------
}