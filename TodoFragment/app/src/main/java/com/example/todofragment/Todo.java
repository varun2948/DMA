package com.example.todofragment;

import java.util.Date;
import java.util.UUID;

public class Todo {
    private UUID mTodoId;
    private String mTodoTitle;
    private String mTodoDetail;
    private Date mTodoDate;
    private boolean mTodoIsComplete;

    public Todo(){
        mTodoId = UUID.randomUUID();
        mTodoDate = new Date();
    }

    public UUID getTodoId() {
        return mTodoId;
    }

    public void setTodoId(UUID mTodoId) {
        this.mTodoId = mTodoId;
    }

    public String getTodoTitle() {
        return mTodoTitle;
    }

    public void setTodoTitle(String mTodoTitle) {
        this.mTodoTitle = mTodoTitle;
    }

    public String getTodoDetail() {
        return mTodoDetail;
    }

    public void setTodoDetail(String mTodoDetail) {
        this.mTodoDetail = mTodoDetail;
    }

    public Date getTodoDate() {
        return mTodoDate;
    }

    public void setTodoDate(Date mTodoDate) {
        this.mTodoDate = mTodoDate;
    }

    public boolean isTodoIsComplete() {
        return mTodoIsComplete;
    }

    public void setTodoIsComplete(boolean mTodoIsComplete) {
        this.mTodoIsComplete = mTodoIsComplete;
    }
}
