package com.brickgit.kata.litho.tutorial.column;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;

public class ColumnActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final ComponentContext context = new ComponentContext(this);

    final Component component =
        Column.create(context)
            .paddingDip(YogaEdge.ALL, 16)
            .backgroundColor(Color.WHITE)
            .child(Text.create(context).text("Hello World").textSizeSp(40))
            .child(Text.create(context).text("How are you").textSizeSp(20))
            .build();

    setContentView(LithoView.create(context, component));
  }
}
