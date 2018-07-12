package oliveiradev.br.livromaterialdesign.data.mocks

import java.util.Arrays

import oliveiradev.br.livromaterialdesign.R
import oliveiradev.br.livromaterialdesign.data.models.Hero

object HeroesMock {

    val heroesList: List<Hero>
        get() = Arrays.asList(
                Hero("Batman", R.drawable.batman_profile, "Héroi sombrio de Gothan City, Lider da Liga, ou talvez o mais temido.."),
                Hero("Mulher Maravilha", R.drawable.mulher_profile, "Filha de Zeus, heroina da primeira guerra, em quesitos de combate é completa."),
                Hero("Asa Noturna", R.drawable.asa_profile, "Primeiro robin, cotado para ser o futuro Homem Morcego."),
                Hero("Flash", R.drawable.flash_profile, "Super velocidade, capaz de contrariar as leis da fisica e até mesmo viajar pelo tempo.")
        )
}
