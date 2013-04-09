package com.timeofplay.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.greatlogic.glbase.gllib.GLLog;
import com.timeofplay.server.model.dao.UserDAOLocator;
import com.timeofplay.server.model.dto.User;
import com.timeofplay.shared.IRemoteService;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class TimeOfPlayRemoteServiceServlet extends RemoteServiceServlet implements IRemoteService {
//--------------------------------------------------------------------------------------------------
/**
 * Attempts to log in using the supplied user id and password.
 * @param userId The user id that will be used for the login attempt.
 * @param password The password that will be used for the login attempt (this is the plain text
 * password, not the encrypted hash value).
 * @return The id of the User row, or zero if the login request fails.
 */
@Override
public Integer login(final String userId, final String password) {
  Integer result;
  final User user = UserDAOLocator.getUserDAO().findByUserIdAndPassword(userId, password);
  if (user == null) {
    GLLog.infoSummary("Login failed for userId:" + userId);
    result = 0;
  }
  else {
    result = user.getId();
    GLLog.infoSummary("Login succeeded for userId:" + userId);
    final HttpSession session = getThreadLocalRequest().getSession();
    session.setAttribute("User", user);
  }
  return result;
} // login()
//--------------------------------------------------------------------------------------------------
}