package com.acx.xmltosql.utils.draw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DrawConfig {

    @Autowired
    private IDrawMethod DrawNewlyInstall;

    protected static Map<String, IDrawMethod> drawMethodMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawMethodMap.put("newly_installed", DrawNewlyInstall);
    }



}
