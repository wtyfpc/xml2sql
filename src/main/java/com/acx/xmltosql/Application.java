package com.acx.xmltosql;
import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.XmlToObjectList;
import com.acx.xmltosql.utils.method.newinstalled.impl.MetricTemplGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private XmlToObjectList xmlToObjectList;

    @Autowired
    private MetricTemplGenerator metricTemplGenerator;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<XmlTemplate>  xmlObjectList = xmlToObjectList.loadfile();
        String sql = metricTemplGenerator.generateSql(xmlObjectList);
        System.out.println(sql);
        metricTemplGenerator.exportToFile(sql);
    }

}

