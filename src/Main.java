import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();

        Evento evento = new Evento("Entrega da atividade", LocalDateTime.of(data, hora), DiaDaSemana.TERCA);
        evento.exibirEvento();

        System.out.println();
        evento.adiarEventoEmDias(5);
        System.out.println("Evento ADIADO:");
        evento.exibirEvento();

        System.out.println();
        //Evento convertido para o fuso horario de SP
        System.out.println("Horario do evento no fuso horario de São Paulo: ");
        evento.converterFusoParaSP();
        evento.exibirEvento();

        System.out.println();
        //Evento convertido para o fuso horario de GMT
        System.out.println("Horario do evento no fuso horario GMT: ");
        evento.converterFusoParaGMT();
        evento.exibirEvento();

    }

}
