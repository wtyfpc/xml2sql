package com.acx.xmltosql.model;


import jakarta.xml.bind.annotation.XmlAttribute;

public class ResMetric {

    private String name;
//    private String collector;
    private String displayName;
    private String description;
    private byte dataType;
    private String unit;
    private String partType;
    private Integer collectInterval;
    private byte isCollect;
    private String preProcess;
    private String postProcess;
    private byte collectMode;
//    private String batchGroup;
    private byte priority;
//    private String collectProtocol;
//    private String protocolParam;
    private String valueKeyword;
    private String valueRange;
    private String valueMapping;
    private String createVersion;
    private String lastModifyVersion;

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @XmlAttribute(name = "collector")
//    public String getCollector() {
//        return collector;
//    }

//    public void setCollector(String collector) {
//        this.collector = collector;
//    }

    @XmlAttribute(name = "display_name")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @XmlAttribute(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlAttribute(name = "data_type")
    public byte getDataType() {
        return dataType;
    }

    public void setDataType(byte dataType) {
        this.dataType = dataType;
    }

    @XmlAttribute(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @XmlAttribute(name = "part_type")
    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    @XmlAttribute(name = "interval")
    public Integer getCollectInterval() {
        return collectInterval;
    }

    public void setCollectInterval(Integer collectInterval) {
        this.collectInterval = collectInterval;
    }

    @XmlAttribute(name = "iscollect")
    public byte getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(byte isCollect) {
        this.isCollect = isCollect;
    }

    @XmlAttribute(name = "pre_process")
    public String getPreProcess() {
        return preProcess;
    }

    public void setPreProcess(String preProcess) {
        this.preProcess = preProcess;
    }

    @XmlAttribute(name = "post_process")
    public String getPostProcess() {
        return postProcess;
    }

    public void setPostProcess(String postProcess) {
        this.postProcess = postProcess;
    }

    @XmlAttribute(name = "collect_mode")
    public byte getCollectMode() {
        return collectMode;
    }

    public void setCollectMode(byte collectMode) {
        this.collectMode = collectMode;
    }

//    @XmlAttribute(name = "batch_group")
//    public String getBatchGroup() {
//        return batchGroup;
//    }
//
//    public void setBatchGroup(String batchGroup) {
//        this.batchGroup = batchGroup;
//    }

    @XmlAttribute(name = "priority")
    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

//    @XmlAttribute(name = "collect_protocol")
//    public String getCollectProtocol() {return collectProtocol;}
//
//    public void setProtocol(String protocol) {
//        this.collectProtocol = collectProtocol;
//    }
//
//    @XmlAttribute(name = "protocol_param")
//    public String getProtocolParam() {
//        return protocolParam;
//    }

//    public void setProtocolParam(String protocolParam) {
//        this.protocolParam = protocolParam;
//    }

    @XmlAttribute(name = "value_keyword")
    public String getValueKeyword() {
        return valueKeyword;
    }

    public void setValueKeyword(String valueKeyword) {
        this.valueKeyword = valueKeyword;
    }

    @XmlAttribute(name = "value_range")
    public String getValueRange() {
        return valueRange;
    }

    public void setValueRange(String valueRange) {
        this.valueRange = valueRange;
    }

    @XmlAttribute(name = "value_mapping")
    public String getValueMapping() {
        return valueMapping;
    }

    public void setValueMapping(String valueMapping) {
        this.valueMapping = valueMapping;
    }

    @XmlAttribute(name = "create_version")
    public String getCreateVersion() {
        return createVersion;
    }

    public void setCreateVersion(String createVersion) {
        this.createVersion = createVersion;
    }

    @XmlAttribute(name = "last_modify_version")
    public String getLastModifyVersion() {
        return lastModifyVersion;
    }

    public void setLastModifyVersion(String lastModifyVersion) {
        this.lastModifyVersion = lastModifyVersion;
    }
}