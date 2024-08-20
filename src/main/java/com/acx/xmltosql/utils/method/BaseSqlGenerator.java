package com.acx.xmltosql.utils.method;

import com.acx.xmltosql.model.XmlTemplate;

import java.util.List;

public abstract class BaseSqlGenerator{

    protected abstract String generateSql(List<XmlTemplate> xmlObject);

    protected abstract void exportToFile(String sql);

}
