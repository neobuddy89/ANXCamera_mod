.class public final Landroid/os/statistics/E2EScenarioPayload;
.super Ljava/lang/Object;
.source "E2EScenarioPayload.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Ljava/lang/Cloneable;
.implements Ljava/io/Serializable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Landroid/os/statistics/E2EScenarioPayload;",
            ">;"
        }
    .end annotation
.end field

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private final values:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Landroid/os/statistics/E2EScenarioPayload$1;

    invoke-direct {v0}, Landroid/os/statistics/E2EScenarioPayload$1;-><init>()V

    sput-object v0, Landroid/os/statistics/E2EScenarioPayload;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    if-eqz p1, :cond_2

    invoke-virtual {p1}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    goto :goto_0

    :cond_0
    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    if-nez v2, :cond_1

    const-string v4, ""

    goto :goto_1

    :cond_1
    move-object v4, v2

    :goto_1
    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_2
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 7

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readHashMap(Ljava/lang/ClassLoader;)Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1

    iget-object v5, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    if-nez v4, :cond_0

    const-string v6, ""

    goto :goto_1

    :cond_0
    move-object v6, v4

    :goto_1
    invoke-virtual {v5, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    goto :goto_0

    :cond_2
    return-void
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 3

    new-instance v0, Landroid/os/statistics/E2EScenarioPayload;

    invoke-direct {v0}, Landroid/os/statistics/E2EScenarioPayload;-><init>()V

    iget-object v1, v0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    iget-object v2, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    return-object v0
.end method

.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public get(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public isEmpty()Z
    .locals 1

    iget-object v0, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public mergeFrom(Landroid/os/statistics/E2EScenarioPayload;)V
    .locals 2

    iget-object v0, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    iget-object v1, p1, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    return-void
.end method

.method public put(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4

    const/4 v0, 0x0

    if-nez p1, :cond_0

    move-object v1, v0

    goto :goto_0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_0
    if-nez p2, :cond_1

    goto :goto_1

    :cond_1
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_1
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    iget-object v2, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    if-nez v0, :cond_2

    const-string v3, ""

    goto :goto_2

    :cond_2
    move-object v3, v0

    :goto_2
    invoke-virtual {v2, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3
    return-void
.end method

.method public putAll(Ljava/util/Map;)V
    .locals 4

    if-nez p1, :cond_0

    return-void

    :cond_0
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v2, v1

    check-cast v2, Ljava/util/Map$Entry;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    move-object v3, v1

    check-cast v3, Ljava/util/Map$Entry;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Landroid/os/statistics/E2EScenarioPayload;->put(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0

    :cond_1
    return-void
.end method

.method public varargs putValues([Ljava/lang/Object;)V
    .locals 4

    if-nez p1, :cond_0

    return-void

    :cond_0
    array-length v0, p1

    rem-int/lit8 v0, v0, 0x2

    const/4 v1, 0x1

    if-eq v0, v1, :cond_2

    const/4 v0, 0x0

    :goto_0
    array-length v2, p1

    div-int/lit8 v2, v2, 0x2

    if-ge v0, v2, :cond_1

    mul-int/lit8 v2, v0, 0x2

    aget-object v2, p1, v2

    mul-int/lit8 v3, v0, 0x2

    add-int/2addr v3, v1

    aget-object v3, p1, v3

    invoke-virtual {p0, v2, v3}, Landroid/os/statistics/E2EScenarioPayload;->put(Ljava/lang/Object;Ljava/lang/Object;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    return-void

    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "length of keyandvalues should be even"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public toJson()Lorg/json/JSONObject;
    .locals 5

    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    :try_start_0
    iget-object v1, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    nop

    goto :goto_0

    :cond_0
    goto :goto_1

    :catch_0
    move-exception v1

    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    :goto_1
    return-object v0
.end method

.method public writeToBundle(Landroid/os/Bundle;)V
    .locals 4

    iget-object v0, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    iget-object v0, p0, Landroid/os/statistics/E2EScenarioPayload;->values:Ljava/util/HashMap;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeMap(Ljava/util/Map;)V

    return-void
.end method
