package com.timeofplay.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.timeofplay.client.IClientFactory;

public class EventsTabPanel extends Composite {
//--------------------------------------------------------------------------------------------------
//==================================================================================================
interface IEventsTabPanelBinder extends UiBinder<Widget, EventsTabPanel> { //
} // interface IEventsTabPanelBinder
//==================================================================================================
public EventsTabPanel(final IClientFactory clientFactory) {
  final IEventsTabPanelBinder binder = GWT.create(IEventsTabPanelBinder.class);
  initWidget(binder.createAndBindUi(this));
} // EventsTabPanel()
//--------------------------------------------------------------------------------------------------
}