package in.ashokit.service;

import java.util.List;

import org.springframework.data.domain.Example;

import in.ashokit.dto.ViewEnqFilterRequest;
import in.ashokit.entities.Counsellor;
import in.ashokit.entities.Enquiry;
import in.ashokit.repos.CounsellorRepo;
import in.ashokit.repos.EnquiryRepo;
import io.micrometer.common.util.StringUtils;

public class EnquiryServiceImpl implements EnquiryService {

	private EnquiryRepo enqRepo;

	private CounsellorRepo counsellorRepo;

	public EnquiryServiceImpl(EnquiryRepo enqRepo, CounsellorRepo counsellorRepo) {

		this.enqRepo = enqRepo;
		this.counsellorRepo = counsellorRepo;
	}

	@Override
	public boolean addEnqiry(Enquiry enq, Integer counsellorId) throws Exception {

		Counsellor counsellor = counsellorRepo.findById(counsellorId).orElse(null);

		if (counsellor == null) {
			throw new Exception("No counsellor found");
		}

		// associating counsellor to enquiry
		enq.setCounsellor(counsellor);
		Enquiry save = enqRepo.save(enq);

		if (save.getEnqId() != null) {
			return true;
		}

		return false;
	}

	@Override
	public List<Enquiry> getAllEnquiries(Integer counsellorId) {

		return enqRepo.getEnquiresByCounsellorId(counsellorId);

	}

	@Override
	public Enquiry getEnquiryById(Integer enqId) {
		return enqRepo.findById(enqId).orElse(null);
	}

	@Override
	public List<Enquiry> getEnquiresWithFilter(ViewEnqFilterRequest filterReq, Integer counsellorId) {

		// QBE implements (Dynamic Query preparation)

		Enquiry enq = new Enquiry();//

		if (StringUtils.isNotEmpty(filterReq.getClassMode())) {
			enq.setClassMode(filterReq.getClassMode());

		}

		if (StringUtils.isNotEmpty(filterReq.getCourseName())) {

			enq.setCourseName(filterReq.getCourseName());
		}

		if (StringUtils.isNotEmpty(filterReq.getEnqStatus())) {
			enq.setEnqStatus(filterReq.getEnqStatus());

		}

		Counsellor c = counsellorRepo.findById(counsellorId).orElse(null);

		enq.setCounsellor(c);

		Example<Enquiry> of = Example.of(enq);

		List<Enquiry> enqList = enqRepo.findAll(of);

		return enqList;
	}

}
