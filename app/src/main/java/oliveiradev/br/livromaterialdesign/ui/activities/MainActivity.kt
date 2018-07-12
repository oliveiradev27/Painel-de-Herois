package oliveiradev.br.livromaterialdesign.ui.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.transition.TransitionInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import oliveiradev.br.livromaterialdesign.R
import oliveiradev.br.livromaterialdesign.data.mocks.HeroesMock
import oliveiradev.br.livromaterialdesign.data.models.Hero
import oliveiradev.br.livromaterialdesign.ui.adapters.HeroesAdapter
import oliveiradev.br.livromaterialdesign.ui.listeners.OnIteractionItemListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val transitionInflater = TransitionInflater.from(this)
            val transition
                    = transitionInflater.inflateTransition(R.transition.some_transition)
            window.sharedElementExitTransition = transition
            window.sharedElementReenterTransition = transition
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
    }

    private fun setAdapter() {
        recyclerViewHeros.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = HeroesAdapter(HeroesMock.heroesList, getInteractionItemListener())
        recyclerViewHeros.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun getInteractionItemListener(): OnIteractionItemListener<Hero> {
        return object : OnIteractionItemListener<Hero> {

            override fun onClickItem(view: View, item: Hero) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val imageProfile = view.findViewById<View>(R.id.imageProfile)
                    val textName = view.findViewById<View>(R.id.textName)

                    val optionsCompat
                            = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this@MainActivity,
                            Pair.create(imageProfile, "imageProfile"),
                            Pair.create(textName, "textName"))
                    val intent = Intent(this@MainActivity,
                            HeroContentActivity::class.java)
                    intent.putExtra("hero", item)
                    startActivity(intent, optionsCompat.toBundle())
                }
            }

        }
    }
}
