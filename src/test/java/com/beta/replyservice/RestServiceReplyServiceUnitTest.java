package com.beta.replyservice;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ReplyController.class)
public class RestServiceReplyServiceUnitTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ReplyService replyService;
	
	@Test
	public void testV1ImptEmptyMsg() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/reply"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Message is empty")));
	}
	
	@Test
	public void testV1ImptHelloWorldMsg() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/reply/helloWorld"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("helloWorld")));
	}
	
	@Test
	public void testV2ImptEmptyMsg() throws Exception{
		Mockito.when(replyService.parseMessageWithRules("")).thenReturn("Message is empty");
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/reply"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Message is empty")));
	}
	
	@Test
	public void testV2ImptHelloWorldMsgWithoutRules() throws Exception{
		Mockito.when(replyService.parseMessageWithRules("helloWorld")).thenReturn("helloWorld");
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/reply/helloWorld"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("helloWorld")));
	}
	
	@Test
	public void testV2ImptHelloWorldMsgWithRules11() throws Exception{
		Mockito.when(replyService.parseMessageWithRules("11-helloWorld")).thenReturn("helloWorld");
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/reply/11-helloWorld"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("helloWorld")));
	}
	
	@Test
	public void testV2ImptHelloWorldMsgWithRules12() throws Exception{
		Mockito.when(replyService.parseMessageWithRules("12-helloWorld")).thenReturn("4fa0a111415b55dfa7be99a89365b119");
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/reply/12-helloWorld"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("4fa0a111415b55dfa7be99a89365b119")));
	}
	
	@Test
	public void testV2ImptHelloWorldMsgWithRules21() throws Exception{
		Mockito.when(replyService.parseMessageWithRules("21-helloWorld")).thenReturn("1e20660d60ead89002e7b6a36ad338a1");
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/reply/21-helloWorld"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("1e20660d60ead89002e7b6a36ad338a1")));
	}
	
	@Test
	public void testV2ImptHelloWorldMsgWithRules22() throws Exception{
		Mockito.when(replyService.parseMessageWithRules("22-helloWorld")).thenReturn("c74d19a2f88924a1aeb9f55754696eaa");
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/reply/22-helloWorld"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("c74d19a2f88924a1aeb9f55754696eaa")));
	}

}
