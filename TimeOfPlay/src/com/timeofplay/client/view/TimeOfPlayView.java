package com.timeofplay.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.timeofplay.client.IClientFactory;

public class TimeOfPlayView extends Composite {
//--------------------------------------------------------------------------------------------------
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
} // initialize()
//--------------------------------------------------------------------------------------------------
}