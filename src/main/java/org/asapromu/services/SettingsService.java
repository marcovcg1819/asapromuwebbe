package org.asapromu.services;

import org.asapromu.entities.Settings;
import org.asapromu.repositories.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {
	@Autowired
	private SettingsRepository settingsRepository;
	
	public Settings save(Settings s) {
		return settingsRepository.save(s);
	}
	
	public Settings getByNamesetting(String name) {
		return settingsRepository.findByNamesetting(name).get();
	}

}
