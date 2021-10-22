package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroDeFuncionariosTest {

	// função de teste para cadastrar funcionário com sucesso
	@Test
	public void testCadastroDeFuncionarioComSucesso() {

		// executando o driver no googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// Abrindo o navegador GoogleChrome
		WebDriver driver = new ChromeDriver();

		// maximizar o navegador
		driver.manage().window().maximize();

		// acessar a pág do sistema que será testada
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio01");

		// preecher o campo nome do funcionário
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Natália Sousa");

		// preencher o campo data de admissão do funcionário
		driver.findElement(By.xpath("//*[@id=\"DataAdmissao\"]")).sendKeys("19/10/2021");

		// preecher o campo cpf do funcionário
		driver.findElement(By.xpath("//*[@id=\"CPF\"]")).sendKeys("123.456.789-10");

		// preencher o campo resumo de atividades
		driver.findElement(By.xpath("//*[@id=\"ResumoAtividades\"]")).sendKeys("Programadora de sistemas");

		// clicar no botão cadastrar funcionário
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// capturar a mensagem obtida no sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// comparando se a mensagem obtida do sistema é "Funcionário cadastrado com
		// sucesso"
		assertEquals(mensagem, "Funcionário cadastrado com sucesso");

		try {
			// o selenium irá fazer um print da tela e armazenar em memória
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_teste\\Cadastro de funcionário com sucesso.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// fechar o navegador
		driver.close();
		driver.quit();

	}

	// função de teste para validação de campos obrigatórios

	@Test
	public void testValidacaoDeCamposObrigatorios() {

		// executando o driver no googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// Abrindo o navegador GoogleChrome
		WebDriver driver = new ChromeDriver();

		// maximizar o navegador
		driver.manage().window().maximize();

		// acessar a pág do sistema que será testada
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio01");

		// clicar no botão cadastrar funcionário
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// capturar a mensagem de erro exibidas no sistema
		String erroNome = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[1]/span")).getText();
		String erroDataAdmissao = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[1]/span"))
				.getText();
		String erroCpf = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[2]/span")).getText();
		String erroResumoAtividades = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[2]/span"))
				.getText();

		// comparando se o resultado esperado é igual ao obtido
		assertEquals(erroNome, "Informe o nome do funcionário.");
		assertEquals(erroDataAdmissao, "Informe a data de admissão do funcionário.");
		assertEquals(erroCpf, "Informe o cpf do funcionário.");
		assertEquals(erroResumoAtividades, "Informe o resumo de atividades do funcionário");
		
		try {
			// o selenium irá fazer um print da tela e armazenar em memória
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_teste\\Validação de campos obrigatórios.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		// fechar o navegador
				driver.close();
				driver.quit();

	}

}
