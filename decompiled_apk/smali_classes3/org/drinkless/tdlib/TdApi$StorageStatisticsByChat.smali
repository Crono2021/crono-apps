.class public Lorg/drinkless/tdlib/TdApi$StorageStatisticsByChat;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StorageStatisticsByChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x25dff623


# instance fields
.field public byFileType:[Lorg/drinkless/tdlib/TdApi$StorageStatisticsByFileType;

.field public chatId:J

.field public count:I

.field public size:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45558
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45559
    return-void
.end method

.method public constructor <init>(JJI[Lorg/drinkless/tdlib/TdApi$StorageStatisticsByFileType;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "storageStatisticsByFileTypeArr"    # [Lorg/drinkless/tdlib/TdApi$StorageStatisticsByFileType;

    .line 45546
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45547
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsByChat;->chatId:J

    .line 45548
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsByChat;->size:J

    .line 45549
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsByChat;->count:I

    .line 45550
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsByChat;->byFileType:[Lorg/drinkless/tdlib/TdApi$StorageStatisticsByFileType;

    .line 45551
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45555
    const v0, 0x25dff623

    return v0
.end method
