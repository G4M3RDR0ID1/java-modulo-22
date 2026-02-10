import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {

  private String nome;
  private LocalDateTime dataHora;
  private DiaDaSemana diaDaSemana;

    private void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    private void setDataHora(ZonedDateTime dataHora) {
        this.dataHora = dataHora.toLocalDateTime();
    }

    public Evento(String nome, LocalDateTime dataHora, DiaDaSemana diaDaSemana) {
        this.nome = nome;
        this.dataHora = dataHora;
        this.diaDaSemana = diaDaSemana;
    }

    public void exibirEvento(){

        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter horaFormatada = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("O evento: " + nome
                + " | Ocorrera em um(a) : " + diaDaSemana
                + " | Na data: " + dataHora.format(dataFormatada)
                + " | Horario: " + dataHora.format(horaFormatada));
    }

    public void adiarEventoEmDias(int diasAdiados){
        setDataHora(dataHora.plusDays(diasAdiados));
    }

    public void converterFusoParaSP(){
        ZoneId sp = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime zonedAtual = dataHora.atZone(ZoneId.systemDefault());
        ZonedDateTime convertido = zonedAtual.withZoneSameInstant(sp);

        setDataHora(convertido);
    }
    public void converterFusoParaGMT(){
        ZoneId gmt = ZoneId.of("GMT");

        ZonedDateTime zonedAtual = dataHora.atZone(ZoneId.systemDefault());
        ZonedDateTime convertido = zonedAtual.withZoneSameInstant(gmt);

        setDataHora(convertido);
    }

}
