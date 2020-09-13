package com.id.wasta.rest.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.id.nlp.bean.CardDetailsBean;
import com.id.nlp.service.NlpProcesssingService;
import com.id.nlp.service.OpticalCharacterRecognitionService;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.business.service.ContactScannerService;

@Controller
public class ContactScannerController {
	
	/*@Value("${camCard.userName}")
	private String userName;
	
	@Value("${camCard.apiKey}")
	private String apiKey;
	
	@Value("${camCard.url}")
	private String url;*/
	
	@Autowired
	private ContactScannerService contactScannerService;
	
	@Autowired
	private OpticalCharacterRecognitionService googleOpticalCharacterRecognitionService;
	
	@Autowired
	private NlpProcesssingService nlpProcesssingService;
	
	@RequestMapping(value = "/read-image-text-cc", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public JsonResponse startProcessCamCoder(@RequestParam(value="file") MultipartFile file) throws IllegalStateException, IOException {
        //writeFile(file);
        String lines =  googleOpticalCharacterRecognitionService.extractTextFromImage(file.getInputStream());
		CardDetailsBean cardDetailsBean = nlpProcesssingService.extractCardDetails(lines);
		/*CardDetailsBean cardDetailsBean = googleOpticalCharacterRecognitionService.extractTextAndEntityFromImage(userName, apiKey, url, file.getOriginalFilename(), file.getBytes());
        ObjectMapper mapper = new ObjectMapper();	
        JsonNode rootNode = mapper.readTree("{\"address\":[{\"item\":{\"postal_code\":\"-603103\",\"street\":\"#4, 1st Flr:, PVS Complex, OMR Kazhipattur, Chennai\",\"type\":[\"work\"]},\"position\":\"21,305,368,303,367,357,20,360\"}],\"comment\":[{\"item\":\"R m BAN '\",\"position\":\"79,523,350,521,349,577,79,579\"}],\"email\":[{\"item\":\"probanbuildint@gmail.com\",\"position\":\"48,230,363,227,362,253,48,256\"}],\"formatted_name\":[{\"item\":\"Sivanandham A\",\"position\":\"30,437,273,435,273,463,30,465\"}],\"label\":[{\"item\":{\"address\":\"#4, 1st Flr:, PVS Complex, OMR Kazhipattur, Chennai-603 103., -603103\",\"type\":[\"work\"]},\"position\":\"21,305,368,303,367,357,20,360\"}],\"name\":[{\"item\":{\"family_name\":\"A\",\"given_name\":\"Sivanandham\"},\"position\":\"0,0,0,0,0,0,0,0\"}],\"organization\":[{\"item\":{\"unit\":\"BE.M.I.E., F.I. V\"},\"position\":\"28,409,184,407,183,428,27,429\"},{\"item\":{\"name\":\"Orient Travels\"},\"position\":\"31,501,351,498,350,521,30,524\"}],\"rotation_angle\":\"0\",\"telephone\":[{\"item\":{\"number\":\"+919443160265\",\"type\":[\"cellular\",\"voice\"]},\"position\":\"60,261,256,260,256,282,60,284\"},{\"item\":{\"number\":\"9677038675\",\"type\":[\"cellular\",\"voice\"]},\"position\":\"272,260,423,258,423,281,272,282\"}],\"title\":[{\"item\":\"Proprietor\",\"position\":\"25,378,132,377,132,401,25,401\"}],\"url\":[{\"item\":\"Proban.in..\",\"position\":\"45,203,342,200,342,224,45,227\"}]}\r\n");
        CardDetailsBean cardDetailsBean = googleOpticalCharacterRecognitionService.mapJsonResponse(rootNode);*/
        if(cardDetailsBean!=null) {  
        	return new JsonResponse(cardDetailsBean,MessageTypeEnum.SUCCESS.getValue(),"image.scan","Success", true);
        }
        return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "image.scan", "invalid error", false);
    }
	
	@RequestMapping(value = "/chkScanDtls", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public JsonResponse validatecamCoder(@RequestBody CardDetailsBean cardDetailsBean) throws IllegalStateException, IOException {
		try {
			return new JsonResponse(contactScannerService.convertCardToCustomerBean(cardDetailsBean),MessageTypeEnum.SUCCESS.getValue(),"validate.scan","Success", true);
		} catch (Exception e) {
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(),"validate.scan","invalid error", false);
		}
    }
	
	
	public File writeFile(MultipartFile file) throws IOException{    
	    File convFile = new File(System.currentTimeMillis()+"_"+file.getOriginalFilename());
	    boolean fileCreated = convFile.createNewFile(); 
	    if(fileCreated) {
	    	try(FileOutputStream fos = new FileOutputStream(convFile)){
	    		fos.write(file.getBytes());
	    	}
	    }
	    return convFile;
	}
}
