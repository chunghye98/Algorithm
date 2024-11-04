import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static PriorityQueue<Ticket> ticketSequence;
    static List<Stack<Ticket>> tickets;
    static Stack<Ticket> queue;
    static String result;

    static class Ticket implements Comparable<Ticket> {
        char alpha;
        int number;

        public Ticket(char alpha, int number) {
            this.alpha = alpha;
            this.number = number;
        }

        @Override
        public int compareTo(Ticket o) {
            if (this.alpha == o.alpha) {
                return Integer.compare(this.number, o.number);
            }
            return Character.compare(this.alpha, o.alpha);
        }

        @Override
        public boolean equals(Object o) {
            Ticket ticket = (Ticket) o;
            return alpha == ticket.alpha && number == ticket.number;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();
        output();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        ticketSequence = new PriorityQueue<>();
        tickets = new ArrayList<>();
        queue = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            Stack<Ticket> newTickets = new Stack<>();

            for (int j = inputs.length - 1; j >= 0; j--) {
                char alpha = inputs[j].split("-")[0].charAt(0);
                int number = Integer.parseInt(inputs[j].split("-")[1]);

                newTickets.push(new Ticket(alpha, number));
                ticketSequence.add(new Ticket(alpha, number));
            }

            tickets.add(newTickets);
        }
    }

    private static void solve() {
        for (Stack<Ticket> ticket : tickets) {
            while (!ticket.isEmpty()) {
                if (queue.isEmpty()) {
                    queue.add(ticket.pop());
                } else if (ticket.peek().equals(ticketSequence.peek())) {
                    ticket.pop();
                    ticketSequence.poll();
                } else if (queue.peek().equals(ticketSequence.peek())) {
                    queue.pop();
                    ticketSequence.poll();
                } else {
                    queue.push(ticket.pop());
                }
            }
        }

        result = "GOOD";
        while (!queue.isEmpty()) {
            if (queue.peek().equals(ticketSequence.peek())) {
                queue.pop();
                ticketSequence.poll();
            }else {
                result = "BAD";
                return;
            }
        }
    }

    private static void output() {
        System.out.println(result);
    }
}