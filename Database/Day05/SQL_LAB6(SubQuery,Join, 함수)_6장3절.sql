========================================
		SubQuery
========================================


1. 직원들의 이름, 입사일, 부서명을 조회하시오.
단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
그리고 부서가 없는 직원에 대해서는 '<부서없음>' 이 출력되도록 한다.
(outer-join , nvl() )

select ename, hiredate, nvl(dname,'부서없음') "부서"
from emp left outer join dept using(DEPTNO);

select first_name, hire_date, nvl(department_name,'부서없음') "부서"
from employees left outer join departments using(department_id);



select * from dept
select * from emp


2. 직원의 직책에 따라 월급을 다르게 지급하려고 한다.
직책에 'Manager'가 포함된 직원은 급여에 0.5를 곱하고
나머지 직원들에 대해서는 원래의 급여를 지급하도록 한다. 
적절하게 조회하시오. (decode)

select ename, job, decode(job,'MANAGER',sal * 0.5, sal) "급여", sal
from emp



3. 각 부서별로 최저급여를 받는 직원의 이름과 부서id, 급여를 조회하시오.
select department_id, salary
from employees 
where (department_id, salary) in (
    select department_id, min(salary)
    from employees
    group by department_id)
order by 1






4. 각 직급별(job_title) 인원수를 조회하되 사용되지 않은 직급이 있다면 해당 직급도
출력결과에 포함시키시오. 그리고 직급별 인원수가 3명 이상인 직급만 출력결과에 포함시키시오.
select job_title, count(*) "인원수"
from jobs left outer join employees using(job_id)
group by job_title
having count(*) = 0 or count(*) >= 3;




5. 각 부서별 최대급여를 받는 직원의 이름, 부서명, 급여를 조회하시오.
select first_name,department_name, salary "급여"
from employees join departments using(department_id)
where (department_id,salary) in(
    select department_id, max(salary)
    from employees
    group by department_id)
order by salary desc;    


select * from departments
select * from employees



6. 직원의 이름, 부서id, 급여를 조회하시오. 그리고 직원이 속한 해당 부서의 
최소급여를 마지막에 포함시켜 출력 하시오.


select emp.first_name, emp.department_id, emp.salary, emp2.최소급여
from employees emp, (
                    select department_id, min(salary) "최소급여"
                    from employees
                    group by department_id) emp2
where emp.department_id = emp2.department_id
order by department_id asc, emp.salary asc;


 


