package com.threeq.network.core.model;

/**
 * @Date 2017/4/22
 * @User three
 */
public class BaseEntity<T> extends Entity<T> {
    private boolean isActive;
    private Long createTime;
    private Long updateTime;
    private Long deleteTime;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }
}
