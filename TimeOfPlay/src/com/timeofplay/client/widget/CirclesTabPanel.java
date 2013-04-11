package com.timeofplay.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.timeofplay.client.IClientFactory;

public class CirclesTabPanel extends Composite {
//--------------------------------------------------------------------------------------------------
@UiField(provided = true)
CirclesTreeWidget circlesTreeWidget;
//==================================================================================================
interface ICirclesTabPanelBinder extends UiBinder<Widget, CirclesTabPanel> { //
} // interface ICirclesTabPanelBinder
//==================================================================================================
public CirclesTabPanel(final IClientFactory clientFactory) {
  circlesTreeWidget = new CirclesTreeWidget(clientFactory);
  final ICirclesTabPanelBinder binder = GWT.create(ICirclesTabPanelBinder.class);
  initWidget(binder.createAndBindUi(this));
} // CirclesTabPanel()
//--------------------------------------------------------------------------------------------------
}