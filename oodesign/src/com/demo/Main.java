package com.demo;

import com.demo.model.Circle;
import com.demo.service.ShapeService;
import com.demo.shape_post_processors.CircleColorPostProcessor;
import com.demo.shape_post_processors.CircleScalePostProcessor;

public class Main {

    public static void main(String[] args) {
        // new shapeServiceImpl
        ShapeService shapeService = ShapeService.getInstance();

        // generate a circle
        Circle circle = new Circle("Circle1", "red", 1.0);
        System.out.println("Origin circle, " + circle);
        System.out.println();

        // registerPostProcessor
        circle.registerShapePostProcessor(new CircleColorPostProcessor("yellow", "red"));
        circle.registerShapePostProcessor(new CircleScalePostProcessor(0.5, 0.5));

        // draw a circle
        shapeService.draw(circle);

        System.out.println();
        System.out.println("Final circle, " + circle);
    }
}
