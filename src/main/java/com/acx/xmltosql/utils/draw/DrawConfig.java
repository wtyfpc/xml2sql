package com.acx.xmltosql.utils.draw;
import com.acx.xmltosql.utils.draw.impl.DrawUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DrawConfig {

    @Autowired
    @Qualifier("drawNewlyInstall")
    private IDrawMethod DrawNewlyInstall;

    @Autowired
    @Qualifier("drawUpdate")
    private IDrawMethod DrawUpdate;

    protected static Map<String, IDrawMethod> drawMethodMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawMethodMap.put("newly_installed", DrawNewlyInstall);
        drawMethodMap.put("update", DrawUpdate);
    }

}
