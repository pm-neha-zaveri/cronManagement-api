#!/bin/bash

# This Script is used to details of crons set in crontab file
# The crons read by shell script are owned by root user i.e. reading crontab file of root user
#
# The serverips provided in ip.conf are requested for giving data of crontab in one hit
# This script will do ssh login and reads the crontab file will sudo readonly access
#
# RUN : ./cron_scripts/list_remote_crons.sh >/dev/null

# STEP 1 : get the program execution directory.
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

# Reading username and password from the config file.
USERNAME=$(cat $CONFIGDIR/config.properties | grep server.username | cut -d '=' -f2)	
PASSWORD=$(cat $CONFIGDIR/config.properties | grep server.password | cut -d '=' -f2)

# Command which will check crons scheduled on servers
CMD="sudo crontab -l"

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

	echo "CRONTAB FILE FOR SERVER:$HOST:DATE:$DATE:";

	echo "$VAR" > tempResult ;
	echo "$(tail -n +3 tempResult)" > tempResult
	cat tempResult
	rm tempResult;
done	
