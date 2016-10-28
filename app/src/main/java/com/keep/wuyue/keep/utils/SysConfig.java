package com.keep.wuyue.keep.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wuyue on 2016/10/28.
 *
 * 存放系统参数
 */

public class SysConfig {

    private final static String SYS_PARMS = "sys_parms_comcare";
    private SharedPreferences config;

    private static SysConfig sysConfig;

    private SysConfig(Context context){
        config = context.getSharedPreferences(SYS_PARMS,0);
    }

    /**
     * 单例模式
     * @param context
     * @return
     */
    public static SysConfig getConfig(Context context){
        if(sysConfig == null){
            sysConfig = new SysConfig(context);
        }
        return sysConfig;
    }

    //获取版本号
    public int getAppVersion(){
        return config.getInt("version",0);
    }

    //设置版本号
    public void setAppVersion(int version){
        config.edit().putInt("version",version).commit();
    }

    //获取服务器最新的版本号
    public int getSerAppVersion(){
        return config.getInt("serappversion",0);
    }

    //写入服务器版本号
    public void setSerAppVersion(int serAppVersion){
        config.edit().putInt("serAppVersion",serAppVersion).commit();
    }

    /***
     * 设置自定义配置信息
     * @param custom_action
     * @param info  配置内容
     * @return
     */
    public void setCustomConfig(String custom_action,String info){
        config.edit().putString(custom_action, info).commit();
    }
    /***
     * 获取自定义配置信息
     * @return
     */
    public String getCustomConfig(String custom_action,String defaultStr){
        return config.getString(custom_action, defaultStr);
    }
}
