package com.example.fragmenthw;

import java.util.Date;
import java.util.UUID;

public class TodoClass {
    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDetail() {
        return mDetail;
    }

    public void setmDetail(String mDetail) {
        this.mDetail = mDetail;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismIsComplete() {
        return mIsComplete;
    }

    public void setmIsComplete(boolean mIsComplete) {
        this.mIsComplete = mIsComplete;
    }

    private UUID mId;
    private String mTitle;
    private String mDetail;
    private Date mDate;
    private boolean mIsComplete;
}
