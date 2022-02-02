package com.task.dto;

import java.io.Serializable;

import com.poiji.annotation.ExcelCellName;
import com.task.entity.Permission;

import lombok.Data;

@Data
public class DataImportDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ExcelCellName("Authority")
	private String authority;

	@ExcelCellName("Authority Name")
	private String authorityName;
	
	public Permission toImportData() {
		Permission permission = new Permission();
		permission.setAuthority(authority);
		permission.setAuthorityName(authorityName);
		return permission;
	}

}
