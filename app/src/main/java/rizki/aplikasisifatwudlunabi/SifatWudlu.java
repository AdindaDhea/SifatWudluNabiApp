package rizki.aplikasisifatwudlunabi;

import com.google.gson.annotations.SerializedName;

public class SifatWudlu {

    @SerializedName("id")
    private int id;
    @SerializedName("judul")
    private String judul;
    @SerializedName("gambar")
    private String gambar;
    @SerializedName("isi_konten")
    private String isi_konten;
    @SerializedName("sumber_isi")
    private String sumber_isi;
    @SerializedName("sumber_gambar")
    private String sumber_gambar;
    @SerializedName("dibuat_pada")
    private String dibuat_pada;
    @SerializedName("value")
    private String value;
    @SerializedName("message")
    private String massage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getIsi_konten() {
        return isi_konten;
    }

    public void setIsi_konten(String isi_konten) {
        this.isi_konten = isi_konten;
    }

    public String getSumber_isi() {
        return sumber_isi;
    }

    public void setSumber_isi(String sumber_isi) {
        this.sumber_isi = sumber_isi;
    }

    public String getDibuat_pada() {
        return dibuat_pada;
    }

    public void setDibuat_pada(String dibuat_pada) {
        this.dibuat_pada = dibuat_pada;
    }

    public String getSumber_gambar() {
        return sumber_gambar;
    }

    public void setSumber_gambar(String sumber_gambar) {
        this.sumber_gambar = sumber_gambar;
    }
}
