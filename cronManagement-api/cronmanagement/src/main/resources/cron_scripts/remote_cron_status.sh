#!/bin/bash
#
# This script is used to check current status of request cron i.e. cron is in RUNNING or NOT RUNNING state
# This script will do ssh login on requested server and will check for process running will requested parameter
# If it found it,then process will return true otherwise false
#
# RUN : ./cron_scripts/remote_cron_logs.sh >/dev/null hostname croncommand

# Getting Parameters (Manadatory parameter)
HOST=$2
CronName=$3

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


# Reading username and password from the config file.
USERNAME=$(cat $CONFIGDIR/config.properties | grep server.username | cut -d '=' -f2)	
PASSWORD=$(cat $CONFIGDIR/config.properties | grep server.password | cut -d '=' -f2)

CMD="ps ax | grep -v grep | grep '$CronName'";

VAR=$(expect -c "spawn ssh -o StrictHostKeyChecking=no $USERNAME@$HOST
            	 match_max 100000
            	 expect \"*?assword:*\"
            	 send -- \"$PASSWORD\r\"
	    	 expect -- \"*@*\"
	    	 send -- \"$CMD\r\"	
            	 send -- \"\r\"
            	 expect eof
    ")

echo "$VAR" > tempResult ;
echo "$(tail -n +9 tempResult)" > tempResult
RESULT=$(cat tempResult)
rm tempResult
		
if [ "$RESULT" == "" ]
then 
	echo "DURING EXECUTION OF CRON SHELL SCRIPT,SOME ERROR OCCURED"
	exit
fi

number_of_occurrences=$(grep -o "$CronName" <<< "$RESULT" | wc -l)
if [ $number_of_occurrences -lt 1 ]
then
	echo "false"
else
	echo "true"
fi
