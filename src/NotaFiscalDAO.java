
public class NotaFiscalDAO  implements AcaoAposGerarNota{

	public void persiste(NotaFiscal nf) {
		
	}

	@Override
	public void executa(NotaFiscal nf) {
		persiste(nf);
	}

}
