USE [master]
GO
/****** Object:  Database [zhc-ch]    Script Date: 10/17/2015 15:52:41 ******/
CREATE DATABASE [zhc-ch] ON  PRIMARY 
( NAME = N'zhc-ch', FILENAME = N'D:\sqlServer实例\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\zhc-ch.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'zhc-ch_log', FILENAME = N'D:\sqlServer实例\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\zhc-ch_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [zhc-ch] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [zhc-ch].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [zhc-ch] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [zhc-ch] SET ANSI_NULLS OFF
GO
ALTER DATABASE [zhc-ch] SET ANSI_PADDING OFF
GO
ALTER DATABASE [zhc-ch] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [zhc-ch] SET ARITHABORT OFF
GO
ALTER DATABASE [zhc-ch] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [zhc-ch] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [zhc-ch] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [zhc-ch] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [zhc-ch] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [zhc-ch] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [zhc-ch] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [zhc-ch] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [zhc-ch] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [zhc-ch] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [zhc-ch] SET  DISABLE_BROKER
GO
ALTER DATABASE [zhc-ch] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [zhc-ch] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [zhc-ch] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [zhc-ch] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [zhc-ch] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [zhc-ch] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [zhc-ch] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [zhc-ch] SET  READ_WRITE
GO
ALTER DATABASE [zhc-ch] SET RECOVERY FULL
GO
ALTER DATABASE [zhc-ch] SET  MULTI_USER
GO
ALTER DATABASE [zhc-ch] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [zhc-ch] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'zhc-ch', N'ON'
GO
USE [zhc-ch]
GO
/****** Object:  Table [dbo].[title]    Script Date: 10/17/2015 15:52:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[title](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[classify] [int] NOT NULL,
	[queue] [int] NOT NULL,
	[identity_id] [int] NOT NULL,
	[status] [int] NOT NULL,
	[title_val] [varchar](200) NOT NULL,
	[url] [varchar](200) NULL,
	[desc_text] [varchar](200) NULL,
	[modify_time] [datetime] NOT NULL,
	[page_num] [int] NOT NULL,
 CONSTRAINT [IX_title] UNIQUE NONCLUSTERED 
(
	[identity_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[text_val]    Script Date: 10/17/2015 15:52:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[text_val](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[classify] [int] NOT NULL,
	[queue] [int] NOT NULL,
	[identity_id] [int] NOT NULL,
	[status] [int] NOT NULL,
	[content_text] [text] NULL,
	[custom_title] [varchar](200) NOT NULL,
	[desc_text] [varchar](200) NULL,
	[create_time] [datetime] NOT NULL,
	[last_modify_time] [datetime] NULL,
	[page_num] [int] NOT NULL,
 CONSTRAINT [IX_text_val] UNIQUE NONCLUSTERED 
(
	[identity_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[mail]    Script Date: 10/17/2015 15:52:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[mail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[qq_num] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[phone] [varchar](50) NULL,
	[message_val] [text] NOT NULL,
	[job] [varchar](50) NULL,
	[ip] [varchar](50) NULL,
	[create_time] [datetime] NOT NULL,
 CONSTRAINT [IX_message] UNIQUE NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[index_id]    Script Date: 10/17/2015 15:52:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[index_id](
	[identity_id] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[img_text_val]    Script Date: 10/17/2015 15:52:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[img_text_val](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[classify] [int] NOT NULL,
	[queue] [int] NOT NULL,
	[identity_id] [int] NOT NULL,
	[status] [int] NOT NULL,
	[custom_title] [varchar](200) NOT NULL,
	[text_val] [varchar](500) NULL,
	[url] [varchar](200) NULL,
	[create_time] [datetime] NOT NULL,
	[last_modify_time] [datetime] NULL,
	[desc_text] [varchar](200) NULL,
	[page_num] [int] NOT NULL,
 CONSTRAINT [IX_img_text_val] UNIQUE NONCLUSTERED 
(
	[identity_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[img]    Script Date: 10/17/2015 15:52:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[img](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[classify] [int] NOT NULL,
	[queue] [int] NOT NULL,
	[identity_id] [int] NOT NULL,
	[status] [int] NOT NULL,
	[img_path] [varchar](200) NOT NULL,
	[url] [varchar](200) NULL,
	[desc_text] [varchar](200) NULL,
	[modify_time] [datetime] NOT NULL,
	[page_num] [int] NOT NULL,
 CONSTRAINT [IX_img] UNIQUE NONCLUSTERED 
(
	[identity_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
EXEC sys.sp_addextendedproperty @name=N'unique', @value=N'' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'img'
GO
/****** Object:  Table [dbo].[dept]    Script Date: 10/17/2015 15:52:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[dept](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[classify_num] [int] NOT NULL,
	[data_type] [varchar](50) NOT NULL,
	[sum] [int] NOT NULL,
	[max_queue] [int] NOT NULL,
	[min_queue] [int] NOT NULL,
	[first_page_sum] [int] NOT NULL,
	[desc_text] [varchar](200) NULL,
	[create_time] [datetime] NOT NULL,
	[main_local_page_url] [varchar](200) NULL,
	[queue] [int] NOT NULL,
	[page_num] [int] NOT NULL,
 CONSTRAINT [IX_dept] UNIQUE NONCLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[admin]    Script Date: 10/17/2015 15:52:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[admin](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[power] [int] NOT NULL,
	[forget_question] [varchar](100) NOT NULL,
	[forget_answer] [varchar](50) NOT NULL,
 CONSTRAINT [IX_admin] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Default [DF_title_queue]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[title] ADD  CONSTRAINT [DF_title_queue]  DEFAULT ((0)) FOR [queue]
GO
/****** Object:  Default [DF_title_status]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[title] ADD  CONSTRAINT [DF_title_status]  DEFAULT ((0)) FOR [status]
GO
/****** Object:  Default [DF_title_modify_time]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[title] ADD  CONSTRAINT [DF_title_modify_time]  DEFAULT (getdate()) FOR [modify_time]
GO
/****** Object:  Default [DF_title_page_num]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[title] ADD  CONSTRAINT [DF_title_page_num]  DEFAULT ((-1)) FOR [page_num]
GO
/****** Object:  Default [DF_text_val_queue]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[text_val] ADD  CONSTRAINT [DF_text_val_queue]  DEFAULT ((0)) FOR [queue]
GO
/****** Object:  Default [DF_text_val_status]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[text_val] ADD  CONSTRAINT [DF_text_val_status]  DEFAULT ((0)) FOR [status]
GO
/****** Object:  Default [DF_text_val_create_time]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[text_val] ADD  CONSTRAINT [DF_text_val_create_time]  DEFAULT (getdate()) FOR [create_time]
GO
/****** Object:  Default [DF_text_val_last_modify_time]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[text_val] ADD  CONSTRAINT [DF_text_val_last_modify_time]  DEFAULT (getdate()) FOR [last_modify_time]
GO
/****** Object:  Default [DF_text_val_page_num]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[text_val] ADD  CONSTRAINT [DF_text_val_page_num]  DEFAULT ((-1)) FOR [page_num]
GO
/****** Object:  Default [DF_message_create_time]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[mail] ADD  CONSTRAINT [DF_message_create_time]  DEFAULT (getdate()) FOR [create_time]
GO
/****** Object:  Default [DF_img_text_val_queue]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[img_text_val] ADD  CONSTRAINT [DF_img_text_val_queue]  DEFAULT ((0)) FOR [queue]
GO
/****** Object:  Default [DF_img_text_val_status]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[img_text_val] ADD  CONSTRAINT [DF_img_text_val_status]  DEFAULT ((0)) FOR [status]
GO
/****** Object:  Default [DF_img_text_val_create_time]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[img_text_val] ADD  CONSTRAINT [DF_img_text_val_create_time]  DEFAULT (getdate()) FOR [create_time]
GO
/****** Object:  Default [DF_img_text_val_last_modify_time]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[img_text_val] ADD  CONSTRAINT [DF_img_text_val_last_modify_time]  DEFAULT (getdate()) FOR [last_modify_time]
GO
/****** Object:  Default [DF_img_text_val_page_num]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[img_text_val] ADD  CONSTRAINT [DF_img_text_val_page_num]  DEFAULT ((-1)) FOR [page_num]
GO
/****** Object:  Default [DF_img_queue]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[img] ADD  CONSTRAINT [DF_img_queue]  DEFAULT ((0)) FOR [queue]
GO
/****** Object:  Default [DF_img_status]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[img] ADD  CONSTRAINT [DF_img_status]  DEFAULT ((0)) FOR [status]
GO
/****** Object:  Default [DF_img_modify_time]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[img] ADD  CONSTRAINT [DF_img_modify_time]  DEFAULT (getdate()) FOR [modify_time]
GO
/****** Object:  Default [DF_img_page_num]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[img] ADD  CONSTRAINT [DF_img_page_num]  DEFAULT ((-1)) FOR [page_num]
GO
/****** Object:  Default [DF_dept_create_time]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[dept] ADD  CONSTRAINT [DF_dept_create_time]  DEFAULT (getdate()) FOR [create_time]
GO
/****** Object:  Default [DF_dept_queue]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[dept] ADD  CONSTRAINT [DF_dept_queue]  DEFAULT ((0)) FOR [queue]
GO
/****** Object:  Default [DF_dept_page_num]    Script Date: 10/17/2015 15:52:42 ******/
ALTER TABLE [dbo].[dept] ADD  CONSTRAINT [DF_dept_page_num]  DEFAULT ((-1)) FOR [page_num]
GO
