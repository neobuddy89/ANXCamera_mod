.class final Lcom/google/android/gms/internal/measurement/zzgs;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-measurement-base@@17.3.0"

# interfaces
.implements Lcom/google/android/gms/internal/measurement/zzhd;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/internal/measurement/zzhd<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final zza:[I

.field private static final zzb:Lsun/misc/Unsafe;


# instance fields
.field private final zzc:[I

.field private final zzd:[Ljava/lang/Object;

.field private final zze:I

.field private final zzf:I

.field private final zzg:Lcom/google/android/gms/internal/measurement/zzgo;

.field private final zzh:Z

.field private final zzi:Z

.field private final zzj:Z

.field private final zzk:Z

.field private final zzl:[I

.field private final zzm:I

.field private final zzn:I

.field private final zzo:Lcom/google/android/gms/internal/measurement/zzgw;

.field private final zzp:Lcom/google/android/gms/internal/measurement/zzfy;

.field private final zzq:Lcom/google/android/gms/internal/measurement/zzhv;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/measurement/zzhv<",
            "**>;"
        }
    .end annotation
.end field

.field private final zzr:Lcom/google/android/gms/internal/measurement/zzes;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/measurement/zzes<",
            "*>;"
        }
    .end annotation
.end field

.field private final zzs:Lcom/google/android/gms/internal/measurement/zzgh;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lcom/google/android/gms/internal/measurement/zzgs;->zza:[I

    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzib;->zzc()Lsun/misc/Unsafe;

    move-result-object v0

    sput-object v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    return-void
.end method

.method private constructor <init>([I[Ljava/lang/Object;IILcom/google/android/gms/internal/measurement/zzgo;ZZ[IIILcom/google/android/gms/internal/measurement/zzgw;Lcom/google/android/gms/internal/measurement/zzfy;Lcom/google/android/gms/internal/measurement/zzhv;Lcom/google/android/gms/internal/measurement/zzes;Lcom/google/android/gms/internal/measurement/zzgh;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([I[",
            "Ljava/lang/Object;",
            "II",
            "Lcom/google/android/gms/internal/measurement/zzgo;",
            "ZZ[III",
            "Lcom/google/android/gms/internal/measurement/zzgw;",
            "Lcom/google/android/gms/internal/measurement/zzfy;",
            "Lcom/google/android/gms/internal/measurement/zzhv<",
            "**>;",
            "Lcom/google/android/gms/internal/measurement/zzes<",
            "*>;",
            "Lcom/google/android/gms/internal/measurement/zzgh;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    iput-object p2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzd:[Ljava/lang/Object;

    iput p3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zze:I

    iput p4, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzf:I

    instance-of p1, p5, Lcom/google/android/gms/internal/measurement/zzfd;

    iput-boolean p1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzi:Z

    iput-boolean p6, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzj:Z

    const/4 p1, 0x0

    if-eqz p14, :cond_0

    invoke-virtual {p14, p5}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Lcom/google/android/gms/internal/measurement/zzgo;)Z

    move-result p2

    if-eqz p2, :cond_0

    const/4 p2, 0x1

    goto :goto_0

    :cond_0
    move p2, p1

    :goto_0
    iput-boolean p2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    iput-boolean p1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    iput-object p8, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzl:[I

    iput p9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzm:I

    iput p10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzn:I

    iput-object p11, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzo:Lcom/google/android/gms/internal/measurement/zzgw;

    iput-object p12, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    iput-object p13, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    iput-object p14, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    iput-object p5, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzg:Lcom/google/android/gms/internal/measurement/zzgo;

    iput-object p15, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    return-void
.end method

.method private final zza(II)I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zze:I

    if-lt p1, v0, :cond_0

    iget v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzf:I

    if-gt p1, v0, :cond_0

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(II)I

    move-result p1

    return p1

    :cond_0
    const/4 p1, -0x1

    return p1
.end method

.method private static zza(Lcom/google/android/gms/internal/measurement/zzhv;Ljava/lang/Object;)I
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<UT:",
            "Ljava/lang/Object;",
            "UB:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/google/android/gms/internal/measurement/zzhv<",
            "TUT;TUB;>;TT;)I"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/measurement/zzhv;->zzb(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/measurement/zzhv;->zzf(Ljava/lang/Object;)I

    move-result p0

    return p0
.end method

.method private final zza(Ljava/lang/Object;[BIIIIIIIJILcom/google/android/gms/internal/measurement/zzdt;)I
    .locals 16
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;[BIIIIIIIJI",
            "Lcom/google/android/gms/internal/measurement/zzdt;",
            ")I"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v3, p2

    move/from16 v4, p3

    move/from16 v2, p5

    move/from16 v8, p6

    move/from16 v5, p7

    move-wide/from16 v9, p10

    move/from16 v6, p12

    move-object/from16 v11, p13

    sget-object v12, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    iget-object v7, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    add-int/lit8 v13, v6, 0x2

    aget v7, v7, v13

    const v13, 0xfffff

    and-int/2addr v7, v13

    int-to-long v13, v7

    const/4 v7, 0x5

    const/4 v15, 0x2

    packed-switch p9, :pswitch_data_0

    goto/16 :goto_8

    :pswitch_0
    const/4 v7, 0x3

    if-ne v5, v7, :cond_a

    and-int/lit8 v2, v2, -0x8

    or-int/lit8 v7, v2, 0x4

    nop

    invoke-direct {v0, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v2

    move-object/from16 v3, p2

    move/from16 v4, p3

    move/from16 v5, p4

    move v6, v7

    move-object/from16 v7, p13

    invoke-static/range {v2 .. v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(Lcom/google/android/gms/internal/measurement/zzhd;[BIIILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    invoke-virtual {v12, v1, v13, v14}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v3

    if-ne v3, v8, :cond_0

    invoke-virtual {v12, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v15

    goto :goto_0

    :cond_0
    const/4 v15, 0x0

    :goto_0
    if-nez v15, :cond_1

    iget-object v3, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v12, v1, v9, v10, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_7

    :cond_1
    iget-object v3, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-static {v15, v3}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v12, v1, v9, v10, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_7

    :pswitch_1
    if-nez v5, :cond_a

    invoke-static {v3, v4, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    iget-wide v3, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzeg;->zza(J)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v12, v1, v9, v10, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_7

    :pswitch_2
    if-nez v5, :cond_a

    invoke-static {v3, v4, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    iget v3, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzeg;->zze(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v12, v1, v9, v10, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_7

    :pswitch_3
    if-nez v5, :cond_a

    invoke-static {v3, v4, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v3

    iget v4, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-direct {v0, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(I)Lcom/google/android/gms/internal/measurement/zzfk;

    move-result-object v5

    if-eqz v5, :cond_3

    invoke-interface {v5, v4}, Lcom/google/android/gms/internal/measurement/zzfk;->zza(I)Z

    move-result v5

    if-eqz v5, :cond_2

    goto :goto_1

    :cond_2
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzhy;

    move-result-object v1

    int-to-long v4, v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Lcom/google/android/gms/internal/measurement/zzhy;->zza(ILjava/lang/Object;)V

    move v2, v3

    goto/16 :goto_9

    :cond_3
    :goto_1
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v12, v1, v9, v10, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move v2, v3

    goto/16 :goto_7

    :pswitch_4
    if-ne v5, v15, :cond_a

    invoke-static {v3, v4, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zze([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    iget-object v3, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v12, v1, v9, v10, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_7

    :pswitch_5
    if-ne v5, v15, :cond_a

    nop

    invoke-direct {v0, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v2

    move/from16 v5, p4

    invoke-static {v2, v3, v4, v5, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(Lcom/google/android/gms/internal/measurement/zzhd;[BIILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    invoke-virtual {v12, v1, v13, v14}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v3

    if-ne v3, v8, :cond_4

    invoke-virtual {v12, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v15

    goto :goto_2

    :cond_4
    const/4 v15, 0x0

    :goto_2
    if-nez v15, :cond_5

    iget-object v3, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v12, v1, v9, v10, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_3

    :cond_5
    iget-object v3, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-static {v15, v3}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v12, v1, v9, v10, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :goto_3
    invoke-virtual {v12, v1, v13, v14, v8}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto/16 :goto_9

    :pswitch_6
    if-ne v5, v15, :cond_a

    invoke-static {v3, v4, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    iget v4, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-nez v4, :cond_6

    const-string v3, ""

    invoke-virtual {v12, v1, v9, v10, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_5

    :cond_6
    const/high16 v5, 0x20000000

    and-int v5, p8, v5

    if-eqz v5, :cond_8

    add-int v5, v2, v4

    invoke-static {v3, v2, v5}, Lcom/google/android/gms/internal/measurement/zzie;->zza([BII)Z

    move-result v5

    if-eqz v5, :cond_7

    goto :goto_4

    :cond_7
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzh()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_8
    :goto_4
    new-instance v5, Ljava/lang/String;

    sget-object v6, Lcom/google/android/gms/internal/measurement/zzff;->zza:Ljava/nio/charset/Charset;

    invoke-direct {v5, v3, v2, v4, v6}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    invoke-virtual {v12, v1, v9, v10, v5}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    add-int/2addr v2, v4

    :goto_5
    invoke-virtual {v12, v1, v13, v14, v8}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto/16 :goto_9

    :pswitch_7
    if-nez v5, :cond_a

    invoke-static {v3, v4, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    iget-wide v3, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-eqz v3, :cond_9

    const/4 v15, 0x1

    goto :goto_6

    :cond_9
    const/4 v15, 0x0

    :goto_6
    invoke-static {v15}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v12, v1, v9, v10, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_7

    :pswitch_8
    if-ne v5, v7, :cond_a

    invoke-static/range {p2 .. p3}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BI)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v12, v1, v9, v10, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    add-int/lit8 v2, v4, 0x4

    goto :goto_7

    :pswitch_9
    const/4 v2, 0x1

    if-ne v5, v2, :cond_a

    invoke-static/range {p2 .. p3}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BI)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v12, v1, v9, v10, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    add-int/lit8 v2, v4, 0x8

    goto :goto_7

    :pswitch_a
    if-nez v5, :cond_a

    invoke-static {v3, v4, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    iget v3, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v12, v1, v9, v10, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_7

    :pswitch_b
    if-nez v5, :cond_a

    invoke-static {v3, v4, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    iget-wide v3, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v12, v1, v9, v10, v3}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_7

    :pswitch_c
    if-ne v5, v7, :cond_a

    invoke-static/range {p2 .. p3}, Lcom/google/android/gms/internal/measurement/zzdq;->zzd([BI)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v12, v1, v9, v10, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    add-int/lit8 v2, v4, 0x4

    goto :goto_7

    :pswitch_d
    const/4 v2, 0x1

    if-ne v5, v2, :cond_a

    invoke-static/range {p2 .. p3}, Lcom/google/android/gms/internal/measurement/zzdq;->zzc([BI)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v12, v1, v9, v10, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    add-int/lit8 v2, v4, 0x8

    nop

    :goto_7
    invoke-virtual {v12, v1, v13, v14, v8}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    goto :goto_9

    :cond_a
    :goto_8
    move v2, v4

    :goto_9
    return v2

    :pswitch_data_0
    .packed-switch 0x33
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_a
        :pswitch_3
        :pswitch_8
        :pswitch_9
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private final zza(Ljava/lang/Object;[BIIIIIIJIJLcom/google/android/gms/internal/measurement/zzdt;)I
    .locals 16
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;[BIIIIIIJIJ",
            "Lcom/google/android/gms/internal/measurement/zzdt;",
            ")I"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v3, p2

    move/from16 v4, p3

    move/from16 v5, p4

    move/from16 v2, p5

    move/from16 v6, p7

    move/from16 v8, p8

    move-wide/from16 v9, p12

    move-object/from16 v7, p14

    sget-object v11, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v11, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzfl;

    invoke-interface {v11}, Lcom/google/android/gms/internal/measurement/zzfl;->zza()Z

    move-result v12

    const/4 v13, 0x1

    if-nez v12, :cond_1

    invoke-interface {v11}, Lcom/google/android/gms/internal/measurement/zzfl;->size()I

    move-result v12

    nop

    if-nez v12, :cond_0

    const/16 v12, 0xa

    goto :goto_0

    :cond_0
    shl-int/2addr v12, v13

    :goto_0
    invoke-interface {v11, v12}, Lcom/google/android/gms/internal/measurement/zzfl;->zza(I)Lcom/google/android/gms/internal/measurement/zzfl;

    move-result-object v11

    sget-object v12, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v12, v1, v9, v10, v11}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :cond_1
    const/4 v9, 0x5

    const-wide/16 v14, 0x0

    const/4 v10, 0x2

    packed-switch p11, :pswitch_data_0

    goto/16 :goto_19

    :pswitch_0
    const/4 v1, 0x3

    if-ne v6, v1, :cond_3e

    nop

    invoke-direct {v0, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v1

    nop

    nop

    and-int/lit8 v6, v2, -0x8

    or-int/lit8 v6, v6, 0x4

    move-object/from16 p6, v1

    move-object/from16 p7, p2

    move/from16 p8, p3

    move/from16 p9, p4

    move/from16 p10, v6

    move-object/from16 p11, p14

    invoke-static/range {p6 .. p11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(Lcom/google/android/gms/internal/measurement/zzhd;[BIIILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget-object v8, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-interface {v11, v8}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    :goto_1
    if-ge v4, v5, :cond_2

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v8

    iget v9, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v9, :cond_2

    move-object/from16 p6, v1

    move-object/from16 p7, p2

    move/from16 p8, v8

    move/from16 p9, p4

    move/from16 p10, v6

    move-object/from16 p11, p14

    invoke-static/range {p6 .. p11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(Lcom/google/android/gms/internal/measurement/zzhd;[BIIILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget-object v8, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-interface {v11, v8}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_2
    nop

    move v1, v4

    goto/16 :goto_1a

    :pswitch_1
    if-ne v6, v10, :cond_5

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzgc;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v2, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    add-int/2addr v2, v1

    :goto_2
    if-ge v1, v2, :cond_3

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget-wide v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/measurement/zzeg;->zza(J)J

    move-result-wide v4

    invoke-virtual {v11, v4, v5}, Lcom/google/android/gms/internal/measurement/zzgc;->zza(J)V

    goto :goto_2

    :cond_3
    if-ne v1, v2, :cond_4

    nop

    goto/16 :goto_1a

    :cond_4
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zza()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_5
    if-nez v6, :cond_3e

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzgc;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget-wide v8, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-static {v8, v9}, Lcom/google/android/gms/internal/measurement/zzeg;->zza(J)J

    move-result-wide v8

    invoke-virtual {v11, v8, v9}, Lcom/google/android/gms/internal/measurement/zzgc;->zza(J)V

    :goto_3
    if-ge v1, v5, :cond_6

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget v6, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v6, :cond_6

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget-wide v8, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-static {v8, v9}, Lcom/google/android/gms/internal/measurement/zzeg;->zza(J)J

    move-result-wide v8

    invoke-virtual {v11, v8, v9}, Lcom/google/android/gms/internal/measurement/zzgc;->zza(J)V

    goto :goto_3

    :cond_6
    nop

    goto/16 :goto_1a

    :pswitch_2
    if-ne v6, v10, :cond_9

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzfg;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v2, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    add-int/2addr v2, v1

    :goto_4
    if-ge v1, v2, :cond_7

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzeg;->zze(I)I

    move-result v4

    invoke-virtual {v11, v4}, Lcom/google/android/gms/internal/measurement/zzfg;->zzd(I)V

    goto :goto_4

    :cond_7
    if-ne v1, v2, :cond_8

    nop

    goto/16 :goto_1a

    :cond_8
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zza()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_9
    if-nez v6, :cond_3e

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzfg;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzeg;->zze(I)I

    move-result v4

    invoke-virtual {v11, v4}, Lcom/google/android/gms/internal/measurement/zzfg;->zzd(I)V

    :goto_5
    if-ge v1, v5, :cond_a

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget v6, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v6, :cond_a

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzeg;->zze(I)I

    move-result v4

    invoke-virtual {v11, v4}, Lcom/google/android/gms/internal/measurement/zzfg;->zzd(I)V

    goto :goto_5

    :cond_a
    nop

    goto/16 :goto_1a

    :pswitch_3
    if-ne v6, v10, :cond_b

    invoke-static {v3, v4, v11, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzfl;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    goto :goto_6

    :cond_b
    if-nez v6, :cond_3e

    move/from16 v2, p5

    move-object/from16 v3, p2

    move/from16 v4, p3

    move/from16 v5, p4

    move-object v6, v11

    move-object/from16 v7, p14

    invoke-static/range {v2 .. v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(I[BIILcom/google/android/gms/internal/measurement/zzfl;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    :goto_6
    check-cast v1, Lcom/google/android/gms/internal/measurement/zzfd;

    iget-object v3, v1, Lcom/google/android/gms/internal/measurement/zzfd;->zzb:Lcom/google/android/gms/internal/measurement/zzhy;

    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzhy;->zza()Lcom/google/android/gms/internal/measurement/zzhy;

    move-result-object v4

    if-ne v3, v4, :cond_c

    const/4 v3, 0x0

    :cond_c
    nop

    invoke-direct {v0, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(I)Lcom/google/android/gms/internal/measurement/zzfk;

    move-result-object v4

    iget-object v5, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    move/from16 v6, p6

    invoke-static {v6, v11, v4, v3, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzfk;Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/measurement/zzhy;

    if-eqz v3, :cond_d

    iput-object v3, v1, Lcom/google/android/gms/internal/measurement/zzfd;->zzb:Lcom/google/android/gms/internal/measurement/zzhy;

    :cond_d
    move v1, v2

    goto/16 :goto_1a

    :pswitch_4
    if-ne v6, v10, :cond_3e

    nop

    nop

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ltz v4, :cond_14

    array-length v6, v3

    sub-int/2addr v6, v1

    if-gt v4, v6, :cond_13

    if-nez v4, :cond_e

    sget-object v4, Lcom/google/android/gms/internal/measurement/zzdu;->zza:Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-interface {v11, v4}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    goto :goto_7

    :cond_e
    invoke-static {v3, v1, v4}, Lcom/google/android/gms/internal/measurement/zzdu;->zza([BII)Lcom/google/android/gms/internal/measurement/zzdu;

    move-result-object v6

    invoke-interface {v11, v6}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    add-int/2addr v1, v4

    :goto_7
    if-ge v1, v5, :cond_12

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget v6, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v6, :cond_12

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ltz v4, :cond_11

    array-length v6, v3

    sub-int/2addr v6, v1

    if-gt v4, v6, :cond_10

    if-nez v4, :cond_f

    sget-object v4, Lcom/google/android/gms/internal/measurement/zzdu;->zza:Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-interface {v11, v4}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    goto :goto_7

    :cond_f
    invoke-static {v3, v1, v4}, Lcom/google/android/gms/internal/measurement/zzdu;->zza([BII)Lcom/google/android/gms/internal/measurement/zzdu;

    move-result-object v6

    invoke-interface {v11, v6}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    add-int/2addr v1, v4

    goto :goto_7

    :cond_10
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zza()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_11
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzb()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_12
    nop

    goto/16 :goto_1a

    :cond_13
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zza()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_14
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzb()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :pswitch_5
    if-ne v6, v10, :cond_3e

    nop

    invoke-direct {v0, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v1

    move-object/from16 p6, v1

    move/from16 p7, p5

    move-object/from16 p8, p2

    move/from16 p9, p3

    move/from16 p10, p4

    move-object/from16 p11, v11

    move-object/from16 p12, p14

    invoke-static/range {p6 .. p12}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(Lcom/google/android/gms/internal/measurement/zzhd;I[BIILcom/google/android/gms/internal/measurement/zzfl;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    goto/16 :goto_1a

    :pswitch_6
    if-ne v6, v10, :cond_3e

    const-wide/32 v8, 0x20000000

    and-long v8, p9, v8

    cmp-long v1, v8, v14

    const-string v6, ""

    if-nez v1, :cond_1a

    nop

    nop

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ltz v4, :cond_19

    if-nez v4, :cond_15

    invoke-interface {v11, v6}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    goto :goto_8

    :cond_15
    new-instance v8, Ljava/lang/String;

    sget-object v9, Lcom/google/android/gms/internal/measurement/zzff;->zza:Ljava/nio/charset/Charset;

    invoke-direct {v8, v3, v1, v4, v9}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    invoke-interface {v11, v8}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    add-int/2addr v1, v4

    :goto_8
    if-ge v1, v5, :cond_18

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget v8, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v8, :cond_18

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ltz v4, :cond_17

    if-nez v4, :cond_16

    invoke-interface {v11, v6}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    goto :goto_8

    :cond_16
    new-instance v8, Ljava/lang/String;

    sget-object v9, Lcom/google/android/gms/internal/measurement/zzff;->zza:Ljava/nio/charset/Charset;

    invoke-direct {v8, v3, v1, v4, v9}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    invoke-interface {v11, v8}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    add-int/2addr v1, v4

    goto :goto_8

    :cond_17
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzb()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_18
    nop

    goto/16 :goto_1a

    :cond_19
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzb()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_1a
    nop

    nop

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ltz v4, :cond_21

    if-nez v4, :cond_1b

    invoke-interface {v11, v6}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    goto :goto_9

    :cond_1b
    add-int v8, v1, v4

    invoke-static {v3, v1, v8}, Lcom/google/android/gms/internal/measurement/zzie;->zza([BII)Z

    move-result v9

    if-eqz v9, :cond_20

    new-instance v9, Ljava/lang/String;

    sget-object v10, Lcom/google/android/gms/internal/measurement/zzff;->zza:Ljava/nio/charset/Charset;

    invoke-direct {v9, v3, v1, v4, v10}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    invoke-interface {v11, v9}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    move v1, v8

    :goto_9
    if-ge v1, v5, :cond_1f

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget v8, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v8, :cond_1f

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ltz v4, :cond_1e

    if-nez v4, :cond_1c

    invoke-interface {v11, v6}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    goto :goto_9

    :cond_1c
    add-int v8, v1, v4

    invoke-static {v3, v1, v8}, Lcom/google/android/gms/internal/measurement/zzie;->zza([BII)Z

    move-result v9

    if-eqz v9, :cond_1d

    new-instance v9, Ljava/lang/String;

    sget-object v10, Lcom/google/android/gms/internal/measurement/zzff;->zza:Ljava/nio/charset/Charset;

    invoke-direct {v9, v3, v1, v4, v10}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    invoke-interface {v11, v9}, Lcom/google/android/gms/internal/measurement/zzfl;->add(Ljava/lang/Object;)Z

    nop

    move v1, v8

    goto :goto_9

    :cond_1d
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzh()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_1e
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzb()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_1f
    nop

    goto/16 :goto_1a

    :cond_20
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzh()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_21
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzb()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :pswitch_7
    const/4 v1, 0x0

    if-ne v6, v10, :cond_25

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzds;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    iget v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    add-int/2addr v4, v2

    :goto_a
    if-ge v2, v4, :cond_23

    invoke-static {v3, v2, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v2

    iget-wide v5, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    cmp-long v5, v5, v14

    if-eqz v5, :cond_22

    move v5, v13

    goto :goto_b

    :cond_22
    move v5, v1

    :goto_b
    invoke-virtual {v11, v5}, Lcom/google/android/gms/internal/measurement/zzds;->zza(Z)V

    goto :goto_a

    :cond_23
    if-ne v2, v4, :cond_24

    nop

    move v1, v2

    goto/16 :goto_1a

    :cond_24
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zza()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_25
    if-nez v6, :cond_3e

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzds;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget-wide v8, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    cmp-long v6, v8, v14

    if-eqz v6, :cond_26

    move v6, v13

    goto :goto_c

    :cond_26
    move v6, v1

    :goto_c
    invoke-virtual {v11, v6}, Lcom/google/android/gms/internal/measurement/zzds;->zza(Z)V

    :goto_d
    if-ge v4, v5, :cond_28

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v6

    iget v8, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v8, :cond_28

    invoke-static {v3, v6, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget-wide v8, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    cmp-long v6, v8, v14

    if-eqz v6, :cond_27

    move v6, v13

    goto :goto_e

    :cond_27
    move v6, v1

    :goto_e
    invoke-virtual {v11, v6}, Lcom/google/android/gms/internal/measurement/zzds;->zza(Z)V

    goto :goto_d

    :cond_28
    nop

    move v1, v4

    goto/16 :goto_1a

    :pswitch_8
    if-ne v6, v10, :cond_2b

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzfg;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v2, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    add-int/2addr v2, v1

    :goto_f
    if-ge v1, v2, :cond_29

    invoke-static {v3, v1}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BI)I

    move-result v4

    invoke-virtual {v11, v4}, Lcom/google/android/gms/internal/measurement/zzfg;->zzd(I)V

    add-int/lit8 v1, v1, 0x4

    goto :goto_f

    :cond_29
    if-ne v1, v2, :cond_2a

    nop

    goto/16 :goto_1a

    :cond_2a
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zza()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_2b
    if-ne v6, v9, :cond_3e

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzfg;

    invoke-static/range {p2 .. p3}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BI)I

    move-result v1

    invoke-virtual {v11, v1}, Lcom/google/android/gms/internal/measurement/zzfg;->zzd(I)V

    add-int/lit8 v1, v4, 0x4

    :goto_10
    if-ge v1, v5, :cond_2c

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget v6, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v6, :cond_2c

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BI)I

    move-result v1

    invoke-virtual {v11, v1}, Lcom/google/android/gms/internal/measurement/zzfg;->zzd(I)V

    add-int/lit8 v1, v4, 0x4

    goto :goto_10

    :cond_2c
    nop

    goto/16 :goto_1a

    :pswitch_9
    if-ne v6, v10, :cond_2f

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzgc;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v2, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    add-int/2addr v2, v1

    :goto_11
    if-ge v1, v2, :cond_2d

    invoke-static {v3, v1}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BI)J

    move-result-wide v4

    invoke-virtual {v11, v4, v5}, Lcom/google/android/gms/internal/measurement/zzgc;->zza(J)V

    add-int/lit8 v1, v1, 0x8

    goto :goto_11

    :cond_2d
    if-ne v1, v2, :cond_2e

    nop

    goto/16 :goto_1a

    :cond_2e
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zza()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_2f
    if-ne v6, v13, :cond_3e

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzgc;

    invoke-static/range {p2 .. p3}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BI)J

    move-result-wide v8

    invoke-virtual {v11, v8, v9}, Lcom/google/android/gms/internal/measurement/zzgc;->zza(J)V

    add-int/lit8 v1, v4, 0x8

    :goto_12
    if-ge v1, v5, :cond_30

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget v6, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v6, :cond_30

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BI)J

    move-result-wide v8

    invoke-virtual {v11, v8, v9}, Lcom/google/android/gms/internal/measurement/zzgc;->zza(J)V

    add-int/lit8 v1, v4, 0x8

    goto :goto_12

    :cond_30
    nop

    goto/16 :goto_1a

    :pswitch_a
    if-ne v6, v10, :cond_31

    invoke-static {v3, v4, v11, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzfl;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    goto/16 :goto_1a

    :cond_31
    if-nez v6, :cond_3e

    move-object/from16 p6, p2

    move/from16 p7, p3

    move/from16 p8, p4

    move-object/from16 p9, v11

    move-object/from16 p10, p14

    invoke-static/range {p5 .. p10}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(I[BIILcom/google/android/gms/internal/measurement/zzfl;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    goto/16 :goto_1a

    :pswitch_b
    if-ne v6, v10, :cond_34

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzgc;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v2, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    add-int/2addr v2, v1

    :goto_13
    if-ge v1, v2, :cond_32

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget-wide v4, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-virtual {v11, v4, v5}, Lcom/google/android/gms/internal/measurement/zzgc;->zza(J)V

    goto :goto_13

    :cond_32
    if-ne v1, v2, :cond_33

    nop

    goto/16 :goto_1a

    :cond_33
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zza()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_34
    if-nez v6, :cond_3e

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzgc;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget-wide v8, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-virtual {v11, v8, v9}, Lcom/google/android/gms/internal/measurement/zzgc;->zza(J)V

    :goto_14
    if-ge v1, v5, :cond_35

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget v6, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v6, :cond_35

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget-wide v8, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-virtual {v11, v8, v9}, Lcom/google/android/gms/internal/measurement/zzgc;->zza(J)V

    goto :goto_14

    :cond_35
    nop

    goto/16 :goto_1a

    :pswitch_c
    if-ne v6, v10, :cond_38

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzfc;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v2, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    add-int/2addr v2, v1

    :goto_15
    if-ge v1, v2, :cond_36

    invoke-static {v3, v1}, Lcom/google/android/gms/internal/measurement/zzdq;->zzd([BI)F

    move-result v4

    invoke-virtual {v11, v4}, Lcom/google/android/gms/internal/measurement/zzfc;->zza(F)V

    add-int/lit8 v1, v1, 0x4

    goto :goto_15

    :cond_36
    if-ne v1, v2, :cond_37

    nop

    goto/16 :goto_1a

    :cond_37
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zza()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_38
    if-ne v6, v9, :cond_3e

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzfc;

    invoke-static/range {p2 .. p3}, Lcom/google/android/gms/internal/measurement/zzdq;->zzd([BI)F

    move-result v1

    invoke-virtual {v11, v1}, Lcom/google/android/gms/internal/measurement/zzfc;->zza(F)V

    add-int/lit8 v1, v4, 0x4

    :goto_16
    if-ge v1, v5, :cond_39

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget v6, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v6, :cond_39

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzdq;->zzd([BI)F

    move-result v1

    invoke-virtual {v11, v1}, Lcom/google/android/gms/internal/measurement/zzfc;->zza(F)V

    add-int/lit8 v1, v4, 0x4

    goto :goto_16

    :cond_39
    nop

    goto :goto_1a

    :pswitch_d
    if-ne v6, v10, :cond_3c

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzeo;

    invoke-static {v3, v4, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget v2, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    add-int/2addr v2, v1

    :goto_17
    if-ge v1, v2, :cond_3a

    invoke-static {v3, v1}, Lcom/google/android/gms/internal/measurement/zzdq;->zzc([BI)D

    move-result-wide v4

    invoke-virtual {v11, v4, v5}, Lcom/google/android/gms/internal/measurement/zzeo;->zza(D)V

    add-int/lit8 v1, v1, 0x8

    goto :goto_17

    :cond_3a
    if-ne v1, v2, :cond_3b

    nop

    goto :goto_1a

    :cond_3b
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zza()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v1

    throw v1

    :cond_3c
    if-ne v6, v13, :cond_3e

    nop

    check-cast v11, Lcom/google/android/gms/internal/measurement/zzeo;

    invoke-static/range {p2 .. p3}, Lcom/google/android/gms/internal/measurement/zzdq;->zzc([BI)D

    move-result-wide v8

    invoke-virtual {v11, v8, v9}, Lcom/google/android/gms/internal/measurement/zzeo;->zza(D)V

    add-int/lit8 v1, v4, 0x8

    :goto_18
    if-ge v1, v5, :cond_3d

    invoke-static {v3, v1, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v4

    iget v6, v7, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ne v2, v6, :cond_3d

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzdq;->zzc([BI)D

    move-result-wide v8

    invoke-virtual {v11, v8, v9}, Lcom/google/android/gms/internal/measurement/zzeo;->zza(D)V

    add-int/lit8 v1, v4, 0x8

    goto :goto_18

    :cond_3d
    nop

    goto :goto_1a

    :cond_3e
    :goto_19
    move v1, v4

    :goto_1a
    return v1

    :pswitch_data_0
    .packed-switch 0x12
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_a
        :pswitch_3
        :pswitch_8
        :pswitch_9
        :pswitch_2
        :pswitch_1
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_a
        :pswitch_3
        :pswitch_8
        :pswitch_9
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private final zza(Ljava/lang/Object;[BIIIJLcom/google/android/gms/internal/measurement/zzdt;)I
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "V:",
            "Ljava/lang/Object;",
            ">(TT;[BIIIJ",
            "Lcom/google/android/gms/internal/measurement/zzdt;",
            ")I"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    sget-object v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    invoke-direct {p0, p5}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(I)Ljava/lang/Object;

    move-result-object p5

    invoke-virtual {v0, p1, p6, p7}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v2, v1}, Lcom/google/android/gms/internal/measurement/zzgh;->zzc(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    nop

    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v2, p5}, Lcom/google/android/gms/internal/measurement/zzgh;->zze(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v3, v2, v1}, Lcom/google/android/gms/internal/measurement/zzgh;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0, p1, p6, p7, v2}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object v1, v2

    :cond_0
    iget-object p1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {p1, p5}, Lcom/google/android/gms/internal/measurement/zzgh;->zzf(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzgf;

    move-result-object p1

    iget-object p5, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {p5, v1}, Lcom/google/android/gms/internal/measurement/zzgh;->zza(Ljava/lang/Object;)Ljava/util/Map;

    move-result-object p5

    nop

    invoke-static {p2, p3, p8}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p3

    iget p6, p8, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    if-ltz p6, :cond_7

    sub-int p7, p4, p3

    if-gt p6, p7, :cond_7

    add-int/2addr p6, p3

    iget-object p7, p1, Lcom/google/android/gms/internal/measurement/zzgf;->zzb:Ljava/lang/Object;

    iget-object v0, p1, Lcom/google/android/gms/internal/measurement/zzgf;->zzd:Ljava/lang/Object;

    :goto_0
    if-ge p3, p6, :cond_5

    add-int/lit8 v1, p3, 0x1

    aget-byte p3, p2, p3

    if-gez p3, :cond_1

    invoke-static {p3, p2, v1, p8}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(I[BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget p3, p8, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    move v2, v1

    goto :goto_1

    :cond_1
    move v2, v1

    :goto_1
    ushr-int/lit8 v1, p3, 0x3

    and-int/lit8 v3, p3, 0x7

    const/4 v4, 0x1

    if-eq v1, v4, :cond_3

    const/4 v4, 0x2

    if-eq v1, v4, :cond_2

    goto :goto_2

    :cond_2
    iget-object v1, p1, Lcom/google/android/gms/internal/measurement/zzgf;->zzc:Lcom/google/android/gms/internal/measurement/zzim;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/measurement/zzim;->zzb()I

    move-result v1

    if-ne v3, v1, :cond_4

    iget-object v4, p1, Lcom/google/android/gms/internal/measurement/zzgf;->zzc:Lcom/google/android/gms/internal/measurement/zzim;

    iget-object p3, p1, Lcom/google/android/gms/internal/measurement/zzgf;->zzd:Ljava/lang/Object;

    invoke-virtual {p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    move-object v1, p2

    move v3, p4

    move-object v6, p8

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza([BIILcom/google/android/gms/internal/measurement/zzim;Ljava/lang/Class;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p3

    iget-object v0, p8, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    goto :goto_0

    :cond_3
    iget-object v1, p1, Lcom/google/android/gms/internal/measurement/zzgf;->zza:Lcom/google/android/gms/internal/measurement/zzim;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/measurement/zzim;->zzb()I

    move-result v1

    if-ne v3, v1, :cond_4

    iget-object v4, p1, Lcom/google/android/gms/internal/measurement/zzgf;->zza:Lcom/google/android/gms/internal/measurement/zzim;

    const/4 v5, 0x0

    move-object v1, p2

    move v3, p4

    move-object v6, p8

    invoke-static/range {v1 .. v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza([BIILcom/google/android/gms/internal/measurement/zzim;Ljava/lang/Class;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p3

    iget-object p7, p8, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    goto :goto_0

    :cond_4
    :goto_2
    invoke-static {p3, p2, v2, p4, p8}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(I[BIILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p3

    goto :goto_0

    :cond_5
    if-ne p3, p6, :cond_6

    invoke-interface {p5, p7, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    nop

    return p6

    :cond_6
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzg()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object p1

    throw p1

    :cond_7
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zza()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object p1

    throw p1
.end method

.method private static zza([BIILcom/google/android/gms/internal/measurement/zzim;Ljava/lang/Class;Lcom/google/android/gms/internal/measurement/zzdt;)I
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([BII",
            "Lcom/google/android/gms/internal/measurement/zzim;",
            "Ljava/lang/Class<",
            "*>;",
            "Lcom/google/android/gms/internal/measurement/zzdt;",
            ")I"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    sget-object v0, Lcom/google/android/gms/internal/measurement/zzgr;->zza:[I

    invoke-virtual {p3}, Lcom/google/android/gms/internal/measurement/zzim;->ordinal()I

    move-result p3

    aget p3, v0, p3

    packed-switch p3, :pswitch_data_0

    new-instance p0, Ljava/lang/RuntimeException;

    const-string p1, "unsupported field type."

    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p0

    :pswitch_0
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/measurement/zzdq;->zzd([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p0

    goto/16 :goto_1

    :pswitch_1
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p0

    iget-wide p1, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-static {p1, p2}, Lcom/google/android/gms/internal/measurement/zzeg;->zza(J)J

    move-result-wide p1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    iput-object p1, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    goto/16 :goto_1

    :pswitch_2
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p0

    iget p1, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-static {p1}, Lcom/google/android/gms/internal/measurement/zzeg;->zze(I)I

    move-result p1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    iput-object p1, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    goto/16 :goto_1

    :pswitch_3
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzgz;->zza()Lcom/google/android/gms/internal/measurement/zzgz;

    move-result-object p3

    invoke-virtual {p3, p4}, Lcom/google/android/gms/internal/measurement/zzgz;->zza(Ljava/lang/Class;)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object p3

    invoke-static {p3, p0, p1, p2, p5}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(Lcom/google/android/gms/internal/measurement/zzhd;[BIILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p0

    goto :goto_1

    :pswitch_4
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p0

    iget-wide p1, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    iput-object p1, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    goto :goto_1

    :pswitch_5
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p0

    iget p1, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    iput-object p1, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    goto :goto_1

    :pswitch_6
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/measurement/zzdq;->zzd([BI)F

    move-result p0

    invoke-static {p0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p0

    iput-object p0, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    add-int/lit8 p0, p1, 0x4

    goto :goto_1

    :pswitch_7
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BI)J

    move-result-wide p2

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    iput-object p0, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    add-int/lit8 p0, p1, 0x8

    goto :goto_1

    :pswitch_8
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BI)I

    move-result p0

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    iput-object p0, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    add-int/lit8 p0, p1, 0x4

    goto :goto_1

    :pswitch_9
    invoke-static {p0, p1}, Lcom/google/android/gms/internal/measurement/zzdq;->zzc([BI)D

    move-result-wide p2

    invoke-static {p2, p3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p0

    iput-object p0, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    add-int/lit8 p0, p1, 0x8

    goto :goto_1

    :pswitch_a
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/measurement/zzdq;->zze([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p0

    goto :goto_1

    :pswitch_b
    invoke-static {p0, p1, p5}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result p0

    iget-wide p1, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    const-wide/16 p3, 0x0

    cmp-long p1, p1, p3

    if-eqz p1, :cond_0

    const/4 p1, 0x1

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    :goto_0
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    iput-object p1, p5, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    nop

    :goto_1
    return p0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_8
        :pswitch_7
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_4
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method static zza(Ljava/lang/Class;Lcom/google/android/gms/internal/measurement/zzgm;Lcom/google/android/gms/internal/measurement/zzgw;Lcom/google/android/gms/internal/measurement/zzfy;Lcom/google/android/gms/internal/measurement/zzhv;Lcom/google/android/gms/internal/measurement/zzes;Lcom/google/android/gms/internal/measurement/zzgh;)Lcom/google/android/gms/internal/measurement/zzgs;
    .locals 36
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;",
            "Lcom/google/android/gms/internal/measurement/zzgm;",
            "Lcom/google/android/gms/internal/measurement/zzgw;",
            "Lcom/google/android/gms/internal/measurement/zzfy;",
            "Lcom/google/android/gms/internal/measurement/zzhv<",
            "**>;",
            "Lcom/google/android/gms/internal/measurement/zzes<",
            "*>;",
            "Lcom/google/android/gms/internal/measurement/zzgh;",
            ")",
            "Lcom/google/android/gms/internal/measurement/zzgs<",
            "TT;>;"
        }
    .end annotation

    move-object/from16 v0, p1

    instance-of v1, v0, Lcom/google/android/gms/internal/measurement/zzhb;

    if-eqz v1, :cond_35

    check-cast v0, Lcom/google/android/gms/internal/measurement/zzhb;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/measurement/zzhb;->zza()I

    move-result v1

    sget v2, Lcom/google/android/gms/internal/measurement/zzfd$zze;->zzi:I

    const/4 v3, 0x0

    if-ne v1, v2, :cond_0

    const/4 v11, 0x1

    goto :goto_0

    :cond_0
    move v11, v3

    :goto_0
    invoke-virtual {v0}, Lcom/google/android/gms/internal/measurement/zzhb;->zzd()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    nop

    invoke-virtual {v1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const v7, 0xd800

    if-lt v5, v7, :cond_2

    and-int/lit16 v5, v5, 0x1fff

    const/4 v8, 0x1

    const/16 v9, 0xd

    :goto_1
    add-int/lit8 v10, v8, 0x1

    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    if-lt v8, v7, :cond_1

    and-int/lit16 v8, v8, 0x1fff

    shl-int/2addr v8, v9

    or-int/2addr v5, v8

    add-int/lit8 v9, v9, 0xd

    move v8, v10

    goto :goto_1

    :cond_1
    shl-int/2addr v8, v9

    or-int/2addr v5, v8

    goto :goto_2

    :cond_2
    const/4 v10, 0x1

    :goto_2
    nop

    add-int/lit8 v8, v10, 0x1

    invoke-virtual {v1, v10}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-lt v9, v7, :cond_4

    and-int/lit16 v9, v9, 0x1fff

    const/16 v10, 0xd

    :goto_3
    add-int/lit8 v12, v8, 0x1

    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    if-lt v8, v7, :cond_3

    and-int/lit16 v8, v8, 0x1fff

    shl-int/2addr v8, v10

    or-int/2addr v9, v8

    add-int/lit8 v10, v10, 0xd

    move v8, v12

    goto :goto_3

    :cond_3
    shl-int/2addr v8, v10

    or-int/2addr v9, v8

    move v8, v12

    :cond_4
    nop

    if-nez v9, :cond_5

    nop

    nop

    nop

    nop

    nop

    nop

    sget-object v9, Lcom/google/android/gms/internal/measurement/zzgs;->zza:[I

    move v6, v3

    move v10, v6

    move v12, v10

    move v13, v12

    move v15, v13

    move-object v14, v9

    move v9, v15

    goto/16 :goto_d

    :cond_5
    add-int/lit8 v9, v8, 0x1

    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    if-lt v8, v7, :cond_7

    and-int/lit16 v8, v8, 0x1fff

    const/16 v10, 0xd

    :goto_4
    add-int/lit8 v12, v9, 0x1

    invoke-virtual {v1, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-lt v9, v7, :cond_6

    and-int/lit16 v9, v9, 0x1fff

    shl-int/2addr v9, v10

    or-int/2addr v8, v9

    add-int/lit8 v10, v10, 0xd

    move v9, v12

    goto :goto_4

    :cond_6
    shl-int/2addr v9, v10

    or-int/2addr v8, v9

    move v9, v12

    :cond_7
    nop

    add-int/lit8 v10, v9, 0x1

    invoke-virtual {v1, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-lt v9, v7, :cond_9

    and-int/lit16 v9, v9, 0x1fff

    const/16 v12, 0xd

    :goto_5
    add-int/lit8 v13, v10, 0x1

    invoke-virtual {v1, v10}, Ljava/lang/String;->charAt(I)C

    move-result v10

    if-lt v10, v7, :cond_8

    and-int/lit16 v10, v10, 0x1fff

    shl-int/2addr v10, v12

    or-int/2addr v9, v10

    add-int/lit8 v12, v12, 0xd

    move v10, v13

    goto :goto_5

    :cond_8
    shl-int/2addr v10, v12

    or-int/2addr v9, v10

    move v10, v13

    :cond_9
    nop

    add-int/lit8 v12, v10, 0x1

    invoke-virtual {v1, v10}, Ljava/lang/String;->charAt(I)C

    move-result v10

    if-lt v10, v7, :cond_b

    and-int/lit16 v10, v10, 0x1fff

    const/16 v13, 0xd

    :goto_6
    add-int/lit8 v14, v12, 0x1

    invoke-virtual {v1, v12}, Ljava/lang/String;->charAt(I)C

    move-result v12

    if-lt v12, v7, :cond_a

    and-int/lit16 v12, v12, 0x1fff

    shl-int/2addr v12, v13

    or-int/2addr v10, v12

    add-int/lit8 v13, v13, 0xd

    move v12, v14

    goto :goto_6

    :cond_a
    shl-int/2addr v12, v13

    or-int/2addr v10, v12

    move v12, v14

    :cond_b
    nop

    add-int/lit8 v13, v12, 0x1

    invoke-virtual {v1, v12}, Ljava/lang/String;->charAt(I)C

    move-result v12

    if-lt v12, v7, :cond_d

    and-int/lit16 v12, v12, 0x1fff

    const/16 v14, 0xd

    :goto_7
    add-int/lit8 v15, v13, 0x1

    invoke-virtual {v1, v13}, Ljava/lang/String;->charAt(I)C

    move-result v13

    if-lt v13, v7, :cond_c

    and-int/lit16 v13, v13, 0x1fff

    shl-int/2addr v13, v14

    or-int/2addr v12, v13

    add-int/lit8 v14, v14, 0xd

    move v13, v15

    goto :goto_7

    :cond_c
    shl-int/2addr v13, v14

    or-int/2addr v12, v13

    move v13, v15

    :cond_d
    nop

    add-int/lit8 v14, v13, 0x1

    invoke-virtual {v1, v13}, Ljava/lang/String;->charAt(I)C

    move-result v13

    if-lt v13, v7, :cond_f

    and-int/lit16 v13, v13, 0x1fff

    const/16 v15, 0xd

    :goto_8
    add-int/lit8 v16, v14, 0x1

    invoke-virtual {v1, v14}, Ljava/lang/String;->charAt(I)C

    move-result v14

    if-lt v14, v7, :cond_e

    and-int/lit16 v14, v14, 0x1fff

    shl-int/2addr v14, v15

    or-int/2addr v13, v14

    add-int/lit8 v15, v15, 0xd

    move/from16 v14, v16

    goto :goto_8

    :cond_e
    shl-int/2addr v14, v15

    or-int/2addr v13, v14

    move/from16 v14, v16

    :cond_f
    nop

    add-int/lit8 v15, v14, 0x1

    invoke-virtual {v1, v14}, Ljava/lang/String;->charAt(I)C

    move-result v14

    if-lt v14, v7, :cond_11

    and-int/lit16 v14, v14, 0x1fff

    const/16 v16, 0xd

    :goto_9
    add-int/lit8 v17, v15, 0x1

    invoke-virtual {v1, v15}, Ljava/lang/String;->charAt(I)C

    move-result v15

    if-lt v15, v7, :cond_10

    and-int/lit16 v15, v15, 0x1fff

    shl-int v15, v15, v16

    or-int/2addr v14, v15

    add-int/lit8 v16, v16, 0xd

    move/from16 v15, v17

    goto :goto_9

    :cond_10
    shl-int v15, v15, v16

    or-int/2addr v14, v15

    move/from16 v15, v17

    :cond_11
    nop

    add-int/lit8 v16, v15, 0x1

    invoke-virtual {v1, v15}, Ljava/lang/String;->charAt(I)C

    move-result v15

    if-lt v15, v7, :cond_13

    and-int/lit16 v15, v15, 0x1fff

    move/from16 v3, v16

    const/16 v16, 0xd

    :goto_a
    add-int/lit8 v17, v3, 0x1

    invoke-virtual {v1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-lt v3, v7, :cond_12

    and-int/lit16 v3, v3, 0x1fff

    shl-int v3, v3, v16

    or-int/2addr v15, v3

    add-int/lit8 v16, v16, 0xd

    move/from16 v3, v17

    goto :goto_a

    :cond_12
    shl-int v3, v3, v16

    or-int/2addr v15, v3

    move/from16 v3, v17

    goto :goto_b

    :cond_13
    move/from16 v3, v16

    :goto_b
    nop

    add-int/lit8 v16, v3, 0x1

    invoke-virtual {v1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-lt v3, v7, :cond_15

    and-int/lit16 v3, v3, 0x1fff

    move/from16 v6, v16

    const/16 v16, 0xd

    :goto_c
    add-int/lit8 v17, v6, 0x1

    invoke-virtual {v1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v6

    if-lt v6, v7, :cond_14

    and-int/lit16 v6, v6, 0x1fff

    shl-int v6, v6, v16

    or-int/2addr v3, v6

    add-int/lit8 v16, v16, 0xd

    move/from16 v6, v17

    goto :goto_c

    :cond_14
    shl-int v6, v6, v16

    or-int/2addr v3, v6

    move/from16 v16, v17

    :cond_15
    nop

    add-int v6, v3, v14

    add-int/2addr v6, v15

    new-array v6, v6, [I

    shl-int/lit8 v15, v8, 0x1

    add-int/2addr v15, v9

    move v9, v12

    move v12, v15

    move v15, v3

    move v3, v8

    move/from16 v8, v16

    move/from16 v35, v14

    move-object v14, v6

    move/from16 v6, v35

    :goto_d
    sget-object v7, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/measurement/zzhb;->zze()[Ljava/lang/Object;

    move-result-object v17

    nop

    invoke-virtual {v0}, Lcom/google/android/gms/internal/measurement/zzhb;->zzc()Lcom/google/android/gms/internal/measurement/zzgo;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    move/from16 v18, v8

    mul-int/lit8 v8, v13, 0x3

    new-array v8, v8, [I

    const/16 v19, 0x1

    shl-int/lit8 v13, v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    nop

    add-int v20, v15, v6

    move/from16 v22, v15

    move/from16 v6, v18

    move/from16 v23, v20

    const/16 v18, 0x0

    const/16 v21, 0x0

    :goto_e
    if-ge v6, v2, :cond_34

    add-int/lit8 v24, v6, 0x1

    invoke-virtual {v1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v6

    move/from16 v25, v2

    const v2, 0xd800

    if-lt v6, v2, :cond_17

    and-int/lit16 v6, v6, 0x1fff

    move/from16 v2, v24

    const/16 v24, 0xd

    :goto_f
    add-int/lit8 v26, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    move/from16 v27, v15

    const v15, 0xd800

    if-lt v2, v15, :cond_16

    and-int/lit16 v2, v2, 0x1fff

    shl-int v2, v2, v24

    or-int/2addr v6, v2

    add-int/lit8 v24, v24, 0xd

    move/from16 v2, v26

    move/from16 v15, v27

    goto :goto_f

    :cond_16
    shl-int v2, v2, v24

    or-int/2addr v6, v2

    move/from16 v2, v26

    goto :goto_10

    :cond_17
    move/from16 v27, v15

    move/from16 v2, v24

    :goto_10
    nop

    add-int/lit8 v15, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    move/from16 v24, v15

    const v15, 0xd800

    if-lt v2, v15, :cond_19

    and-int/lit16 v2, v2, 0x1fff

    move/from16 v15, v24

    const/16 v24, 0xd

    :goto_11
    add-int/lit8 v26, v15, 0x1

    invoke-virtual {v1, v15}, Ljava/lang/String;->charAt(I)C

    move-result v15

    move/from16 v28, v11

    const v11, 0xd800

    if-lt v15, v11, :cond_18

    and-int/lit16 v11, v15, 0x1fff

    shl-int v11, v11, v24

    or-int/2addr v2, v11

    add-int/lit8 v24, v24, 0xd

    move/from16 v15, v26

    move/from16 v11, v28

    goto :goto_11

    :cond_18
    shl-int v11, v15, v24

    or-int/2addr v2, v11

    move/from16 v15, v26

    goto :goto_12

    :cond_19
    move/from16 v28, v11

    move/from16 v15, v24

    :goto_12
    nop

    and-int/lit16 v11, v2, 0xff

    move/from16 v24, v9

    and-int/lit16 v9, v2, 0x400

    if-eqz v9, :cond_1a

    add-int/lit8 v9, v18, 0x1

    aput v21, v14, v18

    move/from16 v18, v9

    :cond_1a
    const/16 v9, 0x33

    move/from16 v30, v10

    if-lt v11, v9, :cond_22

    add-int/lit8 v9, v15, 0x1

    invoke-virtual {v1, v15}, Ljava/lang/String;->charAt(I)C

    move-result v15

    const v10, 0xd800

    if-lt v15, v10, :cond_1c

    and-int/lit16 v15, v15, 0x1fff

    const/16 v32, 0xd

    :goto_13
    add-int/lit8 v33, v9, 0x1

    invoke-virtual {v1, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-lt v9, v10, :cond_1b

    and-int/lit16 v9, v9, 0x1fff

    shl-int v9, v9, v32

    or-int/2addr v15, v9

    add-int/lit8 v32, v32, 0xd

    move/from16 v9, v33

    const v10, 0xd800

    goto :goto_13

    :cond_1b
    shl-int v9, v9, v32

    or-int/2addr v15, v9

    move/from16 v9, v33

    :cond_1c
    nop

    add-int/lit8 v10, v11, -0x33

    move/from16 v32, v9

    const/16 v9, 0x9

    if-eq v10, v9, :cond_1f

    const/16 v9, 0x11

    if-ne v10, v9, :cond_1d

    goto :goto_14

    :cond_1d
    const/16 v9, 0xc

    if-ne v10, v9, :cond_1e

    and-int/lit8 v9, v5, 0x1

    const/4 v10, 0x1

    if-ne v9, v10, :cond_1e

    div-int/lit8 v9, v21, 0x3

    shl-int/2addr v9, v10

    add-int/2addr v9, v10

    add-int/lit8 v10, v12, 0x1

    aget-object v12, v17, v12

    aput-object v12, v13, v9

    move v12, v10

    const/4 v10, 0x1

    goto :goto_15

    :cond_1e
    const/4 v10, 0x1

    goto :goto_15

    :cond_1f
    :goto_14
    div-int/lit8 v9, v21, 0x3

    const/4 v10, 0x1

    shl-int/2addr v9, v10

    add-int/2addr v9, v10

    add-int/lit8 v19, v12, 0x1

    aget-object v12, v17, v12

    aput-object v12, v13, v9

    move/from16 v12, v19

    :goto_15
    shl-int/lit8 v9, v15, 0x1

    aget-object v10, v17, v9

    instance-of v15, v10, Ljava/lang/reflect/Field;

    if-eqz v15, :cond_20

    check-cast v10, Ljava/lang/reflect/Field;

    goto :goto_16

    :cond_20
    check-cast v10, Ljava/lang/String;

    invoke-static {v4, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v10

    aput-object v10, v17, v9

    :goto_16
    move-object/from16 v33, v0

    move-object/from16 v34, v1

    invoke-virtual {v7, v10}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v0

    long-to-int v0, v0

    add-int/lit8 v9, v9, 0x1

    aget-object v1, v17, v9

    instance-of v10, v1, Ljava/lang/reflect/Field;

    if-eqz v10, :cond_21

    check-cast v1, Ljava/lang/reflect/Field;

    goto :goto_17

    :cond_21
    check-cast v1, Ljava/lang/String;

    invoke-static {v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    aput-object v1, v17, v9

    :goto_17
    invoke-virtual {v7, v1}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v9

    long-to-int v1, v9

    nop

    move-object/from16 v19, v4

    move/from16 v31, v12

    move/from16 v15, v32

    move-object/from16 v10, v34

    const/4 v12, 0x0

    const/16 v16, 0x1

    move v4, v1

    move v1, v0

    move v0, v3

    const v3, 0xd800

    goto/16 :goto_20

    :cond_22
    move-object/from16 v33, v0

    move-object/from16 v34, v1

    add-int/lit8 v0, v12, 0x1

    aget-object v1, v17, v12

    check-cast v1, Ljava/lang/String;

    invoke-static {v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    const/16 v9, 0x31

    const/16 v10, 0x9

    if-eq v11, v10, :cond_2b

    const/16 v10, 0x11

    if-ne v11, v10, :cond_23

    const/4 v12, 0x1

    goto/16 :goto_1a

    :cond_23
    const/16 v10, 0x1b

    if-eq v11, v10, :cond_2a

    if-ne v11, v9, :cond_24

    goto :goto_19

    :cond_24
    const/16 v10, 0xc

    if-eq v11, v10, :cond_28

    const/16 v10, 0x1e

    if-eq v11, v10, :cond_28

    const/16 v10, 0x2c

    if-ne v11, v10, :cond_25

    goto :goto_18

    :cond_25
    const/16 v10, 0x32

    if-ne v11, v10, :cond_27

    add-int/lit8 v10, v22, 0x1

    aput v21, v14, v22

    div-int/lit8 v12, v21, 0x3

    const/16 v19, 0x1

    shl-int/lit8 v12, v12, 0x1

    add-int/lit8 v22, v0, 0x1

    aget-object v0, v17, v0

    aput-object v0, v13, v12

    and-int/lit16 v0, v2, 0x800

    if-eqz v0, :cond_26

    add-int/lit8 v12, v12, 0x1

    add-int/lit8 v0, v22, 0x1

    aget-object v22, v17, v22

    aput-object v22, v13, v12

    move/from16 v22, v10

    const/4 v12, 0x1

    goto :goto_1b

    :cond_26
    move/from16 v0, v22

    const/4 v12, 0x1

    move/from16 v22, v10

    goto :goto_1b

    :cond_27
    const/4 v12, 0x1

    goto :goto_1b

    :cond_28
    :goto_18
    and-int/lit8 v10, v5, 0x1

    const/4 v12, 0x1

    if-ne v10, v12, :cond_29

    div-int/lit8 v10, v21, 0x3

    shl-int/2addr v10, v12

    add-int/2addr v10, v12

    add-int/lit8 v12, v0, 0x1

    aget-object v0, v17, v0

    aput-object v0, v13, v10

    move v0, v12

    const/4 v12, 0x1

    goto :goto_1b

    :cond_29
    const/4 v12, 0x1

    goto :goto_1b

    :cond_2a
    :goto_19
    div-int/lit8 v10, v21, 0x3

    const/4 v12, 0x1

    shl-int/2addr v10, v12

    add-int/2addr v10, v12

    add-int/lit8 v19, v0, 0x1

    aget-object v0, v17, v0

    aput-object v0, v13, v10

    move/from16 v0, v19

    goto :goto_1b

    :cond_2b
    const/4 v12, 0x1

    :goto_1a
    div-int/lit8 v10, v21, 0x3

    shl-int/2addr v10, v12

    add-int/2addr v10, v12

    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v19

    aput-object v19, v13, v10

    :goto_1b
    invoke-virtual {v7, v1}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v9

    long-to-int v1, v9

    and-int/lit8 v9, v5, 0x1

    if-ne v9, v12, :cond_30

    const/16 v9, 0x11

    if-gt v11, v9, :cond_2f

    add-int/lit8 v9, v15, 0x1

    move-object/from16 v10, v34

    invoke-virtual {v10, v15}, Ljava/lang/String;->charAt(I)C

    move-result v12

    const v15, 0xd800

    if-lt v12, v15, :cond_2d

    and-int/lit16 v12, v12, 0x1fff

    const/16 v16, 0xd

    :goto_1c
    add-int/lit8 v29, v9, 0x1

    invoke-virtual {v10, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-lt v9, v15, :cond_2c

    and-int/lit16 v9, v9, 0x1fff

    shl-int v9, v9, v16

    or-int/2addr v12, v9

    add-int/lit8 v16, v16, 0xd

    move/from16 v9, v29

    goto :goto_1c

    :cond_2c
    shl-int v9, v9, v16

    or-int/2addr v12, v9

    move/from16 v9, v29

    :cond_2d
    nop

    const/16 v16, 0x1

    shl-int/lit8 v19, v3, 0x1

    div-int/lit8 v29, v12, 0x20

    add-int v19, v19, v29

    aget-object v15, v17, v19

    move/from16 v31, v0

    instance-of v0, v15, Ljava/lang/reflect/Field;

    if-eqz v0, :cond_2e

    check-cast v15, Ljava/lang/reflect/Field;

    goto :goto_1d

    :cond_2e
    check-cast v15, Ljava/lang/String;

    invoke-static {v4, v15}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v15

    aput-object v15, v17, v19

    :goto_1d
    move v0, v3

    move-object/from16 v19, v4

    invoke-virtual {v7, v15}, Lsun/misc/Unsafe;->objectFieldOffset(Ljava/lang/reflect/Field;)J

    move-result-wide v3

    long-to-int v3, v3

    rem-int/lit8 v12, v12, 0x20

    move v4, v3

    move v15, v9

    const v3, 0xd800

    goto :goto_1f

    :cond_2f
    move/from16 v31, v0

    move v0, v3

    move-object/from16 v19, v4

    move-object/from16 v10, v34

    const v3, 0xd800

    const/16 v16, 0x1

    goto :goto_1e

    :cond_30
    move/from16 v31, v0

    move v0, v3

    move-object/from16 v19, v4

    move/from16 v16, v12

    move-object/from16 v10, v34

    const v3, 0xd800

    :goto_1e
    nop

    const/4 v4, 0x0

    const/4 v12, 0x0

    :goto_1f
    const/16 v9, 0x12

    if-lt v11, v9, :cond_31

    const/16 v9, 0x31

    if-gt v11, v9, :cond_31

    add-int/lit8 v9, v23, 0x1

    aput v1, v14, v23

    move/from16 v23, v9

    :cond_31
    :goto_20
    add-int/lit8 v9, v21, 0x1

    aput v6, v8, v21

    add-int/lit8 v6, v9, 0x1

    and-int/lit16 v3, v2, 0x200

    if-eqz v3, :cond_32

    const/high16 v3, 0x20000000

    goto :goto_21

    :cond_32
    const/4 v3, 0x0

    :goto_21
    and-int/lit16 v2, v2, 0x100

    if-eqz v2, :cond_33

    const/high16 v2, 0x10000000

    goto :goto_22

    :cond_33
    const/4 v2, 0x0

    :goto_22
    or-int/2addr v2, v3

    shl-int/lit8 v3, v11, 0x14

    or-int/2addr v2, v3

    or-int/2addr v1, v2

    aput v1, v8, v9

    add-int/lit8 v21, v6, 0x1

    shl-int/lit8 v1, v12, 0x14

    or-int/2addr v1, v4

    aput v1, v8, v6

    move v3, v0

    move-object v1, v10

    move v6, v15

    move-object/from16 v4, v19

    move/from16 v9, v24

    move/from16 v2, v25

    move/from16 v15, v27

    move/from16 v11, v28

    move/from16 v10, v30

    move/from16 v12, v31

    move-object/from16 v0, v33

    goto/16 :goto_e

    :cond_34
    move-object/from16 v33, v0

    move/from16 v24, v9

    move/from16 v30, v10

    move/from16 v28, v11

    move/from16 v27, v15

    new-instance v0, Lcom/google/android/gms/internal/measurement/zzgs;

    invoke-virtual/range {v33 .. v33}, Lcom/google/android/gms/internal/measurement/zzhb;->zzc()Lcom/google/android/gms/internal/measurement/zzgo;

    move-result-object v10

    const/4 v12, 0x0

    move-object v5, v0

    move-object v6, v8

    move-object v7, v13

    move/from16 v8, v30

    move-object v13, v14

    move/from16 v14, v27

    move/from16 v15, v20

    move-object/from16 v16, p2

    move-object/from16 v17, p3

    move-object/from16 v18, p4

    move-object/from16 v19, p5

    move-object/from16 v20, p6

    invoke-direct/range {v5 .. v20}, Lcom/google/android/gms/internal/measurement/zzgs;-><init>([I[Ljava/lang/Object;IILcom/google/android/gms/internal/measurement/zzgo;ZZ[IIILcom/google/android/gms/internal/measurement/zzgw;Lcom/google/android/gms/internal/measurement/zzfy;Lcom/google/android/gms/internal/measurement/zzhv;Lcom/google/android/gms/internal/measurement/zzes;Lcom/google/android/gms/internal/measurement/zzgh;)V

    return-object v0

    :cond_35
    check-cast v0, Lcom/google/android/gms/internal/measurement/zzhs;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/measurement/zzhs;->zza()I

    move-result v0

    sget v1, Lcom/google/android/gms/internal/measurement/zzfd$zze;->zzi:I

    new-instance v0, Ljava/lang/NoSuchMethodError;

    invoke-direct {v0}, Ljava/lang/NoSuchMethodError;-><init>()V

    throw v0
.end method

.method private final zza(I)Lcom/google/android/gms/internal/measurement/zzhd;
    .locals 3

    div-int/lit8 p1, p1, 0x3

    shl-int/lit8 p1, p1, 0x1

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzd:[Ljava/lang/Object;

    aget-object v0, v0, p1

    check-cast v0, Lcom/google/android/gms/internal/measurement/zzhd;

    if-eqz v0, :cond_0

    return-object v0

    :cond_0
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzgz;->zza()Lcom/google/android/gms/internal/measurement/zzgz;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzd:[Ljava/lang/Object;

    add-int/lit8 v2, p1, 0x1

    aget-object v1, v1, v2

    check-cast v1, Ljava/lang/Class;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/measurement/zzgz;->zza(Ljava/lang/Class;)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzd:[Ljava/lang/Object;

    aput-object v0, v1, p1

    return-object v0
.end method

.method private final zza(IILjava/util/Map;Lcom/google/android/gms/internal/measurement/zzfk;Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "V:",
            "Ljava/lang/Object;",
            "UT:",
            "Ljava/lang/Object;",
            "UB:",
            "Ljava/lang/Object;",
            ">(II",
            "Ljava/util/Map<",
            "TK;TV;>;",
            "Lcom/google/android/gms/internal/measurement/zzfk;",
            "TUB;",
            "Lcom/google/android/gms/internal/measurement/zzhv<",
            "TUT;TUB;>;)TUB;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-direct {p0, p1}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(I)Ljava/lang/Object;

    move-result-object p1

    invoke-interface {v0, p1}, Lcom/google/android/gms/internal/measurement/zzgh;->zzf(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzgf;

    move-result-object p1

    invoke-interface {p3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object p3

    invoke-interface {p3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p3

    :goto_0
    invoke-interface {p3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {p3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-interface {p4, v1}, Lcom/google/android/gms/internal/measurement/zzfk;->zza(I)Z

    move-result v1

    if-nez v1, :cond_1

    if-nez p5, :cond_0

    invoke-virtual {p6}, Lcom/google/android/gms/internal/measurement/zzhv;->zza()Ljava/lang/Object;

    move-result-object p5

    :cond_0
    nop

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-static {p1, v1, v2}, Lcom/google/android/gms/internal/measurement/zzgg;->zza(Lcom/google/android/gms/internal/measurement/zzgf;Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v1

    invoke-static {v1}, Lcom/google/android/gms/internal/measurement/zzdu;->zzc(I)Lcom/google/android/gms/internal/measurement/zzec;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/internal/measurement/zzec;->zzb()Lcom/google/android/gms/internal/measurement/zzen;

    move-result-object v2

    :try_start_0
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-static {v2, p1, v3, v0}, Lcom/google/android/gms/internal/measurement/zzgg;->zza(Lcom/google/android/gms/internal/measurement/zzen;Lcom/google/android/gms/internal/measurement/zzgf;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    nop

    invoke-virtual {v1}, Lcom/google/android/gms/internal/measurement/zzec;->zza()Lcom/google/android/gms/internal/measurement/zzdu;

    move-result-object v0

    invoke-virtual {p6, p5, p2, v0}, Lcom/google/android/gms/internal/measurement/zzhv;->zza(Ljava/lang/Object;ILcom/google/android/gms/internal/measurement/zzdu;)V

    invoke-interface {p3}, Ljava/util/Iterator;->remove()V

    goto :goto_1

    :catch_0
    move-exception p1

    new-instance p2, Ljava/lang/RuntimeException;

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    :cond_1
    :goto_1
    goto :goto_0

    :cond_2
    return-object p5
.end method

.method private final zza(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<UT:",
            "Ljava/lang/Object;",
            "UB:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            "ITUB;",
            "Lcom/google/android/gms/internal/measurement/zzhv<",
            "TUT;TUB;>;)TUB;"
        }
    .end annotation

    nop

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v3, v0, p2

    nop

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v0

    const v1, 0xfffff

    and-int/2addr v0, v1

    int-to-long v0, v0

    nop

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    if-nez p1, :cond_0

    return-object p3

    :cond_0
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(I)Lcom/google/android/gms/internal/measurement/zzfk;

    move-result-object v5

    if-nez v5, :cond_1

    return-object p3

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v0, p1}, Lcom/google/android/gms/internal/measurement/zzgh;->zza(Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v4

    nop

    move-object v1, p0

    move v2, p2

    move-object v6, p3

    move-object v7, p4

    invoke-direct/range {v1 .. v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(IILjava/util/Map;Lcom/google/android/gms/internal/measurement/zzfk;Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method private static zza(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/reflect/Field;"
        }
    .end annotation

    :try_start_0
    invoke-virtual {p0, p1}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object p0
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0

    return-object p0

    :catch_0
    move-exception v0

    invoke-virtual {p0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v0

    array-length v1, v0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_1

    aget-object v3, v0, v2

    invoke-virtual {v3}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    return-object v3

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p0

    invoke-static {v0}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, 0x28

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v2, "Field "

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " for "

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, " not found. Known fields are "

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v1, p0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private static zza(Ljava/lang/Object;J)Ljava/util/List;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "J)",
            "Ljava/util/List<",
            "*>;"
        }
    .end annotation

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/util/List;

    return-object p0
.end method

.method private static zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_0

    check-cast p1, Ljava/lang/String;

    invoke-interface {p2, p0, p1}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILjava/lang/String;)V

    return-void

    :cond_0
    check-cast p1, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-interface {p2, p0, p1}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILcom/google/android/gms/internal/measurement/zzdu;)V

    return-void
.end method

.method private static zza(Lcom/google/android/gms/internal/measurement/zzhv;Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<UT:",
            "Ljava/lang/Object;",
            "UB:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/google/android/gms/internal/measurement/zzhv<",
            "TUT;TUB;>;TT;",
            "Lcom/google/android/gms/internal/measurement/zzis;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/measurement/zzhv;->zzb(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {p0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzhv;->zza(Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V

    return-void
.end method

.method private final zza(Lcom/google/android/gms/internal/measurement/zzis;ILjava/lang/Object;I)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "V:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/google/android/gms/internal/measurement/zzis;",
            "I",
            "Ljava/lang/Object;",
            "I)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    if-eqz p3, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-direct {p0, p4}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(I)Ljava/lang/Object;

    move-result-object p4

    invoke-interface {v0, p4}, Lcom/google/android/gms/internal/measurement/zzgh;->zzf(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzgf;

    move-result-object p4

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v0, p3}, Lcom/google/android/gms/internal/measurement/zzgh;->zzb(Ljava/lang/Object;)Ljava/util/Map;

    move-result-object p3

    invoke-interface {p1, p2, p4, p3}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILcom/google/android/gms/internal/measurement/zzgf;Ljava/util/Map;)V

    :cond_0
    return-void
.end method

.method private final zza(Ljava/lang/Object;ILcom/google/android/gms/internal/measurement/zzhe;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzf(I)Z

    move-result v0

    const v1, 0xfffff

    if-eqz v0, :cond_0

    nop

    and-int/2addr p2, v1

    int-to-long v0, p2

    invoke-interface {p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zzm()Ljava/lang/String;

    move-result-object p2

    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    return-void

    :cond_0
    iget-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzi:Z

    if-eqz v0, :cond_1

    nop

    and-int/2addr p2, v1

    int-to-long v0, p2

    invoke-interface {p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zzl()Ljava/lang/String;

    move-result-object p2

    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    return-void

    :cond_1
    nop

    and-int/2addr p2, v1

    int-to-long v0, p2

    invoke-interface {p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zzn()Lcom/google/android/gms/internal/measurement/zzdu;

    move-result-object p2

    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    return-void
.end method

.method private final zza(Ljava/lang/Object;Ljava/lang/Object;I)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TT;I)V"
        }
    .end annotation

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v0

    const v1, 0xfffff

    and-int/2addr v0, v1

    int-to-long v0, v0

    nop

    invoke-direct {p0, p2, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v2

    if-nez v2, :cond_0

    return-void

    :cond_0
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p2, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p2

    if-eqz v2, :cond_1

    if-eqz p2, :cond_1

    invoke-static {v2, p2}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    return-void

    :cond_1
    if-eqz p2, :cond_2

    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    :cond_2
    return-void
.end method

.method private final zza(Ljava/lang/Object;I)Z
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;I)Z"
        }
    .end annotation

    iget-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzj:Z

    const v1, 0xfffff

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-eqz v0, :cond_14

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result p2

    nop

    and-int v0, p2, v1

    int-to-long v0, v0

    nop

    nop

    const/high16 v4, 0xff00000

    and-int/2addr p2, v4

    ushr-int/lit8 p2, p2, 0x14

    const-wide/16 v4, 0x0

    packed-switch p2, :pswitch_data_0

    new-instance p1, Ljava/lang/IllegalArgumentException;

    invoke-direct {p1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw p1

    :pswitch_0
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_0

    return v3

    :cond_0
    return v2

    :pswitch_1
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long p1, p1, v4

    if-eqz p1, :cond_1

    return v3

    :cond_1
    return v2

    :pswitch_2
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_2

    return v3

    :cond_2
    return v2

    :pswitch_3
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long p1, p1, v4

    if-eqz p1, :cond_3

    return v3

    :cond_3
    return v2

    :pswitch_4
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_4

    return v3

    :cond_4
    return v2

    :pswitch_5
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_5

    return v3

    :cond_5
    return v2

    :pswitch_6
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_6

    return v3

    :cond_6
    return v2

    :pswitch_7
    sget-object p2, Lcom/google/android/gms/internal/measurement/zzdu;->zza:Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/measurement/zzdu;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_7

    return v3

    :cond_7
    return v2

    :pswitch_8
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_8

    return v3

    :cond_8
    return v2

    :pswitch_9
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p1

    instance-of p2, p1, Ljava/lang/String;

    if-eqz p2, :cond_a

    check-cast p1, Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result p1

    if-nez p1, :cond_9

    return v3

    :cond_9
    return v2

    :cond_a
    instance-of p2, p1, Lcom/google/android/gms/internal/measurement/zzdu;

    if-eqz p2, :cond_c

    sget-object p2, Lcom/google/android/gms/internal/measurement/zzdu;->zza:Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-virtual {p2, p1}, Lcom/google/android/gms/internal/measurement/zzdu;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_b

    return v3

    :cond_b
    return v2

    :cond_c
    new-instance p1, Ljava/lang/IllegalArgumentException;

    invoke-direct {p1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw p1

    :pswitch_a
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzc(Ljava/lang/Object;J)Z

    move-result p1

    return p1

    :pswitch_b
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_d

    return v3

    :cond_d
    return v2

    :pswitch_c
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long p1, p1, v4

    if-eqz p1, :cond_e

    return v3

    :cond_e
    return v2

    :pswitch_d
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result p1

    if-eqz p1, :cond_f

    return v3

    :cond_f
    return v2

    :pswitch_e
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long p1, p1, v4

    if-eqz p1, :cond_10

    return v3

    :cond_10
    return v2

    :pswitch_f
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide p1

    cmp-long p1, p1, v4

    if-eqz p1, :cond_11

    return v3

    :cond_11
    return v2

    :pswitch_10
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzd(Ljava/lang/Object;J)F

    move-result p1

    const/4 p2, 0x0

    cmpl-float p1, p1, p2

    if-eqz p1, :cond_12

    return v3

    :cond_12
    return v2

    :pswitch_11
    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zze(Ljava/lang/Object;J)D

    move-result-wide p1

    const-wide/16 v0, 0x0

    cmpl-double p1, p1, v0

    if-eqz p1, :cond_13

    return v3

    :cond_13
    return v2

    :cond_14
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(I)I

    move-result p2

    ushr-int/lit8 v0, p2, 0x14

    shl-int v0, v3, v0

    and-int/2addr p2, v1

    int-to-long v4, p2

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result p1

    and-int/2addr p1, v0

    if-eqz p1, :cond_15

    return v3

    :cond_15
    return v2

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private final zza(Ljava/lang/Object;II)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;II)Z"
        }
    .end annotation

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(I)I

    move-result p3

    const v0, 0xfffff

    and-int/2addr p3, v0

    int-to-long v0, p3

    invoke-static {p1, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result p1

    if-ne p1, p2, :cond_0

    const/4 p1, 0x1

    return p1

    :cond_0
    const/4 p1, 0x0

    return p1
.end method

.method private final zza(Ljava/lang/Object;III)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;III)Z"
        }
    .end annotation

    iget-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzj:Z

    if-eqz v0, :cond_0

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result p1

    return p1

    :cond_0
    and-int p1, p3, p4

    if-eqz p1, :cond_1

    const/4 p1, 0x1

    return p1

    :cond_1
    const/4 p1, 0x0

    return p1
.end method

.method private static zza(Ljava/lang/Object;ILcom/google/android/gms/internal/measurement/zzhd;)Z
    .locals 2

    nop

    const v0, 0xfffff

    and-int/2addr p1, v0

    int-to-long v0, p1

    invoke-static {p0, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    invoke-interface {p2, p0}, Lcom/google/android/gms/internal/measurement/zzhd;->zzd(Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method private static zzb(Ljava/lang/Object;J)D
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;J)D"
        }
    .end annotation

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Double;

    invoke-virtual {p0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide p0

    return-wide p0
.end method

.method private final zzb(II)I
    .locals 4

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    array-length v0, v0

    div-int/lit8 v0, v0, 0x3

    add-int/lit8 v0, v0, -0x1

    :goto_0
    if-gt p2, v0, :cond_2

    add-int v1, v0, p2

    ushr-int/lit8 v1, v1, 0x1

    mul-int/lit8 v2, v1, 0x3

    nop

    iget-object v3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v3, v3, v2

    nop

    if-ne p1, v3, :cond_0

    return v2

    :cond_0
    if-ge p1, v3, :cond_1

    add-int/lit8 v0, v1, -0x1

    goto :goto_0

    :cond_1
    add-int/lit8 p2, v1, 0x1

    goto :goto_0

    :cond_2
    const/4 p1, -0x1

    return p1
.end method

.method private final zzb(I)Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzd:[Ljava/lang/Object;

    div-int/lit8 p1, p1, 0x3

    shl-int/lit8 p1, p1, 0x1

    aget-object p1, v0, p1

    return-object p1
.end method

.method private final zzb(Ljava/lang/Object;I)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;I)V"
        }
    .end annotation

    iget-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzj:Z

    if-eqz v0, :cond_0

    return-void

    :cond_0
    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(I)I

    move-result p2

    const/4 v0, 0x1

    ushr-int/lit8 v1, p2, 0x14

    shl-int/2addr v0, v1

    const v1, 0xfffff

    and-int/2addr p2, v1

    int-to-long v1, p2

    nop

    invoke-static {p1, v1, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result p2

    or-int/2addr p2, v0

    invoke-static {p1, v1, v2, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    return-void
.end method

.method private final zzb(Ljava/lang/Object;II)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;II)V"
        }
    .end annotation

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(I)I

    move-result p3

    const v0, 0xfffff

    and-int/2addr p3, v0

    int-to-long v0, p3

    invoke-static {p1, v0, v1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    return-void
.end method

.method private final zzb(Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V
    .locals 18
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lcom/google/android/gms/internal/measurement/zzis;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    nop

    iget-boolean v3, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    if-eqz v3, :cond_0

    iget-object v3, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v3, v1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzew;

    move-result-object v3

    nop

    iget-object v5, v3, Lcom/google/android/gms/internal/measurement/zzew;->zza:Lcom/google/android/gms/internal/measurement/zzhi;

    invoke-virtual {v5}, Lcom/google/android/gms/internal/measurement/zzhi;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    invoke-virtual {v3}, Lcom/google/android/gms/internal/measurement/zzew;->zzd()Ljava/util/Iterator;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    const/4 v5, 0x0

    :goto_0
    const/4 v6, -0x1

    nop

    iget-object v7, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    array-length v7, v7

    sget-object v8, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    const/4 v10, 0x0

    const/4 v11, 0x0

    :goto_1
    if-ge v10, v7, :cond_18

    invoke-direct {v0, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v12

    nop

    iget-object v13, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v14, v13, v10

    nop

    nop

    const/high16 v15, 0xff00000

    and-int/2addr v15, v12

    ushr-int/lit8 v15, v15, 0x14

    nop

    nop

    iget-boolean v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzj:Z

    const v16, 0xfffff

    if-nez v4, :cond_2

    const/16 v4, 0x11

    if-gt v15, v4, :cond_2

    add-int/lit8 v4, v10, 0x2

    aget v4, v13, v4

    and-int v13, v4, v16

    if-eq v13, v6, :cond_1

    nop

    move/from16 v17, v10

    int-to-long v9, v13

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v11

    move v6, v13

    goto :goto_2

    :cond_1
    move/from16 v17, v10

    :goto_2
    ushr-int/lit8 v4, v4, 0x14

    const/4 v9, 0x1

    shl-int v4, v9, v4

    goto :goto_3

    :cond_2
    move/from16 v17, v10

    const/4 v4, 0x0

    :goto_3
    if-eqz v5, :cond_4

    iget-object v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v9, v5}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Ljava/util/Map$Entry;)I

    move-result v9

    if-gt v9, v14, :cond_4

    iget-object v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v9, v2, v5}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Lcom/google/android/gms/internal/measurement/zzis;Ljava/util/Map$Entry;)V

    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    goto :goto_3

    :cond_3
    const/4 v5, 0x0

    goto :goto_3

    :cond_4
    nop

    and-int v9, v12, v16

    int-to-long v9, v9

    nop

    packed-switch v15, :pswitch_data_0

    move/from16 v12, v17

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_0
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_5

    nop

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v9

    invoke-interface {v2, v14, v4, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_5
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_1
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_6

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zze(IJ)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_6
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_2
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_7

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zzf(II)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_7
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_3
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_8

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(IJ)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_8
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_4
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_9

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zza(II)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_9
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_5
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_a

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(II)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_a
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_6
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_b

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zze(II)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_b
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_7
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_c

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILcom/google/android/gms/internal/measurement/zzdu;)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_c
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_8
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_d

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v9

    invoke-interface {v2, v14, v4, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_d
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_9
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_e

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v14, v4, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_e
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_a
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_f

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzf(Ljava/lang/Object;J)Z

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IZ)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_f
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_b
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_10

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(II)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_10
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_c
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_11

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(IJ)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_11
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_d
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_12

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(II)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_12
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_e
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_13

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(IJ)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_13
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_f
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_14

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IJ)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_14
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_10
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_15

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;J)F

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IF)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_15
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_11
    move/from16 v12, v17

    invoke-direct {v0, v1, v14, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_16

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;J)D

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ID)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :cond_16
    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_12
    move/from16 v12, v17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-direct {v0, v2, v14, v4, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Lcom/google/android/gms/internal/measurement/zzis;ILjava/lang/Object;I)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_13
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    nop

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v10

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Lcom/google/android/gms/internal/measurement/zzhd;)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_14
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zze(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_15
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzj(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_16
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzg(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_17
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzl(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_18
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzm(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_19
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_1a
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzn(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_1b
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzk(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_1c
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzf(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_1d
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_1e
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzd(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_1f
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzc(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_20
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_21
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x1

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_22
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zze(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_23
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzj(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_24
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzg(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_25
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzl(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_26
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzm(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_27
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_28
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v4, v9, v2}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_29
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    nop

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v10

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Lcom/google/android/gms/internal/measurement/zzhd;)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_2a
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v4, v9, v2}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_2b
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzn(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_2c
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzk(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_2d
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzf(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_2e
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_2f
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzd(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_30
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzc(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_31
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v10, 0x0

    invoke-static {v4, v9, v2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    const/4 v13, 0x0

    goto/16 :goto_4

    :pswitch_32
    move/from16 v12, v17

    nop

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v12

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    const/4 v13, 0x0

    invoke-static {v4, v9, v2, v13}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_4

    :pswitch_33
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    nop

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v9

    invoke-interface {v2, v14, v4, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_4

    :pswitch_34
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zze(IJ)V

    goto/16 :goto_4

    :pswitch_35
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zzf(II)V

    goto/16 :goto_4

    :pswitch_36
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(IJ)V

    goto/16 :goto_4

    :pswitch_37
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zza(II)V

    goto/16 :goto_4

    :pswitch_38
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(II)V

    goto/16 :goto_4

    :pswitch_39
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zze(II)V

    goto/16 :goto_4

    :pswitch_3a
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILcom/google/android/gms/internal/measurement/zzdu;)V

    goto/16 :goto_4

    :pswitch_3b
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v9

    invoke-interface {v2, v14, v4, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_4

    :pswitch_3c
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v14, v4, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V

    goto/16 :goto_4

    :pswitch_3d
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    nop

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzib;->zzc(Ljava/lang/Object;J)Z

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IZ)V

    goto/16 :goto_4

    :pswitch_3e
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(II)V

    goto :goto_4

    :pswitch_3f
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(IJ)V

    goto :goto_4

    :pswitch_40
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(II)V

    goto :goto_4

    :pswitch_41
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(IJ)V

    goto :goto_4

    :pswitch_42
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    invoke-virtual {v8, v1, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IJ)V

    goto :goto_4

    :pswitch_43
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    nop

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzib;->zzd(Ljava/lang/Object;J)F

    move-result v4

    invoke-interface {v2, v14, v4}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IF)V

    goto :goto_4

    :pswitch_44
    move/from16 v12, v17

    const/4 v13, 0x0

    and-int/2addr v4, v11

    if-eqz v4, :cond_17

    nop

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzib;->zze(Ljava/lang/Object;J)D

    move-result-wide v9

    invoke-interface {v2, v14, v9, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ID)V

    :cond_17
    :goto_4
    add-int/lit8 v10, v12, 0x3

    goto/16 :goto_1

    :cond_18
    :goto_5
    if-eqz v5, :cond_1a

    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v4, v2, v5}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Lcom/google/android/gms/internal/measurement/zzis;Ljava/util/Map$Entry;)V

    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_19

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    move-object v5, v4

    goto :goto_5

    :cond_19
    const/4 v5, 0x0

    goto :goto_5

    :cond_1a
    iget-object v3, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-static {v3, v1, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Lcom/google/android/gms/internal/measurement/zzhv;Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V

    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_44
        :pswitch_43
        :pswitch_42
        :pswitch_41
        :pswitch_40
        :pswitch_3f
        :pswitch_3e
        :pswitch_3d
        :pswitch_3c
        :pswitch_3b
        :pswitch_3a
        :pswitch_39
        :pswitch_38
        :pswitch_37
        :pswitch_36
        :pswitch_35
        :pswitch_34
        :pswitch_33
        :pswitch_32
        :pswitch_31
        :pswitch_30
        :pswitch_2f
        :pswitch_2e
        :pswitch_2d
        :pswitch_2c
        :pswitch_2b
        :pswitch_2a
        :pswitch_29
        :pswitch_28
        :pswitch_27
        :pswitch_26
        :pswitch_25
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_1d
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private final zzb(Ljava/lang/Object;Ljava/lang/Object;I)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TT;I)V"
        }
    .end annotation

    invoke-direct {p0, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v0

    nop

    iget-object v1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v1, v1, p3

    nop

    nop

    const v2, 0xfffff

    and-int/2addr v0, v2

    int-to-long v2, v0

    nop

    invoke-direct {p0, p2, v1, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v0

    if-nez v0, :cond_0

    return-void

    :cond_0
    invoke-static {p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p2

    if-eqz v0, :cond_1

    if-eqz p2, :cond_1

    invoke-static {v0, p2}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    invoke-static {p1, v2, v3, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v1, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    return-void

    :cond_1
    if-eqz p2, :cond_2

    invoke-static {p1, v2, v3, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v1, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    :cond_2
    return-void
.end method

.method private static zzc(Ljava/lang/Object;J)F
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;J)F"
        }
    .end annotation

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Float;

    invoke-virtual {p0}, Ljava/lang/Float;->floatValue()F

    move-result p0

    return p0
.end method

.method private final zzc(I)Lcom/google/android/gms/internal/measurement/zzfk;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzd:[Ljava/lang/Object;

    div-int/lit8 p1, p1, 0x3

    shl-int/lit8 p1, p1, 0x1

    add-int/lit8 p1, p1, 0x1

    aget-object p1, v0, p1

    check-cast p1, Lcom/google/android/gms/internal/measurement/zzfk;

    return-object p1
.end method

.method private final zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TT;I)Z"
        }
    .end annotation

    invoke-direct {p0, p1, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result p1

    invoke-direct {p0, p2, p3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result p2

    if-ne p1, p2, :cond_0

    const/4 p1, 0x1

    return p1

    :cond_0
    const/4 p1, 0x0

    return p1
.end method

.method private final zzd(I)I
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    add-int/lit8 p1, p1, 0x1

    aget p1, v0, p1

    return p1
.end method

.method private static zzd(Ljava/lang/Object;J)I
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;J)I"
        }
    .end annotation

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Integer;

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result p0

    return p0
.end method

.method private final zze(I)I
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    add-int/lit8 p1, p1, 0x2

    aget p1, v0, p1

    return p1
.end method

.method private static zze(Ljava/lang/Object;J)J
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;J)J"
        }
    .end annotation

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Long;

    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide p0

    return-wide p0
.end method

.method private static zze(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzhy;
    .locals 2

    check-cast p0, Lcom/google/android/gms/internal/measurement/zzfd;

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzfd;->zzb:Lcom/google/android/gms/internal/measurement/zzhy;

    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzhy;->zza()Lcom/google/android/gms/internal/measurement/zzhy;

    move-result-object v1

    if-ne v0, v1, :cond_0

    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzhy;->zzb()Lcom/google/android/gms/internal/measurement/zzhy;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/internal/measurement/zzfd;->zzb:Lcom/google/android/gms/internal/measurement/zzhy;

    :cond_0
    return-object v0
.end method

.method private static zzf(I)Z
    .locals 1

    const/high16 v0, 0x20000000

    and-int/2addr p0, v0

    if-eqz p0, :cond_0

    const/4 p0, 0x1

    return p0

    :cond_0
    const/4 p0, 0x0

    return p0
.end method

.method private static zzf(Ljava/lang/Object;J)Z
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;J)Z"
        }
    .end annotation

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Boolean;

    invoke-virtual {p0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p0

    return p0
.end method

.method private final zzg(I)I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zze:I

    if-lt p1, v0, :cond_0

    iget v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzf:I

    if-gt p1, v0, :cond_0

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(II)I

    move-result p1

    return p1

    :cond_0
    const/4 p1, -0x1

    return p1
.end method


# virtual methods
.method public final zza(Ljava/lang/Object;)I
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)I"
        }
    .end annotation

    nop

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    array-length v0, v0

    const/4 v1, 0x0

    move v2, v1

    :goto_0
    if-ge v1, v0, :cond_3

    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v3

    nop

    iget-object v4, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v1

    nop

    nop

    const v5, 0xfffff

    and-int/2addr v5, v3

    int-to-long v5, v5

    nop

    nop

    const/high16 v7, 0xff00000

    and-int/2addr v3, v7

    ushr-int/lit8 v3, v3, 0x14

    const/16 v7, 0x25

    packed-switch v3, :pswitch_data_0

    goto/16 :goto_1

    :pswitch_0
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    mul-int/lit8 v2, v2, 0x35

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_1
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_2
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_3
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_4
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_5
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_6
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_7
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_8
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    mul-int/lit8 v2, v2, 0x35

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_9
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_a
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzf(Ljava/lang/Object;J)Z

    move-result v3

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Z)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_b
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_c
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_d
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_e
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_f
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_10
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;J)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_11
    invoke-direct {p0, p1, v4, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v3

    if-eqz v3, :cond_2

    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;J)D

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_12
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_13
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_14
    nop

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v7

    :cond_0
    mul-int/lit8 v2, v2, 0x35

    add-int/2addr v2, v7

    goto/16 :goto_1

    :pswitch_15
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_16
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_17
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_18
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_19
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_1a
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_1b
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    add-int/2addr v2, v3

    goto/16 :goto_1

    :pswitch_1c
    nop

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-virtual {v3}, Ljava/lang/Object;->hashCode()I

    move-result v7

    :cond_1
    mul-int/lit8 v2, v2, 0x35

    add-int/2addr v2, v7

    goto :goto_1

    :pswitch_1d
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v3

    add-int/2addr v2, v3

    goto :goto_1

    :pswitch_1e
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzc(Ljava/lang/Object;J)Z

    move-result v3

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Z)I

    move-result v3

    add-int/2addr v2, v3

    goto :goto_1

    :pswitch_1f
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto :goto_1

    :pswitch_20
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    goto :goto_1

    :pswitch_21
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v3

    add-int/2addr v2, v3

    goto :goto_1

    :pswitch_22
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    goto :goto_1

    :pswitch_23
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    goto :goto_1

    :pswitch_24
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzd(Ljava/lang/Object;J)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v3

    add-int/2addr v2, v3

    goto :goto_1

    :pswitch_25
    mul-int/lit8 v2, v2, 0x35

    invoke-static {p1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zze(Ljava/lang/Object;J)D

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(J)I

    move-result v3

    add-int/2addr v2, v3

    nop

    :cond_2
    :goto_1
    add-int/lit8 v1, v1, 0x3

    goto/16 :goto_0

    :cond_3
    mul-int/lit8 v2, v2, 0x35

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/measurement/zzhv;->zzb(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    add-int/2addr v2, v0

    iget-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    if-eqz v0, :cond_4

    mul-int/lit8 v2, v2, 0x35

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzew;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/measurement/zzew;->hashCode()I

    move-result p1

    add-int/2addr v2, p1

    :cond_4
    return v2

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_25
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_1d
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method final zza(Ljava/lang/Object;[BIIILcom/google/android/gms/internal/measurement/zzdt;)I
    .locals 29
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;[BIII",
            "Lcom/google/android/gms/internal/measurement/zzdt;",
            ")I"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    move-object/from16 v15, p0

    move-object/from16 v14, p1

    move-object/from16 v12, p2

    move/from16 v13, p4

    move/from16 v11, p5

    move-object/from16 v9, p6

    sget-object v10, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    nop

    nop

    nop

    nop

    const/16 v16, 0x0

    move/from16 v0, p3

    move/from16 v2, v16

    move v3, v2

    move v6, v3

    const/4 v1, -0x1

    const/4 v7, -0x1

    :goto_0
    if-ge v0, v13, :cond_26

    add-int/lit8 v3, v0, 0x1

    aget-byte v0, v12, v0

    if-gez v0, :cond_0

    invoke-static {v0, v12, v3, v9}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(I[BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    iget v3, v9, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    move v4, v0

    move v5, v3

    goto :goto_1

    :cond_0
    move v5, v0

    move v4, v3

    :goto_1
    ushr-int/lit8 v3, v5, 0x3

    and-int/lit8 v0, v5, 0x7

    const/4 v8, 0x3

    if-le v3, v1, :cond_1

    div-int/2addr v2, v8

    invoke-direct {v15, v3, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(II)I

    move-result v1

    move v2, v1

    goto :goto_2

    :cond_1
    invoke-direct {v15, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzg(I)I

    move-result v1

    move v2, v1

    :goto_2
    nop

    const/4 v1, -0x1

    if-ne v2, v1, :cond_2

    move/from16 v24, v3

    move v2, v4

    move/from16 v25, v5

    move-object/from16 v26, v10

    move/from16 v18, v16

    goto/16 :goto_d

    :cond_2
    iget-object v1, v15, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    add-int/lit8 v18, v2, 0x1

    aget v8, v1, v18

    nop

    const/high16 v18, 0xff00000

    and-int v18, v8, v18

    ushr-int/lit8 v11, v18, 0x14

    nop

    nop

    const v18, 0xfffff

    move/from16 v19, v5

    and-int v5, v8, v18

    int-to-long v12, v5

    nop

    const/16 v5, 0x11

    move/from16 v20, v8

    if-gt v11, v5, :cond_16

    add-int/lit8 v5, v2, 0x2

    aget v1, v1, v5

    ushr-int/lit8 v5, v1, 0x14

    const/4 v8, 0x1

    shl-int v22, v8, v5

    and-int v1, v1, v18

    if-eq v1, v7, :cond_4

    const/4 v5, -0x1

    if-eq v7, v5, :cond_3

    int-to-long v8, v7

    invoke-virtual {v10, v14, v8, v9, v6}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_3
    nop

    int-to-long v6, v1

    invoke-virtual {v10, v14, v6, v7}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v6

    move v7, v1

    goto :goto_3

    :cond_4
    const/4 v5, -0x1

    :goto_3
    const/4 v1, 0x5

    packed-switch v11, :pswitch_data_0

    move-object/from16 v12, p2

    move-object/from16 v13, p6

    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move/from16 p3, v7

    move/from16 v8, v19

    move v7, v4

    goto/16 :goto_9

    :pswitch_0
    const/4 v1, 0x3

    if-ne v0, v1, :cond_6

    shl-int/lit8 v0, v3, 0x3

    or-int/lit8 v8, v0, 0x4

    nop

    invoke-direct {v15, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v0

    move-object/from16 v1, p2

    move v9, v2

    move v2, v4

    move v11, v3

    move/from16 v3, p4

    move v4, v8

    move/from16 v18, v5

    move/from16 v8, v19

    move-object/from16 v5, p6

    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(Lcom/google/android/gms/internal/measurement/zzhd;[BIIILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    and-int v1, v6, v22

    if-nez v1, :cond_5

    move-object/from16 v5, p6

    iget-object v1, v5, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v10, v14, v12, v13, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_4

    :cond_5
    move-object/from16 v5, p6

    invoke-virtual {v10, v14, v12, v13}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    iget-object v2, v5, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v10, v14, v12, v13, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :goto_4
    or-int v6, v6, v22

    move-object/from16 v12, p2

    move/from16 v13, p4

    move v3, v8

    move v2, v9

    move v1, v11

    move/from16 v11, p5

    move-object v9, v5

    goto/16 :goto_0

    :cond_6
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move/from16 v8, v19

    move-object/from16 v5, p6

    move-object/from16 v12, p2

    move-object v13, v5

    move/from16 p3, v7

    move v7, v4

    goto/16 :goto_9

    :pswitch_1
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move/from16 v8, v19

    move-object/from16 v5, p6

    if-nez v0, :cond_7

    move-wide v2, v12

    move-object/from16 v12, p2

    invoke-static {v12, v4, v5}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v13

    iget-wide v0, v5, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/measurement/zzeg;->zza(J)J

    move-result-wide v19

    move-object v0, v10

    move-object/from16 v1, p1

    move/from16 p3, v13

    move-object v13, v5

    move-wide/from16 v4, v19

    invoke-virtual/range {v0 .. v5}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    or-int v6, v6, v22

    move/from16 v0, p3

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v13, p4

    move/from16 v11, p5

    goto/16 :goto_0

    :cond_7
    move-object/from16 v12, p2

    move-object v13, v5

    move/from16 p3, v7

    move v7, v4

    goto/16 :goto_9

    :pswitch_2
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move-object/from16 v13, p6

    if-nez v0, :cond_8

    invoke-static {v12, v4, v13}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    iget v1, v13, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-static {v1}, Lcom/google/android/gms/internal/measurement/zzeg;->zze(I)I

    move-result v1

    invoke-virtual {v10, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    or-int v6, v6, v22

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v13, p4

    move/from16 v11, p5

    goto/16 :goto_0

    :cond_8
    move/from16 p3, v7

    move v7, v4

    goto/16 :goto_9

    :pswitch_3
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move-object/from16 v13, p6

    if-nez v0, :cond_b

    invoke-static {v12, v4, v13}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    iget v1, v13, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-direct {v15, v9}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(I)Lcom/google/android/gms/internal/measurement/zzfk;

    move-result-object v4

    if-eqz v4, :cond_a

    invoke-interface {v4, v1}, Lcom/google/android/gms/internal/measurement/zzfk;->zza(I)Z

    move-result v4

    if-eqz v4, :cond_9

    goto :goto_5

    :cond_9
    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzhy;

    move-result-object v2

    int-to-long v3, v1

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v2, v8, v1}, Lcom/google/android/gms/internal/measurement/zzhy;->zza(ILjava/lang/Object;)V

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v13, p4

    move/from16 v11, p5

    goto/16 :goto_0

    :cond_a
    :goto_5
    invoke-virtual {v10, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    or-int v6, v6, v22

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v13, p4

    move/from16 v11, p5

    goto/16 :goto_0

    :cond_b
    move/from16 p3, v7

    move v7, v4

    goto/16 :goto_9

    :pswitch_4
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move-object/from16 v13, p6

    const/4 v1, 0x2

    if-ne v0, v1, :cond_c

    invoke-static {v12, v4, v13}, Lcom/google/android/gms/internal/measurement/zzdq;->zze([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    iget-object v1, v13, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v10, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    or-int v6, v6, v22

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v13, p4

    move/from16 v11, p5

    goto/16 :goto_0

    :cond_c
    move/from16 p3, v7

    move v7, v4

    goto/16 :goto_9

    :pswitch_5
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move-object/from16 v13, p6

    const/4 v1, 0x2

    if-ne v0, v1, :cond_e

    nop

    invoke-direct {v15, v9}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v0

    move/from16 v5, p4

    invoke-static {v0, v12, v4, v5, v13}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(Lcom/google/android/gms/internal/measurement/zzhd;[BIILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    and-int v1, v6, v22

    if-nez v1, :cond_d

    iget-object v1, v13, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v10, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_6

    :cond_d
    nop

    invoke-virtual {v10, v14, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    iget-object v4, v13, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-static {v1, v4}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v10, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    :goto_6
    or-int v6, v6, v22

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v11, p5

    move v13, v5

    goto/16 :goto_0

    :cond_e
    move/from16 v5, p4

    move/from16 p3, v7

    move v7, v4

    goto/16 :goto_9

    :pswitch_6
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move/from16 v5, p4

    move-object/from16 v13, p6

    const/4 v1, 0x2

    if-ne v0, v1, :cond_10

    const/high16 v0, 0x20000000

    and-int v0, v20, v0

    if-nez v0, :cond_f

    invoke-static {v12, v4, v13}, Lcom/google/android/gms/internal/measurement/zzdq;->zzc([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    goto :goto_7

    :cond_f
    invoke-static {v12, v4, v13}, Lcom/google/android/gms/internal/measurement/zzdq;->zzd([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    :goto_7
    iget-object v1, v13, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v10, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    or-int v6, v6, v22

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v11, p5

    move v13, v5

    goto/16 :goto_0

    :cond_10
    move/from16 p3, v7

    move v7, v4

    goto/16 :goto_9

    :pswitch_7
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move/from16 v5, p4

    move-object/from16 v13, p6

    if-nez v0, :cond_12

    invoke-static {v12, v4, v13}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    move/from16 p3, v0

    iget-wide v0, v13, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    const-wide/16 v19, 0x0

    cmp-long v0, v0, v19

    if-eqz v0, :cond_11

    const/4 v0, 0x1

    goto :goto_8

    :cond_11
    move/from16 v0, v16

    :goto_8
    invoke-static {v14, v2, v3, v0}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JZ)V

    or-int v6, v6, v22

    move/from16 v0, p3

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v11, p5

    move v13, v5

    goto/16 :goto_0

    :cond_12
    move/from16 p3, v7

    move v7, v4

    goto/16 :goto_9

    :pswitch_8
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move/from16 v5, p4

    move-object/from16 v13, p6

    if-ne v0, v1, :cond_13

    invoke-static {v12, v4}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BI)I

    move-result v0

    invoke-virtual {v10, v14, v2, v3, v0}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    add-int/lit8 v0, v4, 0x4

    or-int v6, v6, v22

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v11, p5

    move v13, v5

    goto/16 :goto_0

    :cond_13
    move/from16 p3, v7

    move v7, v4

    goto/16 :goto_9

    :pswitch_9
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move/from16 v5, p4

    move-object/from16 v13, p6

    const/4 v1, 0x1

    if-ne v0, v1, :cond_14

    invoke-static {v12, v4}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BI)J

    move-result-wide v19

    move-object v0, v10

    move-object/from16 v1, p1

    move/from16 p3, v7

    move v7, v4

    move-wide/from16 v4, v19

    invoke-virtual/range {v0 .. v5}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    add-int/lit8 v0, v7, 0x8

    or-int v6, v6, v22

    move/from16 v7, p3

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v13, p4

    move/from16 v11, p5

    goto/16 :goto_0

    :cond_14
    move/from16 p3, v7

    move v7, v4

    goto/16 :goto_9

    :pswitch_a
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move/from16 p3, v7

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move-object/from16 v13, p6

    move v7, v4

    if-nez v0, :cond_15

    invoke-static {v12, v7, v13}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    iget v1, v13, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-virtual {v10, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    or-int v6, v6, v22

    move/from16 v7, p3

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v13, p4

    move/from16 v11, p5

    goto/16 :goto_0

    :pswitch_b
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move/from16 p3, v7

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move-object/from16 v13, p6

    move v7, v4

    if-nez v0, :cond_15

    invoke-static {v12, v7, v13}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v7

    iget-wide v4, v13, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    move-object v0, v10

    move-object/from16 v1, p1

    invoke-virtual/range {v0 .. v5}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    or-int v6, v6, v22

    move v0, v7

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v7, p3

    move/from16 v13, p4

    move/from16 v11, p5

    goto/16 :goto_0

    :pswitch_c
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move/from16 p3, v7

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move-object/from16 v13, p6

    move v7, v4

    if-ne v0, v1, :cond_15

    invoke-static {v12, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zzd([BI)F

    move-result v0

    invoke-static {v14, v2, v3, v0}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JF)V

    add-int/lit8 v0, v7, 0x4

    or-int v6, v6, v22

    move/from16 v7, p3

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v13, p4

    move/from16 v11, p5

    goto/16 :goto_0

    :pswitch_d
    move v9, v2

    move v11, v3

    move/from16 v18, v5

    move/from16 p3, v7

    move-wide v2, v12

    move/from16 v8, v19

    move-object/from16 v12, p2

    move-object/from16 v13, p6

    move v7, v4

    const/4 v1, 0x1

    if-ne v0, v1, :cond_15

    invoke-static {v12, v7}, Lcom/google/android/gms/internal/measurement/zzdq;->zzc([BI)D

    move-result-wide v0

    invoke-static {v14, v2, v3, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JD)V

    add-int/lit8 v0, v7, 0x8

    or-int v6, v6, v22

    move/from16 v7, p3

    move v3, v8

    move v2, v9

    move v1, v11

    move-object v9, v13

    move/from16 v13, p4

    move/from16 v11, p5

    goto/16 :goto_0

    :cond_15
    :goto_9
    move v2, v7

    move/from16 v25, v8

    move/from16 v18, v9

    move-object/from16 v26, v10

    move/from16 v24, v11

    move/from16 v7, p3

    goto/16 :goto_d

    :cond_16
    move v5, v3

    move/from16 v17, v7

    move/from16 v8, v19

    const/16 v18, -0x1

    move v7, v4

    move-wide/from16 v27, v12

    move-object/from16 v12, p2

    move-object v13, v9

    move v9, v2

    move-wide/from16 v2, v27

    const/16 v1, 0x1b

    if-ne v11, v1, :cond_1a

    const/4 v1, 0x2

    if-ne v0, v1, :cond_19

    invoke-virtual {v10, v14, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/measurement/zzfl;

    invoke-interface {v0}, Lcom/google/android/gms/internal/measurement/zzfl;->zza()Z

    move-result v1

    if-nez v1, :cond_18

    invoke-interface {v0}, Lcom/google/android/gms/internal/measurement/zzfl;->size()I

    move-result v1

    nop

    if-nez v1, :cond_17

    const/16 v1, 0xa

    goto :goto_a

    :cond_17
    shl-int/lit8 v1, v1, 0x1

    :goto_a
    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/measurement/zzfl;->zza(I)Lcom/google/android/gms/internal/measurement/zzfl;

    move-result-object v0

    invoke-virtual {v10, v14, v2, v3, v0}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object v11, v0

    goto :goto_b

    :cond_18
    move-object v11, v0

    :goto_b
    nop

    invoke-direct {v15, v9}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v0

    move v1, v8

    move-object/from16 v2, p2

    move v3, v7

    move/from16 v4, p4

    move v7, v5

    move-object v5, v11

    move/from16 v19, v6

    move-object/from16 v6, p6

    invoke-static/range {v0 .. v6}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(Lcom/google/android/gms/internal/measurement/zzhd;I[BIILcom/google/android/gms/internal/measurement/zzfl;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    move/from16 v11, p5

    move v1, v7

    move v3, v8

    move v2, v9

    move-object v9, v13

    move/from16 v7, v17

    move/from16 v6, v19

    move/from16 v13, p4

    goto/16 :goto_0

    :cond_19
    move/from16 v19, v6

    move v6, v5

    move/from16 v24, v6

    move v15, v7

    move/from16 v25, v8

    move/from16 v18, v9

    move-object/from16 v26, v10

    goto/16 :goto_c

    :cond_1a
    move/from16 v19, v6

    move v6, v5

    const/16 v1, 0x31

    if-gt v11, v1, :cond_1c

    nop

    move/from16 v5, v20

    int-to-long v4, v5

    move v1, v0

    move-object/from16 v0, p0

    move/from16 p3, v1

    move-object/from16 v1, p1

    move-wide/from16 v22, v2

    move-object/from16 v2, p2

    move v3, v7

    move-wide/from16 v20, v4

    move/from16 v4, p4

    move v5, v8

    move/from16 v24, v6

    move v15, v7

    move/from16 v7, p3

    move/from16 v25, v8

    move v8, v9

    move/from16 v18, v9

    move-object/from16 v26, v10

    move-wide/from16 v9, v20

    move-wide/from16 v12, v22

    move-object/from16 v14, p6

    invoke-direct/range {v0 .. v14}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;[BIIIIIIJIJLcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    if-ne v0, v15, :cond_1b

    move v2, v0

    move/from16 v7, v17

    move/from16 v6, v19

    goto/16 :goto_d

    :cond_1b
    move-object/from16 v15, p0

    move-object/from16 v14, p1

    move-object/from16 v12, p2

    move/from16 v13, p4

    move/from16 v11, p5

    move-object/from16 v9, p6

    move/from16 v7, v17

    move/from16 v2, v18

    move/from16 v6, v19

    move/from16 v1, v24

    move/from16 v3, v25

    move-object/from16 v10, v26

    goto/16 :goto_0

    :cond_1c
    move/from16 p3, v0

    move-wide/from16 v22, v2

    move/from16 v24, v6

    move v15, v7

    move/from16 v25, v8

    move/from16 v18, v9

    move-object/from16 v26, v10

    move/from16 v5, v20

    const/16 v0, 0x32

    if-ne v11, v0, :cond_1f

    move/from16 v7, p3

    const/4 v0, 0x2

    if-ne v7, v0, :cond_1e

    nop

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move v3, v15

    move/from16 v4, p4

    move/from16 v5, v18

    move-wide/from16 v6, v22

    move-object/from16 v8, p6

    invoke-direct/range {v0 .. v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;[BIIIJLcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    if-ne v0, v15, :cond_1d

    move v2, v0

    move/from16 v7, v17

    move/from16 v6, v19

    goto :goto_d

    :cond_1d
    move-object/from16 v15, p0

    move-object/from16 v14, p1

    move-object/from16 v12, p2

    move/from16 v13, p4

    move/from16 v11, p5

    move-object/from16 v9, p6

    move/from16 v7, v17

    move/from16 v2, v18

    move/from16 v6, v19

    move/from16 v1, v24

    move/from16 v3, v25

    move-object/from16 v10, v26

    goto/16 :goto_0

    :cond_1e
    :goto_c
    move v2, v15

    move/from16 v7, v17

    move/from16 v6, v19

    goto :goto_d

    :cond_1f
    move/from16 v7, p3

    nop

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move v3, v15

    move/from16 v4, p4

    move v8, v5

    move/from16 v5, v25

    move/from16 v6, v24

    move v9, v11

    move-wide/from16 v10, v22

    move/from16 v12, v18

    move-object/from16 v13, p6

    invoke-direct/range {v0 .. v13}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;[BIIIIIIIJILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    if-ne v0, v15, :cond_25

    move v2, v0

    move/from16 v7, v17

    move/from16 v6, v19

    :goto_d
    move/from16 v8, p5

    move/from16 v9, v25

    if-ne v9, v8, :cond_21

    if-nez v8, :cond_20

    goto :goto_e

    :cond_20
    move-object/from16 v10, p0

    move-object/from16 v13, p1

    move v0, v2

    move v3, v9

    goto/16 :goto_10

    :cond_21
    :goto_e
    move-object/from16 v10, p0

    iget-boolean v0, v10, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    if-eqz v0, :cond_24

    move-object/from16 v11, p6

    iget-object v0, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzd:Lcom/google/android/gms/internal/measurement/zzeq;

    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzeq;->zza()Lcom/google/android/gms/internal/measurement/zzeq;

    move-result-object v1

    if-eq v0, v1, :cond_23

    iget-object v0, v10, Lcom/google/android/gms/internal/measurement/zzgs;->zzg:Lcom/google/android/gms/internal/measurement/zzgo;

    nop

    iget-object v1, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzd:Lcom/google/android/gms/internal/measurement/zzeq;

    move/from16 v12, v24

    invoke-virtual {v1, v0, v12}, Lcom/google/android/gms/internal/measurement/zzeq;->zza(Lcom/google/android/gms/internal/measurement/zzgo;I)Lcom/google/android/gms/internal/measurement/zzfd$zzf;

    move-result-object v0

    if-nez v0, :cond_22

    nop

    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzhy;

    move-result-object v4

    move v0, v9

    move-object/from16 v1, p2

    move/from16 v3, p4

    move-object/from16 v5, p6

    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(I[BIILcom/google/android/gms/internal/measurement/zzhy;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    move-object/from16 v14, p1

    move/from16 v13, p4

    move v3, v9

    move-object v15, v10

    move-object v9, v11

    move v1, v12

    move/from16 v2, v18

    move-object/from16 v10, v26

    move-object/from16 v12, p2

    move v11, v8

    goto/16 :goto_0

    :cond_22
    move-object/from16 v13, p1

    move-object v0, v13

    check-cast v0, Lcom/google/android/gms/internal/measurement/zzfd$zzd;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/measurement/zzfd$zzd;->zza()Lcom/google/android/gms/internal/measurement/zzew;

    nop

    iget-object v0, v0, Lcom/google/android/gms/internal/measurement/zzfd$zzd;->zzc:Lcom/google/android/gms/internal/measurement/zzew;

    new-instance v0, Ljava/lang/NoSuchMethodError;

    invoke-direct {v0}, Ljava/lang/NoSuchMethodError;-><init>()V

    throw v0

    :cond_23
    move-object/from16 v13, p1

    move/from16 v12, v24

    goto :goto_f

    :cond_24
    move-object/from16 v13, p1

    move-object/from16 v11, p6

    move/from16 v12, v24

    :goto_f
    nop

    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzhy;

    move-result-object v4

    move v0, v9

    move-object/from16 v1, p2

    move/from16 v3, p4

    move-object/from16 v5, p6

    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(I[BIILcom/google/android/gms/internal/measurement/zzhy;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    move v3, v9

    move-object v15, v10

    move-object v9, v11

    move v1, v12

    move-object v14, v13

    move/from16 v2, v18

    move-object/from16 v10, v26

    move-object/from16 v12, p2

    move/from16 v13, p4

    move v11, v8

    goto/16 :goto_0

    :cond_25
    move-object/from16 v10, p0

    move-object/from16 v13, p1

    move/from16 v8, p5

    move-object/from16 v11, p6

    move/from16 v12, v24

    move/from16 v9, v25

    move v3, v9

    move-object v15, v10

    move-object v9, v11

    move v1, v12

    move-object v14, v13

    move/from16 v7, v17

    move/from16 v2, v18

    move/from16 v6, v19

    move-object/from16 v10, v26

    move-object/from16 v12, p2

    move/from16 v13, p4

    move v11, v8

    goto/16 :goto_0

    :cond_26
    move/from16 v19, v6

    move/from16 v17, v7

    move-object/from16 v26, v10

    move v8, v11

    move-object v13, v14

    move-object v10, v15

    :goto_10
    const/4 v1, -0x1

    if-eq v7, v1, :cond_27

    int-to-long v1, v7

    move-object/from16 v4, v26

    invoke-virtual {v4, v13, v1, v2, v6}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_27
    const/4 v1, 0x0

    iget v2, v10, Lcom/google/android/gms/internal/measurement/zzgs;->zzm:I

    :goto_11
    iget v4, v10, Lcom/google/android/gms/internal/measurement/zzgs;->zzn:I

    if-ge v2, v4, :cond_28

    iget-object v4, v10, Lcom/google/android/gms/internal/measurement/zzgs;->zzl:[I

    aget v4, v4, v2

    iget-object v5, v10, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-direct {v10, v13, v4, v1, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/measurement/zzhy;

    add-int/lit8 v2, v2, 0x1

    goto :goto_11

    :cond_28
    if-eqz v1, :cond_29

    iget-object v2, v10, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-virtual {v2, v13, v1}, Lcom/google/android/gms/internal/measurement/zzhv;->zzb(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_29
    if-nez v8, :cond_2b

    move/from16 v1, p4

    if-ne v0, v1, :cond_2a

    goto :goto_12

    :cond_2a
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzg()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v0

    throw v0

    :cond_2b
    move/from16 v1, p4

    if-gt v0, v1, :cond_2c

    if-ne v3, v8, :cond_2c

    :goto_12
    return v0

    :cond_2c
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzg()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v0

    throw v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_a
        :pswitch_3
        :pswitch_8
        :pswitch_9
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final zza()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzo:Lcom/google/android/gms/internal/measurement/zzgw;

    iget-object v1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzg:Lcom/google/android/gms/internal/measurement/zzgo;

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/measurement/zzgw;->zza(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final zza(Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhe;Lcom/google/android/gms/internal/measurement/zzeq;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lcom/google/android/gms/internal/measurement/zzhe;",
            "Lcom/google/android/gms/internal/measurement/zzeq;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p3, :cond_1f

    iget-object v8, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    nop

    move-object v1, v0

    move-object v10, v1

    :cond_0
    :goto_0
    :try_start_0
    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zza()I

    move-result v2

    invoke-direct {p0, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzg(I)I

    move-result v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-gez v3, :cond_a

    const v3, 0x7fffffff

    if-ne v2, v3, :cond_3

    iget p2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzm:I

    :goto_1
    iget p3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzn:I

    if-ge p2, p3, :cond_1

    iget-object p3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzl:[I

    aget p3, p3, p2

    invoke-direct {p0, p1, p3, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v10

    add-int/lit8 p2, p2, 0x1

    goto :goto_1

    :cond_1
    if-eqz v10, :cond_2

    invoke-virtual {v8, p1, v10}, Lcom/google/android/gms/internal/measurement/zzhv;->zzb(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_2
    return-void

    :cond_3
    :try_start_1
    iget-boolean v3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    if-nez v3, :cond_4

    move-object v3, v0

    goto :goto_2

    :cond_4
    iget-object v3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzg:Lcom/google/android/gms/internal/measurement/zzgo;

    invoke-virtual {v9, p3, v3, v2}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Lcom/google/android/gms/internal/measurement/zzeq;Lcom/google/android/gms/internal/measurement/zzgo;I)Ljava/lang/Object;

    move-result-object v2

    move-object v3, v2

    :goto_2
    if-eqz v3, :cond_6

    if-nez v1, :cond_5

    invoke-virtual {v9, p1}, Lcom/google/android/gms/internal/measurement/zzes;->zzb(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzew;

    move-result-object v1

    move-object v11, v1

    goto :goto_3

    :cond_5
    move-object v11, v1

    :goto_3
    nop

    move-object v1, v9

    move-object v2, p2

    move-object v4, p3

    move-object v5, v11

    move-object v6, v10

    move-object v7, v8

    invoke-virtual/range {v1 .. v7}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Lcom/google/android/gms/internal/measurement/zzhe;Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzeq;Lcom/google/android/gms/internal/measurement/zzew;Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v10

    move-object v1, v11

    goto :goto_0

    :cond_6
    invoke-virtual {v8, p2}, Lcom/google/android/gms/internal/measurement/zzhv;->zza(Lcom/google/android/gms/internal/measurement/zzhe;)Z

    if-nez v10, :cond_7

    invoke-virtual {v8, p1}, Lcom/google/android/gms/internal/measurement/zzhv;->zzc(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :cond_7
    invoke-virtual {v8, v10, p2}, Lcom/google/android/gms/internal/measurement/zzhv;->zza(Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhe;)Z

    move-result v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v2, :cond_0

    iget p2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzm:I

    :goto_4
    iget p3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzn:I

    if-ge p2, p3, :cond_8

    iget-object p3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzl:[I

    aget p3, p3, p2

    invoke-direct {p0, p1, p3, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v10

    add-int/lit8 p2, p2, 0x1

    goto :goto_4

    :cond_8
    if-eqz v10, :cond_9

    invoke-virtual {v8, p1, v10}, Lcom/google/android/gms/internal/measurement/zzhv;->zzb(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_9
    return-void

    :cond_a
    :try_start_2
    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    nop

    const/high16 v5, 0xff00000

    and-int/2addr v5, v4

    ushr-int/lit8 v5, v5, 0x14

    const v6, 0xfffff

    packed-switch v5, :pswitch_data_0

    if-nez v10, :cond_15

    :try_start_3
    invoke-virtual {v8}, Lcom/google/android/gms/internal/measurement/zzhv;->zza()Ljava/lang/Object;

    move-result-object v10

    goto/16 :goto_9

    :pswitch_0
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    nop

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v6

    invoke-interface {p2, v6, p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zzb(Lcom/google/android/gms/internal/measurement/zzhd;Lcom/google/android/gms/internal/measurement/zzeq;)Ljava/lang/Object;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_1
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzt()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_2
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzs()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_3
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzr()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_4
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzq()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_5
    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzp()I

    move-result v5

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(I)Lcom/google/android/gms/internal/measurement/zzfk;

    move-result-object v7

    if-eqz v7, :cond_c

    invoke-interface {v7, v5}, Lcom/google/android/gms/internal/measurement/zzfk;->zza(I)Z

    move-result v7

    if-eqz v7, :cond_b

    goto :goto_5

    :cond_b
    nop

    invoke-static {v2, v5, v10, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(IILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v10

    goto/16 :goto_0

    :cond_c
    :goto_5
    nop

    and-int/2addr v4, v6

    int-to-long v6, v4

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {p1, v6, v7, v4}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_6
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzo()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_7
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzn()Lcom/google/android/gms/internal/measurement/zzdu;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_8
    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v5

    if-eqz v5, :cond_d

    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v6

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v7

    invoke-interface {p2, v7, p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zza(Lcom/google/android/gms/internal/measurement/zzhd;Lcom/google/android/gms/internal/measurement/zzeq;)Ljava/lang/Object;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    nop

    nop

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_6

    :cond_d
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    nop

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v6

    invoke-interface {p2, v6, p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zza(Lcom/google/android/gms/internal/measurement/zzhd;Lcom/google/android/gms/internal/measurement/zzeq;)Ljava/lang/Object;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    :goto_6
    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_9
    invoke-direct {p0, p1, v4, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;ILcom/google/android/gms/internal/measurement/zzhe;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_a
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzk()Z

    move-result v6

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_b
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzj()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_c
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzi()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_d
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzh()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_e
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzf()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_f
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzg()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_10
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zze()F

    move-result v6

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_11
    nop

    and-int/2addr v4, v6

    int-to-long v4, v4

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzd()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v6

    invoke-static {p1, v4, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_0

    :pswitch_12
    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(I)Ljava/lang/Object;

    move-result-object v2

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v3

    and-int/2addr v3, v6

    int-to-long v3, v3

    nop

    invoke-static {p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    if-nez v5, :cond_e

    iget-object v5, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v5, v2}, Lcom/google/android/gms/internal/measurement/zzgh;->zze(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-static {p1, v3, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_7

    :cond_e
    iget-object v6, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v6, v5}, Lcom/google/android/gms/internal/measurement/zzgh;->zzc(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_f

    nop

    iget-object v6, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v6, v2}, Lcom/google/android/gms/internal/measurement/zzgh;->zze(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    iget-object v7, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v7, v6, v5}, Lcom/google/android/gms/internal/measurement/zzgh;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {p1, v3, v4, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object v5, v6

    :cond_f
    :goto_7
    iget-object v3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v3, v5}, Lcom/google/android/gms/internal/measurement/zzgh;->zza(Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v3

    iget-object v4, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v4, v2}, Lcom/google/android/gms/internal/measurement/zzgh;->zzf(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzgf;

    move-result-object v2

    invoke-interface {p2, v3, v2, p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zza(Ljava/util/Map;Lcom/google/android/gms/internal/measurement/zzgf;Lcom/google/android/gms/internal/measurement/zzeq;)V

    goto/16 :goto_0

    :pswitch_13
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    nop

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v2

    nop

    iget-object v3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    invoke-virtual {v3, p1, v4, v5}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v3

    invoke-interface {p2, v3, v2, p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zzb(Ljava/util/List;Lcom/google/android/gms/internal/measurement/zzhd;Lcom/google/android/gms/internal/measurement/zzeq;)V

    goto/16 :goto_0

    :pswitch_14
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzq(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_15
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzp(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_16
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzo(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_17
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzn(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_18
    iget-object v5, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int/2addr v4, v6

    int-to-long v6, v4

    invoke-virtual {v5, p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v4

    invoke-interface {p2, v4}, Lcom/google/android/gms/internal/measurement/zzhe;->zzm(Ljava/util/List;)V

    nop

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(I)Lcom/google/android/gms/internal/measurement/zzfk;

    move-result-object v3

    invoke-static {v2, v4, v3, v10, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzfk;Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v10

    goto/16 :goto_0

    :pswitch_19
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzl(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_1a
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzh(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_1b
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzg(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_1c
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzf(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_1d
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zze(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_1e
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzc(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_1f
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzd(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_20
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzb(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_21
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zza(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_22
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzq(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_23
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzp(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_24
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzo(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_25
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzn(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_26
    iget-object v5, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int/2addr v4, v6

    int-to-long v6, v4

    invoke-virtual {v5, p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v4

    invoke-interface {p2, v4}, Lcom/google/android/gms/internal/measurement/zzhe;->zzm(Ljava/util/List;)V

    nop

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(I)Lcom/google/android/gms/internal/measurement/zzfk;

    move-result-object v3

    invoke-static {v2, v4, v3, v10, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzfk;Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v10

    goto/16 :goto_0

    :pswitch_27
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzl(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_28
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzk(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_29
    nop

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v2

    nop

    nop

    and-int v3, v4, v6

    int-to-long v3, v3

    nop

    iget-object v5, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    invoke-virtual {v5, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v3

    invoke-interface {p2, v3, v2, p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zza(Ljava/util/List;Lcom/google/android/gms/internal/measurement/zzhd;Lcom/google/android/gms/internal/measurement/zzeq;)V

    goto/16 :goto_0

    :pswitch_2a
    nop

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzgs;->zzf(I)Z

    move-result v2

    if-eqz v2, :cond_10

    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzj(Ljava/util/List;)V

    goto/16 :goto_0

    :cond_10
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzi(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_2b
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzh(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_2c
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzg(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_2d
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzf(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_2e
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zze(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_2f
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzc(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_30
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzd(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_31
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzb(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_32
    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    and-int v3, v4, v6

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v2

    invoke-interface {p2, v2}, Lcom/google/android/gms/internal/measurement/zzhe;->zza(Ljava/util/List;)V

    goto/16 :goto_0

    :pswitch_33
    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_11

    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v3

    invoke-interface {p2, v3, p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zzb(Lcom/google/android/gms/internal/measurement/zzhd;Lcom/google/android/gms/internal/measurement/zzeq;)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    nop

    nop

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_0

    :cond_11
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    nop

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v2

    invoke-interface {p2, v2, p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zzb(Lcom/google/android/gms/internal/measurement/zzhd;Lcom/google/android/gms/internal/measurement/zzeq;)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_34
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzt()J

    move-result-wide v6

    invoke-static {p1, v4, v5, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JJ)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_35
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzs()I

    move-result v2

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_36
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzr()J

    move-result-wide v6

    invoke-static {p1, v4, v5, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JJ)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_37
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzq()I

    move-result v2

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_38
    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzp()I

    move-result v5

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(I)Lcom/google/android/gms/internal/measurement/zzfk;

    move-result-object v7

    if-eqz v7, :cond_13

    invoke-interface {v7, v5}, Lcom/google/android/gms/internal/measurement/zzfk;->zza(I)Z

    move-result v7

    if-eqz v7, :cond_12

    goto :goto_8

    :cond_12
    nop

    invoke-static {v2, v5, v10, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(IILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v10

    goto/16 :goto_0

    :cond_13
    :goto_8
    nop

    and-int v2, v4, v6

    int-to-long v6, v2

    invoke-static {p1, v6, v7, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_39
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzo()I

    move-result v2

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_3a
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzn()Lcom/google/android/gms/internal/measurement/zzdu;

    move-result-object v2

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_3b
    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v2

    if-eqz v2, :cond_14

    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v2

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v3

    invoke-interface {p2, v3, p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zza(Lcom/google/android/gms/internal/measurement/zzhd;Lcom/google/android/gms/internal/measurement/zzeq;)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    nop

    nop

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    goto/16 :goto_0

    :cond_14
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    nop

    invoke-direct {p0, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v2

    invoke-interface {p2, v2, p3}, Lcom/google/android/gms/internal/measurement/zzhe;->zza(Lcom/google/android/gms/internal/measurement/zzhd;Lcom/google/android/gms/internal/measurement/zzeq;)Ljava/lang/Object;

    move-result-object v2

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_3c
    invoke-direct {p0, p1, v4, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;ILcom/google/android/gms/internal/measurement/zzhe;)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_3d
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzk()Z

    move-result v2

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JZ)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_3e
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzj()I

    move-result v2

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_3f
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzi()J

    move-result-wide v6

    invoke-static {p1, v4, v5, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JJ)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_40
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzh()I

    move-result v2

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_41
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzf()J

    move-result-wide v6

    invoke-static {p1, v4, v5, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JJ)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_42
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzg()J

    move-result-wide v6

    invoke-static {p1, v4, v5, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JJ)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_43
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zze()F

    move-result v2

    invoke-static {p1, v4, v5, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JF)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :pswitch_44
    nop

    and-int v2, v4, v6

    int-to-long v4, v2

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzhe;->zzd()D

    move-result-wide v6

    invoke-static {p1, v4, v5, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JD)V

    invoke-direct {p0, p1, v3}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_0

    :cond_15
    :goto_9
    invoke-virtual {v8, v10, p2}, Lcom/google/android/gms/internal/measurement/zzhv;->zza(Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhe;)Z

    move-result v2
    :try_end_3
    .catch Lcom/google/android/gms/internal/measurement/zzfn; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    if-nez v2, :cond_18

    iget p2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzm:I

    :goto_a
    iget p3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzn:I

    if-ge p2, p3, :cond_16

    iget-object p3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzl:[I

    aget p3, p3, p2

    invoke-direct {p0, p1, p3, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v10

    add-int/lit8 p2, p2, 0x1

    goto :goto_a

    :cond_16
    if-eqz v10, :cond_17

    invoke-virtual {v8, p1, v10}, Lcom/google/android/gms/internal/measurement/zzhv;->zzb(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_17
    return-void

    :cond_18
    goto/16 :goto_0

    :catch_0
    move-exception v2

    :try_start_4
    invoke-virtual {v8, p2}, Lcom/google/android/gms/internal/measurement/zzhv;->zza(Lcom/google/android/gms/internal/measurement/zzhe;)Z

    if-nez v10, :cond_19

    invoke-virtual {v8, p1}, Lcom/google/android/gms/internal/measurement/zzhv;->zzc(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    move-object v10, v2

    :cond_19
    invoke-virtual {v8, v10, p2}, Lcom/google/android/gms/internal/measurement/zzhv;->zza(Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhe;)Z

    move-result v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    if-nez v2, :cond_1c

    iget p2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzm:I

    :goto_b
    iget p3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzn:I

    if-ge p2, p3, :cond_1a

    iget-object p3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzl:[I

    aget p3, p3, p2

    invoke-direct {p0, p1, p3, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v10

    add-int/lit8 p2, p2, 0x1

    goto :goto_b

    :cond_1a
    if-eqz v10, :cond_1b

    invoke-virtual {v8, p1, v10}, Lcom/google/android/gms/internal/measurement/zzhv;->zzb(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_1b
    return-void

    :cond_1c
    goto/16 :goto_0

    :catchall_0
    move-exception p2

    iget p3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzm:I

    :goto_c
    iget v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzn:I

    if-ge p3, v0, :cond_1d

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzl:[I

    aget v0, v0, p3

    invoke-direct {p0, p1, v0, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhv;)Ljava/lang/Object;

    move-result-object v10

    add-int/lit8 p3, p3, 0x1

    goto :goto_c

    :cond_1d
    if-eqz v10, :cond_1e

    invoke-virtual {v8, p1, v10}, Lcom/google/android/gms/internal/measurement/zzhv;->zzb(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_1e
    throw p2

    :cond_1f
    throw v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_44
        :pswitch_43
        :pswitch_42
        :pswitch_41
        :pswitch_40
        :pswitch_3f
        :pswitch_3e
        :pswitch_3d
        :pswitch_3c
        :pswitch_3b
        :pswitch_3a
        :pswitch_39
        :pswitch_38
        :pswitch_37
        :pswitch_36
        :pswitch_35
        :pswitch_34
        :pswitch_33
        :pswitch_32
        :pswitch_31
        :pswitch_30
        :pswitch_2f
        :pswitch_2e
        :pswitch_2d
        :pswitch_2c
        :pswitch_2b
        :pswitch_2a
        :pswitch_29
        :pswitch_28
        :pswitch_27
        :pswitch_26
        :pswitch_25
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_1d
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final zza(Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lcom/google/android/gms/internal/measurement/zzis;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-interface {p2}, Lcom/google/android/gms/internal/measurement/zzis;->zza()I

    move-result v0

    sget v1, Lcom/google/android/gms/internal/measurement/zzfd$zze;->zzk:I

    const/high16 v2, 0xff00000

    const/4 v3, 0x0

    const/4 v4, 0x1

    const/4 v5, 0x0

    const v6, 0xfffff

    if-ne v0, v1, :cond_7

    nop

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-static {v0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Lcom/google/android/gms/internal/measurement/zzhv;Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V

    nop

    nop

    iget-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzew;

    move-result-object v0

    nop

    iget-object v1, v0, Lcom/google/android/gms/internal/measurement/zzew;->zza:Lcom/google/android/gms/internal/measurement/zzhi;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/measurement/zzhi;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/measurement/zzew;->zze()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    goto :goto_0

    :cond_0
    move-object v0, v3

    move-object v1, v0

    :goto_0
    iget-object v7, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    array-length v7, v7

    add-int/lit8 v7, v7, -0x3

    :goto_1
    if-ltz v7, :cond_4

    invoke-direct {p0, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v8

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    :goto_2
    if-eqz v1, :cond_2

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v10, v1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Ljava/util/Map$Entry;)I

    move-result v10

    if-le v10, v9, :cond_2

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v10, p2, v1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Lcom/google/android/gms/internal/measurement/zzis;Ljava/util/Map$Entry;)V

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    goto :goto_2

    :cond_1
    move-object v1, v3

    goto :goto_2

    :cond_2
    nop

    and-int v10, v8, v2

    ushr-int/lit8 v10, v10, 0x14

    packed-switch v10, :pswitch_data_0

    goto/16 :goto_3

    :pswitch_0
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    invoke-direct {p0, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v10

    invoke-interface {p2, v9, v8, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_3

    :pswitch_1
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zze(IJ)V

    goto/16 :goto_3

    :pswitch_2
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zzf(II)V

    goto/16 :goto_3

    :pswitch_3
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(IJ)V

    goto/16 :goto_3

    :pswitch_4
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zza(II)V

    goto/16 :goto_3

    :pswitch_5
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(II)V

    goto/16 :goto_3

    :pswitch_6
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zze(II)V

    goto/16 :goto_3

    :pswitch_7
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILcom/google/android/gms/internal/measurement/zzdu;)V

    goto/16 :goto_3

    :pswitch_8
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    invoke-direct {p0, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v10

    invoke-interface {p2, v9, v8, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_3

    :pswitch_9
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    invoke-static {v9, v8, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V

    goto/16 :goto_3

    :pswitch_a
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zzf(Ljava/lang/Object;J)Z

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IZ)V

    goto/16 :goto_3

    :pswitch_b
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(II)V

    goto/16 :goto_3

    :pswitch_c
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(IJ)V

    goto/16 :goto_3

    :pswitch_d
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(II)V

    goto/16 :goto_3

    :pswitch_e
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(IJ)V

    goto/16 :goto_3

    :pswitch_f
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IJ)V

    goto/16 :goto_3

    :pswitch_10
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;J)F

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IF)V

    goto/16 :goto_3

    :pswitch_11
    invoke-direct {p0, p1, v9, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;J)D

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ID)V

    goto/16 :goto_3

    :pswitch_12
    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    invoke-direct {p0, p2, v9, v8, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Lcom/google/android/gms/internal/measurement/zzis;ILjava/lang/Object;I)V

    goto/16 :goto_3

    :pswitch_13
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-direct {p0, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v10

    invoke-static {v9, v8, p2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_3

    :pswitch_14
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zze(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_15
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzj(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_16
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzg(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_17
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzl(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_18
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzm(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_19
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_1a
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzn(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_1b
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzk(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_1c
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzf(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_1d
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_1e
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzd(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_1f
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzc(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_20
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_21
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_22
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zze(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_23
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzj(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_24
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzg(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_25
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzl(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_26
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzm(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_27
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_28
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;)V

    goto/16 :goto_3

    :pswitch_29
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-direct {p0, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v10

    invoke-static {v9, v8, p2, v10}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_3

    :pswitch_2a
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;)V

    goto/16 :goto_3

    :pswitch_2b
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzn(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_2c
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzk(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_2d
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzf(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_2e
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_2f
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzd(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_30
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzc(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_31
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_32
    nop

    nop

    iget-object v9, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v9, v9, v7

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-static {v9, v8, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_3

    :pswitch_33
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    invoke-direct {p0, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v10

    invoke-interface {p2, v9, v8, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_3

    :pswitch_34
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zze(IJ)V

    goto/16 :goto_3

    :pswitch_35
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zzf(II)V

    goto/16 :goto_3

    :pswitch_36
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(IJ)V

    goto/16 :goto_3

    :pswitch_37
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zza(II)V

    goto/16 :goto_3

    :pswitch_38
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(II)V

    goto/16 :goto_3

    :pswitch_39
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zze(II)V

    goto/16 :goto_3

    :pswitch_3a
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILcom/google/android/gms/internal/measurement/zzdu;)V

    goto/16 :goto_3

    :pswitch_3b
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    invoke-direct {p0, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v10

    invoke-interface {p2, v9, v8, v10}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_3

    :pswitch_3c
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    invoke-static {v9, v8, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V

    goto/16 :goto_3

    :pswitch_3d
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzc(Ljava/lang/Object;J)Z

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IZ)V

    goto/16 :goto_3

    :pswitch_3e
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(II)V

    goto :goto_3

    :pswitch_3f
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(IJ)V

    goto :goto_3

    :pswitch_40
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(II)V

    goto :goto_3

    :pswitch_41
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(IJ)V

    goto :goto_3

    :pswitch_42
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IJ)V

    goto :goto_3

    :pswitch_43
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zzd(Ljava/lang/Object;J)F

    move-result v8

    invoke-interface {p2, v9, v8}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IF)V

    goto :goto_3

    :pswitch_44
    invoke-direct {p0, p1, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v10

    if-eqz v10, :cond_3

    nop

    and-int/2addr v8, v6

    int-to-long v10, v8

    nop

    invoke-static {p1, v10, v11}, Lcom/google/android/gms/internal/measurement/zzib;->zze(Ljava/lang/Object;J)D

    move-result-wide v10

    invoke-interface {p2, v9, v10, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ID)V

    :cond_3
    :goto_3
    add-int/lit8 v7, v7, -0x3

    goto/16 :goto_1

    :cond_4
    :goto_4
    if-eqz v1, :cond_6

    iget-object p1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {p1, p2, v1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Lcom/google/android/gms/internal/measurement/zzis;Ljava/util/Map$Entry;)V

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result p1

    if-eqz p1, :cond_5

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/Map$Entry;

    move-object v1, p1

    goto :goto_4

    :cond_5
    move-object v1, v3

    goto :goto_4

    :cond_6
    return-void

    :cond_7
    iget-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzj:Z

    if-eqz v0, :cond_f

    nop

    nop

    nop

    iget-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    if-eqz v0, :cond_8

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzew;

    move-result-object v0

    nop

    iget-object v1, v0, Lcom/google/android/gms/internal/measurement/zzew;->zza:Lcom/google/android/gms/internal/measurement/zzhi;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/measurement/zzhi;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_8

    invoke-virtual {v0}, Lcom/google/android/gms/internal/measurement/zzew;->zzd()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    goto :goto_5

    :cond_8
    move-object v0, v3

    move-object v1, v0

    :goto_5
    iget-object v7, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    array-length v7, v7

    move v8, v5

    :goto_6
    if-ge v8, v7, :cond_c

    invoke-direct {p0, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v9

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    :goto_7
    if-eqz v1, :cond_a

    iget-object v11, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v11, v1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Ljava/util/Map$Entry;)I

    move-result v11

    if-gt v11, v10, :cond_a

    iget-object v11, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v11, p2, v1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Lcom/google/android/gms/internal/measurement/zzis;Ljava/util/Map$Entry;)V

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_9

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    goto :goto_7

    :cond_9
    move-object v1, v3

    goto :goto_7

    :cond_a
    nop

    and-int v11, v9, v2

    ushr-int/lit8 v11, v11, 0x14

    packed-switch v11, :pswitch_data_1

    goto/16 :goto_8

    :pswitch_45
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    invoke-direct {p0, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v11

    invoke-interface {p2, v10, v9, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_8

    :pswitch_46
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zze(IJ)V

    goto/16 :goto_8

    :pswitch_47
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zzf(II)V

    goto/16 :goto_8

    :pswitch_48
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(IJ)V

    goto/16 :goto_8

    :pswitch_49
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zza(II)V

    goto/16 :goto_8

    :pswitch_4a
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(II)V

    goto/16 :goto_8

    :pswitch_4b
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zze(II)V

    goto/16 :goto_8

    :pswitch_4c
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILcom/google/android/gms/internal/measurement/zzdu;)V

    goto/16 :goto_8

    :pswitch_4d
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    invoke-direct {p0, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v11

    invoke-interface {p2, v10, v9, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_8

    :pswitch_4e
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    invoke-static {v10, v9, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V

    goto/16 :goto_8

    :pswitch_4f
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zzf(Ljava/lang/Object;J)Z

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IZ)V

    goto/16 :goto_8

    :pswitch_50
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(II)V

    goto/16 :goto_8

    :pswitch_51
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(IJ)V

    goto/16 :goto_8

    :pswitch_52
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(II)V

    goto/16 :goto_8

    :pswitch_53
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(IJ)V

    goto/16 :goto_8

    :pswitch_54
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IJ)V

    goto/16 :goto_8

    :pswitch_55
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;J)F

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IF)V

    goto/16 :goto_8

    :pswitch_56
    invoke-direct {p0, p1, v10, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;J)D

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ID)V

    goto/16 :goto_8

    :pswitch_57
    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    invoke-direct {p0, p2, v10, v9, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Lcom/google/android/gms/internal/measurement/zzis;ILjava/lang/Object;I)V

    goto/16 :goto_8

    :pswitch_58
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-direct {p0, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v11

    invoke-static {v10, v9, p2, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_8

    :pswitch_59
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zze(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_5a
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzj(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_5b
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzg(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_5c
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzl(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_5d
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzm(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_5e
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_5f
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzn(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_60
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzk(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_61
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzf(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_62
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_63
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzd(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_64
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzc(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_65
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_66
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_67
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zze(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_68
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzj(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_69
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzg(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_6a
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzl(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_6b
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzm(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_6c
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_6d
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;)V

    goto/16 :goto_8

    :pswitch_6e
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-direct {p0, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v11

    invoke-static {v10, v9, p2, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_8

    :pswitch_6f
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;)V

    goto/16 :goto_8

    :pswitch_70
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzn(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_71
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzk(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_72
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzf(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_73
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_74
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzd(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_75
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzc(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_76
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_77
    nop

    nop

    iget-object v10, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v10, v10, v8

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    invoke-static {v10, v9, p2, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzis;Z)V

    goto/16 :goto_8

    :pswitch_78
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    invoke-direct {p0, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v11

    invoke-interface {p2, v10, v9, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_8

    :pswitch_79
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zze(IJ)V

    goto/16 :goto_8

    :pswitch_7a
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zzf(II)V

    goto/16 :goto_8

    :pswitch_7b
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(IJ)V

    goto/16 :goto_8

    :pswitch_7c
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zza(II)V

    goto/16 :goto_8

    :pswitch_7d
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zzb(II)V

    goto/16 :goto_8

    :pswitch_7e
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zze(II)V

    goto/16 :goto_8

    :pswitch_7f
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILcom/google/android/gms/internal/measurement/zzdu;)V

    goto/16 :goto_8

    :pswitch_80
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    invoke-direct {p0, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v11

    invoke-interface {p2, v10, v9, v11}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)V

    goto/16 :goto_8

    :pswitch_81
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v9

    invoke-static {v10, v9, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V

    goto/16 :goto_8

    :pswitch_82
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzc(Ljava/lang/Object;J)Z

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IZ)V

    goto/16 :goto_8

    :pswitch_83
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(II)V

    goto :goto_8

    :pswitch_84
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zzd(IJ)V

    goto :goto_8

    :pswitch_85
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(II)V

    goto :goto_8

    :pswitch_86
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zzc(IJ)V

    goto :goto_8

    :pswitch_87
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IJ)V

    goto :goto_8

    :pswitch_88
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zzd(Ljava/lang/Object;J)F

    move-result v9

    invoke-interface {p2, v10, v9}, Lcom/google/android/gms/internal/measurement/zzis;->zza(IF)V

    goto :goto_8

    :pswitch_89
    invoke-direct {p0, p1, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v11

    if-eqz v11, :cond_b

    nop

    and-int/2addr v9, v6

    int-to-long v11, v9

    nop

    invoke-static {p1, v11, v12}, Lcom/google/android/gms/internal/measurement/zzib;->zze(Ljava/lang/Object;J)D

    move-result-wide v11

    invoke-interface {p2, v10, v11, v12}, Lcom/google/android/gms/internal/measurement/zzis;->zza(ID)V

    :cond_b
    :goto_8
    add-int/lit8 v8, v8, 0x3

    goto/16 :goto_6

    :cond_c
    :goto_9
    if-eqz v1, :cond_e

    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v2, p2, v1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Lcom/google/android/gms/internal/measurement/zzis;Ljava/util/Map$Entry;)V

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_d

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    goto :goto_9

    :cond_d
    move-object v1, v3

    goto :goto_9

    :cond_e
    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-static {v0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Lcom/google/android/gms/internal/measurement/zzhv;Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V

    return-void

    :cond_f
    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;Lcom/google/android/gms/internal/measurement/zzis;)V

    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_44
        :pswitch_43
        :pswitch_42
        :pswitch_41
        :pswitch_40
        :pswitch_3f
        :pswitch_3e
        :pswitch_3d
        :pswitch_3c
        :pswitch_3b
        :pswitch_3a
        :pswitch_39
        :pswitch_38
        :pswitch_37
        :pswitch_36
        :pswitch_35
        :pswitch_34
        :pswitch_33
        :pswitch_32
        :pswitch_31
        :pswitch_30
        :pswitch_2f
        :pswitch_2e
        :pswitch_2d
        :pswitch_2c
        :pswitch_2b
        :pswitch_2a
        :pswitch_29
        :pswitch_28
        :pswitch_27
        :pswitch_26
        :pswitch_25
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_1d
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_89
        :pswitch_88
        :pswitch_87
        :pswitch_86
        :pswitch_85
        :pswitch_84
        :pswitch_83
        :pswitch_82
        :pswitch_81
        :pswitch_80
        :pswitch_7f
        :pswitch_7e
        :pswitch_7d
        :pswitch_7c
        :pswitch_7b
        :pswitch_7a
        :pswitch_79
        :pswitch_78
        :pswitch_77
        :pswitch_76
        :pswitch_75
        :pswitch_74
        :pswitch_73
        :pswitch_72
        :pswitch_71
        :pswitch_70
        :pswitch_6f
        :pswitch_6e
        :pswitch_6d
        :pswitch_6c
        :pswitch_6b
        :pswitch_6a
        :pswitch_69
        :pswitch_68
        :pswitch_67
        :pswitch_66
        :pswitch_65
        :pswitch_64
        :pswitch_63
        :pswitch_62
        :pswitch_61
        :pswitch_60
        :pswitch_5f
        :pswitch_5e
        :pswitch_5d
        :pswitch_5c
        :pswitch_5b
        :pswitch_5a
        :pswitch_59
        :pswitch_58
        :pswitch_57
        :pswitch_56
        :pswitch_55
        :pswitch_54
        :pswitch_53
        :pswitch_52
        :pswitch_51
        :pswitch_50
        :pswitch_4f
        :pswitch_4e
        :pswitch_4d
        :pswitch_4c
        :pswitch_4b
        :pswitch_4a
        :pswitch_49
        :pswitch_48
        :pswitch_47
        :pswitch_46
        :pswitch_45
    .end packed-switch
.end method

.method public final zza(Ljava/lang/Object;[BIILcom/google/android/gms/internal/measurement/zzdt;)V
    .locals 27
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;[BII",
            "Lcom/google/android/gms/internal/measurement/zzdt;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    move-object/from16 v15, p0

    move-object/from16 v14, p1

    move-object/from16 v12, p2

    move/from16 v13, p4

    move-object/from16 v11, p5

    iget-boolean v0, v15, Lcom/google/android/gms/internal/measurement/zzgs;->zzj:Z

    if-eqz v0, :cond_20

    nop

    sget-object v9, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    nop

    const/4 v10, -0x1

    const/16 v16, 0x0

    move/from16 v0, p3

    move v1, v10

    move/from16 v2, v16

    :goto_0
    if-ge v0, v13, :cond_1e

    add-int/lit8 v3, v0, 0x1

    aget-byte v0, v12, v0

    if-gez v0, :cond_0

    invoke-static {v0, v12, v3, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(I[BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    iget v3, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    move v8, v0

    move/from16 v17, v3

    goto :goto_1

    :cond_0
    move/from16 v17, v0

    move v8, v3

    :goto_1
    ushr-int/lit8 v7, v17, 0x3

    and-int/lit8 v6, v17, 0x7

    if-le v7, v1, :cond_1

    div-int/lit8 v2, v2, 0x3

    invoke-direct {v15, v7, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(II)I

    move-result v0

    move v4, v0

    goto :goto_2

    :cond_1
    invoke-direct {v15, v7}, Lcom/google/android/gms/internal/measurement/zzgs;->zzg(I)I

    move-result v0

    move v4, v0

    :goto_2
    nop

    if-ne v4, v10, :cond_2

    move/from16 v24, v7

    move v2, v8

    move-object/from16 v18, v9

    move/from16 v26, v10

    move/from16 v19, v16

    goto/16 :goto_9

    :cond_2
    iget-object v0, v15, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    add-int/lit8 v1, v4, 0x1

    aget v5, v0, v1

    nop

    const/high16 v0, 0xff00000

    and-int/2addr v0, v5

    ushr-int/lit8 v3, v0, 0x14

    nop

    nop

    const v0, 0xfffff

    and-int/2addr v0, v5

    int-to-long v1, v0

    nop

    const/16 v0, 0x11

    const/4 v10, 0x2

    if-gt v3, v0, :cond_13

    const/4 v0, 0x1

    packed-switch v3, :pswitch_data_0

    move v10, v4

    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    move/from16 v19, v10

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_0
    if-nez v6, :cond_3

    invoke-static {v12, v8, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v6

    move-wide/from16 v19, v1

    iget-wide v0, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/measurement/zzeg;->zza(J)J

    move-result-wide v21

    move-object v0, v9

    move-wide/from16 v2, v19

    move-object/from16 v1, p1

    move v10, v4

    move-wide/from16 v4, v21

    invoke-virtual/range {v0 .. v5}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    move v0, v6

    move v1, v7

    move v2, v10

    const/4 v10, -0x1

    goto :goto_0

    :cond_3
    move v10, v4

    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    move/from16 v19, v10

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_1
    move-wide v2, v1

    move v10, v4

    if-nez v6, :cond_4

    invoke-static {v12, v8, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    iget v1, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-static {v1}, Lcom/google/android/gms/internal/measurement/zzeg;->zze(I)I

    move-result v1

    invoke-virtual {v9, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    move v1, v7

    move v2, v10

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_4
    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    move/from16 v19, v10

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_2
    move-wide v2, v1

    move v10, v4

    if-nez v6, :cond_5

    invoke-static {v12, v8, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    iget v1, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-virtual {v9, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    move v1, v7

    move v2, v10

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_5
    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    move/from16 v19, v10

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_3
    move-wide v2, v1

    if-ne v6, v10, :cond_6

    invoke-static {v12, v8, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zze([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    iget-object v1, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v9, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move v2, v4

    move v1, v7

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_6
    move/from16 v19, v4

    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_4
    move-wide v2, v1

    if-ne v6, v10, :cond_8

    nop

    invoke-direct {v15, v4}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v0

    invoke-static {v0, v12, v8, v13, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(Lcom/google/android/gms/internal/measurement/zzhd;[BIILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    invoke-virtual {v9, v14, v2, v3}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    if-nez v1, :cond_7

    iget-object v1, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v9, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    goto :goto_3

    :cond_7
    iget-object v5, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-static {v1, v5}, Lcom/google/android/gms/internal/measurement/zzff;->zza(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v9, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    nop

    :goto_3
    move v2, v4

    move v1, v7

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_8
    move/from16 v19, v4

    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_5
    move-wide v2, v1

    if-ne v6, v10, :cond_a

    const/high16 v0, 0x20000000

    and-int/2addr v0, v5

    if-nez v0, :cond_9

    invoke-static {v12, v8, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zzc([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    goto :goto_4

    :cond_9
    invoke-static {v12, v8, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zzd([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    :goto_4
    iget-object v1, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzc:Ljava/lang/Object;

    invoke-virtual {v9, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move v2, v4

    move v1, v7

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_a
    move/from16 v19, v4

    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_6
    move-wide v2, v1

    if-nez v6, :cond_c

    invoke-static {v12, v8, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v1

    iget-wide v5, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    const-wide/16 v19, 0x0

    cmp-long v5, v5, v19

    if-eqz v5, :cond_b

    goto :goto_5

    :cond_b
    move/from16 v0, v16

    :goto_5
    invoke-static {v14, v2, v3, v0}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JZ)V

    move v0, v1

    move v2, v4

    move v1, v7

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_c
    move/from16 v19, v4

    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_7
    move-wide v2, v1

    const/4 v0, 0x5

    if-ne v6, v0, :cond_d

    invoke-static {v12, v8}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BI)I

    move-result v0

    invoke-virtual {v9, v14, v2, v3, v0}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    add-int/lit8 v0, v8, 0x4

    move v2, v4

    move v1, v7

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_d
    move/from16 v19, v4

    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_8
    move-wide v2, v1

    if-ne v6, v0, :cond_e

    invoke-static {v12, v8}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BI)J

    move-result-wide v5

    move-object v0, v9

    move-object/from16 v1, p1

    move v10, v4

    move-wide v4, v5

    invoke-virtual/range {v0 .. v5}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    add-int/lit8 v0, v8, 0x8

    move v1, v7

    move v2, v10

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_e
    move v10, v4

    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    move/from16 v19, v10

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_9
    move-wide v2, v1

    move v10, v4

    if-nez v6, :cond_f

    invoke-static {v12, v8, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zza([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    iget v1, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zza:I

    invoke-virtual {v9, v14, v2, v3, v1}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    move v1, v7

    move v2, v10

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_f
    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    move/from16 v19, v10

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_a
    move-wide v2, v1

    move v10, v4

    if-nez v6, :cond_10

    invoke-static {v12, v8, v11}, Lcom/google/android/gms/internal/measurement/zzdq;->zzb([BILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v6

    iget-wide v4, v11, Lcom/google/android/gms/internal/measurement/zzdt;->zzb:J

    move-object v0, v9

    move-object/from16 v1, p1

    invoke-virtual/range {v0 .. v5}, Lsun/misc/Unsafe;->putLong(Ljava/lang/Object;JJ)V

    move v0, v6

    move v1, v7

    move v2, v10

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_10
    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    move/from16 v19, v10

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_b
    move-wide v2, v1

    move v10, v4

    const/4 v0, 0x5

    if-ne v6, v0, :cond_11

    invoke-static {v12, v8}, Lcom/google/android/gms/internal/measurement/zzdq;->zzd([BI)F

    move-result v0

    invoke-static {v14, v2, v3, v0}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JF)V

    add-int/lit8 v0, v8, 0x4

    move v1, v7

    move v2, v10

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_11
    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    move/from16 v19, v10

    const/16 v26, -0x1

    goto/16 :goto_8

    :pswitch_c
    move-wide v2, v1

    move v10, v4

    if-ne v6, v0, :cond_12

    invoke-static {v12, v8}, Lcom/google/android/gms/internal/measurement/zzdq;->zzc([BI)D

    move-result-wide v0

    invoke-static {v14, v2, v3, v0, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JD)V

    add-int/lit8 v0, v8, 0x8

    move v1, v7

    move v2, v10

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_12
    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    move/from16 v19, v10

    const/16 v26, -0x1

    goto/16 :goto_8

    :cond_13
    const/16 v0, 0x1b

    if-ne v3, v0, :cond_17

    if-ne v6, v10, :cond_16

    invoke-virtual {v9, v14, v1, v2}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/measurement/zzfl;

    invoke-interface {v0}, Lcom/google/android/gms/internal/measurement/zzfl;->zza()Z

    move-result v3

    if-nez v3, :cond_15

    invoke-interface {v0}, Lcom/google/android/gms/internal/measurement/zzfl;->size()I

    move-result v3

    nop

    if-nez v3, :cond_14

    const/16 v3, 0xa

    goto :goto_6

    :cond_14
    shl-int/lit8 v3, v3, 0x1

    :goto_6
    invoke-interface {v0, v3}, Lcom/google/android/gms/internal/measurement/zzfl;->zza(I)Lcom/google/android/gms/internal/measurement/zzfl;

    move-result-object v0

    invoke-virtual {v9, v14, v1, v2, v0}, Lsun/misc/Unsafe;->putObject(Ljava/lang/Object;JLjava/lang/Object;)V

    move-object v5, v0

    goto :goto_7

    :cond_15
    move-object v5, v0

    :goto_7
    nop

    invoke-direct {v15, v4}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v0

    move/from16 v1, v17

    move-object/from16 v2, p2

    move v3, v8

    move/from16 v19, v4

    move/from16 v4, p4

    move-object/from16 v6, p5

    invoke-static/range {v0 .. v6}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(Lcom/google/android/gms/internal/measurement/zzhd;I[BIILcom/google/android/gms/internal/measurement/zzfl;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    move v1, v7

    move/from16 v2, v19

    const/4 v10, -0x1

    goto/16 :goto_0

    :cond_16
    move/from16 v19, v4

    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    const/16 v26, -0x1

    goto/16 :goto_8

    :cond_17
    move/from16 v19, v4

    const/16 v0, 0x31

    if-gt v3, v0, :cond_19

    nop

    int-to-long v4, v5

    move-object/from16 v0, p0

    move-wide/from16 v20, v1

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move v10, v3

    move v3, v8

    move-wide/from16 v22, v4

    move/from16 v4, p4

    move/from16 v5, v17

    move/from16 p3, v6

    move v6, v7

    move/from16 v24, v7

    move/from16 v7, p3

    move v15, v8

    move/from16 v8, v19

    move-object/from16 v18, v9

    move/from16 v25, v10

    const/16 v26, -0x1

    move-wide/from16 v9, v22

    move/from16 v11, v25

    move-wide/from16 v12, v20

    move-object/from16 v14, p5

    invoke-direct/range {v0 .. v14}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;[BIIIIIIJIJLcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    if-ne v0, v15, :cond_18

    move v2, v0

    goto/16 :goto_9

    :cond_18
    move-object/from16 v15, p0

    move-object/from16 v14, p1

    move-object/from16 v12, p2

    move/from16 v13, p4

    move-object/from16 v11, p5

    move-object/from16 v9, v18

    move/from16 v2, v19

    move/from16 v1, v24

    move/from16 v10, v26

    goto/16 :goto_0

    :cond_19
    move-wide/from16 v20, v1

    move/from16 v25, v3

    move/from16 p3, v6

    move/from16 v24, v7

    move v15, v8

    move-object/from16 v18, v9

    const/16 v26, -0x1

    const/16 v0, 0x32

    move/from16 v9, v25

    if-ne v9, v0, :cond_1c

    move/from16 v7, p3

    if-ne v7, v10, :cond_1b

    nop

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move v3, v15

    move/from16 v4, p4

    move/from16 v5, v19

    move-wide/from16 v6, v20

    move-object/from16 v8, p5

    invoke-direct/range {v0 .. v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;[BIIIJLcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    if-ne v0, v15, :cond_1a

    move v2, v0

    goto :goto_9

    :cond_1a
    move-object/from16 v15, p0

    move-object/from16 v14, p1

    move-object/from16 v12, p2

    move/from16 v13, p4

    move-object/from16 v11, p5

    move-object/from16 v9, v18

    move/from16 v2, v19

    move/from16 v1, v24

    move/from16 v10, v26

    goto/16 :goto_0

    :cond_1b
    :goto_8
    move v2, v15

    goto :goto_9

    :cond_1c
    move/from16 v7, p3

    nop

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move v3, v15

    move/from16 v4, p4

    move v8, v5

    move/from16 v5, v17

    move/from16 v6, v24

    move-wide/from16 v10, v20

    move/from16 v12, v19

    move-object/from16 v13, p5

    invoke-direct/range {v0 .. v13}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;[BIIIIIIIJILcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    if-ne v0, v15, :cond_1d

    move v2, v0

    :goto_9
    nop

    invoke-static/range {p1 .. p1}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzhy;

    move-result-object v4

    move/from16 v0, v17

    move-object/from16 v1, p2

    move/from16 v3, p4

    move-object/from16 v5, p5

    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/measurement/zzdq;->zza(I[BIILcom/google/android/gms/internal/measurement/zzhy;Lcom/google/android/gms/internal/measurement/zzdt;)I

    move-result v0

    move-object/from16 v15, p0

    move-object/from16 v14, p1

    move-object/from16 v12, p2

    move/from16 v13, p4

    move-object/from16 v11, p5

    move-object/from16 v9, v18

    move/from16 v2, v19

    move/from16 v1, v24

    move/from16 v10, v26

    goto/16 :goto_0

    :cond_1d
    move-object/from16 v15, p0

    move-object/from16 v14, p1

    move-object/from16 v12, p2

    move/from16 v13, p4

    move-object/from16 v11, p5

    move-object/from16 v9, v18

    move/from16 v2, v19

    move/from16 v1, v24

    move/from16 v10, v26

    goto/16 :goto_0

    :cond_1e
    move/from16 v4, p4

    if-ne v0, v4, :cond_1f

    return-void

    :cond_1f
    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzfo;->zzg()Lcom/google/android/gms/internal/measurement/zzfo;

    move-result-object v0

    throw v0

    :cond_20
    move v4, v13

    const/4 v5, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move/from16 v3, p3

    move/from16 v4, p4

    move-object/from16 v6, p5

    invoke-virtual/range {v0 .. v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;[BIIILcom/google/android/gms/internal/measurement/zzdt;)I

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_9
        :pswitch_2
        :pswitch_7
        :pswitch_8
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final zza(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TT;)Z"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    array-length v0, v0

    const/4 v1, 0x0

    move v2, v1

    :goto_0
    const/4 v3, 0x1

    if-ge v2, v0, :cond_15

    nop

    invoke-direct {p0, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v4

    nop

    const v5, 0xfffff

    and-int v6, v4, v5

    int-to-long v6, v6

    nop

    nop

    const/high16 v8, 0xff00000

    and-int/2addr v4, v8

    ushr-int/lit8 v4, v4, 0x14

    packed-switch v4, :pswitch_data_0

    goto/16 :goto_1

    :pswitch_0
    nop

    invoke-direct {p0, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(I)I

    move-result v4

    and-int/2addr v4, v5

    int-to-long v4, v4

    invoke-static {p1, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v8

    invoke-static {p2, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v4

    if-ne v8, v4, :cond_0

    nop

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_13

    :cond_0
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_1
    nop

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    goto/16 :goto_2

    :pswitch_2
    nop

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    goto/16 :goto_2

    :pswitch_3
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_13

    :cond_1
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_4
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-eqz v4, :cond_13

    :cond_2
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_5
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v5

    if-eq v4, v5, :cond_13

    :cond_3
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_6
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-eqz v4, :cond_13

    :cond_4
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_7
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_5

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v5

    if-eq v4, v5, :cond_13

    :cond_5
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_8
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_6

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v5

    if-eq v4, v5, :cond_13

    :cond_6
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_9
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_7

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v5

    if-eq v4, v5, :cond_13

    :cond_7
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_a
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_8

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_13

    :cond_8
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_b
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_9

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_13

    :cond_9
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_c
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_a

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_13

    :cond_a
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_d
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_b

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzc(Ljava/lang/Object;J)Z

    move-result v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzc(Ljava/lang/Object;J)Z

    move-result v5

    if-eq v4, v5, :cond_13

    :cond_b
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_e
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_c

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v5

    if-eq v4, v5, :cond_13

    :cond_c
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_f
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_d

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-eqz v4, :cond_13

    :cond_d
    nop

    move v3, v1

    goto/16 :goto_2

    :pswitch_10
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_e

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v5

    if-eq v4, v5, :cond_13

    :cond_e
    nop

    move v3, v1

    goto :goto_2

    :pswitch_11
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_f

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-eqz v4, :cond_13

    :cond_f
    nop

    move v3, v1

    goto :goto_2

    :pswitch_12
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_10

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-eqz v4, :cond_13

    :cond_10
    nop

    move v3, v1

    goto :goto_2

    :pswitch_13
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_11

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzd(Ljava/lang/Object;J)F

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzd(Ljava/lang/Object;J)F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v5

    if-eq v4, v5, :cond_13

    :cond_11
    nop

    move v3, v1

    goto :goto_2

    :pswitch_14
    invoke-direct {p0, p1, p2, v2}, Lcom/google/android/gms/internal/measurement/zzgs;->zzc(Ljava/lang/Object;Ljava/lang/Object;I)Z

    move-result v4

    if-eqz v4, :cond_12

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zze(Ljava/lang/Object;J)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v4

    invoke-static {p2, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zze(Ljava/lang/Object;J)D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-eqz v4, :cond_13

    :cond_12
    nop

    move v3, v1

    goto :goto_2

    :cond_13
    :goto_1
    nop

    :goto_2
    if-nez v3, :cond_14

    return v1

    :cond_14
    add-int/lit8 v2, v2, 0x3

    goto/16 :goto_0

    :cond_15
    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/measurement/zzhv;->zzb(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-virtual {v2, p2}, Lcom/google/android/gms/internal/measurement/zzhv;->zzb(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_16

    return v1

    :cond_16
    iget-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    if-eqz v0, :cond_17

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzew;

    move-result-object p1

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v0, p2}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzew;

    move-result-object p2

    invoke-virtual {p1, p2}, Lcom/google/android/gms/internal/measurement/zzew;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1

    :cond_17
    return v3

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public final zzb(Ljava/lang/Object;)I
    .locals 19
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)I"
        }
    .end annotation

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    iget-boolean v2, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzj:Z

    const/high16 v3, 0xff00000

    const/4 v4, 0x0

    const v7, 0xfffff

    const/4 v8, 0x1

    const-wide/16 v9, 0x0

    const/4 v11, 0x0

    if-eqz v2, :cond_13

    sget-object v2, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    nop

    move v12, v11

    move v13, v12

    :goto_0
    iget-object v14, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    array-length v14, v14

    if-ge v12, v14, :cond_12

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v14

    nop

    and-int v15, v14, v3

    ushr-int/lit8 v15, v15, 0x14

    nop

    nop

    iget-object v3, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v3, v3, v12

    nop

    nop

    and-int/2addr v14, v7

    int-to-long v5, v14

    nop

    sget-object v14, Lcom/google/android/gms/internal/measurement/zzex;->zza:Lcom/google/android/gms/internal/measurement/zzex;

    invoke-virtual {v14}, Lcom/google/android/gms/internal/measurement/zzex;->zza()I

    move-result v14

    if-lt v15, v14, :cond_0

    sget-object v14, Lcom/google/android/gms/internal/measurement/zzex;->zzb:Lcom/google/android/gms/internal/measurement/zzex;

    invoke-virtual {v14}, Lcom/google/android/gms/internal/measurement/zzex;->zza()I

    move-result v14

    if-gt v15, v14, :cond_0

    iget-object v14, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    add-int/lit8 v17, v12, 0x2

    aget v14, v14, v17

    and-int/2addr v14, v7

    goto :goto_1

    :cond_0
    move v14, v11

    :goto_1
    packed-switch v15, :pswitch_data_0

    goto/16 :goto_2

    :pswitch_0
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v14

    if-eqz v14, :cond_11

    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/measurement/zzgo;

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v6

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzgo;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_1
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v5

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzen;->zzf(IJ)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_2
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v5

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzh(II)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_3
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v9, v10}, Lcom/google/android/gms/internal/measurement/zzen;->zzh(IJ)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_4
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v11}, Lcom/google/android/gms/internal/measurement/zzen;->zzj(II)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_5
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v5

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzk(II)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_6
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v5

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(II)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_7
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v14

    if-eqz v14, :cond_11

    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzdu;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_8
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v6

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_9
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    instance-of v6, v5, Lcom/google/android/gms/internal/measurement/zzdu;

    if-eqz v6, :cond_1

    check-cast v5, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzdu;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :cond_1
    check-cast v5, Ljava/lang/String;

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(ILjava/lang/String;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_a
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v8}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(IZ)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_b
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v11}, Lcom/google/android/gms/internal/measurement/zzen;->zzi(II)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_c
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v9, v10}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(IJ)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_d
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v5

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzf(II)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_e
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v5

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzen;->zze(IJ)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_f
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v5

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzen;->zzd(IJ)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_10
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(IF)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_11
    invoke-direct {v0, v1, v3, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v5

    if-eqz v5, :cond_11

    const-wide/16 v5, 0x0

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(ID)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_12
    iget-object v14, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(I)Ljava/lang/Object;

    move-result-object v6

    invoke-interface {v14, v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgh;->zza(ILjava/lang/Object;Ljava/lang/Object;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_13
    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v6

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_14
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzc(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_2

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_2
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_15
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzg(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_3

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_3
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_16
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_4

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_4
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_17
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_5

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_5
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_18
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzd(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_6

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_6
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_19
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzf(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_7

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_7
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_1a
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzj(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_8

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_8
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_1b
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_9

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_9
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_1c
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_a

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_a
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_1d
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zze(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_b

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_b
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_1e
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_c

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_c
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_1f
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_d

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_d
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_20
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_e

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_e
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_21
    nop

    invoke-virtual {v2, v1, v5, v6}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(Ljava/util/List;)I

    move-result v5

    if-lez v5, :cond_11

    iget-boolean v6, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v6, :cond_f

    int-to-long v14, v14

    invoke-virtual {v2, v1, v14, v15, v5}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_f
    nop

    invoke-static {v3}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v3

    invoke-static {v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v6

    add-int/2addr v3, v6

    add-int/2addr v3, v5

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_22
    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzc(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_23
    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzg(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_24
    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_25
    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_26
    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzd(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_27
    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzf(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_28
    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_29
    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v6

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_2a
    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_2b
    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzj(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_2c
    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_2d
    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_2e
    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zze(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_2f
    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_30
    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_31
    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_32
    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;J)Ljava/util/List;

    move-result-object v5

    invoke-static {v3, v5, v11}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Z)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_33
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v14

    if-eqz v14, :cond_11

    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/measurement/zzgo;

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v6

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzgo;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_34
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v14

    if-eqz v14, :cond_11

    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v5

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzen;->zzf(IJ)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_35
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v5

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzh(II)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_36
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v9, v10}, Lcom/google/android/gms/internal/measurement/zzen;->zzh(IJ)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_37
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v11}, Lcom/google/android/gms/internal/measurement/zzen;->zzj(II)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_38
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v5

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzk(II)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_39
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v5

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(II)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_3a
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzdu;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_3b
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v6

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_3c
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v5

    instance-of v6, v5, Lcom/google/android/gms/internal/measurement/zzdu;

    if-eqz v6, :cond_10

    check-cast v5, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzdu;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :cond_10
    check-cast v5, Ljava/lang/String;

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(ILjava/lang/String;)I

    move-result v3

    add-int/2addr v13, v3

    goto/16 :goto_2

    :pswitch_3d
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v8}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(IZ)I

    move-result v3

    add-int/2addr v13, v3

    goto :goto_2

    :pswitch_3e
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v11}, Lcom/google/android/gms/internal/measurement/zzen;->zzi(II)I

    move-result v3

    add-int/2addr v13, v3

    goto :goto_2

    :pswitch_3f
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v9, v10}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(IJ)I

    move-result v3

    add-int/2addr v13, v3

    goto :goto_2

    :pswitch_40
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v5

    invoke-static {v3, v5}, Lcom/google/android/gms/internal/measurement/zzen;->zzf(II)I

    move-result v3

    add-int/2addr v13, v3

    goto :goto_2

    :pswitch_41
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v14

    if-eqz v14, :cond_11

    nop

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v5

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzen;->zze(IJ)I

    move-result v3

    add-int/2addr v13, v3

    goto :goto_2

    :pswitch_42
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v14

    if-eqz v14, :cond_11

    invoke-static {v1, v5, v6}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v5

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzen;->zzd(IJ)I

    move-result v3

    add-int/2addr v13, v3

    goto :goto_2

    :pswitch_43
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v5

    if-eqz v5, :cond_11

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(IF)I

    move-result v3

    add-int/2addr v13, v3

    goto :goto_2

    :pswitch_44
    invoke-direct {v0, v1, v12}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v5

    if-eqz v5, :cond_11

    const-wide/16 v5, 0x0

    invoke-static {v3, v5, v6}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(ID)I

    move-result v3

    add-int/2addr v13, v3

    :cond_11
    :goto_2
    add-int/lit8 v12, v12, 0x3

    const/high16 v3, 0xff00000

    goto/16 :goto_0

    :cond_12
    iget-object v2, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-static {v2, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Lcom/google/android/gms/internal/measurement/zzhv;Ljava/lang/Object;)I

    move-result v1

    add-int/2addr v13, v1

    return v13

    :cond_13
    nop

    sget-object v2, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    const/4 v3, -0x1

    nop

    move v5, v11

    move v6, v5

    move v12, v6

    :goto_3
    iget-object v13, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    array-length v13, v13

    if-ge v5, v13, :cond_59

    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v13

    nop

    iget-object v14, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v15, v14, v5

    nop

    nop

    const/high16 v16, 0xff00000

    and-int v17, v13, v16

    ushr-int/lit8 v4, v17, 0x14

    nop

    nop

    nop

    const/16 v11, 0x11

    if-gt v4, v11, :cond_15

    add-int/lit8 v11, v5, 0x2

    aget v11, v14, v11

    and-int v14, v11, v7

    ushr-int/lit8 v18, v11, 0x14

    shl-int v18, v8, v18

    if-eq v14, v3, :cond_14

    nop

    int-to-long v8, v14

    invoke-virtual {v2, v1, v8, v9}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v12

    move v3, v14

    :cond_14
    move v8, v11

    goto :goto_4

    :cond_15
    iget-boolean v8, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v8, :cond_16

    sget-object v8, Lcom/google/android/gms/internal/measurement/zzex;->zza:Lcom/google/android/gms/internal/measurement/zzex;

    invoke-virtual {v8}, Lcom/google/android/gms/internal/measurement/zzex;->zza()I

    move-result v8

    if-lt v4, v8, :cond_16

    sget-object v8, Lcom/google/android/gms/internal/measurement/zzex;->zzb:Lcom/google/android/gms/internal/measurement/zzex;

    invoke-virtual {v8}, Lcom/google/android/gms/internal/measurement/zzex;->zza()I

    move-result v8

    if-gt v4, v8, :cond_16

    iget-object v8, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    add-int/lit8 v9, v5, 0x2

    aget v8, v8, v9

    and-int/2addr v8, v7

    const/16 v18, 0x0

    goto :goto_4

    :cond_16
    const/4 v8, 0x0

    const/16 v18, 0x0

    :goto_4
    nop

    and-int v9, v13, v7

    int-to-long v9, v9

    nop

    packed-switch v4, :pswitch_data_1

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_45
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_17

    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/measurement/zzgo;

    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v8

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzgo;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_17
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_46
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_18

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v8

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/measurement/zzen;->zzf(IJ)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_18
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_47
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_19

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzh(II)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_19
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_48
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_1a

    const-wide/16 v8, 0x0

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/measurement/zzen;->zzh(IJ)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_1a
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_49
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_1b

    const/4 v4, 0x0

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzj(II)I

    move-result v8

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_1b
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_4a
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_1c

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzk(II)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_1c
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_4b
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_1d

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(II)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_1d
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_4c
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_1e

    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzdu;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_1e
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_4d
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_1f

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v8

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_1f
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_4e
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_21

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    instance-of v8, v4, Lcom/google/android/gms/internal/measurement/zzdu;

    if-eqz v8, :cond_20

    check-cast v4, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzdu;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_20
    check-cast v4, Ljava/lang/String;

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(ILjava/lang/String;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_21
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_4f
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_22

    const/4 v4, 0x1

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(IZ)I

    move-result v8

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_22
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_50
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_23

    const/4 v4, 0x0

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzi(II)I

    move-result v8

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_23
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_51
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_24

    const-wide/16 v8, 0x0

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(IJ)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_24
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_52
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_25

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzf(II)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_25
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_53
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_26

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v8

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/measurement/zzen;->zze(IJ)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_26
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_54
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_27

    invoke-static {v1, v9, v10}, Lcom/google/android/gms/internal/measurement/zzgs;->zze(Ljava/lang/Object;J)J

    move-result-wide v8

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/measurement/zzen;->zzd(IJ)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_27
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_55
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_28

    const/4 v4, 0x0

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(IF)I

    move-result v8

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_28
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_56
    invoke-direct {v0, v1, v15, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v4

    if-eqz v4, :cond_29

    const-wide/16 v8, 0x0

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(ID)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_29
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_57
    iget-object v4, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v8

    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(I)Ljava/lang/Object;

    move-result-object v9

    invoke-interface {v4, v15, v8, v9}, Lcom/google/android/gms/internal/measurement/zzgh;->zza(ILjava/lang/Object;Ljava/lang/Object;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_58
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v8

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_59
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzc(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_2b

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_2a

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_2a
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_2b
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_5a
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzg(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_2d

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_2c

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_2c
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_2d
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_5b
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_2f

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_2e

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_2e
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_2f
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_5c
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_31

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_30

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_30
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_31
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_5d
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzd(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_33

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_32

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_32
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_33
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_5e
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzf(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_35

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_34

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_34
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_35
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_5f
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzj(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_37

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_36

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_36
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_37
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_60
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_39

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_38

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_38
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_39
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_61
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_3b

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_3a

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_3a
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_3b
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_62
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zze(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_3d

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_3c

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_3c
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_3d
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_63
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_3f

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_3e

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_3e
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_3f
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_64
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_41

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_40

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_40
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_41
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_65
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_43

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_42

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_42
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_43
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_66
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(Ljava/util/List;)I

    move-result v4

    if-lez v4, :cond_45

    iget-boolean v9, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzk:Z

    if-eqz v9, :cond_44

    int-to-long v8, v8

    invoke-virtual {v2, v1, v8, v9, v4}, Lsun/misc/Unsafe;->putInt(Ljava/lang/Object;JI)V

    :cond_44
    nop

    invoke-static {v15}, Lcom/google/android/gms/internal/measurement/zzen;->zze(I)I

    move-result v8

    invoke-static {v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(I)I

    move-result v9

    add-int/2addr v8, v9

    add-int/2addr v8, v4

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_45
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_67
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    const/4 v8, 0x0

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzc(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_68
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzg(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_69
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_6a
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_6b
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzd(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_6c
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzf(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_6d
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_6e
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v8

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_6f
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_70
    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    const/4 v8, 0x0

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzj(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_71
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_72
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_73
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zze(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_74
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzb(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_75
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_76
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzh(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_77
    const/4 v8, 0x0

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zzi(ILjava/util/List;Z)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_78
    and-int v4, v12, v18

    if-eqz v4, :cond_46

    nop

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/measurement/zzgo;

    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v8

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzgo;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_46
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_79
    and-int v4, v12, v18

    if-eqz v4, :cond_47

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v8

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/measurement/zzen;->zzf(IJ)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_47
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_7a
    and-int v4, v12, v18

    if-eqz v4, :cond_48

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzh(II)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_48
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_7b
    and-int v4, v12, v18

    if-eqz v4, :cond_49

    const-wide/16 v8, 0x0

    invoke-static {v15, v8, v9}, Lcom/google/android/gms/internal/measurement/zzen;->zzh(IJ)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_49
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_7c
    and-int v4, v12, v18

    if-eqz v4, :cond_4a

    const/4 v4, 0x0

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzj(II)I

    move-result v8

    add-int/2addr v6, v8

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_4a
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_7d
    and-int v4, v12, v18

    if-eqz v4, :cond_4b

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzk(II)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_4b
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_7e
    and-int v4, v12, v18

    if-eqz v4, :cond_4c

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v4

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(II)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_4c
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_7f
    and-int v4, v12, v18

    if-eqz v4, :cond_4d

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzdu;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_4d
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_80
    and-int v4, v12, v18

    if-eqz v4, :cond_4e

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v8

    invoke-static {v15, v4, v8}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(ILjava/lang/Object;Lcom/google/android/gms/internal/measurement/zzhd;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_4e
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_81
    and-int v4, v12, v18

    if-eqz v4, :cond_50

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getObject(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v4

    instance-of v8, v4, Lcom/google/android/gms/internal/measurement/zzdu;

    if-eqz v8, :cond_4f

    check-cast v4, Lcom/google/android/gms/internal/measurement/zzdu;

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzc(ILcom/google/android/gms/internal/measurement/zzdu;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_4f
    check-cast v4, Ljava/lang/String;

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(ILjava/lang/String;)I

    move-result v4

    add-int/2addr v6, v4

    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_50
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_82
    and-int v4, v12, v18

    if-eqz v4, :cond_51

    const/4 v4, 0x1

    invoke-static {v15, v4}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(IZ)I

    move-result v8

    add-int/2addr v6, v8

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_51
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_83
    const/4 v4, 0x1

    and-int v8, v12, v18

    if-eqz v8, :cond_52

    const/4 v8, 0x0

    invoke-static {v15, v8}, Lcom/google/android/gms/internal/measurement/zzen;->zzi(II)I

    move-result v9

    add-int/2addr v6, v9

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :cond_52
    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v13, 0x0

    goto/16 :goto_5

    :pswitch_84
    const/4 v4, 0x1

    const/4 v8, 0x0

    and-int v9, v12, v18

    if-eqz v9, :cond_53

    const-wide/16 v13, 0x0

    invoke-static {v15, v13, v14}, Lcom/google/android/gms/internal/measurement/zzen;->zzg(IJ)I

    move-result v9

    add-int/2addr v6, v9

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    goto/16 :goto_5

    :cond_53
    const-wide/16 v13, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    goto/16 :goto_5

    :pswitch_85
    const/4 v4, 0x1

    const/4 v8, 0x0

    const-wide/16 v13, 0x0

    and-int v11, v12, v18

    if-eqz v11, :cond_54

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v9

    invoke-static {v15, v9}, Lcom/google/android/gms/internal/measurement/zzen;->zzf(II)I

    move-result v9

    add-int/2addr v6, v9

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    goto :goto_5

    :cond_54
    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    goto :goto_5

    :pswitch_86
    const/4 v4, 0x1

    const/4 v8, 0x0

    const-wide/16 v13, 0x0

    and-int v11, v12, v18

    if-eqz v11, :cond_55

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-static {v15, v9, v10}, Lcom/google/android/gms/internal/measurement/zzen;->zze(IJ)I

    move-result v9

    add-int/2addr v6, v9

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    goto :goto_5

    :cond_55
    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    goto :goto_5

    :pswitch_87
    const/4 v4, 0x1

    const/4 v8, 0x0

    const-wide/16 v13, 0x0

    and-int v11, v12, v18

    if-eqz v11, :cond_56

    invoke-virtual {v2, v1, v9, v10}, Lsun/misc/Unsafe;->getLong(Ljava/lang/Object;J)J

    move-result-wide v9

    invoke-static {v15, v9, v10}, Lcom/google/android/gms/internal/measurement/zzen;->zzd(IJ)I

    move-result v9

    add-int/2addr v6, v9

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    goto :goto_5

    :cond_56
    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    goto :goto_5

    :pswitch_88
    const/4 v4, 0x1

    const/4 v8, 0x0

    const-wide/16 v13, 0x0

    and-int v9, v12, v18

    if-eqz v9, :cond_57

    const/4 v9, 0x0

    invoke-static {v15, v9}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(IF)I

    move-result v10

    add-int/2addr v6, v10

    const-wide/16 v10, 0x0

    goto :goto_5

    :cond_57
    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    goto :goto_5

    :pswitch_89
    const/4 v4, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v13, 0x0

    and-int v10, v12, v18

    if-eqz v10, :cond_58

    const-wide/16 v10, 0x0

    invoke-static {v15, v10, v11}, Lcom/google/android/gms/internal/measurement/zzen;->zzb(ID)I

    move-result v15

    add-int/2addr v6, v15

    goto :goto_5

    :cond_58
    const-wide/16 v10, 0x0

    :goto_5
    add-int/lit8 v5, v5, 0x3

    move v11, v8

    move v8, v4

    move v4, v9

    move-wide v9, v13

    goto/16 :goto_3

    :cond_59
    move v8, v11

    iget-object v2, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-static {v2, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Lcom/google/android/gms/internal/measurement/zzhv;Ljava/lang/Object;)I

    move-result v2

    add-int/2addr v6, v2

    iget-boolean v2, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    if-eqz v2, :cond_5c

    iget-object v2, v0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v2, v1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzew;

    move-result-object v1

    nop

    move v11, v8

    :goto_6
    iget-object v2, v1, Lcom/google/android/gms/internal/measurement/zzew;->zza:Lcom/google/android/gms/internal/measurement/zzhi;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/measurement/zzhi;->zzc()I

    move-result v2

    if-ge v11, v2, :cond_5a

    iget-object v2, v1, Lcom/google/android/gms/internal/measurement/zzew;->zza:Lcom/google/android/gms/internal/measurement/zzhi;

    invoke-virtual {v2, v11}, Lcom/google/android/gms/internal/measurement/zzhi;->zzb(I)Ljava/util/Map$Entry;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/measurement/zzey;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/google/android/gms/internal/measurement/zzew;->zza(Lcom/google/android/gms/internal/measurement/zzey;Ljava/lang/Object;)I

    move-result v2

    add-int/2addr v8, v2

    add-int/lit8 v11, v11, 0x1

    goto :goto_6

    :cond_5a
    iget-object v1, v1, Lcom/google/android/gms/internal/measurement/zzew;->zza:Lcom/google/android/gms/internal/measurement/zzhi;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/measurement/zzhi;->zzd()Ljava/lang/Iterable;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_7
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_5b

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/measurement/zzey;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/google/android/gms/internal/measurement/zzew;->zza(Lcom/google/android/gms/internal/measurement/zzey;Ljava/lang/Object;)I

    move-result v2

    add-int/2addr v8, v2

    goto :goto_7

    :cond_5b
    nop

    add-int/2addr v6, v8

    :cond_5c
    nop

    return v6

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_44
        :pswitch_43
        :pswitch_42
        :pswitch_41
        :pswitch_40
        :pswitch_3f
        :pswitch_3e
        :pswitch_3d
        :pswitch_3c
        :pswitch_3b
        :pswitch_3a
        :pswitch_39
        :pswitch_38
        :pswitch_37
        :pswitch_36
        :pswitch_35
        :pswitch_34
        :pswitch_33
        :pswitch_32
        :pswitch_31
        :pswitch_30
        :pswitch_2f
        :pswitch_2e
        :pswitch_2d
        :pswitch_2c
        :pswitch_2b
        :pswitch_2a
        :pswitch_29
        :pswitch_28
        :pswitch_27
        :pswitch_26
        :pswitch_25
        :pswitch_24
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_1d
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_89
        :pswitch_88
        :pswitch_87
        :pswitch_86
        :pswitch_85
        :pswitch_84
        :pswitch_83
        :pswitch_82
        :pswitch_81
        :pswitch_80
        :pswitch_7f
        :pswitch_7e
        :pswitch_7d
        :pswitch_7c
        :pswitch_7b
        :pswitch_7a
        :pswitch_79
        :pswitch_78
        :pswitch_77
        :pswitch_76
        :pswitch_75
        :pswitch_74
        :pswitch_73
        :pswitch_72
        :pswitch_71
        :pswitch_70
        :pswitch_6f
        :pswitch_6e
        :pswitch_6d
        :pswitch_6c
        :pswitch_6b
        :pswitch_6a
        :pswitch_69
        :pswitch_68
        :pswitch_67
        :pswitch_66
        :pswitch_65
        :pswitch_64
        :pswitch_63
        :pswitch_62
        :pswitch_61
        :pswitch_60
        :pswitch_5f
        :pswitch_5e
        :pswitch_5d
        :pswitch_5c
        :pswitch_5b
        :pswitch_5a
        :pswitch_59
        :pswitch_58
        :pswitch_57
        :pswitch_56
        :pswitch_55
        :pswitch_54
        :pswitch_53
        :pswitch_52
        :pswitch_51
        :pswitch_50
        :pswitch_4f
        :pswitch_4e
        :pswitch_4d
        :pswitch_4c
        :pswitch_4b
        :pswitch_4a
        :pswitch_49
        :pswitch_48
        :pswitch_47
        :pswitch_46
        :pswitch_45
    .end packed-switch
.end method

.method public final zzb(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TT;)V"
        }
    .end annotation

    if-eqz p2, :cond_3

    const/4 v0, 0x0

    :goto_0
    iget-object v1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    array-length v1, v1

    if-ge v0, v1, :cond_1

    nop

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v1

    nop

    const v2, 0xfffff

    and-int/2addr v2, v1

    int-to-long v2, v2

    nop

    nop

    iget-object v4, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v4, v4, v0

    nop

    nop

    const/high16 v5, 0xff00000

    and-int/2addr v1, v5

    ushr-int/lit8 v1, v1, 0x14

    packed-switch v1, :pswitch_data_0

    goto/16 :goto_1

    :pswitch_0
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_1
    invoke-direct {p0, p2, v4, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v4, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_1

    :pswitch_2
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_3
    invoke-direct {p0, p2, v4, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v4, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;II)V

    goto/16 :goto_1

    :pswitch_4
    iget-object v1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-static {v1, p1, p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Lcom/google/android/gms/internal/measurement/zzgh;Ljava/lang/Object;Ljava/lang/Object;J)V

    goto/16 :goto_1

    :pswitch_5
    iget-object v1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    invoke-virtual {v1, p1, p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzfy;->zza(Ljava/lang/Object;Ljava/lang/Object;J)V

    goto/16 :goto_1

    :pswitch_6
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_7
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p1, v2, v3, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JJ)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_8
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_9
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p1, v2, v3, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JJ)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_a
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_b
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_c
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_d
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_e
    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_f
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_10
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzc(Ljava/lang/Object;J)Z

    move-result v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JZ)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto/16 :goto_1

    :pswitch_11
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto :goto_1

    :pswitch_12
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p1, v2, v3, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JJ)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto :goto_1

    :pswitch_13
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;J)I

    move-result v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JI)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto :goto_1

    :pswitch_14
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p1, v2, v3, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JJ)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto :goto_1

    :pswitch_15
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzb(Ljava/lang/Object;J)J

    move-result-wide v4

    invoke-static {p1, v2, v3, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JJ)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto :goto_1

    :pswitch_16
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zzd(Ljava/lang/Object;J)F

    move-result v1

    invoke-static {p1, v2, v3, v1}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JF)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    goto :goto_1

    :pswitch_17
    invoke-direct {p0, p2, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;I)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zze(Ljava/lang/Object;J)D

    move-result-wide v4

    invoke-static {p1, v2, v3, v4, v5}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JD)V

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(Ljava/lang/Object;I)V

    :cond_0
    :goto_1
    add-int/lit8 v0, v0, 0x3

    goto/16 :goto_0

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-static {v0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Lcom/google/android/gms/internal/measurement/zzhv;Ljava/lang/Object;Ljava/lang/Object;)V

    iget-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-static {v0, p1, p2}, Lcom/google/android/gms/internal/measurement/zzhf;->zza(Lcom/google/android/gms/internal/measurement/zzes;Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_2
    return-void

    :cond_3
    const/4 p1, 0x0

    throw p1

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final zzc(Ljava/lang/Object;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzm:I

    :goto_0
    iget v1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzn:I

    if-ge v0, v1, :cond_1

    iget-object v1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzl:[I

    aget v1, v1, v0

    invoke-direct {p0, v1}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v1

    const v2, 0xfffff

    and-int/2addr v1, v2

    int-to-long v1, v1

    nop

    invoke-static {p1, v1, v2}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v4, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v4, v3}, Lcom/google/android/gms/internal/measurement/zzgh;->zzd(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-static {p1, v1, v2, v3}, Lcom/google/android/gms/internal/measurement/zzib;->zza(Ljava/lang/Object;JLjava/lang/Object;)V

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzl:[I

    array-length v0, v0

    nop

    :goto_1
    if-ge v1, v0, :cond_2

    iget-object v2, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzp:Lcom/google/android/gms/internal/measurement/zzfy;

    iget-object v3, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzl:[I

    aget v3, v3, v1

    int-to-long v3, v3

    invoke-virtual {v2, p1, v3, v4}, Lcom/google/android/gms/internal/measurement/zzfy;->zzb(Ljava/lang/Object;J)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_2
    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzq:Lcom/google/android/gms/internal/measurement/zzhv;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/measurement/zzhv;->zzd(Ljava/lang/Object;)V

    iget-boolean v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/internal/measurement/zzes;->zzc(Ljava/lang/Object;)V

    :cond_3
    return-void
.end method

.method public final zzd(Ljava/lang/Object;)Z
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    nop

    nop

    const/4 v0, 0x0

    const/4 v1, -0x1

    move v2, v0

    move v3, v2

    :goto_0
    iget v4, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzm:I

    const/4 v5, 0x1

    if-ge v2, v4, :cond_e

    iget-object v4, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzl:[I

    aget v4, v4, v2

    nop

    iget-object v6, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    aget v6, v6, v4

    nop

    invoke-direct {p0, v4}, Lcom/google/android/gms/internal/measurement/zzgs;->zzd(I)I

    move-result v7

    nop

    iget-boolean v8, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzj:Z

    const v9, 0xfffff

    if-nez v8, :cond_0

    iget-object v8, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzc:[I

    add-int/lit8 v10, v4, 0x2

    aget v8, v8, v10

    and-int v10, v8, v9

    ushr-int/lit8 v8, v8, 0x14

    shl-int v8, v5, v8

    if-eq v10, v1, :cond_1

    nop

    sget-object v1, Lcom/google/android/gms/internal/measurement/zzgs;->zzb:Lsun/misc/Unsafe;

    int-to-long v11, v10

    invoke-virtual {v1, p1, v11, v12}, Lsun/misc/Unsafe;->getInt(Ljava/lang/Object;J)I

    move-result v3

    move v1, v10

    goto :goto_1

    :cond_0
    move v8, v0

    :cond_1
    :goto_1
    nop

    const/high16 v10, 0x10000000

    and-int/2addr v10, v7

    if-eqz v10, :cond_2

    move v10, v5

    goto :goto_2

    :cond_2
    move v10, v0

    :goto_2
    if-eqz v10, :cond_3

    invoke-direct {p0, p1, v4, v3, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;III)Z

    move-result v10

    if-nez v10, :cond_3

    return v0

    :cond_3
    nop

    const/high16 v10, 0xff00000

    and-int/2addr v10, v7

    ushr-int/lit8 v10, v10, 0x14

    const/16 v11, 0x9

    if-eq v10, v11, :cond_c

    const/16 v11, 0x11

    if-eq v10, v11, :cond_c

    const/16 v8, 0x1b

    if-eq v10, v8, :cond_9

    const/16 v8, 0x3c

    if-eq v10, v8, :cond_8

    const/16 v8, 0x44

    if-eq v10, v8, :cond_8

    const/16 v6, 0x31

    if-eq v10, v6, :cond_9

    const/16 v6, 0x32

    if-eq v10, v6, :cond_4

    goto/16 :goto_7

    :cond_4
    nop

    iget-object v6, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    and-int/2addr v7, v9

    int-to-long v7, v7

    invoke-static {p1, v7, v8}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v7

    invoke-interface {v6, v7}, Lcom/google/android/gms/internal/measurement/zzgh;->zzb(Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Map;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_7

    invoke-direct {p0, v4}, Lcom/google/android/gms/internal/measurement/zzgs;->zzb(I)Ljava/lang/Object;

    move-result-object v4

    iget-object v7, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzs:Lcom/google/android/gms/internal/measurement/zzgh;

    invoke-interface {v7, v4}, Lcom/google/android/gms/internal/measurement/zzgh;->zzf(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzgf;

    move-result-object v4

    iget-object v4, v4, Lcom/google/android/gms/internal/measurement/zzgf;->zzc:Lcom/google/android/gms/internal/measurement/zzim;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/measurement/zzim;->zza()Lcom/google/android/gms/internal/measurement/zzip;

    move-result-object v4

    sget-object v7, Lcom/google/android/gms/internal/measurement/zzip;->zzi:Lcom/google/android/gms/internal/measurement/zzip;

    if-ne v4, v7, :cond_7

    const/4 v4, 0x0

    invoke-interface {v6}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_3
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_7

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    if-nez v4, :cond_5

    invoke-static {}, Lcom/google/android/gms/internal/measurement/zzgz;->zza()Lcom/google/android/gms/internal/measurement/zzgz;

    move-result-object v4

    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    invoke-virtual {v4, v8}, Lcom/google/android/gms/internal/measurement/zzgz;->zza(Ljava/lang/Class;)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v4

    :cond_5
    invoke-interface {v4, v7}, Lcom/google/android/gms/internal/measurement/zzhd;->zzd(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_6

    move v5, v0

    goto :goto_4

    :cond_6
    goto :goto_3

    :cond_7
    nop

    :goto_4
    if-nez v5, :cond_d

    return v0

    :cond_8
    invoke-direct {p0, p1, v6, v4}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;II)Z

    move-result v5

    if-eqz v5, :cond_d

    invoke-direct {p0, v4}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v4

    invoke-static {p1, v7, v4}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;ILcom/google/android/gms/internal/measurement/zzhd;)Z

    move-result v4

    if-nez v4, :cond_d

    return v0

    :cond_9
    nop

    nop

    and-int v6, v7, v9

    int-to-long v6, v6

    invoke-static {p1, v6, v7}, Lcom/google/android/gms/internal/measurement/zzib;->zzf(Ljava/lang/Object;J)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_b

    invoke-direct {p0, v4}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v4

    move v7, v0

    :goto_5
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v8

    if-ge v7, v8, :cond_b

    invoke-interface {v6, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    invoke-interface {v4, v8}, Lcom/google/android/gms/internal/measurement/zzhd;->zzd(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_a

    move v5, v0

    goto :goto_6

    :cond_a
    add-int/lit8 v7, v7, 0x1

    goto :goto_5

    :cond_b
    nop

    :goto_6
    if-nez v5, :cond_d

    return v0

    :cond_c
    invoke-direct {p0, p1, v4, v3, v8}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;III)Z

    move-result v5

    if-eqz v5, :cond_d

    invoke-direct {p0, v4}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(I)Lcom/google/android/gms/internal/measurement/zzhd;

    move-result-object v4

    invoke-static {p1, v7, v4}, Lcom/google/android/gms/internal/measurement/zzgs;->zza(Ljava/lang/Object;ILcom/google/android/gms/internal/measurement/zzhd;)Z

    move-result v4

    if-nez v4, :cond_d

    return v0

    :cond_d
    :goto_7
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_0

    :cond_e
    iget-boolean v1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzh:Z

    if-eqz v1, :cond_f

    iget-object v1, p0, Lcom/google/android/gms/internal/measurement/zzgs;->zzr:Lcom/google/android/gms/internal/measurement/zzes;

    invoke-virtual {v1, p1}, Lcom/google/android/gms/internal/measurement/zzes;->zza(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzew;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/android/gms/internal/measurement/zzew;->zzf()Z

    move-result p1

    if-nez p1, :cond_f

    return v0

    :cond_f
    return v5
.end method
