package com.acx.xmltosql.common;
import com.beust.jcommander.Parameter;

public class InputArgs {
    @Parameter(names = {"-d", "--deployment"}, description = "Select installation mode (newinstall/update)")
    private String deployment = "update";

    @Parameter(names = {"-x", "--xml.directory.path"}, description = "xml file address")
    private String xmlDirectoryPath = "./xml";

    @Parameter(names = {"-s", "--sql.file.path"}, description = "SQL file location")
    private String sqlDirectoryPath = "./data/sql/";

    @Parameter(names = {"-l", "--log_path"}, description = "Log path")
    private String logPath = "./data/log";

    @Parameter(names = {"-c", "--current_time"},description = "Input current version")
    private String currentVersion = "6.6";

    // Getter methods
    public String getDeployment() {
        return deployment;
    }

    public String getXmlDirectoryPath() {
        return xmlDirectoryPath;
    }

    public String getSqlFilePath(){
        return sqlDirectoryPath;
    }


    public String getLogPath(){
        return logPath;
    }

    public String getCurrentVersion(){
        return currentVersion;
    }

}
