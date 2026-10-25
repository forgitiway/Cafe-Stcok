# CafeStock — Manajemen Stok Cafe

**Nama:** Istiqomah Virginia  
**NIM:** F1D02410116

---

## 1. Deskripsi Aplikasi

CafeStock merupakan aplikasi berbasis Java Swing yang digunakan untuk mengelola persediaan bahan di cafe. Aplikasi ini membantu pengguna mencatat dan memantau stok bahan agar persediaan tetap terkontrol.

## 2. Fitur Aplikasi

- Menambahkan data bahan cafe.
- Memilih kategori bahan.
- Menampilkan data bahan dalam bentuk tabel.
- Menambah jumlah stok bahan.
- Mengurangi jumlah stok bahan.
- Menghapus data bahan.
- Menampilkan status stok berdasarkan batas minimum.
- Memvalidasi input agar data yang dimasukkan sesuai.

## 3. Teknologi

- **Bahasa Pemrograman:** Java
- **Library GUI:** Java Swing
- **Komponen Tabel:** JTable dan DefaultTableModel
- **Layout:** BorderLayout, FlowLayout, dan GridLayout
- **IDE:** Visual Studio Code

## 4. Komponen GUI

### Top Level Container

- **JFrame:** Digunakan sebagai jendela utama aplikasi CafeStock yang menampung seluruh komponen GUI.

Contoh kode:

```java
public class CafeStock extends JFrame
```

### Intermediate Component

- **JPanel:** Mengelompokkan komponen berdasarkan bagian tampilan, seperti judul, form input, dan tabel.
- **JScrollPane:** Menampung tabel dan menyediakan fasilitas scroll apabila data melebihi area yang tersedia.

Contoh kode:

```java
JPanel panelUtama = new JPanel(new BorderLayout(10, 10));
JScrollPane scroll = new JScrollPane(tabel);
```

### Atomic Component

- **JLabel:** Menampilkan teks atau keterangan pada form.
- **JTextField:** Menerima input nama bahan, jumlah stok, dan batas minimum.
- **JComboBox:** Memilih kategori bahan.
- **JButton:** Menjalankan perintah melalui tombol.
- **JTable:** Menampilkan daftar bahan dan informasi stok dalam bentuk tabel.

## 5. Layout Manager

### BorderLayout

Mengatur komponen berdasarkan posisi NORTH, SOUTH, EAST, WEST, dan CENTER. Layout ini digunakan untuk menyusun judul, form, dan tabel.

### GridLayout

Menyusun komponen dalam baris dan kolom dengan ukuran sel yang seragam. Layout ini digunakan pada form input yang terdiri dari empat baris dan dua kolom.

### FlowLayout

Menyusun komponen secara berurutan dari kiri ke kanan. Layout ini digunakan untuk mengatur posisi tombol.

## 6. Event Handling

Event Handling digunakan untuk menangani interaksi pengguna dengan aplikasi. CafeStock menggunakan dua interface, yaitu ActionListener dan MouseListener.

### ActionListener

Digunakan untuk menangani tindakan ketika pengguna menekan tombol.

- Tombol Tambah Bahan untuk menambahkan data.
- Tombol Reset untuk mengosongkan form.
- Tombol Tambah Stok untuk menambah persediaan.
- Tombol Kurangi Stok untuk mengurangi persediaan.
- Tombol Hapus Bahan untuk menghapus data.

Contoh kode:

```java
btnTambah.addActionListener(this);
```

Method yang digunakan untuk menangani tindakan tombol adalah `actionPerformed()`.

### MouseListener

Digunakan untuk menangani interaksi mouse pada tabel. Ketika pengguna mengklik baris tabel, data bahan yang dipilih akan ditampilkan kembali pada form input.

Contoh kode:

```java
tabel.addMouseListener(this);
```

Method `mouseClicked()` digunakan untuk menangani kejadian ketika baris tabel diklik.

## 7. Cara Menjalankan

1. Pastikan Java Development Kit (JDK) sudah terpasang.
2. Buka folder project Cafe-Stock di Visual Studio Code.
3. Buka file `CafeStock.java`.
4. Jalankan program melalui tombol Run Java.
5. Jendela aplikasi CafeStock akan muncul dan siap digunakan.

## 8. Struktur Proyek

```text
Cafe-Stock/
├── screenshot cafestock/
│   ├── halamanAwal.png
│   ├── kurangiStok.png
│   ├── statusBahan.png
│   └── validasiStok.png
├── CafeStock.java
└── README.md
```

Keterangan:
- `screenshot cafestock/` merupakan folder yang berisi dokumentasi screenshot aplikasi.
- `halamanAwal.png` menampilkan tampilan awal aplikasi CafeStock.
- `kurangiStok.png` menampilkan proses pengurangan stok bahan.
- `statusBahan.png` menampilkan status persediaan bahan.
- `validasiStok.png` menampilkan contoh validasi input stok.
- `CafeStock.java` berisi kode program aplikasi.
- `README.md` berisi dokumentasi aplikasi CafeStock.


Keterangan:

- `CafeStock.java` berisi kode program aplikasi.
- `README.md` berisi dokumentasi aplikasi.
- `cafestock.png` berisi screenshot tampilan aplikasi.

## 9. Penyimpanan Data

Data bahan disimpan sementara menggunakan `DefaultTableModel` selama aplikasi berjalan. Data tidak disimpan secara permanen ke database atau file, sehingga data akan hilang ketika aplikasi ditutup.

## 10. Dokumentasi Screenshot

### A. Halaman Awal

![Halaman Awal](screenshot-cafestock/halamanAwal.png)

### B. Pengurangan Stok

![Pengurangan Stok](screenshot-cafestock/kurangiStok.png)

### C. Status Bahan

![Status Bahan](screenshot-cafestock/statusBahan.png)

### D. Validasi Stok

![Validasi Stok](screenshot-cafestock/validasiStok.png)