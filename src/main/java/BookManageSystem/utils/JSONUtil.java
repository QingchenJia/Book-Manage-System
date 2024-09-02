package BookManageSystem.utils;

import com.alibaba.fastjson2.JSON;

public class JSONUtil {
    public static String object2JSON(Object object) {
        return JSON.toJSONString(object);
    }

    public static Object JSON2object(String json, Class<?> clazz) {
        return JSON.parseObject(json, clazz);
    }
}
