package com.egco428.ex17_map

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        val mu = LatLng(13.793406,100.322514)

        //add marker
        //set title
        //mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //mMap.addMarker(MarkerOptions().position(mu).title("Marker in Mahidol"))

        //marker blue
        //mMap.addMarker(MarkerOptions().position(LatLng(15.4321,100.45612)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))

        //marker by set icon
        //mMap.addMarker(MarkerOptions().position(LatLng(15.4321,100.45612)).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)))

        //move focus and zoom
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mu,6f))

        //click short
        /*mMap.setOnMapClickListener { latLng ->
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng))
            mMap.addMarker(MarkerOptions().position(latLng).title(latLng.toString()))
        }*/


        //mMap.moveCamera(CameraUpdateFactory.newLatLng(mu))

        //draw line
        //mMap.addPolyline(PolylineOptions().add(LatLng(15.0,100.45612),LatLng(15.55321,100.0),LatLng(15.896,96.0)).width(5f).color(Color.GREEN))

        //draw line and fillin by color
        //mMap.addPolygon(PolygonOptions().add(LatLng(15.0,99.45612),LatLng(15.55321,96.0),LatLng(12.0,94.0),LatLng(15.0,99.45612)).strokeColor(Color.MAGENTA).fillColor(Color.GRAY))


        var count = 1
        var first = true
        var ll = LatLng(11.11,11.11)

        //click long
        mMap.setOnMapLongClickListener { latLng ->
            if(first) {
                ll = latLng
                first =false
            }

            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng))
            if(count==1) {
                mMap.addMarker(MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_setting)))
                if(latLng != ll) {
                    mMap.addPolyline(PolylineOptions().add(ll,latLng).width(10f).color(Color.BLACK))
                    ll = latLng
                }
                count+=1
            }
            else if(count==2) {
                mMap.addMarker(MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_call)))
                if(latLng != ll) {
                    mMap.addPolyline(PolylineOptions().add(ll,latLng).width(10f).color(Color.BLACK))
                    ll = latLng
                }
                count+=1
            }
            else if(count==3) {
                mMap.addMarker(MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_message)))
                if(latLng != ll) {
                    mMap.addPolyline(PolylineOptions().add(ll,latLng).width(10f).color(Color.BLACK))
                    ll = latLng
                }
                count+=1
            }
            else if(count==4) {
                mMap.addMarker(MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_warning)))
                if(latLng != ll) {
                    mMap.addPolyline(PolylineOptions().add(ll,latLng).width(10f).color(Color.BLACK))
                    ll = latLng
                }
                count=1
            }

        }


    }
}
