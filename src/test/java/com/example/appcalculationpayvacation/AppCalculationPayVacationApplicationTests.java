package com.example.appcalculationpayvacation;

import controllers.PayCalculateController;
import models.VacationData;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import services.CalculateVacationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AppCalculationPayVacationApplicationTests {

	@Test
	void contextLoads() {

	}
	@Test
	public void testVacationPayCalculator() {
		CalculateVacationServiceImpl calculator = new CalculateVacationServiceImpl();
		VacationData testData = new VacationData(50000, 20); // Пример данных для тестирования
		double expectedPay = 50000 * 12 / (12 * 29.3) * 20; // Ожидаемая оплата отпускных

		assertEquals(expectedPay, calculator.vacationPayCalculator(testData));
	}

	@Mock
	private CalculateVacationServiceImpl vacationService;

	@Test
	public void testCalculate() {
		PayCalculateController controller = new PayCalculateController(vacationService);
		VacationData testData = new VacationData(50000, 20); // Example test data
		double expectedPay = 10000.0; // Expected pay for the given test data

		when(vacationService.vacationPayCalculator(testData)).thenReturn(expectedPay);

		double actualPay = controller.calculate(50000, 20);

		assertEquals(expectedPay, actualPay);
	}
}
