.class public Lorg/drinkless/tdlib/TdApi$StorageStatisticsFast;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StorageStatisticsFast"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x34bed79f


# instance fields
.field public databaseSize:J

.field public fileCount:I

.field public filesSize:J

.field public languagePackDatabaseSize:J

.field public logSize:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48918
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48919
    return-void
.end method

.method public constructor <init>(JIJJJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "j9"    # J
    .param p6, "j10"    # J
    .param p8, "j11"    # J

    .line 48905
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48906
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsFast;->filesSize:J

    .line 48907
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsFast;->fileCount:I

    .line 48908
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsFast;->databaseSize:J

    .line 48909
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsFast;->languagePackDatabaseSize:J

    .line 48910
    iput-wide p8, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsFast;->logSize:J

    .line 48911
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48915
    const v0, -0x34bed79f    # -1.2658785E7f

    return v0
.end method
