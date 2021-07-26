package com.demo.shape_post_processors;

public abstract class SortedShapePostProcessor implements ShapePostProcessor, Comparable<SortedShapePostProcessor> {

    public abstract Integer getOrder();

    @Override
    public int compareTo(SortedShapePostProcessor o) {
        return this.getOrder() - o.getOrder();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SortedShapePostProcessor) {
            return this.getName().equals(((SortedShapePostProcessor) obj).getName());
        }
        return false;
    }
}
