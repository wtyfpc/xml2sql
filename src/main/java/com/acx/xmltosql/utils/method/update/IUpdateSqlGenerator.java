package com.acx.xmltosql.utils.method.update;

import com.acx.xmltosql.model.XmlTemplate;

import java.util.List;

public interface IUpdateSqlGenerator {
    public void exec(List<XmlTemplate> xmlObject);
}
