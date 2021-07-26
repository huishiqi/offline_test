package com.demo.shape_post_processors;

import com.demo.model.Shape;

public class CircleScalePostProcessor extends ScalePostProcessor {
    public CircleScalePostProcessor() {
    }

    public CircleScalePostProcessor(Double scaleBeforeProcess, Double scaleAfterProcess) {
        super(scaleBeforeProcess, scaleAfterProcess);
    }

    @Override
    public String getName() {
        return "CircleScalePostProcessor";
    }

    @Override
    public Shape postProcessBeforeDraw(Shape shape) {
        System.out.println("CircleScalePostProcessor postProcessBeforeDraw, set scale = " + this.shapeScaleBeforeDraw);
        shape.processScale(this.shapeScaleBeforeDraw);
        return shape;
    }

    @Override
    public Shape postProcessAfterDraw(Shape shape) {
        System.out.println("CircleScalePostProcessor postProcessAfterDraw, set scale = " + this.shapeScaleAfterDraw);
        shape.processScale(this.shapeScaleAfterDraw);
        return shape;
    }

    @Override
    public Integer getOrder() {
        return 2;
    }
}
