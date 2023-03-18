-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2021 at 03:51 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlybangiay`
--

-- --------------------------------------------------------

--
-- Table structure for table `cthoadon`
--

CREATE TABLE `cthoadon` (
  `MaHoaDon` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaGiay` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cthoadon`
--

INSERT INTO `cthoadon` (`MaHoaDon`, `MaGiay`, `SoLuong`) VALUES
('HD00001', 'MG00001', 19),
('HD00002', 'MG00002', 48),
('HD00003', 'MG00001', 3),
('HD00005', 'MG00003', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `MaPhieuNhap` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaGiay` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`MaPhieuNhap`, `MaGiay`, `SoLuong`) VALUES
('PN00001', 'MG00001', 5),
('PN00002', 'MG00002', 5),
('PN0003', 'MG00001', 5),
('PN0006', 'MG00001', 5),
('PN0011', 'MG00002', 3);

-- --------------------------------------------------------

--
-- Table structure for table `giay`
--

CREATE TABLE `giay` (
  `MaGiay` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenGiay` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaNSX` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaLoai` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Size` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MauSac` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GiaThanh` int(11) DEFAULT NULL,
  `TrangThai` tinyint(1) NOT NULL,
  `SoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `giay`
--

INSERT INTO `giay` (`MaGiay`, `TenGiay`, `MaNSX`, `MaLoai`, `Size`, `MauSac`, `GiaThanh`, `TrangThai`, `SoLuong`) VALUES
('aaaa', 'adidas baba', 'AD', 'NK00002', '45', 'vàng', 1200000, 1, 120),
('MG00001', 'Adidas Alphatoriso', 'AD', 'AD00003', '42.5', 'Đen', 2295000, 0, 17),
('MG00002', 'Adidas Macquee Boost', 'AD', 'AD00002', '43.1', 'Xám', 1785000, 1, 50),
('MG00003', 'Nike Jordan Low 1', 'NK', 'NK00002', '44', 'Xám', 4995000, 1, 29),
('MG00004', 'Adidas Alphatoriso II', 'AD', 'AD00003', '42.5', 'Đen', 3295000, 1, 25),
('MG00005', 'Nike Jordan High 1', 'NK', 'NK00002', '44', 'Xám', 5995000, 1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHoaDon` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNhanVien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayXuat` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHoaDon`, `MaNhanVien`, `NgayXuat`) VALUES
('HD00001', 'NV00001', '2022-10-10'),
('HD00002', 'NV00002', '2022-10-22'),
('HD00003', 'NV00001', '2022-10-19'),
('HD00004', 'NV00001', '2022-10-20'),
('HD00005', 'NV00001', '2022-10-20');

-- --------------------------------------------------------

--
-- Table structure for table `loaigiay`
--

