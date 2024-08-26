package com.acx.xmltosql.utils.draw;

import com.acx.xmltosql.common.InputArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.acx.xmltosql.utils.draw.DrawConfig.drawMethodMap;

@Component
public class SqlCreateFactory {

    @Autowired
    private final InputArgs inputArgs;
    private final String deployment;

    public SqlCreateFactory(InputArgs inputArgs) {
        this.inputArgs = inputArgs;
        deployment =  inputArgs.getDeployment();
    }


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
