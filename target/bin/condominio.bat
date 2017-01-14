@REM ----------------------------------------------------------------------------
@REM  Copyright 2001-2006 The Apache Software Foundation.
@REM
@REM  Licensed under the Apache License, Version 2.0 (the "License");
@REM  you may not use this file except in compliance with the License.
@REM  You may obtain a copy of the License at
@REM
@REM       http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM  Unless required by applicable law or agreed to in writing, software
@REM  distributed under the License is distributed on an "AS IS" BASIS,
@REM  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM  See the License for the specific language governing permissions and
@REM  limitations under the License.
@REM ----------------------------------------------------------------------------
@REM
@REM   Copyright (c) 2001-2006 The Apache Software Foundation.  All rights
@REM   reserved.

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup
set REPO=


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\org\apache\wicket\wicket-core\7.6.0\wicket-core-7.6.0.jar;"%REPO%"\org\apache\commons\commons-collections4\4.1\commons-collections4-4.1.jar;"%REPO%"\org\apache\wicket\wicket-request\7.6.0\wicket-request-7.6.0.jar;"%REPO%"\org\apache\wicket\wicket-util\7.6.0\wicket-util-7.6.0.jar;"%REPO%"\commons-fileupload\commons-fileupload\1.3.2\commons-fileupload-1.3.2.jar;"%REPO%"\commons-io\commons-io\2.5\commons-io-2.5.jar;"%REPO%"\org\apache\wicket\wicket-extensions\7.6.0\wicket-extensions-7.6.0.jar;"%REPO%"\org\slf4j\slf4j-api\1.7.21\slf4j-api-1.7.21.jar;"%REPO%"\log4j\log4j\1.2.17\log4j-1.2.17.jar;"%REPO%"\junit\junit\4.12\junit-4.12.jar;"%REPO%"\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;"%REPO%"\org\eclipse\jetty\aggregate\jetty-all-server\8.2.0.v20160908\jetty-all-server-8.2.0.v20160908.jar;"%REPO%"\org\eclipse\jetty\orbit\javax.servlet\3.0.0.v201112011016\javax.servlet-3.0.0.v201112011016.jar;"%REPO%"\org\eclipse\jetty\orbit\javax.security.auth.message\1.0.0.v201108011116\javax.security.auth.message-1.0.0.v201108011116.jar;"%REPO%"\org\eclipse\jetty\orbit\javax.mail.glassfish\1.4.1.v201005082020\javax.mail.glassfish-1.4.1.v201005082020.jar;"%REPO%"\org\eclipse\jetty\orbit\javax.activation\1.1.0.v201105071233\javax.activation-1.1.0.v201105071233.jar;"%REPO%"\org\eclipse\jetty\orbit\javax.annotation\1.1.0.v201108011116\javax.annotation-1.1.0.v201108011116.jar;"%REPO%"\mysql\mysql-connector-java\5.1.40\mysql-connector-java-5.1.40.jar;"%REPO%"\org\hibernate\hibernate-core\5.2.6.Final\hibernate-core-5.2.6.Final.jar;"%REPO%"\org\jboss\logging\jboss-logging\3.3.0.Final\jboss-logging-3.3.0.Final.jar;"%REPO%"\org\hibernate\javax\persistence\hibernate-jpa-2.1-api\1.0.0.Final\hibernate-jpa-2.1-api-1.0.0.Final.jar;"%REPO%"\org\javassist\javassist\3.20.0-GA\javassist-3.20.0-GA.jar;"%REPO%"\antlr\antlr\2.7.7\antlr-2.7.7.jar;"%REPO%"\org\apache\geronimo\specs\geronimo-jta_1.1_spec\1.1.1\geronimo-jta_1.1_spec-1.1.1.jar;"%REPO%"\org\jboss\jandex\2.0.3.Final\jandex-2.0.3.Final.jar;"%REPO%"\com\fasterxml\classmate\1.3.0\classmate-1.3.0.jar;"%REPO%"\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;"%REPO%"\org\hibernate\common\hibernate-commons-annotations\5.0.1.Final\hibernate-commons-annotations-5.0.1.Final.jar;"%REPO%"\javax\enterprise\cdi-api\1.1\cdi-api-1.1.jar;"%REPO%"\javax\el\el-api\2.2\el-api-2.2.jar;"%REPO%"\org\jboss\spec\javax\interceptor\jboss-interceptors-api_1.1_spec\1.0.0.Beta1\jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar;"%REPO%"\javax\annotation\jsr250-api\1.0\jsr250-api-1.0.jar;"%REPO%"\javax\inject\javax.inject\1\javax.inject-1.jar;"%REPO%"\org\luiz\condominiu\0.0.1-SNAPSHOT\condominiu-0.0.1-SNAPSHOT.jar

set ENDORSED_DIR=
if NOT "%ENDORSED_DIR%" == "" set CLASSPATH="%BASEDIR%"\%ENDORSED_DIR%\*;%CLASSPATH%

if NOT "%CLASSPATH_PREFIX%" == "" set CLASSPATH=%CLASSPATH_PREFIX%;%CLASSPATH%

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% -Xmx512m -classpath %CLASSPATH% -Dapp.name="condominio" -Dapp.repo="%REPO%" -Dapp.home="%BASEDIR%" -Dbasedir="%BASEDIR%" Start %CMD_LINE_ARGS%
if %ERRORLEVEL% NEQ 0 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=%ERRORLEVEL%

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@REM If error code is set to 1 then the endlocal was done already in :error.
if %ERROR_CODE% EQU 0 @endlocal


:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
