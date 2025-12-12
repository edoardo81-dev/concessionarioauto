package com.example.service;

import com.example.model.Automobile;
import com.example.repository.AutomobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomobileService {

	@Autowired
	private AutomobileRepository automobileRepository;

	public List<Automobile> findAll() {
		return automobileRepository.findAll();
	}
}