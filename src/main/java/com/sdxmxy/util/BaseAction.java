package com.sdxmxy.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sdxmxy.domain.PageBean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseAction<T> extends ActionSupport implements
        ModelDriven<T> {
    // 模型驱动
    protected T model;

    @Override
    public T getModel() {
        return model;
    }

    // 构造器 完成model实例化
    public BaseAction() {
        // 构造子类Action对象 ，获取继承父类型的泛型
        // AreaAction extends BaseAction<Area>
        // BaseAction<Area>
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        // 获取类型第一个泛型参数
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Class<T> modelClass = (Class<T>) parameterizedType
                .getActualTypeArguments()[0];
        try {
            model = modelClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("模型构造失败...");
        }
    }

    // 接收分页查询参数
    protected int page;
    protected int rows;

    public void setPage(int page) {
        this.page = page;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    // 将分页查询结果数据，压入值栈的方法
    protected void pushPageDataToValueStack(PageBean<T> pageData) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", pageData.getTotalCount());
        result.put("rows", pageData.getList());
        ActionContext.getContext().getValueStack().push(result);
    }
}