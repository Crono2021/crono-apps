.class public Lorg/drinkless/tdlib/TdApi$DeviceTokenApplePushVoIP;
.super Lorg/drinkless/tdlib/TdApi$DeviceToken;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeviceTokenApplePushVoIP"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2ff045e9


# instance fields
.field public deviceToken:Ljava/lang/String;

.field public encrypt:Z

.field public isAppSandbox:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36652
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 36653
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z

    .line 36641
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 36642
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenApplePushVoIP;->deviceToken:Ljava/lang/String;

    .line 36643
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenApplePushVoIP;->isAppSandbox:Z

    .line 36644
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenApplePushVoIP;->encrypt:Z

    .line 36645
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36649
    const v0, 0x2ff045e9

    return v0
.end method
