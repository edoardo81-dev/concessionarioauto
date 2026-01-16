package com.example.service;

import com.example.dto.VeicoloDTO;
import com.example.model.Automobile;
import com.example.model.Furgone;
import com.example.model.Motocicletta;
import com.example.repository.AutomobileRepository;
import com.example.repository.FurgoneRepository;
import com.example.repository.MotociclettaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

@Service
@RequiredArgsConstructor
public class VeicoloService {

	private final AutomobileRepository autoRepo;
	private final MotociclettaRepository motoRepo;
	private final FurgoneRepository furgRepo;

	/** Recupera tutti i veicoli */
	public List<Object> findAllVeicoli() {
		List<Object> lista = new ArrayList<>();
		lista.addAll(autoRepo.findAll());
		lista.addAll(motoRepo.findAll());
		lista.addAll(furgRepo.findAll());
		return lista;
	}

	/**
	 * Prezzo medio di tutti i veicoli (INTERO, arrotondato).
	 *
	 * UX: il valore viene poi formattato con separatore delle migliaia in pagina.
	 */
	public Integer prezzoMedio() {
		List<Object> tutti = findAllVeicoli();
		if (tutti.isEmpty())
			return 0;

		double somma = tutti.stream().mapToDouble(v -> {
			if (v instanceof Automobile)
				return ((Automobile) v).getPrezzo();
			else if (v instanceof Motocicletta)
				return ((Motocicletta) v).getPrezzo();
			else if (v instanceof Furgone)
				return ((Furgone) v).getPrezzo();
			else
				return 0;
		}).sum();
		double media = somma / tutti.size();
		return (int) Math.round(media);
	}

	/** Veicolo meno caro tra tutte le categorie (DTO) */
	public VeicoloDTO veicoloPiuEconomicoDTO() {
		List<Object> tutti = findAllVeicoli();
		if (tutti.isEmpty())
			return null;

		Object min = tutti.get(0);
		for (Object v : tutti) {
			int prezzoV = (v instanceof Automobile) ? ((Automobile) v).getPrezzo()
					: (v instanceof Motocicletta) ? ((Motocicletta) v).getPrezzo()
							: (v instanceof Furgone) ? ((Furgone) v).getPrezzo() : 0;

			int prezzoMin = (min instanceof Automobile) ? ((Automobile) min).getPrezzo()
					: (min instanceof Motocicletta) ? ((Motocicletta) min).getPrezzo()
							: (min instanceof Furgone) ? ((Furgone) min).getPrezzo() : 0;

			if (prezzoV < prezzoMin)
				min = v;
		}

		if (min instanceof Automobile a) {
			return new VeicoloDTO(a.getMarca(), a.getModello(), a.getPrezzo());
		} else if (min instanceof Motocicletta m) {
			return new VeicoloDTO(m.getMarca(), m.getModello(), m.getPrezzo());
		} else if (min instanceof Furgone f) {
			return new VeicoloDTO(f.getMarca(), f.getModello(), f.getPrezzo());
		}
		return null;
	}

	/**
	 * Metodo generico riusabile per trovare il più economico in una lista e
	 * mapparlo in DTO.
	 */
	private <T> VeicoloDTO piuEconomicoDTO(List<T> lista, ToIntFunction<T> prezzoExtractor,
			Function<T, String> marcaExtractor, Function<T, String> modelloExtractor) {
		return lista.stream().min(Comparator.comparingInt(prezzoExtractor))
				.map(v -> new VeicoloDTO(marcaExtractor.apply(v), modelloExtractor.apply(v), prezzoExtractor.applyAsInt(v)))
				.orElse(null);
	}

	/** Wrapper di categoria (usano il metodo generico) */
	public VeicoloDTO autoPiuEconomicaDTO() {
		return piuEconomicoDTO(autoRepo.findAll(), Automobile::getPrezzo, Automobile::getMarca, Automobile::getModello);
	}

	public VeicoloDTO motoPiuEconomicaDTO() {
		return piuEconomicoDTO(motoRepo.findAll(), Motocicletta::getPrezzo, Motocicletta::getMarca,
				Motocicletta::getModello);
	}

	public VeicoloDTO furgonePiuEconomicoDTO() {
		return piuEconomicoDTO(furgRepo.findAll(), Furgone::getPrezzo, Furgone::getMarca, Furgone::getModello);
	}

	/** Prezzo medio per marca (INTERO, arrotondato) */
	public Integer prezzoMedioPerMarca(String marca) {
		List<Object> tutti = findAllVeicoli();
		List<Integer> prezzi = new ArrayList<>();
		for (Object v : tutti) {
			if (v instanceof Automobile a && a.getMarca().equalsIgnoreCase(marca))
				prezzi.add(a.getPrezzo());
			else if (v instanceof Motocicletta m && m.getMarca().equalsIgnoreCase(marca))
				prezzi.add(m.getPrezzo());
			else if (v instanceof Furgone f && f.getMarca().equalsIgnoreCase(marca))
				prezzi.add(f.getPrezzo());
		}
		if (prezzi.isEmpty())
			return 0;
		double media = prezzi.stream().mapToInt(Integer::intValue).average().orElse(0);
		return (int) Math.round(media);
	}
}
