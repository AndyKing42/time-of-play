package com.timeofplay.server;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.timeofplay.server.model.dto.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class TimeOfPlayRequestFactoryServlet extends RequestFactoryServlet {
//--------------------------------------------------------------------------------------------------
@Override
protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
  throws IOException, ServletException {
  if (!userIsLoggedIn(request)) {
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
  }
  else {
    super.doPost(request, response);
  }
} // doPost()
//--------------------------------------------------------------------------------------------------
private boolean userIsLoggedIn(final HttpServletRequest request) {
  boolean result = false;
  final HttpSession session = request.getSession();
  if (session != null) {
    final User user = (User)session.getAttribute("User");
    result = user != null;
  }
  return result;
} // userIsLoggedIn()
//--------------------------------------------------------------------------------------------------
}