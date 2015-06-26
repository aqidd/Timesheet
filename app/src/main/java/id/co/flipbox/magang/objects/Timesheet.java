package id.co.flipbox.magang.objects;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Taufik on 25 Jun 2015.
 */
public class Timesheet {
    int id;
    Date tanggal;
    Time mulai, selesai;
    String desc, absensi, isian;
    User pekerja;
    Project proyek;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Time getMulai() {
        return mulai;
    }

    public void setMulai(Time mulai) {
        this.mulai = mulai;
    }

    public Time getSelesai() {
        return selesai;
    }

    public void setSelesai(Time selesai) {
        this.selesai = selesai;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAbsensi() {
        return absensi;
    }

    public void setAbsensi(String absensi) {
        this.absensi = absensi;
    }

    public String getIsian() {
        return isian;
    }

    public void setIsian(String isian) {
        this.isian = isian;
    }

    public User getPekerja() {
        return pekerja;
    }

    public void setPekerja(User pekerja) {
        this.pekerja = pekerja;
    }

    public Project getProyek() {
        return proyek;
    }

    public void setProyek(Project proyek) {
        this.proyek = proyek;
    }

    public Timesheet(int id, Date tanggal, Time mulai, Time selesai, String desc, String absensi, String isian, User pekerja, Project proyek) {
        this.id = id;
        this.tanggal = tanggal;
        this.mulai = mulai;
        this.selesai = selesai;
        this.desc = desc;
        this.absensi = absensi;
        this.isian = isian;
        this.pekerja = pekerja;
        this.proyek = proyek;
    }
}
