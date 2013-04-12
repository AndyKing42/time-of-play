package com.timeofplay.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class TestLayout extends Composite {
//--------------------------------------------------------------------------------------------------
@UiField
ResizeLayoutPanel outerPanel;
//==================================================================================================
public interface ITestLayoutUiBinder extends UiBinder<Widget, TestLayout> { //
} // interface ITestLayoutUiBinder
//==================================================================================================
public void initialize() {
  final ITestLayoutUiBinder binder = GWT.create(ITestLayoutUiBinder.class);
  binder.createAndBindUi(this);
} // initialize()
//--------------------------------------------------------------------------------------------------
public ResizeLayoutPanel getOuterPanel() {
  return outerPanel;
} // getOuterPanel()
//--------------------------------------------------------------------------------------------------
}