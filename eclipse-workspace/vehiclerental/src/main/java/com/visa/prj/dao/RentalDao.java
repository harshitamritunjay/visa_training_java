package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.dto.RentalReportDTO;
import com.visa.prj.entity.Rental;

public interface RentalDao {

	void addRental(Rental rental);
	List<RentalReportDTO> getReport();
}
