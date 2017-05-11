# PREPARATORY REFACTORING TO HANDLE A NEW CATEGORY 

## CODE SMELLS THAT IMPACT CATEGORIES
- [X] Data clumps (categories fields | data)
- [X] Data clumps (single category w/ places fields | data)
- [X] Shotgun surgery (logic | behaviour)
- [X] Primitive obsession (single field | data)
- [X] Switch statement (dispatch logic | behaviour)

## ON GAME CLASS
- [X] move category questions fields
- [X] extract logic from Game's ctor
- [X] move createRockQuestion method
- [X] move fillQuestions method
- [X] move askQuestion method
- [X] move currentCategory method

## ON QUESTION DECK CLASS
- [X] inline createRockQuestion?
- [X] clean fillQuestions method
- [X] clean askQuestion method
    - [X] fix string comparison
    - [X] move out System.out.println() calls
- [X] clean currentCategory method
    - [X] explicit Rock places in currentCategory
    - [X] throw exception for out of board place
- [X] test fillQuestions method
- [X] test askQuestion method
- [X] test currentCategory method
- [] spread out add category, placeOn and addQuestion
