.class public Lorg/drinkless/tdlib/TdApi$DeviceTokenApplePush;
.super Lorg/drinkless/tdlib/TdApi$DeviceToken;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeviceTokenApplePush"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x17196bc3


# instance fields
.field public deviceToken:Ljava/lang/String;

.field public isAppSandbox:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25224
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 25225
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 25214
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 25215
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenApplePush;->deviceToken:Ljava/lang/String;

    .line 25216
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenApplePush;->isAppSandbox:Z

    .line 25217
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25221
    const v0, 0x17196bc3

    return v0
.end method
