package com.timeofplay.server;

import com.greatlogic.glbase.gllib.GLUtil;
import com.greatlogic.glbase.gllib.IGLProgram;
import com.timeofplay.server.model.dao.UserDAOLocator;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TimeOfPlayServletContextListener implements ServletContextListener {
//==================================================================================================
private static class TimeOfPlayProgram implements IGLProgram {
@Override
public boolean displayCommandLineHelp() {
  return false;
} // displayCommandLineHelp()
} // class TimeOfPlayProgram
//==================================================================================================
@Override
public void contextDestroyed(final ServletContextEvent event) {
  //
} // contextDestroyed()
//--------------------------------------------------------------------------------------------------
@Override
public void contextInitialized(final ServletContextEvent event) {
  final String configFilename = event.getServletContext().getInitParameter("ConfigFilename");
  GLUtil.initializeProgram(new TimeOfPlayProgram(), null, null, //
                           "<args ConfigFilename='" + configFilename + "'/>");
  initializeDAOs();
} // contextInitialized()
//--------------------------------------------------------------------------------------------------
private void initializeDAOs() {
  UserDAOLocator.getUserDAO();
} // initializeDAOs()
//--------------------------------------------------------------------------------------------------
}