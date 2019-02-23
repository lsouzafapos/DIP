import java.util.List;

public class GeradorDeNotaFiscal {

//	private final EnviadorDeEmail email;
//	private final NotaFiscalDAO dao;

//	public GeradorDeNotaFiscal(EnviadorDeEmail email, NotaFiscalDAO dao) {
//		super();
//		this.email = email;
//		this.dao = dao;
//	}

	private final List<AcaoAposGerarNota> acoes;

	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes) {
		this.acoes = acoes;
	}

	public NotaFiscal gera(Fatura fatura) {

		double valor = fatura.getValorMensal();

		NotaFiscal nf = new NotaFiscal(valor, impostoSimplesSobre0(valor));

		for (AcaoAposGerarNota acao : acoes) {
			acao.executa(nf);
		}
//		email.enviaEmail(nf);
//		dao.persiste(nf);
		return nf;

	}

	private Object impostoSimplesSobre0(double valor) {
		return valor * 0.06;
	}
}
