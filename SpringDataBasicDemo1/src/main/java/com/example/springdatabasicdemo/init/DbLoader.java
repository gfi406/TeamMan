package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.models.*;
import com.example.springdatabasicdemo.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

@Component
@DependsOn("dataSource")
public class DbLoader implements ApplicationRunner {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TasksRepository taskRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ClerkRepository clerkRepository;



    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Создаем проекты
        Projects project1 = new Projects("Hiwrld", "Desc 1", "2023-12-01", "Active");
        Projects project2 = new Projects("Ejik", "Desc 2", "2023-10-01", "Active");
        Projects project3 = new Projects("O.L.E.K.","Oh, Let's Eat Kebabs","2023-12-25","Active");


        projectRepository.save(project1);
        projectRepository.save(project2);
        projectRepository.save(project3);

       // Создаем задачи
        Tasks task1 = new Tasks("Tea cat", "development of an algorithm for sending cats to a tea ceremony", "2022-06-01", "In Progress");
        Tasks task2 = new Tasks("Superhero salmon fight", "creating a model to predict the outcome of superhero fights between salmon and other heroes", "2022-07-01", "Done");
        Tasks task3 = new Tasks("Combat dance battle", "development of an algorithm for assessing and classifying various dance styles of battle tanks", "2023-02-11", "Testing");
        Tasks task4 = new Tasks("Cat fall predictor", "creating a model to predict the places where cats will jump from treetops", "2023-02-06", "Done");
        Tasks task5 = new Tasks("Martian Revolutionary", "development of an algorithm that allows us to determine how the Martians plan to overthrow the Earth", "2023-01-12", "Done");
        Tasks task6 = new Tasks("Coffee eagle", "creating a model to predict the flight patterns of coffee-dropping eagles", "2023-03-15", "Planned");
        Tasks task7 = new Tasks("Robot chef", "development of an algorithm for a robot that can cook gourmet meals", "2023-04-20", "Planned");
        Tasks task8 = new Tasks("Space cat transporter", "designing a system to safely transport space cats to different planets", "2023-05-10", "In progress");
        Tasks task9 = new Tasks("Time-traveling fish", "developing a model to study the behavior of fish in different time periods", "2023-06-25", "In progress");
        Tasks task10 = new Tasks("Quantum kangaroo jumps", "researching the physics behind quantum jumps performed by kangaroos", "2023-07-17", "Done");
        Tasks task11 = new Tasks("Unicorn language translation", "creating an algorithm to decode and understand the language of unicorns", "2023-08-05", "Done");
        Tasks task12 = new Tasks("Sneezing elephant detection", "developing a system to detect and track sneezing behavior in elephants", "2023-09-13", "Testing");
        Tasks task13 = new Tasks("Robot soccer champions", "building an AI-powered robot soccer team to compete in international tournaments", "2023-10-20", "Testing");
        Tasks task14 = new Tasks("Alien communication deciphering", "developing techniques to understand and communicate with extraterrestrial beings", "2023-11-12", "Done");
        Tasks task15 = new Tasks("Virtual reality surfing", "creating a virtual reality experience for surfing on any ocean wave", "2023-09-05", "In Progress");
        Tasks task16 = new Tasks("Intergalactic travel planner", "designing a system to plan and book travel to different galaxies", "2023-09-18", "Done");
        Tasks task17 = new Tasks("Birds vs. Robots battle", "conducting a study on the tactics and strategies of birds in battles against robots", "2023-09-25", "Done");
        Tasks task18 = new Tasks("Disco dancing penguins", "analyzing the dance moves and patterns of disco dancing penguins", "2023-08-17", "Done");
        Tasks task19 = new Tasks("Supermarket shopping spree prediction", "developing a model to predict the most efficient path for a shopping spree in a supermarket", "2023-09-29", "Done");
        Tasks task20 = new Tasks("Space jellyfish swarm behavior", "studying the behavior and movement patterns of swarms of space jellyfish", "2023-09-12", "Done");
        Tasks task21 = new Tasks("Invisibility cloak creation", "researching materials and techniques for creating an invisibility cloak", "2023-09-20", "In progress");
        Tasks task22 = new Tasks("Machine learning weather forecasting", "developing a machine learning model for accurate weather forecasting", "2023-07-15", "Testing");
        Tasks task23 = new Tasks("Lizard acrobatics analysis", "analyzing the acrobatic behavior and capabilities of various species of lizards", "2023-08-02", "In progress");
        Tasks task24 = new Tasks("Smartphone mind reading", "exploring the possibilities of mind reading using smartphone technology", "2023-09-10", "Testing");
        Tasks task25 = new Tasks("Robot pet training", "developing algorithms and techniques for training robots as pets", "2023-10-25", "In progress");
        task1.setProject(project1);
        task2.setProject(project2);
        task3.setProject(project2);
        task4.setProject(project2);
        task5.setProject(project1);
        task6.setProject(project3);
        task7.setProject(project1);
        task8.setProject(project2);
        task9.setProject(project2);
        task10.setProject(project2);
        task11.setProject(project3);
        task12.setProject(project1);
        task13.setProject(project1);
        task14.setProject(project2);
        task15.setProject(project3);
        task16.setProject(project2);
        task17.setProject(project1);
        task18.setProject(project1);
        task19.setProject(project1);
        task20.setProject(project3);
        task21.setProject(project3);
        task22.setProject(project3);
        task23.setProject(project1);
        task24.setProject(project1);
        task25.setProject(project1);
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);
        taskRepository.save(task5);
        taskRepository.save(task6);
        taskRepository.save(task7);
        taskRepository.save(task8);
        taskRepository.save(task9);
        taskRepository.save(task10);
        taskRepository.save(task11);
        taskRepository.save(task12);
        taskRepository.save(task13);
        taskRepository.save(task14);
        taskRepository.save(task15);
        taskRepository.save(task16);
        taskRepository.save(task17);
        taskRepository.save(task18);
        taskRepository.save(task19);
        taskRepository.save(task20);
        taskRepository.save(task21);
        taskRepository.save(task22);
        taskRepository.save(task23);
        taskRepository.save(task24);
        taskRepository.save(task25);


        // Создаем команды
        Team team1 = new Team("Slimak");
        Team team2 = new Team("Bober");
        Team team3 = new Team("Kaczka");
        Team team4 = new Team("CCU");

        team1.setProject(project1);
        team2.setProject(project2);
        team3.setProject(project3);
        team4.setProject(project3);

        teamRepository.save(team1);
        teamRepository.save(team2);
        teamRepository.save(team3);
        teamRepository.save(team4);

        // Создаем сотрудников
        Clerk clerk1 = new Clerk("John Doe", "Developer",20);
        Clerk clerk6 = new Clerk("Jane Boe", "Designer",30);
        Clerk clerk2 = new Clerk("Jane Smith", "Engineer",20);
        Clerk clerk3 = new Clerk("Michael Johnson", "Manager",40);
        Clerk clerk4 = new Clerk("Sarah Williams", "Analyst",70);
        Clerk clerk5 = new Clerk("David Brown", "Designer",10);
        Clerk clerk7 = new Clerk("William Lee", "Developer", 30);
        Clerk clerk8 = new Clerk("Elizabeth Wilson", "Project Manager", 60);
        Clerk clerk9 = new Clerk("Daniel Lewis", "Business Analyst", 50);
        Clerk clerk10 = new Clerk("Olivia Rodriguez", "UX Designer", 40);
        Clerk clerk11 = new Clerk("Sophia Garcia", "Programmer", 60);
        Clerk clerk12 = new Clerk("Liam Martinez", "Designer", 50);
        Clerk clerk13 = new Clerk("Olivia Rodriguez", "Project Manager", 87);
        Clerk clerk14 = new Clerk("Noah Anderson", "Analyst", 30);
        Clerk clerk15 = new Clerk("Emma Wilson", "Developer", 40);
        Clerk clerk16 = new Clerk("William Moore", "QA Engineer", 54);
        Clerk clerk17 = new Clerk("Isabella Johnson", "UX Designer", 78);
        Clerk clerk18 = new Clerk("Mason Williams", "Frontend Developer", 42);
        Clerk clerk19 = new Clerk("Sofia Jones", "Backend Developer", 63);
        Clerk clerk20 = new Clerk("Lucas Garcia", "System Admin", 53);
        Clerk clerk21 = new Clerk("Emily Smith", "Designer", 35);
        Clerk clerk22 = new Clerk("Elijah Thomas", "Programmer", 51);
        Clerk clerk23 = new Clerk("Olivia Moore", "Developer", 46);
        Clerk clerk24 = new Clerk("Noah Martinez", "Analyst", 65);
        Clerk clerk25 = new Clerk("Ava Anderson", "QA Engineer", 51);
        Clerk clerk26 = new Clerk("Liam Davis", "UX Designer", 79);
        Clerk clerk27 = new Clerk("Emma Johnson", "Frontend Developer", 42);
        Clerk clerk28 = new Clerk("William Garcia", "Backend Developer", 33);
        Clerk clerk29 = new Clerk("Sophia Jones", "System Admin", 54);
        Clerk clerk30 = new Clerk("Mason Williams", "Designer", 65);
        Clerk clerk31 = new Clerk("Isabella Lewis", "Programmer", 42);
        Clerk clerk32 = new Clerk("Daniel Rodriguez", "Project Manager", 53);
        Clerk clerk33 = new Clerk("Michael Thomas", "Business Analyst", 68);
        Clerk clerk34 = new Clerk("Ethan Martinez", "Developer", 71);
        Clerk clerk35 = new Clerk("Olivia Anderson", "Designer", 43);
        Clerk clerk36 = new Clerk("Lucas Moore", "Analyst", 52);
        Clerk clerk37 = new Clerk("Amelia Davis", "QA Engineer", 69);
        Clerk clerk38 = new Clerk("Evelyn Johnson", "UX Designer", 78);
        Clerk clerk39 = new Clerk("Oliver Garcia", "Frontend Developer", 41);
        Clerk clerk40 = new Clerk("Layla Jones", "Backend Developer", 55);

        clerk1.setTeam(team1);
        clerk2.setTeam(team1);
        clerk3.setTeam(team4);
        clerk4.setTeam(team2);
        clerk5.setTeam(team3);
        clerk6.setTeam(team4);
        clerk7.setTeam(team1);
        clerk8.setTeam(team1);
        clerk9.setTeam(team2);
        clerk10.setTeam(team4);
        clerk11.setTeam(team3);
        clerk12.setTeam(team3);
        clerk13.setTeam(team1);
        clerk14.setTeam(team1);
        clerk15.setTeam(team4);
        clerk16.setTeam(team2);
        clerk17.setTeam(team3);
        clerk18.setTeam(team3);
        clerk19.setTeam(team1);
        clerk20.setTeam(team4);
        clerk21.setTeam(team2);
        clerk22.setTeam(team2);
        clerk23.setTeam(team3);
        clerk24.setTeam(team3);
        clerk25.setTeam(team4);
        clerk26.setTeam(team1);
        clerk27.setTeam(team2);
        clerk28.setTeam(team2);
        clerk29.setTeam(team3);
        clerk30.setTeam(team3);
        clerk31.setTeam(team1);
        clerk32.setTeam(team4);
        clerk33.setTeam(team2);
        clerk34.setTeam(team2);
        clerk35.setTeam(team3);
        clerk36.setTeam(team3);
        clerk37.setTeam(team1);
        clerk38.setTeam(team1);
        clerk39.setTeam(team4);
        clerk40.setTeam(team2);
        clerkRepository.save(clerk1);
        clerkRepository.save(clerk2);
        clerkRepository.save(clerk3);
        clerkRepository.save(clerk4);
        clerkRepository.save(clerk5);
        clerkRepository.save(clerk6);
        clerkRepository.save(clerk7);
        clerkRepository.save(clerk8);
        clerkRepository.save(clerk9);
        clerkRepository.save(clerk10);
        clerkRepository.save(clerk11);
        clerkRepository.save(clerk12);
        clerkRepository.save(clerk13);
        clerkRepository.save(clerk14);
        clerkRepository.save(clerk15);
        clerkRepository.save(clerk16);
        clerkRepository.save(clerk17);
        clerkRepository.save(clerk18);
        clerkRepository.save(clerk19);
        clerkRepository.save(clerk20);
        clerkRepository.save(clerk21);
        clerkRepository.save(clerk22);
        clerkRepository.save(clerk23);
        clerkRepository.save(clerk24);
        clerkRepository.save(clerk25);
        clerkRepository.save(clerk26);
        clerkRepository.save(clerk27);
        clerkRepository.save(clerk28);
        clerkRepository.save(clerk29);
        clerkRepository.save(clerk30);
        clerkRepository.save(clerk31);
        clerkRepository.save(clerk32);
        clerkRepository.save(clerk33);
        clerkRepository.save(clerk34);
        clerkRepository.save(clerk35);
        clerkRepository.save(clerk36);
        clerkRepository.save(clerk37);
        clerkRepository.save(clerk38);
        clerkRepository.save(clerk39);
        clerkRepository.save(clerk40);



    }


}
