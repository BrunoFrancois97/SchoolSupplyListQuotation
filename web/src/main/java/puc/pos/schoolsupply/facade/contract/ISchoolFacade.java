package puc.pos.schoolsupply.facade.contract;

import puc.pos.schoolsupply.model.dto.SchoolDto;

import java.util.List;

public interface ISchoolFacade {
    List<SchoolDto> findAll();
}
