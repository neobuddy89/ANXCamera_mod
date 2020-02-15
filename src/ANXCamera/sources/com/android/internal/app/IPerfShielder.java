package com.android.internal.app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.statistics.E2EScenario;
import android.os.statistics.E2EScenarioPayload;
import android.os.statistics.E2EScenarioSettings;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IPerfShielder extends IInterface {

    public static class Default implements IPerfShielder {
        public void abortMatchingScenario(E2EScenario e2EScenario, String str, int i, long j) throws RemoteException {
        }

        public void abortSpecificScenario(Bundle bundle, int i, long j) throws RemoteException {
        }

        public void addActivityLaunchTime(String str, String str2, long j, long j2, boolean z, boolean z2) throws RemoteException {
        }

        public boolean addCallingPkgHookRule(String str, String str2, String str3) throws RemoteException {
            return false;
        }

        public void addTimeConsumingIntent(String[] strArr) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public Bundle beginScenario(E2EScenario e2EScenario, E2EScenarioSettings e2EScenarioSettings, String str, E2EScenarioPayload e2EScenarioPayload, int i, long j, boolean z) throws RemoteException {
            return null;
        }

        public void clearTimeConsumingIntent() throws RemoteException {
        }

        public void closeCheckPriority() throws RemoteException {
        }

        public boolean deleteFilterInfo(String str) throws RemoteException {
            return false;
        }

        public boolean deletePackageInfo(String str) throws RemoteException {
            return false;
        }

        public boolean deleteRedirectRule(String str, String str2) throws RemoteException {
            return false;
        }

        public void finishMatchingScenario(E2EScenario e2EScenario, String str, E2EScenarioPayload e2EScenarioPayload, int i, long j) throws RemoteException {
        }

        public void finishSpecificScenario(Bundle bundle, E2EScenarioPayload e2EScenarioPayload, int i, long j) throws RemoteException {
        }

        public List<Bundle> getAllRunningProcessMemInfos() throws RemoteException {
            return null;
        }

        public long getFreeMemory() throws RemoteException {
            return 0;
        }

        public int getMemoryTrimLevel() throws RemoteException {
            return 0;
        }

        public String getPackageNameByPid(int i) throws RemoteException {
            return null;
        }

        public ParcelFileDescriptor getPerfEventSocketFd() throws RemoteException {
            return null;
        }

        public boolean insertFilterInfo(String str, String str2, Uri uri, List<Bundle> list) throws RemoteException {
            return false;
        }

        public boolean insertPackageInfo(PackageInfo packageInfo) throws RemoteException {
            return false;
        }

        public boolean insertRedirectRule(String str, String str2, String str3, Bundle bundle) throws RemoteException {
            return false;
        }

        public void killUnusedApp(int i, int i2) throws RemoteException {
        }

        public boolean removeCallingPkgHookRule(String str, String str2) throws RemoteException {
            return false;
        }

        public void removeServicePriority(MiuiServicePriority miuiServicePriority, boolean z) throws RemoteException {
        }

        public void removeTimeConsumingIntent(String[] strArr) throws RemoteException {
        }

        public void reportAnr(int i, String str, long j, long j2, String str2) throws RemoteException {
        }

        public void reportExcessiveCpuUsageRecords(List<Bundle> list) throws RemoteException {
        }

        public void reportNotificationClick(String str, Intent intent, long j) throws RemoteException {
        }

        public void reportPerceptibleJank(int i, int i2, String str, long j, long j2, long j3, int i3, long j4) throws RemoteException {
        }

        public List<QuickAppResolveInfo> resolveQuickAppInfos(Intent intent) throws RemoteException {
            return null;
        }

        public void setForkedProcessGroup(int i, int i2, int i3, String str) throws RemoteException {
        }

        public void setHapLinks(Map map, ActivityInfo activityInfo) throws RemoteException {
        }

        public void setMiuiBroadcastDispatchEnable(boolean z) throws RemoteException {
        }

        public void setMiuiContentProviderControl(boolean z) throws RemoteException {
        }

        public void setSchedFgPid(int i) throws RemoteException {
        }

        public void setServicePriority(List<MiuiServicePriority> list) throws RemoteException {
        }

        public void setServicePriorityWithNoProc(List<MiuiServicePriority> list, long j) throws RemoteException {
        }

        public List<Bundle> updateProcessFullMemInfoByPids(int[] iArr) throws RemoteException {
            return null;
        }

        public List<Bundle> updateProcessPartialMemInfoByPids(int[] iArr) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IPerfShielder {
        private static final String DESCRIPTOR = "com.android.internal.app.IPerfShielder";
        static final int TRANSACTION_abortMatchingScenario = 30;
        static final int TRANSACTION_abortSpecificScenario = 31;
        static final int TRANSACTION_addActivityLaunchTime = 2;
        static final int TRANSACTION_addCallingPkgHookRule = 26;
        static final int TRANSACTION_addTimeConsumingIntent = 16;
        static final int TRANSACTION_beginScenario = 29;
        static final int TRANSACTION_clearTimeConsumingIntent = 18;
        static final int TRANSACTION_closeCheckPriority = 13;
        static final int TRANSACTION_deleteFilterInfo = 37;
        static final int TRANSACTION_deletePackageInfo = 23;
        static final int TRANSACTION_deleteRedirectRule = 21;
        static final int TRANSACTION_finishMatchingScenario = 32;
        static final int TRANSACTION_finishSpecificScenario = 33;
        static final int TRANSACTION_getAllRunningProcessMemInfos = 7;
        static final int TRANSACTION_getFreeMemory = 24;
        static final int TRANSACTION_getMemoryTrimLevel = 19;
        static final int TRANSACTION_getPackageNameByPid = 5;
        static final int TRANSACTION_getPerfEventSocketFd = 28;
        static final int TRANSACTION_insertFilterInfo = 36;
        static final int TRANSACTION_insertPackageInfo = 22;
        static final int TRANSACTION_insertRedirectRule = 20;
        static final int TRANSACTION_killUnusedApp = 4;
        static final int TRANSACTION_removeCallingPkgHookRule = 27;
        static final int TRANSACTION_removeServicePriority = 12;
        static final int TRANSACTION_removeTimeConsumingIntent = 17;
        static final int TRANSACTION_reportAnr = 25;
        static final int TRANSACTION_reportExcessiveCpuUsageRecords = 34;
        static final int TRANSACTION_reportNotificationClick = 35;
        static final int TRANSACTION_reportPerceptibleJank = 1;
        static final int TRANSACTION_resolveQuickAppInfos = 38;
        static final int TRANSACTION_setForkedProcessGroup = 6;
        static final int TRANSACTION_setHapLinks = 39;
        static final int TRANSACTION_setMiuiBroadcastDispatchEnable = 15;
        static final int TRANSACTION_setMiuiContentProviderControl = 14;
        static final int TRANSACTION_setSchedFgPid = 3;
        static final int TRANSACTION_setServicePriority = 10;
        static final int TRANSACTION_setServicePriorityWithNoProc = 11;
        static final int TRANSACTION_updateProcessFullMemInfoByPids = 8;
        static final int TRANSACTION_updateProcessPartialMemInfoByPids = 9;

        private static class Proxy implements IPerfShielder {
            public static IPerfShielder sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void abortMatchingScenario(E2EScenario e2EScenario, String str, int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (e2EScenario != null) {
                        obtain.writeInt(1);
                        e2EScenario.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(30, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().abortMatchingScenario(e2EScenario, str, i, j);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void abortSpecificScenario(Bundle bundle, int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(31, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().abortSpecificScenario(bundle, i, j);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addActivityLaunchTime(String str, String str2, long j, long j2, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    try {
                        obtain.writeString(str);
                    } catch (Throwable th) {
                        th = th;
                        String str3 = str2;
                        long j3 = j;
                        obtain.recycle();
                        throw th;
                    }
                    try {
                        obtain.writeString(str2);
                        try {
                            obtain.writeLong(j);
                            obtain.writeLong(j2);
                            int i = 0;
                            obtain.writeInt(z ? 1 : 0);
                            if (z2) {
                                i = 1;
                            }
                            obtain.writeInt(i);
                            try {
                                if (this.mRemote.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                                    obtain.recycle();
                                    return;
                                }
                                Stub.getDefaultImpl().addActivityLaunchTime(str, str2, j, j2, z, z2);
                                obtain.recycle();
                            } catch (Throwable th2) {
                                th = th2;
                                obtain.recycle();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            obtain.recycle();
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        long j32 = j;
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    String str4 = str;
                    String str32 = str2;
                    long j322 = j;
                    obtain.recycle();
                    throw th;
                }
            }

            public boolean addCallingPkgHookRule(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    boolean z = false;
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().addCallingPkgHookRule(str, str2, str3);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    boolean z2 = z;
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addTimeConsumingIntent(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringArray(strArr);
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().addTimeConsumingIntent(strArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public Bundle beginScenario(E2EScenario e2EScenario, E2EScenarioSettings e2EScenarioSettings, String str, E2EScenarioPayload e2EScenarioPayload, int i, long j, boolean z) throws RemoteException {
                E2EScenario e2EScenario2 = e2EScenario;
                E2EScenarioSettings e2EScenarioSettings2 = e2EScenarioSettings;
                E2EScenarioPayload e2EScenarioPayload2 = e2EScenarioPayload;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    int i2 = 1;
                    if (e2EScenario2 != null) {
                        obtain.writeInt(1);
                        e2EScenario2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (e2EScenarioSettings2 != null) {
                        obtain.writeInt(1);
                        e2EScenarioSettings2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    try {
                        obtain.writeString(str);
                        if (e2EScenarioPayload2 != null) {
                            obtain.writeInt(1);
                            e2EScenarioPayload2.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeInt(i);
                        obtain.writeLong(j);
                        if (!z) {
                            i2 = 0;
                        }
                        obtain.writeInt(i2);
                        if (this.mRemote.transact(29, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                            obtain2.recycle();
                            obtain.recycle();
                            return bundle;
                        }
                        Bundle beginScenario = Stub.getDefaultImpl().beginScenario(e2EScenario, e2EScenarioSettings, str, e2EScenarioPayload, i, j, z);
                        obtain2.recycle();
                        obtain.recycle();
                        return beginScenario;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    String str2 = str;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public void clearTimeConsumingIntent() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(18, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().clearTimeConsumingIntent();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void closeCheckPriority() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().closeCheckPriority();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean deleteFilterInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(37, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().deleteFilterInfo(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    boolean z2 = z;
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean deletePackageInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    if (!this.mRemote.transact(23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().deletePackageInfo(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    boolean z2 = z;
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean deleteRedirectRule(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().deleteRedirectRule(str, str2);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    boolean z2 = z;
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void finishMatchingScenario(E2EScenario e2EScenario, String str, E2EScenarioPayload e2EScenarioPayload, int i, long j) throws RemoteException {
                E2EScenario e2EScenario2 = e2EScenario;
                E2EScenarioPayload e2EScenarioPayload2 = e2EScenarioPayload;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (e2EScenario2 != null) {
                        obtain.writeInt(1);
                        e2EScenario2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    try {
                        obtain.writeString(str);
                        if (e2EScenarioPayload2 != null) {
                            obtain.writeInt(1);
                            e2EScenarioPayload2.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        try {
                            obtain.writeInt(i);
                            try {
                                obtain.writeLong(j);
                                if (this.mRemote.transact(32, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                                    obtain2.readException();
                                    obtain2.recycle();
                                    obtain.recycle();
                                    return;
                                }
                                Stub.getDefaultImpl().finishMatchingScenario(e2EScenario, str, e2EScenarioPayload, i, j);
                                obtain2.recycle();
                                obtain.recycle();
                            } catch (Throwable th) {
                                th = th;
                                obtain2.recycle();
                                obtain.recycle();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            long j2 = j;
                            obtain2.recycle();
                            obtain.recycle();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        int i2 = i;
                        long j22 = j;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    String str2 = str;
                    int i22 = i;
                    long j222 = j;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public void finishSpecificScenario(Bundle bundle, E2EScenarioPayload e2EScenarioPayload, int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (e2EScenarioPayload != null) {
                        obtain.writeInt(1);
                        e2EScenarioPayload.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(33, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().finishSpecificScenario(bundle, e2EScenarioPayload, i, j);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<Bundle> getAllRunningProcessMemInfos() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllRunningProcessMemInfos();
                    }
                    obtain2.readException();
                    ArrayList createTypedArrayList = obtain2.createTypedArrayList(Bundle.CREATOR);
                    obtain2.recycle();
                    obtain.recycle();
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getFreeMemory() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(24, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFreeMemory();
                    }
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    obtain2.recycle();
                    obtain.recycle();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public int getMemoryTrimLevel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMemoryTrimLevel();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getPackageNameByPid(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPackageNameByPid(i);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelFileDescriptor getPerfEventSocketFd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(28, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPerfEventSocketFd();
                    }
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean insertFilterInfo(String str, String str2, Uri uri, List<Bundle> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = true;
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    if (!this.mRemote.transact(36, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().insertFilterInfo(str, str2, uri, list);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean insertPackageInfo(PackageInfo packageInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (packageInfo != null) {
                        obtain.writeInt(1);
                        packageInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().insertPackageInfo(packageInfo);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean insertRedirectRule(String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    boolean z = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().insertRedirectRule(str, str2, str3, bundle);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void killUnusedApp(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(4, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().killUnusedApp(i, i2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public boolean removeCallingPkgHookRule(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    if (!this.mRemote.transact(27, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeCallingPkgHookRule(str, str2);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    boolean z2 = z;
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeServicePriority(MiuiServicePriority miuiServicePriority, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    int i = 0;
                    if (miuiServicePriority != null) {
                        obtain.writeInt(1);
                        miuiServicePriority.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    if (this.mRemote.transact(12, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().removeServicePriority(miuiServicePriority, z);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void removeTimeConsumingIntent(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringArray(strArr);
                    if (this.mRemote.transact(17, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().removeTimeConsumingIntent(strArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void reportAnr(int i, String str, long j, long j2, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    try {
                        obtain.writeInt(i);
                    } catch (Throwable th) {
                        th = th;
                        String str3 = str;
                        long j3 = j;
                        long j4 = j2;
                        obtain.recycle();
                        throw th;
                    }
                    try {
                        obtain.writeString(str);
                        try {
                            obtain.writeLong(j);
                        } catch (Throwable th2) {
                            th = th2;
                            long j42 = j2;
                            obtain.recycle();
                            throw th;
                        }
                        try {
                            obtain.writeLong(j2);
                            obtain.writeString(str2);
                            if (this.mRemote.transact(25, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                                obtain.recycle();
                                return;
                            }
                            Stub.getDefaultImpl().reportAnr(i, str, j, j2, str2);
                            obtain.recycle();
                        } catch (Throwable th3) {
                            th = th3;
                            obtain.recycle();
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        long j32 = j;
                        long j422 = j2;
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    int i2 = i;
                    String str32 = str;
                    long j322 = j;
                    long j4222 = j2;
                    obtain.recycle();
                    throw th;
                }
            }

            public void reportExcessiveCpuUsageRecords(List<Bundle> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(34, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().reportExcessiveCpuUsageRecords(list);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void reportNotificationClick(String str, Intent intent, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    if (this.mRemote.transact(35, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().reportNotificationClick(str, intent, j);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void reportPerceptibleJank(int i, int i2, String str, long j, long j2, long j3, int i3, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    try {
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        obtain.writeString(str);
                        obtain.writeLong(j);
                        obtain.writeLong(j2);
                        obtain.writeLong(j3);
                        obtain.writeInt(i3);
                        obtain.writeLong(j4);
                        if (this.mRemote.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().reportPerceptibleJank(i, i2, str, j, j2, j3, i3, j4);
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    int i4 = i;
                    obtain.recycle();
                    throw th;
                }
            }

            public List<QuickAppResolveInfo> resolveQuickAppInfos(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(38, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().resolveQuickAppInfos(intent);
                    }
                    obtain2.readException();
                    ArrayList createTypedArrayList = obtain2.createTypedArrayList(QuickAppResolveInfo.CREATOR);
                    obtain2.recycle();
                    obtain.recycle();
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setForkedProcessGroup(int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setForkedProcessGroup(i, i2, i3, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setHapLinks(Map map, ActivityInfo activityInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    if (activityInfo != null) {
                        obtain.writeInt(1);
                        activityInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(39, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setHapLinks(map, activityInfo);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void setMiuiBroadcastDispatchEnable(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(15, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setMiuiBroadcastDispatchEnable(z);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void setMiuiContentProviderControl(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(14, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setMiuiContentProviderControl(z);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void setSchedFgPid(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setSchedFgPid(i);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void setServicePriority(List<MiuiServicePriority> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(10, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setServicePriority(list);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void setServicePriorityWithNoProc(List<MiuiServicePriority> list, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(11, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setServicePriorityWithNoProc(list, j);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public List<Bundle> updateProcessFullMemInfoByPids(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeIntArray(iArr);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateProcessFullMemInfoByPids(iArr);
                    }
                    obtain2.readException();
                    ArrayList createTypedArrayList = obtain2.createTypedArrayList(Bundle.CREATOR);
                    obtain2.recycle();
                    obtain.recycle();
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<Bundle> updateProcessPartialMemInfoByPids(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeIntArray(iArr);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateProcessPartialMemInfoByPids(iArr);
                    }
                    obtain2.readException();
                    ArrayList createTypedArrayList = obtain2.createTypedArrayList(Bundle.CREATOR);
                    obtain2.recycle();
                    obtain.recycle();
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPerfShielder asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPerfShielder)) ? new Proxy(iBinder) : (IPerfShielder) queryLocalInterface;
        }

        public static IPerfShielder getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static String getDefaultTransactionName(int i) {
            switch (i) {
                case 1:
                    return "reportPerceptibleJank";
                case 2:
                    return "addActivityLaunchTime";
                case 3:
                    return "setSchedFgPid";
                case 4:
                    return "killUnusedApp";
                case 5:
                    return "getPackageNameByPid";
                case 6:
                    return "setForkedProcessGroup";
                case 7:
                    return "getAllRunningProcessMemInfos";
                case 8:
                    return "updateProcessFullMemInfoByPids";
                case 9:
                    return "updateProcessPartialMemInfoByPids";
                case 10:
                    return "setServicePriority";
                case 11:
                    return "setServicePriorityWithNoProc";
                case 12:
                    return "removeServicePriority";
                case 13:
                    return "closeCheckPriority";
                case 14:
                    return "setMiuiContentProviderControl";
                case 15:
                    return "setMiuiBroadcastDispatchEnable";
                case 16:
                    return "addTimeConsumingIntent";
                case 17:
                    return "removeTimeConsumingIntent";
                case 18:
                    return "clearTimeConsumingIntent";
                case 19:
                    return "getMemoryTrimLevel";
                case 20:
                    return "insertRedirectRule";
                case 21:
                    return "deleteRedirectRule";
                case 22:
                    return "insertPackageInfo";
                case 23:
                    return "deletePackageInfo";
                case 24:
                    return "getFreeMemory";
                case 25:
                    return "reportAnr";
                case 26:
                    return "addCallingPkgHookRule";
                case 27:
                    return "removeCallingPkgHookRule";
                case 28:
                    return "getPerfEventSocketFd";
                case 29:
                    return "beginScenario";
                case 30:
                    return "abortMatchingScenario";
                case 31:
                    return "abortSpecificScenario";
                case 32:
                    return "finishMatchingScenario";
                case 33:
                    return "finishSpecificScenario";
                case 34:
                    return "reportExcessiveCpuUsageRecords";
                case 35:
                    return "reportNotificationClick";
                case 36:
                    return "insertFilterInfo";
                case 37:
                    return "deleteFilterInfo";
                case 38:
                    return "resolveQuickAppInfos";
                case 39:
                    return "setHapLinks";
                default:
                    return null;
            }
        }

        public static boolean setDefaultImpl(IPerfShielder iPerfShielder) {
            if (Proxy.sDefaultImpl != null || iPerfShielder == null) {
                return false;
            }
            Proxy.sDefaultImpl = iPerfShielder;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public String getTransactionName(int i) {
            return getDefaultTransactionName(i);
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            if (i3 != 1598968902) {
                boolean z = false;
                switch (i3) {
                    case 1:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        int readInt2 = parcel.readInt();
                        String readString = parcel.readString();
                        long readLong = parcel.readLong();
                        long readLong2 = parcel.readLong();
                        long readLong3 = parcel.readLong();
                        int readInt3 = parcel.readInt();
                        long readLong4 = parcel.readLong();
                        Parcel parcel5 = parcel4;
                        Object obj = DESCRIPTOR;
                        reportPerceptibleJank(readInt, readInt2, readString, readLong, readLong2, readLong3, readInt3, readLong4);
                        return true;
                    case 2:
                        parcel3.enforceInterface(DESCRIPTOR);
                        addActivityLaunchTime(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0);
                        return true;
                    case 3:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setSchedFgPid(parcel.readInt());
                        return true;
                    case 4:
                        parcel3.enforceInterface(DESCRIPTOR);
                        killUnusedApp(parcel.readInt(), parcel.readInt());
                        return true;
                    case 5:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String packageNameByPid = getPackageNameByPid(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeString(packageNameByPid);
                        return true;
                    case 6:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setForkedProcessGroup(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel3.enforceInterface(DESCRIPTOR);
                        List<Bundle> allRunningProcessMemInfos = getAllRunningProcessMemInfos();
                        parcel2.writeNoException();
                        parcel4.writeTypedList(allRunningProcessMemInfos);
                        return true;
                    case 8:
                        parcel3.enforceInterface(DESCRIPTOR);
                        List<Bundle> updateProcessFullMemInfoByPids = updateProcessFullMemInfoByPids(parcel.createIntArray());
                        parcel2.writeNoException();
                        parcel4.writeTypedList(updateProcessFullMemInfoByPids);
                        return true;
                    case 9:
                        parcel3.enforceInterface(DESCRIPTOR);
                        List<Bundle> updateProcessPartialMemInfoByPids = updateProcessPartialMemInfoByPids(parcel.createIntArray());
                        parcel2.writeNoException();
                        parcel4.writeTypedList(updateProcessPartialMemInfoByPids);
                        return true;
                    case 10:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setServicePriority(parcel3.createTypedArrayList(MiuiServicePriority.CREATOR));
                        return true;
                    case 11:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setServicePriorityWithNoProc(parcel3.createTypedArrayList(MiuiServicePriority.CREATOR), parcel.readLong());
                        return true;
                    case 12:
                        parcel3.enforceInterface(DESCRIPTOR);
                        MiuiServicePriority miuiServicePriority = parcel.readInt() != 0 ? (MiuiServicePriority) MiuiServicePriority.CREATOR.createFromParcel(parcel3) : null;
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        removeServicePriority(miuiServicePriority, z);
                        return true;
                    case 13:
                        parcel3.enforceInterface(DESCRIPTOR);
                        closeCheckPriority();
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setMiuiContentProviderControl(z);
                        return true;
                    case 15:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setMiuiBroadcastDispatchEnable(z);
                        return true;
                    case 16:
                        parcel3.enforceInterface(DESCRIPTOR);
                        addTimeConsumingIntent(parcel.createStringArray());
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel3.enforceInterface(DESCRIPTOR);
                        removeTimeConsumingIntent(parcel.createStringArray());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel3.enforceInterface(DESCRIPTOR);
                        clearTimeConsumingIntent();
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel3.enforceInterface(DESCRIPTOR);
                        int memoryTrimLevel = getMemoryTrimLevel();
                        parcel2.writeNoException();
                        parcel4.writeInt(memoryTrimLevel);
                        return true;
                    case 20:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean insertRedirectRule = insertRedirectRule(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null);
                        parcel2.writeNoException();
                        parcel4.writeInt(insertRedirectRule ? 1 : 0);
                        return true;
                    case 21:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean deleteRedirectRule = deleteRedirectRule(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeInt(deleteRedirectRule ? 1 : 0);
                        return true;
                    case 22:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean insertPackageInfo = insertPackageInfo(parcel.readInt() != 0 ? (PackageInfo) PackageInfo.CREATOR.createFromParcel(parcel3) : null);
                        parcel2.writeNoException();
                        parcel4.writeInt(insertPackageInfo ? 1 : 0);
                        return true;
                    case 23:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean deletePackageInfo = deletePackageInfo(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeInt(deletePackageInfo ? 1 : 0);
                        return true;
                    case 24:
                        parcel3.enforceInterface(DESCRIPTOR);
                        long freeMemory = getFreeMemory();
                        parcel2.writeNoException();
                        parcel4.writeLong(freeMemory);
                        return true;
                    case 25:
                        parcel3.enforceInterface(DESCRIPTOR);
                        reportAnr(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString());
                        return true;
                    case 26:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean addCallingPkgHookRule = addCallingPkgHookRule(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeInt(addCallingPkgHookRule ? 1 : 0);
                        return true;
                    case 27:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean removeCallingPkgHookRule = removeCallingPkgHookRule(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeInt(removeCallingPkgHookRule ? 1 : 0);
                        return true;
                    case 28:
                        parcel3.enforceInterface(DESCRIPTOR);
                        ParcelFileDescriptor perfEventSocketFd = getPerfEventSocketFd();
                        parcel2.writeNoException();
                        if (perfEventSocketFd != null) {
                            parcel4.writeInt(1);
                            perfEventSocketFd.writeToParcel(parcel4, 1);
                        } else {
                            parcel4.writeInt(0);
                        }
                        return true;
                    case 29:
                        parcel3.enforceInterface(DESCRIPTOR);
                        Bundle beginScenario = beginScenario(parcel.readInt() != 0 ? E2EScenario.CREATOR.createFromParcel(parcel3) : null, parcel.readInt() != 0 ? E2EScenarioSettings.CREATOR.createFromParcel(parcel3) : null, parcel.readString(), parcel.readInt() != 0 ? E2EScenarioPayload.CREATOR.createFromParcel(parcel3) : null, parcel.readInt(), parcel.readLong(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        if (beginScenario != null) {
                            parcel4.writeInt(1);
                            beginScenario.writeToParcel(parcel4, 1);
                        } else {
                            parcel4.writeInt(0);
                        }
                        return true;
                    case 30:
                        parcel3.enforceInterface(DESCRIPTOR);
                        abortMatchingScenario(parcel.readInt() != 0 ? E2EScenario.CREATOR.createFromParcel(parcel3) : null, parcel.readString(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 31:
                        parcel3.enforceInterface(DESCRIPTOR);
                        abortSpecificScenario(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null, parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 32:
                        parcel3.enforceInterface(DESCRIPTOR);
                        finishMatchingScenario(parcel.readInt() != 0 ? E2EScenario.CREATOR.createFromParcel(parcel3) : null, parcel.readString(), parcel.readInt() != 0 ? E2EScenarioPayload.CREATOR.createFromParcel(parcel3) : null, parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 33:
                        parcel3.enforceInterface(DESCRIPTOR);
                        finishSpecificScenario(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null, parcel.readInt() != 0 ? E2EScenarioPayload.CREATOR.createFromParcel(parcel3) : null, parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel3.enforceInterface(DESCRIPTOR);
                        reportExcessiveCpuUsageRecords(parcel3.createTypedArrayList(Bundle.CREATOR));
                        return true;
                    case 35:
                        parcel3.enforceInterface(DESCRIPTOR);
                        reportNotificationClick(parcel.readString(), parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel3) : null, parcel.readLong());
                        return true;
                    case 36:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean insertFilterInfo = insertFilterInfo(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel3) : null, parcel3.createTypedArrayList(Bundle.CREATOR));
                        parcel2.writeNoException();
                        parcel4.writeInt(insertFilterInfo ? 1 : 0);
                        return true;
                    case 37:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean deleteFilterInfo = deleteFilterInfo(parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeInt(deleteFilterInfo ? 1 : 0);
                        return true;
                    case 38:
                        parcel3.enforceInterface(DESCRIPTOR);
                        List<QuickAppResolveInfo> resolveQuickAppInfos = resolveQuickAppInfos(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel3) : null);
                        parcel2.writeNoException();
                        parcel4.writeTypedList(resolveQuickAppInfos);
                        return true;
                    case 39:
                        parcel3.enforceInterface(DESCRIPTOR);
                        setHapLinks(parcel3.readHashMap(getClass().getClassLoader()), parcel.readInt() != 0 ? (ActivityInfo) ActivityInfo.CREATOR.createFromParcel(parcel3) : null);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel4.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void abortMatchingScenario(E2EScenario e2EScenario, String str, int i, long j) throws RemoteException;

    void abortSpecificScenario(Bundle bundle, int i, long j) throws RemoteException;

    void addActivityLaunchTime(String str, String str2, long j, long j2, boolean z, boolean z2) throws RemoteException;

    boolean addCallingPkgHookRule(String str, String str2, String str3) throws RemoteException;

    void addTimeConsumingIntent(String[] strArr) throws RemoteException;

    Bundle beginScenario(E2EScenario e2EScenario, E2EScenarioSettings e2EScenarioSettings, String str, E2EScenarioPayload e2EScenarioPayload, int i, long j, boolean z) throws RemoteException;

    void clearTimeConsumingIntent() throws RemoteException;

    void closeCheckPriority() throws RemoteException;

    boolean deleteFilterInfo(String str) throws RemoteException;

    boolean deletePackageInfo(String str) throws RemoteException;

    boolean deleteRedirectRule(String str, String str2) throws RemoteException;

    void finishMatchingScenario(E2EScenario e2EScenario, String str, E2EScenarioPayload e2EScenarioPayload, int i, long j) throws RemoteException;

    void finishSpecificScenario(Bundle bundle, E2EScenarioPayload e2EScenarioPayload, int i, long j) throws RemoteException;

    List<Bundle> getAllRunningProcessMemInfos() throws RemoteException;

    long getFreeMemory() throws RemoteException;

    int getMemoryTrimLevel() throws RemoteException;

    String getPackageNameByPid(int i) throws RemoteException;

    ParcelFileDescriptor getPerfEventSocketFd() throws RemoteException;

    boolean insertFilterInfo(String str, String str2, Uri uri, List<Bundle> list) throws RemoteException;

    boolean insertPackageInfo(PackageInfo packageInfo) throws RemoteException;

    boolean insertRedirectRule(String str, String str2, String str3, Bundle bundle) throws RemoteException;

    void killUnusedApp(int i, int i2) throws RemoteException;

    boolean removeCallingPkgHookRule(String str, String str2) throws RemoteException;

    void removeServicePriority(MiuiServicePriority miuiServicePriority, boolean z) throws RemoteException;

    void removeTimeConsumingIntent(String[] strArr) throws RemoteException;

    void reportAnr(int i, String str, long j, long j2, String str2) throws RemoteException;

    void reportExcessiveCpuUsageRecords(List<Bundle> list) throws RemoteException;

    void reportNotificationClick(String str, Intent intent, long j) throws RemoteException;

    void reportPerceptibleJank(int i, int i2, String str, long j, long j2, long j3, int i3, long j4) throws RemoteException;

    List<QuickAppResolveInfo> resolveQuickAppInfos(Intent intent) throws RemoteException;

    void setForkedProcessGroup(int i, int i2, int i3, String str) throws RemoteException;

    void setHapLinks(Map map, ActivityInfo activityInfo) throws RemoteException;

    void setMiuiBroadcastDispatchEnable(boolean z) throws RemoteException;

    void setMiuiContentProviderControl(boolean z) throws RemoteException;

    void setSchedFgPid(int i) throws RemoteException;

    void setServicePriority(List<MiuiServicePriority> list) throws RemoteException;

    void setServicePriorityWithNoProc(List<MiuiServicePriority> list, long j) throws RemoteException;

    List<Bundle> updateProcessFullMemInfoByPids(int[] iArr) throws RemoteException;

    List<Bundle> updateProcessPartialMemInfoByPids(int[] iArr) throws RemoteException;
}
