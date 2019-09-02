echo "\nProcesses before shutdown:\n" > university-service.deleted

ps -ef | grep "java -jar university-service.jar" | grep ? >> university-service.deleted

echo "\nExisting process pid: $(cat university-service.pid) \n" >> university-service.deleted

echo "\nKilling process with pid - $(cat university-service.pid)\n" >> university-service.deleted

sudo kill -9 $(cat university-service.pid)

sudo rm -f university-service.pid