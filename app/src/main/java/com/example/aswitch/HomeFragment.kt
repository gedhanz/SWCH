package com.example.aswitch

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread
import androidx.fragment.app.Fragment
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.Marker.SIZE_AUTO
import com.naver.maps.map.overlay.Overlay
import com.naver.maps.map.util.MarkerIcons


class HomeFragment : Fragment(), OnMapReadyCallback {
    private lateinit var naverMap: NaverMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fm = childFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map, it).commit()
            }
        mapFragment.getMapAsync(this)
    }
    @UiThread
    override fun onMapReady(nMap: NaverMap) {
        naverMap = nMap
        naverMap.cameraPosition =
            CameraPosition(LatLng(37.38026082219308, 126.80284869843071), 12.0)
        val marker1 = Marker().apply { //진애연
            position = LatLng(37.3883047674791, 126.736904128563)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.BLUE
        }
        //marker1.onClickListener = Overlay.OnClickListener {
            //var intent = Intent(context, WindowInfo::class.java)
            //var url = "https://www.naver.co.kr/"
            //intent.putExtra("Url",url)
            //startActivity(intent)
            //false
        //}

        val marker2 = Marker().apply {//풍차횟집
            position = LatLng(37.3480116592429, 126.688915265611)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.BLUE
        }
        val marker3 = Marker().apply {//고기와면
            position = LatLng(37.3809332379338, 126.800848424051)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.RED
        }
        val marker4 = Marker().apply {//엉터리생고기
            position = LatLng(37.3453235794196, 126.736862306960)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.RED
        }
        val marker5 = Marker().apply {//명동칼국수
            position = LatLng(37.3449173281097, 126.737521112612)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.WHITE
        }
        val marker6 = Marker().apply {//소양강회집
            position = LatLng(37.3481171954859, 126.689645605024)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.BLUE
        }
        val marker7 = Marker().apply {//우강
            position = LatLng(37.3512837432112, 126.722992868695)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.RED
        }
        val marker8 = Marker().apply {//샤브린
            position = LatLng(37.3449173281097, 126.737521112612)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.YELLOW
        }
        val marker9 = Marker().apply {//버섯생농장
            position = LatLng(37.3460624708384, 126.733863347972)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.LTGRAY
        }
        val marker10 = Marker().apply {//등대횟집
            position = LatLng(37.3464919470019, 126.688351599755)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.BLUE
        }
        val marker11 = Marker().apply {//오도로
            position = LatLng(37.3438118227765, 126.736734977879)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.YELLOW
        }
        val marker12 = Marker().apply {//우촌
            position = LatLng(37.3519020955018, 126.722522199719)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.RED
        }
        val marker13 = Marker().apply {//큰손오리농장
            position = LatLng(37.3409742030580, 126.690464953318)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.YELLOW
        }
        val marker14 = Marker().apply {//8.14바베큐
            position = LatLng(37.3468452026392, 126.734348701346)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.YELLOW
        }
        val marker15 = Marker().apply {//고기한판
            position = LatLng(37.3640320962970, 126.730291998549)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.RED
        }
        val marker16 = Marker().apply {//오이도회조개구이
            position = LatLng(37.3480352566775, 126.690182031367)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.BLUE
        }
        val marker17 = Marker().apply {//미다미
            position = LatLng(37.3531276111426, 126.721614740415)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.YELLOW
        }
        val marker18 = Marker().apply {//929숯불닭갈비 시흥점
            position = LatLng(37.3528045240969, 126.724084922879)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.YELLOW
        }
        val marker19 = Marker().apply {//더베이징
            position = LatLng(37.3431836002875, 126.734827121838)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.YELLOW
        }
        val marker20 = Marker().apply {//신의한소
            position = LatLng(37.3698395012101, 126.730426438967)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.RED
        }
        val marker21 = Marker().apply {//여수횟집
            position = LatLng(37.3462506947154, 126.688265131764)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.BLUE
        }
        val marker22 = Marker().apply {//조선우
            position = LatLng(37.3778827237522, 126.725246332808)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.RED
        }
        val marker23 = Marker().apply {//미래아구찜
            position = LatLng(37.3698395012101, 126.730426438967)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.YELLOW
        }
        val marker24 = Marker().apply {//보리네생고깃간 신천점
            position = LatLng(37.4383334052142, 126.792145402397)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.RED
        }
        val marker25 = Marker().apply {//흙과사람들
            position = LatLng(37.4438432204480, 126.792212090167)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.LTGRAY
        }
        val marker26 = Marker().apply {//백년회관서서갈비시흥대야점
            position = LatLng(37.4432741168365, 126.791380259483)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.YELLOW
        }
        val marker27 = Marker().apply {//한촌설렁탕
            position = LatLng(37.4419671000349, 126.791070307552)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.YELLOW
        }
        val marker28 = Marker().apply {//곽만근 갈비탕 시흥점
            position = LatLng(37.3702971643332, 126.809360561867)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.YELLOW
        }
        marker1.map = naverMap
        marker2.map = naverMap
        marker3.map = naverMap
        marker4.map = naverMap
        marker5.map = naverMap
        marker6.map = naverMap
        marker7.map = naverMap
        marker8.map = naverMap
        marker9.map = naverMap
        marker10.map = naverMap
        marker11.map = naverMap
        marker12.map = naverMap
        marker13.map = naverMap
        marker14.map = naverMap
        marker15.map = naverMap
        marker16.map = naverMap
        marker17.map = naverMap
        marker18.map = naverMap
        marker19.map = naverMap
        marker20.map = naverMap
        marker21.map = naverMap
        marker22.map = naverMap
        marker23.map = naverMap
        marker24.map = naverMap
        marker25.map = naverMap
        marker26.map = naverMap
        marker27.map = naverMap
        marker28.map = naverMap

    }

}