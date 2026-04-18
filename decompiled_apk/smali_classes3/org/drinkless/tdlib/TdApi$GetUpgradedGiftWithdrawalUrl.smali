.class public Lorg/drinkless/tdlib/TdApi$GetUpgradedGiftWithdrawalUrl;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetUpgradedGiftWithdrawalUrl"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2ebff1b4


# instance fields
.field public password:Ljava/lang/String;

.field public receivedGiftId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26784
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26785
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 26774
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26775
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetUpgradedGiftWithdrawalUrl;->receivedGiftId:Ljava/lang/String;

    .line 26776
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetUpgradedGiftWithdrawalUrl;->password:Ljava/lang/String;

    .line 26777
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26781
    const v0, -0x2ebff1b4

    return v0
.end method
