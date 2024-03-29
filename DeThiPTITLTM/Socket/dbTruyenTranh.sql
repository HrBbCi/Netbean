USE [QuanLyTruyenTranh]
GO
/****** Object:  Table [dbo].[tblKhachHang]    Script Date: 10/17/2017 9:20:24 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblKhachHang]') AND type in (N'U'))
DROP TABLE [dbo].[tblKhachHang]
GO
/****** Object:  User [erp2]    Script Date: 10/17/2017 9:20:24 AM ******/
IF  EXISTS (SELECT * FROM sys.database_principals WHERE name = N'erp2')
DROP USER [erp2]
GO
/****** Object:  User [erp2]    Script Date: 10/17/2017 9:20:24 AM ******/
IF NOT EXISTS (SELECT * FROM sys.database_principals WHERE name = N'erp2')
CREATE USER [erp2] FOR LOGIN [erp2] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[tblKhachHang]    Script Date: 10/17/2017 9:20:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblKhachHang]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tblKhachHang](
	[maKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[soDienThoai] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[moTa] [nvarchar](50) NULL
) ON [PRIMARY]
END
GO
SET IDENTITY_INSERT [dbo].[tblKhachHang] ON 

INSERT [dbo].[tblKhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [diaChi], [email], [moTa]) VALUES (1, N'Chu Ðình Hung', NULL, NULL, NULL, NULL)
INSERT [dbo].[tblKhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [diaChi], [email], [moTa]) VALUES (2, N'Ðàm Van Giáp', NULL, NULL, NULL, NULL)
INSERT [dbo].[tblKhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [diaChi], [email], [moTa]) VALUES (3, N'Lương Thị Hồng Hạnh', N'0169791293', N'Hà Nội', N'hanhLuon@gmail.com', N'lasjd asdlk jsad')
INSERT [dbo].[tblKhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [diaChi], [email], [moTa]) VALUES (4, N'Nguyễn Xuân Khánh', N'09129321', N'Thái Bình', N'khanh@gmail.com', N'lasjd asdlk jsadasdasda sldjsa ld sajlkdasdsa dsad')
SET IDENTITY_INSERT [dbo].[tblKhachHang] OFF
