# secretkey를 관리하기 위한 git sub module

## properties

### applicaiton-common.properties

CORS/WhiteList

### applicaiton-db.properties

DB 설정 파일

### applicaiton-secret.properties

API 비밀 키

## 비밀 키 생성

createAES.py : AES-256 키 생성

## .env파일 설정

.env.example 예시 파일을 이용해서 .env 파일 생성
.env 파일에 팀 비밀키 넣어서 프로젝트 루트에 넣어서 사용
