package com.brickgit.kata.litho.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;

import java.util.List;

public class MenuActivity extends AppCompatActivity {

  public static final String INDICES = "INDICES";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final int[] indices = getIntent().getIntArrayExtra(INDICES);
    final List<MenuModel> dataModels = getModels(indices);

    final ComponentContext context = new ComponentContext(this);

    final Component component =
        RecyclerCollectionComponent.create(context)
            .disablePTR(true)
            .section(
                MenuSection.create(new SectionContext(context))
                    .models(dataModels)
                    .parentIndices(indices)
                    .build())
            .build();

    setContentView(LithoView.create(context, component));
  }

  private List<MenuModel> getModels(@Nullable int[] indices) {
    List<MenuModel> models = MenuModel.MODELS;
    if (indices == null) {
      return models;
    }

    for (int i = 0; i < indices.length; i++) {
      models = models.get(indices[i]).getModels();
    }
    return models;
  }
}
