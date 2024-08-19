package com.acx.xmltosql.utils.impl;

import com.acx.xmltosql.model.ResMetric;
import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.SqlGenerator;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MetricTemplGenerator extends SqlGenerator {

    @Override
    public String generateInsertSql(List<XmlTemplate> xmlTemplateList){
        for(XmlTemplate xmlTemplate : xmlTemplateList) {
            for (ResMetric resMetric : xmlTemplate.getMetrics().getResmetrics()) {
                String sql = parseXmlObject(resMetric);
                System.out.println(sql);
            }
        }
        return null;
    }

    protected static String parseXmlObject(ResMetric metric) {
        return String.format(
                "INSERT INTO gv_collection_metric_templ (name, visiable, description, creator, create_time, last_modify_time) " +
                        "VALUES ('%s', '%s', '%s', '%s', %s, '%s', '%s', %s, %s, '%s', '%s', %s, '%s', %s, '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                metric.getName(), metric.getCollector(), metric.getDisplayName(), metric.getDescription(), metric.getDataType(),
                metric.getUnit(), metric.getPartType(), metric.getCollectInterval(), metric.getIsCollect(), metric.getPreProcess(),
                metric.getPostProcess(), metric.getCollectMode(), metric.getBatchGroup(), metric.getPriority(), metric.getProtocol(),
                metric.getProtocolParam(), metric.getValueKeyword(), metric.getValueRange(), metric.getValueMapping(),
                metric.getCreateVersion(), metric.getLastModifyVersion()
        );
    }

}
