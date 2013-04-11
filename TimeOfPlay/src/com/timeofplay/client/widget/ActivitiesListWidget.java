package com.timeofplay.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.timeofplay.client.IClientFactory;
import com.timeofplay.client.ITimeOfPlayClientEnums.EUpdateType;

public class ActivitiesListWidget extends Composite {
//--------------------------------------------------------------------------------------------------

private final IClientFactory _clientFactory;
private EUpdateType          _updateType;
//==================================================================================================
interface IActivitiesListWidgetBinder extends UiBinder<Widget, ActivitiesListWidget> { //
} // interface IActivitiesListWidgetBinder
//==================================================================================================
public ActivitiesListWidget(final IClientFactory clientFactory) {
  _clientFactory = clientFactory;
  final IActivitiesListWidgetBinder binder = GWT.create(IActivitiesListWidgetBinder.class);
  initWidget(binder.createAndBindUi(this));
} // CircleUsersGridWidget()
//--------------------------------------------------------------------------------------------------
}