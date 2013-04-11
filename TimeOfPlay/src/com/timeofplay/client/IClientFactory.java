package com.timeofplay.client;

import com.google.web.bindery.event.shared.EventBus;
import com.timeofplay.client.cache.TimeOfPlayCache;
import com.timeofplay.client.view.TimeOfPlayView;
import com.timeofplay.client.widget.AccountTabPanel;
import com.timeofplay.client.widget.CirclesTabPanel;
import com.timeofplay.client.widget.EventsTabPanel;
import com.timeofplay.shared.IRemoteServiceAsync;

public interface IClientFactory {
//--------------------------------------------------------------------------------------------------
AccountTabPanel getAccountTabPanel();
CirclesTabPanel getCirclesTabPanel();
EventBus getEventBus();
EventsTabPanel getEventsTabPanel();
IRemoteServiceAsync getRemoteServiceAsync();
IRequestFactory getRequestFactory();
RequestFactoryResender getRequestFactoryResender();
TimeOfPlayCache getTimeOfPlayCache();
TimeOfPlayView getTimeOfPlayView();
void initialize(final EventBus eventBus, final IRemoteServiceAsync remoteServiceAsync,
                final IRequestFactory requestFactory, final TimeOfPlayCache timeOfPlayCache);
void login();
void setRequestFactoryResender(final RequestFactoryResender requestFactoryResender);
//--------------------------------------------------------------------------------------------------
}