-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2021 at 05:32 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `qlst`
--

-- --------------------------------------------------------

--
-- Table structure for table `cthd`
--

CREATE TABLE IF NOT EXISTS `cthd` (
  `MaHd` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DonGiaCTHD` double NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `ThanhTienCTHD` double NOT NULL,
  `TienGGCTHD` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctkm`
--

CREATE TABLE IF NOT EXISTS `ctkm` (
  `MaKm` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PhanTramGGCT` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctpn`
--

CREATE TABLE IF NOT EXISTS `ctpn` (
  `MaPn` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DonGiaPn` double NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `ThanhTienCTPn` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE IF NOT EXISTS `hoadon` (
  `MaHd` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaKh` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaKm` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayXuat` date NOT NULL,
  `TongTien` double NOT NULL,
  `TienGGHd` double NOT NULL,
  `ThanhTienHd` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE IF NOT EXISTS `khachhang` (
  `MaKh` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HoKh` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenKh` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sdt` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChiKh` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKh`, `HoKh`, `TenKh`, `Sdt`, `DiaChiKh`) VALUES
('KH001', 'Nguyễn', 'Văn A', '09111111111', '273 An Dương Vương P3 Q5 TPHCM'),
('KH002', 'Lê', 'Thị A', '0371111111', '275 An Dương Vương P3 Q5 TPHCM\r\n'),
('KH003', 'Võ', 'Văn', '034555555', '74 Phạm Hùng P9 Q8 TPHCM'),
('KH004', 'Trần', 'Thị N', '0217777777', '45 Ba Đình Hà Nội'),
('KH005', 'Nguyễn', 'Văn M', '0654211111', '580 Hưng Phú P9 Q8'),
('KH006', 'Trần', 'Bội Thư', '0908843432', '331 lê hồng phong'),
('KH007', 'Lâm', 'Văn Bền', '0944534343', '266 Cao Đạt'),
('KH008', 'Trần', 'Văn Tèo', '0123456789', 'abc xyz'),
('KH009', 'DFDFD', 'GFFGFG', '0123456678', 'SBABV'),
('KH010', 'jja', 'smssms', '2110000000', 'smsk');

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE IF NOT EXISTS `khuyenmai` (
  `MaKm` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenCT` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LoaiCT` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayBDKM` date NOT NULL,
  `NgayKTKM` date NOT NULL,
  `PhanTramGG` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKm`, `TenCT`, `LoaiCT`, `NgayBDKM`, `NgayKTKM`, `PhanTramGG`) VALUES
('KM000', 'Không khuyến mãi', 'Không', '2021-05-15', '2021-05-17', 0),
('KM001', 'Khuyến mãi sách ngoại văn', 'Khuyến mãi theo sách ', '2021-05-16', '2021-05-23', 0.15);

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE IF NOT EXISTS `loaisanpham` (
  `MaLoai` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenLoai` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`MaLoai`, `TenLoai`) VALUES
('LOAI12', 'loai moi');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `MaNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`MaNv`, `Password`) VALUES
('NV006', '123456'),
('NV007', '654321');

-- --------------------------------------------------------

--
-- Table structure for table `ncc`
--

CREATE TABLE IF NOT EXISTS `ncc` (
  `MaNCC` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNCC` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sdt` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DcNCC` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ncc`
--

INSERT INTO `ncc` (`MaNCC`, `TenNCC`, `Sdt`, `DcNCC`) VALUES
('NCC2', 'nhà cung cấp mớ', '034900668', 'quận'),
('NXB1', 'NXB Trẻ', '02839316289', '161B Lý Chính Thắng, Phường 7, Quận 3 , TP. Hồ Chí Minh');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE IF NOT EXISTS `nhanvien` (
  `MaNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HoNv` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChiNv` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ChucVu` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Luong` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNv`, `HoNv`, `TenNv`, `DiaChiNv`, `ChucVu`, `Luong`) VALUES
('NV006', 'Phạm Duy', 'Luân', 'Long An', 'Quản lý', 200000),
('NV007', 'Lê Hoài', 'Lân', 'Bình Định', 'Quản lý', 200000),
('NV008', 'Ngô Quang', 'Đông', 'TPHCM', 'Quản lý', 180000),
('NV009', 'Hồ Hải', 'Hậu', 'TPHCM', 'Quản lý', 170000),
('NV010', 'Trịnh Tuấn', 'Lộc', 'TPHCM', 'Nhân viên', 70000);

-- --------------------------------------------------------

--
-- Table structure for table `nhasx`
--

CREATE TABLE IF NOT EXISTS `nhasx` (
  `MaNSX` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNSX` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Sdt` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DcNSX` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `nhasx`
--

INSERT INTO `nhasx` (`MaNSX`, `TenNSX`, `Sdt`, `DcNSX`) VALUES
('NSX1', 'Pepsi', '032821378', 'TPHCM'),
('NSX2', 'Coca', '032384893', 'HN');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE IF NOT EXISTS `phieunhap` (
  `MaPn` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNxb` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayNhap` date NOT NULL,
  `ThanhTienPn` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE IF NOT EXISTS `sanpham` (
  `MaSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNSX` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNCC` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaLoai` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HSD` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DonGia` double NOT NULL,
  `SoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cthd`
--
ALTER TABLE `cthd`
 ADD PRIMARY KEY (`MaHd`,`MaSP`), ADD KEY `MaHd` (`MaHd`), ADD KEY `MaSach` (`MaSP`) USING BTREE;

--
-- Indexes for table `ctkm`
--
ALTER TABLE `ctkm`
 ADD PRIMARY KEY (`MaKm`,`MaSP`), ADD KEY `MaKm` (`MaKm`), ADD KEY `MaSach` (`MaSP`) USING BTREE;

--
-- Indexes for table `ctpn`
--
ALTER TABLE `ctpn`
 ADD PRIMARY KEY (`MaPn`,`MaSP`), ADD KEY `MaPn` (`MaPn`), ADD KEY `MaSach` (`MaSP`) USING BTREE;

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
 ADD PRIMARY KEY (`MaHd`), ADD KEY `hd1` (`MaNv`), ADD KEY `hd2` (`MaKh`), ADD KEY `hd3` (`MaKm`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
 ADD PRIMARY KEY (`MaKh`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
 ADD PRIMARY KEY (`MaKm`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
 ADD PRIMARY KEY (`MaLoai`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
 ADD PRIMARY KEY (`MaNv`);

--
-- Indexes for table `ncc`
--
ALTER TABLE `ncc`
 ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
 ADD PRIMARY KEY (`MaNv`);

--
-- Indexes for table `nhasx`
--
ALTER TABLE `nhasx`
 ADD PRIMARY KEY (`MaNSX`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
 ADD PRIMARY KEY (`MaPn`), ADD KEY `pn1` (`MaNv`), ADD KEY `pn2` (`MaNxb`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
 ADD PRIMARY KEY (`MaSP`), ADD KEY `s1` (`MaNSX`), ADD KEY `s2` (`MaNCC`), ADD KEY `s3` (`MaLoai`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cthd`
--
ALTER TABLE `cthd`
ADD CONSTRAINT `cthd1` FOREIGN KEY (`MaHd`) REFERENCES `hoadon` (`MaHd`),
ADD CONSTRAINT `cthd2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Constraints for table `ctkm`
--
ALTER TABLE `ctkm`
ADD CONSTRAINT `ctkm1` FOREIGN KEY (`MaKm`) REFERENCES `khuyenmai` (`MaKm`),
ADD CONSTRAINT `ctkm2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Constraints for table `ctpn`
--
ALTER TABLE `ctpn`
ADD CONSTRAINT `ctpn1` FOREIGN KEY (`MaPn`) REFERENCES `phieunhap` (`MaPn`),
ADD CONSTRAINT `ctpn2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
ADD CONSTRAINT `hd1` FOREIGN KEY (`MaNv`) REFERENCES `nhanvien` (`MaNv`),
ADD CONSTRAINT `hd2` FOREIGN KEY (`MaKh`) REFERENCES `khachhang` (`MaKh`),
ADD CONSTRAINT `hd3` FOREIGN KEY (`MaKm`) REFERENCES `khuyenmai` (`MaKm`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
ADD CONSTRAINT `fk_login` FOREIGN KEY (`MaNv`) REFERENCES `nhanvien` (`MaNv`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
ADD CONSTRAINT `pn1` FOREIGN KEY (`MaNv`) REFERENCES `nhanvien` (`MaNv`),
ADD CONSTRAINT `pn2` FOREIGN KEY (`MaNxb`) REFERENCES `ncc` (`MaNCC`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
ADD CONSTRAINT `s1` FOREIGN KEY (`MaNSX`) REFERENCES `nhasx` (`MaNSX`),
ADD CONSTRAINT `s2` FOREIGN KEY (`MaNCC`) REFERENCES `ncc` (`MaNCC`),
ADD CONSTRAINT `s3` FOREIGN KEY (`MaLoai`) REFERENCES `loaisanpham` (`MaLoai`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
