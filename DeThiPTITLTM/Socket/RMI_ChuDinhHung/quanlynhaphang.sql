USE [quanlynhaphang]
GO
/****** Object:  Table [dbo].[tblNCC]    Script Date: 11/1/2017 2:57:12 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblNCC]') AND type in (N'U'))
DROP TABLE [dbo].[tblNCC]
GO
/****** Object:  Table [dbo].[tblHoaDon]    Script Date: 11/1/2017 2:57:12 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblHoaDon]') AND type in (N'U'))
DROP TABLE [dbo].[tblHoaDon]
GO
/****** Object:  Table [dbo].[tblHangNhap]    Script Date: 11/1/2017 2:57:12 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblHangNhap]') AND type in (N'U'))
DROP TABLE [dbo].[tblHangNhap]
GO
/****** Object:  Table [dbo].[tblHangHoa]    Script Date: 11/1/2017 2:57:12 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblHangHoa]') AND type in (N'U'))
DROP TABLE [dbo].[tblHangHoa]
GO
/****** Object:  Table [dbo].[tblHangHoa]    Script Date: 11/1/2017 2:57:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblHangHoa]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tblHangHoa](
	[int] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[description] [nvarchar](50) NULL
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[tblHangNhap]    Script Date: 11/1/2017 2:57:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblHangNhap]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tblHangNhap](
	[id] [int] NOT NULL,
	[maHangHoa] [int] NOT NULL,
	[maHoaDon] [int] NOT NULL,
	[soLuong] [int] NULL,
	[DonGia] [float] NULL
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[tblHoaDon]    Script Date: 11/1/2017 2:57:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblHoaDon]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tblHoaDon](
	[id] [int] NOT NULL,
	[idNCC] [int] NOT NULL,
	[amout] [int] NOT NULL
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[tblNCC]    Script Date: 11/1/2017 2:57:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblNCC]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tblNCC](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[address] [nvarchar](50) NULL,
	[phone] [nvarchar](50) NULL
) ON [PRIMARY]
END
GO
SET IDENTITY_INSERT [dbo].[tblHangHoa] ON 

INSERT [dbo].[tblHangHoa] ([int], [name], [description]) VALUES (1, N'BIm Bim', N'Màu Đỏ')
INSERT [dbo].[tblHangHoa] ([int], [name], [description]) VALUES (2, N'Lạc Rang', N'lạc ngon giòn')
INSERT [dbo].[tblHangHoa] ([int], [name], [description]) VALUES (3, N'Nước coca', N'loại lớn')
INSERT [dbo].[tblHangHoa] ([int], [name], [description]) VALUES (4, N'Nước pepsi', N'Loại nhỏ')
INSERT [dbo].[tblHangHoa] ([int], [name], [description]) VALUES (5, N'Trứng gà', N'gà vườn')
INSERT [dbo].[tblHangHoa] ([int], [name], [description]) VALUES (6, N'Trứng vịt', N'vịt nút')
INSERT [dbo].[tblHangHoa] ([int], [name], [description]) VALUES (7, N'Trứng cút lộn', N'loại nhỏ')
INSERT [dbo].[tblHangHoa] ([int], [name], [description]) VALUES (8, N'Tôm', N'hải sản')
INSERT [dbo].[tblHangHoa] ([int], [name], [description]) VALUES (9, N'Tích', N'hải sản')
INSERT [dbo].[tblHangHoa] ([int], [name], [description]) VALUES (10, N'Ghẹ', N'hải sản')
SET IDENTITY_INSERT [dbo].[tblHangHoa] OFF
SET IDENTITY_INSERT [dbo].[tblNCC] ON 

INSERT [dbo].[tblNCC] ([id], [name], [address], [phone]) VALUES (1, N'Đồ uống', N'41 Mạc Thị Bưởi', N'(04) 38621159')
INSERT [dbo].[tblNCC] ([id], [name], [address], [phone]) VALUES (2, N'Đồ ăn', N'143 Trần Phú', N'01697938868')
INSERT [dbo].[tblNCC] ([id], [name], [address], [phone]) VALUES (3, N'Đồ Khô', N'Km 10 Nguyễn Trãi', N'09888888888')
INSERT [dbo].[tblNCC] ([id], [name], [address], [phone]) VALUES (4, N'Gia Vị', N'76 Trần Phú ', N'09123287432')
INSERT [dbo].[tblNCC] ([id], [name], [address], [phone]) VALUES (5, N'Hải sản', N'789 Giải Phóng', N'0918232141')
INSERT [dbo].[tblNCC] ([id], [name], [address], [phone]) VALUES (6, N'Tươi Lạnh', N'123 Hà Đông', N'091823213')
SET IDENTITY_INSERT [dbo].[tblNCC] OFF
