package com.timeofplay.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.timeofplay.client.IClientFactory;
import com.timeofplay.client.widget.UserEditorWidget;

public class TimeOfPlayView extends Composite {
//--------------------------------------------------------------------------------------------------
@UiField
ResizeLayoutPanel      topLevelPanel;
@UiField(provided = true)
UserEditorWidget       userEditorWidget;

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
  userEditorWidget = new UserEditorWidget(_clientFactory);
  final ITimeOfPlayViewUiBinder binder = GWT.create(ITimeOfPlayViewUiBinder.class);
  binder.createAndBindUi(this);
} // initialize()
//--------------------------------------------------------------------------------------------------
}