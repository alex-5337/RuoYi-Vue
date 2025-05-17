DROP TABLE IF EXISTS proj_tenant_info;

-- ----------------------------
-- 1、租客信息表
-- ----------------------------
CREATE TABLE `proj_tenant_info` (
  `tenant_id` int NOT NULL AUTO_INCREMENT COMMENT '租客ID',
  `user_id` int DEFAULT NULL COMMENT '用户ID',
  `id_card` char(18) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` varchar(100) DEFAULT 'N' COMMENT '是否删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `gender` varchar(100) DEFAULT '2' COMMENT '性别',
  `age` int DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `ethnicity` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '民族',
  `education` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学历',
  `company` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '工作单位',
  `hire_date` date DEFAULT NULL COMMENT '入职时间',
  `leave_date` date DEFAULT NULL COMMENT '离职时间',
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `is_employed` varchar(100) DEFAULT 'Y' COMMENT '是否在职',
  `leave_reason` text COLLATE utf8mb4_unicode_ci COMMENT '离职原因',
  `resignation_cert` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '离职证明',
  `department` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在部门',
  `position` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '岗位',
  `job_level` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职级',
  `employee_id` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '工号',
  `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `license_plate` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车牌号',
  `emergency_contact` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '紧急联系人',
  `emergency_phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '紧急联系人电话',
  `marital_status`  varchar(100) DEFAULT '1' COMMENT '婚姻状况',
  `contact_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系地址',
  `entry_time` date DEFAULT NULL COMMENT '入行时间',
  PRIMARY KEY (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='租客信息表';