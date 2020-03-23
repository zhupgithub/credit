package com.zhupeng.common.utils;

import java.util.UUID;

public class UUIDUtil {

    /**
     * 获取uuID的值，当isexit_为true时表示不进行去除“_”,当为false时表示进去去除“_”
     * @param isexit_
     * @return
     */
    public static String getUUID(Boolean isexit_){
        if(!isexit_){
            return UUID.randomUUID().toString().replace("-", "");
        }
        return UUID.randomUUID().toString();
    }

    /**
     * 获取UUID的值，不进行去除“_”
     * @return
     */
    public static String getUUID(){
        return getUUID(true);
    }
}
