select * from user_tables ;

select pid ,pname ,sex,tall,birthday from PERSON;

insert into PERSON values(1001,'Cindy','女',1.65,default,'');

--在创建表时对表进行约束
create table phone(   --含外键的表--》子表
  pno number primary key,
  branch varchar2(40) not null,
  price number not null,
  pid number --外键
)

create table person(  --主表
  pid       number  primary key,   -- 主键
  pname varchar2(20) unique,
  sex       char(2)  not null,
  tall       number(3,2) check (tall between 0.10 and 3.0),
  birthday date default sysdate ,
  image    blob
  );
select pid, pname,sex,tall,birthday from PERSON;

select *from PHONE ;

insert into PHONE values(10001,'xioami',1500,1001);
alter table phone add constraint fk_phone_person_pid foreign key(pid) references person(pid);
--alter table  子表名  add constraint  约束名  foreign key（外键） references 主表 （主键字段）
delete from PHONE where pid = 1001;
delete from PERSON where pid =1001;
 
 
 