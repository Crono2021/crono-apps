.class public Lorg/drinkless/tdlib/TdApi$ChatBoostSourceGiftCode;
.super Lorg/drinkless/tdlib/TdApi$ChatBoostSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBoostSourceGiftCode"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5dbed46


# instance fields
.field public giftCode:Ljava/lang/String;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23644
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatBoostSource;-><init>()V

    .line 23645
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 23634
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatBoostSource;-><init>()V

    .line 23635
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSourceGiftCode;->userId:J

    .line 23636
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostSourceGiftCode;->giftCode:Ljava/lang/String;

    .line 23637
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23641
    const v0, -0x5dbed46

    return v0
.end method
