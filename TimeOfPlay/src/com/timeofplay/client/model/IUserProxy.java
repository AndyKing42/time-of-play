package com.timeofplay.client.model;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.timeofplay.server.model.dto.User;
import com.timeofplay.server.model.dto.UserLocator;

@ProxyFor(value = User.class, locator = UserLocator.class)
public interface IUserProxy extends EntityProxy {
//--------------------------------------------------------------------------------------------------
int getId();
String getScreenName();
String getUserId();
int getVersion();
//--------------------------------------------------------------------------------------------------
void setId(final Integer id);
void setScreenName(final String screenName);
void setUserId(final String userId);
void setVersion(final Integer version);
//--------------------------------------------------------------------------------------------------
}