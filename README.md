# Java 8 + Spring Framework project

The objective of this project is to build a small software for the management of goods in a company.  Read through the following business case to capture the data requirements and develop the software solution.

### Business case:
- This company is focused in buying and selling products.
- This is the information needed for each item:
- Item code: Must be a unique value. This should be a numeric value.
    - Description
    -	Price
    -  	State : This can either be _Active_ or _Discontinued_.
    - 	Suppliers. Each item can be supplied by a set of suppliers. Likewise, a supplier can provide more than one item.
    -	Price reductions. An item can have several price reductions associated to it. No control for overlapping dates is required but recommended (look at the section ‘Extra points’).
    -	Creation date
    -	Creator (User)
-	This is the information needed for each supplier:
    -	Name
    -	Country
-	This is the information needed for the price reduction:
    -	Reduced price
    -	Start date
    -	End date

### Tasks
Here are the tasks that need to be implemented for the API:
- **Login**: The API should have an access window where the user can sign in with its corresponding username and password. This should be implemented using an authentication mechanism.
- **List of items**: The API should represent the list of items offered by the company. An option to filter the records by the item’s state should be implemented.
This list should include the following information:
    - Item code:
    - Description
    - State
    - Price
    - Creation date
    - Creator
- **Item’s information**: The detailed information of an item selected from the list should be represented in a window. The suppliers and price reductions associated to the item must be included too. It is your own choice, how to represent this information.
- **Create an item**: An action to create an item must be developed.
    - The only mandatory fields are the _Item code_ and _Description_.
	- The value _Active_ should be set as the default state.
    - The current date should be set as the creation date.
- **Edit an item’s data**: _Active_ items should be modifiable.
    - All the fields (excluding the item code) should be editable.
    - An option to associate a supplier should be included. The system should verify that the supplier is  not associated to the item already.
    - An option to insert price reductions should be implemented.
- **Deactivate an item**: Implement an option to deactivate an item by changing its state to _Discontinued_.
    - The user has to specify the reason for the deactivation.
    - The user performing the deactivation has to be registered.
    
You have to perform these tasks satisfying also the next points
-	Java Framework: develop the solution using either Spring Boot or Play Java frameworks
-	Hibernate: It is required to include Hibernate ORM
-	Models: Implement the domain models with JPA annotations
-	REST: Design the API entries for REST methods exclusively
-	It is convenient to use libraries and tools provided by the platform selected.

The section _Extra points_ and _Technical extra assessments_ is optional. It will be taken into account when assesing this test.

#### Extra points
-	Admin: Implement a role for Adminstrators, so they can:
- 	Manage user information
    -	Create users
    -	Delete users
    -	List users
-	Delete items.
-	Control of overlapping dates when inserting a price reduction. An item cannot have two active price reductions at the same time.
-	SQLs: Build the corresponding SQL queries to obtain the following results
    - List of cheapest item per supplier.
    - List of suppliers associated to items whose price has been reduced.
-   Documentation: Include the following software documentation:
    -	Class diagram
    -	User manual

#### Technical extra assessments
- 	Not only the efficiency of the final solution will be assessed but also code guide style, simplicity, usage of standards and design patterns
- 	Java 8 and above compliant JDK
-	Asynchronous and non blocking Java and Javascript methods
-	Implementation of unit tests
- 	SQL statements optimized for either PostgreSQL or H2 RDBM
-	Adoption of security APIs (eg JWT)
-	Rich GUI through making use of React/Redux like frameworks.