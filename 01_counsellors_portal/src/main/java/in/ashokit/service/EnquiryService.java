package in.ashokit.service;

import java.util.List;

import in.ashokit.dto.ViewEnqFilterRequest;
import in.ashokit.entities.Enquiry;

public interface EnquiryService {
	
	public boolean addEnqiry(Enquiry enq, Integer counsellorId) throws Exception;
	
	public List<Enquiry> getAllEnquiries(Integer counsellorId);
	
	public List<Enquiry> getEnquiresWithFilter(ViewEnqFilterRequest filterReq,
			Integer counsellorId);
	
	public Enquiry getEnquiryById(Integer enqId);
	
	
	

}
