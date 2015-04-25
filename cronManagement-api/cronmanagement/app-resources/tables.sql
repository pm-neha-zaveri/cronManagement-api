CREATE TABLE `cron_forecasting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cron_id` bigint(20) NOT NULL,
  `server_id` bigint(20) NOT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `run_time` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE `cron_alert` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cron_id` bigint(20) NOT NULL,
  `server_id` bigint(20) NOT NULL,
  `dc_id` bigint(20) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `run_time` int(11) DEFAULT NULL,
  `threshold` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

 CREATE TABLE `cron_log_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cron_id` bigint(20) NOT NULL,
  `server_id` bigint(20) NOT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `run_time` int(11) DEFAULT NULL,
  `threshold` smallint(6) DEFAULT NULL,
  `processId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `cronjob` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serverId` int(11) NOT NULL,
  `scheduleexpr` varchar(55) NOT NULL,
  `name` varchar(255) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT 'ACTIVE',
  `cronType` varchar(55) DEFAULT 'ReportingCron',
  `threshold` int(10) unsigned NOT NULL DEFAULT '0',
  `noOfRuns` int(10) unsigned NOT NULL DEFAULT '0',
  `noOfAlerts` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
)

CREATE TABLE `datacenter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dcName` varchar(255) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  `longitude` varchar(45) DEFAULT NULL,
  `dcHealth` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

 CREATE TABLE `server` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serverIp` varchar(45) DEFAULT NULL,
  `dcId` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `server_health` int(3) DEFAULT '10',
  PRIMARY KEY (`id`)
);

update cron_log_history clh set clh.server_id = (select id from cronjob cj where cj.id=clh.cron_id);

update cron_forecasting cf set server_id= (select id from cronjob cj where cj.id=cf.cron_id);

update cron_alert ca set server_id=(select id from cronjob cj where cj.id=ca.cron_id);

alter table cronjob modify column threshold int(10) UNSIGNED NOT NULL Default 0;
 
alter table cronjob modify column noOfRuns int(10) UNSIGNED NOT NULL Default 0;
  
alter table cronjob modify column noOfAlerts int(10) UNSIGNED NOT NULL;

ALTER TABLE `cronmanagement`.`cronjob` CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT  ;
