# PREPARATORY REFACTORING TO HANDLE A NEW CATEGORY 

## CODE SMELLS THAT IMPACT CATEGORIES
- [] Data clumps (categories fields | data)
- [] Data clumps (single category w/ places fields | data)
- [] Shotgun surgery (logic | behaviour)
- [] Primitive obsession (single field | data)
- [] Switch statement (dispatch logic | behaviour)

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
- [] clean askQuestion method
    - [X] fix string comparison
    - [] move out System.out.println() calls
- [] clean currentCategory method
    - [X] explicit Rock places in currentCategory
    - [X] throw exception for out of board place
- [X] test fillQuestions method
- [X] test askQuestion method
- [X] test currentCategory method
