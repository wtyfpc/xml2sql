package com.acx.xmltosql.utils.draw;

import com.acx.xmltosql.utils.draw.impl.DrawNewlyInstall;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DrawConfig {

    @Resource
    private IDrawMethod DrawNewlyInstall;

    protected static Map<String, IDrawMethod> drawMethodMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawMethodMap.put("newly_installed", DrawNewlyInstall);
    }



}
