package androidx.core.location;

import android.location.LocationManager;
import android.os.Build;

public final class LocationManagerCompat {
    private LocationManagerCompat() {
    }

    public static boolean isLocationEnabled(LocationManager locationManager) {
        return Build.VERSION.SDK_INT >= 28 ? locationManager.isLocationEnabled() : locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }
}
