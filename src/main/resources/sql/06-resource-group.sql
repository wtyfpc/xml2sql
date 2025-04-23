DROP TABLE IF EXISTS `gv_resource_group`;
CREATE TABLE `gv_resource_group`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分组ID',
  `TYPE` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '分组类型(RESOURCE-资产分组，SERVICE-服务分组)',
  `NAME` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '分组名称',
  `CATEGORY` bigint(22) NOT NULL COMMENT '分组大类(对应CMDB的资产大类)',
  `ROLE` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '分组角色(对应CMDB的资产角色)',
  `IS_PRESET` varchar(8) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '是否预置(YES-是，NO-否)',
  `STATUS` varchar(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '分组状态(ENABLE-启用，DISABLE-停用)',
  `CREATOR` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '创建人',
  `CREATOR_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `NAME_UNI_INDEX`(`NAME`) USING BTREE COMMENT '分组名称唯一索引',
  INDEX `TYPE_INDEX`(`TYPE`) USING BTREE COMMENT '分组类型索引'
) ENGINE = InnoDB AUTO_INCREMENT = 10000930027 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '分组表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of gv_resource_group
-- ----------------------------
INSERT INTO `gv_resource_group` VALUES (10000010000, 'RESOURCE', '服务器-管理节点', 10002, '管理节点', 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000020000, 'RESOURCE', '服务器-登录节点', 10002, '登录节点', 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000030000, 'RESOURCE', '服务器-计算节点', 10002, '计算节点', 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000040000, 'RESOURCE', '服务器-存储节点', 10002, '存储节点', 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000050000, 'RESOURCE', '服务器-裸金属', 10002, '裸金属', 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000060000, 'RESOURCE', '服务器-功能节点', 10002, '功能节点', 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000070000, 'RESOURCE', '服务器-其他', 10002, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000080000, 'RESOURCE', '存储服务器', 10819, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000090000, 'RESOURCE', '虚拟主机', 10601, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000100000, 'RESOURCE', '刀片机箱', 10009, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000110000, 'RESOURCE', '一拖二机柜', 10823, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000120000, 'RESOURCE', '以太网交换机', 10001, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000130000, 'RESOURCE', '以太网交换模块', 10808, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000140000, 'RESOURCE', '抗DDOS', 10031, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000150000, 'RESOURCE', '负载均衡', 10033, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000160000, 'RESOURCE', '防火墙', 10032, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000170000, 'RESOURCE', 'IB交换机', 10202, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000180000, 'RESOURCE', '磁盘阵列', 10006, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000190000, 'RESOURCE', '存储系统', 10008, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000200000, 'RESOURCE', 'CDM', 10824, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000210000, 'RESOURCE', 'PDM', 10825, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000220000, 'SERVICE', 'EFile服务', 400028, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000230000, 'SERVICE', 'EShell服务', 400029, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000240000, 'SERVICE', 'Mysql服务', 400044, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000250000, 'SERVICE', 'Redis服务', 400057, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000260000, 'SERVICE', 'OpenSM服务', 400034, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000270000, 'SERVICE', 'Slurm主控服务(slurmctld)', 400070, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000280000, 'SERVICE', 'Slurm记账服务(slurmdbd)', 400069, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000290000, 'SERVICE', 'Slurm认证服务(munged)', 400068, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000300000, 'SERVICE', 'LDAP认证服务(slapd)', 400074, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000310000, 'SERVICE', 'Gridview服务', 400033, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000320000, 'SERVICE', '网关微服务(acx-gateway)', 400013, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000330000, 'SERVICE', '资产管理微服务(acx-cmdb)', 400008, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000340000, 'SERVICE', '告警微服务(acx-alarm)', 400004, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000350000, 'SERVICE', '监控可视化微服务(acx-clustermonitor)', 400007, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000360000, 'SERVICE', '采集微服务(acx-collector)', 400009, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000370000, 'SERVICE', '应用中心微服务(acx-appcenter)', 400005, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000380000, 'SERVICE', '商务数据分析微服务(acx-bizanalysis)', 400006, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000390000, 'SERVICE', '计费系统微服务(acx-fund)', 400012, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000400000, 'SERVICE', '作业汇聚微服务(acx-jobgather)', 400016, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000410000, 'SERVICE', '调度业务管理微服务(acx-jobmgt)', 400017, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000420000, 'SERVICE', '资源管理微服务(acx-resource)', 400020, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000430000, 'SERVICE', '用户管理微服务(acx-user)', 400021, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000440000, 'SERVICE', 'Docker服务', 400026, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000450000, 'SERVICE', 'Etcd服务', 400030, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000460000, 'SERVICE', 'Flanneld服务', 400031, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000470000, 'SERVICE', 'FreeIPMI服务', 400032, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000480000, 'SERVICE', 'HTTPD', 400078, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000490000, 'SERVICE', 'Imageshub服务', 400035, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000500000, 'SERVICE', 'InfluxDB服务', 400036, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000510000, 'SERVICE', 'LDAP客户端认证服务(sssd)', 400073, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000520000, 'SERVICE', 'LDAP客户端认证服务(nscd)', 400071, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000530000, 'SERVICE', 'LDAP客户端认证服务(nslcd)', 400072, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000540000, 'SERVICE', '消息微服务(acx-message)', 400043, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000550000, 'SERVICE', 'Nacos服务', 400045, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000560000, 'SERVICE', 'Nginx服务', 400047, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000570000, 'SERVICE', 'Slurm计费服务', 400060, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000580000, 'SERVICE', 'Slurm文件同步服务(Rsyncd)', 400061, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000590000, 'SERVICE', 'SSH服务', 400063, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000600000, 'SERVICE', 'Tomcat服务', 400064, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000610000, 'SERVICE', 'WORKORDER', 400082, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000620000, 'SERVICE', 'xxl-job服务', 400067, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000630000, 'SERVICE', 'ActiveMQ消息队列服务', 400001, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000640000, 'SERVICE', 'AI社区模型数据集(acx-aihub)', 400002, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000650000, 'SERVICE', 'AI管理平台侧服务(acx-aimgt)', 400003, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000660000, 'SERVICE', '容器管理微服务(acx-containermgt)', 400010, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000670000, 'SERVICE', '数据资产管理微服务(acx-dataasset)', 400011, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000680000, 'SERVICE', '镜像管理微服务(acx-imagemgt)', 400014, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000690000, 'SERVICE', 'AI推理服务(acx-inference)', 400015, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000700000, 'SERVICE', '作业调度微服务(acx-jobsched)', 400018, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000710000, 'SERVICE', '平台配置微服务(acx-platform)', 400019, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000720000, 'SERVICE', '用户管理代理微服务(acx-useragent)', 400022, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000730000, 'SERVICE', 'Chronyd服务', 400023, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000740000, 'SERVICE', 'DCV 网关', 400024, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000750000, 'SERVICE', 'DCV Server', 400025, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000760000, 'SERVICE', 'easyop_rmi', 400027, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000770000, 'SERVICE', 'Kubernetes服务', 400037, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000780000, 'SERVICE', 'Karaf服务', 400038, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000790000, 'SERVICE', 'Keepalived服务', 400039, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000800000, 'SERVICE', 'NFS服务端', 400046, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000810000, 'SERVICE', 'NIS客户端服务', 400048, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000820000, 'SERVICE', 'NIS服务端服务', 400049, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000830000, 'SERVICE', 'noVNC服务', 400050, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000840000, 'SERVICE', 'NTP时间同步服务', 400051, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000850000, 'SERVICE', 'Pbs客户端服务', 400052, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000860000, 'SERVICE', 'Pbs计费服务', 400053, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000870000, 'SERVICE', 'Pbs主服务', 400054, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000880000, 'SERVICE', '快传服务(RaySync)', 400055, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000890000, 'SERVICE', '远程桌面协议(RDP)', 400056, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000900000, 'SERVICE', 'sacp_rmi服务', 400058, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000910000, 'SERVICE', 'VNC服务端服务', 400065, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000920000, 'SERVICE', 'Windows Citrix服务', 400066, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');
INSERT INTO `gv_resource_group` VALUES (10000930000, 'SERVICE', '服务拨测', 20104, NULL, 'YES', 'ENABLE', 'optadmin', '2099-01-01 00:00:00');


DROP TABLE IF EXISTS `gv_resource_group_alarm_template_relation`;
CREATE TABLE `gv_resource_group_alarm_template_relation`  (
  `GROUP_ID` bigint(20) NOT NULL COMMENT '分组ID',
  `ALARM_TEMPLATE_ID` bigint(20) NOT NULL COMMENT '告警模板ID',
  `STATUS` varchar(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '状态(ENABLE-启用，DISABLE-停用)',
  PRIMARY KEY (`GROUP_ID`, `ALARM_TEMPLATE_ID`) USING BTREE,
  INDEX `ALARM_TEMPLATE_ID_INDEX`(`ALARM_TEMPLATE_ID`) USING BTREE COMMENT '告警模板ID索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '告警模板-分组关系表' ROW_FORMAT = DYNAMIC;

DROP TABLE IF EXISTS `gv_resource_group_metric_template_relation`;
CREATE TABLE `gv_resource_group_metric_template_relation`  (
  `GROUP_ID` bigint(20) NOT NULL COMMENT '分组ID',
  `METRIC_TEMPLATE_ID` bigint(20) NOT NULL COMMENT '指标模板ID',
  `STATUS` varchar(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '状态(ENABLE-启用，DISABLE-停用)',
  PRIMARY KEY (`GROUP_ID`, `METRIC_TEMPLATE_ID`) USING BTREE,
  INDEX `METRIC_TEMPLATE_ID_INDEX`(`METRIC_TEMPLATE_ID`) USING BTREE COMMENT '指标模板索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '指标模板-分组关系表' ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Records of gv_resource_group_metric_template_relation
-- -----------------------------------------------------
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000010000, 11483338451, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000010000, 11952731490, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000020000, 11483338451, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000020000, 11952731490, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000030000, 11483338451, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000030000, 11952731490, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000040000, 11483338451, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000040000, 11952731490, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000050000, 11483338451, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000050000, 11952731490, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000060000, 11483338451, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000060000, 11952731490, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000070000, 11483338451, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000070000, 11952731490, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000080000, 11483338451, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000080000, 11952731490, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000090000, 11483338451, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000100000, 11631675128, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000110000, 11559137089, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000120000, 11445354782, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000130000, 11445354782, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000140000, 11678854992, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000170000, 11973629182, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000190000, 12005687380, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000220000, 11187032576, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000230000, 11495879744, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000240000, 11577503092, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000250000, 11117855077, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000260000, 11446608643, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000270000, 11373252470, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000280000, 11652342713, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000290000, 11892718506, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000300000, 11292699538, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000310000, 12001977131, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000320000, 11538665595, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000330000, 11917217189, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000340000, 11614348626, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000350000, 11513478445, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000360000, 12144925710, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000370000, 11667820855, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000380000, 11741143888, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000390000, 11116300216, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000400000, 11951034745, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000410000, 11533140208, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000420000, 11677151871, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000430000, 12018031038, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000440000, 11622071286, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000450000, 11265302726, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000460000, 11150361932, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000470000, 11383939417, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000500000, 11336051850, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000900000, 11137028468, 'ENABLE');
INSERT INTO `gv_resource_group_metric_template_relation` VALUES (10000930000, 11619709857, 'ENABLE');
INSERT INTO gv_cmdb_resource_metric_template_relation (resource_id, template_name) VALUES (1001, 'cluster_metric_template');

DROP TABLE IF EXISTS `gv_resource_group_relation`;
CREATE TABLE `gv_resource_group_relation`  (
  `RESOURCE_ID` decimal(22, 0) NOT NULL COMMENT '资产ID',
  `GROUP_ID` bigint(20) NOT NULL COMMENT '分组ID',
  PRIMARY KEY (`RESOURCE_ID`) USING BTREE,
  INDEX `GROUP_ID_INDEX`(`GROUP_ID`) USING BTREE COMMENT '分组ID索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '资产-分组关系表' ROW_FORMAT = DYNAMIC;