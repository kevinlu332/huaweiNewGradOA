public enum MyEnumClass {

    // these are called: enum constant
    //enum constants
    SMALL, MEDIUM, LARGE, XL;

    //method inside: can be concrete or abstract
    private void myEnumInfo(){
        System.out.println("Universal MyEnumClass.");
    }

    //constructor: every enum constant = an object = has its own constructor
    // with even just one enum constant is called. every enum constants' own constructors are called.
    private MyEnumClass(){
        System.out.println("Constructor called for: "+ this.toString());
    }

}
