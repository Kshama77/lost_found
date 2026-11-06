# LostFound - Lost and Found Tracker

A beginner-friendly Java console application to record and manage lost and found items.

## Features

- Report a lost item
- Report a found item
- View all reported items
- Search by item name, description, or location
- Mark an item as returned
- Delete an item

## Java concepts used

- Classes and objects
- Variables and data types
- Methods
- `ArrayList`
- `Scanner` for user input
- `if/else` and `switch`
- `for` loops
- Basic exception handling

## Project structure

```text
LostFound/
├── src/
│   ├── Main.java
│   └── Item.java
└── README.md
```

## Requirements

- Java JDK 8 or later
- Terminal, Command Prompt, or a Java IDE such as IntelliJ IDEA or Eclipse

## Run the application

Open a terminal in the `LostFound` project folder and run:

```bash
javac -d out src/*.java
java -cp out Main
```

On Windows Command Prompt, the same commands work if the JDK is added to PATH.

## Notes

This starter version stores records in memory using an `ArrayList`. The records are cleared when the application exits. File or database storage can be added as a future improvement.

## Sample menu

```text
================================
       LOST & FOUND TRACKER
================================

------------- MENU -------------
1. Report a lost item
2. Report a found item
3. View all items
4. Search items
5. Mark item as returned
6. Delete an item
0. Exit
--------------------------------
```

## Future improvements

- Save items to a file so records remain after closing the app
- Add date validation
- Add separate user accounts
- Build a graphical interface
