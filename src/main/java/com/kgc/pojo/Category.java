package com.kgc.pojo;


public class Category {

  private long id;
  private String name;
  private long level;
  private long parentId;
  private String picName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getLevel() {
    return level;
  }

  public void setLevel(long level) {
    this.level = level;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }

  public String getPicName() {
    return picName;
  }

  public void setPicName(String picName) {
    this.picName = picName;
  }

  @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                '}';
    }
}
