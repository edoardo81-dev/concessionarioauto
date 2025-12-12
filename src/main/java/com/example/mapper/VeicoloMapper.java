package com.example.mapper;


import com.example.model.Automobile;
import com.example.model.Motocicletta;
import com.example.model.Furgone;
import com.example.dto.AutomobileDTO;
import com.example.dto.MotociclettaDTO;
import com.example.dto.FurgoneDTO;

public class VeicoloMapper {

    /* -------- Automobile -------- */
    public static AutomobileDTO toDto(Automobile auto) {
        if (auto == null) return null;

        AutomobileDTO dto = new AutomobileDTO();
        dto.setId(auto.getId());
        dto.setModello(auto.getModello());
        dto.setMarca(auto.getMarca());
        dto.setCodiceImmatricolazione(auto.getCodiceImmatricolazione());
        dto.setDataImmatricolazione(auto.getDataImmatricolazione());
        dto.setPrezzo(auto.getPrezzo());

        // campi specifici
        dto.setPorte(auto.getPorte());
        dto.setElettrica(auto.isElettrica());

        return dto;
    }

    public static Automobile toEntity(AutomobileDTO dto) {
        if (dto == null) return null;

        Automobile auto = new Automobile();
        auto.setId(dto.getId());
        auto.setModello(dto.getModello());
        auto.setMarca(dto.getMarca());
        auto.setCodiceImmatricolazione(dto.getCodiceImmatricolazione());
        auto.setDataImmatricolazione(dto.getDataImmatricolazione());
        auto.setPrezzo(dto.getPrezzo());

        auto.setPorte(dto.getPorte());
        auto.setElettrica(dto.isElettrica());

        return auto;
    }

    /* -------- Motocicletta -------- */
    public static MotociclettaDTO toDto(Motocicletta moto) {
        if (moto == null) return null;

        MotociclettaDTO dto = new MotociclettaDTO();
        dto.setId(moto.getId());
        dto.setModello(moto.getModello());
        dto.setMarca(moto.getMarca());
        dto.setCodiceImmatricolazione(moto.getCodiceImmatricolazione());
        dto.setDataImmatricolazione(moto.getDataImmatricolazione());
        dto.setPrezzo(moto.getPrezzo());

        // campi specifici
        dto.setCilindrata(moto.getCilindrata());
        dto.setSidecar(moto.isSidecar());

        return dto;
    }

    public static Motocicletta toEntity(MotociclettaDTO dto) {
        if (dto == null) return null;

        Motocicletta moto = new Motocicletta();
        moto.setId(dto.getId());
        moto.setModello(dto.getModello());
        moto.setMarca(dto.getMarca());
        moto.setCodiceImmatricolazione(dto.getCodiceImmatricolazione());
        moto.setDataImmatricolazione(dto.getDataImmatricolazione());
        moto.setPrezzo(dto.getPrezzo());

        moto.setCilindrata(dto.getCilindrata());
        moto.setSidecar(dto.isSidecar());

        return moto;
    }

    /* -------- Furgone -------- */
    public static FurgoneDTO toDto(Furgone furgone) {
        if (furgone == null) return null;

        FurgoneDTO dto = new FurgoneDTO();
        dto.setId(furgone.getId());
        dto.setModello(furgone.getModello());
        dto.setMarca(furgone.getMarca());
        dto.setCodiceImmatricolazione(furgone.getCodiceImmatricolazione());
        dto.setDataImmatricolazione(furgone.getDataImmatricolazione());
        dto.setPrezzo(furgone.getPrezzo());

        // campi specifici
        dto.setCapacitaCarico(furgone.getCapacitaCarico());
        dto.setRefrigerato(furgone.isRefrigerato());

        return dto;
    }

    public static Furgone toEntity(FurgoneDTO dto) {
        if (dto == null) return null;

        Furgone furgone = new Furgone();
        furgone.setId(dto.getId());
        furgone.setModello(dto.getModello());
        furgone.setMarca(dto.getMarca());
        furgone.setCodiceImmatricolazione(dto.getCodiceImmatricolazione());
        furgone.setDataImmatricolazione(dto.getDataImmatricolazione());
        furgone.setPrezzo(dto.getPrezzo());

        furgone.setCapacitaCarico(dto.getCapacitaCarico());
        furgone.setRefrigerato(dto.isRefrigerato());

        return furgone;
    }
}
