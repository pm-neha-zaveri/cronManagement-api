#!/bin/bash

# This Script is used to details of cronlogs which are executed on server
# The cronlogs read by shell script from Fixed Logging location of crons
#
# The serverips provided in ip.conf are requested for giving data of cronlogs in one hit
# This script will do ssh login and reads the cronlog file for current day
#
# RUN : ./cron_scripts/remote_cron_logs.sh >/dev/null

# STEP 1 : Get the program execution directory.
PRG=$0
while [ -h "$PRG" ] ; do
	LS=`ls -ld "$PRG"`
	LINK=`expr "$LS" : '.*-> \(.*\)$'`
	if expr "$LINK" : '.*/.*' > /dev/null; then
	PRG="$LINK"
	else
	PRG=`dirname "$PRG"`/"$LINK"
	fi
done

# STEP 2 : Saving directory locations in variable
PRGDIR=`dirname "$PRG"`
CONFIGDIR=$PRGDIR/config

# get current date
year=$(date "+%Y")
month=$(date "+%m")
day=$(date "+%d")

DATE=$year-$month-$day

# Reading config parameter from the config file.
USERNAME=$(cat $CONFIGDIR/config.properties | grep server.username | cut -d '=' -f2)	
PASSWORD=$(cat $CONFIGDIR/config.properties | grep server.password | cut -d '=' -f2)
CRON_LOG_REMOTE_LOCATION=$(cat $CONFIGDIR/config.properties | grep cronlogs.remotelocation | cut -d '=' -f2)

# Command which will check crons logs on server
CMD="cat $CRON_LOG_REMOTE_LOCATION/cron_log_$DATE.log";

# For each server in the configuration file execute the command
for HOST in $(cat $CONFIGDIR/ip.conf)
do

	# do login to server using the utility expect which takes username and password.
	# get sudo access for running command
	# run command
	VAR=$(expect -c "spawn ssh -o StrictHostKeyChecking=no $USERNAME@$HOST $CMD
            		 match_max 100000
            		 expect \"*?assword:*\"
            		 send -- \"$PASSWORD\r\"
            		 send -- \"\r\"
            		 expect eof
            ")

	echo "$VAR" > tempResult ;
        echo "$(tail -n +3 tempResult)" > tempResult
	cat tempResult	    
	rm tempResult;
done
