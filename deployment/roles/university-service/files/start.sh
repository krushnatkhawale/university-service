#!/usr/bin/env bash

sudo rm -f university-service.deleted

nohup java -jar university-service.jar & echo $! > university-service.pid &