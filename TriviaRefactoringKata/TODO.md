# PREPARATORY REFACTORING TO HANDLE A NEW CATEGORY 

## CODE SMELLS THAT IMPACT CATEGORIES
- [] Data clumps (fields | data)
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
- [] inline createRockQuestion?
- [] clean fillQuestions method
- [] clean askQuestion method
    - [X] fix string comparison
    - [] move out System.out.println() calls
- [] clean currentCategory method
    - [] explicit Rock places in currentCategory
- [] test fillQuestions method
- [] test askQuestion method
- [X] test currentCategory method
