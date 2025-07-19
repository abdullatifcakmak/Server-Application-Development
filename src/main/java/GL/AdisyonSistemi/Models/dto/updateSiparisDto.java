package GL.AdisyonSistemi.Models.dto;

import GL.AdisyonSistemi.Models.Entities.Siparis;

public class updateSiparisDto {
    private Siparis siparis;
    private int odemeId;

    public Siparis getSiparis() {
        return siparis;
    }

    public void setSiparis(Siparis siparis) {
        this.siparis = siparis;
    }

    public int getOdemeId() {
        return odemeId;
    }

    public void setOdemeId(int odemeId) {
        this.odemeId = odemeId;
    }

    public updateSiparisDto(Siparis siparis, int odemeId) {
        this.siparis = siparis;
        this.odemeId = odemeId;
    }
}
