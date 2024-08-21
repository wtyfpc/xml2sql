package com.acx.xmltosql.utils.method.newinstalled.impl;

import com.acx.xmltosql.model.ResMetric;
import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.method.newinstalled.NewlyInstallSqlGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MetricGenerator extends NewlyInstallSqlGenerator {

    private StringBuilder sqlBuilder;
    @Value("${sql.gv_collection_metric.file.path}")
    private String sqlFilePath;

    public MetricGenerator() {
        this.sqlBuilder = new StringBuilder(); // 在构造函数中初始化 StringBuilder
    }

    @Override
    public String generateSql(List<XmlTemplate> xmlTemplateList){
        //TODO
        filterResMetic
        for(XmlTemplate xmlTemplate : xmlTemplateList) {
            for (ResMetric resMetric : xmlTemplate.getMetrics().getResmetrics()) {
                String sql = parseXmlObject(resMetric);
                sqlBuilder = buildSql(sql,sqlBuilder);
            }
        }
        return sqlBuilder.toString();
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

    protected static String parseXmlObject(ResMetric resMetric) {
        return String.format(
                "INSERT INTO gv_collection_metric (name, collector, display_name ,description ,data_type, unit" +
                        "part_type ,collect_interval ,iscollect, pre_process, post_process, collect_mode, batch_group" +
                        ", priority, collect_protocol, protocol_param, value_keyword, value_range, value_mapping, " +
                        "introduced_version, last_modify_version) " +
                        "VALUES ('%s', '%s');",
                resMetric.getName(),resMetric.getCollector(),resMetric.getDisplayName(),resMetric.getDisplayName()
                ,resMetric.getDescription(),resMetric.getDataType(),resMetric.getUnit(),resMetric.getPartType(),
                resMetric.getCollectInterval(),resMetric.getIsCollect(),resMetric.getPreProcess(),resMetric.getPostProcess()
                ,resMetric.getCollectMode(),resMetric.getBatchGroup(),resMetric.getPriority(),resMetric.getCollectProtocol()
                ,resMetric.getProtocolParam(),resMetric.getValueKeyword(),resMetric.getValueRange(),resMetric.getValueMapping()
                ,resMetric.getCreateVersion(),resMetric.getLastModifyVersion()
        );
    }

    protected static Map<String, ResMetric> filterResMetic(List<XmlTemplate> xmlTemplateList){
        return xmlTemplateList.stream()
                .map(XmlTemplate::getMetrics)  // 提取 Metrics 对象
                .flatMap(metrics -> metrics.getResmetrics().stream())  // 获取 ResMetric 列表并展平成单个流
                .collect(Collectors.groupingBy(
                        ResMetric::getName,  // 按 name 字段分组
                        Collectors.collectingAndThen(  // 对分组后的数据进行后处理
                                // 选择每组中 LastModifyVersion 最大的项
                                Collectors.maxBy(Comparator.comparing(ResMetric::getLastModifyVersion)),
                                optional -> optional.orElse(null)
                                )
                        ));
    }






}
