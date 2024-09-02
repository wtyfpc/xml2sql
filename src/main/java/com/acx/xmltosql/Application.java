package com.acx.xmltosql;
import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.common.tools.XmlToObjectList;
import com.acx.xmltosql.utils.draw.IDrawMethod;
import com.acx.xmltosql.utils.draw.SqlCreateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SqlCreateFactory sqlCreateFactory;

    @Autowired
    private XmlToObjectList xmlToObjectList;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(org.springframework.boot.Banner.Mode.OFF); // 关闭启动图标
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<XmlTemplate>  xmlObjectList = xmlToObjectList.loadfile();
        IDrawMethod drawMethod = sqlCreateFactory.getSqlGenerator();
        drawMethod.draw(xmlObjectList);
    }

}

