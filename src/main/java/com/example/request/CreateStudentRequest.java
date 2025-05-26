package com.example.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentRequest {

	private String firstName;

	private String lastName;

	private String email;

	private CreateAddressRequest address;
	private List<CreateSubjectRequest> subjectsLearning;

}
