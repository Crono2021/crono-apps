.class public Lorg/drinkless/tdlib/TdApi$DeviceTokenMicrosoftPushVoIP;
.super Lorg/drinkless/tdlib/TdApi$DeviceToken;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeviceTokenMicrosoftPushVoIP"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2ed35caf


# instance fields
.field public channelUri:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11454
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11455
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11445
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11446
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenMicrosoftPushVoIP;->channelUri:Ljava/lang/String;

    .line 11447
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11451
    const v0, -0x2ed35caf

    return v0
.end method
