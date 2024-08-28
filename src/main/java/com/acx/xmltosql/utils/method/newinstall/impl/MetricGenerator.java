package com.acx.xmltosql.utils.method.newinstall.impl;

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
import java.util.*;
import java.util.stream.Collectors;

@Component("newInstallMetricGenerator")
public class MetricGenerator extends NewlyInstallSqlGenerator {

    private static final Logger logger = LoggerFactory.getLogger(MetricGenerator.class);

    private StringBuilder sqlBuilder;
    @Autowired
    private final InputArgs inputArgs;
    private final String sqlFilePath;

    public MetricGenerator(InputArgs inputArgs) {
        this.inputArgs = inputArgs;
        this.sqlFilePath = inputArgs.getSqlFilePath() + "gv_collection_metric.sql";
        this.sqlBuilder = new StringBuilder(); // 在构造函数中初始化 StringBuilder
    }

    @Override
    public String generateSql(List<XmlTemplate> xmlTemplateList){
        //存储筛选过的指标
        List<ResMetric> resMetricList= new ArrayList<>();
        //筛选指标
        resMetricList = filterResMetic(xmlTemplateList);
        for(ResMetric resMetric : resMetricList) {
                String sql = parseXmlObject(resMetric);
                sqlBuilder = buildSql(sql,sqlBuilder);
        }
        return sqlBuilder.toString();
    }


    @Override
    public void exportToFile(String sql) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sqlFilePath, true))) {
            writer.write(sql);
            writer.newLine();
        } catch (IOException e) {
            logger.error("导出指标SQL异常");
            e.printStackTrace();
        }
    }

    protected static String parseXmlObject(ResMetric resMetric) {
        return String.format(
                "INSERT INTO gv_collection_metric (name, collector, display_name ,description ,data_type, unit" +
                        "part_type ,collect_interval ,iscollect, pre_process, post_process, collect_mode, batch_group" +
                        ", priority, collect_protocol, protocol_param, value_keyword, value_range, value_mapping, " +
                        "introduced_version, last_modify_version) " +
                        "VALUES ('%s', '%s','%s', '%s', %d, '%s','%s', %d, %d, '%s','%s', %d,'%s', %d,'%s', '%s'," +
                        "'%s', '%s','%s', '%s','%s');",
                resMetric.getName(),resMetric.getCollector(),resMetric.getDisplayName(),resMetric.getDescription()
                ,resMetric.getDataType(),resMetric.getUnit(),resMetric.getPartType(), resMetric.getCollectInterval(),
                resMetric.getIsCollect(),resMetric.getPreProcess(),resMetric.getPostProcess(),resMetric.getCollectMode()
                ,resMetric.getBatchGroup(),resMetric.getPriority(),resMetric.getCollectProtocol(),resMetric.getProtocolParam()
                ,resMetric.getValueKeyword(),resMetric.getValueRange(),resMetric.getValueMapping()
                ,resMetric.getCreateVersion(),resMetric.getLastModifyVersion()
        );
    }

    protected static List<ResMetric> filterResMetic(List<XmlTemplate> xmlTemplateList){
        Map<String,ResMetric> maxLastModifyVersionResMetric= xmlTemplateList.stream()
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
        //将maxLastModifyVersionResMetric存入列表里面
        List<ResMetric> resMetricList = new ArrayList<>(maxLastModifyVersionResMetric.values());

        return resMetricList;
    }






}
