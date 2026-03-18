# Hibernate Inventory Management System

A Spring Boot application for managing product inventory using Hibernate ORM and an in-memory H2 database.

## 📋 Features

- **Create Products** - Add new products to the inventory
- **Read Products** - Retrieve product information by ID
- **Update Products** - Modify product price and quantity
- **Delete Products** - Remove products from inventory
- **H2 Console** - View database contents via web interface
- **User Input** - Interactive command-line menu

## 🛠️ Technologies Used

- **Java 21** - Programming language
- **Spring Boot 3.5.11** - Framework
- **Hibernate 6.6.42** - ORM
- **H2 Database** - In-memory relational database
- **Maven** - Build tool
- **JPA** - Java Persistence API

## 📦 Project Structure

```
HibernateInventory/
├── src/
│   ├── main/
│   │   ├── java/com/inventory/
│   │   │   ├── HibernateInventoryApplication.java  (Main entry point)
│   │   │   ├── dao/
│   │   │   │   └── ProductDAO.java                 (Database operations)
│   │   │   └── entity/
│   │   │       └── Product.java                    (Entity model)
│   │   └── resources/
│   │       └── application.properties              (Database config)
│   └── test/
│       └── java/com/inventory/HibernateInventory/
│           └── HibernateInventoryApplicationTests.java
├── pom.xml                                        (Maven dependencies)
└── README.md                                      (This file)
```

## 🚀 Getting Started

### Prerequisites
- Java 21 (JDK)
- Maven 3.6+

### Installation

1. Navigate to project directory:
```bash
cd HibernateInventory
```

2. Build the project:
```bash
mvn clean install
```

### Running the Application

Start the application with interactive menu:
```bash
mvn spring-boot:run
```

You will see the menu:
```
========== INVENTORY MANAGEMENT ==========
1. Create Product
2. Read Product
3. Update Product
4. Delete Product
5. Exit
Enter your choice:
```

## 📝 Usage Examples

### Create a Product
```
Enter your choice: 1
Enter product name: Keyboard
Enter description: Mechanical Keyboard
Enter price: 5000
Enter quantity: 20
→ Product saved: Keyboard
```

### Read a Product
```
Enter your choice: 2
Enter product ID: 1
→ Found: Keyboard
```

### Update a Product
```
Enter your choice: 3
Enter product ID: 1
Enter new price: 4500
Enter new quantity: 15
→ Product updated: Keyboard
```

### Delete a Product
```
Enter your choice: 4
Enter product ID: 1
→ Product deleted: Keyboard
```

## 🗄️ Database Configuration

Database details in `application.properties`:
- **Type**: H2 (In-memory)
- **URL**: `jdbc:h2:mem:inventory_db`
- **Username**: `sa`
- **Password**: `password`
- **Auto DDL**: `update` (creates/updates tables automatically)

### View Database Web Console

While the app is running, open in browser:
```
http://localhost:8080/h2-console
```

**Login details:**
- JDBC URL: `jdbc:h2:mem:inventory_db`
- User: `sa`
- Password: `password`

Run SQL query:
```sql
SELECT * FROM products;
```

## 🧪 Running Tests

```bash
mvn test
```

## 📄 Entity Model

### Product Entity

| Field | Type | Description |
|-------|------|-------------|
| id | Integer | Primary key (AUTO_INCREMENT) |
| name | String | Product name |
| description | String | Product description |
| price | Double | Product price |
| quantity | Integer | Stock quantity |

### Example Product
```json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 75000,
  "quantity": 10
}
```

## 🔍 CRUD Operations

### Create
- Adds a new product to the inventory
- Auto-generates ID

### Read
- Retrieves product by ID
- Returns product details or "Product not found" message

### Update
- Updates price and quantity for existing product
- Requires product ID

### Delete
- Removes product from inventory
- Requires product ID

## 📊 Build Output

When running the application, you'll see:
```
Started HibernateInventoryApplication in 2.061 seconds
Product saved: Laptop
Product saved: Mouse
Found: Laptop
Product updated: Laptop
Product deleted: Mouse
BUILD SUCCESS
```

## 🐛 Troubleshooting

### Issue: "Access denied for user 'root'"
**Solution**: Application uses H2 in-memory database, not MySQL. No external database setup needed.

### Issue: "Unable to locate persister"
**Solution**: Ensure `@EntityScan` annotation includes correct package path.

### Issue: Build fails
**Solution**: Run `mvn clean install` to rebuild from scratch.

## 📝 Notes

- H2 database is **in-memory**, data is cleared when app shuts down
- For persistent storage, switch to MySQL/PostgreSQL
- Tests can be run with `mvn test`
- Application automatically creates tables on startup

## 📧 Support

For issues or questions, check the logs or review the source code comments.

## 📄 License

Open source project for learning purposes.
