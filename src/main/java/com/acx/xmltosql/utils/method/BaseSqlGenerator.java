package com.acx.xmltosql.utils.method;

import com.acx.xmltosql.model.ResMetric;
import com.acx.xmltosql.model.XmlTemplate;

import java.util.*;
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
        //记录元素的顺序；因为经过之后的流式操作后，列表中元素的顺序会发生改变
        //需求：需要保证结果List中各个指标的顺序与模板中的指标顺序一致，因为乱序更新指标不是很方便
        Set<String> set = new LinkedHashSet<>();
        for(XmlTemplate xmlTemplate : xmlTemplateList){
            for(ResMetric resMetric : xmlTemplate.getMetrics().getResmetrics()){
                set.add(resMetric.getName());
            }
        }

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
        
        List<ResMetric> resMetricList1 = new ArrayList<>(maxLastModifyVersionResMetric.size());
        for(String key : set){

            ResMetric resMetric = maxLastModifyVersionResMetric.get(key);
            resMetricList1.add(resMetric);
        }
        //return resMetricList;
        return resMetricList1; //sql语句中指标出现顺序与xml文件中指标顺序一致
    }

}
