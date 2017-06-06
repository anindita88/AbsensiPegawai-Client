/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Hadir;

/**
 *
 * @author Anindita
 */
public class Submit_hadir {
    
    Hadir h = new Hadir();
    
    public boolean cek_pegawai(Hadir karyawan) throws SQLException {
        
        String cek = "SELECT * from tblpegawai where idpegawai = ?";
        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
        pst.setString(1, karyawan.getNIP());
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.next()){
            return true;
        }

        return false;
    }
        
    
   public boolean cek_kehadiran(Hadir karyawan) throws SQLException {
        
        String cek = "SELECT * from tblkehadiran where idpegawai=? and tanggal=curdate()";
        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
        pst.setString(1, karyawan.getNIP());
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.next()){
            return false;
        }
        return true;

    }
   
   public boolean cek_jamMasuk(Hadir karyawan) throws SQLException {
        
        String cek = "SELECT  from tblpegawai where idpegawai=?";
        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
        pst.setString(1, karyawan.getNIP());
        ResultSet rs;
        rs = pst.executeQuery();
        
        if(rs.next()){
            return false;
        }
        return true;

    }
        
        
    public List<Hadir> ambil(Hadir karyawan) throws SQLException {
        
        String cek = " SELECT tblpegawai.idpegawai, tblpegawai.nama, tbljabatan.namajabatan, "
                + "tblpegawai.id_jam, tbljam.jam_kerja_mulai, tbljam.jam_kerja_selesai, tblpegawai.foto, "
                + "tbljam.jam_masuk_mulai, tbljam.jam_keluar_selesai "
                + "FROM tblpegawai, tbljabatan, tbljam WHERE tblpegawai.idpegawai = ? "
                + "and tbljam.id_jam = tblpegawai.id_jam and tblpegawai.jabatan = tbljabatan.idjabatan "
                + "group by idpegawai";
        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
        pst.setString(1, karyawan.getNIP());
        ResultSet rs;
        rs = pst.executeQuery();
        List<Hadir> list = new ArrayList<>();
        if(rs.next()){
            h.setNama(rs.getString("nama"));
            h.setFoto(rs.getString("foto"));
            h.setId_Jam(rs.getString("id_jam"));
            h.setJabatan(rs.getString("namajabatan"));
            h.setMasukStart(rs.getTime("jam_masuk_mulai"));
            h.setKerjaStart(rs.getTime("jam_kerja_mulai"));
            h.setKerjaEnd(rs.getTime("jam_kerja_selesai"));
            h.setKeluarEnd(rs.getTime("jam_keluar_selesai"));
            list.add(h);
        }        
        return list;
    }
    
    
    public void masuk(String nip) throws SQLException {
                   
        String hadir = "INSERT INTO tblkehadiran(idpegawai, tanggal, jmasuk, jkeluar, id_jam) VALUES( ?, CURDATE(), CURTIME(), ?, ?)";
        PreparedStatement pst = konek.getKoneksi().prepareStatement(hadir);
        pst.setString(1, nip);
        pst.setTime(2, h.getKeluarEnd());
        pst.setString(3, h.getId_Jam());
        pst.executeUpdate();     
        
    }
        
    public void keluar(String nip) throws SQLException {
        
        String cek = "UPDATE tblkehadiran SET jkeluar=CURTIME() WHERE idpegawai=? and tanggal=curdate()";
        PreparedStatement pst = konek.getKoneksi().prepareStatement(cek);
        pst.setString(1, nip);       
        pst.executeUpdate();       
        
    }
                            
    
}
