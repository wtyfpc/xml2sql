package com.acx.xmltosql.utils.method.update.impi;

import com.acx.xmltosql.common.init.InputArgs;
import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.method.update.UpdateSqlGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Component("updateMetricTemplGenerator")
public class MetricTemplGenerator extends UpdateSqlGenerator {

    private static final Logger logger = LoggerFactory.getLogger(com.acx.xmltosql.utils.method.newinstall.impl.MetricTemplGenerator.class);

    private StringBuilder sqlBuilder;

    @Autowired
    private final InputArgs inputArgs;
    private final String sqlFilePath;
    private final String currentVersion;

    public MetricTemplGenerator(InputArgs inputArgs) {
        this.inputArgs = inputArgs;
        this.sqlFilePath = inputArgs.getSqlFilePath() + "gv_collection_metric_templ.sql";
        this.currentVersion = inputArgs.getCurrentVersion();
        this.sqlBuilder = new StringBuilder();
    }

    @Override
    protected String generateSql(List<XmlTemplate> xmlTemplateList) {
        for(XmlTemplate xmlTemplate : xmlTemplateList) {
            String sql = null;
            if(currentVersion.equals(xmlTemplate.getIntroduce())){
                sql = parseXmlObject2Insert(xmlTemplate);
            }
            else{
                if(currentVersion.equals(xmlTemplate.getLastModify())){
                    sql = parseXmlObject2Update(xmlTemplate);
                }
                else{
                    continue;
                }
            }
            sqlBuilder = buildSql(sql,sqlBuilder);
        }
        return sqlBuilder.toString();
    }


    private static String parseXmlObject2Insert(XmlTemplate xmlTemplate) {
        return String.format(
                "INSERT INTO gv_collection_metric_templ (id ,name, creator, visiable, description, create_version, last_modify_version) " +
                        "VALUES (%d ,'%s', '%s', %d, '%s', '%s', '%s');",
                xmlTemplate.getHashcode(),xmlTemplate.getName(),xmlTemplate.getCreator(),xmlTemplate.getVisiable(),xmlTemplate.getDescription(),xmlTemplate.getIntroduce(),xmlTemplate.getLastModify()
        );
    }

    private static String parseXmlObject2Update(XmlTemplate xmlTemplate) {
        return String.format(
                "UPDATE gv_collection_metric_templ " +
                        "SET name = '%s', creator = '%s',visiable = %d, description = '%s', create_version = '%s', last_modify_version = '%s' " +
                        "WHERE name = '%s';",
                xmlTemplate.getName(),
                xmlTemplate.getCreator(),
                xmlTemplate.getVisiable(),
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
