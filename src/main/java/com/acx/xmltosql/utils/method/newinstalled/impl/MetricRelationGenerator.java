package com.acx.xmltosql.utils.method.newinstalled.impl;

import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.method.newinstalled.NewlyInstallSqlGenerator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MetricRelationGenerator extends NewlyInstallSqlGenerator {

    @Override
    protected String generateSql(List<XmlTemplate> xmlObject) {
        return null;
    }

    @Override
    public StringBuilder buildSql(String sql, StringBuilder sqlBuilder) {
        return null;
    }

    @Override
    protected void exportToFile(String sql) {

    }
}
