.class public Lmiui/reflect/ReflectUtils;
.super Ljava/lang/Object;
.source "ReflectUtils.java"


# static fields
.field public static final OBJECT_CONSTRUCTOR:Ljava/lang/String; = "<init>"

.field private static PRIMITIVE_CLASSES:[Ljava/lang/Class; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/Class<",
            "*>;"
        }
    .end annotation
.end field

.field private static SIGNATURE_OF_PRIMTIVE_CLASSES:[Ljava/lang/String; = null

.field private static final SURROUNDING_THIS_POINTER:Ljava/lang/String; = "this$0"

.field private static final sAdditionalFields:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap<",
            "Ljava/lang/Object;",
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/16 v0, 0x9

    new-array v0, v0, [Ljava/lang/Class;

    sget-object v1, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    const/4 v2, 0x1

    aput-object v1, v0, v2

    sget-object v1, Ljava/lang/Character;->TYPE:Ljava/lang/Class;

    const/4 v2, 0x2

    aput-object v1, v0, v2

    sget-object v1, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    const/4 v2, 0x3

    aput-object v1, v0, v2

    sget-object v1, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    const/4 v2, 0x4

    aput-object v1, v0, v2

    sget-object v1, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    const/4 v2, 0x5

    aput-object v1, v0, v2

    sget-object v1, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    const/4 v2, 0x6

    aput-object v1, v0, v2

    sget-object v1, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    const/4 v2, 0x7

    aput-object v1, v0, v2

    sget-object v1, Ljava/lang/Void;->TYPE:Ljava/lang/Class;

    const/16 v2, 0x8

    aput-object v1, v0, v2

    sput-object v0, Lmiui/reflect/ReflectUtils;->PRIMITIVE_CLASSES:[Ljava/lang/Class;

    const-string v3, "Z"

    const-string v4, "B"

    const-string v5, "C"

    const-string v6, "S"

    const-string v7, "I"

    const-string v8, "J"

    const-string v9, "F"

    const-string v10, "D"

    const-string v11, "V"

    filled-new-array/range {v3 .. v11}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lmiui/reflect/ReflectUtils;->SIGNATURE_OF_PRIMTIVE_CLASSES:[Ljava/lang/String;

    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    sput-object v0, Lmiui/reflect/ReflectUtils;->sAdditionalFields:Ljava/util/WeakHashMap;

    return-void
.end method

.method protected constructor <init>()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InstantiationException;
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/InstantiationException;

    const-string v1, "Cannot instantiate utility class"

    invoke-direct {v0, v1}, Ljava/lang/InstantiationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static getAdditionalField(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 3

    if-eqz p0, :cond_2

    if-eqz p1, :cond_1

    sget-object v0, Lmiui/reflect/ReflectUtils;->sAdditionalFields:Ljava/util/WeakHashMap;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lmiui/reflect/ReflectUtils;->sAdditionalFields:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/HashMap;

    if-nez v1, :cond_0

    const/4 v2, 0x0

    monitor-exit v0

    return-object v2

    :cond_0
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    monitor-enter v1

    :try_start_1
    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :catchall_1
    move-exception v1

    :try_start_2
    monitor-exit v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v1

    :cond_1
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "fieldName must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "object must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static getSignature(Ljava/lang/Class;)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    const/4 v0, 0x0

    :goto_0
    sget-object v1, Lmiui/reflect/ReflectUtils;->PRIMITIVE_CLASSES:[Ljava/lang/Class;

    array-length v2, v1

    if-ge v0, v2, :cond_1

    aget-object v1, v1, v0

    if-ne p0, v1, :cond_0

    sget-object v1, Lmiui/reflect/ReflectUtils;->SIGNATURE_OF_PRIMTIVE_CLASSES:[Ljava/lang/String;

    aget-object v1, v1, v0

    return-object v1

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lmiui/reflect/ReflectUtils;->getSignature(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getSignature(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    const/4 v0, 0x0

    :goto_0
    sget-object v1, Lmiui/reflect/ReflectUtils;->PRIMITIVE_CLASSES:[Ljava/lang/Class;

    array-length v2, v1

    if-ge v0, v2, :cond_1

    aget-object v1, v1, v0

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lmiui/reflect/ReflectUtils;->SIGNATURE_OF_PRIMTIVE_CLASSES:[Ljava/lang/String;

    aget-object p0, v1, v0

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    const-string v0, "."

    const-string v1, "/"

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    const-string v0, "["

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    move-object v0, p0

    goto :goto_1

    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "L"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ";"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_1
    return-object v0
.end method

.method public static getSignature([Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Class<",
            "*>;",
            "Ljava/lang/Class<",
            "*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v1, 0x28

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    if-eqz p0, :cond_0

    array-length v1, p0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_0

    aget-object v3, p0, v2

    invoke-static {v3}, Lmiui/reflect/ReflectUtils;->getSignature(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    const/16 v1, 0x29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-static {p1}, Lmiui/reflect/ReflectUtils;->getSignature(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static getSurroundingThis(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-static {v1}, Lmiui/reflect/ReflectUtils;->getSignature(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "this$0"

    invoke-static {v0, v2, v1}, Lmiui/reflect/Field;->of(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Lmiui/reflect/Field;

    move-result-object v0

    invoke-virtual {v0, p0}, Lmiui/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static removeAdditionalField(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 3

    if-eqz p0, :cond_2

    if-eqz p1, :cond_1

    sget-object v0, Lmiui/reflect/ReflectUtils;->sAdditionalFields:Ljava/util/WeakHashMap;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lmiui/reflect/ReflectUtils;->sAdditionalFields:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/HashMap;

    if-nez v1, :cond_0

    const/4 v2, 0x0

    monitor-exit v0

    return-object v2

    :cond_0
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    monitor-enter v1

    :try_start_1
    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :catchall_1
    move-exception v1

    :try_start_2
    monitor-exit v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v1

    :cond_1
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "fieldName must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "object must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static setAdditionalField(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    if-eqz p0, :cond_2

    if-eqz p1, :cond_1

    sget-object v0, Lmiui/reflect/ReflectUtils;->sAdditionalFields:Ljava/util/WeakHashMap;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lmiui/reflect/ReflectUtils;->sAdditionalFields:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/HashMap;

    if-nez v1, :cond_0

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    move-object v1, v2

    sget-object v2, Lmiui/reflect/ReflectUtils;->sAdditionalFields:Ljava/util/WeakHashMap;

    invoke-virtual {v2, p0, v1}, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    monitor-enter v1

    :try_start_1
    invoke-virtual {v1, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :catchall_1
    move-exception v1

    :try_start_2
    monitor-exit v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v1

    :cond_1
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "fieldName must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "object must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static updateField(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lmiui/reflect/IllegalArgumentException;
        }
    .end annotation

    if-nez p0, :cond_1

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    new-instance v0, Lmiui/reflect/IllegalArgumentException;

    const-string v1, "clazz and holder cannot be all null"

    invoke-direct {v0, v1}, Lmiui/reflect/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    :goto_0
    if-nez p0, :cond_2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p0

    :cond_2
    move-object v0, p0

    :goto_1
    if-eqz v0, :cond_5

    invoke-virtual {v0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v1

    array-length v2, v1

    const/4 v3, 0x0

    :goto_2
    if-ge v3, v2, :cond_4

    aget-object v4, v1, v3

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    :try_start_0
    invoke-virtual {v4, p1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    if-ne v5, p2, :cond_3

    invoke-virtual {v4, p1, p3}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_3
    nop

    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    :catch_0
    move-exception v1

    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    :cond_4
    invoke-virtual {v0}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v0

    goto :goto_1

    :cond_5
    return-void
.end method
