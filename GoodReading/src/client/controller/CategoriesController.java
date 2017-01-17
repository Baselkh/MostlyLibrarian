package client.controller;
import java.util.ArrayList;

import client.ui.Client;
import protocol.request.AddSubjectToCategoryRequest;
import protocol.request.GetAllCategoriesRequest;
import protocol.request.RemoveSubjectsFromCategoryRequest;
import protocol.request.SubjectsInCategoryRequest;
import protocol.response.AddSubjectToCategoryResponse;
import protocol.response.GetAllCategoriesResponse;
import protocol.response.RemoveSubjectsFromCategoryResponse;
import protocol.response.SubjectsInCategoryResponse;

/**
 * @author Basel
 *
 */
public class CategoriesController extends AbstractController {

	public CategoriesController(Client client){
		super(client);
	}
	
	public SubjectsInCategoryResponse getSubjectsInCategory(String categoryName){
		SubjectsInCategoryRequest message= new SubjectsInCategoryRequest(categoryName);
		return (SubjectsInCategoryResponse) client.sendMessage(message);
	}
	
	public GetAllCategoriesResponse GetAllCategories(){
		GetAllCategoriesRequest message= new GetAllCategoriesRequest();
		return (GetAllCategoriesResponse) client.sendMessage(message);
	}
	
	public AddSubjectToCategoryResponse addSubjectToCategory(String categoryName, String subjectName){
		AddSubjectToCategoryRequest message= new AddSubjectToCategoryRequest(categoryName, subjectName);
		return (AddSubjectToCategoryResponse) client.sendMessage(message);
	}
	
	public RemoveSubjectsFromCategoryResponse removeSubjectsFromCategory(ArrayList<String> subjectsIDs, String categoryName){
		RemoveSubjectsFromCategoryRequest message= new RemoveSubjectsFromCategoryRequest(subjectsIDs, categoryName);
		return (RemoveSubjectsFromCategoryResponse) client.sendMessage(message);
	}
	
}

