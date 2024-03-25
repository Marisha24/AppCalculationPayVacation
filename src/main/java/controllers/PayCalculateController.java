package controllers;

import models.VacationData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.CalculateVacationServiceImpl;

@Controller
public class PayCalculateController {
    final CalculateVacationServiceImpl vacantionService;

    public PayCalculateController(CalculateVacationServiceImpl vacantionService) {
        this.vacantionService = vacantionService;
    }

    @GetMapping("/calculacte")
    public double calculate(
            @RequestParam Integer yearSalary,
            @RequestParam Integer vacationDays
    ){
        VacationData vacationPay = new  VacationData(yearSalary, vacationDays);

        return vacantionService.vacationPayCalculator(vacationPay);
    }
}
