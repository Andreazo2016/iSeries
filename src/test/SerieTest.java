import iseries.App;
import iseries.model.Episodio;
import iseries.model.Serie;
import iseries.model.Temporada;
import iseries.repository.SerieRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={App.class})
public class SerieTest {
    private Serie serie;
    private List<Temporada> temporadas;
    private List<Episodio> episodios;

    @Autowired private SerieRepository serieRepository;
    @Before
    public void init(){
        serieRepository.deleteAll();
        this.temporadas = new ArrayList<Temporada>();
        this.episodios = new ArrayList<Episodio>();
        //add episodios
        this.episodios.add(new Episodio(null,"Prologo"));
        this.episodios.add(new Episodio(null,"firt time"));
        this.episodios.add(new Episodio(null,"second time"));
        //add tempodaras
        Temporada temporada = new Temporada(null,"10","10",null,episodios);

        serie = new Serie(null,"Demolidor","Marvel","Netflix","Ação","Filme de Heroi","2016","/dardevil",temporadas);
        temporada.setSerie(serie);
        serie.getTemporadas().add(temporada);
    }

    @Test
    public void verificarSeSalvouSeries(){
        Serie serieSalva = serieRepository.save(serie);
        Assert.assertEquals(serieSalva.getNome(),"Demolidor");
        Assert.assertEquals(serieSalva.getDiretor(),"Marvel");
        Assert.assertEquals(serieSalva.getGenero(),"Ação");

        Assert.assertEquals(serieSalva.getTemporadas().size(),1);
        Temporada temporada = serieSalva.getTemporadas().get(0);
        Assert.assertEquals(temporada.getEpisodios().size(),3);
    }


}
