
# Java Search Engine

A command line search engine which implements Inverted Index, Strategy pattern.


## Demo
![Final](https://github.com/anhtuansggd/Search_Engine/assets/122171727/0879d524-5647-458a-be20-808c439375c7)




## Run Locally

Clone the project

```bash
  https://github.com/anhtuansggd/Search_Engine.git
```

Go to the project directory

```bash
  cd Search_Engine
```

Compile source files

```bash
  javac --class-path ./search/ search/*.java
```

Executes with arguments

```bash
  java -classpath ./ search.Main --data ./search/tests.txt
```



## Features

 3 search option:  
    - ALL: Find names that inclued give name  
    - ANY: Find names that comes from any part of give any  
    - NONE: Find names that are different from give name



## More Explanation
Start with a given text file which will be add to list of all names:

Katie Jacobs  
Erick Harrington harrington@gmail.com  
Myrtle Medina  
Erick Burgess

The program maps each word of name to the index of line it starts:

katie -> [0]  
jacobs -> [0]  
erick -> [1, 3]  
harrington -> [1]  
harrington@gmail.com -> [1]  
myrtle -> [2]  
medina -> [2]  
burgess -> [3]  

Now, the program compare the name with chosen finding strategy to return index of result name to queries from list of all name.


## Reference

1: https://www.geeksforgeeks.org/inverted-index/  
2: https://refactoring.guru/design-patterns/strategy
