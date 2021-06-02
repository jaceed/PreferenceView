package com.jacee.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import com.github.jaceed.extender.view.content
import com.github.jaceed.extender.view.visible
import com.jacee.widget.preferenceview.R

/**
 * Created by Jacee.
 * Date: 2021.03.31
 */
class PreferenceView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var icon: Drawable?
    private var iconPadding: Int = -1
    private var title: CharSequence?
    private var titleColor: Int = 0
    private var titleSize: Int = 0
    private var titleLabel: Drawable?
    private var description: CharSequence?
    private var descriptionColor: Int = 0
    private var descriptionSize: Int = 0
    private var stateIcon: Drawable?
    private var stateIconTint: Int = -1
    private var type: Int
    private var preferencePaddingLeft: Int = -1
    private var preferencePaddingRight: Int = -1

    private lateinit var guideLeft: Guideline
    private lateinit var guideRight: Guideline
    private lateinit var iconView: ImageView
    private lateinit var titleView: TextView
    private lateinit var titleLabelView: ImageView
    private lateinit var descView: TextView
    private lateinit var stateIconView: ImageView
    private lateinit var switchView: SwitchCompat

    private val paddingLR by lazy {
        resources.getDimensionPixelSize(R.dimen.preference_padding_lr)
    }


    init {
        LayoutInflater.from(context).inflate(R.layout.view_preference, this, true)

        val a = context.obtainStyledAttributes(attrs, R.styleable.PreferenceView, defStyleAttr, defStyleRes)
        icon = a.getDrawable(R.styleable.PreferenceView_preferenceIcon)
        iconPadding = a.getDimensionPixelSize(R.styleable.PreferenceView_preferenceIconPadding, resources.getDimensionPixelSize(R.dimen.preference_icon_padding))
        title = a.getString(R.styleable.PreferenceView_preferenceTitle)
        titleColor = a.getColor(R.styleable.PreferenceView_preferenceTitleColor, resources.getColor(R.color.preference_title_color))
        titleSize = a.getDimensionPixelSize(R.styleable.PreferenceView_preferenceTitleSize, resources.getDimensionPixelSize(R.dimen.preference_title_size_default))
        titleLabel = a.getDrawable(R.styleable.PreferenceView_preferenceTitleLabel)
        description = a.getString(R.styleable.PreferenceView_preferenceDesc)
        descriptionColor = a.getColor(R.styleable.PreferenceView_preferenceDescColor, resources.getColor(R.color.preference_desc_color))
        descriptionSize = a.getDimensionPixelSize(R.styleable.PreferenceView_preferenceDescSize, resources.getDimensionPixelSize(R.dimen.preference_desc_size_default))
        stateIcon = a.getDrawable(R.styleable.PreferenceView_preferenceStateIcon)
        stateIconTint = a.getColor(R.styleable.PreferenceView_preferenceStateIconTint, Color.GRAY)
        type = a.getInt(R.styleable.PreferenceView_preferenceType, TYPE_NORMAL)
        preferencePaddingLeft = a.getDimensionPixelSize(R.styleable.PreferenceView_preferencePaddingLeft, paddingLR)
        preferencePaddingRight = a.getDimensionPixelSize(R.styleable.PreferenceView_preferencePaddingRight, paddingLR)
        a.recycle()
    }

    private fun refresh() {
        iconView.visible = icon != null
        if (iconView.visible) {
            iconView.setImageDrawable(icon)
            iconView.setPadding(iconView.paddingLeft, iconView.paddingTop, iconPadding, iconView.paddingBottom)
        }

        titleView.text = title
        titleView.setTextColor(titleColor)
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleSize.toFloat())

        titleLabelView.content = titleLabel

        if (type == TYPE_NORMAL) {
            descView.content = description
            descView.setTextColor(descriptionColor)
            descView.setTextSize(TypedValue.COMPLEX_UNIT_PX, descriptionSize.toFloat())
            stateIconView.content = stateIcon
            if (stateIconTint != -1) {
                stateIconView.imageTintList = ColorStateList.valueOf(stateIconTint)
            }
            switchView.visible = false
        } else {
            descView.visible = false
            stateIconView.visible = false
            switchView.visible = true
        }

        guideLeft.setGuidelineBegin(preferencePaddingLeft)
        guideRight.setGuidelineEnd(preferencePaddingRight)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        guideLeft = findViewById(R.id.lg)
        guideRight = findViewById(R.id.rg)
        iconView = findViewById(R.id.icon)
        titleView = findViewById(R.id.title)
        titleLabelView = findViewById(R.id.title_label)
        descView = findViewById(R.id.desc)
        stateIconView = findViewById(R.id.state_icon)
        switchView = findViewById(R.id.switch_btn)

        refresh()
    }


    companion object {
        private const val TYPE_NORMAL = 0
        private const val TYPE_SWITCH = 1
    }


}