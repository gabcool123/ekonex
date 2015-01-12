<?php
try{
    $ip = 'localhost';
    $username = 'root';
    $password = '';
    $bdd = mysql_connect($ip,$username,$password);
    $dbname = mysql_select_db('website');
}catch(Exception $e){
    echo 'Connection impossible à mysql',$e->getMessage();
    die();
}

