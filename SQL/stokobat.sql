-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Bulan Mei 2020 pada 06.08
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stokobat`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `datacustomer`
--

CREATE TABLE `datacustomer` (
  `kd_cust` varchar(20) NOT NULL,
  `nm_cust` varchar(30) NOT NULL,
  `no_tlp` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `datacustomer`
--

INSERT INTO `datacustomer` (`kd_cust`, `nm_cust`, `no_tlp`, `alamat`) VALUES
('CU001', 'Cobain', '021', 'kalibata	'),
('CU002', 'Test', '021', 'kalibata1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `datakaryawan`
--

CREATE TABLE `datakaryawan` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `no_telp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `datakaryawan`
--

INSERT INTO `datakaryawan` (`username`, `password`, `status`, `nama`, `alamat`, `no_telp`) VALUES
('admin', 'admin', 'Admin', 'admin', 'admin', '1234'),
('username', 'password', 'Admin', 'nama', 'alamat', '123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dataobat`
--

CREATE TABLE `dataobat` (
  `kd_obat` varchar(20) NOT NULL,
  `status` varchar(30) NOT NULL,
  `nm_obat` varchar(30) NOT NULL,
  `jml_obat` int(10) NOT NULL,
  `harga` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dataobat`
--

INSERT INTO `dataobat` (`kd_obat`, `status`, `nm_obat`, `jml_obat`, `harga`) VALUES
('OB003', 'Obat Ringan', 'bodrek', 36, '1000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dataobatkeluar`
--

CREATE TABLE `dataobatkeluar` (
  `id` varchar(20) NOT NULL,
  `tgl` date NOT NULL,
  `kd_cust` varchar(30) NOT NULL,
  `nm_cust` varchar(30) NOT NULL,
  `kd_obat` varchar(30) NOT NULL,
  `nm_obat` varchar(30) NOT NULL,
  `jml_stok` int(20) NOT NULL,
  `jml_keluar` int(20) NOT NULL,
  `stok_akhir` int(20) NOT NULL,
  `nm_karyawan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dataobatkeluar`
--

INSERT INTO `dataobatkeluar` (`id`, `tgl`, `kd_cust`, `nm_cust`, `kd_obat`, `nm_obat`, `jml_stok`, `jml_keluar`, `stok_akhir`, `nm_karyawan`) VALUES
('BK0002', '2020-01-08', 'CU001', 'Cobain', 'OB003', 'bodrek', 14, 5, 12, 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dataobatmasuk`
--

CREATE TABLE `dataobatmasuk` (
  `id` varchar(20) NOT NULL,
  `tgl` date NOT NULL,
  `kd_supp` varchar(20) NOT NULL,
  `nm_supp` varchar(30) NOT NULL,
  `kd_obat` varchar(30) NOT NULL,
  `nm_obat` varchar(30) NOT NULL,
  `jml_obat` varchar(30) NOT NULL,
  `jml_msk` varchar(30) NOT NULL,
  `jml_stok` varchar(30) NOT NULL,
  `nm_karyawan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dataobatmasuk`
--

INSERT INTO `dataobatmasuk` (`id`, `tgl`, `kd_supp`, `nm_supp`, `kd_obat`, `nm_obat`, `jml_obat`, `jml_msk`, `jml_stok`, `nm_karyawan`) VALUES
('BK0002', '2020-01-07', 'CU001', 'Cobain', 'OB003', 'bodrek', '14', '13', '26', 'admin'),
('BK0003', '2020-05-12', 'CU001', 'Cobain', 'OB003', 'bodrek', '24', '12', '36', 'nama');

-- --------------------------------------------------------

--
-- Struktur dari tabel `datasupplier`
--

CREATE TABLE `datasupplier` (
  `kd_supp` varchar(20) NOT NULL,
  `nm_supp` varchar(30) NOT NULL,
  `no_tlp` varchar(20) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `nm_marketing` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `datasupplier`
--

INSERT INTO `datasupplier` (`kd_supp`, `nm_supp`, `no_tlp`, `alamat`, `nm_marketing`) VALUES
('SUP001', 'fachri', 'kalibata', '021', 'fachri'),
('SUP002', 'kita coba', '12', '021', 'coba');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `datacustomer`
--
ALTER TABLE `datacustomer`
  ADD PRIMARY KEY (`kd_cust`);

--
-- Indeks untuk tabel `datakaryawan`
--
ALTER TABLE `datakaryawan`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `dataobat`
--
ALTER TABLE `dataobat`
  ADD PRIMARY KEY (`kd_obat`);

--
-- Indeks untuk tabel `dataobatkeluar`
--
ALTER TABLE `dataobatkeluar`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `dataobatmasuk`
--
ALTER TABLE `dataobatmasuk`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `datasupplier`
--
ALTER TABLE `datasupplier`
  ADD PRIMARY KEY (`kd_supp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
