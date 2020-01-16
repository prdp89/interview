package com.interview.javabasics;

public class MethodReference {

    //https://www.javatpoint.com/java-8-method-reference
    public static void main( String[] args ) {
        MethodReference methodReference = new MethodReference(); // Creating object

        Sayable sayable = methodReference::saySomething;

        // Calling interface method
        sayable.say();

      /*  // Referring non-static method using anonymous object
        Sayable sayable2 = new MethodReference()::saySomething; // You can use anonymous object also

        // Calling interface method
        sayable2.say();*/

        //Calling parameterized method......
        InPredicate predicate = methodReference::saySomethingmore;
        System.out.println(predicate.check(2, 3));

        //Implementation Example:

        /*
        FollowUpDTOAssembler followUpDTOAssembler;
        final List<FollowUp> projectList = followUpServiceExt.getAllPostFollowUps();
        return projectList.stream().map(followUpDTOAssembler::toDTO).collect(Collectors.toList());
         */

        /*
        public FollowUpDTO toDTO(FollowUp followUp) {
        return followUp != null ? FollowUpDTO.builder()
                .followedByActorType(followUp.getFollowedByActorType())
                .build() : null;
    }
         */
    }

    private void saySomething() {
        System.out.println("Hello, this is non-static method.");
    }

    private Integer saySomethingmore( int x, int y ) {
        return x + y;
    }

    interface Sayable {
        void say();
    }

    interface InPredicate {
        int check( int x, int y );
    }
}
