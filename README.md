# SOLID principles

## S - Single responsibility 
Classes like Library, Storage, Item, User, Staff - 
only responsible for 1 operation.
- Storage - for storing items in our library, also provides API for controlling that items
- Item - interface for representing items
- StaffBase - interface for staff users
- User - interface for users
- Library - controlling library

## O - Open Closed
Every class doing only their own functions, to add some new 
functions/features it's will be better to create new classes
via inheriting, etc.

## L - Liskov Substitution 
"If any P is a subtype of T, then objects of type T 
present in the program can be replaced by objects of 
type P without negative consequences for the 
functionality of the program." Example: now you can easily 
replace all Users to Patrons and vise - versa because
they both are subtypes of UserBase interface.

## I - Interface Segregation
Now we have two types of users: staff and users, because
they look similar, but they have different functionalities, so
it's better to divide them into two different interfaces
without creating 1 "super" interface with all functions

## D - Dependency Inversion
"Top-level modules should not depend on lower-level modules. Both must depend on abstractions. Abstractions should not depend on details. Details must depend on abstractions." - 
Library, Storage interfaces work with each others via abstractions
in our case via - Interfaces

# How to use program?

At the start, you don't have any users, staffs, and items inside library
You should add them by yourself. 
### Staff
With Staff, you can create new items, they will immediately 
store in library storage, also you can delete some items directly from library storage.
### User (Patron, User)
Every user have own inventory of taken items form library, they can return items
to library, take new items from library (user have limit of 3 taken items at once, while patron
don't have such limitation) and show they inventory
### Library 
With Library commands it's very convenient to show 
all items that currently inside of library's storage, like: sort by items type.