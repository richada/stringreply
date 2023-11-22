package com.beta.replyservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ReplyController {
	
	private final ReplyService replyService;
	
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return new ReplyMessage(message);
	}
	
	@GetMapping("/v2/reply")
	public ReplyMessage replyingV2() {
		return new ReplyMessage("Message is empty");
	}
	
	@GetMapping("/v2/reply/{message}")
	public ReplyMessage replyingV2(@PathVariable String message) {
		return new ReplyMessage(replyService.parseMessageWithRules(message));
	}
}