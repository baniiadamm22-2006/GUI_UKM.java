package pertemuan6;
import java.awt.*;
import javax.swing.*;

public class GUI_UKM extends JFrame {
 
    JTextField txtNama, txtNIM, txtProdi, txtWA;
    JComboBox<String> cmbUKM, cmbSubUKM, cmbLevel;
    JTextArea txtOutput;
    JButton btnDaftar;

    ManajemenUKM ukm = new ManajemenUKM();

    public GUI_UKM() {
        setTitle("Pendaftaran UKM UEU");
        setSize(520, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //wadah 
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(235, 242, 250));
        root.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(root);

        //header
        JPanel header = new JPanel();
        header.setBackground(new Color(0, 92, 168));
        header.setBorder(BorderFactory.createEmptyBorder(18, 10, 18, 10));
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("FORM PENDAFTARAN UKM");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Universitas Esa Unggul");
        subtitle.setForeground(new Color(220, 235, 255));
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(title); //nambah jdul utma
        header.add(Box.createVerticalStrut(4));//kasi jarak 
        header.add(subtitle);// nmbah subjudul stlh judul utma

        root.add(header, BorderLayout.NORTH);

        //untuk input data 
        JPanel cardForm = new JPanel();
        cardForm.setLayout(new BoxLayout(cardForm, BoxLayout.Y_AXIS));//supaya tersusun dri atas ke bwh
        cardForm.setBackground(Color.WHITE);
        cardForm.setBorder(BorderFactory.createCompoundBorder( // style border
                BorderFactory.createLineBorder(new Color(210, 220, 235)),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        txtNama = field(); //untuk input user agar uk dan font sma
        txtNIM = field();
        txtProdi = field();
        txtWA = field();

        cmbUKM = new JComboBox<>(ukm.daftarUKM.toArray(new String[0]));//box pilihan yang di ambil dri manajemen ukm
        cmbSubUKM = new JComboBox<>();
        cmbLevel = new JComboBox<>(ukm.daftarLevel.toArray(new String[0]));//box pilihan kemampuan

        //disusun secara berurutan 
        cardForm.add(label("Nama Mahasiswa"));
        cardForm.add(txtNama);

        cardForm.add(label("NIM"));
        cardForm.add(txtNIM);

        cardForm.add(label("Program Studi"));
        cardForm.add(txtProdi);

        cardForm.add(label("No WhatsApp"));
        cardForm.add(txtWA);

        cardForm.add(label("UKM"));
        cardForm.add(cmbUKM);

        cardForm.add(label("Sub UKM"));
        cardForm.add(cmbSubUKM);

        cardForm.add(label("Level Kemampuan"));
        cardForm.add(cmbLevel);

        cardForm.add(Box.createVerticalStrut(15));

        btnDaftar = new JButton("DAFTAR UKM");
        btnDaftar.setBackground(new Color(0, 120, 215));
        btnDaftar.setForeground(Color.WHITE);
        btnDaftar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnDaftar.setFocusPainted(false);
        btnDaftar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDaftar.setPreferredSize(new Dimension(200, 38));

        cardForm.add(btnDaftar);

        //tmpt output dri user
        JPanel cardOutput = new JPanel(new BorderLayout());
        cardOutput.setBackground(Color.WHITE);
        cardOutput.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 220, 235)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel outTitle = new JLabel("HASIL PENDAFTARAN");
        outTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));

        txtOutput = new JTextArea(8, 20); //nampilin hasil pendaftran
        txtOutput.setEditable(false);//kunci output
        txtOutput.setFont(new Font("Consolas", Font.PLAIN, 12));
        txtOutput.setBackground(new Color(245, 248, 252));
        txtOutput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        cardOutput.add(outTitle, BorderLayout.NORTH);//menempatkan judul diatas
        cardOutput.add(new JScrollPane(txtOutput), BorderLayout.CENTER);

        // gabungin form input dan output 
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setOpaque(false);

        center.add(cardForm);
        center.add(Box.createVerticalStrut(15));
        center.add(cardOutput);

        root.add(center, BorderLayout.CENTER);

        // agr tidak bisa pilih sub ukm tnpa pilih ukm
        cmbUKM.addActionListener(e -> {
            cmbSubUKM.removeAllItems();
            ukm.pilihUKM(cmbUKM.getSelectedIndex() + 1);
            for (String s : ukm.daftarSubUKM) {
                cmbSubUKM.addItem(s);
            }
        });

        btnDaftar.addActionListener(e -> { // untuk menampilkan setelah tombol daftar di tekan
            ukm.nama = txtNama.getText();
            ukm.nim = txtNIM.getText();
            ukm.prodi = txtProdi.getText();
            ukm.noWA = txtWA.getText();

            ukm.pilihUKM(cmbUKM.getSelectedIndex() + 1);
            ukm.pilihSubUKM(cmbSubUKM.getSelectedIndex() + 1);
            ukm.pilihLevel(cmbLevel.getSelectedIndex() + 1);

            txtOutput.setText(ukm.getOutput());
        });
    }

    // style nya agar sama
    private JTextField field() {
        JTextField f = new JTextField();
        f.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        f.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        return f;
    }

    private JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        l.setBorder(BorderFactory.createEmptyBorder(10, 0, 3, 0));
        return l;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI_UKM().setVisible(true));
    }
}
