# General part

Inheritance mapping to tables in relational database is done using @Inheritance annotation on parent class.
There are 3 different strategies of creating the database schema this way, but in all of them there is a special column called discriminator, that stores the name of the direct implementation
If I use schema of this exercise as an example, the discriminator value will be either Ebook or PaperBook (implementations of Book class)

## strategies

### SINGLE_TABLE
Everything is stored in one table, in this project it would look as follows:

    book
    ---------
    ISBN
    DTYPE (discriminator)
    AUTHOR
    PRICE
    TITLE
    DOWNLOADURL (nullable)
    SIZEMB (nullable)
    INSTOCK (nullable)
    SHIPPINGWEIGHT (nullable)
    
The advantage is that everything is in one table therefore no join is needed.

It's a bad design to have everything meddled in one table, because if you need another attribute in Ebook, you'll have to add empty/null values to all PaperBook rows,
Also every attributes in subclasses must be nullable.
  
### JOINED

Every class has it's own table and each table share the same private key (in Java it's just super class that have private key).
The schema looks as follows:

    book        ebook           paperbook
    ----        ------          ---------
    ISBN        ISBN            ISBN
    DTYPE       DOWNLOADURL     INSTOCK
    AUTHOR      SIZEMB          SHIPPINGWEIGHT
    PRICE
    TITLE

The nice thing is that now the attributes in subclasses do not need to be nullable and adding attributes to one subclass won't affect other subclasses.
The bad think is that we need to perform JOIN every time we select anything.


# Practical part

It is written as a BookTest, I use NgTest engine, all tests should be passing, no setup except for the db is not necessary

# Bonus question

annotation @Column(nullable = false) on downloadUrl would fail if SINGLE_TABLE inheritance strategy was used.