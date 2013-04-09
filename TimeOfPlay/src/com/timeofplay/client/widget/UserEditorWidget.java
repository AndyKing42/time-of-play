package com.timeofplay.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.timeofplay.client.IClientFactory;
import com.timeofplay.client.ITimeOfPlayClientEnums.EUpdateType;
import com.timeofplay.client.model.IUserProxy;
import com.timeofplay.shared.IUserRequestContext;

public class UserEditorWidget extends Composite implements Editor<IUserProxy> {
//--------------------------------------------------------------------------------------------------
@UiField
TextBox                         screenName;
@UiField
TextBox                         userId;

private final IClientFactory    _clientFactory;
private IUserProxy              _originalUser;
private EUpdateType             _updateType;
private IUserProxy              _user;
private final IUserEditorDriver _userEditorDriver;
private IUserRequestContext     _userRequestContext;
//==================================================================================================
interface IUserEditorDriver extends RequestFactoryEditorDriver<IUserProxy, UserEditorWidget> { //
} // interface IUserEditorDriver
//==================================================================================================
interface IUserEditorWidgetBinder extends UiBinder<Widget, UserEditorWidget> { //
} // interface IUserEditorWidgetBinder
//==================================================================================================
public UserEditorWidget(final IClientFactory clientFactory) {
  _clientFactory = clientFactory;
  final IUserEditorWidgetBinder binder = GWT.create(IUserEditorWidgetBinder.class);
  initWidget(binder.createAndBindUi(this));
  _userEditorDriver = GWT.create(IUserEditorDriver.class);
  _userEditorDriver.initialize(_clientFactory.getRequestFactory().getEventBus(),
                               _clientFactory.getRequestFactory(), this);
  editUser(null);
} // UserEditorWidget()
//--------------------------------------------------------------------------------------------------
public void editUser(final IUserProxy user) {
  _originalUser = user;
  _updateType = user == null ? EUpdateType.Insert : EUpdateType.Update;
  _userRequestContext = _clientFactory.getRequestFactory().newUserRequestContext();
  if (_updateType == EUpdateType.Insert) {
    _user = _clientFactory.getTimeOfPlayCache().newUser(_userRequestContext);
    _userEditorDriver.edit(_user, _userRequestContext);
    userId.setFocus(true);
  }
  else {
    _user = _userRequestContext.edit(user);
    _userEditorDriver.edit(_user, _userRequestContext);
  }
} // editUser()
//--------------------------------------------------------------------------------------------------
public IUserProxy getUser() {
  return _user;
} // getUser()
//--------------------------------------------------------------------------------------------------
public boolean isChanged() {
  return _user != null && _userRequestContext != null &&
         (_userEditorDriver.isDirty() || _userRequestContext.isChanged()) &&
         _user.getUserId() != null && _user.getUserId().trim().length() > 0;
} // isChanged()
//--------------------------------------------------------------------------------------------------
}