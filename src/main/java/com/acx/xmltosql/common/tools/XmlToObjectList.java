package com.acx.xmltosql.common.tools;

import com.acx.xmltosql.common.InputArgs;
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

    public List<XmlTemplate> loadFile() {
        // Create a list to store parsed XML objects
        List<XmlTemplate> xmlObjectList = new ArrayList<>();

        // Recursively get all XML files from the directory
        List<File> xmlFiles = getXmlFilesRecursively(new File(inputArgs.getXmlDirectoryPath()));

        for (File file : xmlFiles) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(XmlTemplate.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                XmlTemplate xmlTemplate = (XmlTemplate) jaxbUnmarshaller.unmarshal(file);

                // Calculate XML's hash ID
                NameToIdUtil nameToIdUtil = new NameToIdUtil();
                xmlTemplate.setHashcode(nameToIdUtil.getStrHashCode(xmlTemplate.getName()));

                // Add the object to the list
                xmlObjectList.add(xmlTemplate);

            } catch (JAXBException e) {
                logger.error("Error occurred while unmarshalling XML: ", e);
                e.printStackTrace();
            }
        }

        return xmlObjectList;
    }

    // Recursively retrieve all XML files in the directory and its subdirectories
    private List<File> getXmlFilesRecursively(File directory) {
        List<File> xmlFiles = new ArrayList<>();

        // List files and directories in the current directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursively collect files from subdirectories
                    xmlFiles.addAll(getXmlFilesRecursively(file));
                } else if (file.isFile() && file.getName().toLowerCase().endsWith(".xml")) {
                    // Add XML file to the list
                    xmlFiles.add(file);
                }
            }
        }

        return xmlFiles;
    }
}
