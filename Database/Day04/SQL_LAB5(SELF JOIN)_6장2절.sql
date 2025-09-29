-- SELF JOIN
1. 직원의 이름과 관리자 이름을 조회하시오.
select 직원.first_name "직원이름",매니저.first_name "매니저이름"
from employees 직원 inner join employees 매니저 on(직원.manager_id = 매니저.manager_id)
order by 직원.employee_id;
 



2. 직원의 이름과 관리자 이름을 조회하시오.
관리자가 없는 직원정보도 모두 출력하시오.
select 직원.first_name "직원이름",nvl(매니저.first_name,'매니저없음') "매니저이름"
from employees 직원 left outer join employees 매니저 on(직원.manager_id = 매니저.manager_id)
order by 직원.employee_id;



3. 관리자 이름과 관리자가 관리하는 직원의 수를 조회하시오.
단, 관리직원수가 3명 이상인 관리자만 출력되도록 하시오.
select nvl(매니저.first_name,'매니저없음') "매니저이름", count(직원.first_name) "직원수"
from employees 직원 join employees 매니저 on(직원.manager_id = 매니저.manager_id)
group by nvl(매니저.first_name,'매니저없음')
having count(직원.first_name) >= 3
order by 매니저이름;

