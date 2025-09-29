import os
import base64

# os.urandom(16) → AES-128
# os.urandom(24) → AES-192
# os.urandom(32) → AES-256
# 256비트 = 32바이트 키 생성
key = os.urandom(32)

# Base64 인코딩 (환경 변수에 넣기 용도)
base64_key = base64.b64encode(key).decode("utf-8")

print("AES Key (Base64):", base64_key)
