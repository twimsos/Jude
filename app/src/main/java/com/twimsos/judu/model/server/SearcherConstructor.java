package com.twimsos.judu.model.server;


import com.twimsos.judu.model.bean.NetImage;

import java.util.HashMap;

/**
 */
public interface SearcherConstructor {
    public HashMap<String,String> getHeader();
    public String getUrl(String word, int page);
    public NetImage[] getImageList(String response);
}
