package oliveiradev.br.livromaterialdesign.ui.activities

import android.os.Build
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_hero_content.*
import oliveiradev.br.livromaterialdesign.R
import oliveiradev.br.livromaterialdesign.data.models.Hero

class HeroContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val transitionInflater = TransitionInflater.from(this)
            val transition
                    = transitionInflater.inflateTransition(R.transition.some_transition)
            window.sharedElementEnterTransition = transition
            window.sharedElementExitTransition = transition
            window.sharedElementEnterTransition
                    .addListener(object : Transition.TransitionListener {
                        override fun onTransitionStart(transition: Transition) {}

                        override fun onTransitionEnd(transition: Transition) {
                            setVisibilityViews()
                        }

                        override fun onTransitionCancel(transition: Transition) {}

                        override fun onTransitionPause(transition: Transition) {}

                        override fun onTransitionResume(transition: Transition) {}
                    })
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_content)
        if (actionBar != null) actionBar.hide()
        val hero = intent.getParcelableExtra<Hero>("hero")
        bindView(hero)
    }

    private fun setVisibilityViews() {
        textLabelDescription.visibility = View.VISIBLE
        textDescription.visibility = View.VISIBLE
    }

    private fun bindView(hero: Hero) {
        textName.text = hero.name
        textDescription.text = hero.description
        imageHero.setImageDrawable(ResourcesCompat.getDrawable(resources, hero.imgProfile, null))
    }
}
