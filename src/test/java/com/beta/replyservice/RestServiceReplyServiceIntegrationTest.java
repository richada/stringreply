package com.beta.replyservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestServiceReplyServiceIntegrationTest {

	@Autowired
	private ReplyService replyService;
	
	@Test
	public void testV2ImptGivenMsgWithRules12() throws Exception{
		String output = replyService.parseMessageWithRules("12-kbzw9ru");
		assertEquals("5a8973b3b1fafaeaadf10e195c6e1dd4", output);
	}
	
	@Test
	public void testV2ImptGivenMsgWithRules22() throws Exception{
		String output = replyService.parseMessageWithRules("22-kbzw9ru");
		assertEquals("e8501e64cf0a9fa45e3c25aa9e77ffd5", output);
	}
	
	@Test
	public void testV2ImptHelloWorldMsgWithoutRules() throws Exception{
		String output = replyService.parseMessageWithRules("helloWorld");
		assertEquals("helloWorld", output);
	}
	
	@Test
	public void testV2ImptHelloWorldMsgWithRules11() throws Exception{
		String output = replyService.parseMessageWithRules("11-helloWorld");
		assertEquals("helloWorld",output);
	}
	
	@Test
	public void testV2ImptHelloWorldMsgWithRules12() throws Exception{
		String output = replyService.parseMessageWithRules("12-helloWorld");
		assertEquals("4fa0a111415b55dfa7be99a89365b119",output);
	}
	
	@Test
	public void testV2ImptHelloWorldMsgWithRules21() throws Exception{
		String output = replyService.parseMessageWithRules("21-helloWorld");
		assertEquals("1e20660d60ead89002e7b6a36ad338a1",output);
	}
	
	@Test
	public void testV2ImptHelloWorldMsgWithRules22() throws Exception{
		String output = replyService.parseMessageWithRules("22-helloWorld");
		assertEquals("c74d19a2f88924a1aeb9f55754696eaa",output);
	}

}
