#!/bin/bash

	# get the program execution directory.
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

	#This will the Current Sh Directory
	PRGDIR=`dirname "$PRG"`

	#config directory path.
	CONFIGDIR=$PRGDIR/config

	# get current date
	year=$(date "+%Y")
	month=$(date "+%m")
	day=$(date "+%d")

	DATE=$year-$month-$day

	# reading username and password from the config file.
	USERNAME=$(cat $CONFIGDIR/config.properties | grep server.username | cut -d '=' -f2)	
	PASSWORD=$(cat $CONFIGDIR/config.properties | grep server.password | cut -d '=' -f2)

	# command which will check crons scheduled on servers
	CMD="sudo crontab -l"

	# for each server in the configuration file execute the command
	for HOST in $(cat $CONFIGDIR/ip.conf)
	do

		# do login to server using the utility expect which takes username and password.
		# get sudo access for running command
		# run command
		VAR=$(expect -c "
            		spawn ssh -o StrictHostKeyChecking=no $USERNAME@$HOST $CMD
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
