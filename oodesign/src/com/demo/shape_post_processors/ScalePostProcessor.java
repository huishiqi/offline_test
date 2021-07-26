package com.demo.shape_post_processors;

import com.demo.model.Shape;

public class ScalePostProcessor extends SortedShapePostProcessor {
    protected Double shapeScaleBeforeDraw;
    protected Double shapeScaleAfterDraw;

    public ScalePostProcessor() {
    }

    public ScalePostProcessor(Double shapeScaleBeforeDraw, Double shapeScaleAfterDraw) {
        this.shapeScaleBeforeDraw = shapeScaleBeforeDraw;
        this.shapeScaleAfterDraw = shapeScaleAfterDraw;
    }

    @Override
    public String getName() {
        return "ScalePostProcessor";
    }

    @Override
    public Shape postProcessBeforeDraw(Shape shape) {
        System.out.println("ScalePostProcessor postProcessBeforeDraw, set scale = " + this.shapeScaleBeforeDraw);
        shape.processScale(this.shapeScaleBeforeDraw);
        return shape;
    }

    @Override
    public Shape postProcessAfterDraw(Shape shape) {
        System.out.println("ScalePostProcessor postProcessAfterDraw, set scale = " + this.shapeScaleAfterDraw);
        shape.processScale(this.shapeScaleAfterDraw);
        return shape;
    }

    @Override
    public Integer getOrder() {
        return 102;
    }
}
