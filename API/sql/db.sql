select * from user_tables ;

select pid ,pname ,sex,tall,birthday from PERSON;

insert into PERSON values(1001,'Cindy','Ů',1.65,default,'');

--�ڴ�����ʱ�Ա����Լ��
create table phone(   --������ı�--���ӱ�
  pno number primary key,
  branch varchar2(40) not null,
  price number not null,
  pid number --���
)

create table person(  --����
  pid       number  primary key,   -- ����
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
--alter table  �ӱ���  add constraint  Լ����  foreign key������� references ���� �������ֶΣ�
delete from PHONE where pid = 1001;
delete from PERSON where pid =1001;
 
 
 