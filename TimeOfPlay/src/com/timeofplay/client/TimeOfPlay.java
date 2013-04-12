package com.timeofplay.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.timeofplay.client.cache.TimeOfPlayCache;
import com.timeofplay.client.view.TimeOfPlayView;
import com.timeofplay.shared.IRemoteService;
import com.timeofplay.shared.IRemoteServiceAsync;

public class TimeOfPlay implements EntryPoint {
//--------------------------------------------------------------------------------------------------
@Override
public void onModuleLoad() {
  final SimpleEventBus eventBus = new SimpleEventBus();
  final IRemoteServiceAsync remoteServiceAsync = (IRemoteServiceAsync)GWT.create(IRemoteService.class);
  final IRequestFactory requestFactory = GWT.create(IRequestFactory.class);
  requestFactory.initialize(eventBus, new TimeOfPlayRequestTransport());
  final TimeOfPlayCache timeOfPlayCache = new TimeOfPlayCache();
  final IClientFactory clientFactory = GWT.create(UIClientFactory.class);
  clientFactory.initialize(eventBus, remoteServiceAsync, requestFactory, timeOfPlayCache);
  timeOfPlayCache.initialize(clientFactory);
  Window.addWindowClosingHandler(new Window.ClosingHandler() {
    @Override
    public void onWindowClosing(final ClosingEvent event) {
      event.setMessage("Is it okay to close?");
    } // onWindowClosing()
  });
  final TimeOfPlayView timeOfPlayView = new TimeOfPlayView();
  timeOfPlayView.initialize(clientFactory);
  RootLayoutPanel.get().add(timeOfPlayView.getOuterPanel());
  //  final TestLayout testLayout = new TestLayout();
  //  testLayout.initialize();
  //  RootLayoutPanel.get().add(testLayout.getOuterPanel());
} // onModuleLoad()
//--------------------------------------------------------------------------------------------------
}