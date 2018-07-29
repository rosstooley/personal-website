package com.rosstooley.personalwebsite;

import com.rosstooley.personalwebsite.utils.CardPackage;
import com.rosstooley.personalwebsite.utils.StringPair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class HomeController {
    private List<StringPair> getTechSkills() {
        List<StringPair> techSkills = new ArrayList<>(4);

        techSkills.add(new StringPair(
                "Relational Databases",
                "Designed the structure of a relational MySQL " +
                        "database system, as well as handling the transfer of data " +
                        "between it and the web-app using it, whilst working on a production system at Alderbrooke. " +
                        "This included writing a SQL engine to perform quantitative analysis to process thousands of data points " +
                        "per user of the app's psychological evaluation tool."
        ));

        techSkills.add(new StringPair(
                "Document oriented databases",
                "Used MongoDB to store reports for users of the Alderbrooke psychological evaluation tool."
        ));

        techSkills.add(new StringPair(
                "Basic Spring and Spring Boot",
                "Learnt in order to build the front end Alderbrooke's web-app. This website is built using it."
        ));

        techSkills.add(new StringPair(
                "Maven",
                "Used in Alderbrooke to manage the development of our web-app."
        ));

        techSkills.add(new StringPair(
           "Git",
                "Used at Alderbrooke to help organise our team when developing the web-app."
        ));

        techSkills.add(new StringPair(
                "AWS", "The web-app now runs as a production system on an AWS Linux EC2 instance, " +
                "using RDS to run the database instance, S3 to host the MongoDB database, and EBS to manage load balancing."
        ));

        techSkills.add(new StringPair(
                "JUnit and unit testing",
                "Taught as part of the IA Course, I create a regression testing suite for the web-app at Alderbrooke."
        ));

        return techSkills;
    }

    private List<StringPair> getProgrammingLanguages() {
        List<StringPair> languages = new LinkedList<>();

        languages.add(new StringPair(
                "Java",
                "Taught to a high level in my university course. I now use it for the majority of my programming including during my Alderbrooke internship, " +
                        "for my university projects, and home projects (including this website)."
        ));

        languages.add(new StringPair(
                "SML",
                "A functional language taught during first year Computer Science at Cambridge."
        ));

        languages.add(new StringPair(
                "Python",
                "Used to teach Scientific Computing and Data Science at Cambridge, so I also have experience " +
                        "working with Numpy and Pandas."
        ));

        languages.add(new StringPair(
                "Visual Basic",
                "My first language! I was taught this at school and used it to complete my GCSE and A-levels in Computer Science"
        ));

        languages.add(new StringPair(
                "HTML, CSS",
                "Though I am not a web-developer, I have clearly done some web development in my time."
        ));

        return languages;
    }

    private List<StringPair> getCoursesStudied() {
        List<StringPair> courses = new LinkedList<>();

        courses.add(new StringPair(
                "Foundations of Computer Science and Functional Programming",""
        ));

        courses.add(new StringPair(
                "Object-Oriented Programming",""
        ));

        courses.add(new StringPair(
                "Digital Electronics",""
        ));

        courses.add(new StringPair(
                "Discrete Mathematics",""
        ));

        courses.add(new StringPair(
                "Databases",""
        ));

        courses.add(new StringPair(
                "Graphics",""
        ));

        courses.add(new StringPair(
                "Scientific Computing",""
        ));

        courses.add(new StringPair(
                "Algorithms",""
        ));

        courses.add(new StringPair(
                "Operating Systems",""
        ));

        courses.add(new StringPair(
                "Machine Learning and Real World Data",""
        ));

        courses.add(new StringPair(
                "Numerical Methods",""
        ));

        courses.add(new StringPair(
                "Software and Security Engineering",""
        ));

        courses.add(new StringPair(
                "Interaction Design",""
        ));

        return courses;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);

        List<CardPackage> cards = new LinkedList<>();

        List<StringPair> coursesStudied = getCoursesStudied();
        cards.add(new CardPackage("courses","University courses I've studied", coursesStudied));
        List<StringPair> programmingLanguages = getProgrammingLanguages();
        cards.add(new CardPackage("languages","Programming languages I've learnt", programmingLanguages));
        List<StringPair> techSkills = getTechSkills();
        cards.add(new CardPackage("skills","Technologies I've used in industry", techSkills));

        model.addAttribute("cards", cards);
        return "greeting";
    }
}
