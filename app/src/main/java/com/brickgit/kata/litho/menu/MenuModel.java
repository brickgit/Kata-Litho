package com.brickgit.kata.litho.menu;

import android.support.annotation.Nullable;

import com.brickgit.kata.litho.basic.SingleTextActivity;

import java.util.Collections;
import java.util.List;

import lombok.Value;

/** Created by Daniel Lin on 2018/10/1. */
@Value
public class MenuModel {

  public static final List<MenuModel> MODELS =
      Collections.singletonList(new MenuModel("Single Text", SingleTextActivity.class, null));

  private String title;
  @Nullable private Class cls;
  @Nullable private List<MenuModel> models;
}
