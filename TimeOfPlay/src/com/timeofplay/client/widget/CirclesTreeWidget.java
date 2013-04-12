package com.timeofplay.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.Widget;
import com.timeofplay.client.IClientFactory;
import com.timeofplay.client.ITimeOfPlayClientEnums.EUpdateType;

public class CirclesTreeWidget extends ResizeComposite {
//--------------------------------------------------------------------------------------------------
@UiField
Tree                         circlesTree;
@UiField
Button                       newCircleButton;

private final IClientFactory _clientFactory;
private EUpdateType          _updateType;
//==================================================================================================
interface ICirclesTreeWidgetBinder extends UiBinder<Widget, CirclesTreeWidget> { //
} // interface ICirclesTreeWidgetBinder
//==================================================================================================
public CirclesTreeWidget(final IClientFactory clientFactory) {
  _clientFactory = clientFactory;
  final ICirclesTreeWidgetBinder binder = GWT.create(ICirclesTreeWidgetBinder.class);
  initWidget(binder.createAndBindUi(this));
} // CirclesTreeWidget()
//--------------------------------------------------------------------------------------------------
}