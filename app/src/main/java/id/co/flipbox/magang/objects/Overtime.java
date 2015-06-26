package id.co.flipbox.magang.objects;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Taufik on 25 Jun 2015.
 */
public class Overtime implements Serializable{
    int id;
    String status, desc;
    Time mulai, selesai;
    User pekerja;
    Date tanggal;

    public Overtime(int id, String desc, Time mulai, Time selesai, User pekerja, Date tanggal) {
        this.id = id;
        this.status = "pending";
        this.desc = desc;
        this.mulai = mulai;
        this.selesai = selesai;
        this.pekerja = pekerja;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public User getPekerja() {
        return pekerja;
    }

    public void setPekerja(User pekerja) {
        this.pekerja = pekerja;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
