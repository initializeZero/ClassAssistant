package com.zeromirai.classassistant.common.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.zeromirai.android.text.JsonUtils.optStrToJsonObject;

/**
 * Created by initialize on 2018/4/18.
 * LocalCache类,用于处理用户信息缓存
 * 基于SharedPreferences
 */

public class LocalCache extends AbstractCache {

    public static final String USERDATAINFO = "USERDATAINFO";
    public static final String SCHEDULEDATAINFO = "SCHEDULEDATAINFO";
    public static final String SNONUMBERINFO = "SNONUMBERINFO";
    public static final String SNOPASSWORD = "SNOPASSWORDINFO";

    /*
    * 构造函数,传入Context
    * */
    public LocalCache(Context context){
        super(context);
    }

    /*
    * 清除LocalCache模块下的全部缓存(用户信息缓存)
    */
    @Override
    public void clear() {
        clearUserData();
    }

    /*
    * 从缓存中获取用户信息
    */
    @Nullable
    public String getUserData(){
        String str = sharedPreferences.getString(USERDATAINFO, "");
        return str;
    }

    /*
    * 从缓存中获取用户信息(JSON)
    */
    @Nullable
    public JSONObject getUserDataJSON(){
        return optStrToJsonObject(getUserData());
    }

    /*
    * 更新缓存中用户信息
    * */
    public void setUserData(String str){
        if(TextUtils.isEmpty(str)){
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERDATAINFO, str);
        editor.apply();
    }

    /*
    * 更新缓存中用户信息(JSON)
    * */
    public void setUserDataJSON(JSONObject json){
        if(null == json){
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERDATAINFO, json.toString());
        editor.apply();
    }

    /*
    *清除缓存中用户信息
    * */
    public void clearUserData(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERDATAINFO, "");
        editor.apply();
    }

    /*
    * 从缓存中获取课表信息
    */
    @Nullable
    public String getScheduleData(){
        String str = sharedPreferences.getString(SCHEDULEDATAINFO, "");
        return str;
    }

    /*
    * 从缓存中获取课表信息(JSON)
    */
    @Nullable
    public JSONArray getScheduleDataJSON(){
        try{
            return new JSONArray(getScheduleData());
        }catch (JSONException je){
            je.printStackTrace();
        }
        return null;
    }

    /*
    * 更新缓存中课表信息
    * */
    public void setScheduleData(String str){
        if(TextUtils.isEmpty(str)){
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SCHEDULEDATAINFO, str);
        editor.apply();
    }

    /*
    *清除缓存中课表信息
    * */
    public void clearScheduleData(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SCHEDULEDATAINFO, "");
        editor.apply();
    }

    /*
    * 从缓存中获取教务处帐号信息
    */
    @NonNull
    public String getSnoNumber(){
        String str = sharedPreferences.getString(SNONUMBERINFO, "");
        if(TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    /*
    * 更新缓存中教务处帐号信息
    * */
    public void setSnoNumber(String str){
        if(TextUtils.isEmpty(str)){
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SNONUMBERINFO, str);
        editor.apply();
    }

    /*
    *清除缓存中教务处帐号信息
    * */
    public void clearSnoNumber(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SNONUMBERINFO, "");
        editor.apply();
    }

    /*
    * 从缓存中获取教务处密码信息
    */
    @NonNull
    public String getSnoPassword(){
        String str = sharedPreferences.getString(SNOPASSWORD, "");
        if(TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
    /*
    * 更新缓存中教务处密码信息
    * */
    public void setSnoPassword(String str){
        if(TextUtils.isEmpty(str)){
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SNOPASSWORD, str);
        editor.apply();
    }

    /*
    *清除缓存中教务处密码信息
    * */
    public void clearSnoPassword(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SNOPASSWORD, "");
        editor.apply();
    }

}
