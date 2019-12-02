package rizki.aplikasisifatwudlunabi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("read.php")
    Call<List<SifatWudlu>> readKonten();

    @FormUrlEncoded
    @POST("insert.php")
    Call<SifatWudlu> insertKonten(
            @Field("key") String key,
            @Field("judul") String judul,
            @Field("gambar") String species,
            @Field("isi_konten") String isi_konten,
            @Field("sumber_isi") String sumber_isi,
            @Field("sumber_gambar") String sumber_gambar,
            @Field("dibuat_pada") String dibuat_pada);

    @FormUrlEncoded
    @POST("update.php")
    Call<SifatWudlu> updateKonten(
            @Field("key") String key,
            @Field("id") int id,
            @Field("judul") String judul,
            @Field("gambar") String species,
            @Field("isi_konten") String isi_konten,
            @Field("sumber_isi") String sumber_isi,
            @Field("sumber_gambar") String sumber_gambar,
            @Field("dibuat_pada") String dibuat_pada);

    @FormUrlEncoded
    @POST("delete.php")
    Call<SifatWudlu> deleteKonten(
            @Field("key") String key,
            @Field("id") int id,
            @Field("gambar") String gambar);

}
