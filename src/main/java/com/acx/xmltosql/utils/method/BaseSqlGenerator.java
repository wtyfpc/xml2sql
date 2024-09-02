package com.acx.xmltosql.utils.method;

import com.acx.xmltosql.model.ResMetric;
import com.acx.xmltosql.model.XmlTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseSqlGenerator{


    protected abstract String generateSql(List<XmlTemplate> xmlObject);

    // 导出生成的SQL语句到指定文件
    public abstract void exportToFile(String sql);


    /**
     * @author:  caoyonghao
     * @methodsName: 过滤同名指标
     * @param:  xmlTemplateList xml模板对象列表
     * @return: List<ResMetric> 指标对象列表
     * @throws:
     */
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
