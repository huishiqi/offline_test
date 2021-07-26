package com.demo.service;

import com.demo.model.Shape;
import com.demo.shape_post_processors.SortedShapePostProcessor;

public class ShapeService {
    private static ShapeService instance;

    private ShapeService() {
    }

    public static ShapeService getInstance() {
        if (instance == null) {
            synchronized (ShapeService.class) {
                if (instance == null) {
                    instance = new ShapeService();
                }
            }
        }
        return instance;
    }

    public Shape draw(Shape shape) {
        // process before shapeDraw
        for (SortedShapePostProcessor postProcessor : shape.getSortedShapePostProcessorSet()) {
            shape = postProcessor.postProcessBeforeDraw(shape);
        }
        // actual shapeDraw
        shape.draw();
        // process after shapeDraw
        for (SortedShapePostProcessor postProcessor : shape.getSortedShapePostProcessorSet()) {
            shape = postProcessor.postProcessAfterDraw(shape);
        }
        return shape;
    }
}
