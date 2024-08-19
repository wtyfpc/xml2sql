package com.acx.xmltosql.utils;

import com.acx.xmltosql.model.ResMetric;
import com.acx.xmltosql.model.XmlTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


public abstract class SqlGenerator {
    private List<XmlTemplate> xmlTemplateList;


    public abstract String generateInsertSql(List<XmlTemplate> xmlObject);


    // 生成INSERT INTO语句的方法



}
