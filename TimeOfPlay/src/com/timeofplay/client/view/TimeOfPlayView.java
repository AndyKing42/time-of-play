package com.timeofplay.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.timeofplay.client.IClientFactory;

public class TimeOfPlayView extends Composite {
//--------------------------------------------------------------------------------------------------
@UiField
ResizeLayoutPanel      accountTabPanel;
@UiField
ResizeLayoutPanel      circlesTabPanel;
@UiField
ResizeLayoutPanel      eventsTabPanel;
@UiField
TabLayoutPanel         tabLayoutPanel;
@UiField
ResizeLayoutPanel      topLevelPanel;

private IClientFactory _clientFactory;
//==================================================================================================
public interface ITimeOfPlayViewUiBinder extends UiBinder<Widget, TimeOfPlayView> { //
} // interface ITimeOfPlayViewUiBinder
//==================================================================================================
public ResizeLayoutPanel getTopLevelPanel() {
  return topLevelPanel;
} // getTopLevelPanel()
//--------------------------------------------------------------------------------------------------
public void initialize(final IClientFactory clientFactory) {
  _clientFactory = clientFactory;
  final ITimeOfPlayViewUiBinder binder = GWT.create(ITimeOfPlayViewUiBinder.class);
  binder.createAndBindUi(this);
  accountTabPanel.add(_clientFactory.getAccountTabPanel());
} // initialize()
//--------------------------------------------------------------------------------------------------
@UiHandler("tabLayoutPanel")
public void onTabLayoutPanelSelection(final SelectionEvent<Integer> event) {
  switch (event.getSelectedItem()) {
    case 0:
      if (accountTabPanel.getWidget() == null) {
        accountTabPanel.add(_clientFactory.getAccountTabPanel());
      }
      break;
    case 1:
      if (circlesTabPanel.getWidget() == null) {
        circlesTabPanel.add(_clientFactory.getCirclesTabPanel());
      }
      break;
    case 2:
      if (eventsTabPanel.getWidget() == null) {
        eventsTabPanel.add(_clientFactory.getEventsTabPanel());
      }
      break;
  }
} // onTabLayoutPanelSelection()
//--------------------------------------------------------------------------------------------------
}