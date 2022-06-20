package Demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {

      //  ApplicationContext contex=new ClassPathXmlApplicationContext("spring.xml");

        ApplicationContext context= new
                AnnotationConfigApplicationContext(BeanConfig.class);
        //Doctor doctor=contex.getBean(Doctor.class);
        //Nurse doctor =(Nurse) contex.getBean("Nurse");
//        Doctor staff = context.getBean(Doctor.class);
//        Nurse staf = context.getBean(Nurse.class);
//        staf.assist();
//        staff.assist();
        Doctor doctor=context.getBean(Doctor.class);

        doctor.setQualification("MBBS");
        System.out.println(doctor);
//        Doctor doctor1 =context.getBean(Doctor.class);
//        System.out.println(doctor1);




    }
}
