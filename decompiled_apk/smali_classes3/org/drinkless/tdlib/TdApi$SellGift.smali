.class public Lorg/drinkless/tdlib/TdApi$SellGift;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SellGift"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x11c7ac07


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public receivedGiftId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30768
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30769
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 30758
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30759
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SellGift;->businessConnectionId:Ljava/lang/String;

    .line 30760
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SellGift;->receivedGiftId:Ljava/lang/String;

    .line 30761
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30765
    const v0, -0x11c7ac07

    return v0
.end method
