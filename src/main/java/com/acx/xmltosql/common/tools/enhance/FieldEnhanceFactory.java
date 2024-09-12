package com.acx.xmltosql.common.tools.enhance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.acx.xmltosql.common.tools.enhance.utils.NameToIdUtil;

@Component
public class FieldEnhanceFactory extends PartTypeConfig{

    @Autowired NameToIdUtil nameToIdUtil;
    
    public String enhancePartType(String s){
        if(parTypeMap.containsKey(s)){
            return parTypeMap.get(s);
        }
        else{
            return s;
        }
    }

    public String enhanceValueRange(String s){
        return s.replace("'", "\"");
    }

    public String enhanceValueMapping(String s){
        return s.replace("'", "\"");
    }

    public Long createHashID(String s){
        return nameToIdUtil.getStrHashCode(s);
    }

}
