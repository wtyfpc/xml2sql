package com.acx.xmltosql.common;

import com.acx.xmltosql.model.XmlTemplate;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class XmlToObjectList {

    @Autowired
    private InputArgs inputArgs;

    private static final Logger logger = LoggerFactory.getLogger(XmlToObjectList.class);

    void XmlToObject(){

    }

    public List<XmlTemplate> loadfile(){
        // 创建一个文件对象，指向该目录
        File directory = new File(inputArgs.getXmlDirectoryPath());
        // 获取目录下的所有XML文件
        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".xml"));

        // 创建一个List来存放解析后的XML对象
        List<XmlTemplate> xmlObjectList = new ArrayList<>();


        if (files != null) {
            for (File file : files) {
                try {
                    JAXBContext jaxbContext = null;
                    try {
                        jaxbContext = JAXBContext.newInstance(XmlTemplate.class);
                    } catch (JAXBException ex) {
                        logger.error("JAXBException occurred: ", ex);
                        throw new RuntimeException(ex);
                    }

                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    XmlTemplate xmlTemplate = (XmlTemplate) jaxbUnmarshaller.unmarshal(file);

                    // 将对象加入到ArrayList中
                    xmlObjectList.add(xmlTemplate);

                } catch (JAXBException e) {
                    logger.error("JAXBException occurred: ", e);
                    e.printStackTrace();
                }

            }

        }

        return xmlObjectList;

    }
}
