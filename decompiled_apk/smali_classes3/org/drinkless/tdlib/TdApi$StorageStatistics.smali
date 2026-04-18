.class public Lorg/drinkless/tdlib/TdApi$StorageStatistics;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StorageStatistics"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xcf2c615


# instance fields
.field public byChat:[Lorg/drinkless/tdlib/TdApi$StorageStatisticsByChat;

.field public count:I

.field public size:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40812
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40813
    return-void
.end method

.method public constructor <init>(JI[Lorg/drinkless/tdlib/TdApi$StorageStatisticsByChat;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "storageStatisticsByChatArr"    # [Lorg/drinkless/tdlib/TdApi$StorageStatisticsByChat;

    .line 40801
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40802
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StorageStatistics;->size:J

    .line 40803
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StorageStatistics;->count:I

    .line 40804
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$StorageStatistics;->byChat:[Lorg/drinkless/tdlib/TdApi$StorageStatisticsByChat;

    .line 40805
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40809
    const v0, 0xcf2c615

    return v0
.end method
