.class public Lorg/drinkless/tdlib/TdApi$ReportPhoneNumberCodeMissing;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportPhoneNumberCodeMissing"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x355b4aad


# instance fields
.field public mobileNetworkCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18780
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18781
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 18771
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18772
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReportPhoneNumberCodeMissing;->mobileNetworkCode:Ljava/lang/String;

    .line 18773
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18777
    const v0, -0x355b4aad    # -5397161.5f

    return v0
.end method
