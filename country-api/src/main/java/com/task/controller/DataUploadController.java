package com.task.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.poiji.option.PoijiOptions;
import com.task.dto.DataImportDto;
import com.task.entity.Permission;
import com.task.service.DataImportService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "data-upload")
@Api(tags = "Permission Data Upload")
@RequiredArgsConstructor
public class DataUploadController {

	private final DataImportService service;

	@PostMapping("/upload")
	//@PreAuthorize("hasAuthority('SAVE_DATA')")
	public ResponseEntity<?> save(@RequestPart("file") MultipartFile file) throws IOException {

		String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

		List<DataImportDto> items = Poiji.fromExcel(file.getInputStream(),
				PoijiExcelType.valueOf(extension.toUpperCase()), DataImportDto.class,
				PoijiOptions.PoijiOptionsBuilder.settings().preferNullOverDefault(true).build());

		List<Permission> permissions = items.stream().map(DataImportDto::toImportData).collect(Collectors.toList());

		service.saveAll(permissions);
		return ResponseEntity.ok("Uploaded");
	}

}
