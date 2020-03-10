package com.example.pyxis

import android.content.Intent
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

        btnSignup.setOnClickListener {
            startActivity(Intent(this@MainActivity, SignupActivity::class.java))
        }

        btnSurf.setOnClickListener {
            startActivity(Intent(this@MainActivity, WebActivity::class.java))
        }

        val content = arrayOf(
            Content("Tema verdadeiramente escuro.", "Economize bateria e tenha mais conforto ao navegar na web.", R.drawable.iconmoon),
            Content("Liberdade para customizar.", "Suas preferências ficam salvas para cada novo acesso.", R.drawable.iconconfig),
            Content("Pesquisa ao seu alcance.", "Operação com uma mão é prioridade e comodidade.", R.drawable.iconsearch)
        )

        addDots(content.size)

        vwpContent.adapter = OnboardingAdapter(content)
        vwpContent.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                addDots(content.size, position)
            }

        })
    }

    private fun addDots(size: Int, position: Int = 0){
        dots.removeAllViews()
        Array(size){
            val textView = TextView(baseContext).apply {
                text = getText(R.string.dots)
                textSize = 30f
                setTextColor(
                    if (position == it) ContextCompat.getColor(baseContext, android.R.color.white)
                    else ContextCompat.getColor(baseContext, android.R.color.darker_gray))
            }
            dots.addView(textView)
        }
    }

    private inner class OnboardingAdapter (val content: Array<Content>) : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = layoutInflater.inflate(R.layout.main_content, container, false)

            with(content[position]){
                view.txvContent.text = title
                view.txvContentDescription.text = subtitle
                view.imgContentImage.setImageResource(img)
            }

            container.addView(view)

            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun getCount(): Int = content.size
    }
}