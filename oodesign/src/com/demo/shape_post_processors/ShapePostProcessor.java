package com.demo.shape_post_processors;

import com.demo.model.Shape;

public interface ShapePostProcessor {
    String getName();

    Shape postProcessBeforeDraw(Shape shape);

    Shape postProcessAfterDraw(Shape shape);
}
