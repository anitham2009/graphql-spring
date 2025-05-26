package com.example.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.entity.Subject;
import com.example.enums.SubjectNameFilter;
import com.example.response.AddressResponse;
import com.example.response.StudentResponse;
import com.example.response.SubjectResponse;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

	public List<SubjectResponse> getLearningSubjects (StudentResponse studentResponse, SubjectNameFilter subjectNameFilter) {
		
		List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();
		
		if (studentResponse.getStudent().getLearningSubjects() != null) {
			for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
				if(subjectNameFilter.name().equalsIgnoreCase("ALL")) {
					learningSubjects.add(new SubjectResponse(subject));
				}
				if(subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
				learningSubjects.add(new SubjectResponse(subject));
				}
			}
		}
		
		return learningSubjects;
		
	}
	
	public AddressResponse getAddress(StudentResponse studentResponse) {
		AddressResponse addressResponse = null;
		if(studentResponse.getStudent().getAddress() != null) {
			addressResponse = new AddressResponse(studentResponse.getStudent().getAddress());
		}
		return addressResponse;
	}
	public String getFullName (StudentResponse studentResponse) {
		return studentResponse.getFirstName() + " " + studentResponse.getLastName();
	}
}
