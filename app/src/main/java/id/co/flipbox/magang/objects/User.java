package id.co.flipbox.magang.objects;


import java.util.ArrayList;

/**
 * Created by Taufik on 25 Jun 2015.
 */
public class User {
    private int nip, denda;
    private String email, username, nama, jabatan, telp, role;
    private ArrayList<Project> projects;

    public User(int nip, String email, String username, String nama, String jabatan, String telp, String role, ArrayList<Project> projects) {
        this.nip = nip;
        this.email = email;
        this.username = username;
        this.nama = nama;
        this.jabatan = jabatan;
        this.telp = telp;
        this.role = role;
        this.projects = projects;
        denda = 0;
    }
}
