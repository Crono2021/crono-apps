.class public Lorg/drinkless/tdlib/TdApi$ReceivedGifts;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReceivedGifts"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x49bcde20


# instance fields
.field public areNotificationsEnabled:Z

.field public gifts:[Lorg/drinkless/tdlib/TdApi$ReceivedGift;

.field public nextOffset:Ljava/lang/String;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44838
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44839
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$ReceivedGift;ZLjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "receivedGiftArr"    # [Lorg/drinkless/tdlib/TdApi$ReceivedGift;
    .param p3, "z8"    # Z
    .param p4, "str"    # Ljava/lang/String;

    .line 44826
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44827
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ReceivedGifts;->totalCount:I

    .line 44828
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ReceivedGifts;->gifts:[Lorg/drinkless/tdlib/TdApi$ReceivedGift;

    .line 44829
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ReceivedGifts;->areNotificationsEnabled:Z

    .line 44830
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ReceivedGifts;->nextOffset:Ljava/lang/String;

    .line 44831
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44835
    const v0, 0x49bcde20    # 1547204.0f

    return v0
.end method
