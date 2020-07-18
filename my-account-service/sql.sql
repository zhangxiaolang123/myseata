CREATE TABLE `seata_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账户编号',
  `a_money` decimal(10,2) DEFAULT NULL COMMENT '余额',
  `a_create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `a_mark` varchar(200) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='账户信息表';






CREATE TABLE `seata_good` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `g_name` varchar(50) DEFAULT NULL,
  `g_stock` int(11) DEFAULT NULL,
  `g_price` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='商品信息';



CREATE TABLE `seata_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_id` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='订单表';


CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;



LOCK TABLES `seata_account` WRITE;
INSERT INTO `seata_account` VALUES (1,10000.00,'2019-10-11 02:37:35',NULL);
UNLOCK TABLES;


LOCK TABLES `seata_good` WRITE;
INSERT INTO `seata_good` VALUES (1,'华为Meta 30',10,5000.00);
UNLOCK TABLES;




