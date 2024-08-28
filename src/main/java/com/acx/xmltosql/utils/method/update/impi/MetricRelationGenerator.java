package com.acx.xmltosql.utils.method.update.impi;

import com.acx.xmltosql.common.InputArgs;
import com.acx.xmltosql.model.ResMetric;
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

@Component("updateMetricRelationGenerator")
public class MetricRelationGenerator  extends NewlyInstallSqlGenerator {

    private static final Logger logger = LoggerFactory.getLogger(MetricRelationGenerator.class);

    @Autowired
    private final InputArgs inputArgs;

    private final String sqlFilePath;
    private final String currentVersion;

    private StringBuilder sqlBuilder;


    public MetricRelationGenerator(InputArgs inputArgs) {
        this.inputArgs = inputArgs;
        this.sqlFilePath = inputArgs.getSqlFilePath() + "gv_collect_template_metric_relation.sql";
        this.currentVersion = inputArgs.getCurrentVersion();
        this.sqlBuilder = new StringBuilder(); // 在构造函数中初始化 StringBuilder
    }


    @Override
    public String generateSql(List<XmlTemplate> xmlTemplateList){
        for(XmlTemplate xmlTemplate : xmlTemplateList) {
            for (ResMetric resMetric : xmlTemplate.getMetrics().getResmetrics()) {
                String sql = null;
                if(currentVersion.equals(xmlTemplate.getIntroduce())){
                    sql = parseXmlObject2Insert(xmlTemplate,resMetric);
                }
                else{
                    if (currentVersion.equals(xmlTemplate.getLastModify())){
                        sql = parseXmlObject2InsertNotExist(xmlTemplate,resMetric);
                    }
                    else{
                        continue;
                    }
                }
                sqlBuilder = buildSql(sql,sqlBuilder);
            }
        }
        return sqlBuilder.toString();
    }

    private static String parseXmlObject2Insert(XmlTemplate xmlTemplate,ResMetric resMetric) {
        return String.format(
                "INSERT INTO gv_collect_template_metric_relation (name, metric_name) " +
                        "VALUES ('%s', '%s');",
                xmlTemplate.getName(),resMetric.getName()
        );
    }

    private static String parseXmlObject2InsertNotExist(XmlTemplate xmlTemplate, ResMetric resMetric) {
        return String.format(
                "INSERT INTO gv_collect_template_metric_relation (name, metric_name) " +
                        "SELECT '%s', '%s' WHERE NOT EXISTS (" +
                        "SELECT 1 FROM gv_collect_template_metric_relation WHERE name = '%s' AND metric_name = '%s');",
                xmlTemplate.getName(), resMetric.getName(), xmlTemplate.getName(), resMetric.getName()
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
