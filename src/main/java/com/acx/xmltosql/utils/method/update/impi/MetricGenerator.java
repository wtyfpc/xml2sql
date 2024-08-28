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
import java.util.ArrayList;
import java.util.List;

@Component("updateMetricGenerator")
public class MetricGenerator  extends NewlyInstallSqlGenerator {
    private static final Logger logger = LoggerFactory.getLogger(com.acx.xmltosql.utils.method.newinstall.impl.MetricGenerator.class);
    private final String currentVersion;

    private StringBuilder sqlBuilder;
    @Autowired
    private final InputArgs inputArgs;
    private final String sqlFilePath;

    public MetricGenerator(InputArgs inputArgs) {
        this.inputArgs = inputArgs;
        this.sqlFilePath = inputArgs.getSqlFilePath() + "gv_collection_metric.sql";
        this.sqlBuilder = new StringBuilder(); // 在构造函数中初始化 StringBuilder
        this.currentVersion = inputArgs.getCurrentVersion();
    }

    @Override
    public String generateSql(List<XmlTemplate> xmlTemplateList){
        List<ResMetric> resMetricList= new ArrayList<>();
        for(XmlTemplate xmlTemplate : xmlTemplateList) {
            for (ResMetric resMetric : xmlTemplate.getMetrics().getResmetrics()) {
                if(currentVersion.equals(resMetric.getLastModifyVersion())) {
                    String sql = null;
                    if (resMetric.getCreateVersion().equals(resMetric.getLastModifyVersion())) {
                        sql = parseXmlObject2Insert(resMetric);
                    }
                    else{
                        sql = parseXmlObject2Update(resMetric);
                    }
                    sqlBuilder = buildSql(sql, sqlBuilder);
                }
            }
        }
        return sqlBuilder.toString();
    }


    protected static String parseXmlObject2Insert(ResMetric resMetric) {
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

    protected static String parseXmlObject2Update(ResMetric resMetric) {
        return String.format(
                "UPDATE gv_collection_metric SET " +
                        "collector = '%s', " +
                        "display_name = '%s', " +
                        "description = '%s', " +
                        "data_type = %d, " +
                        "unit = '%s', " +
                        "part_type = '%s', " +
                        "collect_interval = %d, " +
                        "iscollect = %d, " +
                        "pre_process = '%s', " +
                        "post_process = '%s', " +
                        "collect_mode = %d, " +
                        "batch_group = '%s', " +
                        "priority = %d, " +
                        "collect_protocol = '%s', " +
                        "protocol_param = '%s', " +
                        "value_keyword = '%s', " +
                        "value_range = '%s', " +
                        "value_mapping = '%s', " +
                        "introduced_version = '%s', " +
                        "last_modify_version = '%s' " +
                        "WHERE name = '%s';",
                resMetric.getCollector(), resMetric.getDisplayName(), resMetric.getDescription(),
                resMetric.getDataType(), resMetric.getUnit(), resMetric.getPartType(),
                resMetric.getCollectInterval(), resMetric.getIsCollect(), resMetric.getPreProcess(),
                resMetric.getPostProcess(), resMetric.getCollectMode(), resMetric.getBatchGroup(),
                resMetric.getPriority(), resMetric.getCollectProtocol(), resMetric.getProtocolParam(),
                resMetric.getValueKeyword(), resMetric.getValueRange(), resMetric.getValueMapping(),
                resMetric.getCreateVersion(), resMetric.getLastModifyVersion(), resMetric.getName()
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
