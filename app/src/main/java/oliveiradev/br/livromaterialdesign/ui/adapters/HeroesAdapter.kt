package oliveiradev.br.livromaterialdesign.ui.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import oliveiradev.br.livromaterialdesign.R
import oliveiradev.br.livromaterialdesign.data.models.Hero
import oliveiradev.br.livromaterialdesign.ui.listeners.OnIteractionItemListener

class HeroesAdapter(private var heroes: List<Hero>, private var listener: OnIteractionItemListener<Hero>)
    : RecyclerView.Adapter<HeroesAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val context = parent.context
        val inflate = LayoutInflater.from(context)
        val view = inflate.inflate(R.layout.item_card_hero, parent, false)

        return HeroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bindData(heroes[position], listener)
    }

    class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageProfile: ImageView = itemView.findViewById(R.id.imageProfile)
        val cardHeroInfo: CardView = itemView.findViewById(R.id.cardHeroInfo)
        val linearContentHeroCard: LinearLayout = itemView.findViewById(R.id.linearContentHeroCard)
        val textName : TextView = itemView.findViewById(R.id.textName)

        fun bindData(hero: Hero, listener: OnIteractionItemListener<Hero>) {
            imageProfile.setImageResource(hero.imgProfile)
            textName.text = hero.name
            imageProfile.setOnClickListener {
                listener.onClickItem(itemView, hero)
            }
        }
    }
}