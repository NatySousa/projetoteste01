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

	// fun��o de teste para cadastrar funcion�rio com sucesso
	@Test
	public void testCadastroDeFuncionarioComSucesso() {

		// executando o driver no googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// Abrindo o navegador GoogleChrome
		WebDriver driver = new ChromeDriver();

		// maximizar o navegador
		driver.manage().window().maximize();

		// acessar a p�g do sistema que ser� testada
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio01");

		// preecher o campo nome do funcion�rio
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Nat�lia Sousa");

		// preencher o campo data de admiss�o do funcion�rio
		driver.findElement(By.xpath("//*[@id=\"DataAdmissao\"]")).sendKeys("19/10/2021");

		// preecher o campo cpf do funcion�rio
		driver.findElement(By.xpath("//*[@id=\"CPF\"]")).sendKeys("123.456.789-10");

		// preencher o campo resumo de atividades
		driver.findElement(By.xpath("//*[@id=\"ResumoAtividades\"]")).sendKeys("Programadora de sistemas");

		// clicar no bot�o cadastrar funcion�rio
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// capturar a mensagem obtida no sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// comparando se a mensagem obtida do sistema � "Funcion�rio cadastrado com
		// sucesso"
		assertEquals(mensagem, "Funcion�rio cadastrado com sucesso");

		try {
			// o selenium ir� fazer um print da tela e armazenar em mem�ria
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_teste\\Cadastro de funcion�rio com sucesso.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// fechar o navegador
		driver.close();
		driver.quit();

	}

	// fun��o de teste para valida��o de campos obrigat�rios

	@Test
	public void testValidacaoDeCamposObrigatorios() {

		// executando o driver no googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// Abrindo o navegador GoogleChrome
		WebDriver driver = new ChromeDriver();

		// maximizar o navegador
		driver.manage().window().maximize();

		// acessar a p�g do sistema que ser� testada
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio01");

		// clicar no bot�o cadastrar funcion�rio
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// capturar a mensagem de erro exibidas no sistema
		String erroNome = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[1]/span")).getText();
		String erroDataAdmissao = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[1]/span"))
				.getText();
		String erroCpf = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div[2]/span")).getText();
		String erroResumoAtividades = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div[2]/span"))
				.getText();

		// comparando se o resultado esperado � igual ao obtido
		assertEquals(erroNome, "Informe o nome do funcion�rio.");
		assertEquals(erroDataAdmissao, "Informe a data de admiss�o do funcion�rio.");
		assertEquals(erroCpf, "Informe o cpf do funcion�rio.");
		assertEquals(erroResumoAtividades, "Informe o resumo de atividades do funcion�rio");
		
		try {
			// o selenium ir� fazer um print da tela e armazenar em mem�ria
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_teste\\Valida��o de campos obrigat�rios.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		// fechar o navegador
				driver.close();
				driver.quit();

	}

}
