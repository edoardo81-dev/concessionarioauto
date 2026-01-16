package com.example.config;

import com.example.model.Automobile;
import com.example.model.Motocicletta;
import com.example.model.Furgone;
import com.example.repository.AutomobileRepository;
import com.example.repository.MotociclettaRepository;
import com.example.repository.FurgoneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AutomobileRepository autoRepo;
    private final MotociclettaRepository motoRepo;
    private final FurgoneRepository furgRepo;

    public DataInitializer(AutomobileRepository autoRepo,
                           MotociclettaRepository motoRepo,
                           FurgoneRepository furgRepo) {
        this.autoRepo = autoRepo;
        this.motoRepo = motoRepo;
        this.furgRepo = furgRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        // Se c'è già almeno un veicolo, non tocchiamo il DB
        if (autoRepo.count() > 0 || motoRepo.count() > 0 || furgRepo.count() > 0) {
            System.out.println("DataInitializer: dati già presenti, nessun inserimento di default.");
            return;
        }

        System.out.println("DataInitializer: popolamento iniziale di auto, moto e furgoni...");

        // ---------- AUTOMOBILI ----------
        Automobile a1 = new Automobile();
        a1.setModello("Panda");
        a1.setMarca("Fiat");
        a1.setCodiceImmatricolazione("IM-0001");
        a1.setDataImmatricolazione(LocalDate.of(2018, 5, 20));
        a1.setPrezzo(8000);
        a1.setPorte(3);              // Panda: 3 porte
        a1.setElettrica(true);       // Panda: elettrica
        autoRepo.save(a1);

        Automobile a2 = new Automobile();
        a2.setModello("A3");
        a2.setMarca("Audi");
        a2.setCodiceImmatricolazione("IM-0002");
        a2.setDataImmatricolazione(LocalDate.of(2020, 3, 10));
        a2.setPrezzo(22000);
        a2.setPorte(5);
        a2.setElettrica(false);
        autoRepo.save(a2);

        Automobile a3 = new Automobile();
        a3.setModello("Mustang");
        a3.setMarca("Ford");
        a3.setCodiceImmatricolazione("IM-0003");
        a3.setDataImmatricolazione(LocalDate.of(2023, 2, 6));
        a3.setPrezzo(38000);
        a3.setPorte(5);
        a3.setElettrica(false);
        autoRepo.save(a3);

        Automobile a4 = new Automobile();
        a4.setModello("Diablo");
        a4.setMarca("Lamborghini");
        a4.setCodiceImmatricolazione("IM-0004");
        a4.setDataImmatricolazione(LocalDate.of(2021, 3, 22));
        a4.setPrezzo(95000);
        a4.setPorte(3);              // Diablo: 3 porte
        a4.setElettrica(false);
        autoRepo.save(a4);

        Automobile a5 = new Automobile();
        a5.setModello("Clio");
        a5.setMarca("Renault");
        a5.setCodiceImmatricolazione("IM-0005");
        a5.setDataImmatricolazione(LocalDate.of(2019, 9, 12));
        a5.setPrezzo(11500);
        a5.setPorte(5);
        a5.setElettrica(false);
        autoRepo.save(a5);

        Automobile a6 = new Automobile();
        a6.setModello("155 V6 TI");
        a6.setMarca("Alfa Romeo");
        a6.setCodiceImmatricolazione("IM-0006");
        a6.setDataImmatricolazione(LocalDate.of(1994, 6, 15));
        a6.setPrezzo(55000);
        a6.setPorte(5);              // portiamo a 5
        a6.setElettrica(false);
        autoRepo.save(a6);

        // ---------- MOTOCICLETTE ----------
        Motocicletta m1 = new Motocicletta();
        m1.setModello("Ninja");
        m1.setMarca("Kawasaki");
        m1.setCodiceImmatricolazione("IM-M001");
        m1.setDataImmatricolazione(LocalDate.of(2019, 7, 1));
        m1.setPrezzo(9000);
        m1.setCilindrata(650);
        m1.setSidecar(false);
        motoRepo.save(m1);

        Motocicletta m2 = new Motocicletta();
        m2.setModello("Duke");
        m2.setMarca("KTM");
        m2.setCodiceImmatricolazione("IM-M002");
        m2.setDataImmatricolazione(LocalDate.of(2021, 2, 15));
        m2.setPrezzo(7000);
        m2.setCilindrata(390);
        m2.setSidecar(false);
        motoRepo.save(m2);

        Motocicletta m3 = new Motocicletta();
        m3.setModello("CBR 900");
        m3.setMarca("Honda");
        m3.setCodiceImmatricolazione("IM-M003");
        m3.setDataImmatricolazione(LocalDate.of(2004, 4, 20));
        m3.setPrezzo(8500);
        m3.setCilindrata(893);
        m3.setSidecar(false);
        motoRepo.save(m3);

        // ---------- FURGONI ----------
        Furgone f1 = new Furgone();
        f1.setModello("Transit");
        f1.setMarca("Ford");
        f1.setCodiceImmatricolazione("IM-F001");
        f1.setDataImmatricolazione(LocalDate.of(2017, 11, 3));
        f1.setPrezzo(18000);
        f1.setCapacitaCarico(1200.0);
        f1.setRefrigerato(false);
        furgRepo.save(f1);

        Furgone f2 = new Furgone();
        f2.setModello("Sprinter");
        f2.setMarca("Mercedes");
        f2.setCodiceImmatricolazione("IM-F002");
        f2.setDataImmatricolazione(LocalDate.of(2022, 1, 5));
        f2.setPrezzo(35000);
        f2.setCapacitaCarico(1800.0);
        f2.setRefrigerato(true);
        furgRepo.save(f2);

        Furgone f3 = new Furgone();
        f3.setModello("Daily");
        f3.setMarca("Iveco");
        f3.setCodiceImmatricolazione("IM-F003");
        f3.setDataImmatricolazione(LocalDate.of(2020, 10, 8));
        f3.setPrezzo(28000);
        f3.setCapacitaCarico(2000.0);
        f3.setRefrigerato(false);
        furgRepo.save(f3);

        System.out.println("DataInitializer: database popolato con auto, moto e furgoni!");
    }
}
