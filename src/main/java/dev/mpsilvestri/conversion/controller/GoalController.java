package dev.mpsilvestri.conversion.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoalController {

	public final String apiKey = "1l52wORZAYlpRzWxll8D";
	public int statusCode;
	public String responseBody;
	public Model model;
	    
    public void convert_goal(String payload, Model model, String guid, String value) {
    	
    	HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_2)
                .build();

        try {
        	
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI("https://api3.esv2.com/v2/Api/Goals"))
                    .version(Version.HTTP_2)
                    .POST(BodyPublishers.ofString(payload))
                    .build();

            HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            this.statusCode = httpResponse.statusCode();
            this.responseBody = httpResponse.body();

            System.out.println("Status code: " + this.statusCode);
            System.out.println("Response: " + this.responseBody);
            
            model.addAttribute("statusCode", statusCode);
            model.addAttribute("responseBody", responseBody);
            model.addAttribute("value", value);
            model.addAttribute("guid", guid);

        } catch (IOException | InterruptedException | URISyntaxException e) {
            
            System.out.println("Error: " + e.getMessage());
            model.addAttribute("error", e.getMessage());
        }
      	
    }
	
	@GetMapping("/convert3000")
    public String convert3000(@RequestParam("guid") String guid, Model model) {

        final String value = "3000"; 
		
		String payload = "<ApiRequest xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                + "xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\r\n"
                + "  <ApiKey>" + this.apiKey + "</ApiKey>\r\n"
                + "  <Data>\r\n"
                + "    <GoalId>34</GoalId>\r\n"
                + "    <GoalValue>"+ value +"</GoalValue>\r\n"
                + "    <MessageGuid>" + guid + "</MessageGuid>\r\n"
                + "  </Data>\r\n"
                + "</ApiRequest>";

        convert_goal(payload, model, guid, value);

        return "result";

    }
    
    @GetMapping("/convert4000")
    public String convert4000(@RequestParam("guid") String guid, Model model) {

    	final String value = "4000"; 
    	
    	String payload = "<ApiRequest xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                + "xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\r\n"
                + "  <ApiKey>" + this.apiKey + "</ApiKey>\r\n"
                + "  <Data>\r\n"
                + "    <GoalId>34</GoalId>\r\n"
                + "    <GoalValue>"+ value +"</GoalValue>\r\n"
                + "    <MessageGuid>" + guid + "</MessageGuid>\r\n"
                + "  </Data>\r\n"
                + "</ApiRequest>";

        convert_goal(payload, model, guid, value);

        return "result";
    }
    
    @GetMapping("/convert5000")
    public String convert5000(@RequestParam("guid") String guid, Model model) {

    	final String value = "5000"; 
    	
    	String payload = "<ApiRequest xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                + "xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\r\n"
                + "  <ApiKey>" + this.apiKey + "</ApiKey>\r\n"
                + "  <Data>\r\n"
                + "    <GoalId>34</GoalId>\r\n"
                + "    <GoalValue>"+ value +"</GoalValue>\r\n"
                + "    <MessageGuid>" + guid + "</MessageGuid>\r\n"
                + "  </Data>\r\n"
                + "</ApiRequest>";

        convert_goal(payload, model, guid, value);

        return "result";
        
    }
    
}
