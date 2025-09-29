#!/bin/bash

# .env 파일 로드
ENV_FILE="$(dirname "$0")/.env"

if [ ! -f "$ENV_FILE" ]; then
    echo ".env 파일을 찾을 수 없습니다: $ENV_FILE"
    exit 1
fi

echo "🔹 환경변수를 설정합니다..."
export $(grep -v '^#' "$ENV_FILE" | xargs)

# 확인용 출력 (민감정보는 마스킹)
echo "JASYPT_ENCRYPTOR_PASSWORD: ${JASYPT_ENCRYPTOR_PASSWORD:0:3}****"

echo "환경변수가 성공적으로 등록되었습니다."
