package com.timeofplay.client;

import com.google.web.bindery.event.shared.EventBus;
import com.timeofplay.client.cache.TimeOfPlayCache;
import com.timeofplay.client.view.TimeOfPlayView;
import com.timeofplay.shared.IRemoteServiceAsync;

public interface IClientFactory {
//--------------------------------------------------------------------------------------------------
EventBus getEventBus();
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