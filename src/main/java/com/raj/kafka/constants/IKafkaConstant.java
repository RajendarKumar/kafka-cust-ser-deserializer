package com.raj.kafka.constants;

public interface IKafkaConstant {

	public interface IProducer {

		Integer MESSAGE_COUNT = 1000;
		String TOPIC_NAME = "newtest";

	}
	
	public interface IConsumer {

		String TOPIC_NAME = "newtest";
		Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;

	}
}
