package com.timeofplay.shared;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.timeofplay.client.model.ICircleUserProxy;
import com.timeofplay.server.model.dao.CircleUserDAOLocator;
import com.timeofplay.server.model.dao.ICircleUserDAO;

@Service(value = ICircleUserDAO.class, locator = CircleUserDAOLocator.class)
public interface ICircleUserRequestContext extends RequestContext {
//--------------------------------------------------------------------------------------------------
Request<ICircleUserProxy> findById(final Integer circleUserId);
Request<Integer> save(final ICircleUserProxy circleUser);
//--------------------------------------------------------------------------------------------------
}