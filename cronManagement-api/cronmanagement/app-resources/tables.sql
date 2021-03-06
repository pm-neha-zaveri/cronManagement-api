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
  `threshold` int(10) unsigned NOT NULL DEFAULT 0,
  `noOfRuns` int(10) unsigned NOT NULL DEFAULT 0,
  `noOfAlerts` int(10) unsigned NOT NULL DEFAULT 0,
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

select count(*) from cron_log_history clh where run_time >= (select threshold from cronjob where id=clh.cron_id) group by clh.cron_id;

select count(*) from cron_log_history clh , cronjob cj where cj.id =clh.cron_id and clh.run_time >= 2700 group by cj.id;

update cronjob set threshold=2700;
alter table cron_log_history drop column threshold;
truncate cron_alert;
insert into cron_alert(cron_id,server_id,start_time,end_time,run_time) select cron_id,server_id,start_time,end_time,run_time from cron_log_history clh where run_time >= (select threshold from cronjob where id=clh.cron_id);
update cron_alert set server_id=(select distinct serverId from cronjob where id=cron_id);
update cron_alert set dc_id=(select distinct dcId from server where id=server_id);
update cron_log_history set server_id=(select distinct serverId from cronjob where id=cron_id);
update cron_forecasting set server_id=(select distinct serverId from cronjob where id=cron_id);

delete from cronjob where serverId=0;
update cronjob set threshold = 2400 where serverId=3;