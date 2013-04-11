package com.timeofplay.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.timeofplay.client.IClientFactory;
import com.timeofplay.client.ITimeOfPlayClientEnums.EUpdateType;
import com.timeofplay.client.model.ICircleUserProxy;
import com.timeofplay.shared.ICircleUserRequestContext;

public class CircleUsersGridWidget extends Composite {
//--------------------------------------------------------------------------------------------------
@UiField
Label                             circleDescLabel;
@UiField
DataGrid<ICircleUserProxy>        circleUserDataGrid;

private final IClientFactory      _clientFactory;
private EUpdateType               _updateType;
private ICircleUserRequestContext _circleUserRequestContext;
//==================================================================================================
interface ICircleUsersGridWidgetBinder extends UiBinder<Widget, CircleUsersGridWidget> { //
} // interface ICircleUsersGridWidgetBinder
//==================================================================================================
public CircleUsersGridWidget(final IClientFactory clientFactory, final int circleId) {
  _clientFactory = clientFactory;
  final ICircleUsersGridWidgetBinder binder = GWT.create(ICircleUsersGridWidgetBinder.class);
  initWidget(binder.createAndBindUi(this));
} // CircleUsersGridWidget()
//--------------------------------------------------------------------------------------------------
}