package com.timeofplay.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.timeofplay.client.IClientFactory;

public class AccountTabPanel extends Composite {
//--------------------------------------------------------------------------------------------------
@UiField(provided = true)
ActivitiesListWidget  activitiesListWidget;
@UiField(provided = true)
CircleUsersGridWidget circleUsersGridWidget;
@UiField(provided = true)
UserEditorWidget      userEditorWidget;
//==================================================================================================
interface IAccountTabPanelBinder extends UiBinder<Widget, AccountTabPanel> { //
} // interface IAccountTabPanelBinder
//==================================================================================================
public AccountTabPanel(final IClientFactory clientFactory) {
  activitiesListWidget = new ActivitiesListWidget(clientFactory);
  circleUsersGridWidget = new CircleUsersGridWidget(clientFactory, "People that I know", 0);
  userEditorWidget = new UserEditorWidget(clientFactory);
  final IAccountTabPanelBinder binder = GWT.create(IAccountTabPanelBinder.class);
  initWidget(binder.createAndBindUi(this));
} // AccountTabPanel()
//--------------------------------------------------------------------------------------------------
}