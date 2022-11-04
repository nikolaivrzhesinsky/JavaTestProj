package YandexTestEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ex2 {

    public static void main(String[] args) {

        int n, k;
        List<Participant> participants = new ArrayList<>();
        Map<String, Integer> counter_discipline = new HashMap<>();
        Map<String, Integer> max_on_Discipline = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                String input = reader.readLine();
                String[] inputStr = input.split(",");
                counter_discipline.put(inputStr[0], Integer.parseInt(inputStr[1]));
                max_on_Discipline.put(inputStr[0], -1);
            }

            k = Integer.parseInt(reader.readLine());
            for (int j = 0; j < k; j++) {
                String inputParticipant = reader.readLine();
                String[] inputParticipantStr = inputParticipant.split(",");

                Participant participant = new Participant();
                participant.setName(inputParticipantStr[0]);
                participant.setPriority_discipline(inputParticipantStr[1]);
                participant.setNum_of_discipline(Integer.parseInt(inputParticipantStr[2]));
                participant.setPenalty(Integer.parseInt(inputParticipantStr[3]));

                participants.add(participant);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i=0;i< participants.size();i++){
            if(max_on_Discipline.get(participants.get(i).getPriority_discipline())==-1){
                max_on_Discipline.put(participants.get(i).getPriority_discipline(),i);
                counter_discipline.put(participants.get(i).getPriority_discipline(),
                        counter_discipline.get(participants.get(i).getPriority_discipline())-1);
            }
            else {

            }
        }
    }
}

    class Participant{

        private String name;
        private String priority_discipline;
        private int num_of_discipline;
        private int penalty;

        public Participant(){}

        public Participant(String name, String priority_discipline, int num_of_discipline, int penalty) {
            this.name = name;
            this.priority_discipline = priority_discipline;
            this.num_of_discipline = num_of_discipline;
            this.penalty = penalty;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPriority_discipline() {
            return priority_discipline;
        }

        public void setPriority_discipline(String priority_discipline) {
            this.priority_discipline = priority_discipline;
        }

        public int getNum_of_discipline() {
            return num_of_discipline;
        }

        public void setNum_of_discipline(int num_of_discipline) {
            this.num_of_discipline = num_of_discipline;
        }

        public int getPenalty() {
            return penalty;
        }

        public void setPenalty(int penalty) {
            this.penalty = penalty;
        }

        public boolean compareByResult(Participant participantFromMap, Participant participantOrder){

            if(participantOrder.getNum_of_discipline()>participantFromMap.getNum_of_discipline()) {
                return true;
            }
            else if(participantOrder.getPenalty()<participantFromMap.getPenalty() &&
                        participantOrder.getNum_of_discipline()==participantFromMap.getNum_of_discipline()){

                    return true;
                }
            else {
                return false;
            }

        }

    }





