package com.timeofplay.client.model;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.timeofplay.server.model.dto.CircleUser;
import com.timeofplay.server.model.dto.CircleUserLocator;

@ProxyFor(value = CircleUser.class, locator = CircleUserLocator.class)
public interface ICircleUserProxy extends EntityProxy {
//--------------------------------------------------------------------------------------------------
int getCircleId();
int getId();
int getMemberUserId();
IUserProxy getMemberUser();
int getVersion();
//--------------------------------------------------------------------------------------------------
void setCircleId(final Integer circleId);
void setId(final Integer circleUserId);
void setMemberUserId(final Integer memberUserId);
void setVersion(final Integer version);
//--------------------------------------------------------------------------------------------------
}