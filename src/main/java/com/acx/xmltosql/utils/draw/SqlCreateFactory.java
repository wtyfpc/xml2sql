package com.acx.xmltosql.utils.draw;

import org.springframework.beans.factory.annotation.Value;

import static com.acx.xmltosql.utils.draw.DrawConfig.drawMethodMap;

public class SqlCreateFactory {

    @Value("${deployment}")
    private String deployment;

    public IDrawMethod getSqlGenerator(String deployment) {
        if (deployment == null) {
            return null;
        }
        if (deployment.equalsIgnoreCase("newly_installed")) {
            return drawMethodMap.get("newly_installed");
        }
        return null;
    }


}
