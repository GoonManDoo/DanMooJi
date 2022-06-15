package com.yedam.myserver.city;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class modifyVO<T> {
	List<T> createdRows;
	List<T> updatedRows;
	List<T> deletedRows;
}
