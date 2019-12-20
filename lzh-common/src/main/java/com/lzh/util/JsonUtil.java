package com.lzh.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * json工具类
 * 用于处理对象转json、json转javabean、转数组数据
 */
public class JsonUtil {

    private static Gson gson = null;

    static{
        gson  = new Gson();
    }

    /**
     * 单例生成唯一的gson对象
     * @return
     */
    public static synchronized Gson newInstance(){
        if(gson == null){
            gson =  new Gson();
        }
        return gson;
    }

    /**
     * 实体转json串
     * @param obj
     * @return
     */
    public static String getJsonString(Object obj){
        return gson.toJson(obj);
    }

    /**
     * json串转javabean
     * @param json
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T toBean(String json,Class<T> clz){

        return gson.fromJson(json, clz);
    }

    public static <T> Map<String, T> readJson2MapObj(String json, Class<T> clz){
        Map<String, JsonObject> map = gson.fromJson(json, new TypeToken<Map<String,JsonObject>>(){}.getType());
        Map<String, T> result = new HashMap<>();
        for(String key:map.keySet()){
            result.put(key,gson.fromJson(map.get(key),clz) );
        }
        return result;
    }

    public static <T> T json2Obj(String json,Class<T> clz){
        return gson.fromJson(json,clz);
    }

    public static Map<String, Object> toMap(String json){
        Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String,Object>>(){}.getType());
        return map;
    }

    public static Map<String,String> readJsonStrMap(String json) {
        Map<String, JsonObject> map = gson.fromJson(json, new TypeToken<Map<String,JsonObject>>(){}.getType());
        Map<String,String> result = new HashMap<>();
        for(String key:map.keySet()){
            result.put(key,gson.fromJson(map.get(key),String.class) );
        }
        return result;
    }

    public static  Map<byte[], byte[]> readJsonByteMap(String json) {
        Map<String, JsonPrimitive> map = gson.fromJson(json, new TypeToken<Map<String,JsonPrimitive>>(){}.getType());
        Map<byte[], byte[]> vmap = new HashMap<>();
        for(String key:map.keySet()){
            vmap.put(key.getBytes(),gson.fromJson(map.get(key),String.class).getBytes() );
        }
        return vmap;

    }

    /**
     * json数据转数组
     * @param json json字符串
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> List<T> readJson2Array(String json, Class<T> clz){
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        List<T> list  = new ArrayList<>();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, (Type)clz));
        }
        return list;
    }
}
