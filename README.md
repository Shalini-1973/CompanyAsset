#Assignment Description :

#Problem statement :
Add Category (Id, name, description) : Here admin will add category like electronic, furniture etc.
Update Category : Here we can update the existing category.
Get All categories : I have to create an API for accessing the list of all categories.
Add Asset (Id, name, purchase date, condition notes, employee Id, category Id) : Here Admin can add Asset.
Search Asset by name : Here I have to create an API for getting the asset by passing name of asset.
Assign an asset : here I have to create an API for assigning the asset to an employee.
Delete an asset : An API to delete the existing asset which is not assigned to any employee.
Recover an asset : An API to recover an asset that is assigned to any employee.
Tech Stack to be used : Spring boot 2.4, Spring JPA, H2 database, GitHub.

#Solution Statement:

By following the above problem statement, I have divided the whole project in there parts i.e. also the three models of our project. 
Category, Asset, Employee
Here I have explained each part individually:

#For Category:

Steps:
I have created a Category class, which contains the information like Id, name and description. Also I have added List<Asset> variable, which is having a ONE TO MANY mapping to the Asset class, because we know that a category can have multiple assets like for Category Electronic, can have assets mobile, laptop etc.
Also I have created a JPARepository for Category class for storing the category to the database.
Then I have created a service interface where I have declared three methods as per the requirement. The methods are foe adding a category to the database, fetching all the categories and updating a particular existing Category in database.
Again I have written the definition of the category service interface methods in Category Implementation class.
For adding a category to database I have created a category Dto class which contain information name and description, this prevent the direct access to database. Then by using the reference of Category Repository
I can add category to database. So before adding to the database firstly I have checked that category is already exists in the database or not. If it is available in the database a log will create by showing the information that can’t store category to the database. Otherwise, it will store to the database.
Then again a method for getting all the category from the database, for that I have used findAll method of JPA Repository of Category class.
Then the last method of this class is updating the Category information of particular category Id. Here the coming arguments of this method are CategoryDto and categoryId. CategoryDto contains the updated information of that Id. Once the updation succesfull, a log will generate by showing information Updation successful, else unable to update the category.
And In last I have created a controller for handling all the URL request, related to the category.

#For Asset:

Steps:
I have created an asset class, which contains information like id, name, condition_notes, purchase_date, assignment_status. Also I have created an object of category class by adding MANY TO ONE relationship because for many asset there must be a single category, also an employee object by adding MANY TO ONE relationship because here also many assets can be represented by single employee.
Again I have created a JPA repository for asset class for applying the operation over the database.
Then, I have created a service interface, in which I declared three method as per the requirement for adding, deleting, and fetching the asset by name from database.
For defining all the above method I implemented the asset service interface to the asset serviceImpl class.
The first method is for adding the asset into the database.For that I have created a assetDto class continning the information name and category id. I have used Dto  class to prevent for passing all the information of asset like id(because it is Auto Generated), condition_note, purchase_date  etc, because I have given  some default values for that variable. Once I get the asset Dto then I have created an object of asset an set the information of coming Dto and default values to the data members of that object and by using the instance of asset repository saved that object to the database. Once it is saved a log will generate by showing the information, asset will be added to the database otherwise it shows error in storing asset.
The next method is for fetching the asset from database by name. For that I have declared a method in asset repository interface here, just by using that method of repository I fetched the asset from the database  by using the coming name.
 The last method is for deleting the asset here, before deleting I have checked the status of the asset which I want to delete .if the status is assigned then  a logger will generate by showing the information that asset is assigned to any employee so can’t deleted. Otherwise just delete the asset by using the method delete by id of JPA Repository.
In last I have created the controller for handling all the URLs request related to asset. You can go through the code for better and clear understanding.

#For Employee:

Steps:
Similarly, here also I have created Entity class, Repository interface, Employee Service interface, in  which I declared five methods i.e., adding an employee, deleting an employee, fetching all employee and also two more methods,  one is for assigning the asset to the employee and the second is for recovering the asset from the employee. Here I have explained only two methods i.e., assigning an asset and recovering an asset.
For assigning the asset I have created assigned Dto containing the information employee id, and asset id, after getting assigned dto, I checked that the employee and asset is available in the database or not for the given employee id, and asset id, if anyone is not available just returned the employee without updating anything. Otherwise firstly checked the asset status is available or not. If not then a log will generate by showing the information that asset is already assigned. Else changed some data members of the asset from default values like  status will be changed to assigned, purchase date will be the current date, employee will be changed from null to the employee of the coming employee id, then in last  get the all assigned  assets to the employee and add the updated asset to that set and again set that list  to the employee asset object and now save the employee object as well as the asset object and just return the employee.
For recovering the asset from the employee which is assigned, for that I have created an another Dto which contains the information employee id, and asset id .after getting the dto fetch the employee id and asset id, and find that the employee and the assets of that id’s exits or not. If not a logger will generates by showing the information entity not found. Otherwise I have checked that the asset status is assigned or not. And also matches   the employee id of that assets and the coming employee id with dto is same or not. If it is same then update the data member of that asset with default value and status with recovered and save both the employee as well as the asset and just return the employee.

#Libraries used:

Spring-boot-starter-data-jpa
Spring-boot-starter-web
H2 database
Lombok
Springfox-swagger2
Springfox-swagger-ui

#Note: I have used swagger for visualizing for APIs, and with swagger UI it provides online sandbox for frontend developers. And for logging I have used Slf4j annotation of Lombok dependency.
 
