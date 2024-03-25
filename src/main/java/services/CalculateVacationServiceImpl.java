package services;

import models.VacationData;
import org.springframework.stereotype.Service;

@Service
public class CalculateVacationServiceImpl {

    public double vacationPayCalculator(VacationData vacationData) {
        double days =  (12 * 29.3);
       double dayCost = vacationData.getAverageSalary() * 12 / days;

        return dayCost * vacationData.getNumberOfVacationDays();
    }
}
