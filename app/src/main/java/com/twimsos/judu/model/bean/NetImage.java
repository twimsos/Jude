package com.twimsos.judu.model.bean;

import java.io.Serializable;


public abstract class NetImage implements Serializable {

    public abstract String getThumbImg();

    public abstract String getLargeImg();

    public abstract int getWidth();

    public abstract int getHeight();

}
