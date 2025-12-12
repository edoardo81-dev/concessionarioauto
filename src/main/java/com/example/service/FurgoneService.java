package com.example.service;

import com.example.model.Furgone;
import com.example.repository.FurgoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FurgoneService {

    private final FurgoneRepository furgoneRepository;

    public List<Furgone> getAllFurgoni() {
        return furgoneRepository.findAll();
    }
}
