package com.springboot.riot

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc

@WebAppConfiguration
@SpringBootTest
class RiotApplicationTests {
	
	lateinit var mockMvc: MockMvc
	
}
