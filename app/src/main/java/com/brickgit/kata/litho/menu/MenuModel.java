package com.brickgit.kata.litho.menu;

import android.support.annotation.Nullable;

import com.brickgit.kata.litho.tutorial.column.ColumnActivity;
import com.brickgit.kata.litho.tutorial.singletext.SingleTextActivity;

import java.util.Arrays;
import java.util.List;

import lombok.Value;

/** Created by Daniel Lin on 2018/10/1. */
@Value
public class MenuModel {

  public static final List<MenuModel> MODELS =
      Arrays.asList(
          new MenuModel("Single Text", SingleTextActivity.class, null),
          new MenuModel("Column Component", ColumnActivity.class, null));

  private String title;
  @Nullable private Class cls;
  @Nullable private List<MenuModel> models;
}
