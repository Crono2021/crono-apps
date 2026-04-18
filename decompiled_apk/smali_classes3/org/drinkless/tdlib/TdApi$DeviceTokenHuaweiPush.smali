.class public Lorg/drinkless/tdlib/TdApi$DeviceTokenHuaweiPush;
.super Lorg/drinkless/tdlib/TdApi$DeviceToken;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeviceTokenHuaweiPush"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x768f4e26


# instance fields
.field public encrypt:Z

.field public token:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25264
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 25265
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 25254
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 25255
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenHuaweiPush;->token:Ljava/lang/String;

    .line 25256
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenHuaweiPush;->encrypt:Z

    .line 25257
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25261
    const v0, 0x768f4e26

    return v0
.end method
