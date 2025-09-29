# Shinhan-SimpleBoard

차민건 - ListController, FrontController

안세현 - UpdateController

윤민혁 - DeleteController

천희찬 - WriterController

### DB 테이블

bno(number), writer(varchar2 50), writedate(date), title(varchar2 50), contents(varchar2 200)

create table SimpleBoard(
    bno number primary key,
    writer varchar2(50),
    writedate date,
    title varchar2(50),
    contents varchar2(200)
);

create sequence bno;

### PR 리뷰 체크리스트

✅ 코드 스타일

■ 변수명, 메서드명이 명확하고 일관성 있는가?

■ 들여쓰기/포맷이 통일되어 있는가?

✅ 기능 검증

■ 실제 기능이 명세대로 동작하는가?

■ 예외 상황에 대한 처리가 있는가?

✅ 중복 코드

■ 기존 코드와 중복되지는 않는가?

■ 공통 기능은 서비스/ 유틸로 분리되었는가?

✅ 커밋 메시지/PR 본문

□ 커밋 메시지가 작업 내역을 설명하고 있는가?

■ PR 본문에 이슈 번호가 연결되어 있는가? 

■ 관련된 변경 파일이 적절히 정리되어 있는가?

✅ 병합 전 확인사항

■ 충돌이 없는가? 

■ develop 브랜치가 기준인지 확인

■ 동작 확인을 위해 간단한 테스트 결과 스크린샷

[![시연 영상](https://youtu.be/kyASwKtZuGE/0.jpg)](https://youtu.be/kyASwKtZuGE)
