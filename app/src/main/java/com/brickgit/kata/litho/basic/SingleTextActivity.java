package com.brickgit.kata.litho.basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;

/** Created by Daniel Lin on 2018/10/2. */
public class SingleTextActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final ComponentContext context = new ComponentContext(this);

    final Component component =
        Text.create(context)
            .text("Hello World")
            .textSizeDip(50)
            .paddingDip(YogaEdge.ALL, 20)
            .build();

    setContentView(LithoView.create(context, component));
  }
}
