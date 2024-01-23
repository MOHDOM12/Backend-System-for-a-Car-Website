package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
@AutoConfigureJsonTesters
public class PricingServiceApplicationTests {


	@Test
	public void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Mock
	PricingService pricingService;

	@Autowired
	private JacksonTester<Price> json;

	@Test
	public void getPrice() throws Exception {
		Price p = new Price();
		mockMvc.perform(get("/services/price?vehicleId=1"))
				.andExpect(status().isOk());



		verify(pricingService, times(1)).getPrice(1L);
	}

}
