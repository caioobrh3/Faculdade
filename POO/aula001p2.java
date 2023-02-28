package POO;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class aula001p2 {

	public static void main(String[] args) {
	       Scanner scanner = new Scanner(System.in);
	        System.out.println("Por favor, informe a data de nascimento no formato dd/MM/yyyy:");
	        String dataNascimento = scanner.nextLine();

	        LocalDate data = LocalDate.parse(dataNascimento, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	        Period idade = Period.between(data, LocalDate.now());
	        System.out.printf("Sua idade é %d anos, %d meses e %d dias.", idade.getYears(), idade.getMonths(), idade.getDays());

	        scanner.close();

	}

}
