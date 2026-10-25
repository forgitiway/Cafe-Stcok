import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CafeStock extends JFrame implements ActionListener, MouseListener {

    JLabel lblNama, lblKategori, lblStok, lblMinimum;
    JTextField txtNama, txtStok, txtMinimum;
    JComboBox<String> cmbKategori;

    JButton btnTambah, btnReset, btnTambahStok;
    JButton btnKurangiStok, btnHapus;

    JTable tabel;
    DefaultTableModel model;

    public CafeStock() {
        setTitle("CafeStock - Manajemen Stok Cafe");
        setSize(800, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelUtama = new JPanel(new BorderLayout(10, 10));
        panelUtama.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
        panelUtama.setBackground(new Color(250, 240, 220));

        JPanel panelJudul = new JPanel(
            new FlowLayout(FlowLayout.LEFT)
        );
        panelJudul.setBackground(new Color(110, 70, 40));

        JLabel lblJudul = new JLabel("CafeStock");
        lblJudul.setFont(new Font("Arial", Font.BOLD, 26));
        lblJudul.setForeground(Color.WHITE);
        panelJudul.add(lblJudul);

        JPanel panelForm = new JPanel(new GridLayout(4, 2, 8, 8));
        panelForm.setBorder(
            BorderFactory.createTitledBorder("Data Bahan")
        );
        panelForm.setBackground(Color.WHITE);

        lblNama = new JLabel("Nama Bahan");
        txtNama = new JTextField();

        lblKategori = new JLabel("Kategori");
        cmbKategori = new JComboBox<>(new String[]{
            "Kopi", "Susu", "Sirup", "Teh", "Topping", "Lainnya"
        });

        lblStok = new JLabel("Jumlah Stok");
        txtStok = new JTextField();

        lblMinimum = new JLabel("Batas Minimum");
        txtMinimum = new JTextField();

        panelForm.add(lblNama);
        panelForm.add(txtNama);
        panelForm.add(lblKategori);
        panelForm.add(cmbKategori);
        panelForm.add(lblStok);
        panelForm.add(txtStok);
        panelForm.add(lblMinimum);
        panelForm.add(txtMinimum);

        btnTambah = new JButton("Tambah Bahan");
        btnReset = new JButton("Reset");

        JPanel panelTombolForm = new JPanel(new FlowLayout());
        panelTombolForm.setBackground(Color.WHITE);
        panelTombolForm.add(btnTambah);
        panelTombolForm.add(btnReset);

        JPanel panelAtas = new JPanel(new BorderLayout(5, 5));
        panelAtas.setBackground(new Color(250, 240, 220));
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombolForm, BorderLayout.SOUTH);

        String[] kolom = {
            "Nama Bahan", "Kategori", "Stok",
            "Batas Minimum", "Status"
        };

        model = new DefaultTableModel(kolom, 0);
        tabel = new JTable(model);
        tabel.setRowHeight(25);
        tabel.addMouseListener(this);

        JScrollPane scroll = new JScrollPane(tabel);
        scroll.setBorder(
            BorderFactory.createTitledBorder("Daftar Stok")
        );

        btnTambahStok = new JButton("Tambah Stok");
        btnKurangiStok = new JButton("Kurangi Stok");
        btnHapus = new JButton("Hapus Bahan");

        JPanel panelAksi = new JPanel(new FlowLayout());
        panelAksi.setBackground(new Color(250, 240, 220));
        panelAksi.add(btnTambahStok);
        panelAksi.add(btnKurangiStok);
        panelAksi.add(btnHapus);

        JPanel panelTabel = new JPanel(new BorderLayout(5, 5));
        panelTabel.add(scroll, BorderLayout.CENTER);
        panelTabel.add(panelAksi, BorderLayout.SOUTH);

        JPanel panelIsi = new JPanel(new BorderLayout(10, 10));
        panelIsi.setBackground(new Color(250, 240, 220));
        panelIsi.add(panelAtas, BorderLayout.NORTH);
        panelIsi.add(panelTabel, BorderLayout.CENTER);

        panelUtama.add(panelJudul, BorderLayout.NORTH);
        panelUtama.add(panelIsi, BorderLayout.CENTER);

        add(panelUtama);

        btnTambah.addActionListener(this);
        btnReset.addActionListener(this);
        btnTambahStok.addActionListener(this);
        btnKurangiStok.addActionListener(this);
        btnHapus.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnTambah) {
            String nama = txtNama.getText().trim();
            String stokText = txtStok.getText().trim();
            String minimumText = txtMinimum.getText().trim();

            if (nama.isEmpty() || stokText.isEmpty()
                    || minimumText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Semua data harus diisi!");
                return;
            }

            try {
                int stok = Integer.parseInt(stokText);
                int minimum = Integer.parseInt(minimumText);

                if (stok < 0 || minimum < 0) {
                    JOptionPane.showMessageDialog(this,
                        "Stok dan batas minimum tidak boleh negatif!");
                    return;
                }

                String kategori =
                    cmbKategori.getSelectedItem().toString();

                String status;
                if (stok <= minimum) {
                    status = "Menipis";
                } else {
                    status = "Aman";
                }

                model.addRow(new Object[]{
                    nama, kategori, stok, minimum, status
                });

                txtNama.setText("");
                txtStok.setText("");
                txtMinimum.setText("");
                cmbKategori.setSelectedIndex(0);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Stok dan batas minimum harus berupa angka!");
            }
        }

        else if (e.getSource() == btnReset) {
            txtNama.setText("");
            txtStok.setText("");
            txtMinimum.setText("");
            cmbKategori.setSelectedIndex(0);
        }

        else if (e.getSource() == btnTambahStok) {
            int baris = tabel.getSelectedRow();

            if (baris == -1) {
                JOptionPane.showMessageDialog(this,
                    "Pilih bahan dari tabel terlebih dahulu!");
                return;
            }

            String input = JOptionPane.showInputDialog(
                this, "Masukkan jumlah stok yang ditambahkan:"
            );

            if (input != null) {
                try {
                    int jumlah = Integer.parseInt(input);
                    int stok = Integer.parseInt(
                        model.getValueAt(baris, 2).toString()
                    );

                    if (jumlah <= 0) {
                        JOptionPane.showMessageDialog(this,
                            "Jumlah harus lebih dari 0!");
                        return;
                    }

                    stok = stok + jumlah;
                    model.setValueAt(stok, baris, 2);
                    perbaruiStatus(baris);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this,
                        "Masukkan angka yang benar!");
                }
            }
        }

        else if (e.getSource() == btnKurangiStok) {
            int baris = tabel.getSelectedRow();

            if (baris == -1) {
                JOptionPane.showMessageDialog(this,
                    "Pilih bahan dari tabel terlebih dahulu!");
                return;
            }

            String input = JOptionPane.showInputDialog(
                this, "Masukkan jumlah stok yang digunakan:"
            );

            if (input != null) {
                try {
                    int jumlah = Integer.parseInt(input);
                    int stok = Integer.parseInt(
                        model.getValueAt(baris, 2).toString()
                    );

                    if (jumlah <= 0 || jumlah > stok) {
                        JOptionPane.showMessageDialog(this,
                            "Jumlah tidak valid atau stok tidak cukup!");
                        return;
                    }

                    stok = stok - jumlah;
                    model.setValueAt(stok, baris, 2);
                    perbaruiStatus(baris);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this,
                        "Masukkan angka yang benar!");
                }
            }
        }

        else if (e.getSource() == btnHapus) {
            int baris = tabel.getSelectedRow();

            if (baris == -1) {
                JOptionPane.showMessageDialog(this,
                    "Pilih bahan yang ingin dihapus!");
            } else {
                model.removeRow(baris);
                txtNama.setText("");
                txtStok.setText("");
                txtMinimum.setText("");
                cmbKategori.setSelectedIndex(0);
            }
        }
    }

    private void perbaruiStatus(int baris) {
        int stok = Integer.parseInt(
            model.getValueAt(baris, 2).toString()
        );
        int minimum = Integer.parseInt(
            model.getValueAt(baris, 3).toString()
        );

        if (stok <= minimum) {
            model.setValueAt("Menipis", baris, 4);
        } else {
            model.setValueAt("Aman", baris, 4);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int baris = tabel.getSelectedRow();

        if (baris != -1) {
            txtNama.setText(
                model.getValueAt(baris, 0).toString()
            );
            cmbKategori.setSelectedItem(
                model.getValueAt(baris, 1).toString()
            );
            txtStok.setText(
                model.getValueAt(baris, 2).toString()
            );
            txtMinimum.setText(
                model.getValueAt(baris, 3).toString()
            );
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        new CafeStock();
    }
}
