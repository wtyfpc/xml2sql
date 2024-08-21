package com.acx.xmltosql.utils.method.newinstall.impl;

import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.method.newinstall.NewlyInstallSqlGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Component
public class MetricTemplGenerator extends NewlyInstallSqlGenerator {
    private StringBuilder sqlBuilder;

    @Value("${sql.gv_collection_metric_templ.file.path}")
    private String sqlFilePath;

    public MetricTemplGenerator() {
        this.sqlBuilder = new StringBuilder(); // 在构造函数中初始化 StringBuilder
    }

    @Override
    public String generateSql(List<XmlTemplate> xmlTemplateList){
        for(XmlTemplate xmlTemplate : xmlTemplateList) {
//            for (ResMetric resMetric : xmlTemplate.getMetrics().getResmetrics()) {
//                String sql = parseXmlObject(resMetric);
//                System.out.println(sql);
//            }
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
            e.printStackTrace();
        }
    }




}
