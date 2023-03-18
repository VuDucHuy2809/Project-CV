<?php


require_once __DIR__ . '/vendor/autoload.php';

use CKSource\CKFinder\CKFinder;

$ckfinder = new CKFinder(__DIR__ . '/../../../config.php');

$ckfinder->run();
