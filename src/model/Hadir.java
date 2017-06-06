/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;

/**
 *
 * @author Anindita
 */
public class Hadir {
    private String NIP;
    private String Nama;
    private String Jabatan;
    private String Foto;
    private String id_Jam;
    private Time MasukStart;
    private Time KerjaStart;
    private Time KerjaEnd;
    private Time KeluarEnd;
    
    public void setNIP(String nip){
        this.NIP = nip;
    }
    /**
     *
     * @return
     */
    public String getNIP(){
        return NIP;
    }
    
        public void setMasukStart(Time jam){
        this.MasukStart = jam;
    }
    /**
     *
     * @return
     */
    public Time getMasukStart(){
        return MasukStart;
    }

    /**
     * @return the KerjaStart
     */
    public Time getKerjaStart() {
        return KerjaStart;
    }

    /**
     * @param KerjaStart the KerjaStart to set
     */
    public void setKerjaStart(Time KerjaStart) {
        this.KerjaStart = KerjaStart;
    }

    /**
     * @return the KerjaEnd
     */
    public Time getKerjaEnd() {
        return KerjaEnd;
    }

    /**
     * @param KerjaEnd the KerjaEnd to set
     */
    public void setKerjaEnd(Time KerjaEnd) {
        this.KerjaEnd = KerjaEnd;
    }

    /**
     * @return the KeluarEnd
     */
    public Time getKeluarEnd() {
        return KeluarEnd;
    }

    /**
     * @param KeluarEnd the KeluarEnd to set
     */
    public void setKeluarEnd(Time KeluarEnd) {
        this.KeluarEnd = KeluarEnd;
    }

    /**
     * @return the Nama
     */
    public String getNama() {
        return Nama;
    }

    /**
     * @param Nama the Nama to set
     */
    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    /**
     * @return the Jabatan
     */
    public String getJabatan() {
        return Jabatan;
    }

    /**
     * @param Jabatan the Jabatan to set
     */
    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }

    /**
     * @return the Foto
     */
    public String getFoto() {
        return Foto;
    }

    /**
     * @param Foto the Foto to set
     */
    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    /**
     * @return the id_Jam
     */
    public String getId_Jam() {
        return id_Jam;
    }

    /**
     * @param id_Jam the id_Jam to set
     */
    public void setId_Jam(String id_Jam) {
        this.id_Jam = id_Jam;
    }
    
    
}
