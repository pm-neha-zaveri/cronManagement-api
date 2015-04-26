<?php

/* UnComment this line while debugging code */

error_reporting(E_ERROR | E_PARSE);

/* 

Command Line Arguments passed to this script:

    1. Cron Name
    2. Datacenter Name
    3. Server IP Address
    4. Time taken by Cron Job
    5. Threshold set for Cron

*/

$CRON = $argv[1];
$DC = $argv[2];
$IP = $argv[3];
$T_TAKEN = $argv[4];
$THRESHOLD = $argv[5];

$ALERT_SERVER = "172.16.14.229";
$ALERT_SERVER_PORT = "8080";

/* 
    Check if Time taken by Cron is more than threshold value
    if yes then send notification to alerting framework which will later pushed to users subscribed for the same. 
*/

if ($T_TAKEN > $THRESHOLD ) {
        
    send_alert($DC, $IP, $T_TAKEN, $THRESHOLD, $CRON, $ALERT_SERVER, $ALERT_SERVER_PORT);

}

/* 
    Code to send notification to alerting framework. 
*/
function send_alert($DC, $IP, $T_TAKEN, $THRESHOLD, $CRON, $ALERT_SERVER, $ALERT_SERVER_PORT) {
        

    /* GET THE ALERT SERVER FROM CONFIG OBJECT */

    /* prepare the json to be sent over the http request to Alerting Server. */

        $json='{"publishAlert": {"alertId": 55,"recCreModule": "PHP","recCreUser": 0,"userType": "A"},"publishAlertParams":';
        $json = $json . ' [{"keyString": "DC","valueString": "' . $DC . '"},';
        $json = $json . ' {"keyString": "IP","valueString": "' . $IP . '"},';
        $json = $json . ' {"keyString": "CRON","valueString": "' . $CRON . '"},';
        $json = $json . ' {"keyString": "TIME","valueString": " ' . $T_TAKEN . '"},';
        $json = $json . ' {"keyString": "THRESHOLD","valueString": "' . $THRESHOLD . '"}]}';

        $url = "http://$ALERT_SERVER:$ALERT_SERVER_PORT/alerts/AlertServlet?";

        echo "$json\n";

        /* Post data consist of json and file which has to be sent over the alert email. */
        /*
            Use following syntax when attachment has to be sent along with email alert.
            //$postdata=array("file"=>"Filename","operId"=>"1","jsonString"=>"".$json);
        */

        $postdata=array("operId"=>"1","jsonString"=>"".$json);

        /* CURL Initiallization */
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_HTTPHEADER, array("Content-type: multipart/form-data"));
        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $postdata);
        $result = curl_exec($ch);

        /* PRINT RESPONSE FROM ALERTING SERVICE */
        print_r($result);   

        /* CLOSE THE CURL HANDLE */
        curl_close($ch);

}
