package com.acx.xmltosql.utils.method.newinstall.impl;

import com.acx.xmltosql.common.InputArgs;
import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.method.newinstall.NewlyInstallSqlGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Component("newInstallMetricTemplGenerator")
public class MetricTemplGenerator extends NewlyInstallSqlGenerator {

    private static final Logger logger = LoggerFactory.getLogger(MetricTemplGenerator.class);

    private StringBuilder sqlBuilder;

    @Autowired
    private final InputArgs inputArgs;
    private final String sqlFilePath;

    public MetricTemplGenerator(InputArgs inputArgs) {
        this.inputArgs = inputArgs;
        this.sqlFilePath = inputArgs.getSqlFilePath() + "gv_collection_metric_templ.sql";
        this.sqlBuilder = new StringBuilder(); // 在构造函数中初始化 StringBuilder
    }


    @Override
    public String generateSql(List<XmlTemplate> xmlTemplateList){
        for(XmlTemplate xmlTemplate : xmlTemplateList) {
            String sql = parseXmlObject(xmlTemplate);
            sqlBuilder = buildSql(sql,sqlBuilder);
        }
        return sqlBuilder.toString();
    }


    protected static String parseXmlObject(XmlTemplate xmlTemplate) {
        return String.format(
                "INSERT INTO gv_collection_metric_templ (name, creator, description, create_version, last_modify_version) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s');",
                xmlTemplate.getName(),xmlTemplate.getCreator(),xmlTemplate.getDescription(),xmlTemplate.getIntroduce(),xmlTemplate.getLastModify()
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
