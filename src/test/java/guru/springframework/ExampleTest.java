package guru.springframework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
//import com.id.retail.IdPosOrderHeader;
import com.id.util.CommonConstants;
//import com.mz.edcportal.bean.MzUser;
public class ExampleTest {


	
	

	  

	public static void main(String[] args) throws JsonProcessingException, ClassNotFoundException{
	
		Class clazz = 	Class.forName("com.id.retail.IdPosOrderHeader");
		 ObjectMapper mapper = new ObjectMapper();
		    //There are other configuration options you can set.  This is the one I needed.
		    mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);

		    JsonSchema schema = mapper.generateJsonSchema(clazz);

		    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema));
		
	}
}
