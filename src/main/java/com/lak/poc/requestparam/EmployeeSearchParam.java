package com.lak.poc.requestparam;

import com.lak.poc.requestparam.anot.ParamName;

import java.util.Calendar;

public class EmployeeSearchParam {

    private Integer pageNo;

    @ParamName("nnnnn")
    private String name;

    private Calendar calendar;

    public Integer getPageNo() {

        return pageNo;
    }

    public void setPageNo(Integer pageNo) {

        this.pageNo = pageNo;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public String toString() {
        return "EmployeeSearchParam{" +
                "pageNo=" + pageNo +
                ", name=" + name +
                '}';
    }
}
