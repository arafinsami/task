package com.task.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.task.entity.Permission;
import com.task.repository.PermissionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataImportService {

	private final PermissionRepository repository;

	@Transactional
	public void saveAll(List<Permission> permissions) {
		repository.saveAll(permissions);
	}

}
