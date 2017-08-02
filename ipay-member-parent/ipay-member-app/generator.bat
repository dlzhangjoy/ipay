set curdir=%~dp0
@echo curdir:%curdir%
cd /d %curdir%
call mvn mybatis-generator:generate -e
pause