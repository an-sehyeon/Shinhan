-- select_All view 생성

create or replace view view_all_list as
select  ai.bno,
        ai.name,
        ai.reg_no,
        ai.phone,
        ai.address,
        ao.housing_area,
        ao.total_score,
        ao.area_rank
from applicant_info ai
join application_office ao on ai.bno = ao.bno;
commit;