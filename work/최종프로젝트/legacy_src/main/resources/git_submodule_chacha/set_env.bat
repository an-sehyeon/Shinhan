@echo off
chcp 65001 >nul
setlocal ENABLEDELAYEDEXPANSION

echo ==== [환경변수 설정 시작 - Windows] ====

set ENV_FILE=%~dp0.env

if not exist "%ENV_FILE%" (
    echo .env 파일이 없습니다: %ENV_FILE%
    pause
    exit /b 1
)

echo .env 파일을 읽는 중...
echo 파일 경로: %ENV_FILE%

for /f "usebackq tokens=1,2 delims==" %%A in ("%ENV_FILE%") do (
    set line=%%A
    if not "!line!"=="" (
        if not "!line:~0,1!"=="#" (
            echo 환경변수 설정: %%A=%%B
            set %%A=%%B
        )
    )
)

echo.
echo 환경변수가 성공적으로 로드되었습니다.
echo 현재 설정된 JASYPT_ENCRYPTOR_PASSWORD: %JASYPT_ENCRYPTOR_PASSWORD%

echo.
echo 이제 Tomcat을 시작합니다...
echo Eclipse에서 서버를 시작하거나, 아래 명령을 실행하세요:
echo.
echo   cd "%CATALINA_HOME%\bin"
echo   startup.bat
echo.

pause