package com.example.ltwnhom10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
    @JsonIgnore
    private List<Integer> list;
    @JsonIgnore
    private List<T> listResult = new ArrayList<>();

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

}
