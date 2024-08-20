package com.acx.xmltosql.utils.method.newinstalled;

import com.acx.xmltosql.model.XmlTemplate;

import java.util.List;

public interface INewlyInstallSqlGenerator {
    public void exec(List<XmlTemplate> xmlObject);
}
