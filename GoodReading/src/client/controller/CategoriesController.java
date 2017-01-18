package client.controller;
import java.util.ArrayList;

import client.ui.Client;
import protocol.request.AddSubjectToCategoryRequest;
import protocol.request.CreateNewCategoryRequest;
import protocol.request.DeleteCategoriesRequest;
import protocol.request.GetAllCategoriesRequest;
import protocol.request.RemoveSubjectsFromCategoryRequest;
import protocol.request.RenameCategoryRequest;
import protocol.request.RenameSubjectRequest;
import protocol.request.SubjectsInCategoryRequest;
import protocol.response.AddSubjectToCategoryResponse;
import protocol.response.CreateNewCategoryResponse;
import protocol.response.DeleteCategoriesResponse;
import protocol.response.GetAllCategoriesResponse;
import protocol.response.RemoveSubjectsFromCategoryResponse;
import protocol.response.RenameCategoryResponse;
import protocol.response.RenameSubjectResponse;
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
	
	public RenameSubjectResponse renameSubject(String subjectID, String newSubjectName){
		RenameSubjectRequest message = new RenameSubjectRequest(subjectID, newSubjectName);
		return (RenameSubjectResponse) client.sendMessage(message);
	}
	
	public CreateNewCategoryResponse createNewCategory(String categoryName){
		CreateNewCategoryRequest message = new CreateNewCategoryRequest(categoryName);
		return (CreateNewCategoryResponse) client.sendMessage(message);
	}
	
	public DeleteCategoriesResponse deleteCategory(ArrayList<String> categories){
		DeleteCategoriesRequest message = new DeleteCategoriesRequest(categories);
		return (DeleteCategoriesResponse) client.sendMessage(message);
	}
	
	public RenameCategoryResponse renameCategory(String oldName, String newName){
		RenameCategoryRequest message = new RenameCategoryRequest(oldName, newName);
		return (RenameCategoryResponse) client.sendMessage(message);
	}
}

