package com.example.aswitch

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naver.maps.map.MapFragment
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.util.FusedLocationSource
import android.widget.*
import androidx.annotation.UiThread
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.Marker.SIZE_AUTO
import com.naver.maps.map.util.MarkerIcons
import com.naver.maps.map.overlay.InfoWindow

class HomeFragment : Fragment(), OnMapReadyCallback {
    private lateinit var naverMap: NaverMap
    private val LOCATION_PERMISSION_REQUEST_CODE = 1000

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

        //Enable location tracking
        mapFragment.getMapAsync { naverMap ->
            // Create LocationOverlay
            val locationOverlay = naverMap.locationOverlay
            locationOverlay.isVisible = true

            naverMap.uiSettings.isLocationButtonEnabled = true

            // Set location tracking mode
            naverMap.locationSource = FusedLocationSource(this@HomeFragment.requireActivity(), LOCATION_PERMISSION_REQUEST_CODE)

            naverMap.locationTrackingMode = LocationTrackingMode.Face
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, enable location tracking
                val mapFragment =
                    childFragmentManager.findFragmentById(R.id.map) as MapFragment?
                mapFragment?.getMapAsync { naverMap ->
                    // Create LocationOverlay
                    val locationOverlay = naverMap.locationOverlay
                    locationOverlay.isVisible = true

                    naverMap.locationSource = FusedLocationSource(this@HomeFragment.requireActivity(), LOCATION_PERMISSION_REQUEST_CODE)

                    naverMap.locationTrackingMode = LocationTrackingMode.Face
                }
            }
        }
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
            iconTintColor = Color.RED
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

        var currentInfoWindow: InfoWindow? = null
        data class MarkerInfo(val name: String, val address: String, val menu: String, val phone: String, val amenity: String, val imageUrl: String )
        val markerInfoMap = mutableMapOf<Marker, MarkerInfo>()
        val marker1Info = MarkerInfo("진애연㈜", "시흥시 월곶해안로 153", "진애연특선","031-317-0998", "경사로", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA1MjlfMjEx%2FMDAxNTI3NTk5ODM4ODgz.gFiH7DtXGg1jO9C-KmZMOQUxYA5NsovuUEGIDZo-jWEg.iufrF7IkpPIg6N1joykyYuMA80BNOj_ABWH95vWy6MAg.JPEG.hsb7391922%2FDSC00834.JPG")
        markerInfoMap[marker1] = marker1Info
        val marker2Info = MarkerInfo("풍차횟집", "시흥시 오이도로 143", "생선초밥","031-499-8259", "문턱없음", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMjFfMTgg%2FMDAxNjc2OTUyNTQ1MDIz.yyCwO1srwUbqh9fhsE3z_8D22H_ttU2_N9NFhLKbfcEg.0ASt0NZt18N3LvaMNeDebLOSYxexc28XYvA08YXdC0Ag.JPEG.kangsung4682%2FKakaoTalk_20230221_125951911_21.jpg")
        markerInfoMap[marker2] = marker2Info
        val marker3Info = MarkerInfo("고기와면", "시흥시 시청로 68번길 10", "생등심","031-318-6696", "문턱없음", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA1MThfODEg%2FMDAxNDk1MDcwNDg2NTg3.I_nAc5SGV4QbLQ5i_kl4ploD131zlL9wgAK_ha3a6wUg.4bvzkdJnvbPQITHnDxmgorT12NnYHTv6EcdHLhOSlegg.JPEG.siheungblog%2F1.JPG��")
        markerInfoMap[marker3] = marker3Info
        val marker4Info = MarkerInfo("엉터리생고기", "시흥시 중심상가3길 10", "큰소한마리","031-319-6363", "문턱없음", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzEyMzFfMTMz%2FMDAxNTE0NzI4NTM2NDIx.tebkJQkjjiMTfV0lImgV5FusKs8HYXg8XEs271cijHog.Cq2RsNbENJEMXjNDc2k7Pa2qH7QgGVIOhH45occ_mrgg.JPEG.just1262%2F1514728458201.jpg")
        markerInfoMap[marker4] = marker4Info
        val marker5Info = MarkerInfo("명동칼국수", "시흥시 중심상가2길 22", "칼국수","031-431-2113", "문턱없음, 장애인 주차장", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjExMDVfMjc4%2FMDAxNjY3NjE4NDU1ODEw.apEvSMEW_Dc3cu-QoTfgkEXaRKMx0uYNP6CR3PU5JTsg._ctzwo0V_dISafNzJYZjw_8DMKiISsUXUqUIhJV9BHAg.JPEG.love_wlgo%2F20221026%25A3%25DF184354.jpg")
        markerInfoMap[marker5] = marker5Info
        val marker6Info = MarkerInfo("소양강회집", "시흥시 오이도로 131", "회, 매운탕","031-497-7773", "경사로", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjEyMDJfMTEx%2FMDAxNjY5OTU0NjM5MDk2.4BjvWTAwshYvFFoSLK5h4F4hAM7eyz7FAqN_VcGBONYg.b8qhDlLK_HfKA6eh4X2oy8XHi_Yb4n9AJ89DAwkt9wUg.JPEG.solzzang0731%2FKakaoTalk_20221127_131153831.jpg&type=sc960_832")
        markerInfoMap[marker6] = marker6Info
        val marker7Info = MarkerInfo("우강", "시흥시 옥구천서로 313", "장어구이","031-433-0592", "경사로", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA3MjRfODIg%2FMDAxNjU4NjYxNzkyMzM1.NwfqucB6uP6KU37h81rvGGJUtDyB9SIE5fBKrsAQVSkg.YOmHuFAcw3fth9SR95O9De_t6RVhHSjOzR8d5QXJ8A8g.JPEG.2sacland%2FKakaoTalk_20220724_170603658.jpg&type=sc960_832")
        markerInfoMap[marker7] = marker7Info
        val marker8Info = MarkerInfo("샤브린", "시흥시 중심상가 2길 22 로즈프라자 2층", "월남쌈소고기샤브","031-434-9988", "문턱없음, 장애인 주차장","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA4MDlfMTM5%2FMDAxNjYwMDU0NzIxNzIx.hVuNe2XCN_DQdHcOVVNvW9jUB440kFlQVoGkO_zlokYg.d7T1wC-U7qYNZAuKxcRiHN15dn7eNjtmvkPyfnHIC6Qg.JPEG.dbwls349%2Foutput_446114994.jpg&type=sc960_832")
        markerInfoMap[marker8] = marker8Info
        val marker9Info = MarkerInfo("버섯생농장", "시흥시 중심상가로 161", "큰버섯샤브샤브","031-431-4495", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MDNfNzMg%2FMDAxNjIyNzI3NTA0MjU3.UXo0xEZ6ru2WUzq-G8YYRxNgCPN-ktxdjJBNXVQ91-Ig.RXxDZLUnr6Sd17MCMLfy4bOxT_eou7nPidM6otHj9UYg.JPEG.dkemzkal%2FIMG_6743.jpg&type=sc960_832")
        markerInfoMap[marker9] = marker9Info
        val marker10Info = MarkerInfo("등대횟집", "시흥시 오이도로 161", "회","031-431-8868", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA3MTBfMjg5%2FMDAxNDk5Njc1NTIyMTg0.rO0SKRKoEPZhHmW6MzMQ6rMImyD4o9nQCik7A2HKELcg.3JedUJX7uquclUuXRbNhuXEzT_g-ALPZ_NZBHK0Esaog.JPEG.ajj2017%2F1.jpg&type=sc960_832")
        markerInfoMap[marker10] = marker10Info
        val marker11Info = MarkerInfo("오도로", "시흥시 중심상가로 198", "참치회, 탕","031-496-8897", "문턱없음","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA3MjZfMTEx%2FMDAxNTY0MTI4NDExOTY3.Lrhit7EVzv94f_dk807mMvoobJi4wuu5JO_onSRG-IMg.PqBmuaZRdDWHhMIMA-Dsmx_qes6meQwQk_GkCvTJBN8g.JPEG.chuai0930%2F20190725_185700.jpg&type=sc960_832")
        markerInfoMap[marker11] = marker11Info
        val marker12Info = MarkerInfo("우촌", "시흥시 옥구상가4길 8-5", "돼지갈비","031-416-7799", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjEwMTVfNzQg%2FMDAxNjY1ODEyMzMxODA1.oZf9Lra--EypXPiZMaLUhb-BksjigvqtAM1MpAXNsQYg.Go9W6kk-NDVQFo1qNg-C47LyxydVe72Hfzp8XpTM8j8g.JPEG.dlagmlwn9602%2F1665812009609.jpg&type=sc960_832")
        markerInfoMap[marker12] = marker12Info
        val marker13Info = MarkerInfo("큰손오리농장", "시흥시 옥터로 79", "오리탕","031-431-6477", "문턱없음","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTAzMDVfMjc1%2FMDAxNTUxNzQyMDk5MjY4.fJ5mhLaMlZ8gItkacf6HwL3mw_zdL_3x_DcAZKIxmhYg.ME1jKnFrVk7KCQ9imaWB-f78vZ2wheb2zPSD20KEsEYg.JPEG.ksgbike%2FDSC03280.JPG&type=a340")
        markerInfoMap[marker13] = marker13Info
        val marker14Info = MarkerInfo("8.14바베큐", "시흥시 서촌상가 3길 5", "갈비","031-319-2255", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDEwMDNfNTIg%2FMDAxNjAxNzMxMTQ2NzE2.2jg2QQxVubdV5W85NyFBh6cFAn3owt3N4zPKCLnfUnYg.xP4AqNXWrQiq9hx-IoC2SNn2lhysavsbs2NRRf0rwZog.JPEG.chodager%2FDSC_6098.jpg&type=sc960_832")
        markerInfoMap[marker14] = marker14Info
        val marker15Info = MarkerInfo("고기한판", "시흥시 함송으로 15, 202호", "소갈비","031-497-9228", "문턱없음, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjEwMTFfMTM4%2FMDAxNjY1NDU3NTQwOTI1.KbQbPwVrZwLTkcFh0Ow9nHAR56lkJre7bNUJdmsWrqQg.3UTrxB4qTuvVJ1LxLVbKMMKE5l4RxMjIhLqOCqiJyRsg.JPEG.cjcfam%2F20221008%25A3%25DF192350.jpg&type=sc960_832")
        markerInfoMap[marker15] = marker15Info
        val marker16Info = MarkerInfo("오이도회조개구이", "시흥시 오이도로 127", "회, 조개구이","031-499-9793", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODExMTFfNTgg%2FMDAxNTQxOTM5MTc1NjU0.Bb6WWFsmrYII9r-j2X0jghw-ZRR_QTnEg7qlqawQv-Eg.O_8ei5ucw3SuG0ivmtQQ8WJpNEjI8AHSgBwAGdUk9GMg.JPEG.emforl1%2F1.jpg&type=sc960_832")
        markerInfoMap[marker16] = marker16Info
        val marker17Info = MarkerInfo("미다미", "시흥시 옥구상가1길 23", "회","031-433-3772", "문턱없음","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTAzMDVfMjA0%2FMDAxNTUxNzg3MzAxOTYw.0hL1MfKWQGKRz2JOA7mD0sFsuPx0OUfvdeTZwwKc69gg.Yd6XgQgVUMfhU3ffi_IGJMzR6OICWe21Q4990nRXQQgg.JPEG.326iloveu%2F2019-03-02-17-21-12.jpg&type=sc960_832")
        markerInfoMap[marker17] = marker17Info
        val marker18Info = MarkerInfo("929숯불닭갈비 시흥점", "시흥시 옥구상가 3길 7-5", "숯불닭갈비","031-496-9290", "경사로, 장애인 주차장","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA2MjlfNzQg%2FMDAxNDk4NjY0NjkyOTc4.SSxBqLsal1179x-0B-qUwJEzHE9pszgz-rU8C6ColrIg._Nn7E1Wh4urZB6AB5CDu5ghuZfs2ADzoFK8N4gY7DCkg.JPEG.taemoms%2FIMG_4605.JPG&type=a340")
        markerInfoMap[marker18] = marker18Info
        val marker19Info = MarkerInfo("더베이징", "시흥시 중심상가1길 14", "짜장면","031-319-4289", "문턱없음, 장애인 주차장","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMjZfMjcg%2FMDAxNjc3Mzk1NjY5OTAw.Dw9iI0JHACpVQUZmjstaPfYmjoP7DJwXL0b8M5gWHO8g.BYmt0WKGsCHSJbFjTwOSq_crjdwznX32suRCiejF6hkg.JPEG.love_wlgo%2F20230226%25A3%25DF132334.jpg&type=l340_165")
        markerInfoMap[marker19] = marker19Info
        val marker20Info = MarkerInfo("신의한소", "시흥시 배곧 3로 96", "삼겹살","0507-1406-4988", "문턱없음, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MDRfMTkz%2FMDAxNjIyNzkwNjMyNjAy.U5qvjvtuqHAVHCctlHAIAohTLPGd2qvF03ONJYtVF5Ag.Dtn9LT0sV_yhbLh1LZ46HTQQs5654F1RmX99QkFuqsAg.JPEG.4u4me1214%2FKakaoTalk_20210604_160212702.jpg&type=sc960_832")
        markerInfoMap[marker20] = marker20Info
        val marker21Info = MarkerInfo("여수횟집", "시흥시 오이도로 163((시흥시 정왕동)", "회","031-497-3827", "문턱없음","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODEyMTVfMTQz%2FMDAxNTQ0ODQxMjczMTI4.0kKe_P-UP-gVtwRTgX_S7m99hx3DvWiVQePwu7hkYmog.F9vQ409jdPSqfxnTvekOxA0DkzB6m7rM1B7HswN1Tk0g.JPEG.franchise09%2FKakaoTalk_20181215_110234100.jpg&type=sc960_832")
        markerInfoMap[marker21] = marker21Info
        val marker22Info = MarkerInfo("조선우", "시흥시 배곧4로32-29, 113,114호(시흥시 정왕동)", "소고기","031-432-1001", "문턱없음, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDEwMDFfMjM0%2FMDAxNjAxNTMxOTM3Nzk5._sx2sy_ZmTayn10UjOivLWf6vr1Y4tqH6kmEzMzd-0sg.VisHbPds_ekh3MjvjwV8OpxdwhR_o3Y6MXpARTkNCl4g.JPEG.relax7798%2FIMG_5244.JPG&type=sc960_832")
        markerInfoMap[marker22] = marker22Info
        val marker23Info = MarkerInfo("미래아구찜", "시흥시 배곧3로96, 201호(시흥시 정왕동)", "아구찜","031-432-6664", "문턱없음, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA2MTJfMjU1%2FMDAxNTI4NzczOTU3ODA5.Q3junADApHTyKP8BHI5ddBqW9JXDoG4rSi-TBNKnzQYg.Wv-lMrw8HNAP_HEDvOBIXEAwiQdWuiTZRvPwciEJp-Ag.JPEG.gpdnjsl%2FIMG_4482.JPG&type=sc960_832")
        markerInfoMap[marker23] = marker23Info
        val marker24Info = MarkerInfo("보리네생고깃간 신천점", "시흥시 수인으로 3299, 1층", "등심","031-312-6992", "문턱없음, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDAzMjdfMjkw%2FMDAxNTg1Mjg3Njc5ODIw.QmdbTKBY15vhmCv32OBKVREYxQGsIaGy-DXz06lsjX8g.pMSTImfUld_53wCHfnCrxrSHBDi1rIrHHQyKixKTjD4g.JPEG.kimnk1206%2FKakaoTalk_Moim_9goRWTZkDsSZvJHh4JRjAzmN9k70Ix.jpg&type=sc960_832")
        markerInfoMap[marker24] = marker24Info
        val marker25Info = MarkerInfo("흙과사람들", "시흥시 비둘기공원로 21 (대야동, 201-204호)", "한정식","031-318-3822", "경사로, 장애인 주차장","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20160413_281%2Flovemmmme_14605057114986Y3qU_JPEG%2FP20160408_111234062_696EA440-1D28-48F8-83B5-D8F0E84706A7.JPG&type=sc960_832")
        markerInfoMap[marker25] = marker25Info
        val marker26Info = MarkerInfo("백년회관서서갈비시흥대야점", "시흥시 비둘기공원6길 8, 2층 (대야동)", "수제돼지갈비","031-404-9414", "문턱없음","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODExMTJfNTkg%2FMDAxNTQyMDMyMzczOTYz.xVUh1B7HoT_ubU-eJCXdrCcA6TYWLBm67hpX4R7SYacg.pSntKya4DwSOy86TUAV-UUofhOeNFvL5cZLRpwxx1t0g.JPEG.hgse32%2FIMG_7605.jpg&type=sc960_832")
        markerInfoMap[marker26] = marker26Info
        val marker27Info = MarkerInfo("한촌설렁탕", "시흥시 비둘기공원6길19(대야동)", "사골황태탕","031-315-8852", "경사로, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA5MDVfODkg%2FMDAxNTY3Njc4OTU2MTM2.GEmVCQvQZoKL_glDdQ4XO5Du9X4kG8Mm-JpAbZTRgiwg.5XxrApb_nZFf7LCZEAoF9T7YOIlC78V2pX2_0UqWKnIg.PNG.sinbaram_drkim%2F20190904_103041.00_01_01_20.Still004.png&type=a340")
        markerInfoMap[marker27] = marker27Info
        val marker28Info = MarkerInfo("곽만근 갈비탕 시흥점", "시흥시 승지로69번길 9-1 (능곡동,1층)", "매운갈비찜","031-435-1250", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA1MzBfMTA4%2FMDAxNTU5MjE4MzcxNDQ0.ExqKQeK62CfR3zsrOTRNKqLso2cRame98uhrhzThiI0g.ZHGxXwLqpWNiRvwTGnuWkdcZdt90hoAWHLtHCBD7gfcg.JPEG.wsxcv1%2F20190530_190745.jpg&type=sc960_832")
        markerInfoMap[marker28] = marker28Info


        var infoWindow = InfoWindow()
        infoWindow.adapter = object : InfoWindow.DefaultViewAdapter(requireContext()) {
            override fun getContentView(infoWindow: InfoWindow): View {
                val view = LayoutInflater.from(context).inflate(R.layout.activity_map_info, null)
                var nameTextView = view.findViewById<TextView>(R.id.map_info_name)
                var addressTextView = view.findViewById<TextView>(R.id.map_info_addr)
                var phoneTextView = view.findViewById<TextView>(R.id.map_info_phone)
                var amenityTextView = view.findViewById<TextView>(R.id.map_info_amenity)
                var imageView = view.findViewById<ImageView>(R.id.map_info_image)
                var imageUri: Uri

                val marker = infoWindow.marker
                val markerInfo = markerInfoMap[marker]

                if (markerInfo != null) {
                    nameTextView.text = markerInfo.name
                    addressTextView.text = markerInfo.address
                    phoneTextView.text = markerInfo.phone
                    amenityTextView.text = markerInfo.amenity
                    imageUri = markerInfo.imageUrl.toUri()
                    Glide.with(requireContext()).load(imageUri).diskCacheStrategy(
                        DiskCacheStrategy.ALL
                    ).fitCenter().placeholder(R.drawable.ic_image_placeholder).into(imageView)
                }

                return view
            }
        }

        marker1.setOnClickListener {
            if (marker1.infoWindow == null) {
                infoWindow.open(marker1)
                currentInfoWindow = infoWindow
            }

            true
        }

        marker2.setOnClickListener {
            if (marker2.infoWindow == null) {
                infoWindow.open(marker2)
                currentInfoWindow = infoWindow
            }
            true
        }

        marker3.setOnClickListener {
            if (marker3.infoWindow == null) {
                infoWindow.open(marker3)
                currentInfoWindow = infoWindow
            }
            true
        }

        marker4.setOnClickListener {
            if (marker4.infoWindow == null) {
                infoWindow.open(marker4)
                currentInfoWindow = infoWindow
            }
            true
        }

        marker5.setOnClickListener {
            if (marker5.infoWindow == null) {
                infoWindow.open(marker5)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker6.setOnClickListener {
            if (marker6.infoWindow == null) {
                infoWindow.open(marker6)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker7.setOnClickListener {
            if (marker7.infoWindow == null) {
                infoWindow.open(marker7)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker8.setOnClickListener {
            if (marker8.infoWindow == null) {
                infoWindow.open(marker8)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker9.setOnClickListener {
            if (marker9.infoWindow == null) {
                infoWindow.open(marker9)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker10.setOnClickListener {
            if (marker10.infoWindow == null) {
                infoWindow.open(marker10)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker11.setOnClickListener {
            if (marker11.infoWindow == null) {
                infoWindow.open(marker11)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker12.setOnClickListener {
            if (marker12.infoWindow == null) {
                infoWindow.open(marker12)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker13.setOnClickListener {
            if (marker13.infoWindow == null) {
                infoWindow.open(marker13)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker14.setOnClickListener {
            if (marker14.infoWindow == null) {
                infoWindow.open(marker14)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker15.setOnClickListener {
            if (marker15.infoWindow == null) {
                infoWindow.open(marker15)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker16.setOnClickListener {
            if (marker16.infoWindow == null) {
                infoWindow.open(marker16)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker17.setOnClickListener {
            if (marker17.infoWindow == null) {
                infoWindow.open(marker17)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker18.setOnClickListener {
            if (marker18.infoWindow == null) {
                infoWindow.open(marker18)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker19.setOnClickListener {
            if (marker19.infoWindow == null) {
                infoWindow.open(marker19)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker20.setOnClickListener {
            if (marker20.infoWindow == null) {
                infoWindow.open(marker20)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker21.setOnClickListener {
            if (marker21.infoWindow == null) {
                infoWindow.open(marker21)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker22.setOnClickListener {
            if (marker22.infoWindow == null) {
                infoWindow.open(marker22)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker23.setOnClickListener {
            if (marker23.infoWindow == null) {
                infoWindow.open(marker23)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker24.setOnClickListener {
            if (marker24.infoWindow == null) {
                infoWindow.open(marker24)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker25.setOnClickListener {
            if (marker25.infoWindow == null) {
                infoWindow.open(marker25)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker26.setOnClickListener {
            if (marker26.infoWindow == null) {
                infoWindow.open(marker26)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker27.setOnClickListener {
            if (marker27.infoWindow == null) {
                infoWindow.open(marker27)
                currentInfoWindow = infoWindow
            }
            true
        }
        marker28.setOnClickListener {
            if (marker28.infoWindow == null) {
                infoWindow.open(marker28)
                currentInfoWindow = infoWindow
            }
            true
        }

        infoWindow.setOnClickListener {
            if (infoWindow != null) {
                if (marker1.infoWindow != null) {
                    var markerInfo = arrayOf("진애연㈜", "시흥시 월곶해안로 153", "진애연특선","031-317-0998", "경사로", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA1MjlfMjEx%2FMDAxNTI3NTk5ODM4ODgz.gFiH7DtXGg1jO9C-KmZMOQUxYA5NsovuUEGIDZo-jWEg.iufrF7IkpPIg6N1joykyYuMA80BNOj_ABWH95vWy6MAg.JPEG.hsb7391922%2FDSC00834.JPG")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker2.infoWindow != null) {
                    var markerInfo = arrayOf("풍차횟집", "시흥시 오이도로 143", "생선초밥","031-499-8259", "문턱없음", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMjFfMTgg%2FMDAxNjc2OTUyNTQ1MDIz.yyCwO1srwUbqh9fhsE3z_8D22H_ttU2_N9NFhLKbfcEg.0ASt0NZt18N3LvaMNeDebLOSYxexc28XYvA08YXdC0Ag.JPEG.kangsung4682%2FKakaoTalk_20230221_125951911_21.jpg")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker3.infoWindow != null) {
                    var markerInfo = arrayOf("고기와면", "시흥시 시청로 68번길 10", "생등심","031-318-6696", "문턱없음", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA1MThfODEg%2FMDAxNDk1MDcwNDg2NTg3.I_nAc5SGV4QbLQ5i_kl4ploD131zlL9wgAK_ha3a6wUg.4bvzkdJnvbPQITHnDxmgorT12NnYHTv6EcdHLhOSlegg.JPEG.siheungblog%2F1.JPG��")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker4.infoWindow != null) {
                    var markerInfo = arrayOf("엉터리생고기", "시흥시 중심상가3길 10", "큰소한마리","031-319-6363", "문턱없음", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzEyMzFfMTMz%2FMDAxNTE0NzI4NTM2NDIx.tebkJQkjjiMTfV0lImgV5FusKs8HYXg8XEs271cijHog.Cq2RsNbENJEMXjNDc2k7Pa2qH7QgGVIOhH45occ_mrgg.JPEG.just1262%2F1514728458201.jpg")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker5.infoWindow != null) {
                    var markerInfo = arrayOf("명동칼국수", "시흥시 중심상가2길 22", "칼국수","031-431-2113", "문턱없음, 장애인 주차장", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjExMDVfMjc4%2FMDAxNjY3NjE4NDU1ODEw.apEvSMEW_Dc3cu-QoTfgkEXaRKMx0uYNP6CR3PU5JTsg._ctzwo0V_dISafNzJYZjw_8DMKiISsUXUqUIhJV9BHAg.JPEG.love_wlgo%2F20221026%25A3%25DF184354.jpg")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker6.infoWindow != null) {
                    var markerInfo = arrayOf("소양강회집", "시흥시 오이도로 131", "회, 매운탕","031-497-7773", "경사로", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjEyMDJfMTEx%2FMDAxNjY5OTU0NjM5MDk2.4BjvWTAwshYvFFoSLK5h4F4hAM7eyz7FAqN_VcGBONYg.b8qhDlLK_HfKA6eh4X2oy8XHi_Yb4n9AJ89DAwkt9wUg.JPEG.solzzang0731%2FKakaoTalk_20221127_131153831.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker7.infoWindow != null) {
                    var markerInfo = arrayOf("우강", "시흥시 옥구천서로 313", "장어구이","031-433-0592", "경사로", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA3MjRfODIg%2FMDAxNjU4NjYxNzkyMzM1.NwfqucB6uP6KU37h81rvGGJUtDyB9SIE5fBKrsAQVSkg.YOmHuFAcw3fth9SR95O9De_t6RVhHSjOzR8d5QXJ8A8g.JPEG.2sacland%2FKakaoTalk_20220724_170603658.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker8.infoWindow != null) {
                    var markerInfo = arrayOf("샤브린", "시흥시 중심상가 2길 22 로즈프라자 2층", "월남쌈소고기샤브","031-434-9988", "문턱없음, 장애인 주차장", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA4MDlfMTM5%2FMDAxNjYwMDU0NzIxNzIx.hVuNe2XCN_DQdHcOVVNvW9jUB440kFlQVoGkO_zlokYg.d7T1wC-U7qYNZAuKxcRiHN15dn7eNjtmvkPyfnHIC6Qg.JPEG.dbwls349%2Foutput_446114994.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker9.infoWindow != null) {
                    var markerInfo = arrayOf("버섯생농장", "시흥시 중심상가로 161", "큰버섯샤브샤브","031-431-4495", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MDNfNzMg%2FMDAxNjIyNzI3NTA0MjU3.UXo0xEZ6ru2WUzq-G8YYRxNgCPN-ktxdjJBNXVQ91-Ig.RXxDZLUnr6Sd17MCMLfy4bOxT_eou7nPidM6otHj9UYg.JPEG.dkemzkal%2FIMG_6743.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker10.infoWindow != null) {
                    var markerInfo = arrayOf("등대횟집", "시흥시 오이도로 161", "회","031-431-8868", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA3MTBfMjg5%2FMDAxNDk5Njc1NTIyMTg0.rO0SKRKoEPZhHmW6MzMQ6rMImyD4o9nQCik7A2HKELcg.3JedUJX7uquclUuXRbNhuXEzT_g-ALPZ_NZBHK0Esaog.JPEG.ajj2017%2F1.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker11.infoWindow != null) {
                    var markerInfo = arrayOf("오도로", "시흥시 중심상가로 198", "참치회, 탕","031-496-8897", "문턱없음","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA3MjZfMTEx%2FMDAxNTY0MTI4NDExOTY3.Lrhit7EVzv94f_dk807mMvoobJi4wuu5JO_onSRG-IMg.PqBmuaZRdDWHhMIMA-Dsmx_qes6meQwQk_GkCvTJBN8g.JPEG.chuai0930%2F20190725_185700.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker12.infoWindow != null) {
                    var markerInfo = arrayOf("우촌", "시흥시 옥구상가4길 8-5", "돼지갈비","031-416-7799", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjEwMTVfNzQg%2FMDAxNjY1ODEyMzMxODA1.oZf9Lra--EypXPiZMaLUhb-BksjigvqtAM1MpAXNsQYg.Go9W6kk-NDVQFo1qNg-C47LyxydVe72Hfzp8XpTM8j8g.JPEG.dlagmlwn9602%2F1665812009609.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker13.infoWindow != null) {
                    var markerInfo = arrayOf("큰손오리농장", "시흥시 옥터로 79", "오리탕","031-431-6477", "문턱없음","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTAzMDVfMjc1%2FMDAxNTUxNzQyMDk5MjY4.fJ5mhLaMlZ8gItkacf6HwL3mw_zdL_3x_DcAZKIxmhYg.ME1jKnFrVk7KCQ9imaWB-f78vZ2wheb2zPSD20KEsEYg.JPEG.ksgbike%2FDSC03280.JPG&type=a340")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker14.infoWindow != null) {
                    var markerInfo = arrayOf("8.14바베큐", "시흥시 서촌상가 3길 5", "갈비","031-319-2255", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDEwMDNfNTIg%2FMDAxNjAxNzMxMTQ2NzE2.2jg2QQxVubdV5W85NyFBh6cFAn3owt3N4zPKCLnfUnYg.xP4AqNXWrQiq9hx-IoC2SNn2lhysavsbs2NRRf0rwZog.JPEG.chodager%2FDSC_6098.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker15.infoWindow != null) {
                    var markerInfo = arrayOf("고기한판", "시흥시 함송으로 15, 202호", "소갈비","031-497-9228", "문턱없음, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjEwMTFfMTM4%2FMDAxNjY1NDU3NTQwOTI1.KbQbPwVrZwLTkcFh0Ow9nHAR56lkJre7bNUJdmsWrqQg.3UTrxB4qTuvVJ1LxLVbKMMKE5l4RxMjIhLqOCqiJyRsg.JPEG.cjcfam%2F20221008%25A3%25DF192350.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker16.infoWindow != null) {
                    var markerInfo = arrayOf("오이도회조개구이", "시흥시 오이도로 127", "회, 조개구이","031-499-9793", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODExMTFfNTgg%2FMDAxNTQxOTM5MTc1NjU0.Bb6WWFsmrYII9r-j2X0jghw-ZRR_QTnEg7qlqawQv-Eg.O_8ei5ucw3SuG0ivmtQQ8WJpNEjI8AHSgBwAGdUk9GMg.JPEG.emforl1%2F1.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker17.infoWindow != null) {
                    var markerInfo = arrayOf("미다미", "시흥시 옥구상가1길 23", "회","031-433-3772", "문턱없음","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTAzMDVfMjA0%2FMDAxNTUxNzg3MzAxOTYw.0hL1MfKWQGKRz2JOA7mD0sFsuPx0OUfvdeTZwwKc69gg.Yd6XgQgVUMfhU3ffi_IGJMzR6OICWe21Q4990nRXQQgg.JPEG.326iloveu%2F2019-03-02-17-21-12.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker18.infoWindow != null) {
                    var markerInfo = arrayOf("929숯불닭갈비 시흥점", "시흥시 옥구상가 3길 7-5", "숯불닭갈비","031-496-9290", "경사로, 장애인 주차장","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA2MjlfNzQg%2FMDAxNDk4NjY0NjkyOTc4.SSxBqLsal1179x-0B-qUwJEzHE9pszgz-rU8C6ColrIg._Nn7E1Wh4urZB6AB5CDu5ghuZfs2ADzoFK8N4gY7DCkg.JPEG.taemoms%2FIMG_4605.JPG&type=a340")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker19.infoWindow != null) {
                    var markerInfo = arrayOf("더베이징", "시흥시 중심상가1길 14", "짜장면","031-319-4289", "문턱없음, 장애인 주차장","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMjZfMjcg%2FMDAxNjc3Mzk1NjY5OTAw.Dw9iI0JHACpVQUZmjstaPfYmjoP7DJwXL0b8M5gWHO8g.BYmt0WKGsCHSJbFjTwOSq_crjdwznX32suRCiejF6hkg.JPEG.love_wlgo%2F20230226%25A3%25DF132334.jpg&type=l340_165")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker20.infoWindow != null) {
                    var markerInfo = arrayOf("신의한소", "시흥시 배곧 3로 96", "삼겹살","0507-1406-4988", "문턱없음, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MDRfMTkz%2FMDAxNjIyNzkwNjMyNjAy.U5qvjvtuqHAVHCctlHAIAohTLPGd2qvF03ONJYtVF5Ag.Dtn9LT0sV_yhbLh1LZ46HTQQs5654F1RmX99QkFuqsAg.JPEG.4u4me1214%2FKakaoTalk_20210604_160212702.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker21.infoWindow != null) {
                    var markerInfo = arrayOf("여수횟집", "시흥시 오이도로 163((시흥시 정왕동)", "회","031-497-3827", "문턱없음","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODEyMTVfMTQz%2FMDAxNTQ0ODQxMjczMTI4.0kKe_P-UP-gVtwRTgX_S7m99hx3DvWiVQePwu7hkYmog.F9vQ409jdPSqfxnTvekOxA0DkzB6m7rM1B7HswN1Tk0g.JPEG.franchise09%2FKakaoTalk_20181215_110234100.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker22.infoWindow != null) {
                    var markerInfo = arrayOf("조선우", "시흥시 배곧4로32-29, 113,114호(시흥시 정왕동)", "소고기","031-432-1001", "문턱없음, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDEwMDFfMjM0%2FMDAxNjAxNTMxOTM3Nzk5._sx2sy_ZmTayn10UjOivLWf6vr1Y4tqH6kmEzMzd-0sg.VisHbPds_ekh3MjvjwV8OpxdwhR_o3Y6MXpARTkNCl4g.JPEG.relax7798%2FIMG_5244.JPG&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker23.infoWindow != null) {
                    var markerInfo = arrayOf("미래아구찜", "시흥시 배곧3로96, 201호(시흥시 정왕동)", "아구찜","031-432-6664", "문턱없음, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA2MTJfMjU1%2FMDAxNTI4NzczOTU3ODA5.Q3junADApHTyKP8BHI5ddBqW9JXDoG4rSi-TBNKnzQYg.Wv-lMrw8HNAP_HEDvOBIXEAwiQdWuiTZRvPwciEJp-Ag.JPEG.gpdnjsl%2FIMG_4482.JPG&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker24.infoWindow != null) {
                    var markerInfo = arrayOf("보리네생고깃간 신천점", "시흥시 수인으로 3299, 1층", "등심","031-312-6992", "문턱없음, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDAzMjdfMjkw%2FMDAxNTg1Mjg3Njc5ODIw.QmdbTKBY15vhmCv32OBKVREYxQGsIaGy-DXz06lsjX8g.pMSTImfUld_53wCHfnCrxrSHBDi1rIrHHQyKixKTjD4g.JPEG.kimnk1206%2FKakaoTalk_Moim_9goRWTZkDsSZvJHh4JRjAzmN9k70Ix.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker25.infoWindow != null) {
                    var markerInfo = arrayOf("흙과사람들", "시흥시 비둘기공원로 21 (대야동, 201-204호)", "한정식","031-318-3822", "경사로, 장애인 주차장","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20160413_281%2Flovemmmme_14605057114986Y3qU_JPEG%2FP20160408_111234062_696EA440-1D28-48F8-83B5-D8F0E84706A7.JPG&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker26.infoWindow != null) {
                    var markerInfo = arrayOf("백년회관서서갈비시흥대야점", "시흥시 비둘기공원6길 8, 2층 (대야동)", "수제돼지갈비","031-404-9414", "문턱없음","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODExMTJfNTkg%2FMDAxNTQyMDMyMzczOTYz.xVUh1B7HoT_ubU-eJCXdrCcA6TYWLBm67hpX4R7SYacg.pSntKya4DwSOy86TUAV-UUofhOeNFvL5cZLRpwxx1t0g.JPEG.hgse32%2FIMG_7605.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker27.infoWindow != null) {
                    var markerInfo = arrayOf("한촌설렁탕", "시흥시 비둘기공원6길19(대야동)", "사골황태탕","031-315-8852", "경사로, 장애인 주차장, 장애인 화장실","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA5MDVfODkg%2FMDAxNTY3Njc4OTU2MTM2.GEmVCQvQZoKL_glDdQ4XO5Du9X4kG8Mm-JpAbZTRgiwg.5XxrApb_nZFf7LCZEAoF9T7YOIlC78V2pX2_0UqWKnIg.PNG.sinbaram_drkim%2F20190904_103041.00_01_01_20.Still004.png&type=a340")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker28.infoWindow != null) {
                    var markerInfo = arrayOf("곽만근 갈비탕 시흥점", "시흥시 승지로69번길 9-1 (능곡동,1층)", "매운갈비찜","031-435-1250", "경사로","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA1MzBfMTA4%2FMDAxNTU5MjE4MzcxNDQ0.ExqKQeK62CfR3zsrOTRNKqLso2cRame98uhrhzThiI0g.ZHGxXwLqpWNiRvwTGnuWkdcZdt90hoAWHLtHCBD7gfcg.JPEG.wsxcv1%2F20190530_190745.jpg&type=sc960_832")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }

            }
            true
        }

        naverMap.setOnMapClickListener { pointF, latLng ->
            currentInfoWindow?.close()
            currentInfoWindow = null
        }
    }
}