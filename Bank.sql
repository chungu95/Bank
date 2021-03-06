USE [master]
GO
/****** Object:  Database [DichVu]    Script Date: 5/11/2017 11:14:31 AM ******/
CREATE DATABASE [DichVu]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DichVu', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\DichVu.mdf' , SIZE = 3136KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'DichVu_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\DichVu_log.ldf' , SIZE = 784KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [DichVu] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DichVu].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DichVu] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DichVu] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DichVu] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DichVu] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DichVu] SET ARITHABORT OFF 
GO
ALTER DATABASE [DichVu] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DichVu] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [DichVu] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DichVu] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DichVu] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DichVu] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DichVu] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DichVu] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DichVu] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DichVu] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DichVu] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DichVu] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DichVu] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DichVu] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DichVu] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DichVu] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DichVu] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DichVu] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DichVu] SET RECOVERY FULL 
GO
ALTER DATABASE [DichVu] SET  MULTI_USER 
GO
ALTER DATABASE [DichVu] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DichVu] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DichVu] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DichVu] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'DichVu', N'ON'
GO
USE [DichVu]
GO
/****** Object:  StoredProcedure [dbo].[DSGiaoDich]    Script Date: 5/11/2017 11:14:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[DSGiaoDich] @SoTK varchar( 13 ) 
AS 
  BEGIN 
      SELECT * 
      FROM   GiaoDich
      WHERE  MaTK = @SoTk; 
  END; 

GO
/****** Object:  StoredProcedure [dbo].[getDataGiaoDich]    Script Date: 5/11/2017 11:14:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getDataGiaoDich]
    @SoTK varchar(13)
	AS
BEGIN
     SELECT [MaGiaoDich]
           ,[SoTien]
           ,[NgayGD]
		   ,[MaTK]
		   ,[LoaiGD]
     FROM [DichVu].[dbo].[GiaoDich]
     where MaTK = @SoTK
END;

GO
/****** Object:  StoredProcedure [dbo].[getDataKH]    Script Date: 5/11/2017 11:14:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getDataKH]
    @SoTK varchar(13)
	AS
BEGIN
     SELECT [HoTen]
           ,[SoDuKhaDung]
           ,[SoDuHienTai]
     FROM [DichVu].[dbo].[KhachHang]
     where SoTK = @SoTK
END;



GO
/****** Object:  StoredProcedure [dbo].[getDataKHByID]    Script Date: 5/11/2017 11:14:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getDataKHByID]
    @SoTK varchar(13)
	AS
BEGIN
     SELECT [HoTen]
           ,[SoDuKhaDung]
           ,[SoDuHienTai]
     FROM [DichVu].[dbo].[KhachHang]
     where SoTK = @SoTK
END;



GO
/****** Object:  StoredProcedure [dbo].[XemChiTiet]    Script Date: 5/11/2017 11:14:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[XemChiTiet] @SoTK varchar( 13 ) 
AS 
  BEGIN 
      SELECT HoTen, SoDuKhaDung, SoDuHienTai
      FROM   KhachHang, GiaoDich
      WHERE  SoTK = @SoTK; 
  END; 

GO
/****** Object:  Table [dbo].[Customer]    Script Date: 5/11/2017 11:14:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[AccountID] [numeric](13, 0) NOT NULL,
	[CustomerName] [nvarchar](50) NULL,
	[Passport] [numeric](13, 0) NULL,
	[Address] [nvarchar](100) NULL,
	[Email] [nvarchar](30) NULL,
	[Phone] [nchar](11) NULL,
	[Balance] [money] NULL,
	[Password] [nvarchar](32) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[AccountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Deal]    Script Date: 5/11/2017 11:14:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Deal](
	[TransactionID] [nvarchar](50) NOT NULL,
	[Amount] [money] NOT NULL,
	[TransactionDate] [date] NOT NULL,
	[RemitterID] [numeric](13, 0) NOT NULL,
	[ReceiverID] [numeric](13, 0) NOT NULL,
	[TransactionType] [nvarchar](50) NOT NULL,
	[OrderID] [nvarchar](8) NOT NULL,
 CONSTRAINT [PK_GiaoDich] PRIMARY KEY CLUSTERED 
(
	[TransactionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Customer] ([AccountID], [CustomerName], [Passport], [Address], [Email], [Phone], [Balance], [Password]) VALUES (CAST(123456789012 AS Numeric(13, 0)), N'Phạm Trần Tuyết Trinh', CAST(9876543210 AS Numeric(13, 0)), N'Đồng Nai', N'trinh@gmail.com', N'0999999999 ', 18130000.0000, N'61536b26f02832ed0bf885c0d9cec2f5')
INSERT [dbo].[Customer] ([AccountID], [CustomerName], [Passport], [Address], [Email], [Phone], [Balance], [Password]) VALUES (CAST(1234567890123 AS Numeric(13, 0)), N'Vũ Đình Chung', CAST(1234567890 AS Numeric(13, 0)), N'HCMC', N'chungkoi113gmail.com', N'0988457017 ', 36870000.0000, N'e10adc3949ba59abbe56e057f20f883e')
INSERT [dbo].[Deal] ([TransactionID], [Amount], [TransactionDate], [RemitterID], [ReceiverID], [TransactionType], [OrderID]) VALUES (N'2YH5XNCJ', 5000000.0000, CAST(N'2017-05-09' AS Date), CAST(1234567890123 AS Numeric(13, 0)), CAST(123456789012 AS Numeric(13, 0)), N'payment', N'12345678')
INSERT [dbo].[Deal] ([TransactionID], [Amount], [TransactionDate], [RemitterID], [ReceiverID], [TransactionType], [OrderID]) VALUES (N'8L98AXB9', 8980000.0000, CAST(N'2017-05-11' AS Date), CAST(123456789012 AS Numeric(13, 0)), CAST(1234567890123 AS Numeric(13, 0)), N'payment', N'D165AVV2')
INSERT [dbo].[Deal] ([TransactionID], [Amount], [TransactionDate], [RemitterID], [ReceiverID], [TransactionType], [OrderID]) VALUES (N'8SK7R0CE', 22890000.0000, CAST(N'2017-05-11' AS Date), CAST(123456789012 AS Numeric(13, 0)), CAST(1234567890123 AS Numeric(13, 0)), N'payment', N'WCNPQXT4')
INSERT [dbo].[Deal] ([TransactionID], [Amount], [TransactionDate], [RemitterID], [ReceiverID], [TransactionType], [OrderID]) VALUES (N'OHEIVZ1S', 22890000.0000, CAST(N'2017-05-11' AS Date), CAST(123456789012 AS Numeric(13, 0)), CAST(1234567890123 AS Numeric(13, 0)), N'payment', N'WCNPQXT4')
ALTER TABLE [dbo].[Deal]  WITH CHECK ADD  CONSTRAINT [FK_GiaoDich_KhachHang] FOREIGN KEY([RemitterID])
REFERENCES [dbo].[Customer] ([AccountID])
GO
ALTER TABLE [dbo].[Deal] CHECK CONSTRAINT [FK_GiaoDich_KhachHang]
GO
USE [master]
GO
ALTER DATABASE [DichVu] SET  READ_WRITE 
GO
