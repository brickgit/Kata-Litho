package com.brickgit.kata.litho;

import android.app.Application;

import com.facebook.soloader.SoLoader;

/** Created by Daniel Lin on 2018/9/30. */
public class KataLithoApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    SoLoader.init(this, false);
  }
}
