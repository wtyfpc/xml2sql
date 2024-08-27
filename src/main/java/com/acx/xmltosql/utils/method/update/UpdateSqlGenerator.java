package com.acx.xmltosql.utils.method.update;
import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.method.BaseSqlGenerator;
import java.util.List;

public abstract class UpdateSqlGenerator extends BaseSqlGenerator implements IUpdateSqlGenerator {

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
