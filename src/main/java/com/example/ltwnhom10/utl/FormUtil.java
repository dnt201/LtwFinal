package com.example.ltwnhom10.utl;

import org.codehaus.jackson.map.util.BeanUtil;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class FormUtil {

    public static <T> T toModel(Class<T> tClass, HttpServletRequest req){
        T value = null;
        try{
            value = tClass.newInstance();
            BeanUtils.populate(value, req.getParameterMap());
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
        return value;
    }
}
