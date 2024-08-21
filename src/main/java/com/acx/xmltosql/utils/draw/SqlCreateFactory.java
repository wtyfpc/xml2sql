package com.acx.xmltosql.utils.draw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import static com.acx.xmltosql.utils.draw.DrawConfig.drawMethodMap;

@Component
public class SqlCreateFactory {

    @Value("${deployment}")
    private String deployment;


    public IDrawMethod getSqlGenerator() {
        if (deployment == null) {
            return null;
        }
        if (deployment.equals("newly_installed")) {
            return drawMethodMap.get("newly_installed");
        }
        System.out.println(deployment+"方法为空");
        return null;
    }


}
