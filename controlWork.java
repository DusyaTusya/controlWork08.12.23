package controlWork;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class
controlWork {
        private int id;
        private String name;
        private int weight;

        public controlWork(int id, String name, int weight) {
            this.id = id;
            this.name = name;
            this.weight = weight;
        }
        public static void main(String[] args) {

            controlWork toy1 = new controlWork(1, "Лопатка", 2);
            controlWork toy2 = new controlWork(2, "Савочек", 6);
            controlWork toy3 = new controlWork(3, "Ведерко", 2);
            PriorityQueue<controlWork> toyQueue = new PriorityQueue<>((a, b) -> b.weight - a.weight);
            toyQueue.add(toy1);
            toyQueue.add(toy2);
            toyQueue.add(toy3);
            try {
                FileWriter writer = new FileWriter("lotereja.txt");
                for(int i = 0; i < 10; i++){
                    controlWork toy = toyQueue.peek();
                    if(toy != null){
                        writer.write(toy.id + " "+ toy.name + "\n");
                        toy.weight--;
                        if(toy.weight == 0){
                            toyQueue.remove(toy);
                        }
                    }
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
