package com.acx.xmltosql.common.tools.enhance;



import com.acx.xmltosql.utils.draw.IDrawMethod;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PartTypeConfig {
    protected static Map<String,String> parTypeMap = new ConcurrentHashMap<>();
    @PostConstruct
    public void init() {
        parTypeMap.put("antiddos", "ANTIDDOS");
        parTypeMap.put("aptdetect", "APTDETECT");
        parTypeMap.put("auditdb", "AUDITDB");
        parTypeMap.put("auditlog", "AUDITLOG");
        parTypeMap.put("bastionhost", "BASTIONHOST");
        parTypeMap.put("bladechassis", "BLADECHASSIS");
        parTypeMap.put("bladechassis switch module", "BLADECHASSIS SWITCH MODULE");
        parTypeMap.put("bugscan", "BUGSCAN");
        parTypeMap.put("cdu", "CDU");
        parTypeMap.put("cloud", "CLOUD");
        parTypeMap.put("cluster", "CLUSTER");
        parTypeMap.put("diskarray", "DISKARRAY");
        parTypeMap.put("dnsserver", "DNSSERVER");
        parTypeMap.put("firewall", "FIREWALL");
        parTypeMap.put("group", "GROUP");
        parTypeMap.put("ib access switch", "IB ACCESS SWITCH");
        parTypeMap.put("ib core switch", "IB CORE SWITCH");
        parTypeMap.put("ibmgmt", "IBMGMT");
        parTypeMap.put("loadbalance", "LOADBALANCE");
        parTypeMap.put("rack", "RACK");
        parTypeMap.put("room", "ROOM");
        parTypeMap.put("server", "SERVER");
        parTypeMap.put("situationaware", "SITUATIONAWARE");
        parTypeMap.put("storage server", "STORAGE SERVER");
        parTypeMap.put("storagesystem", "STORAGESYSTEM");
        parTypeMap.put("switch", "SWITCH");
        parTypeMap.put("virtual host", "VIRTUAL HOST");
        parTypeMap.put("virusmgmt", "VIRUSMGMT");
        parTypeMap.put("waf", "WAF");
    }

}
