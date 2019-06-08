/**
 * 
 */
package com.raj.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import com.raj.kafka.constants.IKafkaConstant;
import com.raj.kafka.model.Employee;

/**
 * @author Rajendar
 *
 */
public class KafkaMsgConsumer implements Runnable{

	private Consumer<String, Employee> kfkaConsumer;
	public KafkaMsgConsumer(Consumer<String, Employee> kfkaConsumer) {
		this.kfkaConsumer = kfkaConsumer;
	}
	@Override
	public void run() {
		int noMessageFound = 0;
		while(true) {
			@SuppressWarnings("deprecation")
			ConsumerRecords<String, Employee> consumerRecords = kfkaConsumer.poll(1000);
			
	          // 1000 is the time in milliseconds consumer will wait if no record is found at broker.
	          if (consumerRecords.count() == 0) {
	              noMessageFound++;
	              if (noMessageFound > IKafkaConstant.IConsumer.MAX_NO_MESSAGE_FOUND_COUNT)
	                // If no message found count is reached to threshold exit loop.  
	                break;
	              else
	                  continue;
	          }
	          //print each record. 
	          consumerRecords.forEach(record -> {
	              System.out.println("Record Key " + record.key());
	              System.out.println("Record value " + record.value());
	              System.out.println("Record partition " + record.partition());
	              System.out.println("Record offset " + record.offset());
	           });
	          // commits the offset of record to broker. 
	          kfkaConsumer.commitAsync();
	        
		}
	        kfkaConsumer.close();
	}


}
