DessertMaker
============

```
git submodule add git://nuuneoi.com/TheCheeseLibrary.git
gi android >> .gitignore 
```
fix setting.gradle
```
include ':app','TheCheeseLibrary'
```
add build.gradle
```
   compile project(':TheCheeseLibrary') 
```
