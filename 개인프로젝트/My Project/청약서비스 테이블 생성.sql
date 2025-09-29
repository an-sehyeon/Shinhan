
create sequence bno_seq
increment by 1
start with 1
nocache;


-- application_office 테이블 생성시 bno값을 insert하지 않으면 자동으로 bno값 생성 트리거
CREATE OR REPLACE TRIGGER trg_applicant_info
BEFORE INSERT ON applicant_info
FOR EACH ROW
WHEN (NEW.bno IS NULL)
BEGIN
    SELECT bno_seq.NEXTVAL INTO :NEW.bno FROM dual;
END;
/


--alter table applicant_info modify dependent_count number not null;
--alter table applicant_info modify account_open_date varchar2(15);
CREATE TABLE applicant_info (
	bno number,
	name varchar2(10) NOT NULL,
	reg_no varchar2(20) NOT NULL,
	phone varchar2(20) not NULL,
	address varchar(7) NOT NULL,
	dependent_count number not NULL,
	non_home_start_date number NOT NULL,
	account_open_date varchar2(15) not NULL,
	is_married char(1) NOT NULL,
	housing_area number NOT NULL
);


ALTER TABLE application_office ADD total_score NUMBER;
ALTER TABLE application_office ADD area_rank NUMBER;
ALTER TABLE application_office ADD is_selected varchar2(1);
ALTER TABLE application_office ADD is_contract_cancelled varchar2(1);
ALTER TABLE application_office ADD sort_seed NUMBER;

CREATE TABLE application_office (
	bno number,
	housing_area number NOT NULL,
	count number NOT NULL
);

--alter table dependent_score rename column dependent_score to dependent_point;
CREATE TABLE dependent_score (
	dependent_count number NULL,
	dependent_score number NOT NULL
);

--alter table subscription_account_score modify account_open_date varchar2(15) not null;
CREATE TABLE subscription_account_score (
	account_open_date varchar2(15) NOT NULL,
	account_point number NOT NULL
);

CREATE TABLE non_home_ownership_score (
	non_home_start_date number NOT NULL,
	non_home_point number NOT NULL
);

--drop table address_score;
--alter table address_score modify address varchar2(7);
CREATE TABLE address_score (
	address varchar(7) NOT NULL,
	address_num number NOT NULL
);

--alter table unit_price_by_area modify balace_payment varchar2(15);
CREATE TABLE unit_price_by_area (
	housing_area VARCHAR(255) NOT NULL,
	down_payment varchar2(10) NOT NULL,
	interim_payment varchar2(10) NOT NULL,
	balace_payment varchar2(10) NOT NULL,
	total_price varchar2(20) NOT NULL
);

--drop table addresslist;
alter table addresslist rename to address_list;
CREATE TABLE addresslist (
	address_num number NOT NULL,
	address_point number NOT NULL
);

ALTER TABLE application_office ADD CONSTRAINT PK_APPLICATION_OFFICE PRIMARY KEY (
	bno
);

ALTER TABLE applicant_info ADD CONSTRAINT PK_APPLICANT_INFO PRIMARY KEY (
	bno
);

ALTER TABLE dependent_score ADD CONSTRAINT PK_DEPENDENT_SCORE PRIMARY KEY (
	dependent_count
);

ALTER TABLE subscription_account_score ADD CONSTRAINT PK_SUBSCRIPTION_ACCOUNT_SCORE PRIMARY KEY (
	account_open_date
);

ALTER TABLE non_home_ownership_score ADD CONSTRAINT PK_NON_HOME_OWNERSHIP_SCORE PRIMARY KEY (
	non_home_start_date
);

--ALTER TABLE address_score DROP CONSTRAINT PK_ADDRESS_SCORE;
ALTER TABLE address_score ADD CONSTRAINT PK_ADDRESS_SCORE PRIMARY KEY (
	address
);

ALTER TABLE unit_price_by_area ADD CONSTRAINT PK_UNIT_PRICE_BY_AREA PRIMARY KEY (
	housing_area
);

--ALTER TABLE addresslist DROP CONSTRAINT PK_ADDRESSLIST;
ALTER TABLE addresslist ADD CONSTRAINT PK_ADDRESSLIST PRIMARY KEY (
	address_num
);



ALTER TABLE application_office ADD CONSTRAINT FK_info_TO_office_1 FOREIGN KEY (
	bno
)
REFERENCES applicant_info (
	bno
);

--ALTER TABLE application_office DROP CONSTRAINT FK_price_by_area_TO_office_1;

ALTER TABLE application_office ADD CONSTRAINT FK_price_by_area_TO_office_1 FOREIGN KEY (
	housing_area
)
REFERENCES unit_price_by_area (
	housing_area
);


--ALTER TABLE address_score ADD CONSTRAINT UQ_address_num UNIQUE (
address_num
);
--ALTER TABLE applicant_info DROP CONSTRAINT FK_address_score_TO_info_1;
ALTER TABLE applicant_info ADD CONSTRAINT FK_address_score_TO_info_1 FOREIGN KEY (
	address
)
REFERENCES address_score (
	address
);

ALTER TABLE applicant_info ADD CONSTRAINT FK_dependent_score_TO_info_1 FOREIGN KEY (
	dependent_count
)
REFERENCES dependent_score (
	dependent_count
);

ALTER TABLE applicant_info ADD CONSTRAINT FK_non_home_score_TO_info_1 FOREIGN KEY (
	non_home_start_date
)
REFERENCES non_home_ownership_score (
	non_home_start_date
);


--------------------------
--ALTER TABLE applicant_info DROP CONSTRAINT FK_account_score_TO_info_1;
ALTER TABLE applicant_info ADD CONSTRAINT FK_account_score_TO_info_1 FOREIGN KEY (
	account_open_date
)
REFERENCES subscription_account_score (
	account_open_date
);


--ALTER TABLE addresslist DROP CONSTRAINT FK_addscore_TO_addlist_1;

ALTER TABLE addresslist ADD CONSTRAINT FK_addscore_TO_addlist_1 FOREIGN KEY (
	address_num
)
REFERENCES address_score (
	address_num
);


ALTER TABLE applicant_info ADD CONSTRAINT FK_price_by_area_TO_info_1 FOREIGN KEY (
    housing_area
)
REFERENCES unit_price_by_area (
    housing_area
);

commit;


