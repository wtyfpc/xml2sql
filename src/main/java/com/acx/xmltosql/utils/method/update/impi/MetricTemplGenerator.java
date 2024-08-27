package com.acx.xmltosql.utils.method.update.impi;

import com.acx.xmltosql.common.InputArgs;
import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.method.update.UpdateSqlGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MetricTemplGenerator extends UpdateSqlGenerator {

    private static final Logger logger = LoggerFactory.getLogger(com.acx.xmltosql.utils.method.newinstall.impl.MetricTemplGenerator.class);

    private StringBuilder sqlBuilder;

    @Autowired
    private final InputArgs inputArgs;
    private final String sqlFilePath;
    private final String currentVersion;

    public MetricTemplGenerator(StringBuilder sqlBuilder, InputArgs inputArgs) {
        this.sqlBuilder = sqlBuilder;
        this.inputArgs = inputArgs;
        this.sqlFilePath = inputArgs.getSqlFilePath() + "gv_collection_metric_templ.sql";
        this.currentVersion = inputArgs.getCurrentVersion();
    }

    @Override
    protected String generateSql(List<XmlTemplate> xmlTemplateList) {
        for(XmlTemplate xmlTemplate : xmlTemplateList) {
            String sql = null;
            if(currentVersion==xmlTemplate.getIntroduce()){
                sql = parseXmlObject2INSERT(xmlTemplate);
            }
            else{
                sql = parseXmlObject2UPDATE(xmlTemplate);
            }
            sqlBuilder = buildSql(sql,sqlBuilder);
        }
        return sqlBuilder.toString();
    }


    protected static String parseXmlObject2INSERT(XmlTemplate xmlTemplate) {
        return String.format(
                "INSERT INTO gv_collection_metric_templ (name, creator, description, create_version, last_modify_version) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s');",
                xmlTemplate.getName(),xmlTemplate.getCreator(),xmlTemplate.getDescription(),xmlTemplate.getIntroduce(),xmlTemplate.getLastModify()
        );
    }

    protected static String parseXmlObject2UPDATE(XmlTemplate xmlTemplate) {
        return String.format(
                "UPDATE gv_collection_metric_templ " +
                        "SET name = '%s', creator = '%s', description = '%s', create_version = '%s', last_modify_version = '%s' " +
                        "WHERE name = '%s';",
                xmlTemplate.getName(),
                xmlTemplate.getCreator(),
                xmlTemplate.getDescription(),
                xmlTemplate.getIntroduce(),
                xmlTemplate.getLastModify(),
                xmlTemplate.getName()
        );
    }


    @Override
    public void exportToFile(String sql) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sqlFilePath, true))) {
            writer.write(sql);
            writer.newLine();
        } catch (IOException e) {
            logger.error("导出指标模板SQL文件");
            e.printStackTrace();
        }
    }
}
