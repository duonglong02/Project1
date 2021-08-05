package main.thread;

import main.db.DbUtils;
import main.obj.Student;
import main.utils.XFile;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class ThreadOne extends Thread{
    public static Logger logger = Logger.getLogger(ThreadOne.class);
    public static Queue<Student> queue;
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

    @Override
    public void run() {
        while (exit == 1) {
            try {
                ThreadOne.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (queue.size() > 0){
                try {
                    logger.info("Queue student have " + queue.size() + " student");
                    Student student = queue.peek();
                    XFile.writeFile(student);
                    DbUtils.addStudent(student);

                    queue.remove();
                    logger.info("Queue student have " + queue.size() + " student");
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