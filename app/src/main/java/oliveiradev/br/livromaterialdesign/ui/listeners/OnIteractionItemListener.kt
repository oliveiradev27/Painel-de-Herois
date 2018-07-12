package oliveiradev.br.livromaterialdesign.ui.listeners

import android.os.Bundle
import android.view.View

interface OnIteractionItemListener<T> {
    fun onClickItem(view : View, item: T)
}