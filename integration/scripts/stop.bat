ECHO OFF
cd /d %~dp0
for /f "tokens=2* delims= " %%F IN ('vagrant status ^| find /I "default"') DO (SET "STATE=%%F%%G")

IF "%STATE%" EQU "running" (
  ECHO Stopping Vagrant VM (Destroy)
  vagrant halt --force
) ELSE (
  ECHO Vagrant VM is not running
)

if errorlevel 1 (
  ECHO FAILURE! Vagrant VM unresponsive...
)
