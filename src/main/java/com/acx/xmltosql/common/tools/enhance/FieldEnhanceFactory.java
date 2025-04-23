package com.acx.xmltosql.common.tools.enhance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.acx.xmltosql.common.tools.enhance.utils.NameToIdUtil;



/**
 * @description: 字段增强类
 **/
@Component
public class FieldEnhanceFactory extends PartTypeConfig{

    @Autowired NameToIdUtil nameToIdUtil;


    /**
     * 如果partType是主资产字段变小写
     * @param s partType字符串
     * @return parTypeMap.get(s)/s
     */
    public String enhancePartType(String s){
        if(parTypeMap.containsKey(s)){
            return parTypeMap.get(s);
        } else{
            return s.toUpperCase();
        }
    }

    /**
     * 将单引号变双引号
     * @param s partType字符串
     * @return 替换后的结果
     */
    public String enhanceValueRange(String s){
        return s.replace("'", "\"");
    }

    /**
     * 将单引号变双引号
     * @param s partType字符串
     * @return 替换后的结果
     */
    public String enhanceValueMapping(String s){
        return s.replace("'", "\"");
    }

    /**
     * 生成HashID
     * @param s
     * @return 返回Hashcode
     */
    public Long createHashID(String s){
        return nameToIdUtil.getStrHashCode(s);
    }

}
