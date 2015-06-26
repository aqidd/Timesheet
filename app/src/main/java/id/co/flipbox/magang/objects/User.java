package id.co.flipbox.magang.objects;



/**
 * Created by Taufik on 25 Jun 2015.
 */
public class User {
    private int nip, denda;
    private String email, username, nama, jabatan, telp, role;

    public User(int nip, String email, String username, String nama, String jabatan, String telp, String role) {
        this.nip = nip;
        this.email = email;
        this.username = username;
        this.nama = nama;
        this.jabatan = jabatan;
        this.telp = telp;
        this.role = role;
        denda = 0;
    }
}
