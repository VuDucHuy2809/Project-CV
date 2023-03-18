-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 02, 2022 lúc 05:04 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shoe`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_banner`
--

CREATE TABLE `tbl_banner` (
  `id` int(11) NOT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `active` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_banner`
--

INSERT INTO `tbl_banner` (`id`, `title`, `image`, `active`) VALUES
(1, 'Banner 2', 'sl3.jpg', 1),
(2, 'Đăng ký thành viên', 'slideshow_3.jpg', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_category`
--

CREATE TABLE `tbl_category` (
  `id` int(11) NOT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_category`
--

INSERT INTO `tbl_category` (`id`, `title`, `content`) VALUES
(1, 'LUXUBU', 'LUXUBU'),
(2, 'LEXEBE', 'LEXEBE'),
(3, 'LIXIBI', 'LIXIBI'),
(4, 'LAXABA', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_comment`
--

CREATE TABLE `tbl_comment` (
  `id` int(11) NOT NULL,
  `idproduct` int(11) NOT NULL,
  `namemember` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `noidung` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_comment`
--

INSERT INTO `tbl_comment` (`id`, `idproduct`, `namemember`, `noidung`) VALUES
(2, 74, 'John Doe', 'how to buy'),
(3, 74, 'John Doe', 'Sale'),
(4, 72, 'John Doe', '123'),
(5, 72, 'John Doe', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_img_product`
--

CREATE TABLE `tbl_img_product` (
  `idpost` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `file_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `uploaded_on` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_img_product`
--

INSERT INTO `tbl_img_product` (`idpost`, `id_product`, `file_name`, `uploaded_on`) VALUES
(1, 57, '20.png', '2019-01-03 16:36:07'),
(2, 57, '20.png', '2019-01-03 16:36:07'),
(3, 57, '20.png', '2019-01-03 16:36:07'),
(4, 57, '24.png', '2019-01-03 17:03:07'),
(5, 58, '13.png', '2019-01-03 17:03:53'),
(6, 58, '6.png', '2019-01-03 17:05:25'),
(7, 59, '3.png', '2019-01-03 17:31:18'),
(8, 59, '8.png', '2019-01-03 17:31:18'),
(9, 59, '9.png', '2019-01-03 17:31:18'),
(10, 60, '16.png', '2019-01-03 17:32:17'),
(11, 60, '19.png', '2019-01-03 17:32:17'),
(12, 61, '9.png', '2019-01-03 17:32:59'),
(13, 61, '14.png', '2019-01-03 17:32:59'),
(14, 61, '18.png', '2019-01-03 17:32:59'),
(15, 62, '15.png', '2019-01-03 17:51:14'),
(16, 62, '20.png', '2019-01-03 17:51:14'),
(17, 63, '9.png', '2019-01-03 17:53:57'),
(18, 63, '15.png', '2019-01-03 17:53:57'),
(19, 63, '24.png', '2019-01-03 17:53:57'),
(20, 64, '1.png', '2019-01-03 17:54:46'),
(21, 64, '9.png', '2019-01-03 17:54:46'),
(22, 64, '15.png', '2019-01-03 17:54:46'),
(23, 65, '12.png', '2019-01-03 17:57:39'),
(24, 66, '11.png', '2019-01-03 17:58:08'),
(25, 67, '20.png', '2019-01-03 18:00:13'),
(26, 68, '7.png', '2019-01-03 18:00:43'),
(27, 69, '2.png', '2019-01-03 18:01:40'),
(28, 70, '5.png', '2019-01-03 18:02:47'),
(29, 71, '6.png', '2019-01-04 14:25:05'),
(30, 72, '3.png', '2019-01-04 14:47:07'),
(31, 72, '4.png', '2019-01-04 14:47:07'),
(32, 73, '7.png', '2019-01-04 14:47:42'),
(33, 73, '20.png', '2019-01-04 14:47:42'),
(34, 74, '3.png', '2019-01-04 16:08:16'),
(35, 74, '13.png', '2019-01-04 16:08:16'),
(36, 74, '19.png', '2019-01-04 16:08:16'),
(37, 74, '20.png', '2019-01-04 16:08:16'),
(38, 74, '23.png', '2019-01-04 16:08:16'),
(39, 74, '25.png', '2019-01-04 16:08:16'),
(40, 75, '3.png', '2019-01-17 17:48:48'),
(41, 75, '8.png', '2019-01-17 17:48:48'),
(42, 75, '15.png', '2019-01-17 17:48:48');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_oder`
--

CREATE TABLE `tbl_oder` (
  `id` int(11) UNSIGNED NOT NULL,
  `diachi` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `tongtien` float NOT NULL,
  `tenkhachhang` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `note` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hinhthuc` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `tinhtrang` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_oder`
--

INSERT INTO `tbl_oder` (`id`, `diachi`, `tongtien`, `tenkhachhang`, `email`, `phone`, `note`, `hinhthuc`, `tinhtrang`) VALUES
(1, '123', 25000, '123', 'truongcongloi1998@gm', '123', '123', 'Thanh toán tại cửa hàng', 'Chờ duyệt'),
(4, '21', 900000, '123', '123@gmail.com', '1123123123', '213', 'Thanh toán tại cửa hàng', 'Chờ duyệt'),
(5, 's', 89000, 's', 's@gami.com', 's', 's', 'Thanh toán tại cửa hàng', 'Thành công'),
(6, 'a', 900000, 'a', 'a@l.com', 'a', 'a', 'Thanh toán tại nhà', 'Chờ duyệt'),
(7, 'aaa', 80000, 'abc', 'AAAA@m.com', '020452', '', 'Thanh toán tại nhà', 'Chờ duyệt'),
(8, 'aaaaaaa', 2780000, 'aaaaaaaa', 'aaaa@aa.b', '123456', 'aaaaaa', 'Thanh toán tại cửa hàng', 'Thành công');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_oder_detail`
--

CREATE TABLE `tbl_oder_detail` (
  `maOder` int(10) UNSIGNED NOT NULL,
  `idproduct` int(10) UNSIGNED NOT NULL,
  `soluong` float UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_oder_detail`
--

INSERT INTO `tbl_oder_detail` (`maOder`, `idproduct`, `soluong`) VALUES
(1, 74, 1),
(1, 48, 1),
(2, 73, 4),
(3, 72, 5),
(4, 63, 10),
(5, 75, 101),
(5, 0, 101),
(6, 74, 1),
(7, 75, 4),
(8, 74, 101),
(8, 72, 101),
(8, 75, 1),
(8, 73, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_order_session`
--

CREATE TABLE `tbl_order_session` (
  `id` int(11) NOT NULL,
  `idproduct` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `color` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `size` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_order_session`
--

INSERT INTO `tbl_order_session` (`id`, `idproduct`, `name`, `color`, `size`) VALUES
(76, 123, 'LEXEBE 2', 'Black', 'L'),
(77, 72, 'LEXEBE 2', 'Blue', 'M'),
(78, 72, 'LEXEBE 2', 'Blue', 'M'),
(79, 72, 'LEXEBE 2', 'Blue', 'M'),
(80, 72, 'LEXEBE 2', 'Black', 'L');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_page`
--

CREATE TABLE `tbl_page` (
  `id` int(11) NOT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_post`
--

CREATE TABLE `tbl_post` (
  `id` int(11) NOT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `uploaded_on` datetime NOT NULL,
  `author` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_post`
--

INSERT INTO `tbl_post` (`id`, `title`, `content`, `image`, `description`, `uploaded_on`, `author`) VALUES
(1, 'LOREM IPSUM DOLOR SIT AMET', '<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n\r\n<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n\r\n<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n\r\n<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n\r\n<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n', '5.jpg', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...', '2019-01-03 16:36:07', 'Trương Công Lợi'),
(2, 'LOREM IPSUM DOLOR SIT AMET', '<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n\r\n<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n\r\n<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n\r\n<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n\r\n<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n', '6.jpg', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...', '2019-01-03 16:36:07', 'Trương Công Lợi'),
(3, 'LOREM IPSUM DOLOR SIT AMET', '<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n\r\n<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n\r\n<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n\r\n<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...</p>\r\n', '1.jpg', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna...', '2019-01-03 16:36:07', 'Trương Công Lợi'),
(4, 'LOREM IPSUM DOLOR SIT AMET', '<p>LOREM IPSUM DOLOR SIT AMETLOREM IPSUM DOLOR SIT AMETLOREM IPSUM DOLOR SIT AMETLOREM IPSUM DOLOR SIT AMETLOREM IPSUM DOLOR SIT AMET</p>\r\n', '2.jpg', 'LOREM IPSUM DOLOR SIT AMET....', '2019-01-04 14:43:13', 'LoiTruong');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_product`
--

CREATE TABLE `tbl_product` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `category` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `detail` text COLLATE utf8_unicode_ci NOT NULL,
  `sale` int(11) DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `uploaded_on` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_product`
--

INSERT INTO `tbl_product` (`id`, `name`, `code`, `price`, `amount`, `image`, `category`, `detail`, `sale`, `description`, `uploaded_on`) VALUES
(0, 'hieu', 'hieu', 12, 12, '1584233295351_922283782.jpg', '1', '<p>11111</p>\r\n', 11, '1111', '2022-11-02 10:48:25'),
(58, 'LUXUBU 1', '', 1000000, 100, '20.png', '1', '<p>123</p>\r\n', 900000, '123', '2019-01-03 16:36:07'),
(59, 'LUXUBU 2', '', 1000000, 100, '3.png', '1', '<p>123</p>\r\n', 900000, '123', '2019-01-03 16:36:07'),
(60, 'LEXEBE 3', '', 1000000, 100, '19.png', '2', '<p><br />\r\n<strong>Notice</strong>: Undefined index: chitiet in <strong>C:xampphtdocsshoeadminpageschange_product.php</strong> on line <strong>44</strong></p>\r\n', 900000, '<br />\r\n<b>Notice</b>:  Undefined index: mota in <b>C:xampphtdocsshoeadminpageschange_product.php</b> on line <b>42</b><br />\r\n', '2019-01-17 16:25:53'),
(61, 'LUXUBU 4', '', 1000000, 100, '25.png', '3', '<p>123123</p>\r\n', 900000, '23123', '2019-01-03 16:36:07'),
(62, 'LIXIBI 2', '', 1000000, 100, '1.png', '3', '<p>123</p>\r\n', 900000, '123', '2019-01-03 16:36:07'),
(63, 'LIXIBI 3', '', 1000000, 100, '10.png', '3', '<p>123123</p>\r\n', 900000, '123123', '2019-01-03 16:36:07'),
(64, 'LIXIBI 4', '', 1000000, 100, '17.png', '3', '<p>123</p>\r\n', 900000, '123', '2019-01-03 16:36:07'),
(65, 'LIXIBI 5', '', 1000000, 100, '11.png', '3', '<p>123</p>\r\n', 900000, '123', '2019-01-03 16:36:07'),
(66, 'LIXIBI 6', '', 1000000, 100, '12.png', '3', '<p>123</p>\r\n', 900000, '123', '2019-01-03 16:36:07'),
(67, 'LIXIBI 1', '', 1000000, 100, '26.png', '3', '<p>123</p>\r\n', 900000, '123', '2019-01-03 16:36:07'),
(68, 'LIXIBI 7', '', 1000000, 100, '13.png', '3', '<p>123123</p>\r\n', 900000, '12312', '2019-01-03 16:36:07'),
(69, 'LIXIBI 8', '', 1000000, 100, '18.png', '3', '<p>123123</p>\r\n', 900000, '234', '2019-01-03 16:36:07'),
(70, 'LUXUBU 9', '', 1000000, 100, '6.png', '3', '<p>123123</p>\r\n', 900000, '123', '2019-01-03 16:36:07'),
(71, 'LUXUBU 9', 'LUXUBU 9', 1000000, 100, '5.png', '1', '<p>123123</p>\r\n', 900000, '123', '2019-01-04 14:27:02'),
(72, 'LEXEBE 2', 'LEXEBE 2', 1000000, 100, '20.png', '2', '<p>123123123</p>\r\n', 900000, '123123123', '2019-01-04 14:48:11'),
(73, 'LEXEBE 3', 'LEXEBE 3', 1000000, 100, '13.png', '2', '<p>12312312</p>\r\n', 900000, '123123', '2019-01-04 14:47:42'),
(74, 'LEXEBE 4', 'LEXEBE 4', 1000000, 100, '20.png', '2', '<p>Nunc facilisis sagittis ullamcorper. Proin lectus ipsum, gravida et mattis vulputate, tristique ut lectus. Sed et lorem nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean eleifend laoreet congue. Vivamus adipiscing nisl ut dolor dignissim semper. Nulla luctus malesuada tincidunt. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer enim purus, posuere at ultricies eu, placerat a felis. Suspendisse aliquet urna pretium eros convallis interdum. Quisque in arcu id dui vulputate mollis eget non arcu. Aenean et nulla purus. Mauris vel tellus non nunc mattis lobortis.</p>\r\n', 900000, 'Nunc facilisis sagittis ullamcorper. Proin lectus ipsum, gravida et mattis vulputate, tristique ut lectus. Sed et lorem nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean eleifend laoreet congue. Vivamus adipiscing nisl ut dolor dignissim semper. Nulla luctus malesuada tincidunt. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer enim purus, posuere at ultricies eu, placerat a felis. Suspendisse al', '2019-01-04 16:08:16'),
(75, 'LAXABA', 'LAXABA', 1000000, 100, '8.png', '4', '<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt.</p>\r\n', 80000, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt.', '2019-01-17 17:48:48');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_user`
--

CREATE TABLE `tbl_user` (
  `username` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `name` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `chuc_vu` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_user`
--

INSERT INTO `tbl_user` (`username`, `name`, `email`, `phone`, `address`, `password`, `chuc_vu`) VALUES
('Admin', 'Admin', 'admin@gmail.com', '0868313206', 'HCM', 'e10adc3949ba59abbe56e057f20f883e', 'admin'),
('Hieu', 'Minh Hieu', 'hieu@gmail.com', '0123456789', 'TP.HCM', 'e10adc3949ba59abbe56e057f20f883e', 'client');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbl_banner`
--
ALTER TABLE `tbl_banner`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_category`
--
ALTER TABLE `tbl_category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_comment`
--
ALTER TABLE `tbl_comment`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_img_product`
--
ALTER TABLE `tbl_img_product`
  ADD PRIMARY KEY (`idpost`);

--
-- Chỉ mục cho bảng `tbl_oder`
--
ALTER TABLE `tbl_oder`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_order_session`
--
ALTER TABLE `tbl_order_session`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_page`
--
ALTER TABLE `tbl_page`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_post`
--
ALTER TABLE `tbl_post`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_product`
--
ALTER TABLE `tbl_product`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
