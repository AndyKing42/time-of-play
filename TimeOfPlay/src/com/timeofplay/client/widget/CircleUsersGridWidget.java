package com.timeofplay.client.widget;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
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
Label                             headingLabel;
@UiField
DataGrid<ICircleUserProxy>        circleUsersDataGrid;

private final IClientFactory      _clientFactory;
private EUpdateType               _updateType;
private ICircleUserRequestContext _circleUserRequestContext;
//==================================================================================================
interface ICircleUsersGridWidgetBinder extends UiBinder<Widget, CircleUsersGridWidget> { //
} // interface ICircleUsersGridWidgetBinder
//==================================================================================================
public CircleUsersGridWidget(final IClientFactory clientFactory, final String heading,
                             final int circleId) {
  _clientFactory = clientFactory;
  final ICircleUsersGridWidgetBinder binder = GWT.create(ICircleUsersGridWidgetBinder.class);
  initWidget(binder.createAndBindUi(this));
  headingLabel.setText(heading);
  createGridColumns();
} // CircleUsersGridWidget()
//--------------------------------------------------------------------------------------------------

private void createGridColumns() {
  // Name
  final Column<ICircleUserProxy, String> nameColumn = new Column<ICircleUserProxy, String>(
                                                                                           new EditTextCell()) {
    @Override
    public String getValue(final ICircleUserProxy circleUser) {
      return circleUser.getMemberUser().getScreenName();
    }
  };
  circleUsersDataGrid.addColumn(nameColumn, "Name");
  circleUsersDataGrid.setColumnWidth(nameColumn, "25ex");
} // createGridColumns()
//--------------------------------------------------------------------------------------------------
}