import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Renda anual com salário: ");
        double salarioAnual = sc.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        double prestacaoServico = sc.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        double rendaGanhoCapital = sc.nextDouble();
        System.out.print("Gastos médicos: ");
        double gastosMedicos = sc.nextDouble();
        System.out.print("Gastos educacionais: ");
        double gastosEdu = sc.nextDouble();
        System.out.println("\n RELATÓRIO DE IMPOSTO DE RENDA\n");
        System.out.println("CONSOLIDADO DE RENDA:");

        // Calcular imposto do salario anual
        double salarioMensal = salarioAnual / 12;
        double impostoSobSalario = 0.00;
        if (salarioMensal < 3000.00) {
            impostoSobSalario = impostoSobSalario;
        } else if (salarioMensal < 5000.00) {
            impostoSobSalario = salarioAnual * 0.1;
        } else {
            impostoSobSalario = salarioAnual * 0.2;
        }
        //Imposto sobre serviços
        double impostoSobrePrestacaoServico = prestacaoServico * 0.15;
        //Imposto sobre ganho de capital
        double impostoGanhoDeCapital = rendaGanhoCapital * 0.2;

        System.out.printf("Imposto sobre salário: %.2f%n", impostoSobSalario);
        System.out.printf("Imposto sobre serviços: %.2f%n", impostoSobrePrestacaoServico);
        System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoGanhoDeCapital);

        System.out.println("\nDEDUÇÕES:");
        double impostoBrutoTotal = impostoSobSalario + impostoSobrePrestacaoServico + impostoGanhoDeCapital;

        double gastosDedutiveis = gastosMedicos + gastosEdu;
        double maximoDedutivel = impostoBrutoTotal * 0.3;

        double abatimento = (maximoDedutivel < gastosDedutiveis) ? maximoDedutivel : gastosDedutiveis;
        //Calcular imposto devido
        double impostoBrutoDevido = 0.00;
        if (gastosDedutiveis > maximoDedutivel) {
            impostoBrutoDevido = impostoBrutoTotal - maximoDedutivel;
        } else {
            impostoBrutoDevido = impostoBrutoTotal - gastosDedutiveis;
        }
        System.out.printf("Máximo dedutível: %.2f%n", maximoDedutivel);
        System.out.printf("Gastos dedutíveis %.2f%n", gastosDedutiveis);
        System.out.println("\nRESUMO:");
        System.out.printf("Imposto bruto total: %.2f%n", impostoBrutoTotal);
        System.out.printf("Abatimento: %.2f%n", abatimento);
        System.out.printf("Imposto devido: %.2f%n", impostoBrutoDevido);
        sc.close();
    }
}