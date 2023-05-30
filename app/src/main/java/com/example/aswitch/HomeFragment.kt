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
        val marker1 = Marker().apply { //���ֿ�
            position = LatLng(37.3883047674791, 126.736904128563)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.BLUE
        }

        val marker2 = Marker().apply {//ǳ��Ƚ��
            position = LatLng(37.3480116592429, 126.688915265611)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.BLUE
        }

        val marker3 = Marker().apply {//���͸�
            position = LatLng(37.3809332379338, 126.800848424051)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.RED
        }

        val marker4 = Marker().apply {//���͸������
            position = LatLng(37.3453235794196, 126.736862306960)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.RED
        }

        val marker5 = Marker().apply {//��Į����
            position = LatLng(37.3449173281097, 126.737521112612)
            width = SIZE_AUTO
            height = SIZE_AUTO
            icon = MarkerIcons.BLACK
            iconTintColor = Color.RED
        }

        marker1.map = naverMap
        marker2.map = naverMap
        marker3.map = naverMap
        marker4.map = naverMap
        marker5.map = naverMap

        var currentInfoWindow: InfoWindow? = null
        data class MarkerInfo(val name: String, val address: String, val menu: String, val phone: String, val amenity: String, val imageUrl: String )
        val markerInfoMap = mutableMapOf<Marker, MarkerInfo>()
        val marker1Info = MarkerInfo("���ֿ���", "����� �����ؾȷ� 153", "���ֿ�Ư��","031-317-0998", "����", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA1MjlfMjEx%2FMDAxNTI3NTk5ODM4ODgz.gFiH7DtXGg1jO9C-KmZMOQUxYA5NsovuUEGIDZo-jWEg.iufrF7IkpPIg6N1joykyYuMA80BNOj_ABWH95vWy6MAg.JPEG.hsb7391922%2FDSC00834.JPG")
        markerInfoMap[marker1] = marker1Info
        val marker2Info = MarkerInfo("ǳ��Ƚ��", "����� ���̵��� 143", "�����ʹ�","031-499-8259", "���ξ���", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMjFfMTgg%2FMDAxNjc2OTUyNTQ1MDIz.yyCwO1srwUbqh9fhsE3z_8D22H_ttU2_N9NFhLKbfcEg.0ASt0NZt18N3LvaMNeDebLOSYxexc28XYvA08YXdC0Ag.JPEG.kangsung4682%2FKakaoTalk_20230221_125951911_21.jpg")
        markerInfoMap[marker2] = marker2Info
        val marker3Info = MarkerInfo("���͸�", "����� ��û�� 68���� 10", "�����","031-318-6696", "���ξ���", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA1MThfODEg%2FMDAxNDk1MDcwNDg2NTg3.I_nAc5SGV4QbLQ5i_kl4ploD131zlL9wgAK_ha3a6wUg.4bvzkdJnvbPQITHnDxmgorT12NnYHTv6EcdHLhOSlegg.JPEG.siheungblog%2F1.JPG��")
        markerInfoMap[marker3] = marker3Info
        val marker4Info = MarkerInfo("���͸������", "����� �߽ɻ�3�� 10", "ū���Ѹ���","031-319-6363", "���ξ���", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzEyMzFfMTMz%2FMDAxNTE0NzI4NTM2NDIx.tebkJQkjjiMTfV0lImgV5FusKs8HYXg8XEs271cijHog.Cq2RsNbENJEMXjNDc2k7Pa2qH7QgGVIOhH45occ_mrgg.JPEG.just1262%2F1514728458201.jpg")
        markerInfoMap[marker4] = marker4Info
        val marker5Info = MarkerInfo("��Į����", "����� �߽ɻ�2�� 22", "Į����","031-431-2113", "���ξ���, ����� ������", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjExMDVfMjc4%2FMDAxNjY3NjE4NDU1ODEw.apEvSMEW_Dc3cu-QoTfgkEXaRKMx0uYNP6CR3PU5JTsg._ctzwo0V_dISafNzJYZjw_8DMKiISsUXUqUIhJV9BHAg.JPEG.love_wlgo%2F20221026%25A3%25DF184354.jpg")
        markerInfoMap[marker5] = marker5Info

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

        infoWindow.setOnClickListener {
            if (infoWindow != null) {
                if (marker1.infoWindow != null) {
                    var markerInfo = arrayOf("���ֿ���", "����� �����ؾȷ� 153", "���ֿ�Ư��","031-317-0998", "����", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA1MjlfMjEx%2FMDAxNTI3NTk5ODM4ODgz.gFiH7DtXGg1jO9C-KmZMOQUxYA5NsovuUEGIDZo-jWEg.iufrF7IkpPIg6N1joykyYuMA80BNOj_ABWH95vWy6MAg.JPEG.hsb7391922%2FDSC00834.JPG")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker2.infoWindow != null) {
                    var markerInfo = arrayOf("ǳ��Ƚ��", "����� ���̵��� 143", "�����ʹ�","031-499-8259", "���ξ���", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMjFfMTgg%2FMDAxNjc2OTUyNTQ1MDIz.yyCwO1srwUbqh9fhsE3z_8D22H_ttU2_N9NFhLKbfcEg.0ASt0NZt18N3LvaMNeDebLOSYxexc28XYvA08YXdC0Ag.JPEG.kangsung4682%2FKakaoTalk_20230221_125951911_21.jpg")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker3.infoWindow != null) {
                    var markerInfo = arrayOf("���͸�", "����� ��û�� 68���� 10", "�����","031-318-6696", "���ξ���", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA1MThfODEg%2FMDAxNDk1MDcwNDg2NTg3.I_nAc5SGV4QbLQ5i_kl4ploD131zlL9wgAK_ha3a6wUg.4bvzkdJnvbPQITHnDxmgorT12NnYHTv6EcdHLhOSlegg.JPEG.siheungblog%2F1.JPG��")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker4.infoWindow != null) {
                    var markerInfo = arrayOf("���͸������", "����� �߽ɻ�3�� 10", "ū���Ѹ���","031-319-6363", "���ξ���", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzEyMzFfMTMz%2FMDAxNTE0NzI4NTM2NDIx.tebkJQkjjiMTfV0lImgV5FusKs8HYXg8XEs271cijHog.Cq2RsNbENJEMXjNDc2k7Pa2qH7QgGVIOhH45occ_mrgg.JPEG.just1262%2F1514728458201.jpg")
                    val intent = Intent(requireContext(), MapInfoActivity::class.java)
                    intent.putExtra("markerInfo", markerInfo)
                    startActivity(intent)
                }
                if (marker5.infoWindow != null) {
                    var markerInfo = arrayOf("��Į����", "����� �߽ɻ�2�� 22", "Į����","031-431-2113", "���ξ���, ����� ������", "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjExMDVfMjc4%2FMDAxNjY3NjE4NDU1ODEw.apEvSMEW_Dc3cu-QoTfgkEXaRKMx0uYNP6CR3PU5JTsg._ctzwo0V_dISafNzJYZjw_8DMKiISsUXUqUIhJV9BHAg.JPEG.love_wlgo%2F20221026%25A3%25DF184354.jpg")
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