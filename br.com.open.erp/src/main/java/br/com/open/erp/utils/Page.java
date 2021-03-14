package br.com.open.erp.utils;

import lombok.NoArgsConstructor;

import java.util.List;

import lombok.AllArgsConstructor;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {

	private List<T> contents;
	private Long totalElements;
	private Long totalPages; 
	
}
