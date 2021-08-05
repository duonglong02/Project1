package main.thread;

import main.db.DbUtils;
import main.obj.Student;
import main.utils.XFile;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ThreadOne extends Thread{
    public static Logger logger = Logger.getLogger(ThreadOne.class);
    public static Queue<Student> queue;
    private static ArrayList<Student> students = new ArrayList<Student>();
    public int exit = 1;

    public ThreadOne(String name){
        super(name);
        if (queue == null){
            queue = new LinkedList<>();
        }
    }

    public static void addQueue(Student student){
        queue.add(student);
    }

    public static void getQueue(){
        if(queue.size() > 0){
            for (int i = 0; i < queue.size(); i++){
                students.add(queue.remove());
            }
        }
    }

    @Override
    public void run() {
        while (exit == 1) {
            getQueue();
            try {
                ThreadOne.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (queue.size() > 0){
                try {
                    logger.info("ArrayList student have " + students.size() + " student");
                    for (int i = 0; i < students.size(); i++){
                        XFile.writeFile(students.get(i));
                        DbUtils.addStudent(students.get(i));
                    }
                    students.clear();
                    logger.info("ArrayList student have " + students.size() + " student");
                } catch (IOException | ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
            else{
                logger.info("Khong co ban ghi nao trong queue");
            }
        }
    }
}