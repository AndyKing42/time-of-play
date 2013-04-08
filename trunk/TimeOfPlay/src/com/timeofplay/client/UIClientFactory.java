package com.timeofplay.client;

import com.google.web.bindery.event.shared.EventBus;
import com.timeofplay.client.cache.TimeOfPlayCache;
import com.timeofplay.client.view.TimeOfPlayView;
import com.timeofplay.client.widget.LoginWidget;
import com.timeofplay.shared.IRemoteServiceAsync;

public class UIClientFactory implements IClientFactory {
//--------------------------------------------------------------------------------------------------
private EventBus               _eventBus;
private LoginWidget            _loginWidget;
private IRemoteServiceAsync    _remoteServiceAsync;
private IRequestFactory        _requestFactory;
private RequestFactoryResender _requestFactoryResender;
private TimeOfPlayCache        _timeOfPlayCache;
private TimeOfPlayView         _timeOfPlayView;
//--------------------------------------------------------------------------------------------------
@Override
public EventBus getEventBus() {
  return _eventBus;
} // getEventBus()
//--------------------------------------------------------------------------------------------------
@Override
public IRemoteServiceAsync getRemoteServiceAsync() {
  return _remoteServiceAsync;
} // getRemoteServiceAsync()
//--------------------------------------------------------------------------------------------------
@Override
public IRequestFactory getRequestFactory() {
  return _requestFactory;
} // getRequestFactory()
//--------------------------------------------------------------------------------------------------
@Override
public RequestFactoryResender getRequestFactoryResender() {
  return _requestFactoryResender;
} // getRequestFactoryResender()
//--------------------------------------------------------------------------------------------------
@Override
public TimeOfPlayCache getTimeOfPlayCache() {
  return _timeOfPlayCache;
} // getTimeOfPlayCache()
//--------------------------------------------------------------------------------------------------
@Override
public TimeOfPlayView getTimeOfPlayView() {
  if (_timeOfPlayView == null) {
    _timeOfPlayView = new TimeOfPlayView();
    _timeOfPlayView.initialize(this);
  }
  return _timeOfPlayView;
} // getTimeOfPlayView()
//--------------------------------------------------------------------------------------------------
@Override
public void initialize(final EventBus eventBus, final IRemoteServiceAsync remoteServiceAsync,
                       final IRequestFactory requestFactory, final TimeOfPlayCache timeOfPlayCache) {
  _eventBus = eventBus;
  _remoteServiceAsync = remoteServiceAsync;
  _requestFactory = requestFactory;
  ((TOPRequestTransport)_requestFactory.getRequestTransport()).initialize(this);
  _timeOfPlayCache = timeOfPlayCache;
} // initialize()
//--------------------------------------------------------------------------------------------------
@Override
public void login() {
  if (_loginWidget == null) {
    _loginWidget = new LoginWidget(this);
  }
  _loginWidget.login();
} // login()
//--------------------------------------------------------------------------------------------------
@Override
public void setRequestFactoryResender(final RequestFactoryResender requestFactoryResender) {
  _requestFactoryResender = requestFactoryResender;
} // setRequestFactoryResender()
//--------------------------------------------------------------------------------------------------
}