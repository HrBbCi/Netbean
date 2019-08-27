USE [quanlydiem]
GO
/****** Object:  Table [dbo].[ttsv]    Script Date: 07/01/2017 01:47:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ttsv](
	[mssv] [nvarchar](50) NOT NULL,
	[username] [nvarchar](50) NULL,
	[pass] [nvarchar](50) NULL,
	[name] [nvarchar](50) NULL,
	[date] [nvarchar](50) NULL,
	[class] [nvarchar](50) NULL,
 CONSTRAINT [PK_ttsv] PRIMARY KEY CLUSTERED 
(
	[mssv] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ttsv] ([mssv], [username], [pass], [name], [date], [class]) VALUES (N'', N'admin', N'admin', N'', N'', N'')
INSERT [dbo].[ttsv] ([mssv], [username], [pass], [name], [date], [class]) VALUES (N'20141234', N'20141234', N'1', N'Nguyễn Quỳnh Anh', N'10.9.1996', N'CNTT 2.3')
INSERT [dbo].[ttsv] ([mssv], [username], [pass], [name], [date], [class]) VALUES (N'20144838', N'20144838', N'1', N'Nguyễn Văn Tuân', N'23.09.1996', N'CNTT 2.4')
INSERT [dbo].[ttsv] ([mssv], [username], [pass], [name], [date], [class]) VALUES (N'dádá', N'ád', N'hgv', N'dsadsad', N'ghv', N'hgv')
/****** Object:  Table [dbo].[bangdiem]    Script Date: 07/01/2017 01:47:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bangdiem](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[mssv] [nvarchar](50) NOT NULL,
	[kyhoc] [nvarchar](50) NOT NULL,
	[hocphan] [nvarchar](50) NOT NULL,
	[tinchi] [float] NOT NULL,
	[heso] [nvarchar](50) NOT NULL,
	[giuaky] [float] NOT NULL,
	[cuoiky] [float] NOT NULL,
	[diemchu] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[bangdiem] ON
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (1, N'20144838', N'20141', N'Tiếng Anh 1', 0, N'7-3', 7, 4.5, N'D+')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (2, N'20144838', N'20141', N'Giải Tích 1', 4, N'7-3', 7, 3.5, N'D')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (3, N'20144838', N'20141', N'Đại Số', 4, N'7-3', 10, 6.5, N'B')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (4, N'20144838', N'20141', N'Đường Lối Quân Sự', 0, N'7-3', 6, 5, N'D+')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (5, N'20144838', N'20141', N'Giáo Dục Thể Chất A', 0, N'7-3', 7, 7, N'B')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (6, N'20144838', N'20141', N'Vật Lý Đại Cương 1', 3, N'7-3', 5.5, 6, N'C')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (7, N'20144838', N'20141', N'Triết I', 2, N'8-2', 8.5, 3.5, N'D')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (8, N'20144838', N'20141', N'Pháp Luật Đại Cương', 2, N'7-3', 7, 6.5, N'C+')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (9, N'20144838', N'20142', N'Tiếng Anh 2', 0, N'7-3', 6.5, 5.5, N'C')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (10, N'20144838', N'20142', N'Quản Trị Học Đại Cương', 2, N'7-3', 6, 6, N'C')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (11, N'20144838', N'20142', N'Giải Tích 2', 3, N'7-3', 10, 9, N'A')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (12, N'20144838', N'20142', N'Giải Tích 3', 3, N'7-3', 7.5, 8, N'B')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (13, N'20144838', N'20142', N'Công Tác Quốc Phòng Anh Ninh', 0, N'7-3', 3, 5, N'D')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (14, N'20144838', N'20142', N'Giáo Dục Thể Chất B', 0, N'7-3', 6, 7, N'C+')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (15, N'20144838', N'20142', N'Vật Lý Đại Cương 2', 3, N'7-3', 8.5, 9.5, N'A')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (16, N'20144838', N'20142', N'Triết 2', 3, N'8-2', 8, 3, N'D')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (18, N'20144838', N'20151', N'Tin Học Đại Cương', 4, N'7-3', 6.5, 5.5, N'C')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (19, N'20144838', N'20151', N'Nhập Môn CNTT và TT', 3, N'7-3', 8, 7, N'B')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (20, N'20144838', N'20151', N'Xác Suất Thống Kê', 3, N'7-3', 7, 5, N'C')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (21, N'20144838', N'20151', N'Giáo Dục Thể Chất C', 0, N'7-3', 9, 5, N'C')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (22, N'20144838', N'20151', N'Vật Lý Đại Cương III', 3, N'7-3', 6, 7, N'C+')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (23, N'20144838', N'20151', N'Tư Tưởng HCM', 2, N'8-2', 8, 5, N'C')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (24, N'20144838', N'20152', N'Toán Rời Rạc', 3, N'7-3', 5, 8.5, N'B')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (25, N'20144838', N'20152', N'Kiến Trúc Máy Tính', 3, N'7-3', 8, 7.5, N'B')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (26, N'20144838', N'20152', N'Kỹ Thuật Lập Trình', 2, N'7-3', 7, 4, N'D')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (27, N'20144838', N'20152', N'Hệ Điều Hành', 3, N'7-3', 4.5, 5, N'D')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (28, N'20144838', N'20152', N'Bóng Bàn I', 0, N'7-3', 6, 3, N'F')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (37, N'20141234', N'fw5', N'gsdv', 2, N'7-3', 7, 4, N'D')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (38, N'20144838', N'20152', N'Đường Lối CM Của ĐCSVN', 3, N'8-2', 8, 6.5, N'C+')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (39, N'20144838', N'20153', N'Cấu Trúc DL & GT', 3, N'7-3', 4, 4, N'D')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (40, N'20144838', N'20161', N'Mạng Máy Tính', 3, N'7-3', 7.5, 4.5, N'D+')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (41, N'20144838', N'20161', N'Cơ Sở Dữ Liệu', 3, N'7-3', 5, 9, N'B')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (42, N'20144838', N'20161', N'Lập Trình Hướng Đối Tượng', 2, N'7-3', 8, 3.5, N'D')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (43, N'20144838', N'20161', N'Linux Và Phần Mềm Nguồn Mở	', 2, N'7-3', 5.5, 6.5, N'C')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (44, N'20144838', N'20161', N'Nhập Môn Công Nghệ Phần Mềm', 2, N'7-3', 9, 7.5, N'B+')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (45, N'20144838', N'20161', N'Hệ Trợ Giúp Quyết Định', 2, N'7-3', 8, 8.5, N'B+')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (46, N'20144838', N'20161', N'QS Chung Và KCT Bắn Súng AK', 0, N'7-3', 8, 8.5, N'B+')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (47, N'20144838', N'20161', N'Bóng Chuyền I', 0, N'7-3', 6, 6, N'C')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (50, N'20144838', N'20162', N'Phân Tích Và Thiết Kế Hệ Thống Thông Tin', 2, N'7-3', 9.5, 2, N'F')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (52, N'20144838', N'20162', N'Công Nghệ Web Và Dịch Vụ Trực tuyến', 3, N'7-3', 6.5, 3, N'D')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (53, N'20144838', N'20162', N'Bóng Chuyền II', 0, N'7-3', 6, 5, N'D+')
INSERT [dbo].[bangdiem] ([id], [mssv], [kyhoc], [hocphan], [tinchi], [heso], [giuaky], [cuoiky], [diemchu]) VALUES (56, N'20144838', N'20162', N'An Toàn Và Bảo Mật Thông Tin', 3, N'7-3', 8, 7, N'B')
SET IDENTITY_INSERT [dbo].[bangdiem] OFF
/****** Object:  ForeignKey [ma]    Script Date: 07/01/2017 01:47:24 ******/
ALTER TABLE [dbo].[bangdiem]  WITH CHECK ADD  CONSTRAINT [ma] FOREIGN KEY([mssv])
REFERENCES [dbo].[ttsv] ([mssv])
GO
ALTER TABLE [dbo].[bangdiem] CHECK CONSTRAINT [ma]
GO
