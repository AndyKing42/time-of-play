package com.timeofplay.shared;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.timeofplay.client.model.IUserProxy;
import com.timeofplay.server.model.dao.IUserDAO;
import com.timeofplay.server.model.dao.UserDAOLocator;
import java.util.List;

@Service(value = IUserDAO.class, locator = UserDAOLocator.class)
public interface IUserRequestContext extends RequestContext {
//--------------------------------------------------------------------------------------------------
Request<IUserProxy> findById(final Integer userId);
Request<IUserProxy> findByUserIdAndPassword(final String userId, final String password);
Request<Integer> save(final IUserProxy user);
Request<List<IUserProxy>> selectAllUsers();
//--------------------------------------------------------------------------------------------------
}