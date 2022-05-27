package com.demo.ssedemo.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.demo.ssedemo.service.SseService;

@Service
public class SseServiceImpl implements SseService {

	private final Map<Long, SseEmitter> emitterss = new HashMap<Long, SseEmitter>();

	@Override
	public boolean add(Long id, SseEmitter sseEmitter) {
		emitterss.put(id, sseEmitter);
		return true;
	}

	@Override
	public boolean remove(Long id, SseEmitter sseEmitter) {
		this.emitterss.remove(id);
		return true;
	}

	@Override
	public Map<Long, SseEmitter> getSsEmitters() {
		return this.emitterss;
	}

}
