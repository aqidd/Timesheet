package id.co.flipbox.magang.objects;

import java.util.Date;

/**
 * Created by Taufik on 25 Jun 2015.
 */
public class Leave {
    int id;
    String status, jenis, desc;
    Date mulai, selesai;
    User pekerja;

    public Leave(int id, String jenis, String desc, Date mulai, Date selesai, User pekerja) {
        this.id = id;
        this.status = "pending";
        this.jenis = jenis;
        this.desc = desc;
        this.mulai = mulai;
        this.selesai = selesai;
        this.pekerja = pekerja;
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

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getMulai() {
        return mulai;
    }

    public void setMulai(Date mulai) {
        this.mulai = mulai;
    }

    public Date getSelesai() {
        return selesai;
    }

    public void setSelesai(Date selesai) {
        this.selesai = selesai;
    }

    public User getPekerja() {
        return pekerja;
    }

    public void setPekerja(User pekerja) {
        this.pekerja = pekerja;
    }
}

