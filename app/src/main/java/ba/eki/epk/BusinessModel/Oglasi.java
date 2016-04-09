package ba.eki.epk.BusinessModel;

/**
 * Created by zoran.ereiz on 08.10.2015.
 */


import android.os.Parcel;
import android.os.Parcelable;

public class Oglasi {

    private int OglasId;
    private String Naslov;
    private String NazivKategorije;
    private String NazivPodkategorije;
    private String VrstaOglasa;
    private String VrijediDo;
    private String TextOglasa;

    /**
     * No args constructor for use in serialization
     *
     */
    public Oglasi() {
    }

    /**
     *
     * @param VrijediDo
     * @param NazivKategorije
     * @param TextOglasa
     * @param VrstaOglasa
     * @param OglasId
     * @param NazivPodkategorije
     * @param Naslov
     */
    public Oglasi(int OglasId, String Naslov, String NazivKategorije, String NazivPodkategorije, String VrstaOglasa, String VrijediDo, String TextOglasa) {
        this.OglasId = OglasId;
        this.Naslov = Naslov;
        this.NazivKategorije = NazivKategorije;
        this.NazivPodkategorije = NazivPodkategorije;
        this.VrstaOglasa = VrstaOglasa;
        this.VrijediDo = VrijediDo;
        this.TextOglasa = TextOglasa;
    }

    public Oglasi (Parcel source)
    {
        this.setOglasId(source.readInt());
        this.setNaslov(source.readString());
        this.setNazivKategorije(source.readString());
        this.setNazivPodkategorije(source.readString());
        this.setVrstaOglasa(source.readString());
        this.setVrijediDo(source.readString());
        this.setTextOglasa(source.readString());
    }

    public int getOglasId() {
        return OglasId;
    }

    public void setOglasId(int OglasId) {
        this.OglasId = OglasId;
    }

    public String getNaslov() {
        return Naslov;
    }

    public void setNaslov(String Naslov) {
        this.Naslov = Naslov;
    }

    public String getNazivKategorije() {
        return NazivKategorije;
    }

    public void setNazivKategorije(String NazivKategorije) {
        this.NazivKategorije = NazivKategorije;
    }

    public String getNazivPodkategorije() {
        return NazivPodkategorije;
    }

    public void setNazivPodkategorije(String NazivPodkategorije) {
        this.NazivPodkategorije = NazivPodkategorije;
    }

    public String getVrstaOglasa() {
        return VrstaOglasa;
    }

    public void setVrstaOglasa(String VrstaOglasa) {
        this.VrstaOglasa = VrstaOglasa;
    }

    public String getVrijediDo() {
        return VrijediDo;
    }

    public void setVrijediDo(String VrijediDo) {
        this.VrijediDo = VrijediDo;
    }

    public String getTextOglasa() {
        return TextOglasa;
    }

    public void setTextOglasa(String TextOglasa) {
        this.TextOglasa = TextOglasa;
    }

//    @Override
//    public int describeContents() {
//        return this.hashCode();
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//
//    }

    @Override
    public String toString() {
        return null; //return ToStringBuilder.reflectionToString(this);
    }

    public static final Parcelable.Creator<Oglasi> CREATOR = new Parcelable.Creator<Oglasi>() {
        @Override
        public Oglasi createFromParcel(Parcel parcel) {
            return new Oglasi(parcel);
        }

        @Override
        public Oglasi[] newArray(int i) {
            return new Oglasi[i];
        }
    };
}
