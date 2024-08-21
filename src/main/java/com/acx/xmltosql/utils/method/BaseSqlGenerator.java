package com.acx.xmltosql.utils.method;

import com.acx.xmltosql.model.XmlTemplate;

import java.util.List;

public abstract class BaseSqlGenerator{

    protected abstract String generateSql(List<XmlTemplate> xmlObject);

    // 导出生成的SQL语句到指定文件
    public abstract void exportToFile(String sql);
}
