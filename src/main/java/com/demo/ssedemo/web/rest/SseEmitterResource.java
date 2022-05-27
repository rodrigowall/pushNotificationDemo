package com.demo.ssedemo.web.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.demo.ssedemo.serviceimpl.SseServiceImpl;

@RestController
@RequestMapping("/api/")
public class SseEmitterResource {

	@Autowired
	private SseServiceImpl sseService;

	@GetMapping("subscription/{id}")
	public SseEmitter subscribe(@PathVariable Long id) throws IOException {
		SseEmitter emitter = new SseEmitter(((long) (60000 * 5)));

		sseService.add(id, emitter);
		emitter.onCompletion(() -> sseService.remove(id, emitter));

		return emitter;
	}

	@GetMapping("producer/test/{id}/{data}")
	public String produce(@PathVariable String data, @PathVariable Long id) {
		sseService.getSsEmitters().forEach((k, emitter) -> {
			if (k.equals(id)) {
				try {
					emitter.send(data, MediaType.APPLICATION_JSON);
				} catch (IOException e) {
					emitter.complete();
					sseService.remove(k, emitter);
					e.printStackTrace();
				}
			}
		});

		return data;
	}
}
