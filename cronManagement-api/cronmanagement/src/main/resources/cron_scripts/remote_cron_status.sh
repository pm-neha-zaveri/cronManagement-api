#!/bin/bash

HOST=$1
CronName=$2

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

	# reading username and password from the config file.
	USERNAME=$(cat $CONFIGDIR/config.properties | grep server.username | cut -d '=' -f2)	
	PASSWORD=$(cat $CONFIGDIR/config.properties | grep server.password | cut -d '=' -f2)

	CMD="ps ax | grep -v grep | grep  $CronName";

	VAR=$(expect -c "
            spawn ssh -o StrictHostKeyChecking=no $USERNAME@$HOST
            match_max 100000
            expect \"*?assword:*\"
            send -- \"$PASSWORD\r\"
	    expect -- \"*@*\"
    	    send -- \"#start\r\"
	    send -- \"$CMD\r\"	
    	    send -- \"#end\r\"
            expect eof
            ")

		echo "$VAR" > tempResult ;
	        RESULT=$(sed -n "/start/,/end/p" tempResult);
		rm tempResult;
		number_of_occurrences=$(grep -o "$CronName" <<< "$RESULT" | wc -l)
		if [ $number_of_occurrences == 2 ]
		then
			echo false
		else
			echo true
		fi


