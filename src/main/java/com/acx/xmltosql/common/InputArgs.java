package com.acx.xmltosql.common;
import com.beust.jcommander.Parameter;

public class InputArgs {
    @Parameter(names = {"-d", "--deployment"}, description = "Select installation mode")
    private String deployment = "newly_installed";

    @Parameter(names = {"-x", "--xml.directory.path"}, description = "xml file address")
    private String xmlDirectoryPath = "./xml";

    @Parameter(names = {"-metric_templ", "--sql.gv_collection_metric_templ.file.path"}, description = "Indicator template file location")
    private String metricTemplFilePath = "./data/sql/gv_collection_metric_templ.sql";

    @Parameter(names = {"-metric_templ_relation", "--sql.gv_collect_template_metric_relation.file.path"}, description = "Indicator template indicator association relationship table")
    private String templateMetricRelationFilePath = "./data/sql/gv_collect_template_metric_relation.sql";

    @Parameter(names = {"-metric", "--sql.gv_collection_metric.file.path"}, description = "Indicator table")
    private String metricFilePath = "./data/sql/gv_collect_new.sql";

    @Parameter(names = {"-l", "--log_path"}, description = "Log path")
    private String logPath = "./data/log";

    // Getter methods
    public String getDeployment() {
        return deployment;
    }

    public String getXmlDirectoryPath() {
        return xmlDirectoryPath;
    }

    public String getMetricTemplFilePath(){
        return metricTemplFilePath;
    }

    public String getTemplateMetricRelationFilePath(){
        return templateMetricRelationFilePath;
    }

    public String getMetricFilePath(){
        return metricFilePath;
    }

    public String getLogPath(){
        return logPath;
    }

}
