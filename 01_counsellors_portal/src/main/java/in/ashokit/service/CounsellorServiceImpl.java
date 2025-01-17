package in.ashokit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dto.DashboardResponse;
import in.ashokit.entities.Counsellor;
import in.ashokit.entities.Enquiry;
import in.ashokit.repos.CounsellorRepo;
import in.ashokit.repos.EnquiryRepo;

@Service
public class CounsellorServiceImpl implements CounsellorService {

	private CounsellorRepo counsellorRepo;

	private EnquiryRepo enqRepo;
	
	public CounsellorServiceImpl(CounsellorRepo counsellorRepo,EnquiryRepo enqRepo) {
		this.counsellorRepo = counsellorRepo;
		this.enqRepo = enqRepo;
		
	}
	
	@Override
	public Counsellor findByEmail(String email) {
		
		return counsellorRepo.findByEmail(email);
	}

	@Override
	public boolean register(Counsellor counsellor) {
		Counsellor savedCounsellor = counsellorRepo.save(counsellor);
		if (null != savedCounsellor.getCounsellorId()) {
			return true;
		}

		return false;
	}

	@Override
	public Counsellor login(String email, String pwd) {
		Counsellor counsellor = counsellorRepo.findByEmailAndPwd(email, pwd);

		return counsellor;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer counsellorId) {

		DashboardResponse reponse = new DashboardResponse();

		List<Enquiry> enqList = enqRepo.getEnquiresByCounsellorId(counsellorId);
		
		int totalEnq = enqList.size();
		int enrolledEnqs = enqList.stream()
				.filter(e -> e.getEnqStatus().equals("Enrolled"))
				.collect(Collectors.toList())
				.size();
		
		int LostEnqs = enqList.stream()
				.filter(e -> e.getEnqStatus().equals("Lost"))
				.collect(Collectors.toList())
				.size();
		
		int openEnqs = enqList.stream()
				.filter(e -> e.getEnqStatus().equals("Open"))
				.collect(Collectors.toList())
				.size();
		
		reponse.setTotalEnqs(totalEnq);
		reponse.setEnrolledEnqs(enrolledEnqs);
		reponse.setLostEnqs(LostEnqs);
		reponse.setOpenEnqs(openEnqs);

		return reponse;
	}

	

}
