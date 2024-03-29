package pt.org.upskill.repository;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.domain.VaccineTech;
import pt.org.upskill.domain.VaccineType;

import java.util.ArrayList;
import java.util.List;

import static pt.org.upskill.ui.utils.Utils.readIntegerFromConsole;

public class VaccineTypeRepository implements Persistable {

    private List<VaccineType> vaccineTypeList = new ArrayList<VaccineType>();

    public VaccineType createVaccineType(String code, String shortDescription, VaccineTech vaccineTech) {
        return new VaccineType(code, shortDescription, vaccineTech);
    }

    @Override
    public boolean save(Object object) {
        vaccineTypeList.add((VaccineType) object);
        return true;
    }

    @Override
    public boolean delete(Object object) {
        vaccineTypeList.remove(object);
        return true;
    }

    public List<VaccineType> vaccineTypeList() {
        return vaccineTypeList;
    }

    public VaccineType getByCode(String code) {
        for (VaccineType vaccineType : vaccineTypeList) {
            if (vaccineType.code().equals(code)) {
                return vaccineType;
            }
        }
        return null;
    }
}
