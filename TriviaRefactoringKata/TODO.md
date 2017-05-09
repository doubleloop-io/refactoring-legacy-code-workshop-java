# PREPARATORY REFACTORING TO HANDLE A NEW CATEGORY 

## CODE SMELLS THAT IMPACT CATEGORIES
- [] Data clumps (fields | data)
- [] Shotgun surgery (logic | behaviour)
- [] Primitive obsession (single field | data)
- [] Switch statement (dispatch logic | behaviour)

## ON GAME CLASS
- [] move category questions fields
- [X] extract logic from Game's ctor
- [X] move createRockQuestion method
- [X] move fillQuestions method
- [] move askQuestion method
- [X] move currentCategory method

## ON QUESTION DECK CLASS
- [] inline createRockQuestion?
