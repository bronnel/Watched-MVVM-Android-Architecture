package br.com.watched.util

import br.com.watched.model.domain.SearchResponseVO

/**
 * Created by thiagozg on 12/11/2017.
 */
interface UIListeners {

    interface OnClickListener {
        fun onClick(resultVO: SearchResponseVO.ResultVO)
    }

}