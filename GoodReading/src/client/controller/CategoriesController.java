package client.controller;
import client.entities.Category;
import client.ui.Client;
import protocol.request.GetAllCategoriesRequest;
import protocol.request.SubjectsInCategoryRequest;
import protocol.response.GetAllCategoriesResponse;
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
}

