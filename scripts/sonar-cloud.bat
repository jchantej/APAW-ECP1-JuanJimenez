@echo off
set workspace=C:\Users\Chante\Documents\ProyectosEclipce\Patrones.JuanJimenez
::Las variables de entorno se pueden configurar directamente en Windows cuando se tienen los permisos necesarios
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_60
set M2_HOME=C:\Archivos_de_Programa\apache-maven-3.5.0
set PATH=%PATH%;%JAVA_HOME%\bin;%M2_HOME%\bin
echo -----------------------------------------
echo . (C) MIW - UPM
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo JAVA_HOME --- %JAVA_HOME%
echo M2_HOME   --- %M2_HOME%
echo .
cd %workspace%
echo ============ mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent verify --settings settings.xml ... ==================
echo . Se prepara cobertura
call mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent verify --settings settings.xml

echo ============ mvn sonar:sonar ... =======================================================
echo . Se analiza y sube a sonar cloud
call mvn sonar:sonar -Dsonar.organization=jchantej-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=1c003e675d1fcb22c590389e93d1a6b639c46e62 --settings settings.xml
pause