CREATE TABLE `loaigiay` (
  `MaLoai` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenLoai` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GhiChu` text COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loaigiay`
--

INSERT INTO `loaigiay` (`MaLoai`, `TenLoai`, `GhiChu`) VALUES
('AD00001', 'Giày bóng đá', 'Adidas'),
('AD00002', 'Giày bóng rổ', 'Adidas'),
('AD00003', 'Giày chạy bộ', 'Adidas'),
('BT00001', 'Giày chạy bộ', 'Bitis'),
('NK00001', 'Giày bóng đá', 'Nike'),
('NK00002', 'Giày bóng rổ', 'Nike'),
('NK00003', 'Giày chạy bộ', 'Nike'),
('PK00001', 'Giày bóng rổ', 'Peak');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNhaCungCap` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNhaCungCap` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SoDienThoai` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `SoDienThoai`) VALUES
('NccAD', 'HoangThinhSport', 'TPHCM, Việt Nam', '0896454463'),
('NccBT', 'HaiAnhSport', 'Đà Nẵng, Việt Nam', '0756847846'),
('NccNK', 'TrungQuanSport', 'Hà Nội, Việt Nam', '0356475463'),
('NccPK', 'LapThanhSport', 'TPHCM, Việt Nam', '0356885363');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNhanVien` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `DiaChi` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SoDienThoai` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `UserName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MatKhau` varchar(24) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Quyen` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TrangThai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `TenNhanVien`, `NgaySinh`, `DiaChi`, `SoDienThoai`, `UserName`, `MatKhau`, `Quyen`, `TrangThai`) VALUES
('NV00001', 'Vũ Đức Huy', '2001-01-01', 'Tp.Hcm', '0789516331', 'root', '123', 'ADMIN', 1),
('NV00002', 'La Chí Bàng', '2001-01-01', 'Tp.Hcm', '0902279342', 'nvBang', 'NhanVien', 'NhanVien', 1),
('NV00003', 'Phan Văn Dậu', '2001-09-29', 'Long An', '0898139808', 'nvDau', '123', 'NhanVien', 1),
('NV00004', 'Lê Hoàng Anh', '2002-02-18', 'TPHCM', '0795867307', 'nvAnh', '123', 'NhanVien', 0);

-- --------------------------------------------------------

--
-- Table structure for table `nhasanxuat`
--

CREATE TABLE `nhasanxuat` (
  `MaNhaSanXuat` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNhaSanXuat` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `QuocGia` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhasanxuat`
--

INSERT INTO `nhasanxuat` (`MaNhaSanXuat`, `TenNhaSanXuat`, `QuocGia`) VALUES
('AD', 'Adidas', 'Đức'),
('BT', 'Bitis', 'Việt Nam'),
('NK', 'Nike', 'Mỹ'),
('PK', 'Peak', 'Trung Quốc');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPhieuNhap` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNhanVien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNhaCungCap` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayNhap` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPhieuNhap`, `MaNhanVien`, `MaNhaCungCap`, `NgayNhap`) VALUES
('PN00001', 'NV00001', 'NccNK', '2022-03-22'),
('PN00002', 'NV00002', 'NccAD', '2022-01-02'),
('PN00012', 'NV00003', 'NccAD', '2022-05-20'),
('PN0003', 'NV00003', 'NccAD', '2022-05-19'),
('PN0004', 'NV00003', 'NccAD', '2022-05-19'),
('PN0005', 'NV00003', 'NccAD', '2022-05-19'),
('PN0006', 'NV00003', 'NccAD', '2022-05-19'),
('PN0007', 'NV00003', 'NccAD', '2022-05-19'),
('PN0008', 'NV00003', 'NccAD', '2022-05-19'),
('PN0009', 'NV00003', 'NccAD', '2022-05-19'),
('PN0010', 'NV00003', 'NccAD', '2022-05-19'),
('PN0011', 'NV00003', 'NccAD', '2022-05-19');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD PRIMARY KEY (`MaHoaDon`,`MaGiay`),
  ADD KEY `MaGiay` (`MaGiay`);

--
-- Indexes for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`,`MaGiay`),
  ADD KEY `MaGiay` (`MaGiay`);

--
-- Indexes for table `giay`
--
ALTER TABLE `giay`
  ADD PRIMARY KEY (`MaGiay`),
  ADD KEY `MaNSX` (`MaNSX`,`MaLoai`),
  ADD KEY `MaLoai` (`MaLoai`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `MaNhanVien` (`MaNhanVien`);

--
-- Indexes for table `loaigiay`
--
ALTER TABLE `loaigiay`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNhaCungCap`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- Indexes for table `nhasanxuat`
--
ALTER TABLE `nhasanxuat`
  ADD PRIMARY KEY (`MaNhaSanXuat`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`),
  ADD KEY `MaNhanVien` (`MaNhanVien`,`MaNhaCungCap`),
  ADD KEY `MaNhaCungCap` (`MaNhaCungCap`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD CONSTRAINT `cthoadon_ibfk_1` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cthoadon_ibfk_2` FOREIGN KEY (`MaGiay`) REFERENCES `giay` (`MaGiay`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `ctphieunhap_ibfk_1` FOREIGN KEY (`MaPhieuNhap`) REFERENCES `phieunhap` (`MaPhieuNhap`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctphieunhap_ibfk_2` FOREIGN KEY (`MaGiay`) REFERENCES `giay` (`MaGiay`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `giay`
--
ALTER TABLE `giay`
  ADD CONSTRAINT `giay_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `loaigiay` (`MaLoai`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `giay_ibfk_2` FOREIGN KEY (`MaNSX`) REFERENCES `nhasanxuat` (`MaNhaSanXuat`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNhaCungCap`) REFERENCES `nhacungcap` (`MaNhaCungCap`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
