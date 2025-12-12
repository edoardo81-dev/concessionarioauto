package com.example.service;

import com.example.model.Motocicletta;
import com.example.repository.MotociclettaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotociclettaService {

	private final MotociclettaRepository motociclettaRepository;

	public List<Motocicletta> getAllMotociclette() {
		return motociclettaRepository.findAll();
	}
}
