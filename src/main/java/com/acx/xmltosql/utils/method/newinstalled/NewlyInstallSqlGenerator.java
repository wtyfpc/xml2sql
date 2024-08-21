package com.acx.xmltosql.utils.method.newinstalled;

import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.method.BaseSqlGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public abstract class NewlyInstallSqlGenerator extends BaseSqlGenerator implements INewlyInstallSqlGenerator{

    @Override
    public final void exec(List<XmlTemplate> xmlObject){
        String sql = generateSql(xmlObject);
        exportToFile(sql);
    }

    //拼接SQL字符串
    public StringBuilder buildSql(String sql,StringBuilder sqlBuilder){
        sqlBuilder.append(sql).append("\n");
        return sqlBuilder;
    }


}
