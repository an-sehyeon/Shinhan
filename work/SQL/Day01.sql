-- 접속된 계정의 모든 table조회
select * from tab;
-- selection : 모든 칼럼을 조회
select * from employees;

-- Projection : 특정칼럼
select EMPLOYEE_ID,FIRST_NAME from employees;

-- 칼럼의 정보를 보기
desc employees;


-- select문 구조 (select - from 필수)
-- select문 구조 (select - from - where - order by)

-- sodo칼럼(가짜) : rownum는 select 순서
select rownum, first_name 급여, hire_date      -- 3    
from employees emp                            -- 1
where emp.salary > 0                          -- 2    
order by 급여 asc;                             -- 4


-- distinct 중복제거
-- 우리회사의 직원들이 근무하는 부서들은?
select distinct department_id 
from employees
where department_id is not null;

select distinct JOB_ID 
from employees;

-- SCOTT으로 TEST
-- (생략하면 All, distinct는 중복배제)
-- ""칼럼이름이나 테이블이름 (식별자)
-- ' '는 값
-- NULL값을 계산하면 결과는 NULL이다.
select job, deptno, sal, comm 커미션, sal+nvl(comm,0) as "실제로받는 수령액", '신한' "회사명"
from emp;

-- 1번째 칼럼으로 asc
select * 
from emp
order by 2;

select * 
from emp
order by ename;

select empno, ename, sal "급여" 
from emp
order by 급여;


-- 조건절
-- 식별자(identifier) :  table 이름, 칼럼이름, 별칭(특수문자가 있으면 "" 사용)
-- 데이터사전(Meta data저장)에 식별자는 대문자이다.
select empno, ename, job, mgr, hiredate, sal "이달의 급여", comm 커미션, deptno 부서코드
from emp 
where sal >= 1000 
and job='SALESMAN';


-- 테이블 생성
-- DDL
drop table mytable;
create table mytable(  
    id number primary key,
    name varchar2(20),
    birthdat date
);

-- DQL
select * from mytable;
-- DML
insert into mytable values(1,'안',sysdate);
-- TCL
commit;     -- DB에 반영

delete from mytable;
rollback;   -- 원상복구


-- hr계정
select * from tab;

-- DQL(Select문)

select first_name, email, to_char(hire_date, 'yyyy-mon-dd'),job_id,salary,department_id, commission_pct
from employees
where salary >= 1000
-- and department_id in (50,80,)
and (job_id = 'SA_REP' or job_id = 'ST_CLERK')
and length (first_name) >= 6
and commission_pct is not null
order by 3 desc
;

select * from employees;































