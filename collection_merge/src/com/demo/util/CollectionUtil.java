package com.demo.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionUtil {

    public static <T extends Comparable<? super T>> Collection<T> sortedCollectionMerge(Collection<T> coll1, Collection<T> coll2) {
        if (coll1.isEmpty()) return coll2;
        if (coll2.isEmpty()) return coll1;

        List<T> coll = new ArrayList<>();
        Iterator<T> var1 = coll1.iterator();
        Iterator<T> var2 = coll2.iterator();
        T obj1 = var1.next();
        T obj2 = var2.next();
        while (obj1 != null && obj2 != null) {
            if (obj1.compareTo(obj2) < 0) {
                coll.add(obj1);
                if (var1.hasNext()) {
                    obj1 = var1.next();
                } else {
                    coll.add(obj2);
                    break;
                }
            } else {
                coll.add(obj2);
                if (var2.hasNext()) {
                    obj2 = var2.next();
                } else {
                    coll.add(obj1);
                    break;
                }
            }
        }
        while (var1.hasNext()) coll.add(var1.next());
        while (var2.hasNext()) coll.add(var2.next());

        return coll;
    }

}