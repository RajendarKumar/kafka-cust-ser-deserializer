/**
 * 
 */
package com.raj.kafka.serialization;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;

import org.apache.kafka.common.serialization.Serializer;

import com.raj.kafka.exception.SerialazationException;
import com.raj.kafka.model.Employee;

/**
 * @author Rajendar
 *
 */
public class EmployeeSerializer implements Serializer<Employee> {

	private String encoding = "UTF8";
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

		if(Objects.nonNull(configs)) {
			String propName = isKey ?"key.serializer.encoding" : "value.serializer.encoding";
			Object encodingValue = configs.get(propName);
			if (encodingValue == null)
				encodingValue = configs.get("serializer.encoding");
			if (encodingValue instanceof String)
				encoding = (String) encodingValue;
		}

	}

	@Override
	public byte[] serialize(String topic, Employee data) {
		if (Objects.isNull(data))
			return null;
		try {
			byte nameByte[] = data.getName().getBytes(encoding);
			byte dobByte[] = data.getDob().toString().getBytes(encoding);
			/**
			 *4 : int id, 
			 *4 : int nameLenght value, 
			 *name.length :  nameLenght,
			 *4 : int dobLenght value, 
			 *dob.length : dobLength
			 * 
			 */
			ByteBuffer buffer = ByteBuffer.allocate(4+4+nameByte.length+4+dobByte.length);
			buffer.putInt(data.getEmpNo());
			buffer.putInt(nameByte.length);
			buffer.put(nameByte);
			buffer.putInt(dobByte.length);
			buffer.put(dobByte);
			return buffer.array();
		} catch (UnsupportedEncodingException e) {
			throw new SerialazationException(e);
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
