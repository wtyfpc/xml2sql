package com.acx.xmltosql.utils.draw.impl;
import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.draw.IDrawMethod;
import com.acx.xmltosql.utils.method.newinstalled.impl.MetricGenerator;
import com.acx.xmltosql.utils.method.newinstalled.impl.MetricRelationGenerator;
import com.acx.xmltosql.utils.method.newinstalled.impl.MetricTemplGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrawNewlyInstall implements IDrawMethod {

    @Autowired
    MetricTemplGenerator metricTemplGenerator;
    @Autowired
    MetricRelationGenerator metricRelationGenerator;
    @Autowired
    MetricGenerator metricGenerator;

    @Override
    public void draw(List<XmlTemplate> xmlObject){
        metricTemplGenerator.exec(xmlObject);
        metricGenerator.exec(xmlObject);
        metricRelationGenerator.exec(xmlObject);
    }


}
