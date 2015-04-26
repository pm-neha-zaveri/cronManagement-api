	<?php

	class CronFuturePredictor {

	    function httpGet($cronExpr)
	    {
	        $tempCronUrl="http://cron.schlitt.info/index.php?cron=:CRONEXPR&iterations=1";
	        $tempCronUrl=str_replace(':CRONEXPR', $cronExpr, $tempCronUrl);

	        $ch = curl_init();   
	        curl_setopt($ch,CURLOPT_URL,$tempCronUrl);
	        curl_setopt($ch,CURLOPT_RETURNTRANSFER,true);
	        curl_setopt($ch,CURLOPT_HEADER, false); 
	        $output=curl_exec($ch);
	        curl_close($ch);
	        return $output;
	    }

	    function get_string_between($string, $start, $end){
	        $string = " ".$string;
	        $ini = strpos($string,$start);
	        if ($ini == 0) return "";
	        $ini += strlen($start);
	        $len = strpos($string,$end,$ini) - $ini;
	        return substr($string,$ini,$len);
	    }

	    function getFutureCronPredictions($cronExpr){
	        $response=$this->httpGet($cronExpr);
	        $parsed = $this->get_string_between($response, "<ol class='cron'>", "</ol>");
	        $parsed=str_replace('<li>',"", $parsed);
	        $parsed=str_replace('</li>',"", $parsed);
	        $lines = explode(PHP_EOL, $parsed);
	        array_shift($lines);
	        unset($lines[1]);
	        unset($lines[2]);
	        $timeZoneArr=array();
	        foreach ($lines as $key => $value) {
	        	$out=rtrim(shell_exec("date +\"%Y-%m-%d %T\" --date '$value UTC -2 hour'"),"\n");
	        	$timeZoneArr[]=array("timeZone"=>'IST','timeStamp'=>$out);
	        	$out=rtrim(shell_exec("date +\"%Y-%m-%d %T\" --date '$value UTC -14 hour -30 min'"),"\n");
	        	$timeZoneArr[]=array("timeZone"=>'PST','timeStamp'=>$out);
	        	$out=rtrim(shell_exec("date +\"%Y-%m-%d %T\" --date '$value UTC -12 hour -30 min'"),"\n");
	        	$timeZoneArr[]=array("timeZone"=>'EST','timeStamp'=>$out);
	        }
	        return json_encode($timeZoneArr);
	    }

	}


	#$cronExpr = str_replace(' ', '+', $_GET['cron']);
	  $cronExpr = str_replace(' ', '+', '45 * * * *');
	  $obj = new CronFuturePredictor();
	 echo $obj->getFutureCronPredictions($cronExpr);

	?>
