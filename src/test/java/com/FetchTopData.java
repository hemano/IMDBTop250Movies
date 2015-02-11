package com;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.common.AppBaseClass;
import com.constant.pageElement.HomePageUIDs;
import com.constant.pageElement.Top250PageUIDs;
import com.database.SQLiteOperations;

public class FetchTopData extends AppBaseClass {

	
	HomePageUIDs objHomePage;
	Top250PageUIDs objTop250Page;
		
	@Test
	public void getFirst250MoviesFromIMDB(){
		
	objHomePage = new HomePageUIDs(getDriver());
	objTop250Page = new Top250PageUIDs(getDriver());
	
	String expTitle = "IMDb Top 250 - IMDb";
	
		
	//Navigate to Top250 Movies page	
	objHomePage.clickTop250();	
	
	//Verify the title
	String title = objTop250Page.getTop250PageTitle();
	System.out.println("Actual Title : " + title);
	Assert.assertEquals(expTitle, title);
	
	}
	
	@Test(dependsOnMethods = "getFirst250MoviesFromIMDB")	
	public void saveAndPrintMoviesDetails(){

		//Delete all records imdbmoviesDB	
		SQLiteOperations.deleteAllRecordsFromDataBase();
		
		//Populate data in imdbmoviesDB	
		SQLiteOperations.populateDataBase(getDriver());
		
		//Print the data of imdbmoviesDB to console
		SQLiteOperations.printDataFromDBToConsole();
	
	}
}

