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
    public abstract StringBuilder buildSql(String sql,StringBuilder sqlBuilder);


    // 导出生成的SQL语句到指定文件
    protected abstract void exportToFile(String sql);


}
