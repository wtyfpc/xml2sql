package com.acx.xmltosql.utils.method.newinstall.impl;

import com.acx.xmltosql.common.init.InputArgs;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component("newInstallMetricRelationGenerator")
public class MetricRelationGenerator extends NewlyInstallSqlGenerator {

    private static final Logger logger = LoggerFactory.getLogger(MetricRelationGenerator.class);

    @Autowired
    private final InputArgs inputArgs;
    private final String sqlFilePath;
    private StringBuilder sqlBuilder;

    public MetricRelationGenerator(InputArgs inputArgs) {
        this.inputArgs = inputArgs;
        this.sqlFilePath = inputArgs.getSqlFilePath() + "gv_collect_template_metric_relation.sql";
        this.sqlBuilder = new StringBuilder(); // 在构造函数中初始化 StringBuilder
    }

    @Override
    public String generateSql(List<XmlTemplate> xmlTemplateList){
        //创建Set确保指标-模板关联关系关系唯一性
        Set<String> processedNames = new HashSet<>();
        for(XmlTemplate xmlTemplate : xmlTemplateList) {
            for (ResMetric resMetric : xmlTemplate.getMetrics().getResmetrics()) {
                if (processedNames.contains(resMetric.getName())) {
                    continue;
                }
                processedNames.add(resMetric.getName());
                String sql = parseXmlObject(xmlTemplate,resMetric);
                sqlBuilder = buildSql(sql,sqlBuilder);
            }
        }
        return sqlBuilder.toString();
    }


    protected static String parseXmlObject(XmlTemplate xmlTemplate,ResMetric resMetric) {
        return String.format(
                "INSERT INTO gv_collect_template_metric_relation (template_id, metric_name) " +
                        "VALUES (%d, '%s');",
                xmlTemplate.getHashcode(),resMetric.getName()
        );
    }

    @Override
    public void exportToFile(String sql) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sqlFilePath, true))) {
            writer.write(sql);
            writer.newLine();
        } catch (IOException e) {
            logger.error("导出指标模板指标关联关系表SQL异常");
            e.printStackTrace();
        }
    }


}
