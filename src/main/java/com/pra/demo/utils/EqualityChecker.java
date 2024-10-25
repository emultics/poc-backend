package com.pra.demo.utils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EqualityChecker {
    public static <T> boolean isEqual(T firstValue, T b){
        if(firstValue == null || b == null){
            return Objects.equals(firstValue, b);

        }

        if(firstValue instanceof String && b instanceof String){
            return ((String) firstValue).equalsIgnoreCase(((String) b));
        }

        if(firstValue instanceof List && b instanceof List){
            return isEqualLists((List<?>) firstValue, (List<?>) b);

        }

        if(firstValue instanceof Map && b instanceof Map){
            return isEqualMap((Map<?, ?>) firstValue,(Map<?, ?>) b);
        }

        return firstValue.equals(b);
    }

    private static boolean isEqualLists(List<?> a, List<?> b){
        if(a.size() != b.size()){
            return false;
        }

        for(int i=0;i<a.size();i++){
            if(!isEqual(a.get(i), b.get(i))){
                return false;
            }
        }
        return true;
    }

    private static boolean isEqualMap(Map<?,?> a, Map<?,?> b){
        if(a.size() != b.size()){
            return false;
        }

        for(Map.Entry<?,?> entry: a.entrySet()){
            Object key = entry.getKey();
            if(!b.containsKey(key) || !isEqual(entry.getValue(), b.get(key))){
                return false;
            }
        }
        return true;
    }
}
