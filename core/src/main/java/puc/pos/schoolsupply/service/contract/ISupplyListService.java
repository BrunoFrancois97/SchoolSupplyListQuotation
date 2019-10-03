package puc.pos.schoolsupply.service.contract;

import java.util.List;
import java.util.Map;

public interface ISupplyListService {

    Map<String, List<String>> getSchoolsAndLevels();

}
