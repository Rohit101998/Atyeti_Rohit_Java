package Com.Lambda_EXP.Ex1;

public class Test {
    public static void main(String[] args) {
//        EngineeringStudent eng = new EngineeringStudent();
//        String s =eng.getname("Ram");
//        System.out.println(s);


        //or

//        Student eng = new Student() {
//            @Override
//            public String getname(String name) {
//                return name + " is engineering student";
//            }
//        };

//        String bio = eng.getname("Ram");
//        System.out.println(bio);



        Student lawStudent = (name) -> {
            return name + " is law student ";
        };
        String bio = lawStudent.getname("Ram");
        System.out.println(bio);



    }
}
