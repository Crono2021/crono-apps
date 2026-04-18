.class public Lorg/drinkless/tdlib/TdApi$ChatBoostSourceGiveaway;
.super Lorg/drinkless/tdlib/TdApi$ChatBoostSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBoostSourceGiveaway"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7254949a


# instance fields
.field public giftCode:Ljava/lang/String;

.field public giveawayMessageId:J

.field public isUnclaimed:Z

.field public starCount:J

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46786
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatBoostSource;-><init>()V

    .line 46787
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;JJZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "j9"    # J
    .param p6, "j10"    # J
    .param p8, "z8"    # Z

    .line 46773
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatBoostSource;-><init>()V

    .line 46774
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSourceGiveaway;->userId:J

    .line 46775
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSourceGiveaway;->giftCode:Ljava/lang/String;

    .line 46776
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSourceGiveaway;->starCount:J

    .line 46777
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSourceGiveaway;->giveawayMessageId:J

    .line 46778
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSourceGiveaway;->isUnclaimed:Z

    .line 46779
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46783
    const v0, 0x7254949a

    return v0
.end method
