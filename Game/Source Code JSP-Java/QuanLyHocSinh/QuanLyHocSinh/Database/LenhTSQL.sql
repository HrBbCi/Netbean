drop database quanlysinhvien
create database quanlysinhvien

go
use quanlysinhvien


create table sinhvien
	(
		ID int Identity(1,1),
		masv varchar(10) unique not null,
		ten nvarchar(50) not null,
		gioitinh bit not null,
		ngaysinh smalldatetime not null,
		cmnd varchar(12) not null,
		email varchar(50) not null unique check(charindex('@',email,0)>0 and charindex('.',email,0)>0),
		diachi nvarchar(100) not null,
		ngaynhaphoc smalldatetime not null,
		hinhanh nvarchar(100) default('/sof203_assignment1_ps04271/hinhanh/noimage.png')
		Constraint PK_sinhvien_PS04271 primary key (masv)
	)

create table nhanvien
	(
		ID int Identity(1,1),
		manv varchar(10) unique not null,
		ten nvarchar(50) not null,
		matkhau varchar(50) not null,
		loaitaikhoan tinyint not null,
		hinhanh nvarchar(100) default('/sof203_assignment1_ps04271/hinhanh/noimage.png')
		Constraint pk_nhanvien_PS04271 primary key(manv)
	)



create table diem
	(
		ID int Identity(1,1),
		malop varchar(10) not null,
		masv varchar(10) not null,
		diemtoan float default(0.0) check(diemtoan>=0 and diemtoan<=10),
		diemtin float default(0.0) check(diemtin>=0 and diemtin<=10),
		diemanh float default(0.0) check(diemanh>=0 and diemanh<=10)
		constraint pk_diem_PS04271 primary key (ID)
	)


create table taikhoan
	(
		taikhoanID tinyint not null,
		tentaikhoan nvarchar(50)
		constraint pk_taikhoan_PS04271 primary key (taikhoanID)
	)

create table lop
	(
		ID int Identity(1,1),
		malop varchar(10) not null,
		khoi tinyint not null check(khoi>=10 and khoi <=12),
		lop varchar(10) not null,
		manv varchar(10) not null,
		nienkhoa varchar(20) not null
		constraint pk_lop_PS04271 primary key(malop)
	)

select lop from lop where manv like 'phuongtt' and khoi =10 group by lop

select nienkhoa from lop where manv like 'phuongtt' group by nienkhoa
alter table nhanvien
	add constraint FK_nhanvien_PK_taikhoan foreign key(loaitaikhoan) references taikhoan(taikhoanID)

alter table lop 
	add constraint FK_lop_PK_nhanvien foreign key(manv) references nhanvien(manv)

alter table diem
	add constraint FK_diem_PK_lop foreign key(malop) references lop(malop)

alter table diem
	add constraint FK_diem_PK_sinhvien foreign key (masv) references sinhvien(masv)


insert into taikhoan values (2,'daotao')
select * from taikhoan
select * from nhanvien
select * from sinhvien

insert into nhanvien(manv,ten,matkhau,loaitaikhoan) values ('richpvn',N'Phùng Văn Na Rích', 'e10adc3949ba59abbe56e057f20f883e',2)
update nhanvien set loaitaikhoan = 2 where manv ='richpvn'

select s.masv, s.ten, d.diemtoan, d.diemtin, d.diemanh from diem d join sinhvien s on d.masv = s.masv join lop l on d.malop= l.malop where l.manv like 'phuongtt' and l.lop like SUBSTRING('[Các lớp, Khối10, 10a1]',charindex(',','[Các lớp, Khối10, 10a1]',10)+2,charindex(']','[Các lớp, Khối10, 10a1]')-charindex(',','[Các lớp, Khối10, 10a1]',10)-2)

select charindex(',','[Các lớp, Khối10, 10a1]',10)
select SUBSTRING('[Các lớp, Khối10, 10a1]',charindex(',','[Các lớp, Khối10, 10a1]',10)+2,charindex(']','[Các lớp, Khối10, 10a1]')-charindex(',','[Các lớp, Khối10, 10a1]',10)-2)

--[Các lớp, 2016-2017, Khối 10, 10a1]

declare @a nvarchar(50)
set @a = N'[Các lớp, 2016-2017, Khối 10, 10a1]'
select SUBSTRING(@a,31,charindex(']',@a)-31)

select top 3 s.masv, s.ten, substring(convert(float,(d.diemtoan + d.diemtin + d.diemanh)/3),0,4) as dtb
 from diem d join lop l on d.malop = l.malop
	join sinhvien s on d.masv = s.masv
 where l.manv like 'phuongtt' 
 and l.lop like '10a1'