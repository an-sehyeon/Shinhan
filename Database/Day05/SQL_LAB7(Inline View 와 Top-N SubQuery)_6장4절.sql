==========================================
	Inline View 와 Top-N SubQuery
==========================================

1. 급여를 가장 많이 받는 상위 5명의 직원 정보를 조회하시오.
-- rownum : sudo칼럼, 가짜, 모조, select후에 numbering, mysql : limit, oracle상위버전 : step
select *
from (
        select rownum, FIRST_NAME, SALARY
        from employees
        order by salary desc)
where rownum <= 5;


-- 2번째 ~ 4번째를 select

select *
from (
    select rownum seq,aa.*
            from(
            select first_name, salary
            from employees
            order by salary desc) aa) bb
where bb.seq between 2 and 4        




2. 커미션을 가장 많이 받는 상위 3명의 직원 정보를 조회하시오.
-- asc : oracle은 null이 마지막에 나오는 정책

select *
from(
    select first_name, commission_pct
    from employees
    where commission_pct is not null
    order by commission_pct desc)
where rownum <=3;    








3. 월별 입사자 수를 조회하되, 입사자 수가 5명 이상인 월만 출력하시오.
----------------------------
select to_char(hire_date,'mm')월, count(*) 입사자수
from employees
group by to_char(hire_date'mm')
having count(*) >= 5
order by 1;




4. 년도별 입사자 수를 조회하시오. 
단, 입사자수가 많은 년도부터 출력되도록 합니다.

select to_char(hire_date,'yyyy') 년도, count(*) 입사자수
from employees
group by to_char(hire_date,'yyyy')
order by 2 desc;



