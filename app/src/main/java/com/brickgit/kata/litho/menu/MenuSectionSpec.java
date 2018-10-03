package com.brickgit.kata.litho.menu;

import android.support.annotation.Nullable;

import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.DataDiffSection;
import com.facebook.litho.sections.common.RenderEvent;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.RenderInfo;

import java.util.Arrays;
import java.util.List;

/** Created by Daniel Lin on 2018/10/1. */
@GroupSectionSpec
public class MenuSectionSpec {

  @OnCreateChildren
  static Children onCreateChildren(SectionContext c, @Prop List<MenuModel> models) {
    return Children.create()
        .child(
            DataDiffSection.<MenuModel>create(c)
                .data(models)
                .renderEventHandler(MenuSection.onRender(c)))
        .build();
  }

  @OnEvent(RenderEvent.class)
  static RenderInfo onRender(
      SectionContext c,
      @Prop @Nullable int[] parentIndices,
      @FromEvent MenuModel model,
      @FromEvent int index) {
    return ComponentRenderInfo.create()
        .component(
            MenuItem.create(c)
                .model(model)
                .index(index)
                .currentIndices(getUpdatedIndices(parentIndices, index))
                .build())
        .build();
  }

  static int[] getUpdatedIndices(@Nullable int[] parentIndices, int currentIndex) {
    if (parentIndices == null) {
      return new int[] {currentIndex};
    }
    final int[] updatedIndices = Arrays.copyOf(parentIndices, parentIndices.length + 1);
    updatedIndices[parentIndices.length] = currentIndex;
    return updatedIndices;
  }
}
