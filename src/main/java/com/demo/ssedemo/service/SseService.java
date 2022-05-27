package com.demo.ssedemo.service;

import java.util.Map;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface SseService {

	Map<Long, SseEmitter> getSsEmitters();

	boolean add(Long id, SseEmitter sseEmitter);

	boolean remove(Long id, SseEmitter sseEmitter);

}
